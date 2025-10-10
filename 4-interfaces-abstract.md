# Notes on Java implementations

Java has two powerful tools for describing class structures and managing
inheritance. The main reason is to promote code re-use.

## Abstract Methods and Classes

See here in docs: [https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)

Abstract classes cannot be instantiated, but they can be subclassed. They
essentially provide a partial implementation of a class, to be completed by
subclasses.

Abstract methods are declared without braces, like this:

```java
abstract void doStuff(double x, double y);
```

Abstract methods still require a return type declaration. If a class contains an
abstract method, it must be declared an abstract class.

Methods may still be declared public, protected or private. Fields in the class
do not need to be static.

## Interfaces

Interfaces are more like contracts; classes may implement any number of
interfaces. A class that implements an interface must implement the methods
declared in the interface. The methods in an interface are not fully implement,
just declared, similar to abstract methods.

For example, one interface included in Java is `Comparable`. The Comparable
interface contains one method, so the entire interface looks like

```java
public interface Comparable<T>{
    int compareTo(T obj);
}
```

The `<T>` symbol is a *type generic*, indicating that the method `compareTo` may
accept an object of any type. `compareTo` always returns an integer: negative,
zero, or positive if this object is less than, equal to, or greater than `obj`,
respectively.

To make an object comparable (and therefore amenable to built-in sorting
algorithms), the class definition must include `implements` and the name of the
interface. For example:

```java
class MyInt implements Comparable<MyInt> {
    public MyInt compareTo(MyInt a) {

    }
}
```
