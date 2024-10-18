package Clients;
import java.util.Scanner;

public class Client {
	//Scanner made
	static Scanner input = new Scanner(System.in);
	//static IdCounter attribute will be used to keep track of the number of objects and also used below to create Ids automatically.
	public static int IdCounter;
	//All other attributes
	public String ID;
	public String name;
	public long phoneNumber;
	public String email;
	
	//Default constructor, initializes all attributes to the 0 of their type as well incrementing the counter and generating an id.
	public Client() {
		IdCounter++;
		generateId();
	};
	//Parametized constructor to set values for all attributes as well incrementing the counter and generating an id.
	public Client(String name, long number, String email) {
		this.name = name;
		this.phoneNumber = number;
		this.email = email;
		IdCounter++;
		generateId();
	}
	//Copy constructor used to create a copy of an object with the same attributes except the id as well incrementing the counter and generating an id.
	public Client(Client other) {
		this.name = other.name;
		this.phoneNumber = other.phoneNumber;
		this.email = other.email;
		IdCounter++;
		generateId();
	}
	//Accessors for all attributes
	public String getId() {
		return this.ID;
	}
	public String getName() {
		return this.name;
	}
	public long getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getEmail() {
		return this.email;
	}
	//Mutators for all attributes except the ID since it is set automatically through the generateId() function.
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(long number) {
		this.phoneNumber = number;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//toString method to display the details of the client
	public String toString() {
		return String.format("Information of the client:\nID: %s\nName: %s\nPhone number: %d\nEmail: %s\n",
                ID, name, phoneNumber, email);
	}
	/*
	 * equals method compares a Client object to another object, if the parameter object is null or of a different type it will return false, 
	 * also false if they are the same type but dont have the same attributes(except id). returns true if both objects are of the same type and have the same
	 * attributes(except ID).
	 */
	public boolean equals(Object other) {
		// Check if the passed object is null or of a different type
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		else {
			// Typecast the object to Client
	        Client otherClient = (Client) other;

	        // Compare all attributes except ID
	        return this.getName().equals(otherClient.getName()) &&
	                this.getPhoneNumber() == (otherClient.getPhoneNumber()) &&
	                this.getEmail().equals(otherClient.getEmail());
	    }
	}
	//this method sets the ID attribute to C + the counter to create a unique ID for each object. It is included in all constructors.
	public void generateId() {
		this.ID = "C" + IdCounter;
	}
	public static void addClient(Client[] arr) {
		System.out.print("Enter the Client's name: ");
		String clientName = input.nextLine();
		System.out.print("Enter the Client's Phone number: ");
		long clientPhone = input.nextLong();
		System.out.print("Enter the Client's email address: ");
		String clientEmail = input.next();
		input.nextLine();
		arr[IdCounter] = new Client(clientName, clientPhone, clientEmail);
	}
	//This method will take a string id and search an array of clients to look for a client object that has a matching id as the string, outputs a client object.
	public static Client findClientById(String id, Client[] arr) {
		for (Client client : arr) {
            if (client != null && client.getId().equals(id)) {
                return client;
            }
        }
        System.out.println("Client not found");
        return null; // Client not found
    }
	//This method takes a String id and an array of Client. it will go through the array to find the client with the given id and ask for new info to update it.
	public static void updateClient(String id, Client[] arr) {
        for (Client i : arr) {
            if (i != null && i.getId().equals(id)) {
            	//mutators and user input are used to insert the new information into the object.
                System.out.println("Enter new information for the client: ");
                System.out.print("Name: ");
                i.setName(input.next());
                System.out.print("Phone number: ");
                i.setPhoneNumber(input.nextLong());
                System.out.print("Email: ");
                i.setEmail(input.next());
                System.out.println("\nClient updated successfully.\n" + i.toString());
                // Exit the method after updating the client
                return;
            }
        }
        //else print
    	System.out.println("Client with ID " + id + " not found.");
	}
	//This method will go through an array of clients an look for a certain client the user wants to delete and remove them by setting that index in the array as null and shifting the array elements.
	public static void deleteClient(Client[] arr) {
		//ask user to give a clients id and store it
		System.out.print("Enter the ID of the client you wish to delete: ");
		String IdToDelete = input.next();
        //this variable will be used to set the element to null
		int indexToDelete = -1;
        for (int i = 0; i < arr.length; i++) {
        	//checks if a none-null element has the same id and if so sets i as the index to delete
            if (arr[i] != null && arr[i].getId().equals(IdToDelete)) {
                indexToDelete = i;
                break;
            }
        }
        // Delete the element if found
        if (indexToDelete != -1) {
            //shift array elements and set element with id to null
            for (int i = indexToDelete; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = null;
            System.out.println("Client with ID " + IdToDelete + " found and deleted.");
        } 
        else {
            System.out.println("Client with ID " + IdToDelete + " not found.");
        }
    }
}
