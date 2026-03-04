package Assignment_2;

public class Main {
    public static void main(String[] args) {
        RingBuffer<Integer> buffer = new RingBuffer<>(4); // capacity = 4;

        Reader<Integer> r1 = new Reader<>(buffer);
        Reader<Integer> r2 = new Reader<>(buffer);
        // At this point nothing has been written yet. writeSeq = 0. Both r1 and r2's readSeq = 0

        buffer.write(1);
        buffer.write(2);
        buffer.write(3);
        // writeSeq = 3 ; r1.readSeq = 0 ; r2.readSeq = 0; 

        System.out.println("Reader 1: " + r1.read()); // we read logical sequence 0 (value 1) and move r1's readSeq +1
        System.out.println("Reader 1: " + r1.read()); // we read logical sequence 1 (value 2) and move r1's readSeq +1
        // writeSeq = 3; r1.readSeq = 2; r2.readSeq = 0;

        buffer.write(4); // we reach buffer's capacity
        buffer.write(5); // overwrite old data; logical sequence 0 (value 1) is lost forever
        // writeSeq = 5 ; capacity = 4; r2.readSeq = 0;


        // So when r2.read() runs, this code executes: if (readSeq < writeSeq - capacity) {readSeq = writeSeq - capacity;} this changes readSeq = 0 --> readSeq = 1;
        // Since sequence=0 does not exist (it has been overwritten). Through the read() function above, we move Reader 2's pointer to the oldest available value that hasn't been overwritten yet.  
        System.out.println("Reader 2: " + r2.read()); // reads sequence 1 (or index 1) where we see value 2; readSeq++ --> readSeq = 2;
        System.out.println("Reader 2: " + r2.read()); // read 3
        System.out.println("Reader 2: " + r2.read()); // read 4 


    }
}