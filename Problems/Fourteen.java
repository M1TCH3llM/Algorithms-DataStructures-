package Problems;

public class Fourteen {
   

    public static String replaceWordsWithSymbols(String text) {
        // Replace "minus" with "-"
        String result = text.replace("minus", "-");
        // Replace "plus" with "+"
        result = result.replace("plus", "+");
        return result;
    }

    public static void main(String[] args) {
        String input = "minusplusminus";
        String output = replaceWordsWithSymbols(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
