/////////////////////////////// Palindrom Index by Hacker Rank ///////////////////////////

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
     
    private static boolean isPali(char[] chars, int l, int r){
        while(l < r) {
            if(chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    public static int palindromeIndex(String s) {
        int length = s.length();
        char[] ch = s.toCharArray();
        for(int i = 0; i < length / 2; i++) {
            if(ch[i] != ch[length - 1 - i]) {
                if(isPali(ch, i + 1, length - 1 - i)) {
                    return i;
                } else if(isPali(ch, i, length - 2 - i)) {
                    return length - 1 - i;
                } else {
                    return -1;
                }
            }
        }
        return -1; // If the string is already a palindrome
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


