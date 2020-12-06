// 回溯算法是在一棵树上的 深度优先遍历，同时需要自己手画一下树，搞清楚各种条件。
// 组合与全排列的区别在于：当前操作值参不参与后续操作
// 组合，不需要当前值参与后续操作。因此，每次直接往后操作就行。
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultult = new ArrayList<>();
        if( k<=0 || n<k) {
            return resultult;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, resultult);
        return resultult;
    }
    public void dfs(int n, int k, int depth, Deque<Integer> path, List<List<Integer>> resultult) {
        if (path.size() == k) {
            resultult.add(new ArrayList<>(path));
            return;
        }
        for(int i = depth; i <= n; i++ ){
            path.addLast(i);
            dfs(n,k,i+1,path,resultult);
            path.removeLast();
        }
    }
}

// 全排列，当前值需要参与后续操作。
// 因此，需要辅助数组来标识操作数是否参与操作
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();

        dfs(nums, len, 0, path, used, result);
        return result;
    }

    public void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used,
                     List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, result);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}