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

##### Linked Lists vs Arrays
Here’s the comparison of Linked List vs Arrays

**Linked List**:
Data Structure: Non-contiguous
Memory Allocation: Typically allocated one by one to individual elements
Insertion/Deletion: Efficient
Access: Sequential

**Array**:
-  Data Structure: Contiguous
-  Memory Allocation: Typically allocated to the whole array
-  Insertion/Deletion: Inefficient
-  Access: Random

