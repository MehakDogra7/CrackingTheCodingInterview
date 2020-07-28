package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(List.of(
                "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"
        ));
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        A.forEach(str -> {
            ArrayList<Character> temp = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                temp.add(str.charAt(i));
            }
            a.add(temp);
        });

        new Sudoku().solveSudoku(a);
        a.forEach(list -> {
            list.forEach(character -> {
                System.out.print(character + " ");
            });
            System.out.println();
        });
    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        recursive(a);
    }

    private boolean recursive(ArrayList<ArrayList<Character>> A) {
        int[] cell = new int[2]; //row, column

        cell = getUnassignedRowColumn(A);
        if (cell[0] == -1)
            return true;

        int row = cell[0];
        int column = cell[1];

        for (int num = 1; num <= 9; num++) {
            if (isSafe(A, row, column, num)) {
                A.get(row).set(column, (char) (num + 48));
                if (recursive(A)) {
                    return true;
                }
                A.get(row).set(column, '.');
            }
        }

        return false;
    }

    private boolean isSafe(ArrayList<ArrayList<Character>> A, int rowToCheck, int columnToCheck, int num) {
        for (Character character : A.get(rowToCheck)) {
            if (character == (char) (num + 48)) {
                return false;
            }
        }

        for (ArrayList<Character> list : A) {
            if (list.get(columnToCheck) == (char) (num + 48)) {
                return false;
            }
        }

        int gridRowStart = (rowToCheck / 3) * 3;
        int gridColumnStart = (columnToCheck / 3) * 3;
        for (int i = gridRowStart; i < gridRowStart + 3; i++) {
            for (int j = gridColumnStart; j < gridColumnStart + 3; j++) {
                if (A.get(i).get(j) == (char) (num + 48)) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[] getUnassignedRowColumn(ArrayList<ArrayList<Character>> A) {

        int[] cell = new int[2];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if (A.get(i).get(j) == '.') {
                    cell[0] = i;
                    cell[1] = j;
                    return cell;
                }
            }
        }

        cell[0] = -1;
        cell[1] = -1;
        return cell;
    }
}
