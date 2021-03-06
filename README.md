# Java SE 11 Developer

## Table of Contents
1. [Java Basics](#Java-Basics)
    - [Understanding the Java class structure](#Understanding-the-Java-class-structure)
        - [Fields and Methods](#Fields-and-Methods)
        - [Comments](#Comments)
        - [Classes vs Files](#Classes-vs-Files)
    - [Our first program](#Our-first-program)    
        - [Writing a Main method](#Writing-a-Main-method)
        - [Compile and execute code](#Compile-and-execute-code)
    - [Package Declarations and Imports](#Package-Declarations-and-Imports)
        - [Wildcards](#Wildcards)
        - [Redundant Imports](#Redundant-Imports)
        - [Naming Conflicts](#Naming-Conflicts)
2. [Working with Java Data Types](#Working-with-Java-Data-Types)

</br>

## Java Basics
</br>

In Java programs, <b>classes are the basic building blocks</b>. When defining a `class`, you describe all the parts and characteristics of one of those building blocks.</br></br>

### Understanding the Java class structure
</br>

The simplest Java class you can write looks like this:</br>

<sub>Animal.java</sub>

```java
public class Animal {}                  
```
</br>

Java calls a word with special meaning a <b>keyword</b>. 

- The `public` keyword means that the class can be used by other classes.
- The `class` keyword indicates you're defining a class, in our case a class called `Animal`. 

In the following section, we'll look at <b>fields</b>, <b>methods</b> and <b>comments</b>.</br></br>

#### Fields and Methods
</br>

Java classes have to primary elements: <b>fields</b>, more generally known as <b>variables</b>, and <b>methods</b>. 
- <b>Variables</b> hold the state of the program.
- <b>Methods</b> operate on that state. 

Together these are called the <b>members of the class</b>. 

At the moment class <b>Animal</b> isn't a very interesting class, so we can add our first <b>field</b>.</br>

<sub>Animal.java</sub>

```java
public class Animal {                   
    
    String name;                        

}
```
</br>

We define a <b>variable</b> named `name` and also define the type of that variable to be a `String`. Now we can add methods.</br>

<sub>Animal.java</sub>

```java
public class Animal {                   
    
    String name;                        

    public String getName() {           
        return this.name;
    }

}
```
</br>

We defined our first method. A method basically is an operation that can be called. In our case, we define a method called `getName` that return the value of `name` field. 

- Again, `public` is used to specify that this method may be called from other classes. 
- Next comes the return type, in our case, the method return a `String` object.
- Finally `getName` is the name of the method. 

Let's see another example.</br>
<sub>Animal.java</sub>

```java
public class Animal {                       
    
    String name;                            

    public String getName() {               
        return this.name;
    }

    public void setName(String newName) {   
        this.name = newName
    }

}
```
</br>

We define another method. 

- Again `public` signify that this method may be called from other classes. 
- This one has a special return type called `void`. `void` means that when we call the `setName` method no vaule is returned. 
- This method requires information be supplied to it from the calling method. This information is called a `parameter`, in this case `setName` method has one `parameter` named `newName`, and it is of type `String`. 

The full declaration of a method is called a <b>method signature</b>. In the last example, we define a method that the caller should pass in on `String` parameter and expect nothing to be returned.</br></br>


#### Comments
</br>

Another common part of the code is called a <b>comment</b>. <b>Comments</b> aren't executable code, but make your code easier to read. There are three types of <b>comments</b> in Java: <b>single-line</b>, <b>multiple-line</b> and <b>Javadoc</b>. Let's start with the first type, the <b>single-line</b> comment.</br>

```java
// Single-line comment until the end of the line.
```
</br>

A <b>single-line</b> comment begin with two slashes `//`. Anything you type after that on the same line is ignored by the compiler. Next comes the multiple-line comment:</br>

```java
/*
 * Multiple-line comment.
 */ 
```
</br>

A <b>multiple-line</b> comment includes anything starting from `/*` until the symbol `*/`. Finally, we have a <b>Javadoc</b> comment.</br>

```java
/**
 *  Javadoc multiple line comment.
 *  @author Guillem Casas  
**/
```
</br>

This comment is similar to a multiple-line comments except it use `/**` and `**/`. This special syntax tells the Javadoc tool to pay attention to the comment for generate documentation of the project.</br></br>

#### Classes vs Files
</br>

Most of the time, each Java class is defined in its own `.java` file. It is usually `public`, which means any code can call it. Java does not require that the class be `public`. For example this class is just fine:

<sub>Animal.java</sub>

```java 
class Animal {
    String name;
}
```
</br>

You can even put two classes in the same file. <b>When you do so, at most one of the classes in the file is allowed to be public</b>. A file containing the following is also fine:

<sub>Animal.java</sub>

```java 
public class Animal {
    String name;
}

class Animal2 {}
```
</br>

If you do have a `public class`, <b>it needs to match the filename</b>. For example, the following example would not compile in a file named `Animal.java`.

<sub>Animal.java</sub>

```java 
class Animal {
    String name;
}

public class Animal2 {}
```
</br>

If we try to compile this example, we will see an error like this:</br>

<sub>Terminal</sub>

```console 
Animal.java:5: error: class Animal2 is public, should be declared in a file named Animal2.java
```
</br>

### Our first program
</br>

At this point, we have seen how structure a basic class and how define fields and methods. Now, we'll learn how execute a simple Java program.</br></br>

#### Writing a Main method
</br>

A Java program begins execution with the <b>main</b> method. A <b>main</b> method is the gateway between the startup of a Java process, which is managed by the <b>Java Virtual Machine (JVM)</b>. The simpliest possible class with a <b>main</b> method looks like this:</br></br>

<sub>Zoo.java</sub>

```java 
public class Zoo {

    public static void main(String[] args) {
        
    }

}
```
</br>

Naturaly, `public` means any place in the program. The keyword `static` binds a method to its class so it can be called by just the class name, as in, for example, `Zoo.main()`. With the use of static, Java does not need to create an object to call the `main` method.

This code doesn't do anything useful. It has no instruction other than to declare the entry point. In fact, the only reason we even need a class structure to start Java program is because the language requires it. In the following section, we'll look at how to <b>compile</b> and <b>execute</b> a Java program.

#### Compile and execute code
</br>

To compile Java code, we use the `javac` command. This command needs to be followed by the file we want to compile and this file must have the extension `.java`. The result is a file of `bytecode` by the same name, but with a `.class` filename extension. Let see an example:</br></br>


<sub>Terminal</sub>

```bash
javac Zoo.java
```
</br>

`javac` command allow us to compile `.java` file. If you don't get any error messages, file is compiled and `bytecode` generated. So, we must have two files `Zoo.java` and `Zoo.class`. 

Now, we can execute the generated file using `java` command.</br></br>

<sub>Terminal</sub>

```bash
java Zoo
```
</br>

Once this instruction is executed, we see nothing. This is because for now the app does nothing. Suppose we add the following instruction to our `Zoo.java` class.</br></br>

<sub>Zoo.java</sub>

```java
public class Zoo {

    public static void main(String[] args) {
        System.out.println("Welcome to the Zoo!");
    }

}
```
</br>

If we recompile and run the application we should see the following message.</br></br>

```bash
Welcome to the Zoo!
```
</br>


### Package Declarations and Imports
</br>

#### Wildcards
</br>

#### Redundant Imports
</br>

#### Naming Conflicts
</br>

## Working with Java Data Types
</br>
