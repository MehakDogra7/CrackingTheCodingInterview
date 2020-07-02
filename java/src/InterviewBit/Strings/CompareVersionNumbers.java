package InterviewBit.Strings;

import java.util.ArrayList;

public class CompareVersionNumbers {

    public static void main(String[] args) {

        //0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
        System.out.println(new CompareVersionNumbers().compareVersion("45", "54"));
    }

    public int compareVersion(String A, String B) {


        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        int prev = 0;

        for (int i = 0; i < A.length() && prev < A.length(); i++) {
            if (A.charAt(i) == '.') {
                a.add(A.substring(prev, i));
                prev = i + 1;
            } else if (i == A.length() - 1) {
                a.add(A.substring(prev, i + 1));
            }
        }

        prev = 0;
        for (int i = 0; i < B.length() && prev < B.length(); i++) {
            if (B.charAt(i) == '.') {
                b.add(B.substring(prev, i));
                prev = i + 1;
            } else if (i == B.length() - 1) {
                b.add(B.substring(prev, i + 1));
            }
        }

        int compare = 0;
        int i = 0;
        while (i < a.size() && i < b.size()) {
            compare = compare(a.get(i), b.get(i));
            if (compare != 0) {
                return compare;
            }
            i++;
        }

        if (a.size() == b.size() || isAllZero(a, b)) {
            return 0;
        }
        return Integer.compare(a.size(), b.size());
    }

    private boolean isAllZero(ArrayList<String> a, ArrayList<String> b) {

        for (int i = b.size(); i < a.size(); i++) {
            if (!a.get(i).equals("0"))
                return false;
        }

        for (int i = a.size(); i < b.size(); i++) {
            if (!b.get(i).equals("0"))
                return false;
        }
        return true;
    }

    private int compare(String m, String n) {

        m = removePrecedingZeros(m);
        n = removePrecedingZeros(n);

        if (m.length() != n.length()) {
            if (m.length() > n.length()) {
                return 1;
            }
            return -1;
        }

        int i = 0, j = 0;
        while (i < m.length() && j < n.length()) {
            int c1 = Integer.parseInt(String.valueOf(m.charAt(i)));
            int c2 = Integer.parseInt(String.valueOf(n.charAt(j)));
            if (c2 > c1) {
                return -1;
            } else if (c2 < c1) {
                return 1;
            } else {
                i++;
                j++;
            }
        }
        return 0;
    }

    private String removePrecedingZeros(String x) {

        String str = "";
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != '0') {
                str += x.substring(i);
                break;
            }
        }
        return str;
    }
}
