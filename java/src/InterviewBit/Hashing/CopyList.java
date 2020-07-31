package InterviewBit.Hashing;

import java.util.HashMap;

public class CopyList {

    public static void main(String[] args) {
        RandomListNode A = new RandomListNode(1);
        RandomListNode B = new RandomListNode(2);
        RandomListNode C = new RandomListNode(3);

        A.next = B;
        A.random = C;
        B.next = C;
        B.random = A;
        C.random = A;

        RandomListNode temp = new CopyList().copyRandomList(A);
        while (temp != null) {
            System.out.println(temp.label + " " + temp.random.label);
            temp = temp.next;
        }

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode temp = head;
        RandomListNode start = new RandomListNode(Integer.MAX_VALUE);
        RandomListNode prev = start;
        HashMap<Integer, RandomListNode> map = new HashMap<>();
        map.put(Integer.MIN_VALUE, null);

        while (temp != null) {
            RandomListNode curr = new RandomListNode(temp.label);
            map.put(temp.label, curr);
            prev.next = curr;
            prev = curr;
            temp = temp.next;
        }

        temp = head;
        RandomListNode newTemp = start.next;
        while (temp != null) {
            int randomValue = (temp.random != null ? temp.random.label : Integer.MIN_VALUE);
            newTemp.random = map.get(randomValue);
            newTemp = newTemp.next;
            temp = temp.next;
        }

        return start.next;
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
