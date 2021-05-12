package basic;/*
The distance between two array values is the number of
  indices between them.
Given (a), find the minimum distance
  between any pair of equal elements in the array.
If no such value exists, return -1.
 */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class minimum_distances {
  public static int minimumDistances(List<Integer> a) {
    // Write your code here
    boolean arePairs = false;
    long min = a.size();

    for (int index = a.size() - 1; index >= 0; index--) {
      int current = a.get(index);
      int searched_index = a.indexOf(current);

      if (index != searched_index) {
        long distance = index - searched_index;
        min = Math.min(min, distance);
        arePairs = true;
      }
    }

    if (arePairs) {
      return (int) min;
    }

    return -1;
  }
}

class Solution2 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    int result = minimum_distances.minimumDistances(a);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}