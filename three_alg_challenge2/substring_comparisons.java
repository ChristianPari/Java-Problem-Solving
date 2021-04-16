package three_alg_challenge2;
/*
We define the following terms:

    Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows: A B ... Y Z a b ... y z

    For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.
    A substring of a string is a contiguous block of characters in the string. For example, the substrings of abc are a, b, c, ab, bc, and abc.

Given a string, (s), and an integer, (k), complete the function so that it finds the lexicographically smallest and largest substrings of
length (k).
 */
import java.util.Scanner;

public class substring_comparisons {
  public static String getSmallestAndLargest(String s, int k) {
    String smallest = s.substring(0, k);
    String largest = smallest;

    for (int index = 1; index < s.length() - (k - 1); index++) {
      String curSubString = s.substring(index, (index + k));

      // true if smaller, false if
      boolean smallerThanSmallest = curSubString.compareTo(smallest) < 0;
      boolean largerThanLargest = curSubString.compareTo(largest) > 0;


      if (smallerThanSmallest) {
        smallest = curSubString;
      } else if (largerThanLargest) {
        largest = curSubString;
      }
    }

    return smallest + "\n" + largest;
  }


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    int k = scan.nextInt();
    scan.close();

    System.out.println(getSmallestAndLargest(s, k));
  }
}
