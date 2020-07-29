package InterviewBit.Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {

    public static void main(String[] args) {
        System.out.println(new ColorfulNumber().colorful(3245));
    }

    public int colorful(int A) {
        Set<Long> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        int temp = A;
        while (temp > 0) {
            list.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            long prod = 1;
            for (int j = i; j < list.size(); j++) {
                prod *= list.get(j);
                if (set.contains(prod)) {
                    return 0;
                }
                set.add(prod);
            }
        }
        return 1;
    }
}
