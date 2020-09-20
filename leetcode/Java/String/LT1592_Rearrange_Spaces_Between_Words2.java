class Solution { // 3ms
    public String reorderSpaces(String t) {
        String[] ws = t.split("\\s+", -1);
        int cnt = 0, wcnt = ws.length, len = t.length();
        List<String> list = new ArrayList<>();
        for (String w : ws) if (w.length() > 0) list.add(w);
        wcnt = list.size();
        for (int i = 0; i < len; i++) {
            if (t.charAt(i) == ' ') cnt++;
        }
        if (wcnt == 1) {
            String res = list.get(0);
            for (int i = 0; i < cnt; i++) res = res + " ";
            return res;
        }
        int del = cnt / (wcnt - 1), rem = cnt % (wcnt - 1);
        StringBuilder dl = new StringBuilder(), rm = new StringBuilder(), res = new StringBuilder();
        for (int i = 0; i < del; i++) dl.append(' ');
        for (int i = 0; i < rem; i++) rm.append(' ');
        String delim = dl.toString(), tail = rm.toString();
        for (int i = 0; i < wcnt - 1; i++) {
            res.append(list.get(i)).append(delim);
        }
        return res.append(list.get(wcnt - 1)).append(tail).toString();
    }
}