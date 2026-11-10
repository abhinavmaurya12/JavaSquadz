//26.How do you convert a sorted doubly linked list to a balanced binary search tree in
// Java?

//To convert a sorted doubly linked list (DLL) into a balanced Binary Search Tree (BST), 
//we can use the middle element of the linked list as the root node.


public class DLLToBalancedBST26 {

    // Doubly Linked List Node
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // BST Node
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // Find middle node of DLL using slow and fast pointers
    static Node findMiddle(Node head, Node end) {

        Node slow = head;
        Node fast = head;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Convert sorted DLL to balanced BST
    static TreeNode convertToBST(Node head, Node end) {

        if (head == end) {
            return null;
        }

        // Find middle element
        Node mid = findMiddle(head, end);

        // Middle becomes root
        TreeNode root = new TreeNode(mid.data);

        // Left subtree
        root.left = convertToBST(head, mid);

        // Right subtree
        root.right = convertToBST(mid.next, end);

        return root;
    }

    // Inorder traversal of BST
    static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    // Preorder traversal of BST
    static void preorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        // Create sorted doubly linked list
        Node head = new Node(1);

        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);

        head.next = second;

        second.prev = head;
        second.next = third;

        third.prev = second;
        third.next = fourth;

        fourth.prev = third;
        fourth.next = fifth;

        fifth.prev = fourth;
        fifth.next = sixth;

        sixth.prev = fifth;
        sixth.next = seventh;

        seventh.prev = sixth;

        // Convert DLL to BST
        TreeNode root = convertToBST(head, null);

        System.out.println("Inorder Traversal:");
        inorder(root);

        System.out.println("\nPreorder Traversal:");
        preorder(root);
    }
}
