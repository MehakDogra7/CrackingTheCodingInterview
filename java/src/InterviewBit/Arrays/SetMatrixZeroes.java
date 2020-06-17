package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        final List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

        A.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        A.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        A.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        A.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        A.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });

        System.out.println();
        new SetMatrixZeroes().setZeroes(A);

        A.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public void setZeroes(List<ArrayList<Integer>> a) {

        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;

        for (int column = 0; column < a.get(0).size(); column++) {
            if (a.get(0).get(column) == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for (int row = 0; row < a.size(); row++) {
            if (a.get(row).get(0) == 0) {
                isFirstColumnZero = true;
                break;
            }
        }

        for (int row = 1; row < a.size(); row++) {
            for (int column = 1; column < a.get(row).size(); column++) {
                if (a.get(row).get(column) == 0) {
                    a.get(0).set(column, 0);
                    a.get(row).set(0, 0);
                }
            }
        }

        for (int column = 1; column < a.get(0).size(); column++) {
            if (a.get(0).get(column) == 0) {
                markColumnAsZero(a, column);
            }
        }

        for (int row = 1; row < a.size(); row++) {
            if (a.get(row).get(0) == 0) {
                markRowAsZero(a, row);
            }
        }

        if (isFirstRowZero) {
            markRowAsZero(a, 0);
        }

        if (isFirstColumnZero) {
            markColumnAsZero(a, 0);
        }
    }

    private void markRowAsZero(List<ArrayList<Integer>> A, int row) {
        for (int column = 0; column < A.get(row).size(); column++) {
            A.get(row).set(column, 0);
        }
    }

    private void markColumnAsZero(List<ArrayList<Integer>> A, int column) {
        for (int row = 0; row < A.size(); row++) {
            A.get(row).set(column, 0);
        }
    }
}
