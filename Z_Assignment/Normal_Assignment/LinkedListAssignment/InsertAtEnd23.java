//23. How to insert a node at the end of the list?
//Concept: Traversal and Pointer Manipulation
//To insert a node at the end of a singly linked list, we create a new node, traverse the list 
//until we reach the last node, and connect the last node to the new node.

//Logic
//1. Create a new node with the given data.
//2. Check whether the linked list is empty.
//3. If the list is empty, make the new node the head.
//4. Otherwise, traverse the list until the last node (next == null).
//5. Connect the last node to the new node.


class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtEnd23 {

    Node head;

    // Insert node at the end
    void insertAtEnd23(int data) {

        // Create new node
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the last node
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        // Connect last node to new node
        temp.next = newNode;
    }

    // Display linked list
    void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        InsertAtEnd23 list = new InsertAtEnd23();

        // Insert elements
        list.insertAtEnd23(10);
        list.insertAtEnd23(20);
        list.insertAtEnd23(30);

        System.out.println("Linked List:");
        list.display();

        // Insert another node
        list.insertAtEnd23(40);

        System.out.println("After Insertion:");
        list.display();
    }
}
