class Solution {
    public String frequencySort(String s) {
        
        // Use HashMap to count frequency of all characters
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            freqMap.put(currentCharacter, freqMap.getOrDefault(currentCharacter, 0) + 1);
        }

        // Create list of [character, frequency] pairs
        ArrayList<ArrayList<Object>> arr = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            ArrayList<Object> currentRow = new ArrayList<>();
            currentRow.add(entry.getKey());
            currentRow.add(entry.getValue());
            arr.add(currentRow);
        }

        // Sort by frequency in descending order
        Collections.sort(arr, (x, y) -> Integer.compare((Integer)y.get(1), (Integer)x.get(1)));

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < arr.size(); i++) {
            int frequency = (Integer)arr.get(i).get(1);
            char ch = (Character)arr.get(i).get(0);

            while(frequency > 0) {
                str.append(ch);
                frequency--;
            }
        }
        return str.toString();
    }
}
