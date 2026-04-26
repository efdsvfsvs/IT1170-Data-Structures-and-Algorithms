/**
 * IT1170 - Data Structures and Algorithms
 * Practical 5 – Linked Lists
 * Exercise 2: Library Management System using Singly Linked List
 */

// Node class for Book
class BookLink {
    public int bookID;
    public String title;
    public int copies;
    public BookLink next;

    // Constructor
    public BookLink(int bookID, String title, int copies) {
        this.bookID = bookID;
        this.title = title;
        this.copies = copies;
        this.next = null;
    }

    // Display single book
    public void displayLink() {
        System.out.println("ID: " + bookID + ", Title: " + title + ", Copies: " + copies);
    }
}

// Linked List class for Library
class LibraryLinkedList {
    private BookLink first;

    public LibraryLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // Insert at first
    public void insertFirst(int id, String title, int copies) {
        BookLink newBook = new BookLink(id, title, copies);
        newBook.next = first;
        first = newBook;
    }

    // Find book by ID
    public BookLink find(int key) {
        BookLink current = first;
        while (current != null) {
            if (current.bookID == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Insert after a specific book ID
    public boolean insertAfter(int key, int id, String title, int copies) {
        BookLink current = first;
        while (current != null) {
            if (current.bookID == key) {
                BookLink newBook = new BookLink(id, title, copies);
                newBook.next = current.next;
                current.next = newBook;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Delete first book
    public BookLink deleteFirst() {
        if (isEmpty()) return null;
        BookLink temp = first;
        first = first.next;
        return temp;
    }

    // Delete book by ID
    public boolean delete(int key) {
        if (isEmpty()) return false;

        if (first.bookID == key) {
            first = first.next;
            return true;
        }

        BookLink current = first;
        BookLink previous = null;

        while (current != null && current.bookID != key) {
            previous = current;
            current = current.next;
        }

        if (current == null) return false;

        previous.next = current.next;
        return true;
    }

    // Display all books
    public void displayList() {
        if (isEmpty()) {
            System.out.println("Library is empty!");
            return;
        }
        BookLink current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

// Main class to test Library System
public class LibraryLinkedListTest {
    public static void main(String[] args) {
        LibraryLinkedList library = new LibraryLinkedList();

        // Insert initial books
        library.insertFirst(3, "Welcome", 8);
        library.insertFirst(1, "Hello", 15);
        library.insertFirst(2, "World", 4);

        System.out.println("List after insertions:");
        library.displayList();

        // Delete a book
        library.delete(2);   // Note: Sample in lab shows ID 102, but we use 2 here
        System.out.println("List after deleting ID 2:");
        library.displayList();

        // Delete first book
        library.deleteFirst();
        System.out.println("List after deleting first element:");
        library.displayList();
    }
}
