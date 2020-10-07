package InterviewBit.GreedyAlgorithm;

import java.util.*;

public class MeetingRooms {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        A.add(new ArrayList<>(Arrays.asList(1, 18)));
        A.add(new ArrayList<>(Arrays.asList(18, 23)));
        A.add(new ArrayList<>(Arrays.asList(15, 29)));

        A.add(new ArrayList<>(Arrays.asList(4, 15)));
        A.add(new ArrayList<>(Arrays.asList(2, 11)));
        A.add(new ArrayList<>(Arrays.asList(5, 13)));

        System.out.println(new MeetingRooms().solveUsingHeap(A));
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        if (A.size() < 2) return A.size();
        A.sort(new MyComparator());

        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, A.get(0).get(1));
        for (int i = 1; i < A.size(); i++) {
            int currStart = A.get(i).get(0);
            int currEnd = A.get(i).get(1);
            boolean flag = false;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() <= currStart) {
                    entry.setValue(currEnd);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                map.put(map.size() + 1, currEnd);
            }
        }

        return Collections.max(map.keySet());
    }

    public int solve2(ArrayList<ArrayList<Integer>> A) {
        if (A.size() < 2) return A.size();
        A.sort(new MyComparator());

        //A.forEach(x -> System.out.println(x.get(0) + " " + x.get(1)));

        int maxEnd = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            maxEnd = Math.max(maxEnd, A.get(i).get(1));
        }

        int openMeetings = 0;
        int res = 0;
        for (int i = 0; i <= maxEnd; i++) {
            for (int j = 0; j < A.size(); j++) {
                int currentMeetingStart = A.get(j).get(0);
                int currentMeetingEnd = A.get(j).get(1);
                if (currentMeetingStart == i) openMeetings++;
                else if (currentMeetingEnd == i) {
                    openMeetings--;
                    A.remove(j--);
                }
                res = Math.max(res, openMeetings);
            }
        }
        return res;
    }

    public int solve3(ArrayList<ArrayList<Integer>> A) {
        if (A.size() < 2) return A.size();
        A.sort(new MyComparator());

        int maxEnd = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            maxEnd = Math.max(maxEnd, A.get(i).get(1));
        }

        int[] trackMeeting = new int[maxEnd + 1];
        for (int i = 0; i < A.size(); i++) {
            int currentMeetingStart = A.get(i).get(0);
            int currentMeetingEnd = A.get(i).get(1);
            trackMeeting[currentMeetingStart]++;
            trackMeeting[currentMeetingEnd]--;
        }

        int ans = trackMeeting[0];
        for (int i = 1; i <= maxEnd; i++) {
            trackMeeting[i] += trackMeeting[i - 1];
            ans = Math.max(ans, trackMeeting[i]);
        }
        return ans;
    }

    public int solveUsingHeap(ArrayList<ArrayList<Integer>> A) {
        if (A.size() < 2) return A.size();
        A.sort(new MyComparator());

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(A.get(0).get(1));
        for (int i = 1; i < A.size(); i++) {
            int currentMeetingStart = A.get(i).get(0);
            int currentMeetingEnd = A.get(i).get(1);
            if (!heap.isEmpty() && currentMeetingStart >= heap.peek()) {
                heap.poll();
            }
            heap.add(currentMeetingEnd);
        }
        return heap.size();
    }

    static class MyComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {

            if (o1.get(0) < o2.get(0)) return -1;
            if (o1.get(0) > o2.get(0)) return 1;

            return Integer.compare(o1.get(1), o2.get(1));
        }
    }
}
