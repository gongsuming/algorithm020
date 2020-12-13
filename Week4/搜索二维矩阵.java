// 方法一：暴力搜索（遍历所有元素）
// 方法二：结合矩阵特点，从右上角或左下角开始，能节省很多时间。
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // 行
        if (m <= 0) {
            return false;
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = matrix[i].length-1; j >= 0;j--){
                if(matrix[i][j] == target){     // 找到
                    return true;
                }else if(matrix[i][j] < target){ // 不在此行，直接进入下一行
                    break;
                }
            }
        }
        return false;
    }
}