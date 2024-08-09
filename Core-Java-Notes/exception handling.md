

#runtime stack trace mechanism


-   Each and every call performed in a thread is stored in the stack.
-   Each entry in the run-time stack is known as an activation record or stack frame.
-   Each entry in the run-time stack is known as an activation record or stack frame.

means if exception found then stop program execution flow this is thing it follows 
if not found then complete program execution 
elif catch then also complete program excution this is behaviour of exception handling 

#### if found exeception :- 
to find at which line actually exception happend, exception has mechanism in which for every thread it create a stack memory and start adding methods in the form of stack frames in that stack.
after successfull and or even after exception it removed all stack frame and return stack memory to computer

but if exception found at that frame -: it stops adding content in stack becuause it found exception and after that it check any try catch for this exception then if it found not catch then it stop excution
throw error and stop program remove all frames from stack.

if it not found exception - : it create a stack for a thread and start adding methods in the form of stack frames and after execution remove it one by one 

conclusion:-
when every it found exception then it stops adding a frames in that stacks and if catch not found it throws exception it simply removes all frames from stack.

is this is behaviour execptions in java

## Case 1: Normally (graceful termination)

Construction of run-time Stack : 

Firstly, the main thread will call the main() method, and the corresponding entry will be in the stack.
After that main() method is called the fun() method, which will store in the stack.
In the fun() method, moreFun() method is called. Therefore at last moreFun() will be stored in the stack.
Finally, moreFun() is not calling any method and it will print Hello Geeks!



```
// Java program to illustrate run time
// Run-time stack mechanism in
// normal flow of Exception handling

class Geeks {
	public static void main(String[] args)
	{
		fun();
	}

	public static void fun()
	{
		moreFun();
	}

	public static void moreFun()
	{
		System.out.println("Hello Geeks!");
	}
}
```


Destruction of the run-time stack: 
After printing Hello Geeks!, its corresponding entry will be removed from the stack and it will go to the fun() method and there is nothing for execution that’s why the entry of fun() method is removed from the stack and so on. 
When the stack is empty then the run-time stack is destroyed by the JVM.








