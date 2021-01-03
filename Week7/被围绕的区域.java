// 这题和岛屿问题很像，不过要转换一下想法，从边界入手，找连通域，并将连通的
// 标记为T，最后用遍历将T还原成O，把O改成X --> 刚开始没想到，看到题解才恍然大悟，还是要多刷题，多看题解
// 此题还可以用超哥刚讲的“并查集”，目前不会，准备先看题解，把它记住。
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                boolean isEdge = r == 0 || c == 0 || r == m - 1 || c == n - 1;
                if ( isEdge && board[r][c] == 'O') {
                    area(board, r, c);
                }
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
    void area(char[][] board, int r, int c) {
        if (!inArea(board, r, c)) {
            return ;
        }
        if (board[r][c] != 'O') {
            return ;
        }
        board[r][c] = 'T';
        area(board, r - 1, c);
        area(board, r + 1, c);
        area(board, r, c - 1);
        area(board, r, c + 1);
    }
    boolean inArea(char[][] board, int r, int c) {
        return 0 <= r && r < board.length 
            && 0 <= c && c < board[0].length;
    }
}