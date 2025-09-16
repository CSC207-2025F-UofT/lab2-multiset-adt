
// Node is only used inside the LinkedList class, so we define it in the same file;
// there can only be one public class in a file, but there can also be non-public classes.
class Node {
    int item;
    Node next;
    Node(int item) {
        this.item = item;
    }
}

public class LinkedListMultiSet extends MultiSet {

    private Node front;
    private int size;

    @Override
    public void add(int item) {
        Node newNode = new Node(item);
        newNode.next = front;
        front = newNode;
        size += 1;
    }

    @Override
    public void remove(int item) {
        Node prev = null;
        Node cur = front;

        while (cur != null) {
            if (cur.item == item) {
                if (prev == null) {
                    front = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size -= 1;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    @Override
    public boolean contains(int item) {
        Node cur = front;
        while (cur != null) {
            if (cur.item == item) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int count(int item) {
        int numSeen = 0;
        Node cur = front;
        while (cur != null) {
            if (cur.item == item) {
                numSeen += 1;
            }
            cur = cur.next;
        }
        return numSeen;
    }

    @Override
    public int size() {
        return size;
    }
}
