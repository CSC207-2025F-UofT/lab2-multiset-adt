/**
 * A minimal implementation of a binary search tree. See the python version for
 * additional documentation.
 * You can also see <a href="https://www.teach.cs.toronto.edu/~csc148h/notes/binary-search-trees/bst_implementation.html">
 *     CSC148 Course Notes Section 8.5 BST Implementation and Search</a>
 * if you want a refresher on BSTs, but it is not required to complete this assignment.
 */
public class BST {
    // we use Integer here so that we can set the root to null. This is the same idea as
    // how the Python code uses None in the BST implementation.
    private Integer root;

    private BST left;
    private BST right;

    public BST(int root) {
        this.root = root;
        this.left = new BST();
        this.right = new BST();
    }

    /**
     * Alternate constructor, so we don't have to explicitly pass in null.
     */
    public BST() {
        root = null;
        // left and right default to being null
    }


    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(int item) {
        // provided as an example
        if (this.isEmpty()) {
            return false;
        } else if (item == this.root) {
            return true;
        } else if (item < this.root) {
            return this.left.contains(item);
        }
        return this.right.contains(item);

    }


    public void insert(int item) {
        if (this.root == null) {
            this.root = item;
            this.left = new BST();
            this.right = new BST();
        } else if (item <= this.root)
            this.left.insert(item);
        else
            this.right.insert(item);
    }


    public void delete(int item) {
        if (this.isEmpty()) {
            // Do nothing
        }
        else if (this.root == item) {
            this.deleteRoot();
        } else if (item < this.root) {
            this.left.delete(item);
        } else {
            this.right.delete(item);
        }
    }

    private void deleteRoot() {
        if (this.left.isEmpty() && this.right.isEmpty()) {
            this.root = null;
            this.left = null;
            this.right = null;
        } else if (this.left.isEmpty()) {
            int newRoot = this.right.root;
            BST newLeft = this.right.left;
            BST newRight = this.right.right;

            this.root = newRoot;
            this.left = newLeft;
            this.right = newRight;
        } else if (this.right.isEmpty()) {
            int newRoot = this.left.root;
            BST newLeft = this.left.left;
            BST newRight = this.left.right;

            this.root = newRoot;
            this.left = newLeft;
            this.right = newRight;
        } else {
            this.root = this.extractMax();
        }
    }


    private int extractMax() {
        if (this.right == null) {
            // current node is max
            int maxValue = this.root;
            if (this.left != null) {
                // replace this node with its left subtree
                this.root = this.left.root;
                this.right = this.left.right;
                this.left = this.left.left;
            } else {
                // this becomes an "empty" node
                this.root = 0;   // or null if using Integer
                this.left = null;
                this.right = null;
            }
            return maxValue;
        } else {
            return this.right.extractMax();
        }
    }


    public int height() {
        if (this.root == 0 && this.left == null && this.right == null) {
            return -1; // empty tree
        }
        int leftHeight = (this.left == null) ? -1 : this.left.height();
        int rightHeight = (this.right == null) ? -1 : this.right.height();
        return 1 + Math.max(leftHeight, rightHeight);
    }


    public int count(int item) {
        if (this.root == 0 && this.left == null && this.right == null) {
            return 0; // empty
        }
        if (item == this.root) {
            return 1 + ((this.left == null) ? 0 : this.left.count(item))
                    + ((this.right == null) ? 0 : this.right.count(item));
        } else if (item < this.root) {
            return (this.left == null) ? 0 : this.left.count(item);
        } else {
            return (this.right == null) ? 0 : this.right.count(item);
        }
    }


    public int getSize() {
        if (this.root == 0 && this.left == null && this.right == null) {
            return 0;
        }
        int leftSize = (this.left == null) ? 0 : this.left.getSize();
        int rightSize = (this.right == null) ? 0 : this.right.getSize();
        return 1 + leftSize + rightSize;
    }


    public static void main(String[] args) {
        // You can also add code here to do some basic testing if you want,
        // but make sure it doesn't contain syntax errors
        // or else we won't be able to run your code on MarkUs since the file won't
        // compile. Always make sure to run the self tests on MarkUs after you update your code.
        BST bst = new BST();
        int a = 1;
        int b = 0;
        int c = 2;
        bst.insert(a);
        bst.insert(b);
        bst.insert(c);
        System.out.println(bst.contains(a));
        System.out.println(bst.contains(b));
        System.out.println(bst.contains(c));
        bst.delete(b);
        bst.delete(c);
        System.out.println(bst.contains(b));
        System.out.println(bst.contains(c));
        bst.delete(a);
        System.out.println(bst.contains(a));
        System.out.println(bst.root == null);
    }

}
