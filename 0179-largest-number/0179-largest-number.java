class Solution {
    public String largestNumber(int[] nums) {
        
        ArrayList<String> arr = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i<n; i++){
            arr.add(Integer.toString(nums[i]));
        }

        Collections.sort(arr, (x, y) -> {
            String X = x + y;
            String Y = y + x;
            return Y.compareTo(X);
        });
        
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i< n; i++){
            answer.append(arr.get(i));
        }

        int i = 0;
        while (i < n  && answer.charAt(i) == '0')
        {
            i++;
        }

        if(i == n)
        {
            return "0";
        }

        return answer.toString();
    }
}