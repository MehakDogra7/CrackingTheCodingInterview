package InterviewBit.Strings;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {

        System.out.println(new IntegerToRoman().convertToRoman(14));

    }

    private String convertToRoman(int A) {

        Map<Integer, String> romanDict = new LinkedHashMap<>();
        romanDict.put(1000, "M");
        romanDict.put(900, "CM");
        romanDict.put(500, "D");
        romanDict.put(400, "CD");
        romanDict.put(100, "C");
        romanDict.put(90, "XC");

        romanDict.put(50, "L");
        romanDict.put(40, "XL");
        romanDict.put(10, "X");
        romanDict.put(9, "IX");
        romanDict.put(5, "V");
        romanDict.put(4, "IV");
        romanDict.put(1, "I");


        StringBuilder roman = new StringBuilder();
        int temp = A;
        ArrayList<Integer> key = new ArrayList<>(romanDict.keySet());

        while (temp > 0) {
            int nearestBase = 1000;
            int i = 0;
            while (i < romanDict.size()) {
                if (temp >= key.get(i)) {
                    nearestBase = key.get(i);
                    break;
                }
                i++;
            }

            int quotient = temp / nearestBase;
            temp = temp - quotient * nearestBase;

            while (quotient > 0) {
                roman.append(romanDict.get(nearestBase));
                quotient--;
            }
        }
        return roman.toString();
    }

}
