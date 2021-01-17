// 双指针方法。默认是全小写，无需转换。
// 本题需要考虑删除字符的问题，有2种情况：删左指针或删右指针，再判断剩下的是否是回文串
// 删完后只要一个为真就为真

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return isPalindrome(s,i,j-1) || isPalindrome(s, i+1, j);
                }
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome(String s, int i, int j) {
        int n = s.length();
        int left = i, right = j;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
