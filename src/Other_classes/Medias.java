package Other_classes;
import java.util.Scanner;
public class Medias extends Items{
	//Scanner made
	static Scanner input = new Scanner(System.in);
	//static idNumber attribute will be used as a counter to keep track of the number of objects and also used below to create Ids automatically.
	private static int idNumber;
	private String type;
	//Default constructor, initializes all attributes to the 0 of their type as well incrementing the counter and generating an id. Super included since this is a subclass.
	public Medias() {
		super();
		idNumber++;
		generateID();
	}
	//Parametized constructor to set values for all attributes as well incrementing the counter and generating an id. Super included since this is a subclass.
	public Medias(String name, String author, int year, String type) {
		super(name, author, year);
		idNumber++;
		this.type = type;
		generateID();
	}
	//Copy constructor used to create a copy of an object with the same attributes except the id as well incrementing the counter and generating an id. Super included since this is a subclass.
	public Medias(Medias other) {
		super(other);
		this.type = other.type;
		idNumber++;
		generateID();
	}
	//Accessor for private attribute
	public String getType() {
		return this.type;
	}
	//Mutator for private attribute
	public void setType(String type) {
		this.type = type;
	}
	//toString method displays all information of the object.
	public String toString() {
		return String.format("Information of the media:\nID: %s\nName: %s\nAuthor: %s\nPublication year: %d\nType of media: %s\n",
                ID, name, author, publicationYear, type);
	}
	/*
	 * equals method compares a Medias object to another object, if the parameter object is null or of a different type it will return false, 
	 * also false if they are the same type but dont have the same attributes(except id). returns true if both objects are of the same type and have the same
	 * attributes(except ID).
	 */
    public boolean equals(Object other) {
        // Check if the passed object is null or of a different type
        if (other == null || getClass() != other.getClass()) {
            return false;
        } else {
            // Typecast the object to Medias
            Medias otherMedia = (Medias) other;

            // Compare all attributes except ID
            return this.getName().equals(otherMedia.getName()) &&
                    this.getAuthor().equals(otherMedia.getAuthor()) &&
                    this.getPublicationYear() == otherMedia.getPublicationYear() &&
                    this.getType().equals(otherMedia.getType());
        }
    }
  //this method sets the ID attribute to M + the counter to create a unique ID for each object. It is included in all constructors.
	protected void generateID() {
		this.ID = "M" + idNumber;
	}
	//This method is used if the user wants to add a media item to an items array, it takes in an items array and add a new object to it based on user input
	public static void addMedia(Items[] inventory) {
		System.out.print("Enter the medias's name: ");
		String mediaName = input.nextLine();
		System.out.print("Enter the medias's author: ");
		String mediaAuthor = input.nextLine();
		System.out.print("Enter the medias's year of publication: ");
		int mediaYear = input.nextInt();
		System.out.print("Enter the medias's type: ");
		String mediaType = input.next();
		input.nextLine();
		inventory[itemCounter] = new Medias(mediaName, mediaAuthor, mediaYear, mediaType);
	}
}
