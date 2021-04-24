package intermediate;
/*
David has several containers, each with a number of balls in it.
He has just enough containers to sort each type of ball he has into its own container.
David wants to sort the balls using his sort method.

David wants to perform some number of swap operations such that:

    Each container contains only balls of the same type.
    No two balls of the same type are located in different containers.

 */
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

public class organizing_containers_of_balls {

  // Complete the organizingContainers function below.
  static String organizingContainers(List<List<Integer>> container) {
    int ball_types = container.get(0).size();
    List<Integer> capacities = new ArrayList<>();
    HashMap<Integer, Integer> ball_totals = new HashMap<>();

    for (List<Integer> content : container) {
      int counter = 0;
      int capacity = 0;
      while (counter < ball_types) {
        int ball_type = counter;
        int num_of_balls = content.get(counter++);
        if (!ball_totals.containsKey(ball_type)) {
          ball_totals.put(ball_type, num_of_balls);
        } else {
          int new_total = ball_totals.get(ball_type) + num_of_balls;
          ball_totals.replace(ball_type, new_total);
        }
        capacity += num_of_balls;
      }
      capacities.add(capacity);
    }

    boolean possible = true;
    for (Map.Entry<Integer, Integer> ball : ball_totals.entrySet()) {
      int needed_capacity = (int) ((Map.Entry) ball).getValue();
      if (!capacities.contains(needed_capacity)) {
        possible = false;
        break;
      }
      int index = capacities.indexOf(needed_capacity);
      capacities.remove(index);
    }

    String response = possible ? "Possible" : "Impossible";
    return response;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    // MY TESTING
//    int[][] container1 = {
//      {1,3,1},
//      {2,1,2},
//      {3,3,3}
//    };
//    String result1 = organizingContainers(container1);
//    System.out.println(result1);
//    int[][] container2 = {
//      {0,2,1},
//      {1,1,1},
//      {2,0,0}
//    };
//    String result2 = organizingContainers(container2);
//    System.out.println(result2);

    // HACKERRANK CODE
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> container = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
          try {
            container.add(
              Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList())
            );
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });

        String result = organizing_containers_of_balls.organizingContainers(container);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
