




# stack 

In stack, elements are stored and accessed in Last In First Out manner. That is, elements are added to the top of the stack and removed from the top of the stack. The Java collections framework has a class named Stack that provides the functionality of the stack data structure.The Stack class extends the Vector class.
Certainly! Let’s look at a simple use case for a stack in Java. 

Creating a Queue
You can instantiate a Queue using various implementations. Here are a few common ones:

Using LinkedList:

```java
Queue<String> queue = new LinkedList<>();
```

Using PriorityQueue:

```java
Queue<Integer> priorityQueue = new PriorityQueue<>();
Common Operations
```

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

### `HashSet`

- **What it is:** A `HashSet` is a collection that does not allow duplicate elements and does not guarantee any specific order of the elements.
- **How it works:** It uses a hash table internally to store elements. This means it can provide very fast access to elements, but the order in which elements are stored or retrieved is not predictable.

**Use Case:**
Suppose you want to store a collection of unique user IDs and you don’t care about the order in which they are stored or retrieved. `HashSet` is perfect for this scenario.

**Example Code:**

```java
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> userIds = new HashSet<>();

        // Adding user IDs
        userIds.add("user123");
        userIds.add("user456");
        userIds.add("user789");
        userIds.add("user123"); // Duplicate, will not be added

        // Displaying user IDs
        for (String userId : userIds) {
            System.out.println(userId);
        }
    }
}
```

In this example:
- Adding `"user123"` again will not change the set because `HashSet` doesn’t allow duplicates.
- The output order is not guaranteed.

### `LinkedHashSet`

- **What it is:** A `LinkedHashSet` is similar to `HashSet` but it maintains the insertion order of the elements.
- **How it works:** It uses a hash table and a linked list. The hash table provides fast access to elements, while the linked list maintains the order of elements as they were inserted.

**Use Case:**
Suppose you want to store unique user IDs and you want to retrieve them in the order they were added. `LinkedHashSet` is ideal for this use case.

**Example Code:**

```java
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<String> userIds = new LinkedHashSet<>();

        // Adding user IDs
        userIds.add("user123");
        userIds.add("user456");
        userIds.add("user789");
        userIds.add("user123"); // Duplicate, will not be added

        // Displaying user IDs
        for (String userId : userIds) {
            System.out.println(userId);
        }
    }
}
```

In this example:
- The duplicate `"user123"` will not be added, similar to `HashSet`.
- The output will maintain the order in which the user IDs were added: `user123`, `user456`, `user789`.

### Summary

- Use `HashSet` when you need a collection of unique elements and order doesn’t matter.
- Use `LinkedHashSet` when you need a collection of unique elements and you want to maintain the order in which elements are inserted.



### `TreeSet`

- **Definition:** A `TreeSet` is a collection in Java that implements the `NavigableSet` interface and is part of the Java Collections Framework.
- **Features:**
  - **Sorted Order:** Elements are stored in a sorted order according to their natural ordering (if they implement `Comparable`) or according to a specified `Comparator`.
  - **No Duplicates:** It does not allow duplicate elements.
  - **Performance:** Operations like adding, removing, and checking if an element is present are efficient, typically `O(log n)`.
  - ** heterogenious data types are not allowed. means in treeset we can only store same data types 

### How It Works

- **Data Structure:** Internally, `TreeSet` uses a Red-Black tree, which is a type of self-balancing binary search tree. This structure keeps the elements sorted and allows for efficient retrieval, insertion, and deletion.
- **Ordering:** By default, it uses the natural ordering of elements (like integers or strings). Alternatively, you can provide a custom `Comparator` to define the order.

### Real-World Code Use Cases

#### Use Case 1: Maintaining a Sorted List of Unique Elements

**Scenario:** You need to maintain a list of unique student names in alphabetical order.

**Example Code:**

```java
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> studentNames = new TreeSet<>();

        // Adding student names
        studentNames.add("John");
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Alice"); // Duplicate, will not be added

        // Displaying student names in sorted order
        System.out.println("Student names in sorted order:");
        for (String name : studentNames) {
            System.out.println(name);
        }
    }
}
```

**Output:**

```plaintext
Student names in sorted order:
Alice
Bob
John
```

In this example:
- The names are automatically sorted alphabetically.
- Duplicates are not allowed, so `"Alice"` is added only once.

#### Use Case 2: Custom Sorting with a Comparator

**Scenario:** You need to maintain a sorted list of integers but in descending order.

**Example Code:**

```java
import java.util.Comparator;
import java.util.TreeSet;

public class CustomComparatorExample {
    public static void main(String[] args) {
        // Create a TreeSet with a custom comparator for descending order
        TreeSet<Integer> numbers = new TreeSet<>(Comparator.reverseOrder());

        // Adding numbers
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(15);

        // Displaying numbers in descending order
        System.out.println("Numbers in descending order:");
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}
```

**Output:**

```plaintext
Numbers in descending order:
20
15
10
5
```

In this example:
- The `TreeSet` is created with a custom `Comparator` that sorts the integers in descending order.
- The numbers are stored and retrieved in descending order due to the custom comparator.

### Summary

- **`TreeSet`** is ideal when you need a collection of unique elements that are always kept in a sorted order.
- You can use the default natural ordering or specify a custom order with a `Comparator`.
- **Performance**: Operations like insertion, deletion, and lookup are efficient due to the underlying Red-Black tree structure.

