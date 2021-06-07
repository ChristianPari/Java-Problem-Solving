package advanced;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class Result4 {

  /*
   * Complete the 'bonetrousle' function below.
   *
   * The function is expected to return a LONG_INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. LONG_INTEGER n
   *  2. LONG_INTEGER k
   *  3. INTEGER b
   */

  public static List<Long> bonetrousle(long n, long k, int b) {
    // if passes this List will be returned with valid data
    List<Long> answer = new ArrayList<>();

    // if failed somewhere this will be returned
    List<Long> failed = new ArrayList<>(Arrays.asList((long) -1));

    // needed for logic as well as more checks for failure
    long listSum = 0;
    for (long num = 1; num <= b; num++) {
      answer.add(num);
      listSum += num;
    }

    if (listSum > n) {
      return failed;
    }

    // REFERENCE: answer - List, listSum - sum of current List
    int alteringIndex = b - 1;
    long maxAvailableNum = k;

    while (alteringIndex >= 0) {
      long differenceNeeded = n - listSum;
      long toBeAdded = answer.get(alteringIndex) + differenceNeeded;
      if (toBeAdded <= maxAvailableNum) {
        answer.set(alteringIndex, toBeAdded);
        return answer;
      }

      listSum -= answer.get(alteringIndex);
      listSum += maxAvailableNum;
      answer.set(alteringIndex--, maxAvailableNum--);

      if (listSum == n) {
        return answer;
      }
    }

    // all the largest numbers summed from 1-B wasnt enough to reach N so failure
    return failed;
  }
}

public class count_and_say {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        long n = Long.parseLong(firstMultipleInput[0]);

        long k = Long.parseLong(firstMultipleInput[1]);

        int b = Integer.parseInt(firstMultipleInput[2]);

        List<Long> result = Result4.bonetrousle(n, k, b);

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

