// 994. Rotting Oranges - https://leetcode.com/problems/rotting-oranges/

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> queue = new LinkedList();
        int orangeNumber = 0;
        int rottenNumber = 0;
        int minute = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2 ) 
                    orangeNumber++;
                if (grid[i][j] == 2) {
                    rottenNumber++;
                    queue.add(new int []{i, j, minute});
                }
            }
        }
        if (rottenNumber == orangeNumber)
            return 0;
        int [][] directions = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            int r = currentCell[0];
            int c = currentCell[1];
            int min = currentCell[2];
            min++;
            System.out.print("queue ("+r+","+c+") ");
            int sameTime = 0;
            boolean rottenMinute = false;
            for (int d = 0; d < directions.length; d++) {
                int [] direction = directions[d];
                int r_d = r + direction[0];
                int c_d = c + direction[1];
                
                if (r_d < 0 || c_d < 0 || r_d >= grid.length || c_d >= grid[0].length) {
                    continue;
                }
                if (grid[r_d][c_d] == 1) {
                    grid[r_d][c_d] = 2;
                    rottenNumber++;
                    System.out.print(",minute"+minute+" rotten: ("+r_d+","+c_d+") ");
                    queue.add(new int[] {r_d, c_d, min});
                    if (orangeNumber == rottenNumber)
                        return min;
                }
            }
        }
        return -1;
    }
}

// TODO: Add comments and look other solutions!