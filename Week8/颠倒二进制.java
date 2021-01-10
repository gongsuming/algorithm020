// 利用mask将每一位取出来，然后放入正确的位置，即 i 和 31-i 互换。
// 需要注意，当是0时，直接'^'0，不然会出错
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result =0;
        int mask = 1;
        for(int i = 0; i < 32; i++){
            if ((n & (mask<<i)) ==0) {
                result ^= 0;
            }else{
                result ^= mask<<(31-i);
            }
        }
        return result;
    }
}