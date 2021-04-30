package three_alg_challenge3;
/*
You can perform the following operations on the string, (a):
  1: Capitalize zero or more of (a)'s lowercase letters.
  2: Delete all of the remaining lowercase letters in (a).

Given two strings, (a) and (b), determine if it's possible to make (a) equal to (b) as
  described.
If so, print YES on a new line.
Otherwise, print NO.

For example, given (a) = AbcDE and (b) = ABDE, in (a) we can convert "b" and delete "c"
  to match (b). If (a) = AbcDE and (b) = AFDE, matching is not possible because letters
  may only be capitalized or discarded, not changed.
 */
import java.io.*;
import java.util.*;

class Result2 {

  /*
   * Complete the 'abbreviation' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING a
   *  2. STRING b
   */

  public static String abbreviation(String a, String b) {
    // Fails instantly if lengths are wrong
    if (a.length() < b.length()) return "NO";

    // Convert a to a list to remove letters
    List<String> aList = new ArrayList<>(Arrays.asList(a.split("")));
    // Convert b to an array to iterate through
    String[] bList = b.split("");
    for (String letter : bList) {
      // Either has an index or -1 for not found
      int doesContain = aList.indexOf(letter);
      // Checking if a contains any form of the letter, if not then fail
      if (doesContain == -1) {
        String tempB = letter.toLowerCase();
        doesContain = aList.indexOf(tempB);
        if (doesContain == -1) {
          return "NO";
        }
      }
      // Removes the index from a of where the letter was found
      aList.remove(doesContain);
    }

    // Now just going through checking if there are any uppercase letters left
      // If so then fail
    for (String letter : aList) {
      String tempA = letter.toUpperCase();
      if (letter.equals(tempA))
        return "NO";
    }

    // Returns a passing statement if all passes
    return "YES";
  }

}

public class abbreviation {
  public static void main(String[] args) throws IOException {
    // MY TESTING
    String a = "beFgH";
    String b = "EFG";
    String result = Result2.abbreviation(a, b);
    System.out.println(result); // YES

    // HACKERRANK CODE
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//    int q = Integer.parseInt(bufferedReader.readLine().trim());
//
//    IntStream.range(0, q).forEach(qItr -> {
//      try {
//        String a = bufferedReader.readLine();
//
//        String b = bufferedReader.readLine();
//
//        String result = Result.abbreviation(a, b);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//      } catch (IOException ex) {
//        throw new RuntimeException(ex);
//      }
//    });
//
//    bufferedReader.close();
//    bufferedWriter.close();
  }
}
