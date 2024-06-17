////////////////////////////////////////////////////// Time Conversion  //////////////////////////////////////////////////////////////////////////////////////////

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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Extract the period of the day (Either AM or PM)
        String period = s.substring(s.length() - 2);
        
        // Extract the hour, minute, and second parts of the time string
        String hStr = s.substring(0, 2); // hour string
        String mStr = s.substring(3, 5); // minute string
        String sStr = s.substring(6, 8); // second string
        
        // Convert the hour string to an integer
        int h = Integer.parseInt(hStr);
        
        // Conversion logic
        if (period.equals("AM")) {
            if (h == 12) {
                h = 0; // Midnight case
            }
        } else if (period.equals("PM")) {
            if (h != 12) {
                h += 12; // Convert PM hours to 24-hour format
            }
        }
        
        // Format the hour to ensure it has two digits
        String hFormat = String.format("%02d", h);
        
        // Return the combined strings
        return hFormat + ":" + mStr + ":" + sStr;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
