# Lesson 4: Javadocs and Exceptions  
This lesson introduces two important skills that help you write clearer and more reliable programs:

- documenting methods using Javadocs  
- understanding and handling errors (exceptions)

These topics work well together: Javadocs describe how a method *should* be used, and exceptions indicate when something *went wrong*.

## Compile‑Time Errors

A compile‑time error happens **before** your program runs. It occurs during **compilation**, which is the step where Java translates your code into machine instructions.

In VS Code, compilation happens automatically when you press Run. If the compiler finds problems, the program will not start.

Typical compile‑time errors include:

### Syntax errors
```java
System.out.println("Hello")   // missing semicolon
```

### Type mismatches
```java
int x = "hello";   // cannot assign a String to an int
```

### Invalid return type
```java
private int add(int a, int b) {
    return "hi";   // must return an int
}
```

### Missing return
```java
private int getValue() {
    // no return here
}
```

Compile‑time errors are usually fixed by correcting syntax, fixing types, or completing missing logic.

## Runtime Errors

A runtime error (exception) happens **while the program is running**. The code compiles successfully, but something unexpected occurs.

Runtime errors are more common when:

- the program interacts with the user  
- input is unpredictable  
- the program accesses strings using indexes or arrays
- math operations involve special cases (e.g., dividing by zero)

Common runtime exceptions include:

### ArithmeticException
```
int n = 10 / 0;
```

### IndexOutOfBoundsException
```
String s = "ABC";
char c = s.charAt(5);   // index 5 does not exist
```

### NumberFormatException
```
int x = Integer.parseInt("abc");   // cannot convert
```

### IllegalArgumentException
```
private int sqrt(int x) {
    if (x < 0) {
        throw new IllegalArgumentException("negative number");
    }
    return x * x;
}
```

Why learn about exceptions?

- they help you **debug** more quickly  
- they tell you exactly **what went wrong**  
- understanding common exceptions helps you avoid them  

### Handling Runtime Errors with try/catch
You can also try to handle some of them in your program by using `try` and `catch`.

A `try` block allows you to run code that *might* cause an exception.  

A `catch` block lets you recover gracefully instead of crashing.

```java
public void run() {
    try {
        int n = readInt("Enter a number: ");
        System.out.println("You typed: " + n);
    } catch (Exception e) {
        System.out.println("Invalid input. Please enter a whole number.");
    }
}
```

- Code inside `try` executes normally  
- If an exception occurs, Java jumps to `catch`  
- The program keeps running instead of crashing

This is helpful with unpredictable user input.

<br>

# Javadocs and Method Documentation

When writing methods, it’s important that others — or future you! — can understand what they do. Javadocs are the official, structured format for documenting Java methods, classes, and libraries.

They serve two purposes:

1. They help humans understand your code.
2. Tools (like VS Code, IntelliJ, and Javadoc generators) can extract them to produce documentation pages.

Javadocs look something like this:

```java
/**
 * Prints a line containing the given number of stars.
 * @param length how many stars to print
 */
private void starLine(int length) {
    for (int i = 0; i < length; i++) {
        System.out.print("*");
    }
    System.out.println();
}
```

## What Are Javadocs?

Javadocs give programmers a consistent, structured way to document:

- what a method does  
- what each parameter means  
- what value is returned  
- what exceptions might occur  

Because the format is standardized, IDEs can display pop‑up documentation when a method is hovered or called.

In short, Javadocs are structured comments that describe how to use a method.

## When Should You Use Javadocs?

### Simple methods

If a method is small, obvious, and has no parameters or return values, a short single-line comment is fine:

```java
// Draws a simple tree shape
public void drawTree() {
    rect(200, 400, 30, 90);
    ellipse(215, 360, 100, 100);
}
```

### Methods with parameters or return values

These should **always** have Javadocs so users understand how to call them correctly:

```java
/**
 * Returns true if the number is even.
 * @param n the integer to check
 * @return true if n is even; false otherwise
 */
private boolean isEven(int n) {
    return n % 2 == 0;
}
```

### Methods with non-obvious logic

Document methods that have:

- loops  
- conditions  
- validation  
- potential exceptions  


## What Javadocs Contain

A Javadoc block typically includes:

- A summary sentence  
- One `@param` tag per parameter  
- One `@return` tag for return methods  
- Optional `@throws` for exceptions  

## Examples of Javadocs
Here are some examples of methods and corresponding Javadocs:

### No return value, one parameter
```java
/**
 * Prints a line containing the given number of stars.
 * @param length how many stars to print
 */
private void starLine(int length) {
    for (int i = 0; i < length; i++) {
        System.out.print("*");
    }
    System.out.println();
}
```

### Multiple parameters
```java
/**
 * Returns the larger of two integers.
 * @param a the first number
 * @param b the second number
 * @return the larger of a and b
 */
private int max(int a, int b) {
    return (a > b) ? a : b;
}
```

### More complex logic
```java
/**
 * Counts how many vowels appear in the given uppercase string.
 * @param word the string to examine; should be uppercase
 * @return the number of vowels (A, E, I, O, U)
 */
private int countVowels(String word) {
    int count = 0;
    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if ("AEIOU".indexOf(c) != -1) {
            count++;
        }
    }
    return count;
}
```

### Validation + IllegalArgumentException
```java
/**
 * Returns the square root of x as an integer approximation.
 * @param x the number to square root; must be non-negative
 * @return an integer representing the approximate square root
 * @throws IllegalArgumentException if x is negative
 */
private int safeSqrt(int x) {
    if (x < 0) {
        throw new IllegalArgumentException("x must be non-negative");
    }
    return (int) Math.sqrt(x);
}
```

### Making improvements
This example repeats the method name with no meaningful description. No mention of parameter or return values below:

```java
/**
 * Checks for even.
 */
private boolean isEven(int n) {
    return n % 2 == 0;
}
```

A much better version would look like this:
```java
/**
 * Determines whether the given integer is divisible by 2.
 * @param n the number to evaluate
 * @return true if n is an even number, false otherwise
 */
private boolean isEven(int n) {
    return n % 2 == 0;
}
```

## In Summary

Use single-line comments for:
- simple drawing helpers
- trivial one-liners
- methods with no parameters or return values that are obvious from their name

Use full Javadocs for:
- any method with parameters  
- any method with a return value  
- any method involving clear logic or validation  
- any method meant for reuse  


<br>

# Practice Problems

Complete the following exercises using today’s concepts.

## Problem 1 — Add Javadocs
Add proper Javadoc comments above each method.

```java
private int quadruple(int n) {
    return n * 4;
}

private boolean startsWithB(String word) {
    return word.startsWith("B");
}
```

## Problem 2 — Identify Error Type
Indicate whether each example is a compile‑time error or a runtime error.

```
1. int x = "hello";
2. int x = 10 / 0;
3. private int f() { }
4. String s = "ABC"; char c = s.charAt(10);
5. int n = Integer.parseInt("xyz");
```

## Problem 3 — Safe Division with Error Handling
Write a method that divides two integers and returns 0 if division by zero occurs.

```java
public void run() {
    System.out.println(safeDivide(10, 2));
    System.out.println(safeDivide(10, 0));
}

private int safeDivide(int a, int b) {
    // TODO
}
```

## Problem 4 — Repeated Safe Input
Write a method that keeps asking the user for an integer until they enter a valid one.

```java
public void run() {
    int value = readSafeInt("Enter a number: ");
    System.out.println(value);
}

private int readSafeInt(String prompt) {
    // TODO
}
```

## Problem 5 — Safe Character Access
Return a character at the given index, or `'?'` if the index is invalid.

```java
public void run() {
    System.out.println(safeChar("HELLO", 1));  // E
    System.out.println(safeChar("HELLO", 10)); // ?
}

private char safeChar(String word, int index) {
    // TODO
}
```

## Problem 6 — Add Javadocs to a Return Method
Write Javadocs and complete the method.

```java
private String repeat(String s, int times) {
    // TODO
}
```

## Problem 7 — Validate Input Using Exceptions
Return true only if the user enters a number between 1 and 10.

```java
private boolean isValidRange(int n) {
    // TODO
}
```

## Problem 8 — Detect NumberFormatException
Ask the user for a number as a string, convert it, and handle invalid cases.

```java
public void run() {
    String s = readLine("Enter a number: ");
    // TODO: convert safely
}
```

## Problem 9 — Document and Write a Method That Throws an Error
Throw an IllegalArgumentException if the radius is negative.

```java
private double areaOfCircle(double r) {
    // TODO
}
```

## Problem 10 — try/catch and Return Values
Return the integer entered by the user, or −1 if the input is invalid.

```java
private int safeReadInt() {
    // TODO
}
```

