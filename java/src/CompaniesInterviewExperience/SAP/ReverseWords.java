package CompaniesInterviewExperience.SAP;

import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String A = sc.next();
            System.out.println(solve(A));
            t--;
        }
    }

    public static String solve(String A) {
        String[] temp = A.split("\\.");

        for (int i = 0, j = temp.length - 1; i < j; i++, j--) {
            String t = temp[i];
            temp[i] = temp[j];
            temp[j] = t;
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < temp.length; i++) {
            sb.append(temp[i]);
            sb.append(".");
        }

        return sb.toString();
    }
}
