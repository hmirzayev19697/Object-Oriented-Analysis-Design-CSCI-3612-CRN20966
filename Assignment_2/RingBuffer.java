package Assignment_2;

public class RingBuffer<T> {
    private final Object[] buffer;
    private final int capacity;

    private long writeSeq = 0; // It counts how many items were written ever. It is needed to let slow readers catch up(skip items) if some of the items were overwritten
    // For example: if capacity = 4 and writer wrote 10 items, slow readers should skip items 1–6 automatically 
    // because they were overwritten.

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new Object[capacity];
    }

    // Single writer only
    public void write(T item) {
        int index = (int) (writeSeq % capacity);
        buffer[index] = item;
        writeSeq++;
    }

    long getWriteSeq() {
        return writeSeq;
    }

    int getCapacity() {
        return capacity;
    }

    @SuppressWarnings("unchecked")
    T readAt(long sequence) {
        int index = (int) (sequence % capacity);
        return (T) buffer[index];
    }
}