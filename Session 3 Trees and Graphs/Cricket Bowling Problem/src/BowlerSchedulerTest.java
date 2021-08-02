import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlerSchedulerTest {

	public static BowlerScheduler bowlerScheduler;

	@Test
	public void TestAssertionErrorIfBowlersAreZero() {
		Assertions.assertThrows(AssertionError.class, () -> {
			new BowlerScheduler(new Bowler[] {}, 15);
		});
	}

	@Test
	public void TestOneBallPlayed() {
		Bowler[] bowlers = new Bowler[] { new Bowler("B1", 2), new Bowler("B2", 2), new Bowler("B3", 4) };

		bowlerScheduler = new BowlerScheduler(bowlers, 1);
		String[] expectedOutput = new String[] { "B3" };

		assertArrayEquals(expectedOutput, bowlerScheduler.getBowlingOrder());
	}

	@Test
	public void TestOnValidInputMultipleBowlers() {
		Bowler[] bowlers = new Bowler[] { new Bowler("B1", 2), new Bowler("B2", 2), new Bowler("B3", 4),
				new Bowler("B4", 1), new Bowler("B5", 3), new Bowler("B6", 3) };

		bowlerScheduler = new BowlerScheduler(bowlers, 15);
		String[] expectedOutput = new String[] { "B3", "B5", "B3", "B6", "B3", "B6", "B1", "B2", "B5", "B2", "B5", "B3",
				"B4", "B1", "B6" };

		assertArrayEquals(expectedOutput, bowlerScheduler.getBowlingOrder());
	}

	@Test
	public void TestOnOneBowler() {
		String[] expectedOutput = new String[] { "B1", "B1", "B1", "B1" };

		bowlerScheduler = new BowlerScheduler(new Bowler[] { new Bowler("B1", 4) }, 4);
		assertArrayEquals(expectedOutput, bowlerScheduler.getBowlingOrder());
	}

	@Test
	public void TestWhenBallsPlayZero() {
		Bowler[] bowlers = new Bowler[] { new Bowler("B1", 2), new Bowler("B2", 3) };
		String[] expectedOutput = new String[] {};

		bowlerScheduler = new BowlerScheduler(bowlers, 0);
		assertArrayEquals(expectedOutput, bowlerScheduler.getBowlingOrder());
	}

	@Test
	public void TestAssertionErrorIfBallsPlayedNegative() {
		Assertions.assertThrows(AssertionError.class, () -> {
			new BowlerScheduler(new Bowler[] {}, -1);
		});
	}

}
