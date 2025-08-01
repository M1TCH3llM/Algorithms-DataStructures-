// Friend Circle Problem

//  There are N students in a class. Some of them are friends, while some are not.
//   Their friendship is transitive in nature. For example, if A is a direct friend of B, 
//   and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a 
// 	 group of students who are direct or indirect friends.
// Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, 
// then the ith and jth students are direct friends with each other, otherwise not.
//  And you have to output the total number of friend circles among all the students.

package Problems;

public class FiftyFive {
    static void DFS(int[][] friends, int n, boolean[] visited, int v) {
        for (int i = 0; i < n; ++i) {

            // finds friends in student array 
            if (friends[v][i] == 1 && !visited[i] && i != v) {
                visited[i] = true;
                DFS(friends, n, visited, i);
            }
        }
    }

    static int friendCircles(int[][] friends, int n) {
        // no students to be friends with :(
        if (n == 0) {
            return 0;
        }

        int numCircles = 0; //  friend circle value holder

        boolean visited[] = new boolean[n]; // tracks students already in friend circle

        // start with first student and recursively find all there friends then go to next student
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(friends, n, visited, i); //finds all friends passing the DFS method
                numCircles = numCircles + 1;
            }
        }
        return numCircles;
    }

    public static void main(String args[]) 
  { 
      int n = 3;
      int[][] friends = new int[][] {
                         {1,1,0},
                         {1,1,0},
                         {0,0,1}
                        };

      int[][] friends2 = new int[][] {
                         {1,1,0},
                         {1,1,1},
                         {0,1,1}
                        };

     System.out.println("Number of friends circles: " + friendCircles(friends, n)); 
     System.out.println("Number of friends circles Part Two: " + friendCircles(friends2, n)); 
  } 
}


// do Problems 55 - 57