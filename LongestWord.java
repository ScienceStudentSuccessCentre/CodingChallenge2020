import java.util.Scanner;

/**
 * Your goal is take in a sentence, and determine the longest word in that sentence.
 * Punctuation will be filtered out for you. Good luck!
 */
public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine().replaceAll ("\\p{Punct}", "");
        sc.close();
        String longestWord = findLongestWord(input);
        System.out.println("The longest word is: " + longestWord);
    }

    public static String findLongestWord(String input) {
        /**
         * Your code goes here!
         */
        return "";
    }
}
