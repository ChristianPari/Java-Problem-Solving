package cli;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ransom_note_v2 {

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
   HashMap<String, Integer> hashedMag = new HashMap<>();
   for (String letter : magazine) {
     if (hashedMag.containsKey(letter)) {
       hashedMag.replace(letter, hashedMag.get(letter) + 1);
       continue;
     }

     hashedMag.put(letter, 1);
   }

   for (String letter : note) {
     if (!hashedMag.containsKey(letter)) {
       System.out.println("No");
       return;
     }

     if (hashedMag.get(letter) == 0) {
       System.out.println("No");
       return;
     }

     hashedMag.replace(letter, hashedMag.get(letter) - 1);
   }

    System.out.println("Yes");
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
