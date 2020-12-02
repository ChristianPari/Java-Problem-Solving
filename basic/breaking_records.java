import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class breaking_records {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {

                // create vars: min, max, minCount, maxCount
        // loop through array, 0th index assign min and max
            // each folloing index compare aganist min and max
                // if less or greater changes min/max and update minCount/maxCount
        // print maxCount then minCount
        int min = 0;
        int max = 0;
        int min_count = 0;
        int max_count = 0;
        for (int i = 0; i < scores.length; i++) {
            // if "i" is first index -> set min and max to begin checking scores
            if (i == 0) {
                min = scores[i];
                max = scores[i];
            } else if (scores[i] < min) {
                // if less than min -> breaks min record -> add 1 to min_count and change min
                min_count += 1;
                min = scores[i];
            } else if (scores[i] > max) {
                // if greater than max -> breaks max record -> add 1 to max_count and change max
                max_count += 1;
                max = scores[i];
            }
        }

        int[] result = {max_count, min_count};
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
