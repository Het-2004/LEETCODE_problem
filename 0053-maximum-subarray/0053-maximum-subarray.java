class Solution {
    public int maxSubArray(int[] arr) {
        int currentSum = arr[0];
        int maximumSum = arr[0];

        for(int i =1; i< arr.length; i++) {
            int option1 = arr[i];
            int option2 = arr[i] + currentSum;

            currentSum = Math.max(option1, option2);

            if (currentSum > maximumSum) {
                maximumSum = currentSum;
                
            }
        }
        return maximumSum;
    }
}
