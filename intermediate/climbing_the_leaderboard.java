package intermediate;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'climbingLeaderboard' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY ranked
   *  2. INTEGER_ARRAY player
   */

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here

    // TOO LONG
//    ranked = new ArrayList<>(new HashSet<>(ranked));
//    List<Integer> ranks = new ArrayList<>();
//    for (int score : player) {
//      ranked.add(score);
//      ranked.sort(Collections.reverseOrder());
//      int id = ranked.indexOf(score);
//      ranks.add(id + 1);
//      ranked.remove(id);
//    }

    // TOO LONG
//    ranked = new ArrayList<>(new HashSet<>(ranked));
//    for (int score : player) {
//      ranked.add(score);
//      ranked.sort(Collections.reverseOrder());
//      int id = ranked.indexOf(score);
//      player.set(count++, id + 1);
//      ranked.remove(id);
//    }

    // TOO LONG
//    ranked = new ArrayList<>(new LinkedHashSet<>(ranked));
//    List<Integer> ranks = new ArrayList<>();
//    for (int score : player) {
//      int rank = 0;
//      for (int index = ranked.size(); index > 0; index--) {
//        int rankedScore = ranked.get(index - 1);
//        if (score == rankedScore) {
//          rank = index;
//          break;
//        } else if (score < rankedScore) {
//          rank = index + 1;
//          break;
//        } else if (index == 1) {
//          rank = 1;
//          break;
//        }
//      }
//      ranks.add(rank);
//    }
//    return ranks;

    // WORKS
    List<Integer> ranks = new ArrayList<>(); // to store player score ranks
    HashMap<Integer, Integer> ranking = new HashMap<>(); // will hold an organized score to rank coalition
    int rank = 1; // to track current rank number to store as value for a score
    for (int index = 0; index < ranked.size(); index++) {
      if (!ranking.containsKey(ranked.get(index))) { // if the score isnt in the ranking
        ranking.put(ranked.get(index), rank++); // add to ranking with score to rank key value pair
      }
    }

    int iterator = ranked.size() - 1; // to tell the nested loop where to begin
    // used so we dont check the same index more than 1 time when comparing scores and finding ranks
    for (int score : player) {
      for (int index = iterator; index >= 0; index--) {
        int rankedScore = ranked.get(index); // score being compared to players score
        if (score >= rankedScore) { // means ranked higher
          rank = ranking.get(rankedScore); // set rank to the ranked scores rank
          iterator = index - 1;
        } else break;
      }
      ranks.add(rank);
    }
    return ranks;
  }

}

public class climbing_the_leaderboard {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    List<Integer> result = Result.climbingLeaderboard(ranked, player);

    bufferedWriter.write(
      result.stream()
        .map(Object::toString)
        .collect(joining("\n"))
        + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
