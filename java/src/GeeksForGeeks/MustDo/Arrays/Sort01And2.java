package GeeksForGeeks.MustDo.Arrays;

import java.util.Scanner;

public class Sort01And2 {
    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int count0 = 0, count1 = 0, count2 = 0;
            for (int i = 0; i < n; i++) {
                int curr = sc.nextInt();
                if (curr == 0) count0++;
                else if (curr == 1) count1++;
                else count2++;
            }
            for (int i = 0; i < count0; i++) System.out.print(0 + " ");
            for (int i = 0; i < count1; i++) System.out.print(1 + " ");
            for (int i = 0; i < count2; i++) System.out.print(2 + " ");
            System.out.println();
            t--;
        }
    }
}
