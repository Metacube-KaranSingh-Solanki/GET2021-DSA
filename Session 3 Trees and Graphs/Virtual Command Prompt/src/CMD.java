import java.util.Scanner;

public class CMD {
	private Directory root;
	Stack<Directory> traversalStack, findStack;

	public static void main(String[] args) {
		CMD cmd = new CMD();
		cmd.initCommandPromt();
	}

	/** Constructor to initialize the data members and add a root directory */
	public CMD() {
		root = new Directory("root");
		traversalStack = new Stack<>(20);
		traversalStack.push(root);
		findStack = new Stack<>(20);
	}

	/**
	 * Change the directory to sub directory of this directory specified by name
	 * @param name name of the directory
	 * @return true if directory exists, false if not
	 */
	public boolean moveToSubDirectory(String name) {
		Directory subDirectory = getPWD().getSubDirectory(name);
		if (subDirectory == null)
			return false;
		else {
			traversalStack.push(subDirectory);
			return true;
		}
	}

	/**
	 * Moving from present directory to the parent directory
	 * @return true if parent directory exists, false if it is not in the case of
	 *         root directory
	 */
	public boolean moveToParentDirectory() {
		if (getPWD() == root)
			return false;
		traversalStack.pop();
		return true;
	}

	/**
	 * Get present working directory
	 * @return present working directory object
	 */
	public Directory getPWD() {
		return traversalStack.peek();
	}

	/**
	 * Initialize the command prompt
	 */
	public void initCommandPromt() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ::::::::::::::::::: COMMANDPROMT ::::::::::::::::::: ");
		String input = "";
		while (true) {
			System.out.print(getPath(traversalStack) + ">");
			input = sc.nextLine();
			processCommand(input.trim().toLowerCase());
		}
	}

	/**
	 * Process the input command from the user
	 * @param command string input from the console
	 */
	private void processCommand(String command) {
		String[] inputCommand = command.split(" ");
		switch (inputCommand[0]) {
		case "cd":
			if (inputCommand.length == 1) {
				System.out.println(getPath(traversalStack));
			} else {
				changeDirectory(inputCommand[1]);
			}
			break;
		case "bk":
			moveToParentDirectory();
			break;
		case "mkdir":
			if (inputCommand.length > 1) {
				if (getPWD().getSubDirectory(inputCommand[1]) == null)
					getPWD().addSubDirectory(new Directory(inputCommand[1]));
				else
					System.err.println("Directory with this name already exists.");
			} else
				System.err.println("Directory name missing");
			break;
		case "ls":
			Directory[] dirs = getPWD().getAllSubDirectories();
			for (int i = 0; i < getPWD().getSubDirectoryCount(); i++) {
				Directory dir = dirs[i];
				System.out.print(dir.getTimestamp() + "\t");
				System.out.println(dir.getName());
			}
			System.out.println(getPWD().getSubDirectoryCount() + " Folders(s)");
			break;
		case "find":
			if (inputCommand.length > 1) {
				find(getPWD(), inputCommand[1]);
			} else
				System.err.println("Please specify the query also.");
			break;
		case "tree":
			root.printDirectories(0);
			break;
		case "exit":
			System.out.println("EXIT..!");
			System.exit(0);
			break;
		case "":
			break;
		default:
			System.err.println("Invalid command");
		}

	}

	/**
	 * The case of switch where command is cd
	 * @param inputDirectory
	 */
	private void changeDirectory(String inputDirectory) {
		if ("..".equals(inputDirectory)) {
			moveToParentDirectory();
		} else if (".".equals(inputDirectory)) {
			traversalStack.emptyStack();
			traversalStack.push(root);
		} else if (getPWD().getSubDirectory(inputDirectory) != null) {
			moveToSubDirectory(inputDirectory);
		} else {
			System.err.println("Directory not found.");
		}
	}

	/**
	 * Gets the full path of the directory specified by the stack
	 * @param stack contains the information about current directory and it's parent
	 	         directories in hierarchy wise manner
	 * @return the path as a string
	 */
	private String getPath(Stack<Directory> stack) {
		StringBuilder path = new StringBuilder();
		Object[] dirs = stack.getStackAsArray();
		for (int i = 0; i < stack.getStackSize(); i++) {
			Directory dir = (Directory) dirs[i];
			if (i == 0) {
				path.append(dir.getName());
				continue;
			}
			path.append("\\" + dir.getName());
		}

		return path.toString();
	}

	/**
	 * Find the directory with given name or contains the similar word
	 * 
	 * @param dir   present directory
	 * @param query directory that need to searched
	 */
	private void find(Directory dir, String query) {
		if (dir.getName().contains(query) && dir != getPWD()) {
			System.out.println(getPath(findStack));
		}
		for (int i = 0; i < dir.getSubDirectoryCount(); i++) {
			findStack.push(dir.getAllSubDirectories()[i]);
			find(dir.getAllSubDirectories()[i], query);
			findStack.pop();
		}
	}
}
