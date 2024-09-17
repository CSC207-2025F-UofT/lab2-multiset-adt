import java.util.Arrays;
import java.util.Objects;
import java.util.ArrayList;

public class Tree {
    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py
    private Integer root;
    private ArrayList<Tree> subtrees;

    public Tree(Integer root, ArrayList<Tree> subtrees) {
        this.root = root;
        this.subtrees = subtrees;
    }
    public Tree(Integer root) {
        this(root, new ArrayList<Tree>());
    }

    public boolean is_empty() {
        return this.root == null;
    }

    public int size() {
        if (this.is_empty()) {
            return 0;
        }
        else {
            int len = 1;
            for (Tree subtree : this.subtrees) {
                len += subtree.size();
            }
            return len;
        }
    }

    public int count(Integer item) {
        if (this.is_empty()) {
            return 0;
        }
        else {
            int num = 0;
            if (Objects.equals(this.root, item)) {
                num++;
            }
            return num;
        }
    }

    @Override
    public String toString() {
        return this.str_indented();
    }
    private String str_indented(Integer depth) {
        if (this.is_empty()) {
            return "";
        }
        else {
            StringBuilder s = new StringBuilder("  ".repeat(depth) + this.root.toString() + "\n");
            for (Tree subtree : this.subtrees) {
                s.append(subtree.str_indented(depth + 1));
            }
            return s.toString();
        }
    }
    private String str_indented() {
        return this.str_indented(0);
    }

    public float average() {
        if (this.is_empty()) {
            return 0;
        }
        else {
            int[] avg = this.average_helper();
            return (float) avg[0]/avg[1];
        }
    }
    private int[] average_helper() {
        int[] avg = {0, 0};
        if (!this.is_empty()) {
            for (Tree subtree : this.subtrees) {
                int[] subtree_avg = subtree.average_helper();
                avg[0] += subtree_avg[0];
                avg[1] += subtree_avg[1];
            }
        }
        return avg;
    }

    public boolean equals(Tree other) {
        if (this.is_empty() && other.is_empty()) { return true; }
        else if (this.is_empty() || other.is_empty()) { return false; }
        else {
            if ((!Objects.equals(this.root, other.root)) || (this.subtrees.size() != other.subtrees.size())) {
                return false;
            }
            else {
                return this.subtrees.equals(other.subtrees);
            }
        }
    }

    public boolean contains(Integer item) {
        if (this.is_empty()) { return false; }
        if (Objects.equals(this.root, item)) { return true; }
        else {
            for (Tree subtree : this.subtrees) {
                if (subtree.contains(item)) { return true; }
            }
            return false;
        }
    }

    public ArrayList<Integer> leaves() {
        if (this.is_empty()) { return new ArrayList<>(); }
        else if (this.subtrees.isEmpty()) {
            return new ArrayList<>();
        }
        else {
            ArrayList<Integer> leaves = new ArrayList<>() ;
            for (Tree subtree : this.subtrees) {
                leaves.addAll(subtree.leaves());
            }
            return leaves;
        }
    }

}
