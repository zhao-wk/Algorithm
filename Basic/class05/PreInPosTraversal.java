package class05;

import java.util.Stack;

public class PreInPosTraversal {
    public static void main(String[] args) {

    }

    public static void preOrder(TreeNode head){
        if (head == null){
            return;
        }
        System.out.println(head.val);
        preOrder(head.leftChild);
        preOrder(head.rightChild);
    }

    public static void inOrder(TreeNode head){
        if (head == null){
            return;
        }
        inOrder(head.leftChild);
        System.out.println(head.val);
        inOrder(head.rightChild);
    }

    public static void posOrder(TreeNode head){
        if(head == null){
            return;
        }
        posOrder(head.leftChild);
        posOrder(head.rightChild);
        System.out.println(head.val);
    }

    public static void preOrderUnRecur(TreeNode head){
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while(!stack.empty()){
                head = stack.pop();
                System.out.println(head.val);
                if (head.rightChild != null){
                    stack.push(head.rightChild);
                }
                if (head.leftChild != null){
                    stack.push(head.leftChild);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecur(TreeNode head){
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.empty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.leftChild;
                }else {
                    head = stack.pop();
                    System.out.println(head.val);
                    head = head.rightChild;
                }
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur(TreeNode head){
        if (head != null){
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while (stack1 != null){
                head = stack1.pop();
                stack2.push(head);
                if (head.leftChild != null){
                    stack1.push(head.leftChild);
                }
                if (head.rightChild != null){
                    stack1.push(head.rightChild);
                }
            }
            while (!stack2.empty()){
                TreeNode res = stack2.pop();
                System.out.println(res.val);
            }
        }
        System.out.println();
    }
}
