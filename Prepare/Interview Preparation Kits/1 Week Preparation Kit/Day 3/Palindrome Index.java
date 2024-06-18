/////////////////////////////// Palindrom Index by Hacker Rank ///////////////////////////

import java.io.*;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    
    // Function to find the index of the character to remove to make the string a palindrome
    public static int palindromeIndex(String s) {
        int n = s.length();
        
        // Iterate from the start to the middle of the string
        for (int i = 0; i < n / 2; i++) {
            // If characters at current index and its mirror index are not equal
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                // Check if removing the character at the current index forms a palindrome
                if (isPalindrome(s, i + 1, n - 1 - i)) {
                    return i;
                // Check if removing the character at the mirror index forms a palindrome
                } else if (isPalindrome(s, i, n - 2 - i)) {
                    return n - 1 - i;
                } else {
                    // If neither removal forms a palindrome, return -1
                    return -1;
                }
            }
        }
        
        // If the string is already a palindrome or no single character removal can make it a palindrome
        return -1;
    }

    // Helper function to check if a substring s[left:right+1] is a palindrome
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Read the number of queries
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        // Process each query
        IntStream.range(0, q).forEach(qItr -> {
            try {
                // Read the string for the current query
                String s = bufferedReader.readLine();

                // Get the result from the palindromeIndex function
                int result = Result.palindromeIndex(s);

                // Write the result to the output
                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Close the bufferedReader and bufferedWriter
        bufferedReader.close();
        bufferedWriter.close();
    }
}

