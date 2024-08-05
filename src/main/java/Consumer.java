public class Consumer implements Runnable {
    private final SharedBuffer sharedBuffer; // Reference to the shared buffer
    private final int limit; // Limit for consumption

    public Consumer(SharedBuffer sharedBuffer, int limit) {
        this.sharedBuffer = sharedBuffer; // Initialize with the shared buffer
        this.limit = limit; // Set the consumption limit
    }

    @Override
    public void run() {
        int sum = 0; // Initialize the sum to zero
        try {
            for (int i = 0; i < limit; i++) { // Consume numbers up to the limit
                int number = sharedBuffer.remove(); // Remove a number from the buffer
                sum += number; // Add the number to the sum
                System.out.println("Consumed: " + number + ", Current Sum: " + sum); // Print the consumed number and current sum
                Thread.sleep(1000); // Sleep for 1000 milliseconds to simulate consumption time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }
}
