// k: Is Teacher Present

// You are in a class of N students, where only one teacher is known to everyone.
// You will be given a square matrix M[][] where if an element of row i and column j is set to 1 it means the ihe  person known the jth person.
// You need to complete the function findld() that find the id of the teacher if present else returns -1. The function findld() takes two arguments, the square matrix M and its size N.
// Such a teacher may be present in the class, if yes, the teacher doesn’t know anyone in the class.
// Your task is to find the index of the teacher in the class.
// Note 
// M[i][i] will be equal to zero always.
// Input Format
// The first line contains a number denoting the size of the matrix M.
// Next M lines contain space-separated values of the matrix M.
// Sample Input

// 3
// 0 1 0
// 0 0 0
// 0 1 0

// Constraints 
// 2 < = N < = 501
// 0 < = M[][] < = 1
// Output Format
// The output will be the id of the teacher if present (0 based index). Else -1 will be printed.
// Sample Output

// 1

// Explanation
// For the above test case, the matrix will look like
// 0 1 0
// 0 0 0
// 0 1 0
// Here, the teacher is the person with index 1 i.e. id 1.


package Assessment2;

public class IsTeacherPresent {

    static int teacher(int[][] mat) {
        int n = mat.length;

        int i = 0, j = n - 1;
        while (i < j) {
            
           // checks it see if row i knows some one if yes not teacher
            if (mat[j][i] == 1)
                j--;
            
          
            else
            // moves to next column
                i++;
        }
    
        // candidate for teacher
        int t = i;
    
        // 
        for (i = 0; i < n; i++) {
            if (i == t) continue;
            
            // if not 0 not teacher if no one knows candidate also not teacher
            if (mat[t][i] != 0 || mat[i][t] == 0)
                return -1;
        }
    
        return t;
    }
    

    public static void main(String[] args) {
        int[] [] matrix = {{0, 1, 0},
                           {0, 0, 0}, // teacher
                           {0, 1, 0}};
        System.out.println(teacher(matrix));
    }
}
