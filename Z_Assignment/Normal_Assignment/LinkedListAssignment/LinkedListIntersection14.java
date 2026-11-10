//14. How do you find first intersection node of two linked list in Java?
//Concept: Two Pointer Approach

//The intersection of two linked lists occurs when two lists share the same node in memory, not merely when they contain the same data.

//We can find the first intersection node in O(n + m) time and O(1) space using two pointers.
//Logic
//1. Initialize two pointers p1 and p2 at the heads of both linked lists.
//2. Move both pointers one step at a time.
//3. When p1 reaches null, redirect it to the head of the second list.
//4. When p2 reaches null, redirect it to the head of the first list.
//5. Eventually, both pointers will meet at the intersection node, or both will become null if
// there is no intersection.


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListIntersection14 {

    static Node findIntersection(Node head1, Node head2) {

        if (head1 == null || head2 == null) {
            return null;
        }

        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2) {

            p1 = (p1 == null) ? head2 : p1.next;

            p2 = (p2 == null) ? head1 : p2.next;
        }

        return p1;
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

        // Common linked list
        Node common = new Node(30);
        common.next = new Node(40);
        common.next.next = new Node(50);

        // First linked list
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = common;

        // Second linked list
        Node head2 = new Node(15);
        head2.next = common;

        System.out.println("First Linked List:");
        display(head1);

        System.out.println("Second Linked List:");
        display(head2);

        Node intersection = findIntersection(head1, head2);

        if (intersection != null) {
            System.out.println(
                "First Intersection Node: " + intersection.data
            );
        } else {
            System.out.println("No Intersection Found");
        }
    }
}


