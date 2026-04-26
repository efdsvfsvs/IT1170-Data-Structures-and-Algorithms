/**
 * IT1170 - Data Structures and Algorithms
 * Practical 6 – Trees
 * Binary Search Tree with Employee Records
 */

// Node class
class Node {
    int empNo;
    String name;
    Node left;
    Node right;

    // Constructor
    public Node(int empNo, String name) {
        this.empNo = empNo;
        this.name = name;
        this.left = null;
        this.right = null;
    }

    // Display single node
    public void displayNode() {
        System.out.println("Employee No: " + empNo + ", Name: " + name);
    }
}

// Tree class
class Tree {
    Node root;

    // Constructor
    public Tree() {
        root = null;
    }

    // Non-recursive Find
    public Node find(int emp) {
        Node current = root;
        while (current != null) {
            if (emp == current.empNo) {
                return current;
            } else if (emp < current.empNo) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null; // Not found
    }

    // Recursive Find
    public Node findRecursive(int emp) {
        return findRecursiveHelper(root, emp);
    }

    private Node findRecursiveHelper(Node current, int emp) {
        if (current == null) {
            return null;
        }
        if (emp == current.empNo) {
            return current;
        } else if (emp < current.empNo) {
            return findRecursiveHelper(current.left, emp);
        } else {
            return findRecursiveHelper(current.right, emp);
        }
    }

    // Insert method (Binary Search Tree property)
    public void insert(int emp, String name) {
        Node newNode = new Node(emp, name);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;
            if (emp < current.empNo) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    // InOrder Traversal (Left - Root - Right)
    public void inOrder() {
        System.out.println("In-Order Traversal:");
        inOrderHelper(root);
        System.out.println();
    }

    private void inOrderHelper(Node node) {
        if (node != null) {
            inOrderHelper(node.left);
            node.displayNode();
            inOrderHelper(node.right);
        }
    }

    // PreOrder Traversal (Root - Left - Right)
    public void preOrder() {
        System.out.println("Pre-Order Traversal:");
        preOrderHelper(root);
        System.out.println();
    }

    private void preOrderHelper(Node node) {
        if (node != null) {
            node.displayNode();
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    // PostOrder Traversal (Left - Right - Root)
    public void postOrder() {
        System.out.println("Post-Order Traversal:");
        postOrderHelper(root);
        System.out.println();
    }

    private void postOrderHelper(Node node) {
        if (node != null) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            node.displayNode();
        }
    }

    // Delete All Nodes (Set root to null)
    public void deleteAll() {
        root = null;
        System.out.println("All nodes deleted from the tree.");
    }

    // Display current tree status
    public void displayTree() {
        if (root == null) {
            System.out.println("Tree is empty!");
        } else {
            System.out.println("Tree contains nodes.");
            inOrder();  // Show remaining nodes
        }
    }
}

// Main Application
public class EmployeeTree {
    public static void main(String[] args) {
        Tree tree = new Tree();

        // i. Insert 10 Employees
        System.out.println("=== Inserting 10 Employees ===");
        tree.insert(149, "Anusha");
        tree.insert(167, "Kosala");
        tree.insert(047, "Dinusha");
        tree.insert(066, "Mihiri");
        tree.insert(159, "Jayani");
        tree.insert(118, "Nimal");
        tree.insert(195, "Nishantha");
        tree.insert(034, "Avodya");
        tree.insert(105, "Bimali");
        tree.insert(133, "Sampath");

        // ii. Display traversals
        System.out.println("\n=== Tree Traversals ===");
        tree.inOrder();
        tree.preOrder();
        tree.postOrder();

        // iii. Search for employee (user input)
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("\nEnter employee number to search: ");
        int searchEmp = scanner.nextInt();

        Node found = tree.findRecursive(searchEmp);  // Using recursive version as required
        if (found != null) {
            System.out.println("Employee found:");
            found.displayNode();
        } else {
            System.out.println("Employee with number " + searchEmp + " not found.");
        }

        // iv. Delete all nodes
        System.out.println("\n=== Deleting All Nodes ===");
        tree.deleteAll();

        // v. Display tree after deletion
        System.out.println("\n=== Tree After Deletion ===");
        tree.displayTree();

        scanner.close();
    }
}
