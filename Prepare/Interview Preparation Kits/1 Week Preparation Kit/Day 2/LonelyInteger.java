///////////////////////////// Lonely Integer by Hacker Rank ////////////////////////////////////////////////////////

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Method one: XOR
        int result = 0;
        for (int n : a) {
            result ^= n; // XOR Operation to find the unique / lonely integer
        }
        return result;
        
        // Method two: following the constraints:
        /*
        int n = a.size();
        
        // Check if n is odd:
        if (n % 2 == 0) {
            throw new IllegalArgumentException("The number of elements of the list must be odd.");
        }
        
        // Check if all elements are within the range of [0, 100]
        for (int i : a) {
            if (i < 0 || i > 100) {
                throw new IllegalArgumentException("Out of bounds.");
            }
        }
        
        int[] occurences = new int[101];
        for (int num : a) {
            occurences[num]++;
        }
        
        // Find the unique element
        for (int i = 0; i < occurences.length; i++) {
            if (occurences[i] == 1) {
                return i;
            }
        }
        
        throw new IllegalStateException("No lonely integer found.");
        */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
