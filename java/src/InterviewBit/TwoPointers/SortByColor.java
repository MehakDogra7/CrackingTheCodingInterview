package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class SortByColor {

    public static void main(String[] args) {

        //0: Red
        //1: White
        //2: Blue
        ArrayList<Integer> a = new ArrayList<>(List.of(0, 1, 2, 0, 1, 2));
        new SortByColor().sortColors(a);
        a.forEach(i -> System.out.print(i + " "));
    }

    public void sortColors(ArrayList<Integer> a) {
        int countRed = 0;
        int countWhite = 0;
        int countBlue = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == 0)
                countRed++;
            else if (a.get(i) == 1)
                countWhite++;
            else
                countBlue++;
        }

        int index = 0;
        int i = 0;
        while (i < countRed) {
            a.set(index++, 0);
            i++;
        }
        i = 0;
        while (i < countWhite) {
            a.set(index++, 1);
            i++;
        }
        i = 0;
        while (i < countBlue) {
            a.set(index++, 2);
            i++;
        }
    }
}
