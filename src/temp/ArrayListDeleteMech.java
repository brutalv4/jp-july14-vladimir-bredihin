package temp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricky on 11/18/14.
 */
public class ArrayListDeleteMech {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(Integer.valueOf(i));
        }

        System.out.println();

        int n = 3;
        int m = 5;

        list.subList(m, m+n).clear();
    }
}
