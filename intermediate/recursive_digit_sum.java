package intermediate;/*
start: 3:07
end: 4:07 (MAX)

We define super digit of an integer (x) using the following rules:

Given an integer, we need to find the super digit of the integer.
  If (x) has only 1 digit, then its super digit is (x).
  Otherwise, the super digit of (x) is equal to the super digit of the sum of the
    digits of (x).

For example, the super digit of 9875 will be calculated as:
  9875 --- 9+8+7+5 = 29
  29   ---     2+9 = 11
  11   ---     1+1 = 2
  2    ---       2 = 2
  answer = 2
 */
import java.io.*;

import static java.util.stream.Collectors.joining;


public class recursive_digit_sum {

  public static int superDigit(String n, int k) {
    // TEST
    // 321, 2 = 321321
    // 3 + 2 + 1 + 3 + 2 + 1 = 12
    // superDigit(12, 1)
    // 12, 1 = 12
    // 1 + 2 = 3
    // 3 < 10
    // returns 3
    String newN = "";

    if (k > 1) { // concat string to needed length
      int count = 1;
      while (count <= k) {
        newN = newN.concat(n);
        count++;
      }
    } else {
      newN = n;
    }

    int sum = 0; // becomes sum of current (n)
    for (int index = 0; index < newN.length(); index++) {
      int current_num = Integer.parseInt(String.valueOf(newN.charAt(index)));
      sum += current_num;
    }

    if (sum < 10) { // desired answer
      return sum;
    }
    return superDigit(Integer.toString(sum), 1);
  }
}

class Solution {
  public static void main(String[] args) throws IOException {
    System.out.println(recursive_digit_sum.superDigit("148", 3));
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//    String n = firstMultipleInput[0];
//
//    int k = Integer.parseInt(firstMultipleInput[1]);
//
//    int result = intermediate.recursive_digit_sum.superDigit(n, k);
//
//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
//
//    bufferedReader.close();
//    bufferedWriter.close();
  }
}

