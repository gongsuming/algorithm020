// 直接排序，取前K个数即可
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.sort(arr);
        for(int i=0; i< k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}


// 小顶堆
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i =0; i< arr.length; i++) {
            queue.add(arr[i]);
        }
        int[] result = new int[k];
        for(int i =0; i< k; i++) {
            result[i] = queue.remove();
        }
        return result;
    }
}