package class04;

public class MaxDistanceTree {
    public static void main(String[] args) {

    }

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int val){
            this.value = val;
        }
    }

    public static class Info{
        public int maxDistance;
        public int height;
        public Info(int dis, int het){
            this.maxDistance = dis;
            this.height = het;
        }
    }

    public static Info process(Node x){
        if (x == null){
            return new Info(0,0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        //前两种可能性：左子树堆最大距离或右子树的最大距离
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        //第三种可能：左子树的高度 + 右子树的高度 + 这个结点(1)
        int p3 = leftInfo.height + rightInfo.height + 1;

        int maxDistance = Math.max(p3, Math.max(p1, p2));
        int height = Math.max(p1, p2) + 1;
        return new Info(maxDistance, height);
    }


}
