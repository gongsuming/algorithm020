// 前序遍历
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}

// 中序遍历
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        midorder(root, result);
        return result;
    }

    public void midorder(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        midorder(root.left, result);
        result.add(root.val);
        midorder(root.right, result);       
    }
}

// 后序遍历
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        midorder(root, result);
        return result;
    }

    public void midorder(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        midorder(root.left, result);
        midorder(root.right, result);
        result.add(root.val);
    }
}