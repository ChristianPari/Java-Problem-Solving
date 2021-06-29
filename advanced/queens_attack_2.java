package advanced;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result5 {

  /*
   * Complete the 'queensAttack' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER k
   *  3. INTEGER r_q
   *  4. INTEGER c_q
   *  5. 2D_INTEGER_ARRAY obstacles
   */

  public static int queensAttack(
    int max,
    int num_of_obstacles,
    int q_row,
    int q_column,
    List<List<Integer>> obstacles
  ) {
    int moves = 0;
    int current_row = q_row;
    int current_column = q_column;

    int left = q_row - 1;
    int right = max - q_row;
    int top = max - q_column;
    int bottom = q_column - 1;

    // FOR UP DOWN LEFT AND RIGHT
    if (num_of_obstacles > 0) {
      for (List<Integer> obstacle : obstacles) {
        int ob_r = obstacle.get(0);
        int ob_c = obstacle.get(1);

        if (q_row == ob_r) {
          if (ob_c > q_column) {
            right = Math.abs(q_column - ob_c) - 1;
          } else {
            left = Math.abs(q_column - ob_c) - 1;
          }
        }

        if (q_column == ob_c) {
          if (ob_r > q_row) {
            top = Math.abs(q_row - ob_r) - 1;
          } else {
            bottom = Math.abs(q_row - ob_r) - 1;
          }
        }
      }
    }
    // System.out.println("top:" + top + " left:" + left + " bottom:" + bottom + " right:" + right);
    moves += (top + bottom + left + right);


    // BELOW FOR GETTING DIAGONAL MOVES
    // left up
    while (
      (++current_row > 0 && current_row <= max) && (--current_column > 0 && current_column <= max)
    ) {
      if (obstacles.contains(new ArrayList<>(Arrays.asList(current_row, current_column)))) break;
      moves++;
    }
    // System.out.println("l u moves:" + moves);
    current_row = q_row;
    current_column = q_column;

    // right up
    while (
      (++current_row > 0 && current_row <= max) && (++current_column > 0 && current_column <= max)
    ) {
      if (obstacles.contains(new ArrayList<>(Arrays.asList(current_row, current_column)))) break;
      moves++;
    }
    // System.out.println("r u moves:" + moves);
    current_row = q_row;
    current_column = q_column;

    // left down
    while (
      (--current_row > 0 && current_row <= max) && (--current_column > 0 && current_column <= max)
    ) {
      if (obstacles.contains(new ArrayList<>(Arrays.asList(current_row, current_column)))) break;
      moves++;
    }
    // System.out.println("l d moves:" + moves);
    current_row = q_row;
    current_column = q_column;

    // right down
    while (
      (--current_row > 0 && current_row <= max) && (++current_column > 0 && current_column <= max)
    ) {
      if (obstacles.contains(new ArrayList<>(Arrays.asList(current_row, current_column)))) break;
      moves++;
    }
    // System.out.println("r d moves:" + moves);

    return moves;
  }

}

public class queens_attack_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int r_q = Integer.parseInt(secondMultipleInput[0]);

    int c_q = Integer.parseInt(secondMultipleInput[1]);

    List<List<Integer>> obstacles = new ArrayList<>();

    IntStream.range(0, k).forEach(i -> {
      try {
        obstacles.add(
          Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int result = Result5.queensAttack(n, k, r_q, c_q, obstacles);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
