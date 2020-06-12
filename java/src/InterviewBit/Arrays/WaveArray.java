package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class WaveArray {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        getWaveArray(A).forEach(System.out::println);
    }

    private static ArrayList<Integer> getWaveArray(ArrayList<Integer> A) {

        A.sort(Integer::compareTo);

        for (int i = 0; i < A.size() - 1; i += 2) {
            int temp = A.get(i);
            A.set(i, A.get(i + 1));
            A.set(i + 1, temp);
        }
        return A;
    }


}
