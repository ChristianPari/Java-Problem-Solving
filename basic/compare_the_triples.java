package basic;

import java.util.Arrays;
import java.util.List;

public class compare_the_triples {
  public static void main(String[] args) {
    List<Integer> a = Arrays.asList(1,3,2,5);
    List<Integer> b = Arrays.asList(5,7,2,1);

    System.out.println(compareTriplets(a, b));
  }

  private static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    // 2 pointers
    // int first
    // int last is len - 1
    // if len % 2 not 0
    // int extra is len - 1
    // last is len - 2
    // iterate from 0 to len / 2
    // first is always index
    // last is--
    // compare a[first] b[first] and a[last] b[last]
    // assign points accordingly a_id 0 and b_id 1
    // return List of points

    List<Integer> answer = Arrays.asList(0, 0);
    int max = a.size() - 1;
    int extra = (max + 1) % 2;
    int last = (extra == 0) ? max : max - 1;

    if (extra != 0) {
      if (a.get(max) > b.get(max))
        answer.set(0, 1);
      if (b.get(max) > a.get(max))
        answer.set(1, 1);
    }

    int mid = (extra == 0) ? ((max + 1) / 2) : (max / 2);
    for (int first = 0; first < mid; first++) {
      if (a.get(first) > b.get(first))
        answer.set(0, answer.get(0) + 1);
      if (a.get(last) > b.get(last))
        answer.set(0, answer.get(0) + 1);
      if (b.get(first) > a.get(first))
        answer.set(1, answer.get(1) + 1);
      if (b.get(last) > a.get(last))
        answer.set(1, answer.get(1) + 1);

      last--;
    }

    return answer;
  }
}
