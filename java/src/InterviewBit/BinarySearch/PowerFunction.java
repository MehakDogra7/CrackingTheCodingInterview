package InterviewBit.BinarySearch;

public class PowerFunction {

    public static void main(String[] args) {
        //System.out.println(new PowerFunction().solve(2, 3, 3));
        //System.out.println((-1) % 20);
        System.out.println(new PowerFunction().pow(71045970, 41535484, 64735492));
/*
        System.out.println(new PowerFunction().powUsingRecursion(-6, 3));
        System.out.println(new PowerFunction().powUsingIteration(-6, 3));*/
    }

    private int powUsingRecursion(int x, int y) {

        if (y == 0)
            return 1;
        int temp = powUsingRecursion(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        } else {
            if (y > 0)
                return x * temp * temp;
            return (temp * temp) / x;
        }
    }

    private int powUsingIteration(int x, int y) {

        int res = 1;
        while (y > 0) {
            if (y % 2 != 0) {
                res = res * x;
            }

            y >>= 1;
            x = x * x;
        }

        return 0;
    }

    private int pow(int x, int n, int d) {

        if (n == 0)
            return 1 % d;

        long res = 1;
        long a = x;

        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * a) % d;
            }

            n >>= 1;
            a = (a * a) % d;
        }

        if (res < 0)
            res = (res + d) % d;

        return (int) res;
    }
}
