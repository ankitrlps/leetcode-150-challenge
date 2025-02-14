public class MinStack155 {

    Node stack = null;
    Node curr = null;

    public MinStack155() {
        stack = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        curr = stack;
    }
    
    public void push(int val) {
        Node newNode = new Node(val, Math.min(curr.min, val));
        curr.next = newNode;
        newNode.prev = curr;
        curr = curr.next;
    }
    
    public void pop() {
        curr = curr.prev;
        curr.next = null;
    }
    
    public int top() {
        return curr.val;
    }
    
    public int getMin() {
        return curr.min;
    }


    public static void main(String[] args) {
        
    }
}


class Node {
    int val;
    Node next;
    Node prev;
    int min;

    public Node() {}

    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}