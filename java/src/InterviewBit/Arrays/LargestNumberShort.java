package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LargestNumberShort {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(54, 546, 548, 60));

        System.out.println(new LargestNumberShort().getLargestNumber(A));
    }

    private String getLargestNumber(ArrayList<Integer> A) {

        ArrayList<String> input = new ArrayList<>();
        A.forEach(i -> input.add(i.toString()));

        input.sort((s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        StringBuilder output = new StringBuilder();
        input.forEach(i -> output.append(i));

        if (output.charAt(0) == '0')
            return new String("0");
        return output.toString();
    }

}
