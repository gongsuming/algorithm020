// 双指针不仅可以是首尾，也可是同头或同尾。本题先处理非0元素，然后其余置0
class Solution {
    public void moveZeroes(int[] nums) {

    int n = nums.length;
    int fast;
    int slow = 0;
    for( fast = 0; fast < n; fast++) {
        if (nums[fast] != 0)
        {
            nums[slow] = nums[fast];
            slow++;
        }
    }
    for( int i = slow; i < n; i++) {
        nums[i] = 0;
    }
    }
}