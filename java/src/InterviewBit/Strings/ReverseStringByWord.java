package InterviewBit.Strings;

public class ReverseStringByWord {

    public static void main(String[] args) {

        System.out.println(reverse("the sky is blue"));
        System.out.println(reverse("   the sky is    blue     "));
        System.out.println(reverse("hello"));
        System.out.println(reverse(" hello  "));
    }

    private static String reverse(String A) {

        StringBuilder res = new StringBuilder();

        int i = A.length() - 1;
        while (i >= 0) {

            StringBuilder temp = new StringBuilder();
            int j = i;
            while (j >= 0 && A.charAt(j) != ' ') {
                temp.append(A.charAt(j));
                j--;
            }

            if (temp.length() > 0) {
                for (int k = temp.length() - 1; k >= 0; k--) {
                    res.append(temp.charAt(k));
                }
                res.append(' ');
            }

            i = j - 1;
        }

        return res.toString().substring(0, res.length() - 1);
    }
}
