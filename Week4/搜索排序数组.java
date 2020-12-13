// 方法一：暴力搜索（遍历所有元素）
// 方法二：分析数组特点，利用二分法将数组分成两段，然后判断target在哪一段，缩小检索范围。
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < nums[high]){
                if(nums[mid] < target && nums[high] >= target)
                {
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }else{
                if(nums[mid] > target && nums[low] <= target)
                {
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}