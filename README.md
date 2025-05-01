# Java Maze Solver Algorithms 🧩

## Overview 🔍
This Java application implements and compares different algorithms for navigating through a maze to find an exit. The project features three different maze-solving approaches: stack-based (depth-first search), queue-based (breadth-first search), and recursive solutions.

![Maze Solver Animation](maze_animation.gif)

## Project Features 🌟
- **Multiple Search Algorithms:**
  - Stack-based (depth-first search)
  - Queue-based (breadth-first search) 
  - Recursive solution
- **Console-Based Animation:** Visual feedback showing the algorithm's progress
- **Custom Data Structures:** Implementation of stack and queue ADTs
- **Interface-Based Design:** Uses interfaces for polymorphic behavior
- **File I/O:** Reads maze configurations from external files

## Algorithm Comparison 🧠
| Algorithm | Search Pattern | Memory Usage | Optimal Path | Implementation |
|-----------|----------------|--------------|--------------|----------------|
| Stack (DFS) | Explores deep paths first | Lower average memory | Not guaranteed | `PossibleLocationsStack` |
| Queue (BFS) | Explores wide paths first | Higher average memory | Guarantees shortest path | `PossibleLocationsQueue` |
| Recursive | Implicit stack-based | Depends on maze size | Not guaranteed | Direct method calls |

## Technical Implementation ⚙️

### Key Components:
- **Labyrinth.java:** Core maze representation with navigation methods
- **Location.java:** Represents maze coordinates
- **SquareType.java:** Enumeration of possible maze elements
- **PossibleLocations.java:** Interface for search data structures
- **PossibleLocationsStack.java:** Stack implementation for DFS
- **PossibleLocationsQueue.java:** Queue implementation for BFS
- **Simulation.java:** Main driver class for maze solving

### Data Structures:
#### Stack Implementation
```java
public class PossibleLocationsStack implements PossibleLocations {
    private class Node {
        Location data;
        Node next;
    }
    
    Node top;
    
    @Override
    public void add(Location s) {
        Node temp = new Node();
        temp.data = s;
        temp.next = top;
        top = temp;
    }
    
    @Override
    public Location remove() {
        if (isEmpty()) 
            return null;
        Location temp = top.data;
        top = (top).next;
        return temp;
    }
}
```

#### Queue Implementation
```java
public class PossibleLocationsQueue implements PossibleLocations {
    private Location[] q;
    private int capacity, head, tail;
    
    @Override
    public void add(Location s) {
        if (tail == capacity - 1) { 
            capacity = capacity + 6;
            Location[] temp = new Location[capacity];
            for (int i = 0; i < q.length; i++) {
                temp[i] = q[i];
            }
            q = temp;
        }
        q[tail] = s;
        tail++;
    }
    
    @Override
    public Location remove() {
        if (isEmpty())
            return null;
        Location temp = q[head];
        // Implementation details...
        return temp;
    }
}
```

## Maze Representation 🧱
The mazes are represented using characters:
- `x` - Wall (displayed as █)
- ` ` - Corridor (displayed as a space)
- `o` - Way out (displayed as a space but marks potential exits)
- `.` - Visited location (displayed as ░)
- `*` - Start position (displayed as ◉)
- `E` - Exit found (displayed as E)

## Maze Representation 🧱
The mazes are represented using these characters:
- `x` - Wall (displayed as █)
- ` ` - Corridor (displayed as a space)
- `o` - Way out (displayed as a space but marks potential exits)
- `.` - Visited location (displayed as ░)
- `*` - Start position (displayed as ◉)
- `E` - Exit found (displayed as E)

Example maze at different stages:

Initial maze:
```
████████████
█          █
█ ████████ █
█ █      █ █
█ █ ████ █ █
█ █ █  █ █ █
█ █ █  █ █ █
█ █    █ █ █
█ ██████ █ █
█         █ █
█████████  █
████████████
```

Maze with start position set:
```
████████████
█          █
█ ████████ █
█ █      █ █
█ █ ████ █ █
█ █ █  █ █ █
█ █ █  █ █ █
█ █    █ █ █
█ ██████ █ █
█◉        █ █
█████████  █
████████████
```

Maze during exploration (showing visited paths):
```
████████████
█░░░░░░░░░░█
█░████████░█
█░█      █░█
█░█ ████ █░█
█░█ █  █ █░█
█░█ █  █ █░█
█░█    █ █░█
█░██████ █░█
█◉░░░░░░░█░█
█████████░░█
████████████
```

Maze with exit found:
```
████████████
█░░░░░░░░░░█
█░████████░█
█░█      █░█
█░█ ████ █░█
█░█ █  █ █░█
█░█ █  █ █░█
█░█    █ █░█
█░██████ █░█
█◉░░░░░░░█░█
█████████░E█
████████████
```

## Running the Application 🚀
The program accepts two command-line arguments:
1. Input file containing the maze specification
2. Algorithm type: `stack`, `queue`, or `rec`

Example:
```
java Simulation maze1.txt stack
```

## Skills Demonstrated 💪
- **Algorithm Implementation:** Multiple search strategies for problem-solving
- **Data Structure Design:** Custom implementations of abstract data types
- **Object-Oriented Design:** Interface-based programming for flexibility
- **Visual Feedback:** Console-based animation techniques
- **File Parsing:** Reading and interpreting structured data from files
