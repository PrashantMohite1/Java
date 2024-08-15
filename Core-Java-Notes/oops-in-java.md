
# oops ( object oriented programming )


**Access Modifier**: Defines the access type of the method i.e. from where it can be accessed in your application. 

In Java, there are 4 types of access specifiers: 

1. public: Accessible in all classes in your application.
2. protected: Accessible within the package in which it is defined and in its subclass(es) (including subclasses         declared outside the package).
3. private: Accessible only within the class in which it is defined.
4. default (declared/defined without using any modifier): Accessible within the same class and package within which     its class is defined.



## brief explanation of the key OOP (Object-Oriented Programming) pillars in Java:

1. **Encapsulation**: Bundles data (variables) and methods (functions) that operate on the data into a single unit or class, restricting direct access to some of the object’s components.

2. **Abstraction**: Hides complex implementation details and shows only the necessary features of an object, often through abstract classes and interfaces.

3. **Inheritance**: Allows a new class (subclass) to inherit properties and behavior (methods) from an existing class (superclass), promoting code reuse.

4. **Polymorphism**: The word polymorphism means having many forms.Polymorphism allows us to perform a single action in different ways. We can perform polymorphism in java by method overloading and method overriding.
   



-----------------------------------
## Encapsulation 
---------------------------------------

Encapsulation refers to the practice of bundling the data (attributes) and methods (functions) that operate on the data into a single unit or class. It also involves restricting access to some of the object's components, which helps to prevent unintended interference and misuse.encapsulation uses private access modifier to hide the data and use getter and setter to provide controlled access to data.


### usecase :- let say we havent use correct access modifier in program how it will misused 


code to for bankaccount class and here we used balance as public variable

```java
public class BankAccount {
    public double balance; // public variable

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
```

**Direct Manipulation**
   - **Problem**: External code can directly modify the `balance` field without using the provided methods (`deposit` and `withdraw`), which can lead to unintended side effects and inconsistent states.
   - **Example**:
     ```java
     public class Main {
         public static void main(String[] args) {
             BankAccount account = new BankAccount(1000.00);
             
             System.out.println("Initial Balance: $" + account.balance);
             
             // Directly manipulating the balance
             account.balance = -500.00; // Invalid state
            
             System.out.println("After Direct Manipulation: $" + account.balance);
         }
     }
     ```
   - **Consequence**: The balance can be set to an invalid value, such as a negative number, which could break the logic of deposit and withdrawal methods that assume valid states.

If you use `private` for the `balance` field and provide public methods to interact with it, the issues of direct manipulation and unintended side effects can be effectively mitigated. Here's how encapsulation with private fields and public methods helps avoid the problems outlined previously:



### How Private Fields Address Issues and solves above problem

#### Example with Private Fields

```java
public class BankAccount {
    private double balance; // private variable

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
```



**Direct Manipulation**

   **Problem Without Private**: With a public `balance` field, external code can directly modify the `balance` attribute, potentially introducing invalid values or breaking the integrity of the object.

   **Solution With Private**: By declaring `balance` as `private`, you prevent external classes from directly accessing or modifying it. All changes to the `balance` must go through the provided methods (`deposit` and `withdraw`), which include validation logic.

   **Example**:
   ```java
   public class Main {
       public static void main(String[] args) {
           BankAccount account = new BankAccount(1000.00);
           
           System.out.println("Initial Balance: $" + account.getBalance());
           
           // Direct manipulation is not possible
           // account.balance = -500.00; // Compilation error: balance has private access

           // Use provided methods to interact with balance
           account.deposit(500.00);
           account.withdraw(200.00);
           
           System.out.println("After Deposits and Withdrawals: $" + account.getBalance());
       }
   }
   ```
   **Benefit**: Since `balance` is private, direct modifications are not possible. Only the `deposit` and `withdraw` methods can alter `balance`, ensuring that any change is validated according to the class’s rules.




--------------------------------------------
## abstraction 
---------------------------------------

Data abstraction is the process of hiding certain details and showing only essential information to the user.
Abstraction can be achieved with either abstract classes or interfaces.

-    To use an abstract class, you have to inherit it from the base class. Here, you have to provide implementations for the abstract methods, else it will become an abstract class.

Sure! Here are code samples for the two scenarios demonstrating abstraction in Java.

**we cannot create object of abstract class because in abstract class we have only obstract method that we need to implement in child class or subclass. but we can create a object of subclass of abstract class**

```
# syntax to create object of `subclass of abstract class'

new abstract-class-name = new sub-class-name();
```

### Scenario 1: Payment Processing System

**With Abstraction:**

1. **Define an Abstract Class for Payment Methods:**

```java
// Abstract class defining the abstraction
public abstract class PaymentMethod {
    // Abstract method to be implemented by subclasses
    public abstract void processPayment(double amount);
}
```

2. **Implement Concrete Payment Methods:**

```java
// Concrete implementation for Credit Card Payment
public class CreditCardPayment extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Implementation for processing credit card payment
    }
}

// Concrete implementation for PayPal Payment
public class PayPalPayment extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // Implementation for processing PayPal payment
    }
}
```

3. **Use the Abstraction in Your Application:**

```java
public class PaymentProcessor {
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment(double amount) {
        paymentMethod.processPayment(amount);
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentProcessor processor = new PaymentProcessor(creditCard);
        processor.makePayment(100.0); // Processing credit card payment of $100.0

        PaymentMethod payPal = new PayPalPayment();
        processor = new PaymentProcessor(payPal);
        processor.makePayment(200.0); // Processing PayPal payment of $200.0
    }
}
```




### Impact of Not Using Abstraction

If you did not use abstraction in your program, you would have a direct dependency on concrete implementations. Here’s how it might look without abstraction:

1. **Direct Implementation**: Suppose you had methods in the `PaymentProcessor` class for each payment method:

    ```java
    public class PaymentProcessor {
        public void processCreditCardPayment(double amount) {
            System.out.println("Processing credit card payment of $" + amount);
        }

        public void processPayPalPayment(double amount) {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }
    ```

    You’d then call these methods directly based on the payment type:

    ```java
    public class Main {
        public static void main(String[] args) {
            PaymentProcessor processor = new PaymentProcessor();      # syntax of object creation : - ClassName objectName = new ClassName();
            processor.processCreditCardPayment(100.0); // Processing credit card payment of $100.0
            processor.processPayPalPayment(200.0); // Processing PayPal payment of $200.0
        }
    }
    ```

2. **Lack of Flexibility**: If you need to add a new payment method, you would have to modify the `PaymentProcessor` class to add new methods. This breaks the open/closed principle, which states that a class should be open for extension but closed for modification.

3. **Code Duplication**: If the payment processing logic was duplicated for each method, it would be harder to maintain and update.

### Benefits of Your Abstraction

In your program, the `PaymentMethod` abstract class defines a common interface for all payment methods. Concrete classes like `CreditCardPayment` and `PayPalPayment` implement this interface with their specific processing logic. This has several advantages:

1. **Decoupling**: `PaymentProcessor` is decoupled from the specific payment methods. It relies only on the `PaymentMethod` interface, making it easier to add new payment methods without altering the `PaymentProcessor`.

2. **Flexibility**: You can easily switch between different payment methods by changing the instance passed to the `PaymentProcessor` without modifying the `PaymentProcessor` itself.

3. **Maintainability**: Changes to the payment processing logic are confined to the specific payment method classes. If the way payments are processed changes, you only need to update the relevant subclass.

4. **Extensibility**: Adding new payment methods is straightforward. You only need to create a new subclass of `PaymentMethod` and provide the implementation for `processPayment`.



### Purpose of Abstraction

Abstraction is a fundamental concept in object-oriented programming that allows you to define a common interface for a set of related classes while hiding the implementation details. The primary goals of abstraction are:

1. **Simplify Code**: Abstraction simplifies interaction with complex systems by providing a simplified interface. Users of the abstraction don’t need to understand the intricate details of the implementation.

2. **Encapsulate Change**: By abstracting the common functionality, you can change the internal implementation of a class without affecting the classes that use it.

3. **Promote Reusability**: Abstraction allows you to define generic and reusable components. For example, adding new payment methods in the future becomes straightforward by extending the abstract class.


### difference between Interface and abstract class

![alt text](https://github.com/PrashantMohite1/Java/blob/main/Java_Core_Images/interface-vs-abstract-class.png)




---------------------------------------------------------------------------
## Inheritance
-------------------------------------------------------------------------

Java, Inheritance is the mechanism in Java by which one class is allowed to inherit the features(fields and methods) of another class. In Java, Inheritance means creating new classes based on existing ones. A class that inherits from another class can reuse the methods and fields of that class. In addition, you can add new fields and methods to your current class as well.  

Types of Inheritance 
1. **Single Inheritance** -: In single inheritance, a sub-class is derived from only one super class. It inherits the properties and behavior of a single-parent class.
2. **Multilevel Inheritance** -: In Multilevel Inheritance, a child class will be inheriting a base class, and as well as the child class also acts as the base class for other classes.
3. **Hierarchical Inheritance** -: In Hierarchical Inheritance, one class serves as a superclass (base class) for more than one subclass(child class).
4. **Multiple Inheritance (Through Interfaces)** : - In Multiple inheritances, one class can have more than one superclass and inherit features from all parent classes. Please note that Java does not support multiple inheritances with classes. In Java, we can achieve multiple inheritances only through Interfaces. In the image below, Class C is derived from interfaces A and B.
5. **Hybrid Inheritance** -: Hybrid means consist of more than one. Hybrid inheritance is the combination of two or more types of inheritance.
   
![alt text](https://github.com/PrashantMohite1/Java/blob/main/Java_Core_Images/inheritance-in-java.jpg)

---------------------------------------------------------------------------
## Polymorphism
-------------------------------------------------------------------------
Polymorphism allows us to perform a single action in different ways. In other words, polymorphism allows you to define one interface and have multiple implementations. The word “poly” means many and “morphs” means forms, So it means many forms.

In Java Polymorphism is mainly divided into two types: 

-   Compile-time Polymorphism - done by method overloading 
-   Runtime Polymorphism - done by method overiding 


![Alt text](https://github.com/PrashantMohite1/Java/blob/main/Java_Core_Images/OverridingVsOverloading.png)

### Method Overloading
When there are multiple functions with the same name but different parameters then these functions are said to be overloaded. Functions can be overloaded by changes in the number of arguments or/and a change in the type of arguments.

### Method overiding 
-   In Java, Overriding is a feature that allows a subclass or child class to provide a specific implementation of a method that is already provided by one of its super-classes or parent classes. When a method in a subclass has the same name, the same parameters or signature, and the same return type(or sub-type) as a method in its super-class, then the method in the subclass is said to override the method in the super-class.

### What is Is-A-Relationship in Java?
A relationship in Java means different relations between two or more classes. For example, if a class Bulb inherits another class Device, then we can say that Bulb is having is-a relationship with Device, which implies Bulb is a device.  

In Java, we have two types of relationship:

-   Is-A relationship: Whenever one class inherits another class, it is called an IS-A relationship.
-   Has-A relationship: Whenever an instance of one class is used in another class, it is called HAS-A relationship.


---
### difference between Inheritance and polymorphism 


| S.NO | Inheritance                                                                 | Polymorphism                                                                                       |
|------|------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| 1    | Inheritance is when a new class (derived class) is created that inherits features from an existing class (base class). | Polymorphism refers to the ability to define multiple forms for a function or method.              |
| 2    | It is primarily applied to classes.                                          | It is primarily applied to functions or methods.                                                   |
| 3    | Inheritance supports reusability and reduces code length in object-oriented programming. | Polymorphism allows objects to decide which form of the function to use at compile-time (overloading) or run-time (overriding). |
| 4    | Inheritance can be single, hybrid, multiple, hierarchical, and multilevel.     | Polymorphism can be compile-time (overloading) or run-time (overriding).                           |
| 5    | It is used in pattern design.                                                 | It is also used in pattern design.                                                                 |
| 6    | **Example:** The class `Bike` can inherit from the class `TwoWheelVehicle`, which could itself be a subclass of `Vehicle`. | **Example:** The class `Bike` can have a method named `set_color()`, which changes the bike’s color based on the color name entered. |

