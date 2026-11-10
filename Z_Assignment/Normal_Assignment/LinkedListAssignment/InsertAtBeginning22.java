//22. How to insert a node at the beginning of the list?
//Concept: Head Pointer Manipulation
//To insert a new node at the beginning of a linked list, we create a new node, connect it to the existing head, 
//and then update the head pointer to the new node.
//This operation takes O(1) time complexity.

//Logic
//1. Create a new node with the given data.
//2. Set the new node's next pointer to the current head.
//3. Update the head pointer to the new node.
//4. The new node becomes the first node of the linked list.


class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtBeginning22 {

    Node head;

    // Insert node at beginning
    void insertAtBeginning22(int data) {

        // Create a new node
        Node newNode = new Node(data);

        // Connect new node to current head
        newNode.next = head;

        // Update head
        head = newNode;
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

        InsertAtBeginning22 list = new InsertAtBeginning22();

        // Insert elements
        list.insertAtBeginning22(30);
        list.insertAtBeginning22(20);
        list.insertAtBeginning22(10);

        System.out.println("Linked List:");
        list.display();

        // Insert another node
        list.insertAtBeginning22(5);

        System.out.println("After Insertion:");
        list.display();
    }
}
