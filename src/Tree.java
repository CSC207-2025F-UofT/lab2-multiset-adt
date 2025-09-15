import java.util.ArrayList;

public class Tree {
    // We recommend attempting this class last, as it hasn't been scaffolded for your team.
    // Even if your team doesn't have time to implement this class, it is a useful exercise
    // to think about how you might split up the work to get the Tree and TreeMultiSet
    // implemented.
    private int root;
    private ArrayList<Tree> subtrees;

    void Tree(int root, ArrayList<Tree> subtrees) {
        this.root = root;
        if (subtrees == null) {
            this.subtrees = new ArrayList<>();
        } else {
            this.subtrees = subtrees;
        }
    }
}
