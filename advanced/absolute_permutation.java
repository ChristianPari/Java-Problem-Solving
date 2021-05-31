package advanced;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result3 {

  /*
   * Complete the 'absolutePermutation' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER k
   */

  public static List<Integer> absolutePermutation(int n, int k) {
// PERMUTATION IS ONLY POSSIBLE WHEN "k" GOES INTO "n" EVENLY AS A WHOLE NUMBER ... give examples
    List<Integer> answer = new LinkedList<>();

      /*
        FIRST CHECK:
          if "k" is 0 then a plain List filled w/ 1 to "n" is the only result possible bc no permutations will occur
      */
    if (k == 0) {
      for (int num = 1; num <= n; num++) {
        answer.add(num);
      }
      return answer;
    }

      /*
        SECOND CHECK:
          if the divisor of "n" and "k" doesnt equal 0 when modulo by 1 then there isnt a possible permutation bc the result leftover isnt a whole number
          also if the value is a whole number but not divisible by 2 then also isnt able to be a permutation
      */
    double nDivK = (double) n / k;
    boolean isEven = (nDivK % 2 == 0);
    if (!isEven) {
      answer.add(-1);
      return answer;
    }

      /*
        CREATE PERMUTATION:
          having a counter that will hold the place of the current unpermutated index value and then checking if we will be increasing or decreasing this number due to its corresponding number in the permutation
          a boolean that will tell the program when to increase or decrease the value of counter by keeping track of how many elements have been added to the List according to "k"
      */

    int counter = 1;
    boolean adding = true;
    for (int num = 1; num <= n; num++) {
      // System.out.println("counter > k: " + (counter > k) + ", counter: " + counter + ", k: " + k);
      // System.out.println("num: " + num + ", num + k: " + (num + k) + ", num - k: " + (num - k));
      // System.out.println("adding before check: " + adding);

      if (counter > k) {
        counter = 1;
        adding = !adding;
      }

      // System.out.println("adding after check: " + adding);

      if (adding) {
        answer.add(num + k);
        counter++;
      } else {
        answer.add(num - k);
        counter++;
      }

      // System.out.println("filling: " + answer);
    }

    // System.out.println("answer: " + answer + "\n");
    return answer;
  }

}

public class absolute_permutation {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> result = Result3.absolutePermutation(n, k);

        bufferedWriter.write(
          result.stream()
            .map(Object::toString)
            .collect(joining(" "))
            + "\n"
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
