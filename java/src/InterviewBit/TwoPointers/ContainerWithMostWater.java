package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(1, 5, 4, 3));

        System.out.println(new ContainerWithMostWater().maxAreaBruteForce(A));
        System.out.println(new ContainerWithMostWater().maxArea(A));
    }

    public int maxAreaBruteForce(ArrayList<Integer> A) {
        int area = 0;

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int temp = (j - i) * (Integer.min(A.get(i), A.get(j)));
                area = Integer.max(area, temp);
            }
        }

        return area;
    }

    public int maxArea(ArrayList<Integer> A) {
        int area = 0;

        int p1 = 0, p2 = A.size() - 1;
        while (p1 < p2) {
            int temp = 0;
            if (A.get(p1) <= A.get(p2)) {
                temp = (p2 - p1) * A.get(p1);
                p1++;
            } else {
                temp = (p2 - p1) * A.get(p2);
                p2--;
            }
            area = Integer.max(temp, area);
        }

        return area;
    }
}
