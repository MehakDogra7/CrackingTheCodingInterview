package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class NQueens {

    public static ArrayList<ArrayList<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        new NQueens().solveNQueens(4);
        result.forEach(i -> {
            i.forEach(System.out::println);
            System.out.println();
        });
    }

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        result.clear();

        Map<Integer, Integer> positions = new LinkedHashMap<>();
        recursive(a, 0, positions);

        return result;
    }

    private ArrayList<String> generateString(int A, Map<Integer, Integer> positions) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < A; i++) {
            str.append('.');
        }

        ArrayList<String> list = new ArrayList<>();
        positions.forEach((key, value) -> {
            StringBuilder temp = new StringBuilder(str);
            temp.setCharAt(value, 'Q');
            list.add(temp.toString());
        });
        return list;
    }

    private void recursive(int A, int row, Map<Integer, Integer> positions) {
        if (row == A) {
            result.add(generateString(A, positions));
            return;
        }

        for (int column = 0; column < A; column++) {
            boolean foundSafe = isSafe(row, column, positions);
            if (foundSafe) {
                Map<Integer, Integer> temp = new LinkedHashMap<>(positions);
                temp.put(row, column);
                recursive(A, row + 1, temp);
            }
        }
    }

    private boolean isSafe(int row, int column, Map<Integer, Integer> positions) {
        if (positions.containsValue(column))
            return false;

        for (Map.Entry<Integer, Integer> entry : positions.entrySet()) {
            Integer queenRow = entry.getKey();
            Integer queenColumn = entry.getValue();
            if (((queenRow - queenColumn) == (row - column)) || ((queenRow + queenColumn) == (row + column))) {
                return false;
            }
        }
        return true;
    }
}
