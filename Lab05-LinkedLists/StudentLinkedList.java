/**
 * IT1170 - Data Structures and Algorithms
 * Practical 5 – Linked Lists
 * Exercise 1: Singly Linked List with Student Records
 */

// Node class for Student
class StudentLink {
    public int id;
    public int marks;
    public StudentLink next;

    // Constructor
    public StudentLink(int id, int marks) {
        this.id = id;
        this.marks = marks;
        this.next = null;
    }

    // Display single link
    public void displayLink() {
        System.out.println("ID: " + id + ", Marks: " + marks);
    }
}

// Linked List class
class StudentLinkedList {
    private StudentLink first;

    // Constructor
    public StudentLinkedList() {
        first = null;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return first == null;
    }

    // Insert at the beginning
    public void insertFirst(int id, int marks) {
        StudentLink newLink = new StudentLink(id, marks);
        newLink.next = first;
        first = newLink;
    }

    // Find a student by ID
    public StudentLink find(int key) {
        StudentLink current = first;
        while (current != null) {
            if (current.id == key) {
                return current;
            }
            current = current.next;
        }
        return null; // Not found
    }

    // Insert after a specific key
    public boolean insertAfter(int key, int id, int marks) {
        StudentLink current = first;
        while (current != null) {
            if (current.id == key) {
                StudentLink newLink = new StudentLink(id, marks);
                newLink.next = current.next;
                current.next = newLink;
                return true;
            }
            current = current.next;
        }
        return false; // Key not found
    }

    // Delete first element
    public StudentLink deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        StudentLink temp = first;
        first = first.next;
        return temp;
    }

    // Delete by key (ID)
    public boolean delete(int key) {
        if (isEmpty()) {
            return false;
        }

        // If key is at first position
        if (first.id == key) {
            first = first.next;
            return true;
        }

        StudentLink current = first;
        StudentLink previous = null;

        while (current != null && current.id != key) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false; // Not found
        }

        // Delete the node
        previous.next = current.next;
        return true;
    }

    // Display the entire list
    public void displayList() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        StudentLink current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

// Main class to test Exercise 1
public class StudentLinkedListTest {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        // Insertions
        list.insertFirst(103, 75);
        list.insertFirst(101, 85);
        list.insertFirst(102, 90);

        System.out.println("List after insertions:");
        list.displayList();

        // Delete by key
        list.delete(102);
        System.out.println("List after deleting ID 102:");
        list.displayList();

        // Delete first
        list.deleteFirst();
        System.out.println("List after deleting first element:");
        list.displayList();
    }
}
