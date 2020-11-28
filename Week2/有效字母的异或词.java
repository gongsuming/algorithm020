class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() ) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();      // 将String转成char[], 是因为Arrays.sort()函数针对基本数据类型

        Arrays.sort(s1);
        Arrays.sort(t1);

        return Arrays.equals(s1 , t1);
    }
}