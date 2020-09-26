package CollegeAssignments.Algo;

import java.util.ArrayDeque;
import java.util.Queue;

public class MergeSort {

    public static void main(String[] args) {
        int[] A = {4, 7, 19, 16, 14, 18, 17, 13, 10, 2, 3, 8};
        System.out.println("Input Array: ");
        for (int i : A) {
            System.out.print(i + " ");
        }

        int[] res = new MergeSort().sort(A);

        System.out.println("\nSorted Array: ");
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    /**
     * Time Complexity:  O(nlogn)
     * Space Complexity: O(n) for queue and O(n) for merge function -- Overall -> O(n)
     *
     * @param A -- Input array.
     * @return A -- Sorted array.
     */
    private int[] sort(int[] A) {
        boolean isCurrIterationInc = true;                 //Flag to keep track whether the current iteration is increasing or decreasing
        Queue<Integer> queue = new ArrayDeque<>();         //Will contain the starting index of each consecutive block

        for (int i = 0; i < A.length; ) {
            //Add the index i to the queue as this indicates that we are starting inc/dec sequence from this index.
            //No need to store the ending point we can easily identify the end index of current sequence/block by
            //looking at the next value in the queue. If no next then it means this is the last block.
            queue.add(i);
            int j = i;
            if (isCurrIterationInc) {
                //start from current index and keep iterating till we reach end or we see lesser num than current.
                while (j < A.length && (j == A.length - 1 || A[j] < A[j + 1])) {
                    j++;
                }
            } else {
                //start from current index and keep iterating till we reach end or we see greater num than current.
                while (j < A.length && (j == A.length - 1 || A[j] > A[j + 1])) {
                    j++;
                }
                //Now we have identified the starting and ending index of decreasing subArray --so, reverse it.
                reverse(A, i, j);           //Both Included except in case when j = A.length
            }
            i = j + 1;
            //Toggle the flag --i.e. if current iteration is for the search of increasing sequence
            //then the next one would be for decreasing sequence and so on.
            isCurrIterationInc = !isCurrIterationInc;
        }

        /**
         *Queue contains the starting index of all blocks.
         *Take 2 elements at a time -- (means dequeue from beg.) -- merge them by calling merge function and
         *Append (enqueue) the first index again at the end.
         *Do this till we reach the end of algo meaning queue contain only 1 element.
         *Note: If we reach the last block then this means we cannot merge this block with any other block
         *      then simply dequeue and enqueue it.     (This can be check if the next element in the queue is 0
         *      then it means that current index indicate the starting position of last block.
         *For example:
         *0 3 5 6 10 ----- dequeue 0 and 3 - merge them and enqueue 0 at the end
         *5 6 10 0   ----- dequeue 5 and 6 - merge them and enqueue 5 at the end
         *10 0 5     ----- Current is 10 and next is 0, so 10 indicate that this is last block -- simply dequeue & enqueue it at the end. (no operation)
         *0 5 10     ----- dequeue 0 and 5 - merge them and enqueue 0 at the end
         *10 0       ----- Current is 10 and next is 0, so 10 indicate that this is last block -- simply dequeue & enqueue it at the end. (no operation)
         *0 10       ----- dequeue 0 and 10 - merge them and enqueue 0 at the end
         *0          ----- Size is 1 hence we reached at the end of algo which indicates all the blocks are sorted.
         *Since in every iteration we are merging 2 blocks and after reaching at the end we again start merging the result of previous
         *iterations - we are simply reducing the size by n/2 after successful merge of n elements (2-2 blocks)
         *so it will lead to O(nlogn) time complexity.
         */
        while (queue.size() > 1) {
            int startFirst = queue.poll();
            if (queue.peek() == 0) {
                queue.add(startFirst);
                continue;
            }
            int startSecond = queue.poll();
            merge(A, startFirst, startSecond - 1,
                    startSecond, (queue.isEmpty() || queue.peek() == 0) ? A.length - 1 : queue.peek() - 1);
            queue.add(startFirst);
        }

        return A;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param A
     * @param start index
     * @param end   index
     */
    private void reverse(int[] A, int start, int end) {
        if (end == A.length) end = A.length - 1;
        if (start == end) return;

        //Reverse the array between start and end -- both inclusive.
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param A
     * @param startFirst  -- starting index of 1st block.
     * @param endFirst    -- ending index of 1st block.
     * @param startSecond -- starting index of 2nd block.
     * @param endSecond   -- ending index of 2nd block.
     */
    private void merge(int[] A, int startFirst, int endFirst,
                       int startSecond, int endSecond) {     //Both start and end included for both subArrays
        int totalNum = endSecond - startFirst + 1;
        int[] temp = new int[totalNum];                     //Temporary array to store the result of merging of blocks
        int tempIndex = 0, i = startFirst, j = startSecond;
        while (i <= endFirst || j <= endSecond) {           //Keep iterating over both the blocks until both are done
            if (j > endSecond || (i <= endFirst && A[i] < A[j]))        //If second is done or first's element < second's element
                temp[tempIndex++] = A[i++];
            else                                                        //If first is done or first's element >= second's element
                temp[tempIndex++] = A[j++];
        }
        tempIndex = 0;                                      //Copy the content from temporary array to main array.
        for (int k = startFirst; k < endSecond + 1; k++) {
            A[k] = temp[tempIndex++];
        }
    }
}
