package intermediate;

import java.util.HashSet;

public class first_duplicate {

  public static void main(String[] args) {
    int answer = firstDuplicate(new int[]{1,2,3,2,3,1});
  }

  private static int firstDuplicate(int[] a) {
    HashSet<Integer> nums = new HashSet<>();
    for (int num : a) {
      if (nums.contains(num)) {
        return num;
      } else {
        nums.add(num);
      }
    }
    return -1;

    // TAKES TOO LONG
    // int LENGTH = a.length;
    // int smallestIndex = LENGTH;
    // int startingIndex = 0;
    // int nextIndex = 1;
    // while (startingIndex < LENGTH - 1 && nextIndex < LENGTH) {
    //     if (a[nextIndex] == a[startingIndex]) {
    //         smallestIndex = nextIndex < smallestIndex ? nextIndex : smallestIndex;
    //     } else {
    //         ++nextIndex;
    //     }

    //     if (nextIndex == LENGTH) {
    //         ++startingIndex;
    //         nextIndex = startingIndex + 1;
    //     }
    // }

    // return smallestIndex;

    // TAKES TOO LONG O(n^2)
    // List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());;
    // List<Integer> indexes = new ArrayList<>();

    // int removed = 0;
    // while (removed < aList.size()) {
    //     int searching = aList.remove(removed++);
    //     int foundIndex = aList.indexOf(searching);
    //     if (foundIndex > -1)
    //         indexes.add(foundIndex + removed);
    // }

    // if (indexes.size() > 0) {
    //     Collections.sort(indexes);
    //     return a[indexes.get(0)];
    // }

    // return -1;
  }
}
