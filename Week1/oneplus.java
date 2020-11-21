// 这道题本质上是看数组(或一串数)从后往前数有多少个连续的9；记为countOfNine
// 若countOfNine == 数组长度（n），那么就变为100...0（如：999->1000，99999->100000）
// 若countOfNine == 0，那么数组最后一位直接加1就行了
// 若countOfNine介于两者之间，只需要将[n - countOfNine, n-1]置0；[n - countOfNine -1]加1即可

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int countOfNine = 0;
        for(int i =  n - 1; i >= 0; i--) {
            if( digits[i] == 9) {
                countOfNine++;
            }
            else {
                break;
            }
        }
        if ( countOfNine == n) {
            int[] result = new int[n+1];
            result[0] = 1;
            return result;
        }
        if (countOfNine == 0) {
            digits[n-1] = digits[n-1] + 1;
            return digits;
        }
        for(int i = n - countOfNine; i < n; i++) {
            digits[i] = 0;
        }
        digits[n - countOfNine - 1] = digits[n - countOfNine - 1] + 1;
        return digits;
    }
}