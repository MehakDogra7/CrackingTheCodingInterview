package InterviewBit.Strings;

import java.util.ArrayList;
import java.util.Stack;

public class PrettyJson {

    public static void main(String[] args) {

        new PrettyJson().prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"},K: \"L\"}}").forEach(System.out::println);
        //new PrettyJson().format("{A:\"B\",C:{D:\"E\",X: \"Y\",F:{G:\"H\",I:\"J\"}}}").forEach(System.out::println);
    }

    public ArrayList<String> prettyJSON(String A) {

        Stack<Character> stack = new Stack<>();
        ArrayList<String> res = new ArrayList<>();

        int numberOfIndents = 0;
        String temp = "";
        for (int i = 0; i < A.length() - 1; i++) {
            char curr = A.charAt(i);
            if (curr == ' ')
                continue;
            if (curr == '{' || curr == '[') {
                if (!temp.isEmpty())
                    res.add(indent(temp, numberOfIndents));
                res.add(indent(String.valueOf(curr), numberOfIndents));
                temp = new String();
                numberOfIndents++;
            } else if (curr == ',') {
                temp += curr;
                res.add(indent(temp, numberOfIndents));
                temp = new String();
            } else if (curr != '}' && curr != ']') {
                temp += curr;
            } else {
                res.add(indent(temp, numberOfIndents));
                temp = new String();

                temp += curr;
                numberOfIndents--;
            }
        }
        res.add(indent(temp, numberOfIndents));
        res.add(String.valueOf(A.charAt(A.length() - 1)));

        return res;
    }

    private String indent(String str, int numberOfIndents) {

        String res = new String(str);
        for (int i = 0; i < numberOfIndents; i++) {
            res = "\t" + res;
        }

        return res;
    }

}
