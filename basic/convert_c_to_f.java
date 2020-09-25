public class convert_c_to_f {
  public static void main(String[] args) {
    System.out.println(convert(0));
  }

  public static int convert(int celsius) {
    int fahrenheit = celsius * 9 / 5 + 32;
    return fahrenheit;
  }
  
}
