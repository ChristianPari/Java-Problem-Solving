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
    int ball_types = container.get(0).size(); // how many types of balls
    List<Integer> capacities = new ArrayList<>(); // storing containers by index with capacity
    HashMap<Integer, Integer> ball_totals = new HashMap<>(); // key: ball type | value: ball count totals

    for (List<Integer> content : container) { // iterating through list of containers
      int counter = 0; // referring to ball type / a counter to ball type
      int capacity = 0; // will be used to update the "capacities" list
      while (counter < ball_types) { // goes through each ball type per container
        int ball_type = counter; // renaming for use below
        int num_of_balls = content.get(counter++); // gets the amount of balls in the current index
        if (!ball_totals.containsKey(ball_type)) { // adds to the HashMap if it doesn't exist
          ball_totals.put(ball_type, num_of_balls);
        } else { // otherwise update the HashMap with the new total for a ball type
          int new_total = ball_totals.get(ball_type) + num_of_balls;
          ball_totals.replace(ball_type, new_total);
        }
        capacity += num_of_balls; // at the end of each ball type check, increase total capacity for this container
      }
      capacities.add(capacity); // add the capacity for each container to the capacities list which can be referred to by index
    }

    boolean possible = true; // default to true / pass till fail
    for (Map.Entry<Integer, Integer> ball : ball_totals.entrySet()) { // iterating through the HashMap using each Key:Value pair
      int needed_capacity = (int) ((Map.Entry) ball).getValue(); // getting the total for the current ball type
                                                                 // this capcity must be found for this test case to be found true
                                                                 // otherwise not possible
      if (!capacities.contains(needed_capacity)) { // doesn't contain the needed capacity then end the loop and change possible to false
        possible = false;
        break;
      }
      // removing the already found capacity since it can't be reused for another ball type
      int index = capacities.indexOf(needed_capacity);
      capacities.remove(index);
    }

    // return whether possible or impossible
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
