// 695. Max Area of Island - https://leetcode.com/problems/max-area-of-island/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxIslandSize = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j< grid[0].length; j++)
                maxIslandSize = Math.max(maxIslandSize, dfs(grid, i, j));
        return maxIslandSize;
    }
    public int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1)
            return 0;
        grid[r][c] = 2; // Mark as visited
        return 1 + dfs(grid, r+1, c) + dfs(grid, r-1, c) + dfs(grid, r, c+1) + dfs(grid, r, c-1);
    }
}