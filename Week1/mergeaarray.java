// 双指针，只需要考虑array1先走完的情况，因为若是array2先走完，那剩下的array1本身就是有序的，无需操作
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    
    int pointerNmus1 = m - 1;
    int pointerNmus2 = n - 1;

    for(int i = m + n -1; i >= 0; i--) {
        if ( pointerNmus1 >= 0 && pointerNmus2 >= 0) {
            if(nums1[pointerNmus1] >= nums2[pointerNmus2]) {
                nums1[i] = nums1[pointerNmus1];
                pointerNmus1--;
            }
            else {
                nums1[i] = nums2[pointerNmus2];
                pointerNmus2--;
            }
        }
        else {
            break;
        }
    }
    if (pointerNmus1 < 0 ) {
        for(int i = 0; i <= pointerNmus2; i++) {
            nums1[i] = nums2[i];
        }
    }
    }
}