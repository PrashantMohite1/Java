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


### what is binary search tree data type?

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

**four types of Java Set implementations:**
-  **EnumSet** :- EnumSet is a special type of Set designed specifically for dealing with enum values. Enums are like lists of named constants (e.g., days of the week, colors).
-  **HashSet** :- HashSet is a general-purpose implementation of the Set interface that uses a hash table for storage.
    hashtable reference :- https://www.youtube.com/watch?v=JVdMD3r7dSs&t=323s&pp=ygUPaGFzaGluZyBpbiBqYXZh
   
-  **LinkedHashSet**
  LinkedHashSet is an implementation of the Set interface that combines the features of HashSet and a linked list.A LinkedHashSet is similar to HashSet but it maintains the insertion order of the elements uses a doubly linked list to keep track of the order. Each element in the set is linked to the previous and next elements, thus preserving the sequence of insertion.
  
-  **Treeset** :- treeset store unique homogenious elements with sorting order. The default sorting is based on the natural ordering of the elements (like alphabetical order for strings or numerical order for integers). You can also specify a custom order using a Comparator.
    -  Data Structure: Internally, TreeSet uses a Red-Black tree, which is a type of self-balancing binary search tree. This structure keeps the elements sorted and allows for efficient 
        retrieval, insertion, and deletion.
    -   The underlying data structure for treeset is Balanced Tree.
    -   in total collection framework 2 areas where Heterogeneous Object are not allowed - in treeset and tree map.


##### what is Heterogeneous Object and Homogeneous Object

- **Heterogeneous Object:** An object or data structure that contains different types of elements, rather than elements all of the same type.
- **Homogeneous Object:** In contrast, an object where all elements are of the same type is homogeneous.

##### what is tree data type and its type 



### `Map` Interface

The `Map` interface in Java is a collection that maps keys to values. Each key is unique, and each key maps to exactly one value. Think of it like a dictionary where you look up a word (key) and get its definition (value). 

#### `HashMap`

- **How it works:** `HashMap` uses a technique called hashing to store and retrieve key-value pairs. It distributes the pairs into "buckets" based on the hash code of the key.
- **Characteristics:**
  - **No guaranteed order:** The order of entries can be random and may change over time.
  - **Fast access:** Generally provides constant-time performance for basic operations (like adding, removing, or finding elements).
- **Use case:** Use `HashMap` when you need a quick look-up and don’t care about the order of the entries.

#### `TreeMap`

- **How it works:** `TreeMap` stores the entries in a sorted order based on the natural ordering of the keys (or by a custom comparator if provided).
- **Characteristics:**
  - **Sorted order:** Keys are always kept in ascending order.
  - **Slower access:** Operations like adding or removing elements can be slower compared to `HashMap` because it needs to maintain the order.
- **Use case:** Use `TreeMap` when you need the entries to be sorted by key and can afford the extra time for maintaining this order.

#### `LinkedHashMap`

- **How it works:** `LinkedHashMap` maintains a linked list of the entries in the order they were added. It uses a hash table for quick access.
- **Characteristics:**
  - **Insertion order:** Entries are iterated in the order they were inserted.
  - **Moderate access speed:** Slightly slower than `HashMap` due to the overhead of maintaining the linked list, but still generally fast.
- **Use case:** Use `LinkedHashMap` when you need to maintain the insertion order of entries but still want the fast access provided by `HashMap`.

