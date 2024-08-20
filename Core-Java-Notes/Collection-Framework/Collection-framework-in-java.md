![alt text](https://github.com/PrashantMohite1/Java/blob/main/Java_Core_Images/hierarchy-of-collection-framework-in-java.jpg)   


# collection framework in java 

The Java collections framework is a set of classes and interfaces that implement commonly reusable collection data structures.

**Java Collection Interface** :- 

## Collection Root Interface 
The Collection interface is the root interface of the collections framework hierarchy.Java does not provide direct implementations of the Collection interface but provides implementations of its subinterfaces like List, Set, and Queue.

#### Methods of Collection
The Collection interface includes various methods that can be used to perform different operations on objects. These methods are available in all its subinterfaces.

  -  add() - inserts the specified element to the collection
  -  size() - returns the size of the collection
  -  remove() - removes the specified element from the collection
  -  iterator() - returns an iterator to access elements of the collection
  -  addAll() - adds all the elements of a specified collection to the collection
  -  removeAll() - removes all the elements of the specified collection from the collection
  -  clear() - removes all the elements of the collection

### List ( subinterface of Collection Interface ) :- 

Since List is an interface, we cannot create objects from it.

In order to use the functionalities of the List interface, we can use these classes: ArrayList, LinkedList, Vector, Stack

#### ArrayList
ArrayList in Java is a dynamic array implementation that provides a flexible and efficient way to store and manage a list of elements. Here’s how it works under the hood:

1. Basic Structure
Backed by an Array: ArrayList is implemented using a regular array to store its elements. This array is initially created with a certain capacity, which can grow dynamically as needed.
2. Dynamic Resizing
Initial Capacity: When you create an ArrayList, it starts with an initial capacity. For example, new ArrayList<>() uses a default initial capacity of 10.
Growth Strategy: When the array becomes full (i.e., when the number of elements exceeds the current capacity), the ArrayList grows automatically. This is done by creating a new, larger array and copying the elements from the old array to the new one. Typically, the new array is about twice the size of the old one, though the exact growth strategy can vary depending on the implementation.

#### Linked List

What is a Linked List?
A linked list is a linear data structure that consists of a series of nodes connected by pointers (in C or C++) or references (in Java, Python and JavaScript). Each node contains data and a pointer/reference to the next node in the list. Unlike arrays, linked lists allow for efficient insertion or removal of elements from any position in the list, as the nodes are not stored contiguously in memory.

**Types:**
-  Singly Linked List: Each node points to the next node.
-  Doubly Linked List: Each node points to both the next and the previous nodes.
-  Access: Sequential access (linear-time complexity, O(n)).



##### ArrayList vs LinkedLists 

  | Feature              | `ArrayList`                                                         | `LinkedList`                                                       |
|----------------------|---------------------------------------------------------------------|---------------------------------------------------------------------|
| **Internal Structure** | **Backed by an Array**: Internally uses a dynamic array to store elements. <br> **Contiguous Memory**: Elements are stored in contiguous memory locations, which allows for fast index-based access. | **Backed by a Doubly Linked List**: Internally uses a doubly linked list where each element (node) contains a reference to both the next and the previous node. <br> **Non-contiguous Memory**: Elements are stored in non-contiguous memory locations. |
| **Memory Usage**     | **Less Memory Overhead**: Requires less memory overhead because it uses a single array. The overhead is mainly due to the array's resizing mechanism. | **More Memory Overhead**: Requires more memory due to storing additional pointers (references) in each node (for both next and previous nodes). |
| **Resizing**         | **Dynamic Resizing**: When the array becomes full, a new, larger array is created, and elements are copied over. This resizing operation can be costly, but it’s amortized over many insertions. | **No Resizing**: Since `LinkedList` does not use a contiguous block of memory, there is no need for resizing. Nodes are added or removed without affecting other nodes. |



#### Stack 
In stack, elements are stored and accessed in Last In First Out manner. That is, elements are added to the top of the stack and removed from the top of the stack.
The Java collections framework has a class named Stack that provides the functionality of the stack data structure.The Stack class extends the Vector class.


### Queue 
The queue is an abstract data type or linear data structure from which elements can be inserted at the rear(back) of the queue and elements can be deleted from the front(head) of the queue.

### Deque
The double-ended queue is an abstract data type that generalizes a queue from which elements can be inserted or deleted either from both front(head) or rear(tail) ends.

**usecase**:- 

- Imagine you are building an app to take food orders at a restaurant. New orders are placed by customers continuously. The kitchen needs to view and process these orders in a strict first-come-first-served manner. A queue data structure is perfect for this ordering requirement.

- Now consider the app also needs to keep a history of all past orders for analytics. The history should maintain order of completion rather than order of placement. A deque can provide easy access to this historical data from both front and back.
- 

### Set :- 
It is an unordered collection of objects in which duplicate values cannot be stored. 

**Enum**
Enumerations or Java Enum serve the purpose of representing a group of named constants in a programming language.


