class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[][] visited = new int[grid.length][grid[0].length];
        
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (visited[i][j] == 0 && grid[i][j] == '1')
                    res += dfs(grid, i, j, visited);
            }
        }
        return res;
    }
    public int dfs(char[][] grid, int x, int y, int[][] visited) {
        if (grid[x][y] == '0')
            return 0;
        
        // left
        if (x - 1 >= 0 && visited[x - 1][y] == 0 && grid[x - 1][y] == '1') {
            visited[x - 1][y] = 1;
            dfs(grid, x - 1, y, visited);
        }
        // right            
        if (x + 1 <= grid.length - 1 && visited[x + 1][y] == 0 && grid[x + 1][y] == '1') {
            visited[x + 1][y] = 1;
            dfs(grid, x + 1, y, visited);
        }
        // up           
        if (y - 1 >= 0 && visited[x][y - 1] == 0 && grid[x][y - 1] == '1') {
            visited[x][y - 1] = 1;
            dfs(grid, x, y - 1, visited);
        }
        // down   
        if (y + 1 <= grid[0].length - 1 && visited[x][y + 1] == 0 && grid[x][y + 1] == '1') {
            visited[x][y + 1] = 1;
            dfs(grid, x, y + 1, visited);
        }
            
        return 1;
        
    }
}