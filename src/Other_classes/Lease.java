package Other_classes;
import Clients.Client;
//This class is made to keep track of leased items, it has attributes Client and Items.
public class Lease {
	//private attributes
	private Client client;
	private Items item;
	//Default constructor initializes object attibutes to null
	public Lease() {};
	//parametized constructor which takes objects as paramater
	public Lease(Client client, Items item) {
		this.client = client;
		this.item = item;
	}
	//Copy constructor, this has no functionality in this case but I included it because of the instructions
	public Lease(Lease other) {
		this.client = other.client;
		this.item = other.item;
	}
	//Accessors for attributes
	public Client getClient() {
		return this.client;
	}
	public Items getItem() {
		return this.item;
	}
	//Mutators for attributes
	public void setClient(Client client) {
		this.client = client;
	}
	public void setItem(Items item) {
		this.item = item;
	}
	//toString method displays which client is leasing which item based on a lease object.
	public String toString() {
		return "Client " + getClient().getId() + " is leasing item " + getItem().getId() + "\n";
	}
	//equals method will compare one Lease object to another object, returns true if the objects have the same type Lease and the same attributes.
	public boolean equals(Object other) {
		// Check if the passed object is null or of a different type
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		else {
			// Typecast the object to Client
	         Lease otherLease = (Lease) other;

	        // Compare all attributes except ID
	        return this.getClient() == otherLease.getClient()&&
	        		this.getItem() == otherLease.getItem();
	    }
	}
	//addLease method will add a Lease object to a Lease array
	public static void addLease(Lease obj,Lease[] arr) {
		//goes through array elements and add the object in the first null spot which means right after the previous element, if there was none, this will be the first element.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = obj;
				break;
			}
			//if the element in the array isnt null it will run the loop again
			else {
				continue;
			}
		}
	}
	/*
	 * This method will take a client object and a Lease array, loop through the lease array to find the client that matches the one with the 
	 * parameter and then put all their leased items in an Items array and output that. This is used to show all items leased by a specific client.
	 */
	public static Items[] clientLeases(Client client, Lease[] arr) {
		//make Items array and set it to same length as the Lease araray
		Items[] leasedItems = new Items[arr.length];
		//go through Lease array and ignore null elements.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				continue;
			}
			//if an element's client matches the parameter one then add all its items to an items array.
			else if(arr[i].getClient() == (client)) {
				leasedItems[i] = arr[i].getItem();
			}
		}
		//return array
		return leasedItems;
	}
	/*
	 * This is used when the user wants to return a leased item, essentially delets it from the array of all Leases. It takes two array parameters and an id.
	 * One array is the Lease array which all Leases are in and one is the Items array showing all items leased by that client.
	 * its important to remove the item from both arrays so that there are no errors or confusions.*/
	public static void returnItem(String id, Lease[] arr, Items[] array) {
        // variable used later to set the element to null.
        int indexToDelete = -1;
        //go through the Lease array to find an item with a given id and if so set variable to i
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getItem().getId().equals(id)) {
                indexToDelete = i;
                break;
            }
        }
        // Remove the item if found
        if (indexToDelete != -1) {
            // Shift elements in the Lease Array
            for (int i = indexToDelete; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
         // Set the Leases array element to null to delete the item
            arr[arr.length - 1] = null;
            // Shift elements in the Items array
            for (int i = indexToDelete; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            // Set the Items array element to null to delete the item
            array[array.length - 1] = null;
            System.out.println("Item with id " + id + " found and returned.");
        } 
        //if the item with given id is not found.
        else {
            System.out.println("Item with ID " + id + " not found.");
        }
    }
}
