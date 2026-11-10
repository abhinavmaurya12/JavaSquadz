//17. How do you merge two sorted lists into a single sorted linked list?
//Concept: Two Pointer Approach

//We can merge two already sorted linked lists into one sorted linked list by comparing their node values and selecting the smaller value at each step.

//Logic:
//1. Create a dummy node to simplify the merging process.
//2. Create a pointer current pointing to the dummy node.
//3. Compare the values of both linked lists.
//4. Attach the smaller node to the merged list.
//5. Move the pointer of the selected list forward.
//6. When one list becomes empty, attach the remaining nodes of the other list.
//7. Return dummy.next.


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortedLists17 {

    // Merge two sorted linked lists
    static Node mergeLists(Node head1, Node head2) {

        Node dummy = new Node(0);
        Node current = dummy;

        // Compare both lists
        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }

            current = current.next;
        }

        // Attach remaining nodes
        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }

        return dummy.next;
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

        // First sorted linked list
        Node head1 = new Node(10);
        head1.next = new Node(30);
        head1.next.next = new Node(50);

        // Second sorted linked list
        Node head2 = new Node(20);
        head2.next = new Node(40);
        head2.next.next = new Node(60);

        System.out.println("First Linked List:");
        display(head1);

        System.out.println("Second Linked List:");
        display(head2);

        // Merge both lists
        Node merged = mergeLists(head1, head2);

        System.out.println("Merged Sorted Linked List:");
        display(merged);
    }
}
