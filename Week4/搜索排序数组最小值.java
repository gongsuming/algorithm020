// 方法一：暴力搜索（遍历所有元素），当前元素大小后一元素，则后一元素为最小值
class Solution {
    public int findMin(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1] ){
                result = nums[i+1];
                return result;
            }
        }
        return nums[0];       //  这是因为会出现没逆序的情况，算是题目bug
    }
}
// 方法二：分析数组特点，利用二分法将数组逆序点找出来。
class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        // 针对长度为 1 的数组
        if(nums.length == 1) {
            return nums[0];
        }
        // 针对本身是有序的数组，若是出现逆序，则第一个元素必大于最后一个元素
        // 并且这种有序数组进行二分时，会出现越界错误，所以得单独讨论
        if(nums[high] > nums[0]) {
            return nums[0];
        }
        // 开始进行二分查找，先判断是否是逆序点，若不是再判断在哪个半段进行搜索
        while(low <= high){
            mid = low + ( high - low )/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }else if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }else if(nums[mid] < nums[high]){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return 0;
    }
}