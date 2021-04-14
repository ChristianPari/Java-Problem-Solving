package three_alg_challenge;
/*
You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height.
You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height.
This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they are all the same height,
  then return the height.
 */
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class equal_stacks {
  /*
   * Complete the 'equalStacks' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY h1
   *  2. INTEGER_ARRAY h2
   *  3. INTEGER_ARRAY h3
   */

  public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    Stack<Integer> h1Stack = new Stack<>();
    int h1Sum = 0;
    Stack<Integer> h2Stack = new Stack<>();
    int h2Sum = 0;
    Stack<Integer> h3Stack = new Stack<>();
    int h3Sum = 0;

    for (int index = h1.size() - 1; index >= 0; index--) {
      h1Sum += h1.get(index);
      h1Stack.push(h1.get(index));
    }
    for (int index = h2.size() - 1; index >= 0; index--) {
      h2Sum += h2.get(index);
      h2Stack.push(h2.get(index));
    }
    for (int index = h3.size() - 1; index >= 0; index--) {
      h3Sum += h3.get(index);
      h3Stack.push(h3.get(index));
    }

    int smallestStack = Math.min(Math.min(h1Sum, h2Sum), h3Sum);

    while (h1Sum != smallestStack || h2Sum != smallestStack || h3Sum != smallestStack) {
      if (h1Sum > smallestStack) {
        h1Sum -= h1Stack.pop();
      }
      smallestStack = Math.min(Math.min(h1Sum, h2Sum), h3Sum);

      if (h2Sum > smallestStack) {
        h2Sum -= h2Stack.pop();
      }
      smallestStack = Math.min(Math.min(h1Sum, h2Sum), h3Sum);

      if (h3Sum > smallestStack) {
        h3Sum -= h3Stack.pop();
      }
      smallestStack = Math.min(Math.min(h1Sum, h2Sum), h3Sum);
    }

    return smallestStack;
  }
}


class Main {
  public static void main(String[] args) throws IOException {
    // MY TESTING
//    List<Integer> h1 = Arrays.asList(3,2,1,1,1);
//    List<Integer> h2 = Arrays.asList(4,3,2);
//    List<Integer> h3 = Arrays.asList(1,1,4,1);
//    int result = equal_stacks.equalStacks(h1, h2, h3); // 5

    // HACKERRANK CODE
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n1 = Integer.parseInt(firstMultipleInput[0]);

    int n2 = Integer.parseInt(firstMultipleInput[1]);

    int n3 = Integer.parseInt(firstMultipleInput[2]);

    List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    int result = equal_stacks.equalStacks(h1, h2, h3); // equal_stacks is their 'Result' class

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
