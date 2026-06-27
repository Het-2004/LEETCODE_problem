class Solution {
    public int numFriendRequests(int[] ages) {
        // Count frequency of each age
        int[] count = new int[121]; // ages range from 1 to 120
        for (int age : ages) {
            count[age]++;
        }
        
        int totalRequests = 0;
        
        // For each age x, find valid ages y that x can send requests to
        for (int ageX = 1; ageX <= 120; ageX++) {
            if (count[ageX] == 0) continue;
            
            for (int ageY = 1; ageY <= 120; ageY++) {
                if (count[ageY] == 0) continue;
                
                // Check if x can send request to y
                if (canSendRequest(ageX, ageY)) {
                    if (ageX == ageY) {
                        // Same age: each person can send to others with same age
                        // count[ageX] people, each can send to (count[ageX] - 1) others
                        totalRequests += count[ageX] * (count[ageX] - 1);
                    } else {
                        // Different ages: all people with ageX can send to all with ageY
                        totalRequests += count[ageX] * count[ageY];
                    }
                }
            }
        }
        
        return totalRequests;
    }
    
    private boolean canSendRequest(int ageX, int ageY) {
        // Person x will NOT send request to y if any of these is true:
        // 1. ageY <= 0.5 * ageX + 7
        // 2. ageY > ageX
        // 3. ageY > 100 && ageX < 100
        
        if (ageY <= 0.5 * ageX + 7) return false;
        if (ageY > ageX) return false;
        if (ageY > 100 && ageX < 100) return false;
        
        return true;
    }
}