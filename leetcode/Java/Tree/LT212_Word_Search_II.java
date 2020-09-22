class Solution {  // 9ms 90.22%
    
    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        List<String> res = new ArrayList<>();
        TrieNode root = buildTries(words);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    public void dfs(char[][] board, int x, int y, TrieNode p, List<String> res) {
        char c = board[x][y];
        if (board[x][y] == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }
        
        board[x][y] = '#';
        if (x - 1 >= 0) dfs(board, x - 1, y, p, res);
        if (x + 1 < board.length) dfs(board, x + 1, y, p, res);
        if (y - 1 >= 0) dfs(board, x, y - 1, p, res);
        if (y + 1 < board[0].length) dfs(board, x, y + 1, p, res);
        board[x][y] = c;
        
        return;
        
    }
    public TrieNode buildTries(String[] words) {
        TrieNode root = new TrieNode();
        for (String ws : words) {
            TrieNode p = root;
            char[] arr = ws.toCharArray();
            for (char ch : arr) {
                int index = ch - 'a';
                if (p.next[index] == null) 
                    p.next[index] = new TrieNode();
                p = p.next[index];
            }
            p.word = ws;
        }
        return root;
    }
    
    class TrieNode {
        private TrieNode[] next;
        private final int R = 26;
        private String word;
        
        public TrieNode() {
            next = new TrieNode[R];
        }
    }
    
}