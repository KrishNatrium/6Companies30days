class Solution {
    private int maxPro = 0;

    public int maxProduct(String s) {
        findMaxProduct(s, 0, "", "");
        return maxPro;
    }

    private void findMaxProduct(String s, int i, String s1, String s2) {
        // Base case: If we've processed all characters
        if (i == s.length()) {
            if (isPalindrome(s1) && isPalindrome(s2)) {
                maxPro = Math.max(maxPro, s1.length() * s2.length());
            }
            return;
        }

        // Recursion to find all possibilities
        findMaxProduct(s, i + 1, s1 + s.charAt(i), s2);
        findMaxProduct(s, i + 1, s1, s2 + s.charAt(i));
        findMaxProduct(s, i + 1, s1, s2);
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
