class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int answer[] = new int[n];

        int index = n-1;
        int i =0;
        int j = n-1;

        while(i <= j){
            if(Math.abs(nums[i]) > Math.abs(nums[j]))
            {
                answer[index] = nums[i] * nums[i];
                i++;
            }
            else
            {
                answer[index] = nums[j] * nums[j];
                j--;
            }
            index--;
        }

        return answer;
    }
}