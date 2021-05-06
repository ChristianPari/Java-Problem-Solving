package basic;/*
A video player plays a game in which the character competes in a hurdle race.
Hurdles are of varying heights, and the characters have a maximum height they can jump.
There is a magic potion they can take that will increase their
  maximum jump height by 1 unit for each dose.
How many doses of the potion must the character take to be able to jump all of the hurdles.
If the character can already clear all of the hurdles, return 0.
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class the_hurdle_race {
  /*
   * Complete the 'hurdleRace' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY height
   */

  public static int hurdleRace(int k, List<Integer> heights) {
    // Write your code here
    int highest_hurdle = 0;
    for (int height : heights) {
      if (height > highest_hurdle)
        highest_hurdle = height;
    }
    int amt_of_potions = highest_hurdle - k;
    return Math.max(amt_of_potions, 0);
  }
}

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> height = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    int result = the_hurdle_race.hurdleRace(k, height);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
