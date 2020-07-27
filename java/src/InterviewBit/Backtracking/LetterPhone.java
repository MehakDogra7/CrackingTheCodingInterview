package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {
    public static Map<Character, String> map = new HashMap<>();
    public static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> ans = new LetterPhone().letterCombinations("32");
        ans.forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<String> letterCombinations(String A) {
        map.clear();
        result.clear();
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");

        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");

        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        map.put('0', "0");

        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            temp.add(map.get(A.charAt(i)));
        }

        recursive(temp, "", 0, A.length());
        return result;
    }

    private void recursive(ArrayList<String> list, String str, int i, int n) {
        if (i >= n) {
            result.add(str);
            return;
        }

        String curr = list.get(i);
        for (int j = 0; j < curr.length(); j++) {
            recursive(list, str + curr.charAt(j), i + 1, n);
        }
    }
}
