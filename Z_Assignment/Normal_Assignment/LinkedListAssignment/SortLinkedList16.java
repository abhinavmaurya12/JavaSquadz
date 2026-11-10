//16. Write a method in Java to sort a given linked list?
//Concept: Merge Sort Algorithm

//Merge Sort is one of the best algorithms for sorting a singly linked list because it does not require random access to elements.

//It works in three steps:
//1. Divide: Find the middle node and split the linked list into two halves.
//2. Conquer: Recursively sort both halves.
//3. Merge: Merge the two sorted halves into one sorted linked list.


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SortLinkedList16 {

    // Find middle node
    static Node getMiddle(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted linked lists
    static Node merge(Node a, Node b) {

        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data <= b.data) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }

        return result;
    }

    // Sort linked list using Merge Sort
    static Node sortList(Node head) {

        // Base condition
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        Node middle = getMiddle(head);

        Node nextOfMiddle = middle.next;

        // Split linked list
        middle.next = null;

        // Sort both halves
        Node left = sortList(head);
        Node right = sortList(nextOfMiddle);

        // Merge sorted halves
        return merge(left, right);
    }

    // Display linked list
    static void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(40);
        head.next = new Node(10);
        head.next.next = new Node(50);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(30);

        System.out.println("Before Sorting:");
        display(head);

        head = sortList(head);

        System.out.println("After Sorting:");
        display(head);
    }
}
