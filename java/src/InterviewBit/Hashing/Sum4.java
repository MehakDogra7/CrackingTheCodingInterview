package InterviewBit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Sum4 {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 0, -1, 0, -2, 2));
        ArrayList<ArrayList<Integer>> result = new Sum4().fourSum(A, 0);
        result.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        class Position {
            int index1;
            int index2;

            public Position(int index1, int index2) {
                this.index1 = index1;
                this.index2 = index2;
            }
        }
        HashMap<Integer, ArrayList<Position>> pairs = new HashMap<>();
        HashSet<ArrayList<Integer>> tempResult = new HashSet<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                Position position = new Position(i, j);
                int currSum = A.get(i) + A.get(j);

                if (pairs.containsKey(B - currSum)) {
                    ArrayList<Position> p2 = pairs.get(B - currSum);
                    for (int k = 0; k < p2.size(); k++) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        Position currPosition1 = position;
                        Position currPosition2 = p2.get(k);
                        if (currPosition1.index1 != currPosition2.index1 &&
                                currPosition1.index1 != currPosition2.index2 &&
                                currPosition1.index2 != currPosition2.index1 &&
                                currPosition1.index2 != currPosition2.index2) {
                            ArrayList<Integer> l = populateTempList(A.get(currPosition1.index1),
                                    A.get(currPosition1.index2),
                                    A.get(currPosition2.index1),
                                    A.get(currPosition2.index2));
                            tempResult.add(l);
                        }
                    }
                }

                if (pairs.containsKey(currSum)) {
                    pairs.get(currSum).add(position);
                } else {
                    ArrayList<Position> p = new ArrayList<>();
                    p.add(position);
                    pairs.put(A.get(i) + A.get(j), p);
                }
            }

        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>(tempResult);
        sort(result);
        return result;
    }

    private void sort(ArrayList<ArrayList<Integer>> result) {
        result.sort((x, y) -> {
            for (int i = 0; i < Integer.min(x.size(), y.size()); i++) {
                if (x.get(i) < y.get(i)) {
                    return -1;
                } else if (y.get(i) < x.get(i))
                    return 1;
            }
            if (x.size() < y.size())
                return -1;
            return 1;
        });
    }

    private ArrayList<Integer> populateTempList(Integer a, Integer b, Integer c, Integer d) {

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(a);
        temp.add(b);
        temp.add(c);
        temp.add(d);
        temp.sort(Integer::compareTo);
        return temp;
    }
}
