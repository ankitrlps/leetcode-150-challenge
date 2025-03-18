import java.util.HashMap;
import java.util.Map;

public class CopyListRandomPointer138 {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node orig = head;

        while (orig != null) {
            map.put(orig, new Node(orig.val));
            orig = orig.next;
        }

        orig = head;

        while (orig != null) {
            Node curr = map.get(orig);

            curr.next = map.get(orig.next);
            curr.random = map.get(orig.random);
            
            orig = orig.next;
        }

        return map.get(head);
    }

    public Node copyRandomLis1(Node head) {
        Map<Node, Integer> origNodeIndexMap = new HashMap<>();
        Node runner = head;
        int i = 0;
        while (runner != null) {
            origNodeIndexMap.put(runner, i);
            i += 1;
            runner = runner.next;
        }
        
        int[] origRandomNodeIndex = new int[origNodeIndexMap.size()];
        runner = head;
        i = 0;
        while (runner != null) {
            if(runner.random != null) {
                origRandomNodeIndex[i] = origNodeIndexMap.get(runner.random);
            } else {
                origRandomNodeIndex[i] = -1;
            }
            runner = runner.next;
            i++;
        }

        Node origRunner = head;
        Node copy = new Node(0);
        Node copyRunner = copy;
        Node[] randomNodes = new Node[origNodeIndexMap.size()];
        i = 0;
        while (origRunner != null) {
            copyRunner.next = new Node(origRunner.val);
            randomNodes[i] = copyRunner.next;
            i++;
            origRunner = origRunner.next;
            copyRunner = copyRunner.next;
        }

        copyRunner = copy.next;
        i = 0;
        while (copyRunner != null) {
            if (origRandomNodeIndex[i] == -1) {
                copyRunner.random = null;    
            } else {
                copyRunner.random = randomNodes[origRandomNodeIndex[i]];
            }
            i++;
            copyRunner = copyRunner.next;
        }

        return copy.next;
    }

    public static void main(String[] args) {
        
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}