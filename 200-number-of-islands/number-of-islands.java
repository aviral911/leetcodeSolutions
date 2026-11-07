class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    void dfs(char[][] grid, int i, int j) {

        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m ||
            grid[i][j] == '0') {
            return;
        }

        // Mark visited
        grid[i][j] = '0';

        // Explore all 4 directions
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}