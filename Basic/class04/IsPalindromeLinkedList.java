package class04;

public class IsPalindromeLinkedList {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(2);
        ListNode ln5 = new ListNode(1);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;

        boolean result = isPalindrome(ln1);
        System.out.println(result);
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode l2 = mid.next;
        ListNode newHead = reverseLinkedList(l2);
        boolean result = compareList(head, newHead);
        return result;
    }

    public static ListNode findMid(ListNode head){
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static ListNode reverseLinkedList(ListNode head){
        ListNode pre = null, cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static boolean compareList(ListNode l1, ListNode l2){
        while (l2 != null){
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
