//11.Write a Program to print a linked list in reverse order? E.g. Print linked list from
// tail to head?

class Node11 {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedList {

    static void printReverse(Node head) {

        // Base condition
        if (head == null) {
            return;
        }

        // First visit the next node
        printReverse(head.next);

        // Print while returning from recursion
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Linked List in Reverse Order:");

        printReverse(head);
    }
}