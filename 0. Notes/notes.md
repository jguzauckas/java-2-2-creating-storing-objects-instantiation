- Signatures
- Parameters
- Overloading
- Call by Value
- `new` Keyword
- `null` Keyword

# Creating and Storing Objects (Instantiation)

With the basic concept of a class as a blueprint/framework/mold down, we will be learning how to use existing classes to create objects. To do that, we first have to explore more about how a specific piece of classes are written, called **constructors**. Constructors are the instructions on how to build an object based on the class, while the other pieces of a class describe how to use an object once it's been created. For our reference, here is the `Person.java` file that outlines a basic blueprint for a `Person`:

```java
public class Person {
    private int age;
    private boolean isStudent;

    public Person(){
        age = 0;
        isStudent = false;
    }

    public Person(int a){
        age = a;
        isStudent = false;
    }

    public Person(boolean s){
        age = 0;
        isStudent = s;
    }

    public Person(int a, boolean s){
        age = a;
        isStudent = s;
    }
}
```

Going back to our vocabulary from section 1, this class only has variables and constructors, and does not have any methods. The two variables are the `int`-type `age` and the `boolean`-type `isStudent`. This class actually has 4 constructors (each of the lines that starts with `public Person(` is the beginning of a constructor), but each of them are slightly different. Before we discuss why and how they can be different, we first need to understand the idea of a **parameter**

---

## Parameters and Parameter Lists

Oftentimes constructors will ask for specific information to be given to them, or **passed** to them in order for them to do their jobs. These pieces of information are called **parameters**. Here is one of the constructors from the `Person.java` file:

```java
public Person(int a){
    age = a;
    isStudent = false;
}
```

In the first line of the constructor, `int a` represents a **formal parameter**. This tells us two pieces of information, first in the form of the type of information expected, which is an `int`. If you provide the constructor with the wrong type of information for its parameter, this will produce an error. The second piece of information is how the parameter is referred to *within* the constructor, as we can see on the next line where our official `age` variable is assigned whatever the value of `a` is. It is important to note that when creating an object, you don't have to refer to the value as `a`, once a parameter is passed in, the value is copied over to `a` for use internally, and you never have to worry about it. This idea of copying the passed value to be used is referred to as **call by value**.

The information after `public Person` inside the parentheses is referred to as the **parameter list**, as some constructors, like the last one in the `Person.java` file can have more than one parameter, where they are separated by commas:

```java
public Person(int a, boolean s){
    age = a;
    isStudent = s;
}
```

This constructor has two parameters, an `int`-type called `a`, and a `boolean`-type called `s`. It is also possible, like the first constructor in `Person.java`, for a parameter list to be empty:

```java
public Person(){
    age = 0;
    isStudent = false;
}
```

Anytime we have a constructor without any parameters, we refer to it as the **default constructor**, as it is the *default* instructions when nothing is known about an object.

---

## Constructor Signatures

Just like real human signatures are unique, so too are **constructor signatures**. A constructor signature is made up of the constructor name and its parameter list. For our purposes, all constructors in a class have to have the same name (in our example above, it is `Person`), which means the things that differentiates each constructor is their parameter lists.

In Java, the uniqueness of a parameter list is only based on the parameter types, and not the names. Let's say we had two parameter lists that each just had an `int` type, but one was called `a` and the other was called `b`, so the constructors looked like `public Person(int a){}` and `public Person(int b){}`. These constructors are not considered unique from each other, as they both only take in a single `int`, which the computer would have no way of knowing is supposed to function as `a` or `b`.

Pulling a summary from our `Person.java` file, we have 4 unique constructor signatures:

```java
public Person(){}
public Person(int a){}
public Person(boolean s){}
public Person(int a, boolean s){}
```

They are made different by their parameter lists, resulting in 4 possible ways to create a `Person` object with varying amounts of information, from nothing to everything. Not every class will have a constructor for every situation, but it will be important to be able to look at the constructors and decide which of them best fits the information you have.

---

## Constructor Overloading

When constructors share the same name, but have different signatures (read: different parameter lists), we refer to them as **overloaded**. This has a broader definition in Java beyond constructors, but suffice to say, two or more things that have the same name but different signatures being overloaded means that Java has to sort out which one to use, not based on the name as those are the same, but based on the parameter lists. This means that Java will check the types (and the order they are listed) in the parameter list being passed in to determine which constructor it matches and will use.

---

## Creating an Object

With a class like `Person` created, we can go into another Java file and now create a `Person` object to use. A keyword is needed to tell Java to call the constructor for a class: the `new` keyword. This will precede a constructor to let Java know to treat it as a constructor to build a new object. Here is the most basic example with our `Person` default constructor (remember: that means no parameters!) from the `CreateNotes1.java` file:

```java
new Person();
```

This creates a `Person` object to be used, however it does not save that object for later use. This means that just like working with our primitive types, we need to store information in a variable in order to access it later. We know from our work with primitive types that variables have to have a type, and that type for objects will be based on the class the object is coming from. Since these examples are from the `Person` class, the variables will be of the `Person` type. Variable declaration works the same as before, with writing the type and then the name, then we can initialize by assigning our constructor as we had above. Here is an example from the `CreateNotes2.java` file:

```java
Person person1 = new Person();
```

This does the same thing as our first example, but now it stores that information in the `person1` variable so we can access it later. It is important to note that a variable that stores an object in Java is called a **reference** variable. When we worked with primitive types, we made a note of how it stores the information. For example, an `int` variable has 32 bits to store information, where 1 bit is for the sign and the other 31 bits are for the value. A referential data type like an object instead stores an object somewhere else in memory, where more can be assigned as needed, and stores the location (or *reference*) of the object's information in memory to the variable. This way the variable can stay the same size even if the object gets larger, and can just keep track of where to go look for the object's information. This is a fairly minute detail with our basic example, but will be more important throughout the year. We can see this in action if we try to print out the `person1` variable from `CreateNotes2.java`, where we get the following result:

```
Person@2f92e0f4
```

This tells us that it is keeping track of a `Person` object at the memory location `2f92e0f4`. All referential variables will print the memory location instead of the actual object values when asked to print.

Now that we can create an object and store it in a variable using a default constructor, let's do it with a constructor that takes in information. We can do this by writing the literal value in the constructor, or we can pass a variable of the right type into the constructor for it to copy the value from. This example from `CreateNotes3.java` shows both methods:

```java
Person person1 = new Person(25);

int tempAge = 25;
Person person2 = new Person(tempAge);
```

Both of these constructor calls have the same result, creating a `Person` object that has an `age` value of `25`. A final important note is that we can reassign object variables just like primitive variables. Here is an example where we store one object in a variable and then replace it with another assignment from the `CreateNotes4.java` file:

```java
Person person1 = new Person(16, true);
person1 = new Person(25, false);
```

From our external perspective this code doesn't do anything unique and behaves exactly like when we did this with primitive types. Unlike primitive types though, this does not actually erase the first `Person` object with `age` `16` and `isStudent` `true`. Since the variable is referential, it just changes where in memory it is looking to see the new `Person` object with `age` `25` and `isStudent` `false`. The old object is left behind in memory, and is as good as lost to us, but takes up memory while the program is running. We can see the change in memory address when we print each time:

```
Person@2f92e0f4
Person@28a418fc
```

We can see it's still storing a `Person` object, but the memory location has changed to point to a different object.

---

## The `null` Keyword

In previous examples, when we created a referential variable, we assigned it a reference by creating an object for it to keep track of in memory. It is possible though, to just declare a referential variable, but just providing the type and name, but not assigning an object yet. Unlike primitive types though, we need to assign it the `null` value to prevent any errors from occurring. Here is what it looks like from the `NullNotes1.java` file:

```java
Person person1 = null;
```

When this happens, a value is assigned to the variable by Java: the `null` value. The `null` value is a special value that is used to indicate that a reference is not associated with any object. If we were to print this referential variable, it would tell us about it being `null` instead of a proper memory location:

```
null
```

While we rarely do this, you can initially assign a reference variable as `null` and then later reassign it an object to keep track of, just like we reassigned values above. Here is an example from `NullNotes2.java`:

```java
Person person1 = null;
person1 = new Person();
```

When we print out each step of this, we see the allocation change from null to a memory location:

```
null
Person@2f92e0f4
```

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
