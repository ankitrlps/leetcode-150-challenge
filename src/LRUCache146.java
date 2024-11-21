import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    Map<Integer, Integer> map;
    int capacity = 0;
    int size = 0;
    DListNode root;

    public LRUCache146(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        root = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        updateCache(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            updateCache(key);
        } else {
            DListNode node = new DListNode(key); // adding new node to head
            if (size < capacity) {
                map.put(key, value);
                size++;
                if (root == null) {
                    //node.prev = null;
                    //node.next = null;
                    root = node;
                } else {
                    //node.prev = null;
                    node.next = root;
                    root.prev = node;
                    root = node;
                }
            } else {
                // And add a new one at head. Remove tail and same key in map. 
                node.prev = null;
                node.next = root;
                root.prev = node;
                root = node;
                DListNode curr = root;
                while (curr.next != null) {
                    curr = curr.next;
                }
                int removeKey = curr.key;
                map.remove(removeKey);
                map.put(key, value);
                DListNode temp = curr.prev;
                temp.next = null;
            }
        }
    }

    void updateCache(int key) {
        DListNode curr = root;
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }

        // adding to head
        DListNode newNode = new DListNode(curr.key);
        newNode.next = root;
        root.prev = newNode;
        root = newNode;

        // removing the curr node
        DListNode prevNode = curr.prev;
        prevNode.next = curr.next;
        if (curr.next != null) curr.next.prev = prevNode;
        
        // DListNode temp = curr; // for adding to head later;

        // // removing the node
        // DListNode prevNode = curr.prev;
        // prevNode.next = curr.next;
        // if (curr.next != null) curr.next.prev = prevNode;
        
        // // adding to head
        // temp.next = root;
        // root.prev = temp;
        // root = temp;
    }

    public static void main(String[] args) {
        LRUCache146 cache = new LRUCache146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.map);
    }
}

class DListNode {
    DListNode prev;
    DListNode next;
    int key;

    public DListNode(int key) {
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}
