package BowlerOrder;

import java.util.Scanner;

/*
 * class containing main method
 */
public class BowlerOrderMain {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Bowler[] bowlerList;
		System.out.println("Enter the number of balls Virat will play:");
		int numberOfBalls = scanner.nextInt();
		System.out.println("Enter the number of bowlers we have: ");
		int numberOfBowlers = scanner.nextInt();
		bowlerList = new Bowler[numberOfBowlers];
		for(int i=0; i<numberOfBowlers;i++) {
			System.out.println("Enter the name of the bowler: ");
			String nameOfTheBowler = scanner.next();
			System.out.println("Enter the balls to be thrown by the bowler:");
			int balls = scanner.nextInt();
			bowlerList[i] = new Bowler(nameOfTheBowler, balls);
		}
		
		System.out.println("Bowling order as decided will be:");
		BowlingOrderDecision object = new BowlingOrderDecision(numberOfBalls, bowlerList);
		
		Bowler[] decidedBowlers = object.getOrderOfBowler();
		if(decidedBowlers!=null) {
			for(int i=0; i<decidedBowlers.length;i++) {
				System.out.println(decidedBowlers[i].getBowlerName());
			}
		} else {
			System.out.println("Unable to find the order !");
		
		}
	}
}
