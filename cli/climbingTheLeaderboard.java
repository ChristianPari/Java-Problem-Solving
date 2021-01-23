import java.util.*;

public class climbingTheLeaderboard {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Ranked scores on single line...");
    String[] rankedScoresStr = sc.nextLine().split(" ");
    Integer[] rankedScores = new Integer[rankedScoresStr.length];
    for (int idx = 0; idx < rankedScores.length; idx++) {
      rankedScores[idx] = Integer.parseInt(rankedScoresStr[idx]);
    }
    Set<Integer> rankedSet = new LinkedHashSet<>(Arrays.asList(rankedScores));
    List<Integer> ranked = new ArrayList<>(rankedSet);
    ranked.sort(Collections.reverseOrder());

    System.out.println("Players next games scores on single line...");
    String[] playerScoresStr = sc.nextLine().split(" ");
    Integer[] playerScores = new Integer[playerScoresStr.length];
    for (int idx = 0; idx < playerScores.length; idx++) {
      playerScores[idx] = Integer.parseInt(playerScoresStr[idx]);
    }
    List<Integer> player = new ArrayList<>(Arrays.asList(playerScores));
    Collections.sort(player);

    for (int count = 0; count < player.size(); count++) {
      Integer score = player.get(count);
      ranked.add(score);
      ranked.sort(Collections.reverseOrder());
      System.out.println(ranked.indexOf(score) + 1);
    }
  }
}
