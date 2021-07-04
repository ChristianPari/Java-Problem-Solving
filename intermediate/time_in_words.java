package intermediate;

import java.util.HashMap;

public class time_in_words {

  public static void main(String[] args) {
    String result = Result5.timeInWords(1, 2);
    System.out.println(result);
  }
}

class Result5 {

  /*
   * Complete the 'timeInWords' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER h
   *  2. INTEGER m
   */
  private static HashMap<Integer, String> cons = createConversions();

  public static String timeInWords(int h, int m) {
    if (m == 0) return cons.get(h) + " o' clock";
    if (m == 15) return "quarter past " + cons.get(h);
    if (m == 30) return "half past " + cons.get(h);
    if (m == 45) return "quarter to " + cons.get(h + 1);

    if (m < 20) {
      String mins = cons.get(m);
      String ending = (m == 1 ? " minute" : " minutes") + " past ";
      String hour = cons.get(h);
      return mins + ending + hour;
    }

    if (m < 30) {
      int minsLeft = m % 10;
      String mins = "twenty " + cons.get(minsLeft);
      String ending = " minutes past ";
      String hour = cons.get(h);
      return mins + ending + hour;
    }

    int newMins = 60 - m;
    int minsLeft = newMins % 10;

    if (newMins > 19) {
      String mins = "twenty " + cons.get(minsLeft);
      String ending = " minutes to ";
      String hour = cons.get(h + 1);
      return mins + ending + hour;
    }

    String mins = cons.get(newMins);
    String ending = " minutes to ";
    String hour = cons.get(h + 1);

    return mins + ending + hour;
  }

  private static HashMap<Integer, String> createConversions() {
    HashMap<Integer, String> hash = new HashMap<>();
    hash.put(1, "one");
    hash.put(2, "two");
    hash.put(3, "three");
    hash.put(4, "four");
    hash.put(5, "five");
    hash.put(6, "six");
    hash.put(7, "seven");
    hash.put(8, "eight");
    hash.put(9, "nine");
    hash.put(10, "ten");
    hash.put(11, "eleven");
    hash.put(12, "twelve");
    hash.put(13, "thirteen");
    hash.put(14, "fourteen");
    hash.put(16, "sixteen");
    hash.put(17, "seventeen");
    hash.put(18, "eighteen");
    hash.put(19, "nineteen");
    hash.put(20, "twenty");
    return hash;
  }

}