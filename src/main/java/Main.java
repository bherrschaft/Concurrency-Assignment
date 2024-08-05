public class Main {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(10); // Create a shared buffer with a maximum size of 10

        int limit = 10; // Set the limit for the number of productions and consumptions

        Producer producer = new Producer(sharedBuffer, limit); // Create a producer with the shared buffer and limit
        Consumer consumer = new Consumer(sharedBuffer, limit); // Create a consumer with the shared buffer and limit

        Thread producerThread = new Thread(producer); // Create a new thread for the producer
        Thread consumerThread = new Thread(consumer); // Create a new thread for the consumer

        producerThread.start(); // Start the producer thread
        consumerThread.start(); // Start the consumer thread
    }
}
