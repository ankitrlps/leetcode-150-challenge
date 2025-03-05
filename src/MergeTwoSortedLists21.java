public class MergeTwoSortedLists21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode resRunner = res;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                resRunner.next = new ListNode(list1.val);
                resRunner = resRunner.next;
                list1 = list1.next;
            } else {
                resRunner.next = new ListNode(list2.val);
                resRunner = resRunner.next;
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            resRunner.next = new ListNode(list1.val);
            resRunner = resRunner.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            resRunner.next = new ListNode(list2.val);
            resRunner = resRunner.next;
            list2 = list2.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        
    }
}
