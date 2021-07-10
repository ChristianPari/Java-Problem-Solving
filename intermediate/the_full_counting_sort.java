package intermediate;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class counting_sort {

  /*
   * Complete the 'countSort' function below.
   *
   * The function accepts 2D_STRING_ARRAY arr as parameter.
   */

  public static void countSort(List<List<String>> arr) {
    int halfway = arr.size() / 2;
    int tracker = 0;
    int largest_index = 0;
    List<List<String>> result = new ArrayList<>();
    for (int i = 0; i < arr.size(); i++) {
      result.add(new ArrayList<>());
    }

    for (List<String> array : arr) {
      int index = Integer.parseInt(array.get(0));
      largest_index = largest_index < index ? index : largest_index;
      String letter = tracker++ < halfway ? "-" : array.get(1);
      List<String> new_arr = result.get(index);
      new_arr.add(letter);
      result.set(index, new_arr);
    }

    result = result.subList(0, largest_index + 1);

    List<String> answer = result.stream().flatMap(Collection::stream).collect(toList());
    System.out.println(String.join(" ", answer));
  }

}

public class the_full_counting_sort {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<String>> arr = new ArrayList<>();

    IntStream.range(0, n).forEach(i -> {
      try {
        arr.add(
          Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    counting_sort.countSort(arr);

    bufferedReader.close();
  }
}
