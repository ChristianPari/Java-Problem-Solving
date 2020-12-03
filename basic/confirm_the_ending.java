public class confirm_the_ending {
  // check if a string ends with a given target string
  public static void main(String[] args) {
    System.out.println(confirmEnding("Open sesame", "same"));
  }

  public static boolean confirmEnding(
      String str,
      String target
  ) {
    int targetLength = target.length();
    int strEndingWithTargetLength = str.length() - targetLength;
    String strEnding = str.substring(strEndingWithTargetLength);
    return target.equals(strEnding);
  }
}
