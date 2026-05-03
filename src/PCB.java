public class PCB {
    public enum ProcessState{
        NEW, READY, RUNNING, WAITING, TERMINATED
    }

    private int pID;
    private int totalBurstTime;
    private int remainingTime;
    private ProcessState processState;
}
