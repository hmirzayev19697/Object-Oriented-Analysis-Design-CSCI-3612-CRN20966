# Assignment 2 - Ring Buffer

## Overview
TThis project implements a fixed-capacity ring buffer that supports:    
- Single Writer
- Multiple Readers
- Readers read independently

The buffer allows a single writer to continuously write data.
Multiple readers can read from the same buffer independently, without interfering with each other.

Reading does not remove data from the buffer.
If the buffer becomes full, newly written data overwrites the oldest data.
Readers that are too slow may miss overwritten data.

## Design Explanation (Class Responsibilities)

### `RingBuffer<T>`

**Responsibility:**  
Stores data and manages writing.

**Key aspects:**

- Holds a fixed-size array (the ring buffer)
- Contains single writer to write data
- Overwrites old data when capacity is exceeded
- Tracks the total number of written elements (`writeSeq`)

The buffer is simple and unaware of readers.

---

### `Reader<T>`

**Responsibility:**  
Designed for each independent reader.

**Key aspects:**

- Each reader has its own read position (`readSeq`)
- Reading does not affect other readers
- Automatically skips data that has already been overwritten
- Slow readers can fall behind the writer and miss items (by design)

Each reader behaves as if it is the only reader in the system.

---

### `Main`

**Responsibility:**  
To Demonstrate and test the ring buffer behavior.

**How the testing demonstration goes:**

- Creates the ring buffer
- Creates multiple readers
- Writes data into the buffer
- Demonstrates independent reader behavior
- Shows how slow readers miss overwritten data



## UML
### Class Diagram
<img src="UML%20diagrams/ClassDiagram.png" alt="Class Diagram" width="800"/>

## Sequence diagram for write
<img src="UML%20diagrams/SeqDiagram_write.png" alt="Class Diagram" width="400"/>

## Sequence diagram for read
<img src="UML%20diagrams/SeqDiagram_read.png" alt="Class Diagram" width="400"/>

## How to Run

1. Download the current repo
2. Through Terminal Window, run these commands: <br>
`javac Assignment_2/*.java` - To compile all three java files<br>
`java Assignment_2.Main` - To run the Main function and see Ringbuffer's demonstration

