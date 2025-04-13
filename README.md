# Priority Queue Demo in Java

This Java project demonstrates the implementation and usage of a **generic priority queue** with multiple priority levels, including:
- A string-based queue demo
- A real-world simulation of handling client inquiries

## Features
- Generic priority queue supporting 1 to 10 levels
- FIFO ordering within each priority level
- Supports `add`, `poll`, `remove`, `contains`, and iteration
- Demonstrates usage with strings and a custom class `ClientInquiry`

## Files
- `Main.java` - Contains the `main()` function and two test sections (strings + client inquiries)
- `GenericPriorityQueue.java` - A generic class implementing the priority queue logic
- `ClientInquiry.java` - A simple class representing a client's inquiry
- `run.bat` *(optional)* - Batch script to compile and run the project on Windows

## Run Instructions

### Manual (Command Line)
```bash
javac *.java
java Main
```

### With `run.bat` (Windows only)
Double-click `run.bat` (make sure Java is in your system PATH).

## Sample Output
```
====================== סעיף ב של הממן שימוש במחרוזות =====================

[1] Inserting elements with different priorities:
...

=============================== סעיף ג: בדיקות עם פניות לקוחות ==================================
[1] Adding inquiries with different priorities:
...
```

## Author
Or Saban