package InterviewBit.Arrays;

import java.util.ArrayList;

public class Flip {
    public static void main(String[] args) {

        //ArrayList<Integer> A = new ArrayList<Integer>(List.of(1, 1, 0, 1, 0, 1, 1, 0));
        String A = "010111";
        getFlippedIndex(A).forEach(System.out::println);
        getFlippedIndexOptimal(A).forEach(System.out::println);
    }

    private static ArrayList<Integer> getFlippedIndex(String A) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> input = new ArrayList<>();
        int L = 0, R = 0;
        int curr_L = 0;
        int curr_R = 0;
        int count = 0;
        int max = 0;
        int finalMax = 0;
        boolean flag = false;

        for (char c : A.toCharArray()) {
            input.add(Integer.parseInt(Character.toString(c)));
        }

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == 0) {
                curr_L = i;
                curr_R = i;
                count = 0;
                for (int j = i; j < input.size(); j++) {
                    if (input.get(j) == 1) {
                        count--;
                    } else {
                        count++;
                    }

                    if (max < count) {
                        max = count;
                        curr_R = j;
                    }
                }
            }
            if (finalMax < max) {
                flag = true;
                finalMax = max;
                L = curr_L;
                R = curr_R;
            }
        }

        if (flag) {
            result.add(L + 1);
            result.add(R + 1);
        }
        return result;
    }

    private static ArrayList<Integer> getFlippedIndexOptimal(String A) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> input = new ArrayList<>();
        int L = 0;
        int R = 0;
        int current = 0;
        boolean flag = false;

        for (char c : A.toCharArray()) {
            input.add(Integer.parseInt(Character.toString(c)));
        }

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == 1) {
                input.set(i, -1);
            } else {
                flag = true;
                input.set(i, 1);
            }
        }

        int max = input.get(0);
        int curr_max = input.get(0);

        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) > curr_max + input.get(i)) {
                curr_max = input.get(i);
                current = i;
            } else {
                curr_max += input.get(i);
            }

            if (max < curr_max) {
                max = curr_max;
                L = current;
                R = i;
            }
        }

        if (flag) {
            result.add(L + 1);
            result.add(R + 1);
        }
        return result;
    }
}