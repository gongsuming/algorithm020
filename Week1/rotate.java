// 暴力解法，旋转K次，每次移一个，数组的删除与插入，类似冒泡排序的思想。
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int finalValue = nums[n - 1];
            for (int j = 0; j < n; j++) {
                int temp = nums[j];
                nums[j] = finalValue;
                finalValue = temp;
            }
        }
    }
}


// 借助辅助数组（M1: 自己写的，有问题； M2：官方答案）
// M1有个前提：k < n。此外，temp存放移动的k个数会出现覆盖的错误。
class Solution {                                  // M1
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;                            // 原本有上述问题，后来发现一旦k==n时等于原数组没变化，所以取余便能解决所有问题。
        int[] temp = new int[ n - k ];
        for (int i = 0; i < n - k; i++) {
            temp[i] = nums[ i ];
        }
        for (int i = 0; i < k; i++) {
            nums[ i ] = nums[ n - k + i ];
        }
        for (int i = 0 ; i < n - k; i++) {
            nums[ i + k ] = temp[ i ];
        }
    }
}

public class Solution {                           // M2   内在思想是：散列函数
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
