/*
Find the amount of dots within the triangle pattern when given the triangle number

Ex
Tri 1 = 1 dots
Tri 2 = 3 dots
Tri 3 = 6 dots
Tri 4 = 10 dots
Tri 5 = 15 dots
*/

// notes bc im a little rusty since it's been a while

// always create your public class
public class triangular_number_sequence {
  
    // always need a main main method that is used to run your code
    public static void main(String args[]) {
      int triangle = 6;
      gen_dots(triangle);
    }

  // create your needed methods from within
  // if returning a data type enusre to replace 'void' with correct data type
  public static int gen_dots(int num) {

    int answer = (num * (num + 1)) / 2;

    System.out.println(answer);

    return answer;

  }

}
