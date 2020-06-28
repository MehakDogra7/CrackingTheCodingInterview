package InterviewBit.Strings;

public class CountAndSay {

    public static void main(String[] args) {

        System.out.println(new CountAndSay().countAndSay(2));
    }

    public String countAndSay(int A) {

        int i = 1;
        String str = "1";
        while (i <= A - 1) {
            str = say(str);
            i++;
        }
        return str;
    }

    private String say(String prev) {

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < prev.length()) {
            int count = 1;
            int j = i + 1;
            while (j < prev.length() && prev.charAt(i) == prev.charAt(j)) {
                count++;
                j++;
            }
            res.append(count);
            res.append(prev.charAt(i));
            i = j;
        }

        return res.toString();
    }
}
