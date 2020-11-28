// 前序遍历
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }
    public void preorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (int i=0; i < root.children.size(); i++) {
            preorder(root.children.get(i), res);
        }
    }
}  

// 看答案中有个解答如下：
class Solution {
    ArrayList<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.children == null) {     //
            return;                      //
        }                                // 删除这3句话会报错，为什么？

        for (Node child: root.children) {  // 这句话其实就是for循环，值得学习一下
            dfs(child);
        }
    }
}


// 后序遍历
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        aftorder(root, result);
        return result;
    }
    public void aftorder(Node root, List<Integer>result) {
        if(root == null) {
            return ;
        }
        for(int i=0; i<root.children.size(); i++) {
            aftorder(root.children.get(i), result);
        }
        result.add(root.val);
    }
}