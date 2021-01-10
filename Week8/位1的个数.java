// 设置一个mask, 先与target进行'&', 判断是否为0，然后左移mask,进行循环判断
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        int mask = 1;
        for(int i = 0; i<32; i++) {
            if ( (n&mask) != 0) {
                num +=1;
            }
            mask <<=1;
        }
        return num;
    }
}

// 官方题解中提供了一个更优化的思路：
// 我们可以把前面的算法进行优化。我们不再检查数字的每一个位，而是不断把数字最后一个 1 反转，并把答案加一。
// 当数字变成 0 的时候，我们就知道它没有 1 的位了，此时返回答案。
// 这里关键的想法是对于任意数字 n ，将 n 和 n - 1 做与运算，会把最后一个 1 的位变成 0 。
public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
        sum++;
        n &= (n - 1);
    }
    return sum;
}
