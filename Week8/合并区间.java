// 核心思想：两两比较区间的左右端点(画图很清晰知道)
// 技巧：1.排序（保证有序，还可以不讨论A左B右的情况）
//       2.输出结果 （因为存在合并情况，那么result就会出现[0][0]）
class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        int index = 0;

        result[0][0] = intervals[0][0];
        result[0][1] = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int L = intervals[i][0], R = intervals[i][1];
            if( result[index][1] < L) {
                result[++index][0] = L;
                result[index][1] = R;
            }
            else {
                result[index][1] = Math.max(result[index][1], R);
            }

        }
        return Arrays.copyOf(result, index+1);
    }
}