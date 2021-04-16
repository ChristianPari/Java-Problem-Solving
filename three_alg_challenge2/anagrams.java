package three_alg_challenge2;
/*
Two strings, (a) and , (b) are called anagrams if they contain all the same characters in the same frequencies. For this challenge, the test
 is not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.
 */

import java.util.Scanner;

public class anagrams {
  static boolean isAnagram(String a, String b) {
    // make either upper or lower
    // loop through strings
    // if statement
      // second string contains letter
        // replace both instances with blank space
      // doesnt contain letter
        // return false
    // outside of loop check is both strings.trim() are empty
      // return true if yes
      // return false if no

    a = a.toLowerCase();
    b = b.toLowerCase();

    for (int index = 0; index < a.length(); index++) {
      String curLetter = a.substring(index, index + 1);

      boolean containsLetter = b.contains(curLetter); // true or false

      if (containsLetter) {
        if (index == 0) {
          a = " " + a.substring(index + 1);
        } else {
          a = a.substring(0, index) + " " + a.substring(index + 1);
        }

        int bLetterIndex = b.indexOf(curLetter);
        if (bLetterIndex == 0) {
          b = " " + b.substring(bLetterIndex + 1);
        } else {
          b = b.substring(0, bLetterIndex) + " " + b.substring(bLetterIndex + 1);
        }

      } else {
        return false;
      }
    }

    a = a.trim();
    b = b.trim();

    return a.equals("") && b.equals("");
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String a = scan.next();
    String b = scan.next();
    scan.close();
    boolean ret = isAnagram(a, b);
    System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
  }
}
