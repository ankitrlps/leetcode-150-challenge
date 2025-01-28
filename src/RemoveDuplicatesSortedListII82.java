import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicatesSortedListII82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode root = new ListNode(-200, head);
        ListNode pre = root;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pre.next = head.next;
            } else {
                pre = pre.next;
            }
            head = head.next;
        }
        return root.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode runner = head;
        Map<Integer, Integer> map = new LinkedHashMap<>();

        while (runner != null) {
            if (map.containsKey(runner.val)) {
                map.put(runner.val, map.get(runner.val) + 1);
            } else {
                map.put(runner.val, 1);
            }
            runner = runner.next;
        }
        runner = head;
        ListNode prev = null;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                runner.val = key;
                prev = runner;
                runner = runner.next;
            }
        }
        if (prev != null) prev.next = null;
        if (prev == null && map.size() > 0) return null;
        return head;
    }
    
    public static void main(String[] args) {
        
    }
}
