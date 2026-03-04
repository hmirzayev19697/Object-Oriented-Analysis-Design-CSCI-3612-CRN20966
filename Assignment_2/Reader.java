package Assignment_2;

public class Reader<T> {
    private RingBuffer<T> buffer;
    private long readSeq;

    public Reader(RingBuffer<T> buffer) {
        this.buffer = buffer;
        this.readSeq = buffer.getWriteSeq(); // reading start sequence
    }

    public T read() {
        long writeSeq = buffer.getWriteSeq();

        // Reader is too slow → data overwritten
        if (readSeq < writeSeq - buffer.getCapacity()) {
            readSeq = writeSeq - buffer.getCapacity();
        }

        if (readSeq >= writeSeq) {
            return null; // nothing new to read
        }

        T item = buffer.readAt(readSeq);
        readSeq++;
        return item;
    }
}