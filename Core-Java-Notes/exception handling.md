

#runtime stack trace mechanism


-   Each and every call performed in a thread is stored in the stack.
-   Each entry in the run-time stack is known as an activation record or stack frame.
-   Each entry in the run-time stack is known as an activation record or stack frame.

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








