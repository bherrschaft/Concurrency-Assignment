import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> buffer; // A queue to store integers acting as the buffer
    private final int maxSize; // The maximum capacity of the buffer

    public SharedBuffer(int maxSize) {
        this.buffer = new LinkedList<>(); // Initialize the buffer as a LinkedList
        this.maxSize = maxSize; // Set the maximum size of the buffer
    }

    // Method to add a number to the buffer with synchronization
    public synchronized void add(int number) throws InterruptedException {
        // If the buffer is full, wait until space is available
        while (buffer.size() == maxSize) {
            wait(); // Release the lock and wait for a notification
        }
        buffer.add(number); // Add the number to the buffer
        System.out.println("Produced: " + number); // Print the produced number
        notifyAll(); // Notify all waiting threads that a number has been added
    }

    // Method to remove a number from the buffer with synchronization
    public synchronized int remove() throws InterruptedException {
        // If the buffer is empty, wait until a number is available
        while (buffer.isEmpty()) {
            wait(); // Release the lock and wait for a notification
        }
        int number = buffer.poll(); // Remove the head of the queue
        notifyAll(); // Notify all waiting threads that a number has been removed
        return number; // Return the removed number
    }
}
