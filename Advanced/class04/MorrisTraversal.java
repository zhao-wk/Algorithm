package class04;

public class MorrisTraversal {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        morrisPos(head);
    }

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int val){
            this.value = val;
        }
    }

    public static void morris(Node head){
        if (head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void morrisPre(Node head){
        if (head == null){
            return;
        }

        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null){
                    System.out.println(cur.value + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }else {
                System.out.println(cur.value + " ");
            }
            cur = cur.right;
        }
    }

    public static void morrisIn(Node head){
        if (head == null){
            return;
        }

        Node cur = head;
        Node mostRight = null;

        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                else {
                    mostRight.right = null;
                }
            }
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
    }

    public static void morrisPos(Node head){
        if (head == null){
            return;
        }

        Node cur = head;
        Node mostRight = null;

        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;

                    continue;
                }else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
    }

    public static void printEdge(Node head){
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null){
            System.out.println(cur.value);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.right;
            head.right = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
