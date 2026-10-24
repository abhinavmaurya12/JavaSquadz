//7.How to remove duplicate nodes in an unsorted linked list?


import java.util.HashSet;
import java.util.Set;

class Node7 {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicates {

    static Node removeDuplicates(Node head) {
        Set<Integer> seen = new HashSet<>();

        Node current = head;
        Node previous = null;

        while (current != null) {

            if (seen.contains(current.data)) {
                // Remove duplicate node
                previous.next = current.next;
            } else {
                // First occurrence of this value
                seen.add(current.data);
                previous = current;
            }

            current = current.next;
        }

        return head;
    }

    static void display(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(10);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(20);
        head.next.next.next.next.next = new Node(40);

        System.out.println("Before removing duplicates:");
        display(head);

        head = removeDuplicates(head);

        System.out.println("After removing duplicates:");
        display(head);
    }
}
