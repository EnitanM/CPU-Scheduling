import java.util.List;
/**
 * @author Greg Gagne - March 2016
 * @author Eni Meduteni November 2024
 * @class Operating Systems
 * @assignment Project 2 - Phase 1
 * */
public class FCFS implements Algorithm{
    List<Task> queue;
    int cpuTime = 0;
    public FCFS(List<Task> queue){
        this.queue = queue;
    }
    //Implements the schedule() method from the Algorithm interface to mimic the FCFS algorithm
    @Override
    public void schedule() throws UnsupportedOperationException{
        System.out.println("Current CPU Time = " + cpuTime + " seconds");
        try {
            System.out.println("First-Come First-Served Algorithm Selected \n");
            for (Task task : queue) {
                CPU.run(task, task.getBurst());
                //this simulates the process in its critical section
                Thread.sleep(task.getBurst()*100);
                cpuTime = cpuTime + task.getBurst();
                System.out.println("Task " + task.getName() + " finished at " + cpuTime + " seconds \n");
            }
            
        } catch (Exception e) {
            throw new UnsupportedOperationException("System could not successfully schedule processes");
        }
        
    }
    /* Unimplemented method.
     * The implementation in the schedule() method does not require a pickNextTask() method to iterate through the queue. This was achieved with the foreach loop.
     */
    @Override
    public Task pickNextTask() {
        throw new UnsupportedOperationException("Unimplemented method 'pickNextTask'");
    }

}
