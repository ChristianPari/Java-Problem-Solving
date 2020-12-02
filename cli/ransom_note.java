import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ransom_note {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

      // need to compare each vector and check if every letter from the note is within the magazine

      // maybe...
      // loop through note, check if the letter is within magizine
      // if yes, then remove that letter from the magazine
      // continue until all pass or fails
      // use indexOf(Object o) to find the note letter in magazine
      // if is included in magazine, use remove(int index) to remove the letter from the magazine
      // all pass through, return "Yes"
      // if this indexOf(Obejct o) ever returns -1 then the letter isnt within the vector and we return "No"
      boolean allPassed = true;
      String[] magazineToCheck = magazine;
      for (String letter : note) {
        int indexInMag = getLetterIndex(magazineToCheck, letter);
        if (indexInMag == -1) {
          allPassed = false;
        } else {
          magazineToCheck = removeElement(magazineToCheck, indexInMag);
        }
      }
      if (allPassed == true) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }

    private static String[] removeElement(String[] arr, int indexToRemove) {
      String[] newArr = new String[arr.length - 1];
      for (int count = 0, newIdx = 0; count < arr.length; count++) {
        if (count == indexToRemove)
          continue;
        else {
          newArr[newIdx++] = arr[count];
        }
      }
      return newArr;
    }

    private static int getLetterIndex(String[] arr, String letter) {
      int number = -1;
      for (int count = 0; count < arr.length; count++) {
        if (arr[count].equals(letter)) {
          number = count;
          break;
        }
      }
      return number;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      String[] mn = scanner.nextLine().split(" ");

      int m = Integer.parseInt(mn[0]);

      int n = Integer.parseInt(mn[1]);

      String[] magazine = new String[m];

      String[] magazineItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < m; i++) {
        String magazineItem = magazineItems[i];
        magazine[i] = magazineItem;
      }

      String[] note = new String[n];

      String[] noteItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        String noteItem = noteItems[i];
        note[i] = noteItem;
      }

      checkMagazine(magazine, note);

      scanner.close();
    }
}
