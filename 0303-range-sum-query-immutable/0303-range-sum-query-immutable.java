class NumArray {

    int prefix[];

    public NumArray(int[] nums) {

        int n = nums.length;
        prefix = new int[n];
        int sum  = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
    }

    //prefix[i] = sum of nums[0] to ith index

    //1 .. 3 = num[1] + num[2] + num[3]

    //prefix[3] = num[0] + num[1] + num[2] + num[3]
    //prefix[0] = num[0]

    public int sumRange(int left, int right) {

        if(left == 0) {
            return prefix[right];
        }
        else{
            return prefix[right] - prefix[left - 1];
        }
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
