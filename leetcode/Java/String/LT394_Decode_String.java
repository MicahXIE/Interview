class Solution {
    public String decodeString(String s) {  // 6ms 15.36%
        String res = new String(s);
        Deque<Pair<Integer,Integer>> stack = new ArrayDeque<>();

        int index = 0;
        int repeat = 0;
        int start = 0;
        int i = 0;
        boolean flag = false;
        while (i < res.length()) {
            if (Character.isDigit(res.charAt(i)) && flag == false) {
                start = i;
                flag = true;
            }
            if (res.charAt(i) == '[') {
                repeat = Integer.parseInt(res.substring(start, i)); // 100[abc]
                stack.push(new Pair(i, repeat));
                flag = false;
            }
            if (res.charAt(i) == ']') {
                Pair<Integer, Integer> p = stack.pop();
                // System.out.println(p.getKey() + " " + p.getValue());
                repeat = p.getValue();
                String substr = res.substring(p.getKey() + 1, i);
                String str = "";
                while (repeat-- > 0) {
                    str += substr;
                }
                
                // out of range will be null value, is not a good way
                res = res.substring(0, p.getKey() - String.valueOf(p.getValue()).length()) + str + res.substring(i + 1);
                i = p.getKey() - 1 - String.valueOf(p.getValue()).length() + str.length();
                flag = false;
                // System.out.println(res);
            }
            i++;
        }
        
        return res;
    }
}