class Solution { // 7ms 60.17%
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (dfs(board, word, i, j, visited, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int x, int y, boolean[][] visited, int pos) {
        if (pos == word.length()) return true;
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1) return false;
        if (visited[x][y] || board[x][y] != word.charAt(pos)) return false;
        
        visited[x][y] = true;
        pos += 1;
        if (dfs(board, word, x, y - 1, visited, pos) || 
            dfs(board, word, x, y + 1, visited, pos) ||
            dfs(board, word, x - 1, y, visited, pos) ||
            dfs(board, word, x + 1, y, visited, pos))
            return true;
        visited[x][y] = false;
            
        return false;
    }
}