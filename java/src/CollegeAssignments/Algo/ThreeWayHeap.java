package CollegeAssignments.Algo;

/**
 *                                  1
 *                           /      |      \
 *                  2               3               4
 *               /  |   \       /   |    \       /  |  \
 *            5     6    7    8     9     10   11   12   13
 */
public class ThreeWayHeap {

    static int size;

    public static void main(String[] args) {
        int[] heap = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        size = heap.length;

        topDownHeapifyUtilTesting(heap);
        bottomDownHeapifyUtilTesting(heap);
    }

    /**
     * Time Complexity: O(1)
     */
    public static int Parent(int i) {
        if (i == 0) return -1;              //If It is root, then return -1 because root doesn't have any parent.

        return (i - 1) / 3;
    }

    /**
     * Time Complexity: O(1)
     */
    public static int LeftChild(int i) {
        int left = 3 * i + 1;
        if (left >= size)
            return -1;                        //If left index go beyond the size of the heap then return -1;
        return left;
    }

    /**
     * Time Complexity: O(1)
     */
    public static int MiddleChild(int i) {
        int middle = 3 * i + 2;
        if (middle >= size)
            return -1;                      //If middle index go beyond the size of the heap then return -1;
        return middle;
    }

    /**
     * Time Complexity: O(1)
     */
    public static int RightChild(int i) {
        int right = 3 * i + 3;
        if (right >= size)
            return -1;                       //If right index go beyond the size of the heap then return -1;
        return right;
    }

    /**
     * Time Complexity: O(h)    -----> O(logn) (base 3)
     */
    public static void topDownHeapify(int[] heap, int index) {
        int smallestIndex = index;                                            //let current index element is smallest

        int leftChildIndex = LeftChild(index);       //now compare with left child (if any) and update smallest index if left child is smallest then the current smallest
        if (leftChildIndex != -1 && heap[leftChildIndex] < heap[smallestIndex])
            smallestIndex = leftChildIndex;

        int middleChildIndex = MiddleChild(index);  //now compare with middle child (if any) and update smallest index if middle child is smallest then the current smallest
        if (middleChildIndex != -1 && heap[middleChildIndex] < heap[smallestIndex])
            smallestIndex = middleChildIndex;

        int rightChildIndex = RightChild(index);    //now compare with right child (if any) and update smallest index if right child is smallest then the current smallest
        if (rightChildIndex != -1 && heap[rightChildIndex] < heap[smallestIndex])
            smallestIndex = rightChildIndex;

        if (smallestIndex != index) {               //now if the passed input index is not the smallest one which 1 of its child is smaller than,
            int temp = heap[index];                 //then exchange them (parent <--> smallest child)
            heap[index] = heap[smallestIndex];
            heap[smallestIndex] = temp;
            topDownHeapify(heap, smallestIndex);    //and perform topDownHeapify on the smallest index because it is possible that it could be greater than the grand child.
        }
    }

    /**
     * Time Complexity: O(h)    -----> O(logn) (base 3)
     */
    public static void bottomUpHeapify(int[] heap, int index) {
        int parent = Parent(index);
        if (parent == -1)
            return;               //if current index is 0 then it is not possible to perform bottom up heapify because no parent.

        if (heap[index] < heap[parent]) {       //otherwise compare with parent if parent is greater than swap them
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            bottomUpHeapify(heap, parent);      //And perform bottom up heapify on parent.
        }
    }


    //-------------------------------------------------------------Testing Methods---------------------------------------------//
    private static void bottomDownHeapifyUtilTesting(int[] heap) {
        System.out.println("------------Bottom up testing---------------------");
        bottomUpHeapify(heap, 0);                                           //Bottom up heapify on already maintained heap
        for (int element : heap) System.out.print(element + " ");                 //No change in the elements' position

        heap[4] = 1;                                                             //Reverting back the change that is decreasing the key from 14 to 1 this will break the heap property
        System.out.println("\n\nCurrent heap elements after modifying 4th index from 14 to 1");
        for (int element : heap) System.out.print(element + " ");

        bottomUpHeapify(heap, 4);                                          //So after applying bottom up heapify on 4th index the smallest element '1'
        System.out.println("\nAfter Bottom Up heapify");                          //should propagate upwards and becomes the root because it is smallest among all.
        for (int element : heap) System.out.print(element + " ");

        System.out.println("\n------------------Done----------------------------");
    }

    private static void topDownHeapifyUtilTesting(int[] heap) {
        System.out.println("------------Top Down testing----------------------");
        topDownHeapify(heap, 0);                                            //Top Down heapify on already properly maintained heap
        for (int element : heap) System.out.print(element + " ");                 //No change in the elements' position

        heap[0] = 14;                                                             //Increasing the key at 0 index from 1 to 14 this will break the heap property
        System.out.println("\n\nCurrent heap elements after modifying 0th index to 14");
        for (int element : heap) System.out.print(element + " ");

        topDownHeapify(heap, 0);                                            //So after applying the topDown heapify smallest element which is '2' should become the new root.
        System.out.println("\nAfter Top Down heapify");                           //And 14 will propagate downwards to its correct position satisfying the heap property
        for (int element : heap) System.out.print(element + " ");

        System.out.println("\n------------------Done----------------------------\n");
    }
}
