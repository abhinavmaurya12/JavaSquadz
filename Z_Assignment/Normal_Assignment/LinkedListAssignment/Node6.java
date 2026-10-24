//6.Write a Program to convert a binary tree into a doubly linked list?


class Node6 {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    static Node head = null;
    static Node prev = null;

    static void convertToDLL(Node root) {
        if (root == null) {
            return;
        }

        // Visit left subtree
        convertToDLL(root.left);

        // Link current node with previous node
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        // Visit right subtree
        convertToDLL(root.right);
    }

    static void displayDLL(Node head) {
        Node current = head;

        System.out.print("Doubly Linked List: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.right;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create the binary tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);

        root.left.left = new Node(2);
        root.left.right = new Node(8);

        root.right.left = new Node(15);
        root.right.right = new Node(25);

        // Convert tree into DLL
        convertToDLL(root);

        // Display the result
        displayDLL(head);
    }
}
