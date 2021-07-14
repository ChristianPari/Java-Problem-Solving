package intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class stock_maximize {
  public static void main(String[] args) {
    // insert an array of stock prices for x amount of days
    // days = 5 -> ex.. [1, 3, 5, 2, 4]
    // knowing the prices of the days to come, i return the largest possible profit
    System.out.println(stockmax(new ArrayList<>(Arrays.asList(1, 3, 5, 2, 4))));
  }


  public static long stockmax(List<Integer> prices) {

    if (prices.size() < 2) {
      return 0;
    }

    List<Integer> sorted = new ArrayList<>(prices);
    sorted.sort(Collections.reverseOrder());

    int highest_price = sorted.get(0);
    int price_index = prices.indexOf(highest_price);

    long total_profit = (long) (price_index) * highest_price;
    long total_spent = 0;

    int counter = 0;
    while (counter < price_index) {
      total_spent += prices.get(counter++);
    }

    long total_gain = total_profit - total_spent;
    prices = new ArrayList<>(prices.subList(price_index + 1, prices.size()));

    return total_gain + stockmax(prices);
  }

}