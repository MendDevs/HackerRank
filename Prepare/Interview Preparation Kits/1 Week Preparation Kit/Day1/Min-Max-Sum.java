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
        long totalSum = 0L;  // totalSum to hold the sum of all elements
        int minElement = Integer.MAX_VALUE;  // minElement to track the minimum value
        int maxElement = Integer.MIN_VALUE;  // maxElement to track the maximum value
        
        // Calculate total sum, min, and max elements
        for (int num : arr) {
            totalSum += num;  // Add current element to totalSum
            if (num < minElement) {  // Update minElement if current element is smaller
                minElement = num;
            }
            if (num > maxElement) {  // Update maxElement if current element is larger
                maxElement = num;
            }
        }
        
        // Calculate minimum sum by subtracting maxElement from totalSum
        long minSum = totalSum - maxElement;
        // Calculate maximum sum by subtracting minElement from totalSum
        long maxSum = totalSum - minElement;
        
        // Print the results
        System.out.println(minSum + " " + maxSum);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read input from user, split into integers, and collect into a List
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        // Call miniMaxSum function with the input array
        Result.miniMaxSum(arr);

        bufferedReader.close();  // Close the BufferedReader
    }
}
