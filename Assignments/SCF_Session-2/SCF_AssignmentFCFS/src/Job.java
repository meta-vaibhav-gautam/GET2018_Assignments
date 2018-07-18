/*
 Job class shows the particular job with the following attributes
 */
public class Job {
	public int arrivalTime;
	public int burstTime;
	public int waitingTime;
	public int completionTime;
	public int turnaroundTime;
	
	public Job(int arrivalTime,int burstTime, int waitingTime, int completionTime, int turnaroundTime) //Parameterized constructor to initialize job attributes
	{
		this.arrivalTime=arrivalTime;
		this.burstTime=burstTime;
		this.completionTime=completionTime;
		this.completionTime=completionTime;
		this.turnaroundTime=turnaroundTime;
	}
}
