import java.util.Arrays;

class Main {
  public static void main(String args[]) {
    /*

We'll pass you an array of two numbers. Return the sum of those two numbers plus the sum of all the numbers between them. The lowest number will not always come first.

For example, sumAll([4,1]) should return 10 because sum of all the numbers between 1 and 4 (both inclusive) is 10.

    */
    int[] testArray = {5, 10};
    System.out.println(sumAll(testArray));

  }

  public static int sumAll(int[] numbers) {
    // once I researched the sort method
    Arrays.sort(numbers);
    int sum = 0;
    for (int number = numbers[0]; number <= numbers[1]; number++) {
      sum += number;
    }

    return sum;

    // first way
    //   boolean firstSmallest = numbers[0] < numbers[1] ? true : false;

    //   int sum = 0;

    //   if (firstSmallest) {
    //       for (int number = numbers[0]; number <= numbers[1]; number++) {
    //           sum += number;
    //       }
    //   } else {
    //       for (int number = numbers[1]; number <= numbers[0]; number++) {
    //           sum += number;
    //       }
    //   }

    //   return sum;
  }
}