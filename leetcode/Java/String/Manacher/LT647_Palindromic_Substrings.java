class Solution {  // 2ms 92.01% time O(n^2) space O(1)
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            count += extendPalindromic(s, i, i);  // odd palindromic string
            count += extendPalindromic(s, i, i + 1);  // even palindromic string
        }
        
        return count;
    }
    
    private int extendPalindromic(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}