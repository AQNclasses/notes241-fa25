# Review

Functional definition of queue?

- FIFO: first in, first out

Functional definition of stack?

- LIFO: last in, first out

Look at Java Docs

Think-pair-share: how to implement a stack with two queues?

Think-pair-share: pros and cons of implementing with linked list instead of
array?

# Hash maps

AKA "dictionaries"

Key-value pairs: the **key** is *hashed* to find the location of the **value**.

What is hashing? (a mathematical function)

What properties should hash function have?

- map arbitrary sized input data to fixed-size representation (array index)
- example: integers + identity function
- example: integers + mod 10

Mathematically, hash maps implement a **set**.

What problems do we have to solve while implementing a hash function?

- collisions
- full table

how to solve?

# Pre-Quiz




## Go over "quiz" problem

```java
class MyInt {
    public int value;
    public int increment()
    {
        value = value + 1;
        return value;
    }
}

public class MyClass
{
    public static void main(String[] args)
    {
        MyInt x;
        MyInt y;
        x = new MyInt();
        x.value = 13;
        y = x.increment();
        System.out.println(x.value);
    }
}
```

```java
int x = 5;
int y = x;
y = 17; // what is x? (it's still 5)
```

- Reference semantics:

```java
int[] a1 = {4, 15, 8};
int[] a2 = a1;
a2[0] = 7; // what is the first element of a1? (it's 7 !!)
```

- Why reference semantics?
    - Efficiency
    - Memory Usage
    - Copying objects
- What to watch out for: 
    - modifying objects in functions in other classes
    - assuming pass-by-reference for primitive types


# Brief intro to runtime

Example: searching in linked list

O(n)

Example: travelling salesman

O(n!)

Example: matrix multiplication

O(n^3)

Bonus, show most recent work on improving this bound: divide and conquer, hashing methods

First improvement: divide and conquer, 1969. Algorithm still used today for matrices with n > 500

1990: O(n^2.3755)
2024: O(n^2.371552)

# Classes (Objects) and inheritance

either:
 - a program
 - a template for new types of objects

object is an "entity" that combines state and behavior

object-oriented program: programs that perform as interactions between objects. Keep state changes in well-defined objects

Classes contain:
 - fields: variable, part of object state. Each object has its own copy of each field.
   - access fields by *dereferencing* with the dot notation (ex: `s.length()`)
 - methods

```java
public type name(parameters) {
  statements;
}
```

Methods can be:

- accessor
- mutator

(point class example)
(how to access fields from inside same class)

## Inheritance

Formalizes hierarchies of how data is structured

```java
public class Animal {
  String name;
  int happiness;
  boolean newDay = true;
  
  public int getName() {
    return name;
  }
  
  public int getHappiness() {
    return happiness;
  }
  
  public void interact() {
    happiness = happiness + 1;
    newDay = false;
    
  public void sleep() {
    newDay = true;
  }
}
```

To create a *subclass* inheriting this *superclass*:

```java
public class Cow extends Animal {
  boolean milked = false;
  
  public void milk() {
    milked = true;
  }
  
  public void interact() {
    happiness = happiness + 2;
  }
  
  public void grumpy_interact() {
    super.interact();
  }
}
```

- Multiple levels of inheritance are allowed; multi-inheritance is not.
- Constructors are not inherited: if the super-class has a constructor defined, so must the sub-classes


## Exceptions

- Say we've implemented good data structures for queues and stacks. The programmer can still use the data structures in incorrect ways (ex: popping from empty stack).
- In this case, our data structure should "throw an error"
- Errors vs. exceptions
  - error usually cannot be managed inside the program. ex: JVM out of memory
  - exception examples: ClassNotFoundException, IOException, FileNotFoundException
- Two types of built-in exceptions: Checked and Unchecked
  - checked at compile-time vs not
  - if checked, the method containing the exception must either handle the exception or use the keyword `throws`
  - `public static void main(String[] args) throws IOException {...}`
  - unchecked example: divide by zero will compile but throw `ArithmeticException` when run
- Handle exceptions using `try` + `catch` blocks
- Can define custom extensions:

```java
public class StackException extends Exception {
...
}
```

Exception (the superclass) has two constructors:

```java
public Exception(String errorMessage) {...}
public Exception(String errorMessage, Throwable err) {...}
```



## Brief intro to runtime

Example: searching in linked list

O(n)

Example: travelling salesman

O(n!)

Example: matrix multiplication

O(n^3)

Bonus, show most recent work on improving this bound: divide and conquer, hashing methods

First improvement: divide and conquer, 1969. Algorithm still used today for matrices with n > 500

1990: O(n^2.3755)
2024: O(n^2.371552)

*galactic algorithms*


# More Hash Maps

How to fix **collisions**: when hash function maps two values to same index!?!?

```java
private int hash(int value) {
    return Math.abs(value) % hashtable.length;
}
```

- **Probing**: store exact value in array, resolve collision by moving to another index
  - linear probing: move to next available index (wrapping if needed).
  - quadratic probing: move increasingly far away (+1, +4, +9)
  - how to search?
    - use hash function to find index of value; if f(x) = 0, we know it's not there
    - if we find the value, we know it is there
    - if we find a *different* value, this space has already been filled by probing. Perform probe until we either find the value or find 0.
  - how to remove?
    - if we just set to zero, might break a probe sequence
      - if time: example, ten element array, add 54, then 14, then remove 54
      - use special value to signify "removed", skip this during "add" and "contains"
- **Separate chaining:** Solve collisions by storing a list at each index
  - trade multiple probes for traversing lists
  - impossible to "run out" of indices
  - have to check for duplicates in list before adding, and implement proper linked-list access


Problem: full table! how to solve?

- **Re-hashing**: moving data to larger array when our hash table is too full.
  - can't simply copy in-place to larger array; why not?
  - often use prime numbers as table size to reduce collisions

How to handle objects?

- all objects have built in `hashCode()` method (based on memory address)
