/**
 * @author Greg Gagne - March 2016
 * @author Eni Meduteni November 2024
 * @class Operating Systems
 * @assignment Project 2 - Phase 1
 * Driver.java
 * 
 * Demonstrates different scheduling algorithms.
 * 
 * Usage:
 *  
 *  java Driver.java <scheduling algorithm's acronym> <file name including extension>
 *
 * where 
 *  file name is schedule of tasks
 *
 *  algorithms = [FCFS (First-Come First-Served), SJF (Shortest Job First)]
 */
  
import java.util.*;
import java.io.*;

public class CpuDriver
{
    public static void main(String[] args) throws IOException {
        //This checks to make sure the user has provided the necessary amount of parameters in the terminal
        if (args.length != 2) {
            System.err.println("Usage: java Driver.java <scheduling algorithm's acronym> <file name including extension>");
            System.exit(0);
        }

        BufferedReader inFile = new BufferedReader(new FileReader(args[1]));

        String schedule;

        // create the queue of tasks
        List<Task> queue = new ArrayList<Task>();

        // read in the tasks and populate the ready queue. It is assumed that processes arrive at the same time     
        while ( (schedule = inFile.readLine()) != null) {
            String[] params = schedule.split(",\\s*");
            queue.add(new Task(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2])));
        }

        inFile.close();
        System.out.println("Tasks have been successfully uploaded");
        
        Algorithm scheduler = null;
        String choice = args[0].toUpperCase();
        
        //switch case completes the construction of the 'scheduler' object based on the given scheduling algorithm in the terminal.
       switch(choice) {
            case "FCFS":
                scheduler = new FCFS(queue);
                break;
            case "SJF":
                scheduler = new SJF(queue);
                break;
            default:
                System.err.println("Invalid algorithm selected");
                System.exit(0);
        }
        // start the scheduler
        scheduler.schedule();
    }
}