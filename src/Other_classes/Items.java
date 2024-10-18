package Other_classes;
import java.util.Scanner;
public abstract class Items {
	//Scanner made
	static Scanner input = new Scanner(System.in);
	//used to add items to an array of Items in subclasses, incremented in all constructors in this class
	protected static int itemCounter;
	//All attributes for the items
	protected String ID;
	protected String name;
	protected String author;
	protected int publicationYear;
	//default constructor
	public Items() {
		itemCounter++;
	};
	//parametized constructor
	public Items(String name, String author, int year) {
		this.name = name;
		this.author = author;
		this.publicationYear = year;
		itemCounter++;
	}
	//copy constructor
	public Items(Items other) {
		this.name = other.name;
		this.author = other.author;
		this.publicationYear = other.publicationYear;
		itemCounter++;
	}
	//Accessors for all item attributes
	public String getId() {
		return this.ID;
	}
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public int getPublicationYear() {
		return this.publicationYear;
	}
	//Mutators for all attributes besides the id since it is automatic.
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPublicationYear(int year) {
		this.publicationYear = year;
	}
	//abstract toString method to be used by all subclasse objects to display their information
	public abstract String toString();
	//abstract equals method to be used by all subclass objects to compare their attributes to other objects.
	public abstract boolean equals(Object other);
	//this abstract method is used in all subclasses to create a custom id
	protected abstract void generateID();
	//this method asks the user to input an item id and will then use that id to find it in an array of items and remove it by setting it to null.
	public static boolean deleteItem(Items[] items) {
		//get item id from user and store it
		System.out.print("Enter the ID of the item you wish to delete: ");
		String IdToDelete = input.next();
        // this variable will be used to set the element to null
        int indexToDelete = -1;
        for (int i = 0; i < items.length; i++) {
        	//checks if a none-null element has the same id
            if (items[i] != null && items[i].getId().equals(IdToDelete)) {
            	//variable set to i
                indexToDelete = i;
                break;
            }
        }
        // if the variable is not -1 anymore meaning its i because that's the only other option:
        if (indexToDelete != -1) {
        	//shift array elements
            for (int i = indexToDelete; i < items.length - 1; i++) {
                items[i] = items[i + 1];
            }
            //set the one with the id to null
            items[items.length - 1] = null;
            System.out.println("\nItem with ID " + IdToDelete + " found and successfully deleted.");
            return true;
        }
        //if id not found print this
        else {
            System.out.println("Item with ID " + IdToDelete + " not found. Try again.");
            return false;
        }
    }
	//this method goes through an array of items to search for a variable with a specific id.
	public static Items findItemById(String id, Items[] arr) {
        for (Items item : arr) {
        	//if the item in the array is not null and the ids match return that item.
            if (item != null && item.getId().equals(id)) {
                return item;
            }
        }
        //Item not found:
        System.out.print("No such item found");
        return null;
	}
	//This method will take an id and an items array and go through each item to find the one with the matching id and then ask the user for new info and update the object accordingly
	public static boolean updateItem(String id, Items[] inventory) {
	    for (Items item : inventory) {
	        // If the item in the array is non-null and the IDs match, ask the user for info and update, does not include subclass specific instances
	        if (item != null && item.getId().equals(id)) {
	            System.out.println("Enter new information for the item:");
	            System.out.print("Name: ");
	            item.setName(input.next());
	            System.out.print("Author: ");
	            item.setAuthor(input.next());
	            System.out.print("Year of publication: ");
	            item.setPublicationYear(input.nextInt());
	            // Checks to set private subclass instances
	            // Check if the item is an instance of Journals to update volumeNumber
	            if (item instanceof Journals) {
	                System.out.print("Enter new volume number: ");
	                ((Journals) item).setVolumeNumber(input.nextInt());
	            }
	            // Check if the item is an instance of Books to update number of pages
	            else if(item instanceof Books) {
	                System.out.print("Enter new number of pages: ");
	                ((Books) item).setNumberOfPages(input.nextInt());
	            }
	            // Check if the item is an instance of Medias to update media type
	            else if(item instanceof Medias) {
	                System.out.print("Enter new media type: ");
	                ((Medias) item).setType(input.next());
	            }
	            System.out.println("Item updated successfully.");
	            return true;
	        }
	    }
	    // If item not found:
	    System.out.println("Item with ID " + id + " not found. Try again.");
	    return false;
	}
}
