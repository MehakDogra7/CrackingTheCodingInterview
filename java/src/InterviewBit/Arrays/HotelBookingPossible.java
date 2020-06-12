package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class HotelBookingPossible {

    public static void main(String[] args) {

        ArrayList<Integer> arrivals = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> departures = new ArrayList<>(List.of(2, 3, 4));
        int k = 1;

        System.out.println(isBookingsPossibleOptimal(arrivals, departures, k));
    }

    private static boolean isBookingsPossibleOptimal(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        arrive.sort(Integer::compareTo);
        depart.sort(Integer::compareTo);

        for (int i = 0; i < arrive.size(); i++) {
            if ((i + K) < arrive.size() && arrive.get(i + K) < depart.get(i)) {
                return false;
            }
        }
        return true;
    }
}
