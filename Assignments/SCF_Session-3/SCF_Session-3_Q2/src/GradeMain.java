import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of students: ");
		int students=sc.nextInt();
		List<Integer> grades=new ArrayList<Integer>(); 
		System.out.println("Enter grades: ");
		try
		{
			for(int i=0;i<students;i++)
			{
				int marks=sc.nextInt();
				if(marks>=0) //preventing negative numbers to be added into grades list
				{
					grades.add(i, marks);
				}
				else
				{
					grades.add(i,0);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Some error in input !");
		}
		
		System.out.println("Enter your choice\n1.find Average  2.find maximum marks  3.find minimum marks  4.find passed student percentage");
		int Choice=sc.nextInt();
		Grade obj=new Grade();
		switch(Choice){
			case 1:
				System.out.printf("Average marks:  %.2f",obj.findAverage(grades));
				break;
			case 2:
				System.out.println("Maximum marks: "+obj.getMaxMarks(grades));
				break;
			case 3:
				System.out.println("Minimum marks: "+obj.getMinMarks(grades));
				break;
			case 4:
				System.out.printf("Percentage of Passed students: %.2f",obj.passedStudentPercent(grades));
				break;
			default:
				System.out.println("Incorrect choice...");
		}
		sc.close();
	}

}
