# Generics In Java

Generics means parameterized types. The idea is to allow type (Integer, String, … etc., and user-defined types) to be a parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work with different data types. An entity such as class, interface, or method that operates on a parameterized type is a generic entity.

**generic methods**:-
-  Generic Java method takes a parameter and returns some value after performing a task. It is exactly like a normal function, however, a generic method has type parameters
When you use (or call) the generic method, you specify the actual type that you want to use instead of the placeholder. 





Generics in Java are a powerful feature introduced in Java 5 that allows you to write flexible, reusable code while providing compile-time type safety. Generics enable you to create classes, interfaces, and methods that operate on typed parameters, which can be specified when you use them.

### Why We Need Generics

1. **Type Safety**: Generics provide stronger type checks at compile-time. This means that errors that would have only shown up at runtime with non-generic code can be caught early, preventing potential runtime errors.

2. **Code Reusability**: By using generics, you can write code that works with any type while ensuring that type-specific logic is handled correctly. This avoids code duplication and increases maintainability.

3. **Elimination of Casts**: Without generics, you'd have to cast objects retrieved from collections, which can be error-prone and tedious. Generics eliminate the need for these casts, making the code cleaner and easier to understand.

### Use Cases

#### 1. **Generic Classes**

**Example**: A generic class `Box<T>` that can hold any type of object.

```java
public class Box<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

// Usage
Box<String> stringBox = new Box<>();
stringBox.setContent("Hello");
String content = stringBox.getContent();  // No cast needed

Box<Integer> intBox = new Box<>();
intBox.setContent(123);
Integer intContent = intBox.getContent();  // No cast needed
```

In this example, `Box<T>` can be used to hold any type of content. The type parameter `T` is specified when creating an instance of `Box`, making it type-safe and eliminating the need for type casting.

#### 2. **Generic Methods**

**Example**: A generic method `printArray` that can print elements of any type.

```java
public class GenericPrinter {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"A", "B", "C"};
        
        printArray(intArray);  // Prints: 1 2 3
        printArray(strArray);  // Prints: A B C
    }
}
```

Here, `printArray` is a generic method that can operate on arrays of any type. This allows you to use the same method for different types without writing overloaded versions.

#### 3. **Generic Interfaces**

**Example**: A generic interface `Comparable<T>` used to compare objects of type `T`.

```java
public interface Comparable<T> {
    int compareTo(T other);
}

public class Person implements Comparable<Person> {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}
```

In this example, `Comparable<T>` is a generic interface that defines a method `compareTo`. By implementing `Comparable<Person>`, the `Person` class can be compared with other `Person` objects, ensuring type safety.

### Benefits of Generics

- **Compile-time Checking**: Errors related to types are caught during compilation rather than at runtime, reducing the chances of `ClassCastException`.
- **Code Reusability**: Generic classes and methods can handle a wide range of types, making your code more flexible and reusable.
- **Readability and Maintainability**: Generics make the code easier to read and maintain by eliminating unnecessary type casts and clarifying the intended type usage.
