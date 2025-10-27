public class TreeNode {

    public int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public void doubleTree() {
    }

    public void insertBST(int newValue) {
        
    }

    public void printTree(TreeNode root) {
        printTree(root, "", true);
    }

    private void printTree(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
   
    public static void main(String[] args) {
        // Tree structure for testing:
        // 1
        // / \
        // 2 3
        // / \ / \
        // 4 5 6 7
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);

        t1.doubleTree();

        // Test cases for isSubtree
        assert t1.value == 2 : "Test Case 0 Failed";
        assert t1.right.right.value == 14 : "Test Case 1 Failed";
        // assert false : "test failed";

        System.out.println("All test cases passed!");
    }
}
