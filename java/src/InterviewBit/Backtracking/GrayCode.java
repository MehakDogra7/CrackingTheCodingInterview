package InterviewBit.Backtracking;

import java.util.ArrayList;

public class GrayCode {


    public static void main(String[] args) {
        ArrayList<Integer> B = new GrayCode().grayCode(3);
        B.forEach(System.out::println);
    }

    public ArrayList<Integer> grayCode(int a) {
        if (a == 1) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(1);
            return temp;
        }

        ArrayList<Integer> temp = grayCode(a - 1);
        for (int i = temp.size() - 1; i >= 0; i--) {
            temp.add(1 << (a - 1) | temp.get(i));
        }
        return temp;
    }
}
