




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

The queue is an abstract data type or linear data structure from which elements can be inserted at the rear(back) of the queue and elements can be deleted from the front(head) of the queue.

The double-ended queue is an abstract data type that generalizes a queue from which elements can be inserted or deleted either from both front(head) or rear(tail) ends.

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



# set 
In Java, a `Set` is a collection that does not allow duplicate elements. It is part of the Java Collections Framework and is implemented by several classes, including `HashSet`, `LinkedHashSet`, and `TreeSet`. 

### Why Use a Set?

1. **Uniqueness**: If you need to ensure that a collection contains no duplicate elements, a `Set` is ideal. For example, if you're collecting user IDs, you wouldn't want any ID to appear more than once.

2. **Efficient Lookups**: Sets are optimized for operations like checking if an element exists (contains), adding new elements, and removing elements. This is often more efficient than other collections, such as lists, for these operations.

3. **Mathematical Set Operations**: Sets support operations like union, intersection, and difference, which are useful in various scenarios like database operations or complex data analysis.

### Real-World Use Case

#### 1. Hashset

Imagine you're developing a system that processes user registrations. You want to keep track of all unique user IDs that have signed up. Using a `Set` ensures that no user ID is added more than once.

Here's a simple example to illustrate this:

```java
import java.util.HashSet;
import java.util.Set;

public class UserRegistrationSystem {
    public static void main(String[] args) {
        // Create a Set to store unique user IDs
        Set<String> userIds = new HashSet<>();

        // Simulate user registrations
        userIds.add("user123");
        userIds.add("user456");
        userIds.add("user123"); // Duplicate ID, will be ignored

        // Print all unique user IDs
        System.out.println("Registered User IDs: " + userIds);

        // Check if a specific user ID is already registered
        if (userIds.contains("user789")) {
            System.out.println("User ID user789 is already registered.");
        } else {
            System.out.println("User ID user789 is available.");
        }
    }
}
```

### Explanation:

1. **Creation**: `HashSet<String> userIds = new HashSet<>();` creates a `HashSet` that will store user IDs as unique elements.

2. **Adding Elements**: `userIds.add("user123");` adds user IDs to the set. When you add `"user123"` a second time, it is ignored because sets do not allow duplicates.

3. **Checking Existence**: `userIds.contains("user789");` checks if a specific user ID is already in the set.

4. **Output**: The `println` statements show how the `Set` manages unique elements and can be used to check membership efficiently.

In summary, a `Set` is a valuable data structure when you need to maintain a collection of unique elements and perform efficient operations like checking for existence, adding new elements, and removing elements.
