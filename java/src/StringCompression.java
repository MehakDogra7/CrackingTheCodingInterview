public class StringCompression {

    public static void main(String[] args) {
        String str1 = "aabbbcccccd";
        String str2 = "aabcd";

        System.out.println("Compression of " + str1 + " is: " + compress(str1));
        System.out.println("Compression of " + str2 + " is: " + compress(str2));
    }

    private static StringBuilder compress(String str) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int j = i, count = 0;
            while (j < str.length() && str.charAt(i) == str.charAt(j)) {
                count++;
                j++;
            }
            res.append(str.charAt(i) + String.valueOf(count));
            i = j;
        }

        return res.length() < str.length() ? res : new StringBuilder(str);
    }
}
