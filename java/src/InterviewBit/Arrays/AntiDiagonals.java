package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonals {

    public static void main(String[] args) {
        final List<ArrayList<Integer>> A = new ArrayList<>();

        A.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        ArrayList<ArrayList<Integer>> result = antiDiagonals(A);
        result.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    private static ArrayList<ArrayList<Integer>> antiDiagonals(List<ArrayList<Integer>> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int column = 0; column < A.get(0).size(); column++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int startColumn = column, startRow = 0;
            while (startColumn >= 0 && startRow < A.size()) {
                temp.add(A.get(startRow).get(startColumn));
                startColumn--;
                startRow++;
            }
            result.add(temp);
        }

        for (int row = 1; row < A.size(); row++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int startRow = row, startColumn = A.get(0).size() - 1;
            while (startColumn >= 0 && startRow < A.size()) {
                temp.add(A.get(startRow).get(startColumn));
                startColumn--;
                startRow++;
            }
            result.add(temp);
        }

        return result;
    }

}
