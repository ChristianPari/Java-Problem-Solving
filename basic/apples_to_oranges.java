import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

                // s = start of house
        // t = end of house
        // a = tree apples point
        // b = tree oranges point
        // apples[] = distances apples fell from tree
        // oranges[] = ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        // need to add "a" to each element within the array of apples
        // need to add "b" to ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ oranges
        // do these via a loop
        // if any of the elements within the arrays fall between the "s" and "t"
        // sout -> how many apples and oranges are within the range
        // created new arrays of apples and oranges with added distance from tree locations
        int[] newApples = new int[apples.length];
        int[] newOranges = new int[oranges.length];
        for (int i = 0; i < apples.length; i++) {
            newApples[i] = apples[i] + a;
        }
        for (int i = 0; i < oranges.length; i++) {
            newOranges[i] = oranges[i] + b;
        }
        // checking if any of the fruits fell into the inclusive range of "s" and "t"
        int applesInHouse = 0;
        int orangesInHouse = 0;
        for (int i = 0; i < newApples.length; i++) {
            if (newApples[i] >= s && newApples[i] <= t)
                applesInHouse += 1;
        }
        for (int i = 0; i < newOranges.length; i++) {
            if (newOranges[i] >= s && newOranges[i] <= t)
                orangesInHouse += 1;
        }
        System.out.println(applesInHouse);
        System.out.println(orangesInHouse);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}
