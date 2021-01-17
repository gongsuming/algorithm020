// 双指针方法。首先将所有字母转化成小写，再判断。
// 刚开始写错了，看了题解才发现题目中给的字符串包含标点，所以需要Character.isLetterOrDigit来判断

class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (sgood.charAt(left) != sgood.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
