package problems.ds;

public class TreeNode {
    public int val;
    public TreeNode lhs;
    public TreeNode rhs;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode lhs, TreeNode rhs) {
        this.val = val;
        this.lhs = lhs;
        this.rhs = rhs;
    }
}