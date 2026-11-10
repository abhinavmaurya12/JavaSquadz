//12. How to delete a node from a Singly linked list in O(1) time?
//Concept: We can delete a node in O(1) time without knowing its previous node by copying 
//the data of the next node into the current node and then deleting the next node.


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteNode12 {

    static void deleteNode(Node node) {

        // Cannot delete the last node using this method
        if (node == null || node.next == null) {
            System.out.println("Deletion not possible");
            return;
        }

        // Copy next node's data
        node.data = node.next.data;

        // Skip the next node
        node.next = node.next.next;
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

        System.out.println("Before deletion:");
        display(head);

        // Delete node containing 20
        deleteNode(head.next);

        System.out.println("After deletion:");
        display(head);
    }
}
