// 542. 01 Matrix - https://leetcode.com/problems/01-matrix/

// BFS Approach
class Solution1 {
    
    public int[][] updateMatrix(int[][] mat) {
    int[][] dist = new int[mat.length][mat[0].length];
    Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    dist[i][j] = 100000; // First all 1's will be set to infinity, and 0's will make these distances smaller
                else
                    queue.add(new int[] {i,j}); // Putting all the zero coordinates to queue
            }
        }
        
        int [][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()) {
            int [] currentCell = queue.poll();
            int r = currentCell[0];
            int c = currentCell[1];
            // Going to up, down, left, right directions
            for (int d = 0; d < directions.length; d++) {
                int[] dir = directions[d];
                int r_d = r+dir[0];
                int c_d = c+dir[1];
                if (r_d < 0 || c_d < 0 || r_d >= dist.length || c_d >= dist[0].length)
                    continue;
                // It asks the following question: Can I make this cell smaller with my value + 1, in other words: passing through me since my value is the shortest distance from the zero to my cell
                if(dist[r_d][c_d] > dist[r][c] + 1) {
                    dist[r_d][c_d] = dist[r][c] + 1;
                    queue.add(new int [] {r_d, c_d});
                    // If I can make this cell smaller with my value+1, then I may use this cell to make other cells (that are neighbour to it) smaller since It contains a shortest distance value to a zero cell
                }
            }
        }
        return dist;
    }  
}

// DFS Approach
class Solution2 {
    
    public int[][] updateMatrix(int[][] mat) {
    int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[i][j] = mat[i][j];
                if (mat[i][j] != 0) {
                    res[i][j] = dfs(mat, i, j, new boolean[mat.length][mat[0].length]);
                }   
            }
        }
        return res;
    }
    
    public int dfs(int[][] mat, int r, int c, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || visited[r][c] == true)
            return 10000;
        if (mat[r][c] == 0)
            return 0;
        visited[r][c] = true;
        int val = 1 + Math.min(Math.min(Math.min(dfs(mat, r-1, c, visited), dfs(mat, r+1, c, visited)), dfs(mat, r, c-1, visited)), dfs(mat, r, c+1, visited));
        visited[r][c] = false;
        return val;
    }
    
}

// TODO: Look at the DP implementation of this question!