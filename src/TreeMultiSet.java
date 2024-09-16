public class TreeMultiSet extends MultiSet {

    private Tree tree;

    @Override
    void add(Integer item) {
        this.tree.insert(item);
    }
}
