import java.util.Random;

public class Producer implements Runnable {
    private final SharedBuffer sharedBuffer; // Reference to the shared buffer
    private final Random random = new Random(); // Random number generator
    private final int limit; // Limit for production

    public Producer(SharedBuffer sharedBuffer, int limit) {
        this.sharedBuffer = sharedBuffer; // Initialize with the shared buffer
        this.limit = limit; // Set the production limit
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < limit; i++) { // Produce numbers up to the limit
                int number = random.nextInt(100); // Generate a random number between 0 and 99
                sharedBuffer.add(number); // Add the number to the shared buffer
                Thread.sleep(500); // Sleep for 500 milliseconds to simulate production time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }
}
