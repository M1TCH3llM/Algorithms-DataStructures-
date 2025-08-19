
// Given a 2D board and a list of words from the dictionary, find all words in the board.
// Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighbouring. The same letter cell may not be used more than once in a word.
//  Example:
// Input:
// board = [
//   ['o','a','a','n'],
//   ['e','t','a','e'],
//   ['i','h','k','r'],
//   ['i','f','l','v']
// ]
// words = ["oath","pea","eat","rain"]
 
// Output: ["eat","oath"]
//  Note:
// All inputs are consist of lowercase letters a-z.
// The values of words are distinct.

package Problems;

import java.util.*;

public class FiftyEight {

    // perform a depth first search on grid
    static boolean dfs(char[][] letters, String word, int i, int j, int index) {

        // check if the current call is out of bounbds
        if (i < 0 || i >= letters.length || j < 0 || j >= letters[0].length) {
            return false;
        }

        // check if current cell matches char in word
        if (letters[i][j] != word.charAt(index)) {
            return false;
        }

        // check if complete word found
        if (index == word.length() - 1) {
            return true;
        }

        // mark current cell as visited stores letter and replaces with #
        char temp = letters[i][j];
        letters[i][j] = '#'; 

         // 4-directional neighbors
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

         for (int d = 0; d < 4; d++) {
              if (dfs(letters, word, i + dr[d], j + dc[d], index + 1)) {
                  letters[i][j] = temp; // unmark
                  return true;
               }
            }
        letters[i][j] = temp;
        return false;

    }

    // find words in a grid of Char
    static List<String> findWords(List<String> words, char[][] letters) {
        int n = letters.length, m = letters[0].length;
        int r = words.size();
        List<String> ans = new ArrayList<>();

        //store the unique words int the hashSet
        Set<String> result = new HashSet<>();

        for (int i = 0; i < r; i ++) {
            for ( int j = 0; j < n; j ++) {
                for (int k = 0; k < m; k ++) {
                    if (dfs(letters, words.get(i), j, k, 0)) {
                        result.add(words.get(i));
                    }
                }
            }
        }

        for (String word : result) {
            ans.add(word);
        }
        return ans;

    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("oath","pea","eat","rain", "ethk");
        char[][] letters = {
                 {'o','a','a','n'},
                 {'e','t','a','e'},
                 {'i','h','k','r'},
                 {'i','f','l','v'}
                    };
        List<String> ans = findWords(words, letters);
        System.out.println("Found Words: ");
        for (String word : ans) {
            System.out.println(word + " ");
        }
    }
}
