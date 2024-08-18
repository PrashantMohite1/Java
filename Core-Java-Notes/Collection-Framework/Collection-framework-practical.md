




# stack 

In stack, elements are stored and accessed in Last In First Out manner. That is, elements are added to the top of the stack and removed from the top of the stack. The Java collections framework has a class named Stack that provides the functionality of the stack data structure.The Stack class extends the Vector class.
Certainly! Let’s look at a simple use case for a stack in Java. 

**Use Case: Undo Functionality in a Text Editor**

Imagine you are building a simple text editor, and you want to add an "Undo" feature. When a user makes changes to the text (e.g., typing, deleting), you want to be able to revert these changes if the user decides to undo them.

Here’s how a stack can be used to implement this:

1. **Stack for Undo History**: 
   - You can use a stack to keep track of changes. Each time the user makes a change, you push the state of the text (or the action) onto the stack.

2. **Undo Operation**:
   - When the user clicks "Undo", you pop the most recent state from the stack and revert the text to that state.

**Example in Java:**

```java
import java.util.Stack;

public class TextEditor {
    private StringBuilder text;
    private Stack<String> history;

    public TextEditor() {
        text = new StringBuilder();
        history = new Stack<>();
    }

    // Method to add text
    public void addText(String newText) {
        history.push(text.toString()); // Save current state to history
        text.append(newText); // Modify the text
    }

    // Method to undo the last change
    public void undo() {
        if (!history.isEmpty()) {
            text.setLength(0); // Clear current text
            text.append(history.pop()); // Restore last state
        }
    }

    @Override
    public String toString() {
        return text.toString();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addText("Hello");
        System.out.println(editor); // Outputs: Hello
        editor.addText(" World");
        System.out.println(editor); // Outputs: Hello World
        editor.undo();
        System.out.println(editor); // Outputs: Hello
    }
}
```

**Explanation**:
- **`addText` Method**: Before changing the text, it saves the current state to the stack.
- **`undo` Method**: When undoing, it retrieves the last saved state from the stack and restores it.

In this example, the stack helps keep track of previous text states, allowing the user to undo recent changes efficiently.


# queue and deque 

Sure! Here are some real-world use cases:

1. **Queue**:
   **Use Case**: Task Scheduling
   **Example**: A job queue in a task scheduler where tasks are processed in the order they arrive.

   ```java
   import java.util.LinkedList;
   import java.util.Queue;

   public class TaskScheduler {
       public static void main(String[] args) {
           Queue<String> taskQueue = new LinkedList<>();
           taskQueue.add("Task 1");
           taskQueue.add("Task 2");
           taskQueue.add("Task 3");

           while (!taskQueue.isEmpty()) {
               String task = taskQueue.poll();
               System.out.println("Processing " + task);
           }
       }
   }
   ```

2. **Deque**:
   **Use Case**: Undo/Redo Functionality
   **Example**: Managing undo and redo operations where you can push and pop actions.

   ```java
   import java.util.ArrayDeque;
   import java.util.Deque;

   public class UndoRedoManager {
       public static void main(String[] args) {
           Deque<String> undoStack = new ArrayDeque<>();
           Deque<String> redoStack = new ArrayDeque<>();

           // Perform some actions
           undoStack.push("Action 1");
           undoStack.push("Action 2");
           undoStack.push("Action 3");

           // Undo action
           String action = undoStack.pop();
           redoStack.push(action);
           System.out.println("Undone: " + action);

           // Redo action
           action = redoStack.pop();
           undoStack.push(action);
           System.out.println("Redone: " + action);
       }
   }
   ```

In these examples, a queue processes tasks in a first-in, first-out manner, while a deque allows for efficient addition and removal from both ends, useful for managing undo and redo operations.
