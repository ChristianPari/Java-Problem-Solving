package mob_code_session_challenges;

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

public class binary_numbers {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String binary = Integer.toString(n, 2); // "11101"
    String[] binary_array = binary.split("0"); // ["111", "1"]
//    Arrays.sort(binary_array); // ["1", "111"]
//    System.out.println(binary_array[binary_array.length - 1].length());
    System.out.println(Collections.max(Arrays.asList(binary_array)).length());

    bufferedReader.close();
  }
}

// CODE PRIOR TO LEARNING THE BUILT IN METHODS

//package mob_code_session_challenges;
//
//  import java.io.*;
//  import java.math.*;
//  import java.security.*;
//  import java.text.*;
//  import java.util.*;
//  import java.util.concurrent.*;
//  import java.util.regex.*;
//
//public class binary_numbersT {
//  private static final Scanner scanner = new Scanner(System.in);
//
//  public static void main(String[] args) {
//    int n = scanner.nextInt();
//    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//    solution(n);
//    scanner.close();
//  }
//
//  public static void solution(int n) {
//    String binary = "";
//    int binaryLength = getLength(n);
//    int placeholder = n;
//    while (placeholder > 0) {
//      int curBinaryBit = getBinaryDigit(binaryLength);
//      if (placeholder >= curBinaryBit) {
//        binary += "1";
//        placeholder -= curBinaryBit;
//      } else {
//        binary += "0";
//      }
//      binaryLength--;
//    }
//    String[] arrayOfOnes = binary.split("0");
//    int consecutiveOnes = 0;
//    for (String ones : arrayOfOnes) {
//      if (ones.length() > consecutiveOnes) {
//        consecutiveOnes = ones.length();
//      }
//    }
//    System.out.println(consecutiveOnes);
//  }
//
//  public static int getLength(int n) {
//    int count = 1;
//    while (n / 2 >= 1) {
//      count++;
//      n /= 2;
//    }
//    return count;
//  }
//
//  private static int getBinaryDigit(int count) {
//    int num = 1;
//    for (int start = 1; start < count; start++) {
//      num *= 2;
//    }
//    return num;
//  }
//}
