import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        
        // Handle edge cases
        if (numRows <= 0) {
            return answer;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);

        answer.add(new ArrayList<>(firstRow));

        for(int i = 1; i < numRows; i++) 
        {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1); // First element is always 1 

            // For row i, there are i-1 middle elements
            for(int j = 1; j < i; j++ )
            {
                int element = answer.get(i-1).get(j) + answer.get(i-1).get(j-1);
                currentRow.add(element);
            }

            currentRow.add(1);
            answer.add(new ArrayList<>(currentRow));
        }
        return answer;

    }
}