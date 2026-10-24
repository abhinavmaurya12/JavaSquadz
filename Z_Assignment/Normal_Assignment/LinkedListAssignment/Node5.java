//5.How would you remove a node from a doubly linked list?


class Node5 {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    Node head;

    void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    void delete(int value) {
        Node current = head;

        // Find the node
        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node not found");
            return;
        }

        // Update the previous node
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            // Deleting the head
            head = current.next;
        }

        // Update the next node
        if (current.next != null) {
            current.next.prev = current.prev;
        }

        System.out.println("Deleted: " + value);
    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Original list:");
        list.display();

        list.delete(20);

        System.out.println("After deletion:");
        list.display();
    }
}
