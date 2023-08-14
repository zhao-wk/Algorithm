package class04;

import java.util.HashMap;

public class CopyListWithRandom {
    public static void main(String[] args) {
        RandomNode rn1 = new RandomNode(3);
        RandomNode rn2 = new RandomNode(1);
        RandomNode rn3 = new RandomNode(2);
        RandomNode rn4 = new RandomNode(4);
        rn1.next = rn2;
        rn2.next = rn3;
        rn3.next = rn4;
        rn1.random = rn3;
        rn2.random = rn3;
        rn3.random = rn1;
        rn4.random = rn2;
        RandomNode newHead = copyListWithRanClever(rn1);
        while (newHead != null) {
            System.out.println(newHead.next.val);
            System.out.println(newHead.random.val);
            newHead = newHead.next;
        }
    }

    public static RandomNode copyListWithRanStupid(RandomNode head) {
        RandomNode cur = head;
        HashMap<RandomNode, RandomNode> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new RandomNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static RandomNode copyListWithRanClever(RandomNode head){
        RandomNode cur = head;
        RandomNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = new RandomNode(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        RandomNode curCopy = null;

        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random == null ? null : cur.random;
            cur = next;
        }

        RandomNode res = head.next;
        cur = head;
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
