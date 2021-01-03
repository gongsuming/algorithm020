// 对一个精解做了简单笔记，记住岛屿类问题DFS模板，然后打磨细节代码。
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    area(grid, r, c);
                }
            }
        }
        return res;
    }
    void area(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return ;
        }
        if (grid[r][c] != '1') {
            return ;
        }
        grid[r][c] = '2';
        area(grid, r - 1, c);
        area(grid, r + 1, c);
        area(grid, r, c - 1);
        area(grid, r, c + 1);
    }
    boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length 
            && 0 <= c && c < grid[0].length;
    }
}