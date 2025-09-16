
// Node is only used inside the LinkedList class, so we define it in the same file;
// there can only be one public class in a file, but there can also be non-public classes.
class Node {
    int item;
    Node next;
    Node(int item) {
        this.item = item;
        this.next = null;
    }
}


public class LinkedListMultiSet extends MultiSet {

    // a linked list initially is empty
    private Node front;
    private int size;


    public void add(int item) {
        Node newNode =  new Node(item);
        newNode.next = front;
        front = newNode;
        size += 1;
    }

    public void remove(int item) {
        Node cur = front;
        Node prev = null;
        while (cur != null) {
            if (cur.item == item) {
                size--;
                if (prev != null) {
                    prev.next = cur.next;
                }
                else {
                    front = cur.next;
                }
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public boolean contains(int item) {
        Node cur = front;
        while (cur != null) {
            if (cur.item == item){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public int count(int item) {
        int count = 0;
        Node cur = front;
        while (cur != null) {
            if (cur.item == item) {
                count++;
            }
            cur = cur.next;
        }
        return count;
    }

    public int size() {
        return size;
    }
}
