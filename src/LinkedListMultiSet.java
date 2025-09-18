
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
        if (!this.isEmpty()) {
            Node curr = this.front;
            if (curr.item == item) {
                this.front = curr.next;
            } else {
                while (curr.next != null) {
                    if (curr.next.item == item) {
                        curr.next = curr.next.next;
                    }
                    curr = curr.next;
                }
            }
        }
    }

    public boolean contains(int item) {
        if (this.isEmpty()) {
            return false;
        }
        Node curr = this.front;
        while (curr != null) { // Check all nodes including the last
            if (curr.item == item) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.front == null;
    }


    public int count(int item) {
        if (this.isEmpty()) {
            return 0;
        }
        int count = 0;
        Node curr = this.front;
        while (curr != null) {
            if (curr.item == item) {
                count++;
            }
            curr = curr.next;
        }
        return count;
    }

    public int size() {
        return this.size;
    }
}
