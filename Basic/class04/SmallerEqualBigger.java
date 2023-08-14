package class04;

public class SmallerEqualBigger {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(6);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(8);
        ListNode ln7 = new ListNode(6);
        ListNode ln8 = new ListNode(7);
        ListNode ln9 = new ListNode(5);
        ListNode ln10 = new ListNode(2);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = ln9;
        ln9.next = ln10;

        ListNode result = listPartition(ln1, 5);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode listPartition(ListNode head, int value) {
        ListNode sH = null, sT = null, eH = null, eT = null, bH = null, bT = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < value) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            }
            if (head.val == value) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            }
            if (head.val > value) {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if (sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        if(eT != null){
            eT.next = bH;
        }

        return sH != null ? sH : (eH != null ? eH : bH);
    }
}
