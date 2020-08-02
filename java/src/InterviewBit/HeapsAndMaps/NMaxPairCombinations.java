package InterviewBit.HeapsAndMaps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NMaxPairCombinations {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6, -39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28));
        ArrayList<Integer> B = new ArrayList<>(List.of(38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43));

        new NMaxPairCombinations().solveBruteForce(A, B).forEach(i -> System.out.print(i + " "));
        System.out.println();
        new NMaxPairCombinations().solve(A, B).forEach(i -> System.out.print(i + " "));
        /*HeapObject a = new HeapObject(1, 0, 0);
        HeapObject b = new HeapObject(9, 0, 0);
        HeapObject c = new HeapObject(8, 0, 0);
        HeapObject d = new HeapObject(2, 0, 0);
        HeapObject e = new HeapObject(3, 0, 0);
        ArrayList<HeapObject> heapObjects = new ArrayList<>(List.of(a, b, c, d, e));
        new NMaxPairCombinations().maxHeapify(heapObjects, 0);
        heapObjects.forEach(i -> System.out.print(i.sum + " "));*/

    }

    private ArrayList<Integer> solveBruteForce(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                result.add(A.get(i) + B.get(j));
            }
        }

        result.sort(Integer::compareTo);
        ArrayList<Integer> temp = new ArrayList<>();
        int i = result.size() - 1;
        while (n > 0) {
            temp.add(result.get(i--));
            n--;
        }

        return temp;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() == 0 || B.size() == 0 || A.size() != B.size()) return new ArrayList<>();
        int n = A.size();

        ArrayList<Integer> result = new ArrayList<>();
        A.sort(Integer::compareTo);
        B.sort(Integer::compareTo);

        ArrayList<HeapObject> heap = new ArrayList<>();
        heap.add(new HeapObject(A.get(n - 1) + B.get(n - 1), n - 1, n - 1));
        Set<HeapObject> set = new HashSet<>(heap);
        while (n > 0) {
            HeapObject max = extractMax(heap, set);
            result.add(max.sum);
            int i = max.indexA, j = max.indexB;
            if (i > 0) insertIntoHeap(set, heap, new HeapObject(A.get(i - 1) + B.get(j), i - 1, j));
            if (j > 0) insertIntoHeap(set, heap, new HeapObject(A.get(i) + B.get(j - 1), i, j - 1));
            n--;
        }
        return result;
    }

    private HeapObject extractMax(ArrayList<HeapObject> heap, Set<HeapObject> set) {
        if (heap.size() == 0) {
            return null;
        }
        HeapObject max = heap.get(0);
        if (heap.size() == 1) {
            heap.clear();
            return max;
        }
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        maxHeapify(heap, 0);
        return max;
    }

    private void maxHeapify(ArrayList<HeapObject> heap, int i) {
        int l = (i << 1) + 1;
        int r = (i << 1) + 2;

        int largest = Integer.MIN_VALUE;
        if (l < heap.size() && heap.get(l).sum > heap.get(i).sum)
            largest = l;
        else largest = i;
        if (r < heap.size() && heap.get(r).sum > heap.get(largest).sum)
            largest = r;

        if (largest != i) {
            HeapObject temp = heap.get(largest);
            heap.set(largest, heap.get(i));
            heap.set(i, temp);
            maxHeapify(heap, largest);
        }
    }

    private void insertIntoHeap(Set<HeapObject> set, ArrayList<HeapObject> heap, HeapObject heapObject) {
        if (set.contains(heapObject)) {
            return;
        }
        set.add(heapObject);
        heap.add(heapObject);
        int size = heap.size();
        if (size == 1) {
            return;
        }

        int i = size - 1;
        while (i > 0 && heap.get((i - 1) >> 1).sum < heap.get(i).sum) {
            HeapObject temp = heap.get((i - 1) >> 1);
            heap.set(((i - 1) >> 1), heap.get(i));
            heap.set(i, temp);
            i = (i - 1) >> 1;
        }
    }

    static class HeapObject {
        int sum;
        int indexA;
        int indexB;

        public HeapObject(int sum, int indexA, int indexB) {
            this.sum = sum;
            this.indexA = indexA;
            this.indexB = indexB;
        }

        @Override
        public int hashCode() {
            return sum * 10 + indexA * 10 + indexB * 10;
        }

        @Override
        public boolean equals(Object obj) {
            HeapObject h1 = (HeapObject) obj;
            if (h1.sum == this.sum && h1.indexB == this.indexB && h1.indexA == this.indexA) return true;
            return false;
        }
    }
}
