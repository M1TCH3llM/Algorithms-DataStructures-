package Problems;

public class Thirty {
    public String solution(String S) {
           char[] s = S.toCharArray();
        int n = s.length;

        for (int i = 0; i < n; i++) {
            if (s[i] != '?') continue;

            // try 'a' first, else use 'b'
            s[i] = pick(s, i, 'a') ? 'a' : 'b';
        }
        return new String(s);
    }

    private boolean pick(char[] s, int i, char c) {
        int n = s.length;

     
        if (i >= 2 && s[i-1] == c && s[i-2] == c) return false;
        if (i-1 >= 0 && i+1 < n && s[i-1] == c && s[i+1] == c) return false;
        if (i+2 < n && s[i+1] == c && s[i+2] == c) return false;

        return true;
    }


    public static void main(String[] args) {
        Thirty string = new Thirty();

        String filter1 = "a?bb";
        System.out.println(string.solution(filter1)); 

        String filter2= "??abb";
         System.out.println(string.solution(filter2));

        String filter3= "a?b?aa";
        System.out.println(string.solution(filter3));


        String filter4= "aa??aa";
        System.out.println(string.solution(filter4));

    }
}
