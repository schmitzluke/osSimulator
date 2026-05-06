/**
 * Represents a Process Control Block in an Operating System Simulation.
 * It stores process metadata and handles burst time prediction using exponential smoothing.
 * */
public class PCB {
    /** Represents the state in which the process is in*/
    public enum ProcessState{
        NEW, READY, RUNNING, WAITING, TERMINATED
    }

    /** The unique Identifier of a PCB*/
    private int pID;

    /** The total time the process needs to calculate*/
    private int totalBurstTime;

    /** The remaining time the process needs to calculate*/
    private int remainingTime;

    /** The state in which the process is in*/
    private ProcessState processState;

    /** The predicted burst time of a process*/
    private double predictBurst;

    /** The weight constant for exponential smoothing*/
    private static final double  ALPHA = 0.5;

    /** The next unique PCB ID*/
    private static int nextPid = 1;

    /**
     * Initializes a new PCB with total burst time
     *
     * @param totalBurstTime The total time required for the process
     * */
    public PCB(int totalBurstTime){
        this.pID = nextPid;
        nextPid++;
        this.totalBurstTime = totalBurstTime;
        this.remainingTime = totalBurstTime;
        this.processState = ProcessState.NEW;
        this.predictBurst = 10.0;
    }

    /**
     * Updates the predicted burst time based on the actual time spent on the CPU.
     * Uses exponential smoothing formula: tau_{n+1} = alpha * t_n + (1 - alpha) * tau_n.
     *
     * @param actualBurst actual time spent on CPU
     * */
    public void updatePrediction(int actualBurst){
        this.predictBurst = ALPHA * actualBurst + (1 - ALPHA) * this.predictBurst;
    }

    public double getPredictBurst(){
        return this.predictBurst;
    }

    /**
     * String representation of all members
     * */
    @Override
    public String toString() {
        return "pID: " + this.pID + "\n" +
                "totalBurstTime: " + this.totalBurstTime + "\n" +
                "remainingTime: " + this.remainingTime + "\n" +
                "processState: " + this.processState + "\n" +
                "predictBurst: " + this.predictBurst + "\n";
    }
}