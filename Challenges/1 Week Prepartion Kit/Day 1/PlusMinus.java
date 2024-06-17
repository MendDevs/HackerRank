import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    // The plusMinus function calculates the ratios of positive, negative, and zero values in the array
    public static void plusMinus(List<Integer> arr) {
        int n = arr.size(); // Get the size of the array
        int countPositive = 0; // Initialize count for positive numbers
        int countNegative = 0; // Initialize count for negative numbers
        int countZero = 0;     // Initialize count for zeros

        // Loop through each number in the array
        for (int num : arr) {
            if (num > 0) {
                countPositive++; // Increment positive count
            } else if (num < 0) {
                countNegative++; // Increment negative count
            } else {
                countZero++;     // Increment zero count
            }
        }

        // Calculate the ratios and cast counts to double to get a floating point division
        double positiveRatio = (double) countPositive / n;
        double negativeRatio = (double) countNegative / n;
        double zeroRatio = (double) countZero / n;

        // Print the results with 6 decimal places
        System.out.printf("%.6f%n", positiveRatio);
        System.out.printf("%.6f%n", negativeRatio);
        System.out.printf("%.6f%n", zeroRatio);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // Reader for input

        int n = Integer.parseInt(bufferedReader.readLine().trim()); // Read the size of the array

        // Read the array elements, split by space, convert to integers, and collect to a list
        List<Integer> arr = Arrays.stream(bufferedReader.readLine().trim().split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        // Call the plusMinus function with the list of integers
        Result.plusMinus(arr);

        bufferedReader.close(); // Close the BufferedReader
    }
}
