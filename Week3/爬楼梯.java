// 直接递归，会超出时间限制
class Solution {
    public int climbStairs(int n) {
        if( n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}

// 巧妙地运用通项公式
class Solution {
    public int climbStairs(int n) {
        if( n == 1 || n == 2) {
            return n;
        }
        int p1 =0;
        int p2 =0;
        int p3 =1;
        for(int i = 1; i<= n ; i++) {
            p1 = p2;
            p2 = p3;
            p3 = p1 + p2;
        }
        return p3;
    }
}