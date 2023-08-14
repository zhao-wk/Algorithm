package class06;

public class IsBalanced {
    public static void main(String[] args) {

    }

    public static class ReturnType{
        public boolean isBalanced;
        public int height;
        public ReturnType(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static ReturnType checkBalanced(TreeNode head){
        if (head == null){
            return new ReturnType(true, 0);
        }

        ReturnType leftResult = checkBalanced(head.leftChild);
        ReturnType rightResult = checkBalanced(head.rightChild);

        int height = Math.max(leftResult.height, rightResult.height) + 1;
        boolean isBalanced = leftResult.isBalanced && rightResult.isBalanced &&
                Math.abs(leftResult.height - rightResult.height) < 2;
        return new ReturnType(isBalanced, height);
    }
}
