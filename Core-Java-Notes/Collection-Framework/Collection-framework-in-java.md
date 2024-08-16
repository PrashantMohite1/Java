![alt text](https://github.com/PrashantMohite1/Java/blob/main/Java_Core_Images/hierarchy-of-collection-framework-in-java.jpg)   


# collection framework in java 

The Java collections framework is a set of classes and interfaces that implement commonly reusable collection data structures.

**Java Collection Interface** :- 

## Collection Root Interface 
The Collection interface is the root interface of the collections framework hierarchy.Java does not provide direct implementations of the Collection interface but provides implementations of its subinterfaces like List, Set, and Queue.

#### Methods of Collection
The Collection interface includes various methods that can be used to perform different operations on objects. These methods are available in all its subinterfaces.

  add() - inserts the specified element to the collection
  size() - returns the size of the collection
  remove() - removes the specified element from the collection
  iterator() - returns an iterator to access elements of the collection
  addAll() - adds all the elements of a specified collection to the collection
  removeAll() - removes all the elements of the specified collection from the collection
  clear() - removes all the elements of the collection

### List ( subinterface of Collection Interface ) :- 

Since List is an interface, we cannot create objects from it.

In order to use the functionalities of the List interface, we can use these classes:
  ArrayList
  LinkedList
  Vector
  Stack



