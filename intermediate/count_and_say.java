package intermediate;

import java.util.ArrayList;
import java.util.List;

public class count_and_say {
  public static void main(String[] args) {
    int n = 10000;

    String answer = "1";
    int count = 1;

    while (count < n) {
      // TAKES LONGER
//      List<String> say = new ArrayList<>();
//      for (int index = 0; index < answer.length(); index++) {
//        int currentChar = Character.getNumericValue(answer.charAt(index));
//
//        if (index == 0) {
//          say.add("1" + currentChar);
//
//        } else {
//          if (currentChar == Character.getNumericValue(answer.charAt(index - 1))) {
//            int freqs = Character.getNumericValue(say.get(say.size() - 1).charAt(0)) + 1;
//            int num = Character.getNumericValue(say.get(say.size() - 1).charAt(1));
//
//            String combined = Integer.toString(freqs) + Integer.toString(num);
//
//            say.remove(say.size() - 1);
//            say.add(combined);
//          } else {
//            say.add("1" + currentChar);
//          }
//        }
//      }
//
//      answer = String.join("", say);

      // FASTER CODE
      String say = "";
      int freqs = 0;

      char currentNumber = answer.charAt(0);
      for (char currentChar : answer.toCharArray()) {
        if (currentChar == currentNumber) {
          freqs++;
        } else {
          say = say.concat(String.valueOf(freqs) + String.valueOf(currentNumber));
          currentNumber = currentChar;
          freqs = 1;
        }
      }

      answer = say.concat(String.valueOf(freqs) + String.valueOf(currentNumber));
      count++;
    }

    System.out.println(answer);;
  }
}
