




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

Certainly! Here’s how you can implement these use cases in Java:

1. **Queue for Processing Orders**:
   **Use Case**: Managing incoming food orders in the order they are received.

   ```java
   import java.util.LinkedList;
   import java.util.Queue;

   public class RestaurantOrderQueue {
       public static void main(String[] args) {
           Queue<String> orderQueue = new LinkedList<>();
           
           // New orders
           orderQueue.add("Order 1");
           orderQueue.add("Order 2");
           orderQueue.add("Order 3");

           // Processing orders
           while (!orderQueue.isEmpty()) {
               String order = orderQueue.poll();
               System.out.println("Processing " + order);
           }
       }
   }
   ```

2. **Deque for Order History**:
   **Use Case**: Keeping track of completed orders and allowing easy access to recent or oldest orders for analysis.

   ```java
   import java.util.ArrayDeque;
   import java.util.Deque;

   public class OrderHistoryDeque {
       public static void main(String[] args) {
           Deque<String> orderHistory = new ArrayDeque<>();
           
           // Completed orders
           orderHistory.addFirst("Completed Order 1");
           orderHistory.addFirst("Completed Order 2");
           orderHistory.addFirst("Completed Order 3");

           // Access most recent order
           System.out.println("Most recent order: " + orderHistory.peekFirst());
           
           // Access oldest order
           System.out.println("Oldest order: " + orderHistory.peekLast());

           // Remove the most recent order
           System.out.println("Removing: " + orderHistory.removeFirst());
       }
   }
   ```

In the first example, `Queue` ensures that orders are processed in the exact sequence they are placed. In the second example, `Deque` allows adding completed orders to the front (most recent first) and provides methods to access or remove orders from either end for analytics.
