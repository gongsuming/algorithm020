// 2次幂的特征：二进制下表达式为：10...0。一个需要掌握的知识： (n & (n - 1)) == 0 则为2次幂
class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
        return false;
    }
    return (n & (n - 1)) == 0;
  }
} 
