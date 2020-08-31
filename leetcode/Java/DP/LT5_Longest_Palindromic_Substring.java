class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        
        int n = s.length();   // get length of input string 
  
        // table[i][j] will be false if substring str[i..j] 
        // is not palindrome. 
        // Else table[i][j] will be true 
        boolean table[][] = new boolean[n][n]; 
  
        // All substrings of length 1 are palindromes 
        int maxLength = 1; 
        for (int i = 0; i < n; ++i) 
            table[i][i] = true; 
  
        // check for sub-string of length 2. 
        int start = 0; 
        for (int i = 0; i < n - 1; ++i) { 
            if (s.charAt(i) == s.charAt(i + 1)) { 
                table[i][i + 1] = true; 
                start = i; 
                maxLength = 2; 
            } 
        } 
          
        // Check for lengths greater than 2. k is length 
        // of substring 
        for (int k = 3; k <= n; ++k) { 
              
                  // Fix the starting index 
            for (int i = 0; i < n - k + 1; ++i)  
            { 
                // Get the ending index of substring from 
                // starting index i and length k 
                int j = i + k - 1; 
  
                // checking for sub-string from ith index to 
                // jth index iff str.charAt(i+1) to  
                // str.charAt(j-1) is a palindrome 
                if (table[i + 1][j - 1] && s.charAt(i) ==  s.charAt(j)) { 
                    table[i][j] = true; 
  
                    if (k > maxLength) { 
                        start = i; 
                        maxLength = k; 
                    } 
                } 
            } 
        } 

        return s.substring(start, start+maxLength);
    }
}

// Runtime: 37 ms, faster than 41.20% of Java online submissions for Longest Palindromic Substring.
// Memory Usage: 46.6 MB, less than 6.45% of Java online submissions for Longest Palindromic Substring.

