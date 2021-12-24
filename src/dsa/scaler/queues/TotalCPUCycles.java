package dsa.scaler.queues;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class TotalCPUCycles {

    public static void main(String[] args) {
        TotalCPUCycles tcc = new TotalCPUCycles();
        System.out.println(tcc.solve(new int[]{1},new int[]{1}));
    }
    public int solve(int[] A, int[] B) {
        Deque<Integer> taskQueue = new LinkedList<Integer>();
        int totalCycles = 0;
        HashSet<Integer> queuedTasks = new HashSet<>();

        for (int a : A) {
            taskQueue.addLast(a);
            queuedTasks.add(a);
        }

        for (int b : B) {
            if(!queuedTasks.contains(b)){
                continue;
            }
            while (taskQueue.getFirst() != b) {
                taskQueue.addLast(taskQueue.removeFirst());
                totalCycles++;
            }
            taskQueue.removeFirst();
            totalCycles++;
        }

        return totalCycles;
    }
}
