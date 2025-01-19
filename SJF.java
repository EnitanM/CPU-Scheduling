import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * @author Greg Gagne - March 2016
 * @author Eni Meduteni November 2024
 * @class Operating Systems
 * @assignment Project 2 - Phase 1
 * */
public class SJF implements Algorithm{
    List<Task> queue;
    int cpuTime = 0;
    public SJF(List<Task> queue){
        this.queue = queue;
    }
    //Implements the schedule() method from the Algorithm interface to mimic the SJF algorithm
    @Override
    public void schedule() throws UnsupportedOperationException{
        System.out.println("Current CPU Time = " + cpuTime + " seconds");
        try {
            System.out.println("Shortest Job First Algorithm Selected. Also known as the Shortest-next-CPU-burst Algorithm\n");
            //Sort the queue based on their burst length in ascending order. Tasks of the same burst length maintain their position in the queue
            Collections.sort(queue, new Comparator<Task>() {
                @Override
                public int compare(Task task1, Task task2) {
                    //compare tasks by their burst length
                    return Integer.valueOf(task1.getBurst()).compareTo(task2.getBurst());
                }
            });
            //Allocate resources to each task in the sorted order
            for (Task task : queue) {
                CPU.run(task, task.getBurst());
                Thread.sleep(task.getBurst()*100);
                cpuTime = cpuTime + task.getBurst();
                System.out.println("Task " + task.getName() + " finished at " + cpuTime + " seconds \n");
            }
        } catch (Exception e) {
            //error message if CPU scheduler encounters an error
            throw new UnsupportedOperationException("Scheduler could not successfully schedule processes");
        }
        
    }

    /* Unimplemented method.
     * The project example in the textbook provides an interface with the pickNextTask() method, but it is not used in this project.
     * The implementation in the schedule() method does not require a pickNextTask() method to iterate through the queue. This was achieved with the foreach loop.
     */
    @Override
    public Task pickNextTask() {
        throw new UnsupportedOperationException("Unimplemented method 'pickNextTask'");
    }

}
