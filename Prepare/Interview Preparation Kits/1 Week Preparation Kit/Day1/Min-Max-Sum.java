////////////////////////////////////////////////////// Min-Max Sum  //////////////////////////////////////////////////////////////////////////////////////////


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Initialize variables
        long Fsum = 0L; // Represents the sum of all integers in the array
        int minInt = Integer.MAX_VALUE; // Initialize to the maximum possible integer value
        int maxInt = Integer.MIN_VALUE; // Initialize to the minimum possible integer value
        
        // Iterate through the array to calculate sum and find min/max integers
        for (int i : arr) {
            Fsum += i; // Add current integer to the total sum
            if (i < minInt) { // Check if current integer is smaller than the current minimum
                minInt = i; // Update minimum if necessary
            }
            if (i > maxInt) { // Check if current integer is larger than the current maximum
                maxInt = i; // Update maximum if necessary
            }
        }
        
        // Calculate the sums excluding the min and max integers
        long sumMin = Fsum - maxInt;
        long sumMax = Fsum - minInt;
        
        // Print the results
        System.out.println(sumMin + " " + sumMax);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read input integers from the user and convert them to a list
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        // Call the miniMaxSum function with the input list
        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
