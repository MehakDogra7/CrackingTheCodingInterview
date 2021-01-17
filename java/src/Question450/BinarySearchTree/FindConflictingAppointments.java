package Question450.BinarySearchTree;

public class FindConflictingAppointments {

    public static void main(String[] args) {
        int[][] appointments = {{1, 5}, {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}};
        new FindConflictingAppointments().solve(appointments);
    }

    private void solve(int[][] appointments) {
        int n = appointments.length;
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            int[] appointment = appointments[i];
            intervals[i] = new Interval(appointment[0], appointment[1]);
        }

        IntervalNode root = new IntervalNode(intervals[0]);

        for (int i = 1; i < n; i++) {
            Interval currentInterval = intervals[i];

            Interval overLappedInterval = getOverlappedInterval(root, currentInterval);
            if (overLappedInterval != null) {
                System.out.println(currentInterval.toString() + " is overlapping with: " +
                        overLappedInterval.toString());
            }

            root = insertIntoIntervalTree(root, currentInterval);
        }
    }

    private IntervalNode insertIntoIntervalTree(IntervalNode root, Interval intervalToInsert) {
        if (root == null) return new IntervalNode(intervalToInsert);

        if (intervalToInsert.low < root.interval.low)
            root.left = insertIntoIntervalTree(root.left, intervalToInsert);
        else
            root.right = insertIntoIntervalTree(root.right, intervalToInsert);
        root.max = Math.max(root.max, intervalToInsert.high);
        return root;
    }

    private Interval getOverlappedInterval(IntervalNode root, Interval intervalToCheck) {
        if (root == null) return null;

        if (root.interval.low < intervalToCheck.high && root.interval.high > intervalToCheck.low) {
            return root.interval;
        }

        if (root.left != null && root.left.max >= intervalToCheck.low)
            return getOverlappedInterval(root.left, intervalToCheck);
        return getOverlappedInterval(root.right, intervalToCheck);
    }

    static class IntervalNode {
        Interval interval;
        IntervalNode left, right;
        int max;

        public IntervalNode(Interval interval) {
            this.interval = interval;
        }
    }

    static class Interval {
        int low, high;

        public Interval(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public String toString() {
            return "{" +
                    "" + low +
                    ", " + high +
                    '}';
        }
    }
}
