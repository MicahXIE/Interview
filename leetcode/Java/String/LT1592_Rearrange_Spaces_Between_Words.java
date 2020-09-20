class Solution { // 1ms
    public String reorderSpaces(String text) {
        
        int w = 0, s = 0;
        int start = -1;
        boolean isWord = false;
        List<String> str = new ArrayList<String>();
        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) == ' ') {
                if (start != -1 && isWord)
                    str.add(text.substring(start, i));
                isWord = false;
                s++;
            } else {
                if (!isWord) {
                    start = i;
                    w++;
                }
                isWord = true;
                if (i == text.length() - 1)
                    str.add(text.substring(start));
            }
        }
        
        int gap, rem;
        if (w <= 1) {
            gap = 0;
            rem = s;
        } else {
            gap = s / (w - 1);
            rem = s % (w - 1);
        }
        
        int index = 1;
        String res = "";
        for (String word : str) {
            res += word;
            if (index <= (w - 1)) {
                for (int i = 0; i < gap; ++i)
                    res += " ";
                index++;
            }

        }
        for (int i = 0; i < rem; ++i)
            res += " ";
        
        return res;
    }
}