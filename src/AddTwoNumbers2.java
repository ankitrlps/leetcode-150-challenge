import java.util.LinkedList;
import java.util.Queue;

public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode resRunner = res;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                que1.add(l1.val);
                l1 = l1.next != null ? l1.next : null;
            }
            if (l2 != null) {
                que2.add(l2.val);
                l2 = l2.next != null ? l2.next : null;
            }
        }
        
        int carry = 0;
        while (!que1.isEmpty() || !que2.isEmpty()) {
            int a = que1.size() > 0 ? que1.poll() : 0;
            int b = que2.size() > 0 ? que2.poll() : 0;
            int currSum = a + b + carry;
            carry = 0;
            if (currSum > 9) {
                carry = 1;
                currSum = currSum % 10;
            }
            resRunner.next = new ListNode(currSum);
            resRunner = resRunner.next;
        }
        if (carry == 1) {
            resRunner.next = new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        
    }
}
