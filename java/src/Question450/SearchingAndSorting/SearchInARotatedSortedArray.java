package Question450.SearchingAndSorting;

public class SearchInARotatedSortedArray {

    public static void main(String[] args) {
        int[] A = {1, 3, 5};
        int target = 5;
        System.out.println(new SearchInARotatedSortedArray().search(A, target));
    }

    public int search(int[] nums, int target) {

        int pivot = findPivot(nums);

        if (nums[pivot] == target) return pivot;
        int temp = binarySearch(nums, 0, pivot - 1, target);
        if (temp != -1) return temp;
        return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }

    private int findPivot(int[] nums) {
        if (nums.length == 1) return 0;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 && nums[mid] < nums[mid + 1]) || (mid == nums.length - 1 && nums[mid] < nums[mid - 1])
                    || (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1])) {
                return mid;
            } else if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return 0;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
