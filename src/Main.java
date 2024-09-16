import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(MultiSet my_input, int n) {

        int[] items_added = new int[n];
        for (int i = 0; i < n; i++) {
            int x = ThreadLocalRandom.current().nextInt(0, 101);
            my_input.add(x);
            items_added[i] = x;

        }

    }
}
