//////////////////////////////////////////// Hacker Rank Truck Tour Problem //////////////////////////

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {

       /* Another method 


class Result {


    public static int truckTour(List<List<Integer>> petrolpumps) {
    // Write your code here
    int n = petrolpumps.size();int totalSurplus=0; int currentSurplus=0;int startingPump=0;
    for(int i=0; i<n; i++){
        int petrol = petrolpumps.get(i).get(0);
        int distance= petrolpumps.get(i).get(1);
        totalSurplus += petrol - distance;
        currentSurplus += petrol - distance;
        
        if(currentSurplus<0){
            startingPump = i+1;
            currentSurplus = 0;
        }
    }
    return totalSurplus >=0? startingPump:-1;
    }

}
*/

        
        // Write your code here
        int totalPetrol = 0;
        int totalDistance = 0;
        int startIndex = 0;
        int currentBalance = 0;
        int n = petrolpumps.size();
        
        for (int i = 0; i < n; i++) {
            int petrol = petrolpumps.get(i).get(0);
            int distance = petrolpumps.get(i).get(1);
            
            totalPetrol += petrol;
            totalDistance += distance;
            currentBalance += petrol - distance;
            
            if (currentBalance < 0) {
                startIndex = i + 1;
                currentBalance = 0;
            }
        }
        
        if (totalPetrol < totalDistance) {
            return -1;  // It's not possible to complete the tour
        }
        
        return startIndex;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
