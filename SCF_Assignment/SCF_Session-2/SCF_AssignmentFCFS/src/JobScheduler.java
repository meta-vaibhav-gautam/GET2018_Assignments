import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Jobscheduler schedules the job in FCFS fashion
 * Takes number of jobs and 2-D array consisting of arrival and burst time as parameters
*/
public class JobScheduler {
	public void scheduleJobsFCFS(int numberOfJobs,int arrivalAndBurstTimes[][])
	{
		
		double MaximumWaitingTime=0;
		double totalWaiting=0;
		List<Job> jobQueue=new LinkedList<Job>(); // A queue containing all the job objects
		for(int i=0;i<numberOfJobs;i++)
		{
			jobQueue.add(i,(new Job(arrivalAndBurstTimes[i][0], arrivalAndBurstTimes[i][1],0,0,0))); //job (arrival,burst,waiting,completion,turnaround)
			
		}
		Job previousJob=jobQueue.get(0);
		
		for(Job jobs:jobQueue)
		{
			jobs.waitingTime=getWaitingTime(jobs, previousJob);
			
			jobs.completionTime= getCompletionTime(jobs);
			jobs.turnaroundTime= getTurnaroundTime(jobs);
			previousJob=jobs;
		}
		System.out.println("Arrival\t\tburst\t\tcompletion\twaiting\t  turnaround");
		for(Job jobs:jobQueue)
		{
			
			System.out.println(jobs.arrivalTime+"\t\t"+jobs.burstTime+"\t\t"+jobs.completionTime+"\t\t"+jobs.waitingTime+"\t\t"+jobs.turnaroundTime);
		}
		
		System.out.println("Average Waiting Time: "+getAverageWaitingTime(jobQueue, numberOfJobs));
		System.out.println("Maximum Waiting Time: "+getMaxWaitingTime(jobQueue));
		
	}
	
/*
	 * getWaitingTime method calculates the waiting time of job
	 * takes Job objects as parameter
	 * return an integer value as waiting time
 */
	private int getWaitingTime(Job jobs,Job previousJob)
	{
		if(jobs.arrivalTime<previousJob.completionTime)
		{
			jobs.waitingTime=previousJob.completionTime-jobs.arrivalTime;
		}
		else
		{
			jobs.waitingTime=0;
		}
		return jobs.waitingTime;
	}
		
/*
	 * getCompletionTime method calculates the completion time of job
	 * takes Job objects as parameter
	 * return an integer value as completion time
 */	
	private int getCompletionTime(Job jobs)
	{
		return jobs.arrivalTime+jobs.waitingTime+jobs.burstTime;
	}
	
/*
	 * getTurnaroundTime method calculates the turnaround time of job
	 * takes Job objects as parameter
	 * return an integer value as turnaround time
 */	
	private int getTurnaroundTime(Job jobs)
	{
		return jobs.completionTime-jobs.arrivalTime;
	}
	
/*
	 * getAverageWaitingTime method calculates the Average waiting time of job
	 * takes list of jobs and number of jobs as parameter
	 * return an integer value as average waiting time
 */	
	private double getAverageWaitingTime(List<Job>jobList,int numberOfJobs)
	{
		double averageWaitingTime=0;
		double totalWaitingTime=0;
		for(Job jobs:jobList)
		{
			totalWaitingTime+=jobs.waitingTime;
		}
		averageWaitingTime=totalWaitingTime/numberOfJobs;
		return averageWaitingTime;
	}
	
/*
	 * getMaxWaitingTime method calculates the maximum waiting time in the list of jobs
	 * takes list of jobs as parameter
	 * return an integer value as average waiting time
 */	
	
	private int getMaxWaitingTime(List<Job> jobList)
	{
		int max=jobList.get(0).waitingTime;
		for(Job jobs:jobList)
		{
			if(jobs.waitingTime>max)
			{
				max=jobs.waitingTime;
			}
			else
			{
				continue;
			}
		}
		return max;
	}
}

