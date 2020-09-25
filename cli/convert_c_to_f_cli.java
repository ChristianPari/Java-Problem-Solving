// need to import the java util '*' to get access to Scanner class for the use of user input
import java.util.*;

public class convert_c_to_f_cli {
  
  public static void main(String[] args) {
    // define a new instance of the Scanner class
    Scanner sc = new Scanner(System.in);
    System.out.print("\nWould you like to convert Celsius to Fahrenheit or vice versa?\n(c-f or f-c): ");
    String response = sc.next();

    // passes response string into the switch to run the correct processes
    switch (response) {
      case "c-f":
        System.out.print("\nEnter celsius: ");
        int celsius = sc.nextInt();
        sc.close();
        System.out.println("\nFahrenheit");
        System.out.println(convert_c(celsius));
        break;

      case "f-c":
        System.out.print("\nEnter fahrenheit: ");
        int fahrenheit = sc.nextInt();
        sc.close();
        System.out.println("\nCelsius");
        System.out.println(convert_f(fahrenheit));
        break;
    
      default:
        System.out.println("\nYou needed to enter 'c-f' or 'f-c'. You're input is below:");
        System.err.println(response);
        break;
    }
  }

  public static int convert_c(int celsius) {
    int fahrenheit = (celsius / 5) * 9 + 32;
    return fahrenheit;
  }

  public static int convert_f(int fahrenheit) {
    int celsius = (fahrenheit - 32) * 5 / 9;
    return celsius;
  }

}
