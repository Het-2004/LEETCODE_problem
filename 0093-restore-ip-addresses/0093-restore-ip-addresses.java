import java.util.*;

class Solution {

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int index, List<String> path) {

        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            if (isValid(part)) {
                path.add(part);
                backtrack(s, index + len, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String part) {

        // Leading zero
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }

        int num = Integer.parseInt(part);

        return num >= 0 && num <= 255;
    }
}