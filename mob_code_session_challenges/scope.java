package mob_code_session_challenges;

import jdk.internal.org.jline.utils.DiffHelper;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Difference {
  private int[] elements;
  public int maximumDifference;

  // Add your code here
  public Difference(int[] arr) { elements = arr; }

  public void computeDifference() {
    Arrays.sort(elements);
    maximumDifference = elements[elements.length - 1] - elements[0];
  }

} // End of Difference class

public class scope {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    sc.close();

    Difference difference = new Difference(a);

    difference.computeDifference();

    System.out.print(difference.maximumDifference);
  }
}

/*
import java.io.*;
  import java.util.*;
  import java.text.*;
  import java.math.*;
  import java.util.regex.*;


class Difference {
  private int[] elements;
  public int maximumDifference;

  // Add your code here

  public Difference(int[] arr) {
    elements = arr;
  }

  public void computeDifference() {
    for (int num : elements) {
      for (int comparingNum : elements) {
        int diff = num > comparingNum ? num - comparingNum : comparingNum - num;
        maximumDifference = maximumDifference > diff ? maximumDifference : diff;
      }
    }
  }

} // End of Difference class

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    sc.close();

    Difference difference = new Difference(a);

    difference.computeDifference();

    System.out.print(difference.maximumDifference);
  }
}

 */