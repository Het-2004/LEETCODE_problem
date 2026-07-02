class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates,
                           int target,
                           int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Base Case
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            // Stop if current number is too large
            if (candidates[i] > target)
                break;

            // Choose
            current.add(candidates[i]);

            // Recurse (move to next index)
            backtrack(candidates,
                      target - candidates[i],
                      i + 1,
                      current,
                      result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}