class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        
        if (n % 2 == 0) {
            throw new IllegalArgumentException("Array size must be odd");
        }
        
        Collections.sort(arr);
        
        int medianIndex = n / 2;
        int median = arr.get(medianIndex);
        
        return median;
    }
}
