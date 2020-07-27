package JavaCollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorAndCollections {

    public static void main(String[] args) {
        List<Integer> collection = new ArrayList<>(List.of(2, 4, 3, 1, 5));
        Collections.sort(collection, new MyComparator());

        collection.forEach(i -> System.out.print(i + " "));
        System.out.println();

        ArrayList<Integer> arrayList = new ArrayList<>(List.of(2, 4, 3, 1, 5));
        arrayList.sort(new MyComparator());
        arrayList.forEach(i -> System.out.print(i + " "));
        System.out.println();

        ArrayList<Integer> lambda = new ArrayList<>(List.of(2, 4, 3, 1, 5));
        lambda.sort((x, y) -> {
            if (x < y) return -1;
            else if (x > y) return 1;
            return 0;
        });
        lambda.forEach(i -> System.out.print(i + " "));
        System.out.println();

        ArrayList<Integer> efficient = new ArrayList<>(List.of(2, 4, 3, 1, 5));
        efficient.sort(Integer::compareTo);
        efficient.forEach(i -> System.out.print(i + " "));
        System.out.println();

    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            if (x < y) return -1;
            else if (x > y) return 1;
            return 0;
        }
    }

}
