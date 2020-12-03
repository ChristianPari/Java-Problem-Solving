import java.util.Scanner;

public class find_longest_word {
  // return the length of the longest word in th provided string
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a string to have the length of the longest word returned back!");
    String str = sc.nextLine();
    int wordLength = lengthOfLongest(str);
    System.out.println("Longest word has " + wordLength + " characters...");
  }

  public static int lengthOfLongest(String str) {
    int lengthOfWord = 0;
    String[] strList = str.split(" ");
    for (String word : strList) {
      lengthOfWord = lengthOfWord < word.length() ? word.length() : lengthOfWord;
    }
    return lengthOfWord;
  }
}
