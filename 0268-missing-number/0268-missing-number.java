class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long total = (long) n * (n + 1) / 2;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (int) (total - sum);
    }
}