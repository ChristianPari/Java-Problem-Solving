import java.util.ArrayList;
import java.util.List;

public class findTheDifferences {
  public void solution() {
    /*

Compare two arrays and return a new array with any items only found in one of the two given arrays, but not both. In other words, return the symmetric difference of the two arrays.

    */
    List<Integer> testArray1 = new ArrayList<>();
    testArray1.add(1);
    testArray1.add(2);
    testArray1.add(3);
    testArray1.add(5);
    List<Integer> testArray2 = new ArrayList<>();
    testArray2.add(1);
    testArray2.add(2);
    testArray2.add(3);
    testArray2.add(4);
    testArray2.add(5);
    System.out.println(differences(testArray1, testArray2));

  }

  private List<Integer> differences(List<Integer> arr1, List<Integer> arr2)
  {

    List<Integer> diffs = new ArrayList<>();
    for (int elm : arr1) {
      if (!arr2.contains(elm)) {
        diffs.add(elm);
      }
    }
    for (int elm : arr2) {
      if (!arr1.contains(elm)) {
        diffs.add(elm);
      }
    }

    return diffs;

  }

}