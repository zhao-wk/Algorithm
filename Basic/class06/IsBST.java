package class06;

public class IsBST {
    public static void main(String[] args) {

    }

    public static int preValue = Integer.MIN_VALUE;


    public static boolean checkBST(TreeNode root){
        if (root == null) return true;
        boolean isLeftBst = checkBST(root.leftChild);
        if (!isLeftBst) return false;
        if (root.val <= preValue){
            return false;
        }else {
            preValue = root.val;
        }
        return checkBST(root.rightChild);
    }



}
