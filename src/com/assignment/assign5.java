package com.assignment;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class GantChart {

    public ArrayList<Integer> processIds=new ArrayList<>();
    public ArrayList<Integer> exeTimes=new ArrayList<>();

    public void printIds(){
        for(Integer id:processIds)
            System.out.print(" P"+id+" |");
    }

    public void printExTimes(){
        for(Integer time:exeTimes){
            if(time<10)
                System.out.print("    "+time);
            else
                System.out.print("   "+time);
        }}




}
class Process {
    private int processId;
    private int arrivalTime;
    private int burstTime;
    private int remainingBurstTime;
    private int completedTime;
    private int turnaroundTime;
    private int waitingTime;
    private boolean isScheduled;

    public Process(int processId, int arrivalTime, int burstTime) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime;

        this.isScheduled = false;
    }


    public void setRemainingBurstTime(int remainingBurstTime) {
        this.remainingBurstTime = remainingBurstTime;

        if(this.remainingBurstTime == 0)
            setIsScheduled(true);
    }

    public void setCompletedTime(int completedTime) {
        this.completedTime = completedTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void setIsScheduled(boolean isScheduled) {
        this.isScheduled = isScheduled;
    }

    public int getArrivalTime(){
        return arrivalTime;
    }

    public int getBurstTime(){
        return burstTime;
    }

    public int getRemainingBurstTime(){
        return remainingBurstTime;
    }

    public int getCompletedTime(){
        return completedTime;
    }

    public int getTurnaroundTime(){
        return turnaroundTime;
    }

    public int getWaitingTime(){
        return waitingTime;
    }

    public int getProcessId(){
        return processId;
    }

    public boolean isScheduled(){
        return isScheduled;
    }
}

class RR{
    int timer =0;
    // The list of processes to be scheduled
    public ArrayList<Process> processes;
    public ArrayList<Process>  tempList;
    public GantChart chart=new GantChart();

    // the quantum time - which indicates the maximum allowable time a process can run once it is scheduled
    int tq;

    // keeps track of which process should be executed next
    public Queue<Process> schedulingQueue;
    public int time;
    public  Process lastExecutedProcess;
    public boolean hasLeftFlag=true;

    // Class constructor
    public RR(ArrayList<Process> processes, int tq) {
        schedulingQueue = new LinkedList<Process>();
        lastExecutedProcess=null;

        this.processes = processes;

        this.tq = tq;
        this.processes=processes;
        tempList=new ArrayList<>(processes);
        tempList.sort((p1, p2) -> p1.getArrivalTime() - p2.getArrivalTime());

        this.time=0;
    }

    public void run() {
        /*
         * This is where you put your code
         * hints:
         * 1. do not forget to sort the processes by arrival time
         * 2. think about CPU idle times
         */
        timer++;

        while(!tempList.isEmpty() || !schedulingQueue.isEmpty() ||hasLeftFlag ){
            //selects the processes according to their arrival time and put them into the queue
            putToScheduleQ();
            //removes them from temproray list
            removeFromList();
            //checking if last executed process finished otherwise adds it to the queue again
            if(lastExecutedProcess!=null){
                if(!lastExecutedProcess.isScheduled()){
                    schedulingQueue.add(lastExecutedProcess);
                }
            }
            //checks if there is a process to execute or cpu has to wait for a process to come
            if(schedulingQueue.isEmpty()){
                time=tempList.get(0).getArrivalTime();//idle time

            }else{
                executeTheProcess();
            }

        }
        //sorting for the test case
        processes.sort((p1,p2)->p1.getArrivalTime()-p2.getArrivalTime());
        printProcesses();
        printGanttChart();
    }

    public void printProcesses(){

        System.out.println("Table FORM");
        for(Process process:processes){
            System.out.println("Id "+process.getProcessId()+" CT "+process.getCompletedTime()+" TAT "+process.getTurnaroundTime()+" WT "+process.getWaitingTime());
        }
    }

    public void printGanttChart(){
        // TODO Print the demonstration of the scheduling algorithm using Gantt Chart
        System.out.println("\nGantt Chart");
        chart.printIds();
        System.out.println("");
        chart.printExTimes();
        System.out.println("");
    }


    public void putToScheduleQ(){
        for(Process process:tempList){
            if(process.getArrivalTime()<=time && process.getBurstTime()>=process.getRemainingBurstTime()){
                schedulingQueue.add(process);
            }
        }


    }

    public void removeFromList(){

        tempList.removeIf(process->process.getArrivalTime()<=time);
    }

    public void executeTheProcess(){

        Process process=schedulingQueue.remove();
        if(process.getRemainingBurstTime()>tq){
            process.setRemainingBurstTime(process.getRemainingBurstTime()-tq);
            time+=tq;
            chart.processIds.add(process.getProcessId());
            chart.exeTimes.add(time);

        }else{
            if(process.getRemainingBurstTime()<tq){
                time+=process.getRemainingBurstTime();
            }else{
                time+=tq;
            }
            chart.processIds.add(process.getProcessId());
            chart.exeTimes.add(time);
            process.setRemainingBurstTime(0);

            process.setCompletedTime(time);
            process.setTurnaroundTime(time-process.getArrivalTime());
            process.setWaitingTime(process.getTurnaroundTime()-process.getBurstTime());


        }

        lastExecutedProcess=process;
        hasLeftFlag=!process.isScheduled();
    }

}
public class assign5 {
    public static void main(String[] args) {
        ArrayList<Process> listOfProcesses = new ArrayList<Process>();
        //list of processes to be scheduled
        //the first method parameter is the process id
        //the second method parameter is the arrival time
        //the third method parameter is the burst time
        System.out.println("Enter the process allocation time:");
        Scanner sc = new Scanner(System.in);
        int tq=sc.nextInt();
        System.out.println("Enter the set of jobs");
        Scanner sc1 = new Scanner(System.in);
        int n=sc1.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("enter process ID, Arrival_time, Execution_time");
            Scanner sc2=new Scanner(System.in);
            int l=Integer.parseInt(sc2.next());
            int m=Integer.parseInt(sc2.next());
            int k=Integer.parseInt(sc2.next());
            listOfProcesses.add(new Process(l, m, k));
        }



        RR scheduler = new RR(listOfProcesses, tq);
        scheduler.run();
    }
}
