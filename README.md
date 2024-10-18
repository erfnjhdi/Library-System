# Library-System
Overview
The Library System is a Java-based application designed to manage the inventory and client interactions for a library that handles various items, including books, journals, and media. The system allows library employees to add, edit, and remove items, lease items to clients, and manage item returns. It is built with object-oriented principles such as inheritance, polymorphism, and encapsulation.

Features
The system enables the library staff to:

Manage Library Items: Add, delete, or edit the information for books, journals, and media (such as DVDs). Each item has a unique ID, and specific properties based on its type (e.g., a book has a number of pages, a journal has a volume number, and media can be audio, video, or interactive).
Manage Clients: Add, edit, or delete clients. Each client has a unique ID, name, phone number, and email address.
Lease and Return Items: Lease items to clients and record their return.
Display Information: Show all items in a specific category (books, journals, or media), list all leased items, and display the biggest book (the one with the most pages).
Deep Copy: Create a deep copy of the books array to ensure data integrity.
UML Design: The project adheres to UML (Unified Modeling Language) principles, with a well-defined hierarchy of classes representing the items and clients in the system.
Classes and Structure
The system is organized into multiple Java packages:

Clients: Contains the Client class to manage client information.
Driver: The Driver class contains the main() method, which controls the program's execution.
Other Classes: Contains classes representing library items (Books, Journals, Medias, Lease, and Items) with specific attributes for each item type.
Each class has:

A default constructor, a parameterized constructor, and a copy constructor.
Accessors and mutators (getters and setters) for all attributes.
An equals() method to compare objects based on their attributes (excluding IDs).
A toString() method to display clear descriptions of the objects.
Program Flow
Users can choose between:

Menu-driven mode: Allows the user to interactively perform operations like adding, editing, deleting items and clients, leasing items, and viewing reports.
Pre-defined scenario: The program creates a set of items and clients, tests object equality, and demonstrates the functionalities automatically.
Skills Gained
Through this project, I developed and strengthened the following skills:

Object-Oriented Programming: Applied OOP principles such as inheritance, polymorphism, encapsulation, and information hiding to create a well-structured program.
UML Design: Developed a UML diagram to accurately represent the relationships between different classes in the system.
Java Programming: Gained proficiency in Java by implementing custom classes without the use of built-in Java collections such as ArrayList or HashMap.
Problem Solving: Implemented and tested a variety of functionalities, such as finding the largest book and creating deep copies of arrays.
Code Quality and Best Practices: Followed good coding practices, including meaningful variable names, proper indentation, and clear comments throughout the codebase.
