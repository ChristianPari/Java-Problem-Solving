package mob_code_session_challenges;
import java.util.*;

public class dictionaries_and_maps {
  /*
  Given n names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers.
  You will then be given an unknown number of names to query your phone book for.
  For each name queried, print the associated entry from your phone book on a new line in the form name=phoneNumber;
  if an entry name for is not found, print Not found instead.
   */

  final static int NAME = 0;
  final static int PHONE = 1;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Map<String, Integer> phonebook = new HashMap<>();
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      String name = sc.next();
      int phone = sc.nextInt();
      phonebook.put(name, phone);
    }
    while (sc.hasNext()) {
      String name = sc.next();
      Integer phone = phonebook.get(name);
      System.out.println(phone != null ? name + "=" + phone : "Not found");
    }
    sc.close();
  }
}
