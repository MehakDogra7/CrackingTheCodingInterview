package InterviewBit.Arrays;

import java.util.ArrayList;

public class PascalTriangle {

    public static void main(String[] args) {
        int[][] result = pascalTriangle(6);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<ArrayList<Integer>> resultArrayList = pascalTriangleArrayList(6);
        for (int i = 0; i < resultArrayList.size(); i++) {
            for (int j = 0; j < resultArrayList.get(i).size(); j++) {
                System.out.print(resultArrayList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static int[][] pascalTriangle(int A) {

        int[][] result = new int[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j <= i; j++) {

                if (j == 0) {
                    result[i][j] = 1;
                    continue;
                }
                int value1 = (i - 1 < 0 || j - 1 < 0) ? 1 : result[i - 1][j - 1];
                int value2 = (i - 1 < 0) ? 1 : result[i - 1][j];
                result[i][j] = value1 + value2;
            }
        }

        return result;
    }

    private static ArrayList<ArrayList<Integer>> pascalTriangleArrayList(int A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < A; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {

                if (j == 0) {
                    temp.add(1);
                    continue;
                }
                int value1 = (i - 1 < 0 || j - 1 < 0) ? 1 : result.get(i - 1).get(j - 1);
                int value2 = (i - 1 < 0 || i == j) ? 0 : result.get(i - 1).get(j);
                temp.add(value1 + value2);
            }
            result.add(temp);
        }

        return result;
    }


}
