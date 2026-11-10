//13.How to find the Kth node from the end in a singly linked list?
//Concept: Two Pointer Approach (Fast & Slow Pointers)
//We can find the Kth node from the end in O(n) time and O(1) space using two pointers.
//Logic:
//1. Initialize two pointers: first and second, both pointing to the head.
//2. Move the first pointer K positions ahead.
//3. Move both pointers one step at a time until first reaches null.
//4. The second pointer will now point to the Kth node from the end.


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class KthNodeFromEnd13 {

    static Node findKthFromEnd(Node head, int k) {

        Node first = head;
        Node second = head;

        // Move first pointer K steps ahead
        for (int i = 0; i < k; i++) {

            if (first == null) {
                return null; // K is greater than list size
            }

            first = first.next;
        }

        // Move both pointers together
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    static void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Linked List:");
        display(head);

        int k = 2;

        Node result = findKthFromEnd(head, k);

        if (result != null) {
            System.out.println(k + "nd node from end: " + result.data);
        } else {
            System.out.println("Invalid K value");
        }
    }
}
