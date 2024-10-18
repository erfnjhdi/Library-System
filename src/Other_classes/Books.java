package Other_classes;
import java.util.Scanner;
public class Books extends Items{
	//Scanner made
	static Scanner input = new Scanner(System.in);
	//static idNumber attribute will be used as a counter to keep track of the number of objects and also used below to create Ids automatically.
	private static int idNumber;
	private int numberOfPages;
	//Default constructor, initializes all attributes to the 0 of their type as well incrementing the counter and generating an id. Super included since this is a subclass.
	public Books() {
		super();
		idNumber++;
		generateID();
	};
	//Parametized constructor to set values for all attributes as well incrementing the counter and generating an id. Super included since this is a subclass.
	public Books(String name, String author, int year, int pages) {
		super(name, author, year);
		++idNumber;
		this.numberOfPages = pages;
		generateID();
	}
	//Copy constructor used to create a copy of an object with the same attributes except the id as well incrementing the counter and generating an id. Super included since this is a subclass.
	public Books(Books other) {
		super(other);
		idNumber++;
		this.numberOfPages = other.numberOfPages;
		generateID();
	}
	//Accessor for private attribute
	public int getNumberOfPages() {
		return this.numberOfPages;
	}
	//Mutator for private attribute
	public void setNumberOfPages(int number) {
		this.numberOfPages = number;
	}
	//toString method displays all information of the object.
	public String toString() {
		return String.format("Information of the book:\nID: %s\nName: %s\nAuthor: %s\nPublication year: %d\nNumber of pages: %d\n",
                ID, name, author, publicationYear, numberOfPages);
	}
	/*
	 * equals method compares a Books object to another object, if the parameter object is null or of a different type it will return false, 
	 * also false if they are the same type but dont have the same attributes(except id). returns true if both objects are of the same type and have the same
	 * attributes(except ID).
	 */
	public boolean equals(Object other) {
        // Check if the passed object is null or of a different type
        if (other == null || getClass() != other.getClass()) {
            return false;
        } else {
            // Typecast the object to Books
            Books otherBook = (Books) other;

            // Compare all attributes except ID
            return this.getName().equals(otherBook.getName()) &&
                    this.getAuthor().equals(otherBook.getAuthor()) &&
                    this.getPublicationYear() == otherBook.getPublicationYear() &&
                    this.getNumberOfPages() == otherBook.getNumberOfPages();
        }
    }
	//this method sets the ID attribute to B + the counter to create a unique ID for each object. It is included in all constructors.
	protected void generateID() {
		this.ID = "B" + idNumber;
	}
	//This method is used if the user wants to add a book item to an items array, it takes in an items array and add a new object to it based on user input
	public static void addBook(Items[] inventory) {
		System.out.print("Enter the book's name: ");
		String bookName = input.nextLine();
		System.out.print("Enter the book's Author: ");
		String bookAuthor = input.nextLine();
		System.out.print("Enter the book's Year of publication: ");
		int bookYear = input.nextInt();
		System.out.print("Enter the book's number of pages: ");
		int bookPages = input.nextInt();
		input.nextLine();
		inventory[itemCounter] = new Books(bookName, bookAuthor, bookYear, bookPages);
	} 
}
