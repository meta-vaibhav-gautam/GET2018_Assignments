import java.util.Scanner;
/*
 * main class containing main() method*/
public class ImplementJobScheduler {
	public static void main(String args[]){
		System.out.println("Enter the no. of jobs:");
		Scanner sc=new Scanner(System.in); 
		int numberOfJobs=sc.nextInt(); //Number of jobs to be scheduled
		int arrivalAndBurstTimes[][]=new int[numberOfJobs][2]; //2-D Array containing aarrival and burst time
		System.out.println("Enter the arrival time and burst time :");
		for(int i=0;i<numberOfJobs;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(j==1)
				{
					System.out.println("enter burst time of job "+(i+1));
					arrivalAndBurstTimes[i][j]=sc.nextInt();
				}
				else
				{
					System.out.println("enter arrival time of job "+(i+1));
					arrivalAndBurstTimes[i][j]=sc.nextInt();
				}
			}
		}
		JobScheduler obj=new JobScheduler();
		obj.scheduleJobsFCFS(numberOfJobs, arrivalAndBurstTimes); //invoking the method in JobScheduler class
		sc.close();
	}
}
