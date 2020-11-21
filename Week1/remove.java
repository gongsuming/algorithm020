// 双指针，注意输出和(*)

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast;
        for ( fast = 1; fast < n; fast++) {
            if( nums[slow] == nums[fast]){
                    continue;
            }else{
                nums[++slow] = nums[fast];   // (*)
            }
        }
        return slow + 1;
    }
}