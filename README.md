# CPU-Scheduling
### Introduction
Imagine this scenario; you walk in a coffee shop and place an order that costs a measely $10 for you and a friend. Your payment and information are taken, and the staff know you are in the store waiting on your order to be prepared. However, some time passes and you notice that other customers who arrived after you are receiving their orders. You walk up to the counter to check on your order and you are told it is in the queue, but the shop's policy is to focus on completing orders of smaller prices first, so your order is currently last to be made in the order cue because other customers' orders each cost less than $5. How would you react? Would you visit this shop again knowing this is their policy for fulfilling orders? This is an analogy for the problem being solved by CPU scheduling.


CPU scheduling is an important aspect of an Operating System. This is how an Operating System chooses the order in which its processes will be run. The CPU scheduler - based on a pre-programmed algorithm - selects processes from the ready queue to be allocated resources. This project compares and contrasts two algorithms; the F.C.F.S (First-Come First- Served), and S.J.F (Shortest Job First). These algorithms are fairly similar, but certain nuances in the algorithms affect the perfomance metrics of each one.

### Project Breakdown
There are two .txt files provided to test either one of the scheduling algorithms. The files are named "queue1.txt" and "queue2.txt". These represent the ready queue on a system.

To observe any one of the algorithms in action on a given queue of processes, use the following convention in the terminal to run the driver (CPU scheduler)
`java <driver name> <scheduling algorithm's acronym> <queue name including extension>`

For example: 
* `java CpuDriver fcfs queue1.txt` will run the First-Come First-Served algorithm on queue 1
* `java CpuDriver sjf queue2.txt` will run the Shortest Job First Algorithm on queue 2.

When you run each one of these algorithms, you will observe an interval between when each process/task is completed. This time interval is an exaggerated simulation of each process in its critical section (when the process has been allocated resources by the CPU scheduler to be satisfied). This time interval will vary depending on the time slice for each process.

#### Performance Metrics
There are four Gantt charts which illustrate the alogrithms on each queue:
* "FCFS Queue 1.png"
* "SJF Queue 1.png"
* "FCFS Queue 2.png"
* "SJF Queue 2.png"
  
and .xslx sheet which logs the average wait time and average turn around time of each algorithm:
* "Performance Metrics.xlsx"

Study these to observe the significant impact choosing one algorithm over the has on the average wait time and the average turnaround time of the processes.

### Debugging and Problem-Solving
Known errors are encounted when the user fails to follow the convention specified for the terminal. For example:
* “java CpuDriver fcfs schedule.txt” throws a *FileNotFoundException* and the program terminates. The user needs to input the correct .txt file name.
* “java sjf queue1.txt” throws a *NoClassDefFoundError*, and the program terminates. The user did not include the correct driver file name. The console is reading ‘sjf” as the drive file name, which is incorrect.
