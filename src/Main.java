public class Main {
    public static void main(String[] args) {
        // TODO complete this psvm main method to replicate the timing experiment from adts.py.
        //      Note: this will be client code of the various other classes needing to be written.

        MultiSet[] multisets = {new TreeMultiSet(), new ArrayListMultiSet(), new LinkedListMultiSet()};

        for (MultiSet multiset : multisets) {
            for (int n : new int[]{500, 1000, 2000, 4000}) {
                profileMultiSet(multiset, n);
            }
        }
    }
