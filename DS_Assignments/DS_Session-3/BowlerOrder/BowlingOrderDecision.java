package BowlerOrder;

import java.util.Arrays;

/*
 * class containing bowling order decision related methods
 * created on August 07, 2018
 */
public class BowlingOrderDecision {
	private int numberOfBalls = 0;
	private Bowler[] bowlersList ;
	public BowlingOrderDecision(int numberOfBalls, Bowler[] bowlersList) {
		this.numberOfBalls = numberOfBalls;
		this.bowlersList = bowlersList;
	}
	
	/*
	 * method to find order of bowlers
	 * @return an array consisiting order of bowlers
	 */
	public Bowler[] getOrderOfBowler() {
		Bowler [] orderOfBowlers;
		int index=0;
		sortBowlerList();
		int totalBalls = 0,listIndex=0;
		while (totalBalls < numberOfBalls && index!=bowlersList.length) {
			totalBalls += bowlersList[index++].getNumberOfBalls();
		}
		if(index == bowlersList.length && totalBalls < numberOfBalls) {
			return null;
		}
		orderOfBowlers = new Bowler[index];
		for(int i=0; i<index ;i++) {
			orderOfBowlers[i]=bowlersList[i];
		}
		return orderOfBowlers;
	}
	
	/*
	 * method sort the bowlerList in descending order on the basis of number of balls
	 */
	private void sortBowlerList() {
		for(int i=0;i<bowlersList.length;i++) {
			for(int j=0;j<((bowlersList.length-1)-i);j++){
				if(bowlersList[j].getNumberOfBalls() < bowlersList[j+1].getNumberOfBalls()) {
					Bowler temp = bowlersList[j];
					bowlersList[j]=bowlersList[j+1];
					bowlersList[j+1]=temp;
				}
			}
		}
	}
	
}
