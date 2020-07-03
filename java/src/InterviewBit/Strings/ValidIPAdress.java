package InterviewBit.Strings;

import java.util.ArrayList;

public class ValidIPAdress {

    public static void main(String[] args) {

        new ValidIPAdress().restoreIpAddresses("0100100").forEach(System.out::println);
        new ValidIPAdress().restoreIpAddresses("25525511135").forEach(System.out::println);
    }

    public ArrayList<String> restoreIpAddresses(String A) {

        if (A.length() > 12)
            return new ArrayList<>();

        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            for (int j = i + 1; j < A.length(); j++) {
                for (int k = j + 1; k < A.length() - 1; k++) {
                    String ip = A.substring(0, i + 1) + "." +
                            A.substring(i + 1, j + 1) + "." +
                            A.substring(j + 1, k + 1) + "." +
                            A.substring(k + 1);
                    if (isIPValid(ip)) {
                        res.add(ip);
                    }
                }
            }
        }

        return res;
    }

    public boolean isIPValid(String ip) {

        String[] split = ip.split("\\.");
        for (int i = 0; i < split.length; i++) {
            if ((split[i].startsWith("0") && split[i].length() != 1)
                    || split[i].length() < 1) {
                return false;
            }
            int val = Integer.parseInt(split[i]);
            if (val < 0 || val > 255)
                return false;
        }

        return true;
    }
}
