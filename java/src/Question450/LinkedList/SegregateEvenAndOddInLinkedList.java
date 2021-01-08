package Question450.LinkedList;

import java.util.Scanner;

public class SegregateEvenAndOddInLinkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node prev = head;
            for (int i = 1; i < n; i++) {
                prev.next = new Node(sc.nextInt());
                prev = prev.next;
            }
            head = solve(head);
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println();
        }
    }

    private static Node solve(Node head) {

        Node lastEven = new Node(Integer.MAX_VALUE), evenHead = lastEven;
        Node lastOdd = new Node(Integer.MAX_VALUE), oddHead = lastOdd;

        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                lastEven.next = curr;
                lastEven = curr;
            } else {
                lastOdd.next = curr;
                lastOdd = curr;
            }
            curr = curr.next;
        }

        lastEven.next = oddHead.next;
        lastOdd.next = null;

        return evenHead.next;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
