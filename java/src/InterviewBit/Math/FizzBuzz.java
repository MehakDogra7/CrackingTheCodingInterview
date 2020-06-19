package InterviewBit.Math;

import java.util.ArrayList;

public class FizzBuzz {

    public static void main(String[] args) {

        getArray(15).forEach(i -> System.out.print(i + " "));
    }

    private static ArrayList<String> getArray(int A) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 1; i <= A; i++) {
            result.add((i % 3 == 0) ?
                    ((i % 5 == 0) ? "FizzBuzz" : "Fizz") :
                    ((i % 5 == 0) ? "Buzz" : String.valueOf(i)));
        }
        return result;
    }
}
