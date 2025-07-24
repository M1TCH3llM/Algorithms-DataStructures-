// Queues: Total number of seconds

// There is a factory with N people.
// The people are standing in a queue and each person is given some number of tasks to complete.
// The queue follows the following rules:

// 1) The person standing at the front of the queue is allowed to complete while others wait.
// 2) If the person standing at the front of the queue has one task left he completes it in one second and leaves the queue.
// 3) if the person standing at the front of the queue has more than one task he completes half of the remaining tasks each second.
// Find the total number of seconds required for everyone in the queue to complete their tasks.

// Input Format
// The first line of input contains integer N denoting the size of the array.
// The next line contains N integers where ith integer denotes the number of tasks to be completed by ith person.

// Sample Input

// 3
// 3 2 1

// Constraints
// 1< = N< = 50
// 1< Number of tasks<=100
// Output Format

// The output contains a single integer denoting the total number of seconds required for everyone in the queue to complete their tasks.
// Sample Output

// 6

// Explanation

// At t=0 the queue is [3,2,1].
// At t=1 the person at the front of the queue completers half i.e 3/2=1 tasks. Therefore remaining tasks for him=3-1=2. Therefore the queue becomes [2,2,1].
// At t=2 the person at the front of the queue completes half i.e 2/2=1 tasks. Therefore remaining tasks for him=2-1=1. Therefore the queue becomes [1,2,1].
// At t=3 the person at the front of the queue completes the final task and leaves the queue. Therefore the queue becomes [2,1].
// At t=4 the person at the front of the queue completes half i.e 2/2=1 tasks. Therefore remaining tasks for him=2-1=1. Therefore the queue becomes [1,1].
// At t=5 the person at the front of the queue completes the final task and leaves the queue. Therefore the queue becomes [1].
// At t=6 the person at the front of the queue completes the final task and leaves the queue. Therefore the queue becomes empty.
// Hence the output is 6.


package Assessment2;
import java.util.*;

public class TotalNumberSeconds {

     public int solution(int[] input) {
        Queue<Integer> queue = new LinkedList<>();

        for (int t : input) {
            queue.add(t);
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int current = queue.peek();

            if (current ==1 ) {
                queue.poll();
            } else {

                queue.poll();
                int completed = current / 2;
                int remaning = current - completed;

                queue.add(remaning);

            }

            time++;
        }
        return time;
     }

    public static void main(String[] args) {
        
        TotalNumberSeconds solution = new TotalNumberSeconds();

        int[] input = {3, 2, 1}; 
        int result = solution.solution(input);
        System.out.print(Arrays.toString(input) + " => Time: ");
        System.out.print(result);
        System.out.println();



    }
}
