# Concepts in Object-Oriented Programming

- **Class**  
  Implementation (like a blueprint or a factory) of attributes and behaviors of an object.

- **Object**  
  A specific instance of a class. (If a factory makes boots, then a single pair of boots it produced is an **object**).

- **Attributes**  
  Data related to an instance of a class. Stored in variables.

- **Behaviors**  
  What instances of a class can *do*. Found in methods.

- **Constructor**  
  A special method used to create and initialize a new object with default attributes.

- **Separation of Concerns**  
  Keeping different parts of a program focused on their own tasks, so code is easier to manage. (If you owned a veterinary, you'd separate classes for Pets, Dogs, Cats, Customers, etc).

- **Package**  
  A way to group related classes together. Similar to a folder for your project. Classes are linked with the `package` command.

- **Encapsulation**  
  Hiding details inside a class and only showing what is necessary, usually with `private` and `public`.

- **Parameter**  
  Defines the type of value to receive when a method or constructor is called.

- **Argument**  
  The specific value provided when a method or constructor is called.

- **Logic Error**  
  Occurs when a program runs without crashing, but behaves in an incorrect or unexpected way. Typically an error on the part of the programmer, not the program. 

- **String Literal**  
  A sequence of characters enclosed in quotation marks (`" "`).

- **Inheritance**  
  OOP principle where a subclass inherits the attributes and behaviors of a superclass. (A class `Dog` inherits attributes and behaviors of the class above it, `Pets`)

- **Subclass**  
  A class that extends a superclass and inherits its attributes and behaviors. (The classes `Dog` and `Cat` are subclasses of `Pets`)

- **Superclass**  
  A class that can be extended to create subclasses. (The superclass `Pets` contins the subclasses `Dog` and `Cat`)

- **Tester Class**  
  The class that contains the `main` method -- the entry point of a Java program. (A `PetTester` class doesn't definte a `Pet` -- it only builds pet objects and tests to make sure they're working correctly).
