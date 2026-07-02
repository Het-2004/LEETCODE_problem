class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, k, n, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start,
                           int k,
                           int target,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Base Case
        if (target == 0 && current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Invalid Case
        if (target < 0 || current.size() > k) {
            return;
        }

        for (int i = start; i <= 9; i++) {

            // Choose
            current.add(i);

            // Recurse
            backtrack(i + 1,
                      k,
                      target - i,
                      current,
                      result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}