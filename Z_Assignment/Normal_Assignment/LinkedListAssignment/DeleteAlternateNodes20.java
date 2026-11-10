//20. How to delete alternate nodes of a Linked List?

//Concept: Iterative Approach using Pointers
//We need to delete every alternate node from a singly linked list, starting with the second node.

//Before deletion:
//10 → 20 → 30 → 40 → 50 → 60 → null

//After deletion:
//10 → 30 → 50 → null

//Logic
//1. Start with a pointer current pointing to the head.
//2. Check whether the next node exists.
//3. Store the next node in a temporary pointer.
//4. Skip the alternate node by changing current.next.
//5. Move current to the next remaining node.
//6. Repeat until the end of the list.


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteAlternateNodes20 {

    // Delete alternate nodes
    static void deleteAlternate(Node head) {

        Node current = head;

        while (current != null && current.next != null) {

            // Store alternate node
            Node temp = current.next;

            // Skip alternate node
            current.next = temp.next;

            // Move to next remaining node
            current = current.next;
        }
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

        // Create linked list
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        System.out.println("Before Deletion:");
        display(head);

        deleteAlternate(head);

        System.out.println("After Deletion:");
        display(head);
    }
}
