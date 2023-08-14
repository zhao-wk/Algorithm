package class06;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(root, root);
        getFather(fatherMap, root);

        HashSet<TreeNode> set = new HashSet<>();
        TreeNode cur = p;
        while (cur != fatherMap.get(cur)){
            set.add(cur);
            cur = fatherMap.get(cur);
        }

        cur = q;
        while (cur != fatherMap.get(cur)){
            if (set.contains(cur)) return cur;
            cur = fatherMap.get(cur);
        }
        return root;
    }

    public static void getFather(HashMap<TreeNode, TreeNode> fatherMap, TreeNode root){
        fatherMap.put(root.leftChild, root);
        fatherMap.put(root.rightChild, root);
        getFather(fatherMap, root.leftChild);
        getFather(fatherMap, root.rightChild);
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.leftChild, p, q);
        TreeNode right = lowestCommonAncestor2(root.rightChild, p, q);

        if (left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }
}
