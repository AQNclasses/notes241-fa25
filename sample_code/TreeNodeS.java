import java.util.ArrayList;

public class TreeNodeS {

    public int value;
    TreeNodeS left;
    TreeNodeS right;

    public TreeNodeS(int value) {
        this.value = value;
    }

    public void doubleTree() {
        this.value *= 2;
        if (left != null) {left.doubleTree();}
        if (right != null) {right.doubleTree();}
    }

    public void insertBST(int newValue) {

        // goes to left
        if (newValue <= value) {
            if (left == null) {
                left = new TreeNodeS(newValue);
            }
            else {
                left.insertBST(newValue);
            }
        }

        // goes to right
        else {
            if (right == null) {
                right = new TreeNodeS(newValue);
            }
            else{
                right.insertBST(newValue);
            }
        }
    }

    public ArrayList<Integer> inOrder() {
        ArrayList<Integer> ret = new ArrayList<>();
        return inOrder(ret);
    }

    private ArrayList<Integer> inOrder(ArrayList<Integer> ret) {
        if (left != null) {
            ret = left.inOrder(ret);
        }

        ret.add(this.value);

        if (right != null) {
            ret = right.inOrder(ret);
        }

        return ret;

    }

    public void printTree() {
        printTree(this, "", true);
    }

    private void printTree(TreeNodeS node, String prefix, boolean isLeft) {
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
        TreeNodeS t1 = new TreeNodeS(1);
        t1.left = new TreeNodeS(2);
        t1.right = new TreeNodeS(3);
        t1.left.left = new TreeNodeS(4);
        t1.left.right = new TreeNodeS(5);
        t1.right.left = new TreeNodeS(6);
        t1.right.right = new TreeNodeS(7);

        t1.doubleTree();

        // Test cases for isSubtree
        assert t1.value == 2 : "Test Case 0 Failed, actual value " + t1.value;
        assert t1.right.right.value == 14 : "Test Case 1 Failed";
        // assert false : "test failed";

        TreeNodeS t2 = new TreeNodeS(5);
        t2.insertBST(4);
        assert t2.left.value == 4 : "Test Case 2 Failed";
        t2.insertBST(7);
        assert t2.right.value == 7 : "Test Case 3 Failed";

        t2.insertBST(10);
        t2.insertBST(11);
        t2.insertBST(12);

        t2.printTree();

        ArrayList<Integer> a = t2.inOrder();
        System.out.println(a);

        System.out.println("All test cases passed!");
    }
}
