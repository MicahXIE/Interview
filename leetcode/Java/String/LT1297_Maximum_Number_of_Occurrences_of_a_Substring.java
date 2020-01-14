class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int start=0,result=0;
        int value=0;
        HashMap<String,Integer> count = new HashMap<>();
        HashMap<String,Integer> occurence = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            value = count.containsKey(String.valueOf(s.charAt(i))) ? count.get(String.valueOf(s.charAt(i))) : 0;
            count.put(String.valueOf(s.charAt(i)), value+1);
            if (i-start+1>minSize) {                 //Reduce the size of the window if increased to size.
                value = count.get(String.valueOf(s.charAt(start)));
                count.put(String.valueOf(s.charAt(start)), value-1);
                if (count.get(String.valueOf(s.charAt(start))) == 0)        //Remove the letter from map if count 0 to track unique letters.
                    count.remove(String.valueOf(s.charAt(start)));
                start++;
            }
            if (i-start+1==minSize && count.size()<=maxLetters) {  //When the substring in the window matches the constraints.
                value = occurence.containsKey(s.substring(start,start+minSize)) ? occurence.get(s.substring(start,start+minSize)) : 0;
                occurence.put(s.substring(start,start+minSize), value+1);
                result=Math.max(result, value+1); //Increase the occurence count of the string and get the max.
            }   
        }
        return result;
    }
}
