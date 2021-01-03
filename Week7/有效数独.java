// 暴力方法：每行、每列、每个小正方形 依次判断。
// 题解中有个更简洁的代码，感觉像是用空间换来简洁代码，值得学习。
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        // 对每行进行遍历
        for (int row = 0; row < 9; row++) {
            boolean[] isSeen = new boolean[9];
            for (int idx = 0; idx < 9; idx++) {
                char c = board[row][idx];
                if (c != '.') {
                    int num = c - '1';
                    // 如果之前遍历的时候出现过该数字说明有重复，直接false
                    if (isSeen[num] == true) {
                        return false;
                    } else {
                        isSeen[num] = true;
                    }
                }
            }
        }
        // 对每列进行遍历
        for (int col = 0; col < 9; col++) {
            boolean[] isSeen = new boolean[9];
            for (int idx = 0; idx < 9; idx++) {
                char c = board[idx][col];
                if (c != '.') {
                    int num = c - '1';
                    if (isSeen[num] == true) {
                        return false;
                    } else {
                        isSeen[num] = true;
                    }
                }
            }
        }
        // 对每个小正方形进行遍历
        for (int box = 0; box < 9; box++) {
            boolean[] isSeen = new boolean[9];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    char c = board[row + 3 * (box / 3)][col + 3 * (box % 3)];
                    if (c != '.') {
                        int num = c - '1';
                        if (isSeen[num] == true) {
                            return false;
                        } else {
                            isSeen[num] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
