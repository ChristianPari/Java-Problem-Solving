package cli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ocean_view {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String apartmentsStr = sc.next();
    List<Integer> apartmentsList = new ArrayList<>();

    for (String apartment : apartmentsStr.split("")) {
      apartmentsList.add(Integer.parseInt(apartment));
    }

    getOceanViews(apartmentsList);
  }

  private static void getOceanViews(List<Integer> aptList) {

    List<Integer> oceanViews = new ArrayList<>();
    oceanViews.add(aptList.size() - 1); // automatically has ocean view
    int tallestApt = 0; // which ever is tallest
    for (Integer apt : aptList) {
      tallestApt = apt > tallestApt ? apt: tallestApt;
    }
    oceanViews.add(aptList.indexOf(tallestApt));

    for (int index = aptList.indexOf(tallestApt) + 1; index < aptList.size(); index++) {
      for (int testing = index + 1; testing < aptList.size(); index++) {
        if (aptList.get(index) <= aptList.get(testing)) {
          break;
        }

        if (testing == aptList.size() - 1 && (aptList.get(index) > aptList.get(testing))) {
          oceanViews.add(index);
        }
      }
    }

    Collections.sort(oceanViews);
    String output = "";
    for (Integer idx : oceanViews) {
      if (idx == oceanViews.size() - 1) {
        output += "and ";
      }
      output += idx + " ";
    }
    System.out.println(output + "have at least some apartments with an unobstructed ocean view and should be marked as such.");
  }
}
