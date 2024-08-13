
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

3. **Polymorphism**: Enables objects to be treated as instances of their parent class rather than their actual class, allowing for method overriding and dynamic method binding.

4. **Abstraction**: Hides complex implementation details and shows only the necessary features of an object, often through abstract classes and interfaces.


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


