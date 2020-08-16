package IIITCodingClub;

public class DecentNumber {

    public static void main(String[] args) {
        decentNumber(13);
    }

    static void decentNumber(int n) {
        int K = 5 * ((2 * n) % 3);
        if (K > n) {
            System.out.println(-1);
            return;
        } else {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < (n - K); i++) {
                res.append("5");
            }
            for (int i = 0; i < K; i++) {
                res.append("3");
            }
            System.out.println(res);
        }
    }

}
