public class Main {
    public static int findMaxSubarray(int[] arr, int k) {
        int maxValue = Integer.MIN_VALUE;
        int currentRunningSum = 0;

        for(int i = 0; i < arr.length; i++) {
            currentRunningSum += arr[i];
            if(i >= k-1) {
                maxValue = Math.max(maxValue, currentRunningSum);
                currentRunningSum -= arr[i - (k - 1)];
            }
        }
        return maxValue;
    }

    public static int smallSubArray(int[] input, int targetSum) {
        int minWindowSize = Integer.MAX_VALUE;
        int windowStart = 0;
        int currentWindowSum = 0;
        for(int windowEnd = 0; windowEnd < input.length; windowEnd++) {
            currentWindowSum += input[windowEnd];

            while(currentWindowSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= input[windowStart];
                windowStart+=1;
            }
        }
        return minWindowSize;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSubarray(new int[] {4, 2, 1, 7, 8, 1, 2, 8, 1, 0}, 3));
        int targetSum = 8;
        int[] input = new int[] {4, 2, 2, 7, 8, 1, 2, 8, 1, 0};
        System.out.println(smallSubArray(input, targetSum));
    }
}
