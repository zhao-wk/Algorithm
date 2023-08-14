package class06;

public class TreeNode {
    int val;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(){};

    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode leftChild, TreeNode rightChild){
        this.val = val;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
