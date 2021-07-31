
public class Bowler implements Comparable<Bowler>{
	private String name;
	private int ballsLeft;
	
	public Bowler(String name, int ballsLeft) {
		this.name = name;
		this.ballsLeft = ballsLeft;
	}

	public String getName() {
		return name;
	}

	public int getBallsLeft() {
		return ballsLeft;
	}
	
	public void setBallsLeft(int updatedBalls) {
		ballsLeft = updatedBalls;
	}

	@Override
	public int compareTo(Bowler other) {
		if (ballsLeft > other.ballsLeft)
			return 1;
		else if (ballsLeft < other.ballsLeft)
			return -1;
		else
			return 0;
	}
}
