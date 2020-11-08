package GeeksForGeeks.MustDo;

import java.util.Scanner;

public class MinimumPlatforms {
    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] arrival = new int[n];
            int[] departure = new int[n];
            for (int i = 0; i < n; i++) {
                arrival[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                departure[i] = sc.nextInt();
            }
            System.out.println(solve(arrival, departure));
            t--;
        }
    }

    private static int solve(int[] arrival, int[] departure) {
        int[] platform = new int[2361];
        int platformNeeded = 1;

        for (int i = 0; i < arrival.length; i++) {
            platform[arrival[i]]++;
            platform[departure[i] + 1]--;
        }

        for (int i = 1; i < 2361; i++) {
            platform[i] += platform[i - 1];
            platformNeeded = Math.max(platformNeeded, platform[i]);
        }

        return platformNeeded;
    }


}
