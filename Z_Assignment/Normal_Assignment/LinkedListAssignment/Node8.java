//8.Write a recursive method to determine whether a linked list is sorted in descending 
//order or not? If it's sorted then return true otherwise return false


class Node8 {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    static boolean isDescending(Node head) {

        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return true;
        }

        // Check current node and next node
        if (head.data < head.next.data) {
            return false;
        }

        // Recursively check the remaining list
        return isDescending(head.next);
    }

    public static void main(String[] args) {

        Node head = new Node(90);
        head.next = new Node(70);
        head.next.next = new Node(50);
        head.next.next.next = new Node(20);

        if (isDescending(head)) {
            System.out.println("Linked list is sorted in descending order.");
        } else {
            System.out.println("Linked list is not sorted in descending order.");
        }
    }
}
