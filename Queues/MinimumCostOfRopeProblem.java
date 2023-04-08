/* Given are N ropes of different lengths, the task is to connect these ropes into one rope with
minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.
Sample Input 1 : N = 4, arr = [4 3 2 6]
Sample Output 1 : 29
Sample Input 2 : N = 2, arr = [1 2 3]
Sample Output 2 : 9 */

package Queues;
import java.util.PriorityQueue;

public class MinimumCostOfRopeProblem {
    public static int findMinimumCost(int[] ropes) {
        int minCost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(ropes.length == 0) {
            return 0;
        } else if (ropes.length == 1) {
            return ropes[0];
        } else if(ropes.length == 2){
            return ropes[0] + ropes[1];
        } else {
            for(int rope:ropes) {
                pq.offer(rope);
            }
            while(pq.size() > 1) {
                int smallest = pq.poll();
                int secondSmallest = pq.poll();
                int currCost = smallest + secondSmallest;
                minCost += currCost;
                pq.offer(currCost);
            }
        }
        return minCost;
    }
    public static void main(String[] args) {
        int[] ropes = {4,3,2,6};
        System.out.println(findMinimumCost(ropes));
    }
}
