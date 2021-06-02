package intermediate;

import java.util.ArrayList;
import java.util.List;

public class count_and_say {
  public static void main(String[] args) {
    int n = 10000;

    String answer = "1";
    int count = 1;

    while (count < n) {
      List<String> say = new ArrayList<>();
      for (int index = 0; index < answer.length(); index++) {
        int currentChar = Character.getNumericValue(answer.charAt(index));

        if (index == 0) {
          say.add("1" + currentChar);

        } else {
          if (currentChar == Character.getNumericValue(answer.charAt(index - 1))) {
            int freqs = Character.getNumericValue(say.get(say.size() - 1).charAt(0)) + 1;
            int num = Character.getNumericValue(say.get(say.size() - 1).charAt(1));

            String combined = Integer.toString(freqs) + Integer.toString(num);

            say.remove(say.size() - 1);
            say.add(combined);
          } else {
            say.add("1" + currentChar);
          }
        }
      }

      answer = String.join("", say);
      count++;
    }

    System.out.println(answer);;
  }
}
