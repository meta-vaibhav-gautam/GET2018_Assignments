import java.util.Scanner;

public class AreaMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double width=0;
		double height=0;
		double radius=0;
		System.out.println("Enter your choice\n1.Triangle Area  2.Rectangle Area  3.Square Area  4.Circle Area");
		int Choice=sc.nextInt();
		Area obj=new Area();
		switch(Choice){
			case 1:
				try
				{
					System.out.println("Enter width:");
					width=sc.nextDouble();
					System.out.println("Enter height:");
					height=sc.nextDouble();
					System.out.println("Area of triangle: "+obj.triangleArea(width, height));
				}
				catch(Exception e)
				{
					System.out.println("Enter a valid input !");
				}
				break;
			case 2:
				try
				{
					System.out.println("Enter width:");
					width=sc.nextDouble();
					System.out.println("Enter height:");
					height=sc.nextDouble();
					System.out.println("Area of Rectangle: "+obj.rectangleArea(width, height));
				}
				catch(Exception e)
				{
					System.out.println("Enter a valid input !");
				}
				break;
			case 3:
				try
				{
					System.out.println("Enter width:");
					width=sc.nextDouble();
					System.out.println("Area of Square: "+obj.squareArea(width));
				}
				catch(Exception e)
				{
					System.out.println("Enter a valid input !");
				}
				break;
			case 4:
				try
				{
					System.out.println("Enter radius:");
					radius=sc.nextDouble();
					System.out.println("Area of circle: "+obj.cicleArea(radius));
				}
				catch(Exception e)
				{
					System.out.println("Enter a valid input !");
				}
				break;
			default:
				System.out.println("Incorrect choice...");
		}
		sc.close();
	}

}
