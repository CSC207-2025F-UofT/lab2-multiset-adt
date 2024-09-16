import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<MultiSet> multisets = new ArrayList<MultiSet>();
        multisets.add(new TreeMultiSet());
        multisets.add(new ArrayListMultiSet());
        multisets.add(new LinkedListMultiSet());

        ArrayList<Integer> listTwo = new ArrayList<Integer>(4);
        listTwo.add(500);
        listTwo.add(1000);
        listTwo.add(2000);
        listTwo.add(4000);

        for (MultiSet multiset: multisets){
            for (Integer n: listTwo){
                profileMultiSet(multiset, n);
            }
        }
    }

    public static void profileMultiSet(MultiSet my_input, int n){
        /*
          Run the timing experiment for the given <my_input> MultiSet implementation,
          for a problem size of <n>.
         */

        // add n random items, then remove them all; we will only time the removal step.
        ArrayList<Integer> items_added = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            Random rand = new Random();
            int x = rand.nextInt(100);
            my_input.add(x);
            items_added.add(x);
        }

        // sanity check that we added n items
        assert my_input.size() == n;

        Double start = System.currentTimeMillis()/1000.0;

        for (Integer item: items_added){
            my_input.remove(item);
        }

        Double end = System.currentTimeMillis()/1000.0;

        // sanity check that we successfully removed all the items we had added!
        assert my_input.is_empty();

        // print a quick summary of what we just ran
        System.out.println(String.valueOf(n) + String.valueOf(end-start));
    }
}
