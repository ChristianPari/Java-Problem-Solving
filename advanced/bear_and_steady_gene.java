package advanced;/*
A gene is represented as a string of length (n) (where (n) is divisible by 4),
  composed of the letters A, C, T, and G.
It is considered to be steady if each of the four letters occurs exactly n/4
  times.
For example, GACT and AAGTGCCT are both steady genes.
Bear Limak is a famous biotechnology scientist who specializes in modifying bear
  DNA to make it steady. Right now, he is examining a gene represented as a string
    (gene).
It is not necessarily steady.
Fortunately, Limak can choose one (maybe empty) substring of (gene) and
  replace it with any string of the same length.
Modifying a large substring of bear genes can be dangerous.
Given a string (gene), can you help Limak find the length of the smallest possible
  substring that he can replace to make (gene) a steady gene?

Note: A substring of a string (s) is a subsequence made up of
  zero or more contiguous characters of (s).

As an example, consider (gene = ACTGAAAG).
The substring AA just before or after G can be replaced with CT or TC.
One selection would create ACTGACTG.
 */
import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {
  /*
   * Complete the 'steadyGene' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING gene as parameter.
   */

  public static int steadyGene(String gene) {
    // Write your code here
    int geneLength = gene.length();
    int MAX_FREQ = geneLength / 4;
    HashMap<Character, Integer> freqs = new HashMap<>();
    freqs.put('A', 0);
    freqs.put('T', 0);
    freqs.put('C', 0);
    freqs.put('G', 0);

    char[] geneArray = gene.toCharArray();
    for (char c : geneArray) {
      int currentTotal = freqs.get(c);
      freqs.put(c, currentTotal + 1);
    }

    if (freqs.get('A') == MAX_FREQ &&
        freqs.get('T') == MAX_FREQ &&
        freqs.get('C') == MAX_FREQ &&
        freqs.get('G') == MAX_FREQ) {
      return 0;
    }

    int i = 0;
    int j = 0;
    int minSubString = geneLength;

    while (i < geneLength && j < geneLength) {
      if (!isValid(MAX_FREQ, freqs)) {
        char letter = geneArray[i];
        freqs.put(letter, freqs.get(letter) - 1);
        i++;
      } else {
        minSubString = Math.min(minSubString, (i - j));
        char letter = geneArray[j];
        freqs.put(letter, freqs.get(letter) + 1);
        j++;
      }
    }

    return minSubString;
  }

  private static boolean isValid (int maxFreq, HashMap<Character, Integer> map) {
    return map.get('A') <= maxFreq &&
      map.get('T') <= maxFreq &&
      map.get('C') <= maxFreq &&
      map.get('G') <= maxFreq;
  }
}

public class bear_and_steady_gene {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String gene = bufferedReader.readLine();

    int result = Result.steadyGene(gene);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}


