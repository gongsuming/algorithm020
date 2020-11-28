// Hash版    Ps: 先放再判断，也会出问题
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for ( int i=0; i< nums.length; i++) {
            if (hm.containsKey(target-nums[i])) {
                return new int[]{hm.get(target -nums[i]), i};
            }
            hm.put( nums[i], i);
        }
        return new int[]{0 ,0};
    }
}

// 错误解法。当出现 [3,2,4], target = 6 这种情况时就会报错。
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for ( int i=0; i< nums.length; i++) {
            hm.put( nums[i], i);
        }
        for ( int i=0; i< nums.length; i++) {
            if (hm.containsKey(target-nums[i])) {
                return new int[]{i, hm.get(target -nums[i])};
            }
        }
        return new int[]{0 ,0};
    }
}