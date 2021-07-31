
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Directory class contains the structure of the directory and it's sub
 * directory
 */
public class Directory {
	private String name;
	private List<Directory> subDirectories;
	private String timestamp;

	/**
	 * Constructor of directory
	 * 
	 * @param name of the directory
	 */
	public Directory(String name) {
		this.name = name;
		subDirectories = new ArrayList<>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		timestamp = LocalDateTime.now().format(format);
	}

	/**
	 * Add sub directory to this directory
	 * 
	 * @param subDirectory to be added
	 */
	public void addSubDirectory(Directory subDirectory) {
		this.subDirectories.add(subDirectory);
	}

	/**
	 * Check if directory with name is a sub directory of this directory or not
	 * 
	 * @param name
	 * @return return object of directory if it is present, null if not present
	 */
	public Directory getSubDirectory(String name) {
		for (int i = 0; i < getSubDirectoryCount(); i++) {
			if (name.equals(subDirectories.get(i).getName()))
				return subDirectories.get(i);
		}
		return null;
	}

	/**
	 * Get all sub directories as array of directory of this directory
	 * 
	 * @return array of sub directories
	 */
	public Directory[] getAllSubDirectories() {
		Object[] obj = subDirectories.toArray();
		Directory[] dir = new Directory[obj.length];
		for (int i = 0; i < getSubDirectoryCount(); i++) {
			dir[i] = (Directory) obj[i];
		}
		return dir;
	}

	public String getName() {
		return name;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public int getSubDirectoryCount() {
		return subDirectories.size();
	}

	/**
	 * Print directories and sub directories - helper method of tree command
	 * 
	 * @param n
	 */
	public void printDirectories(int n) {
		System.out.println(name);
		for (int i = 0; i < getSubDirectoryCount(); i++) {
			format(n);
			subDirectories.get(i).printDirectories(n + 1);
		}
	}

	/**
	 * Helper method to print the tree structure with proper formatting
	 * 
	 * @param times helper variable that stores how many levels the directory is
	 *              nested
	 */
	private void format(int times) {
		for (int i = 0; i < times; i++)
			System.out.print("    ");

		System.out.print("\u2514\u2500\u2500");
	
	}
}
