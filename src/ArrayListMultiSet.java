import java.util.ArrayList;

public class ArrayListMultiSet extends MultiSet {

    // this ArrayList object is a private instance variable for this class.
    private final ArrayList<Integer> lst = new ArrayList<>();

    @Override
    void add(int item) {
        lst.add(item);
    }

    /**
     * Remove the given item from this multiset.
     * If the item isn't in the multiset, do nothing.
     *
     * @param item the item to remove
     */
    @Override
    void remove(int item) {
        if (lst.contains(item)) {
            lst.remove(item);
        }
    }

    /**
     * Check whether item is in this multiset.
     *
     * @param item the item to check if in this multiset
     * @return True if item is in this multiset and False otherwise.
     */
    @Override
    boolean contains(int item) {
        for (int i : lst)
            if (i == item)
                return true;
        return false;
    }

    /**
     * @return True if this multiset is empty.
     */
    @Override
    boolean isEmpty() {
        return lst.size() == 0;
    }

    /**
     * Count how many times the given item appears in this multiset.
     *
     * @param item the item to count
     * @return How many times item appears in this multiset.
     */
    @Override
    int count(int item) {
        int count = 0;
        for (int i : lst) {
            if (lst.contains(i))
                count++;
        }
        return count;
    }

    /**
     * @return How many items are in this multiset.
     */
    @Override
    int size() {
        int i = 0;
        while (lst.get(i) != null)
            i++;
        return i;
    }
}
