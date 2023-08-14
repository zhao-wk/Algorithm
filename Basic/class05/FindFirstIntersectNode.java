package class05;

public class FindFirstIntersectNode {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);

        ListNode node = getNode(head1, head2);
        System.out.println(node.val);

    }
    public static ListNode getNode(ListNode head1, ListNode head2){
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);

        if(loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    public static ListNode getLoopNode(ListNode head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        };
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static ListNode noLoop(ListNode head1, ListNode head2){
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int n = 0;
        while(cur1.next != null){
            cur1 = cur1.next;
            n++;
        }
        while(cur2.next != null){
            cur2 = cur2.next;
            n--;
        }
        if (cur1 != cur2) return null;

        cur1 = head1;
        while (n != 0){
            cur1 = cur1.next;
            n--;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);

        while (n != 0){
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;

    }

    public static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2){
        ListNode cur1 = null;
        ListNode cur2 = null;
        if (loop1 ==loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1.next != null){
                cur1 = cur1.next;
                n++;
            }
            while (cur2.next != null){
                cur2 = cur2.next;
                n--;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;

            while (n != 0){
                cur1 = cur1.next;
                n--;
            }
            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next;
            while(cur1 != loop1){
                if (cur1 == loop2) return loop2;
                cur1 = cur1.next;
            }
        }
        return null;
    }

}
