import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList148 {

    // loop through the listnode and store node vals to arraylist.
    // sort the arraylist and and loop through listnode and update each node with each element in arraylist
    public ListNode sortList1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(list);
        curr = head;
        int i = 0;

        while (curr != null) {
            curr.val = list.get(i++);
            curr = curr.next;
        }
        return head;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);

        return mergeSort(l1, l2);
    }

    ListNode mergeSort(ListNode l1, ListNode l2) {
        //2,4,1,3
        //1,2,3,4
        ListNode m = new ListNode(0), n = m;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                n.next = l1;
                l1 = l1.next;
            } else {
                n.next = l2;
                l2 = l2.next;
            }
            n = n.next;
        }

        n.next = (l1 != null) ? l1 : l2;
        return m.next;
    }

    public static void main(String[] args) {
        
    }
}
