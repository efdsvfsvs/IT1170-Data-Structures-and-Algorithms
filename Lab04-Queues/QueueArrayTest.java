/**
 * IT1170 - Practical 4
 * Exercise 1: Testing Linear Queue
 */
public class QueueArrayTest {
    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);

        q.insert(10);
        q.insert(20);
        q.insert(30);

        q.display();

        System.out.println("Removed: " + q.remove());
        q.display();

        System.out.println("Front Element: " + q.peekFront());
        System.out.println("Queue Count: " + q.getCount());
    }
}
