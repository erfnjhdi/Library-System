package Other_classes;
import java.util.Scanner;
public class Journals extends Items{
	//Scanner made
	static Scanner input = new Scanner(System.in);
	//static idNumber attribute will be used as a counter to keep track of the number of objects and also used below to create Ids automatically.
	private static int idNumber;
	private int volumeNumber;
	//Default constructor, initializes all attributes to the 0 of their type as well incrementing the counter and generating an id. Super included since this is a subclass.
	public Journals() {
		super();
		idNumber++;
		generateID();
	}
	//Parametized constructor to set values for all attributes as well incrementing the counter and generating an id. Super included since this is a subclass.
	public Journals(String name, String author, int year, int volume) {
		super(name, author, year);
		idNumber++;
		this.volumeNumber = volume;
		generateID();
	}
	//Copy constructor used to create a copy of an object with the same attributes except the id as well incrementing the counter and generating an id. Super included since this is a subclass.
	public Journals(Journals other) {
		super(other);
		idNumber++;
		this.volumeNumber = other.volumeNumber;
		generateID();
	}
	//Accessor for private attribute
	public int getVolumeNumber() {
		return this.volumeNumber;
	}
	//Mutator for private attribute
	public void setVolumeNumber(int volume) {
		this.volumeNumber = volume;
	}
	//toString method displays all information of the object.
	public String toString() {
		return String.format("Information of the journal:\nID: %s\nName: %s\nAuthor: %s\nPublication year: %d\nVolume Number: %d\n",
                ID, name, author, publicationYear, volumeNumber);
	}
	/*
	 * equals method compares a Journals object to another object, if the parameter object is null or of a different type it will return false, 
	 * also false if they are the same type but dont have the same attributes(except id). returns true if both objects are of the same type and have the same
	 * attributes(except ID).
	 */
    public boolean equals(Object other) {
        // Check if the passed object is null or of a different type
        if (other == null || getClass() != other.getClass()) {
            return false;
        } else {
            // Typecast the object to Journals
            Journals otherJournal = (Journals) other;

            // Compare all attributes except ID
            return this.getName().equals(otherJournal.getName()) &&
                    this.getAuthor().equals(otherJournal.getAuthor()) &&
                    this.getPublicationYear() == otherJournal.getPublicationYear() &&
                    this.getVolumeNumber() == otherJournal.getVolumeNumber();
        }
    }
  //this method sets the ID attribute to J + the counter to create a unique ID for each object. It is included in all constructors.
	protected void generateID() {
		this.ID = "J" + idNumber;
	}
	//This method is used if the user wants to add a journal item to an items array, it takes in an items array and add a new object to it based on user input
	public static void addJournal(Items[] inventory) {
		System.out.print("Enter the journal's name: ");
		String journalName = input.nextLine();
		System.out.print("Enter the journal's author: ");
		String journalAuthor = input.nextLine();
		System.out.print("Enter the journal's year of publication: ");
		int journalYear = input.nextInt();
		System.out.print("Enter the journal's volume number: ");
		int journalVolume = input.nextInt();
		input.nextLine();
		inventory[itemCounter] = new Journals(journalName, journalAuthor, journalYear, journalVolume);
	}
}
