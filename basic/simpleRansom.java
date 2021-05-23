package basic;

import java.util.HashMap;

public class simpleRansom {
  public static void main(String[] args) {
    System.out.println(simpleRansom("ac", "abc"));
  }

  public static boolean simpleRansom(String message, String source) {
    HashMap<String, Integer> letterCount = new HashMap<>();
    String[] sourceArray = source.split("");

    for (String letter : sourceArray) {
      if (letter.equals(" ")) {
        continue;
      }

      if (letterCount.containsKey(letter)) {
        letterCount.replace(letter, letterCount.get(letter) + 1);
        continue;
      }

      letterCount.put(letter, 1);
    }

    String[] messageArray = message.split("");
    for (String letter : messageArray) {
      if (!letterCount.containsKey(letter)) return false;

      if (letterCount.get(letter) == 0) return false;

      letterCount.replace(letter, letterCount.get(letter) - 1);
    }

    return true;
  }

}
