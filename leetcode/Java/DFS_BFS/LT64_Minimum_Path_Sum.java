class Solution { // 1ms 99.22%
    public int minPathSum(int[][] grid) {
        int[] min = new int[0];
        int[][] memo = new int[grid.length][grid[0].length];
        return dfs (grid, 0, 0, memo);
    }

    private int dfs (int[][] grid, int i, int j, int[][] memo) {
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];

        if (memo[i][j] != 0) return memo[i][j]; // without this line time exceed

        int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if (i < grid.length - 1) down = dfs(grid, i + 1, j, memo);
        if (j < grid[0].length - 1) right = dfs(grid, i, j + 1, memo);

        return memo[i][j] = grid[i][j] + Math.min(down, right);
    }
}

