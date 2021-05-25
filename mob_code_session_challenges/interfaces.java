package mob_code_session_challenges;

import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
  int divisorSum(int n);
}

class Calculator2 implements AdvancedArithmetic {
  public int divisorSum(int n) {
    int sum = 0;

    for (int num = 1; num <= (n / 2); num++) {
      if (n % num == 0)
        sum += num;
    }

    return sum + n;
  }
}

public class interfaces {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    scan.close();

    AdvancedArithmetic myCalculator = new Calculator2();
    int sum = myCalculator.divisorSum(n);
    System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
    System.out.println(sum);
  }
}

/*import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
   int divisorSum(int n);
}
class Calculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int sum = 0;
      for (int digit = 1; digit <= n; digit++) {
        if (n % digit == 0) {
          sum += digit;
        }
      }
      return sum;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

      	AdvancedArithmetic myCalculator = new Calculator();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}

 */