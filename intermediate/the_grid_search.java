package intermediate;

import java.io.*;
import java.util.*;

class grid_search_result {

  /*
   * Complete the 'gridSearch' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING_ARRAY G
   *  2. STRING_ARRAY P
   */

  public static String gridSearch(
    int G_rows,
    int P_rows,
    List<String> G,
    List<String> P
  ) {
    List<List<String>> arrays = new ArrayList<>();

    int rows = G_rows - P_rows;
    int pattern_start_index = 0;
    int pattern_length = P.get(0).length();

    for (int index = 0; index <= rows; index++) {
      String g_elm = G.get(index);
      String p_elm = P.get(0);
      int str_index = g_elm.indexOf(p_elm);

      if (str_index != -1) {
        pattern_start_index = str_index;
        List<String> sub = G.subList(index, (index + P_rows));
        arrays.add(sub);
      }
    }

    if (arrays.size() < 1) return "NO";
    System.out.println(arrays);

    for (List<String> arr : arrays) {
      boolean found = true;

      for (int index = 0; index < arr.size(); index++) {
        String g_elm = arr.get(index);
        String p_elm = P.get(index);

        if (!g_elm.contains(p_elm)) {
          found = false;
          break;
        }
      }

      if (found) return "YES";

      found = true;
    }

    return "NO";
  }

}

public class the_grid_search {
  public static void main(String[] args) throws IOException {
    int G_rows = 7;
    List<String> G = new ArrayList<>(Arrays.asList(
      "111111111111111",
      "111111111111111",
      "111111111111111",
      "111111011111111",
      "111111111111111",
      "111111111111111",
      "101010101010101"
    ));
    int P_rows = 4;
    List<String> P = new ArrayList<>(Arrays.asList(
      "11111",
      "11111",
      "11111",
      "11110"
    ));

    System.out.println(grid_search_result.gridSearch(G_rows, P_rows, G, P));
  }
}
