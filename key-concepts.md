# Concepts in Object-Oriented Programming (OOP) for Java

- **Class**
 
  Implementation (like a blueprint or a template) for creating attributes and behaviors of an object.  
  ```java
  public class Book {
      //attribute fields
      //constructor
      //behaviors
  }
  
- **Object**

  A specific instance of a class. (If a library needs to add a new book, then a single book it creates is an **object**).

  ```java
  Book myBook = new Book();
  ```

- **Attributes**

  Attributes are found in variables that hold data for each instance of a class.

  ```java
  private int id;
  private String title;
  private float price;
  private boolean checkedOut;
  ```

- **Behaviors**

  Behaviors are what instances of a class can *do*, found in methods.

  ```java
  public void checkOutBook(int id) {
      checkedOut = true;
      System.out.println("Book is checked out);
  }
  ```

- **Constructor**

  A special method used to create and initialize a new object with default attributes.

  ```java
  public Book(String title, String author) {
      this.title = title;
      this.author = author;
  }
  ```
- **Method**

  A named set of instructions to perform a task

  ```java
  public checkOutBook(int id) {
  //behavior of method
  }
  ```

- **Class Header**

  The first line of a class that defines its name, access modifier, and optionally its superclass or interfaces.

  ```java
  public class Library { }
  ```

- **Separation of Concerns**

  Keeping different parts of a program focused on their own tasks, so code is easier to manage.

  ```java
  public class Main { } //only concerned with running the program and testing
  public class Library { } //only concerned with creating library objects
  public class Book { } //only concerned with creating book objets
  ```

- **Package**

  A way to group related classes together.

  ```java
  package com.thelibraryproject.libraryapp;
  ```

- **Encapsulation**

  Hiding details inside a class and only showing what is necessary. Protects the object from interference and controls access to the data.

  ```java
  private String title; // private attribute
  public String getTitle() { return title; } // public getter
  ```

- **Parameter**

  Defines the type of value to receive when a method or constructor is called.

  ```java
  public void setTitle(String newTitle) { this.title = newTitle; }
  ```

- **Argument**

  The specific value provided when a method or constructor is called.

  ```java
  myBook.setTitle("1984"); // "1984" is the argument
  ```

- **Dot Operator**
  The dot between a variable and a method. Used to call a method in a class.

  ```java
  myBook.getAuthor(); 
  ```

- **Logic Error**

  Occurs when a program runs without crashing, but behaves in an incorrect or unexpected way. Human error.

  ```java
  int average = (10 + 20) / 3; // incorrect calculation
  ```

- **Inheritance**

  OOP principle where a subclass inherits the attributes and behaviors of a superclass.

  ```java
  public class Dog extends Pet { }
  ```

- **Superclass**

  A class that can be extended to create subclasses.

  ```java
  public class Pet { }
  ```

- **Subclass**

  A class that inherits attributes and behaviors of a superclass. It `extends` from a superclass.

  ```java
  public class Cat extends Pet { }
  ```

- **Tester Class**

  The class that contains the `main` method -- often Main.java -- the entry point of any Java program.

  ```java
  public class Main {
      public static void main(String[] args) {
          Book myBook = new Book();
          myBook.checkOut(32452, "Catch-22")
      }
  }
  ```

- **Method Signature**

  Consists of a method's name and its parameter list.

  ```java
  setTitle(int id, String title)
  ```

- **String Literal**

  A sequence of characters enclosed in quotation marks (`" "`).

  ```java
  String title = "The Great Gatsby";
  ```

- **Return**

  To exit a method and `return` to the point in the program that called it. Often providing a value.

  ```java
  public String getTitle() {
      return title;
  }
  ```

- **Return Type**

  The type of value returned by a method before it completes its execution and exits.

  ```java
  public String getTitle() { return title; } // return type = String
  ```

- **Void**

  Specifies that a method does not return a value.

  ```java
  public void printTitle() {
      System.out.println(title);
  }
  ```
  


  

<small>Definitions edited by M Harrell, sourced from AP CS A, code.org, and McGraw Hill. Examples by M Harrell</small>
