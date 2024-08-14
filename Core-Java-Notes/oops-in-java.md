
# oops ( object oriented programming )


**Access Modifier**: Defines the access type of the method i.e. from where it can be accessed in your application. 

In Java, there are 4 types of access specifiers: 

1. public: Accessible in all classes in your application.
2. protected: Accessible within the package in which it is defined and in its subclass(es) (including subclasses         declared outside the package).
3. private: Accessible only within the class in which it is defined.
4. default (declared/defined without using any modifier): Accessible within the same class and package within which     its class is defined.



## brief explanation of the key OOP (Object-Oriented Programming) pillars in Java:

1. **Encapsulation**: Bundles data (variables) and methods (functions) that operate on the data into a single unit or class, restricting direct access to some of the object’s components.

2. **Inheritance**: Allows a new class (subclass) to inherit properties and behavior (methods) from an existing class (superclass), promoting code reuse.

3. **Polymorphism**: The word polymorphism means having many forms.Polymorphism allows us to perform a single action in different ways. We can perform polymorphism in java by method overloading and method overriding.
   
5. **Abstraction**: Hides complex implementation details and shows only the necessary features of an object, often through abstract classes and interfaces.


---------------------------------------
-----------------------------------

## Encapsulation 

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



---------------------------------------------
--------------------------------------------

## abstraction 


Data abstraction is the process of hiding certain details and showing only essential information to the user.
Abstraction can be achieved with either abstract classes or interfaces (which you will learn more about in the next chapter).

-    To use an abstract class, you have to inherit it from the base class. Here, you have to provide implementations for the abstract methods, else it will become an abstract class.

Sure! Here are code samples for the two scenarios demonstrating abstraction in Java.

**we cant create object of abstract class because in abstract class we have only obstract method that we need to implement in child class or subclass. but we can create a object of subclass of abstract class**

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


-------------------------------------------------------------------------
---------------------------------------------------------------------------

## Polymorphism

Method Overloading
When there are multiple functions with the same name but different parameters then these functions are said to be overloaded. Functions can be overloaded by changes in the number of arguments or/and a change in the type of arguments.
