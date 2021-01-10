package LeetCode.Contest;

public class MinTimeToFinishAllJobs {

    public static void main(String[] args) {
        int[] jobs = {10, 7, 8, 12, 6, 8};
        int k = 4;
        System.out.println(new MinTimeToFinishAllJobs().minimumTimeRequired(jobs, k));
    }

    public int minimumTimeRequired(int[] jobs, int k) {
        int sum = 0, max = jobs[0];
        for (int i = 0; i < jobs.length; i++) {
            sum += jobs[i];
            max = Math.max(max, jobs[i]);
        }
        if (k == 1) return sum;
        if (k >= jobs.length) return max;

        int low = 1, high = sum, ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid >= max && isPossible(jobs, k, mid)) {
                ans = Math.min(mid, ans);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] jobs, int k, int mid) {

        int sum = 0, workersNeeded = 1;

        for (int i = 0; i < jobs.length; i++) {
            if (sum + jobs[i] <= mid) {
                sum += jobs[i];
            } else {
                workersNeeded++;
                i--;
                sum = 0;
            }
        }

        return workersNeeded <= k;
    }


}
