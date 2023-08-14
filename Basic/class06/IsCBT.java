package class06;

import java.util.LinkedList;
import java.util.Queue;

public class IsCBT {
    public static void main(String[] args) {

    }

    public static boolean checkCBT(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isLeaf = false;
        TreeNode left = null;
        TreeNode right = null;
        queue.add(head);

        while(!queue.isEmpty()){
            head = queue.poll();
            left = head.leftChild;
            right = head.rightChild;
            if ((left == null && right != null) ||
                    (isLeaf && (left!= null || right != null))){
                return false;
            }
            if(left != null){
                queue.add(left);
            }
            if (right != null){
                queue.add(right);
            }
            if (left == null || right == null){
                isLeaf = false;
            }
        }
        return true;
    }
}
