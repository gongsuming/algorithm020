// 动态规划
class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) {
            return n;
        }

        int[] result = new int[n];
        result[0] = 1 ;
        int two = 0;
        int three = 0;
        int five = 0;
        for(int i =1; i< n; i++){
            result[i] = Math.min(Math.min(2*result[two], 3*result[three]),5*result[five]);
            if(result[i] == 2 * result[two]) {
                two++;
            }
            if(result[i] == 3 * result[three]) {
                three++;
            }
            if(result[i] == 5 * result[five]) {
                five++;
            }
        }
        return result[n-1];
    }
}