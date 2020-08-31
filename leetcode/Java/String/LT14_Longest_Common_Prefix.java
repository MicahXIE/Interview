class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return null;   
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<strs.length; i++) {
            if (strs[i].length() < min)
                min = strs[i].length();
        }
        int index;
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<min; j++) {
            char s = strs[0].charAt(j);
            for (index=1; index<strs.length; index++) {
                if (strs[index].charAt(j) == s)
                    continue;
                else
                    break;
            }
            if (index == strs.length) {
                sb.append(s);
            } else {
                break;
            }
        }
        
        return sb.toString();        
    }
}