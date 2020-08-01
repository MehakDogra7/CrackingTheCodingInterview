package InterviewBit.Hashing;

public class WindowString {

    public static void main(String[] args) {
        String S = "xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh";
        String T = "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h";

        System.out.println(new WindowString().minWindow(S, T));
    }

    public String minWindow(String A, String B) {
        if (A.length() < B.length())
            return "";

        int finalStart = -1, start = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        char[] mapA = new char[256];
        char[] mapB = new char[256];

        for (int i = 0; i < B.length(); i++) {
            mapB[B.charAt(i)]++;
        }

        for (int i = 0; i < A.length(); i++) {
            mapA[A.charAt(i)]++;

            if (mapB[A.charAt(i)] > 0 &&
                    mapA[A.charAt(i)] <= mapB[A.charAt(i)]) {
                count++;
            }

            if (count == B.length()) {
                while (mapB[A.charAt(start)] == 0 ||
                        (mapA[A.charAt(start)] > mapB[A.charAt(start)])) {

                    if (mapA[A.charAt(start)] > mapB[A.charAt(start)])
                        mapA[A.charAt(start)]--;

                    start++;
                }

                int len = i - start + 1;
                if (minLength > len) {
                    finalStart = start;
                    minLength = len;
                }
            }
        }

        if (finalStart == -1) {
            return "";
        }

        return A.substring(finalStart, finalStart + minLength);
    }


}