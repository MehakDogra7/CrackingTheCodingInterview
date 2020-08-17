package CollegeAssignments.Java.Activity1;

public class MatchingParanthesis {

    public static void main(String[] args) {
        String s = "([]{()})";
        String res = matchRecursive(s.toCharArray(), 0, s.length()) ? "Success" : "MisMatch";
        System.out.println(res);
    }

    static char findClosing(char c) {
        if (c == '(')
            return ')';
        if (c == '{')
            return '}';
        if (c == '[')
            return ']';
        return Character.MIN_VALUE;
    }

    static boolean matchRecursive(char expr[], int start, int end) {
        if (start == end) {
            return true;
        }
        if (end - start == 1) {
            System.out.println("Failed at: " + start);
            return false;
        }
        if (expr[start] == ')' || expr[start] == '}' || expr[start] == ']') {
            System.out.println("Failed at: " + start);
            return false;
        }

        char closing = findClosing(expr[start]);
        int i, count = 0;
        for (i = start + 1; i < end; i++) {
            if (expr[i] == expr[start])
                count++;
            if (expr[i] == closing) {
                if (count == 0)
                    break;
                count--;
            }
        }

        if (i == end) {
            System.out.println("Failed at: " + end);
            return false;
        }

        if (i == start + 1) return matchRecursive(expr, i + 1, end);
        return matchRecursive(expr, start + 1, i) && matchRecursive(expr, i + 1, end);
    }
}
