package BowlerOrder;

/*
 * class containing attributes of a bowler
 * created on August 07, 2018
 */
public class Bowler {
	private String bowlerName;
	private int numberOfBalls;
	
	public Bowler (String bowlerName, int numberOfBalls) {
		this.bowlerName = bowlerName;
		this.numberOfBalls = numberOfBalls;
	}

	public String getBowlerName() {
		return bowlerName;
	}

	public int getNumberOfBalls() {
		return numberOfBalls;
	}
	
	
}
