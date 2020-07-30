package InterviewBit.Hashing;

import java.util.HashMap;

public class Equal {

    public static void main(String[] args) {
        int arr[] = {3, 4, 7, 1, 2, 9, 8};
        int[] fourElements = new Equal().equal(arr);
        for (int fourElement : fourElements) {
            System.out.print(fourElement + " ");
        }
    }

    public int[] equal(int[] A) {
        int n = A.length;
        HashMap<Integer, Position> mp = new HashMap<>();
        Position[] finalRes = new Position[2];

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                if (!mp.containsKey(A[i] + A[j])) {
                    mp.put(A[i] + A[j], new Position(i, j));
                }
            }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A[i] + A[j];

                if (mp.containsKey(sum)) {

                    Position p = mp.get(sum);
                    if (p.index1 != i && p.index1 != j
                            && p.index2 != i && p.index2 != j) {
                        Position[] curr = new Position[2];
                        curr[1] = new Position(i, j);
                        curr[0] = p;
                        int res = compareArray(finalRes, curr);
                        if (res != -1) {
                            finalRes = curr;
                        }
                    }
                }
            }
        }
        int[] result = new int[4];
        result[0] = finalRes[0].index1;
        result[1] = finalRes[0].index2;
        result[2] = finalRes[1].index1;
        result[3] = finalRes[1].index2;

        return result;
    }

    public int compareArray(Position[] x, Position[] y) {
        if (x[0] == null)
            return 1;
        int A1 = x[0].index1, B1 = x[0].index2, C1 = x[1].index1, D1 = x[1].index2;
        int A2 = y[0].index1, B2 = y[0].index2, C2 = y[1].index1, D2 = y[1].index2;
        int A = Integer.compare(A1, A2), B = Integer.compare(B1, B2), C = Integer.compare(C1, C2), D = Integer.compare(D1, D2);
        if (A != 0) {
            return A;
        }
        if (B != 0) {
            return B;
        }
        if (C != 0) {
            return C;
        }
        return D;
    }

    static class Position {
        int index1, index2;

        public Position(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }
}
