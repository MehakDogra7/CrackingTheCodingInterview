package InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class Array3Pointers {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(List.of(3, 110, 133, 236, 254, 259, 293, 303, 328, 370, 451, 459, 472, 475, 476, 512, 525, 572, 587, 621, 676, 684, 692, 744, 753, 767, 806, 816, 831, 833, 867, 884, 898, 911, 912, 913, 928, 952, 971, 1000, 1003, 1017, 1029, 1051, 1058, 1070, 1108, 1122, 1126, 1150, 1153, 1153, 1254, 1281, 1301, 1324, 1372, 1389, 1389, 1395, 1398, 1447, 1457, 1457, 1482, 1493, 1519, 1560, 1561, 1601, 1636, 1669, 1671, 1697, 1739, 1746, 1747, 1753, 1758, 1763, 1768, 1774, 1817, 1844, 1868, 1871, 1880, 1891, 1897, 1902, 1937, 1967, 1983, 1983, 1986, 2060, 2062, 2070, 2101, 2108, 2113, 2144, 2157, 2162, 2166, 2182, 2191, 2299, 2310, 2314, 2349, 2525, 2529, 2533, 2535, 2546, 2597, 2599, 2600, 2619, 2637, 2648, 2687, 2695, 2703, 2722, 2766, 2774, 2784, 2811, 2832, 2838, 2901, 2903, 2908, 2916, 2943, 2954, 2962, 2964, 2985, 3017, 3035, 3076, 3096, 3123, 3158, 3160, 3187, 3188, 3207, 3221, 3242, 3265, 3306, 3322, 3392, 3409, 3420, 3423, 3431, 3448, 3456, 3464, 3482, 3490, 3499, 3561, 3674, 3724, 3744, 3772, 3782, 3814, 3846, 3896, 3909, 3915, 3925, 3928, 4015, 4036, 4038, 4047, 4070, 4078, 4082, 4148, 4156, 4159, 4184, 4191, 4209, 4241, 4265, 4269, 4328, 4332, 4367, 4386, 4393, 4397, 4399, 4399, 4405, 4409, 4413, 4415, 4436, 4440, 4447, 4448, 4450, 4483, 4580, 4585, 4600, 4615, 4639, 4644, 4651, 4685, 4691, 4704, 4759, 4791, 4793, 4826, 4834, 4854, 4937, 4947, 4957, 4966, 4970, 4996, 5033, 5037, 5063, 5069, 5109, 5136, 5141, 5155, 5202, 5212, 5221, 5222, 5235, 5255, 5313, 5317, 5391, 5445, 5450, 5555, 5556, 5558, 5572, 5596, 5618, 5630, 5636, 5654, 5656, 5676, 5680, 5683, 5683, 5692, 5693, 5720, 5749, 5757, 5801, 5823, 5823, 5832, 5885, 5923, 5925, 5927, 5928, 6004, 6019, 6051, 6051, 6052, 6077, 6090, 6106, 6116, 6135, 6160, 6171, 6193, 6195, 6227, 6273, 6274, 6299, 6310, 6327, 6329, 6331, 6340, 6341, 6351, 6393, 6422, 6429, 6508, 6519, 6554, 6556, 6580, 6605, 6616, 6625, 6631, 6649, 6661, 6670, 6670, 6670, 6684, 6688, 6690, 6698, 6724, 6740, 6740, 6762, 6765, 6767, 6804, 6814, 6828, 6833, 6891, 6899, 6932, 6946, 6963, 6986, 7012, 7062, 7101, 7179, 7191, 7291, 7304, 7318, 7321, 7331, 7387, 7394, 7415, 7462, 7465, 7466, 7471, 7513, 7608, 7626, 7632, 7647, 7708, 7752, 7785, 7795, 7798, 7877, 7916, 7922, 7947, 8000, 8009, 8028, 8042, 8048, 8048, 8097, 8124, 8200, 8206, 8210, 8240, 8241, 8365, 8396, 8398, 8434, 8436, 8459, 8460, 8474, 8511, 8526, 8546, 8551, 8579, 8583, 8586, 8627, 8634, 8643, 8656, 8661, 8665, 8681, 8697, 8702, 8711, 8723, 8726, 8748, 8764, 8788, 8820, 8824, 8825, 8826, 8833, 8918, 8922, 8924, 8935, 8951, 8983, 8996, 9000, 9013, 9017, 9057, 9075, 9114, 9122, 9136, 9137, 9174, 9179, 9180, 9188, 9195, 9220, 9223, 9238, 9258, 9281, 9305, 9307, 9312, 9335, 9370, 9415, 9424, 9425, 9431, 9479, 9484, 9543, 9559, 9570, 9574, 9592, 9597, 9628, 9635, 9657, 9658, 9667, 9764, 9772, 9774, 9832, 9894, 9901, 9902, 9920, 9964, 9970, 9975));
        ArrayList<Integer> B = new ArrayList<>(List.of(56, 309, 1053, 1106, 1133, 1151, 1207, 1301, 1368, 1502, 2029, 2169, 2311, 2363, 2547, 3032, 3449, 3653, 3780, 3783, 3835, 3844, 3861, 3989, 3990, 4151, 4488, 4818, 4862, 4895, 4940, 5268, 5362, 5366, 5438, 5692, 5892, 6056, 6361, 6445, 6485, 6576, 6615, 6684, 6886, 7149, 7193, 7238, 7256, 7357, 7479, 7581, 7653, 7741, 7850, 8463, 8763, 8864, 9049, 9089, 9221, 9793, 9907, 9990));
        ArrayList<Integer> C = new ArrayList<>(List.of(19, 152, 221, 238, 383, 418, 510, 591, 605, 775, 813, 903, 1107, 1110, 1163, 1209, 1229, 1244, 1263, 1271, 1276, 1528, 1528, 1558, 1934, 2201, 2210, 2253, 2348, 2379, 2556, 2632, 2674, 2727, 2842, 2884, 2970, 3000, 3069, 3171, 3173, 3188, 3207, 3318, 3464, 3520, 3521, 3567, 3724, 3923, 3951, 3952, 3954, 4024, 4027, 4143, 4220, 4300, 4332, 4342, 4501, 4514, 4780, 4897, 4967, 4984, 4992, 5030, 5175, 5193, 5205, 5276, 5351, 5355, 5376, 5392, 5943, 5944, 5980, 6151, 6220, 6259, 6317, 6445, 6795, 6807, 6833, 6975, 7028, 7046, 7061, 7268, 7362, 7382, 7463, 7473, 7580, 7637, 7830, 7911, 7921, 7995, 8017, 8107, 8172, 8218, 8239, 8242, 8444, 8588, 8692, 8792, 8820, 8958, 9169, 9176, 9421, 9428, 9458, 9503, 9592, 9641, 9754, 9826, 9866, 9921, 9924));

        System.out.println(new Array3Pointers().minimizeBruteForce(A, B, C));
        System.out.println(new Array3Pointers().minimize(A, B, C));
    }

    public int minimizeBruteForce(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

        int res = Integer.MAX_VALUE;
        int x = 0, y = 0, z = 0;

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                for (int k = 0; k < C.size(); k++) {
                    int curr = max((A.get(i) - B.get(j)), (B.get(j) - C.get(k)), (C.get(k) - A.get(i)));
                    //res = Integer.min(res, curr);
                    if (curr < res) {
                        res = curr;
                        x = A.get(i);
                        y = B.get(j);
                        z = C.get(k);
                    }
                }
            }
        }

        System.out.println(x + " " + y + " " + z);
        return res;
    }

    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {

        int res = Integer.MAX_VALUE;

        for (Integer a : A) {
            int b = getJustMinBinarySearch(B, a);
            if (b != -1) {
                int c = getJustMinBinarySearch(C, a);
                if (c != -1) {
                    int temp = max((a - b), (b - c), (c - a));
                    res = Integer.min(res, temp);
                }
            }
        }

        for (Integer b : B) {
            int a = getJustMinBinarySearch(A, b);
            if (a != -1) {
                int c = getJustMinBinarySearch(C, b);
                if (c != -1) {
                    int temp = max((a - b), (b - c), (c - a));
                    res = Integer.min(res, temp);
                }
            }
        }

        for (Integer c : C) {
            int b = getJustMinBinarySearch(B, c);
            if (b != -1) {
                int a = getJustMinBinarySearch(A, c);
                if (a != -1) {
                    int temp = max((a - b), (b - c), (c - a));
                    res = Integer.min(res, temp);
                }
            }
        }

        return res;
    }

    public int getJustMinBinarySearch(List<Integer> list, int n) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == n) {
                return list.get(mid);
            } else if (list.get(mid) < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (low == 0) {
            return -1;
        }
        return list.get(low - 1);
    }

    public int max(int a, int b, int c) {
        a = Math.abs(a);
        b = Math.abs(b);
        c = Math.abs(c);

        return Integer.max(a, Integer.max(b, c));
    }
}
