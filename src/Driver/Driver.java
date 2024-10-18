//Import all required package classes and scanner
package Driver;
import Other_classes.Items;
import Other_classes.Books;
import Other_classes.Journals;
import Other_classes.Medias;
import Other_classes.Lease;
import Clients.Client;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//make scanner
		Scanner input = new Scanner(System.in);
		//Asks the user if they want the menu or pre-defined scenario. Pressing 3 or any other number ends the program.
		System.out.print("Which option do you choose?"
				+ "\n1. Display menu."
				+ "\n2. Display predefined scenario."
				+ "\n3. Quit program."
				+ "\nEnter your choice here => \n");
		//Stores their choice
		int startChoice = input.nextInt();
		//If they select 1 which is the menu the menu is displayed
		if (startChoice == 1) {
			//Attributes to help test out the menu
			//This is our library inventory, holds all items that are a subclass of the Items class.
			Items[] inventory = new Items[25];
			//This is an array of books containing our book objects.
			Books[] booksArray = new Books[10];
			//Client objects created can be added to array of clients.
			Client[] clientsArray = new Client[10];
			//Lease array created to track all clients and items leased to them.
			Lease[] leaseData = new Lease[3];
			//This boolean keeps the do while loop repeating while true;
			boolean repeat = true;
			do {
				//Menu printed, in this menu i grouped all options relating to items (the first 5) into 1 and options related to clients in 2 (the next 3), the other options are indiviudal.
				System.out.print("------------------------------------------"
						+ "\nPick an option from the menu below:"
						+ "\n1. Item options."
						+ "\n2. Client options."
						+ "\n3. Lease an item to a client"
						+ "\n4. Return an item from a client."
						+ "\n5. Show all items leased by a client."
						+ "\n6. Show all leased items (By all clients)."
						+ "\n7. Display the biggest book."
						+ "\n8. Make a copy of the books array."
						+ "\n9. Quit program."
						+ "\n------------------------------------------\n");
				//User choice from menu stores
				int menuChoice = input.nextInt();
				//switch case to go through all choices
				switch(menuChoice) {
				//Option 1 bring up a second menu for item options
				case 1:
					//User can choose what item option they want
					System.out.print("Which item option do you want?"
							+ "\n1. Add an item."
							+ "\n2. Delete an item."
							+ "\n3. Change information of an item."
							+ "\n4. List all items from a specific category."
							+ "\n5. Display all items."
							+ "\n6. Go back to main menu. \n");
					//store their choice
					int itemChoice = input.nextInt();
					//switch case for item options
					switch(itemChoice) {
					//option 1 to add an item which gets stored in our inventory array.
					case 1:
						//Asks the user which category of item they want to add
						System.out.print("What type of item would you like to add?"
								+ "\n1. Books"
								+ "\n2. Journals"
								+ "\n3. Media \n");
						//store answer
						int itemToAdd = input.nextInt();
						//switch which each choice adding one object from a chosen category to the items array.
						switch(itemToAdd) {
						case 1:
							//Uses addBook to add a book item to the inventory array. In class Books
							Books.addBook(inventory);
							System.out.println("Your item has been added.\n");
							break;
						case 2:
							//uses addJournal to add a journal item to the inventory array. In class Journals
							Journals.addJournal(inventory);
							System.out.println("Your item has been added.\n");
							break;
						case 3:
							//uses addMedia to add a media item to the inventory array. in Class Medias
							Medias.addMedia(inventory);
							System.out.println("Your item has been added.\n");
							break;
						default:
							//in case they enter a number other than 3.
							System.out.print("Invalid choice, try again.");
						}
						break;
					//option to delete an item from the inventory
					case 2:
						boolean deleted = true;
						//Use this method to show all available items
						allItemIds(inventory);
						do {
							//uses deleteItem method from the Itemsclass. view class for explanation.
							deleted = Items.deleteItem(inventory);
						}while(!deleted);
						break;
					//option to update the information of a specific item.
					case 3:
					    boolean found = false;
				        // Use this method to show all available items
				        allItemIds(inventory);
					    do {
					        // Asks the user to enter the ID of an item they would like to update and stores it.
					        System.out.print("Enter the ID of the item you want to change the information of: ");
					        String IdToUpdate = input.next();
					        // Attempt to update the item
					        found = Items.updateItem(IdToUpdate, inventory);
					    } while (!found);
					    break;
					//option to see all items from a specific category
					case 4:
						//first ask user which category they want to see items from 
						System.out.println("Which category do you want to see items from?"
								+ "\n1. Books"
								+ "\n2. Journals"
								+ "\n3. Medias ");
						//store their choice
						int categoryChoice = input.nextInt();
						//switch goes through choices
						switch(categoryChoice) {
						//These options go through the whole inventory and print all items which have an Id starting with the specific letter since each category starts with the same letter id.
						case 1:
							//Go through inventory array
							for (int i = 0; i < inventory.length; i++) {
								//if element is null ignore it and run loop again
								if (inventory[i] == null)
									continue;
								//if the element's id has B as their first letter meaning it's a book print its information.
								if (inventory[i].getId().charAt(0) == 'B') {
									System.out.println(inventory[i].toString());
								}
							}
							break;
						case 2:
							//Go through inventory array
							for (int i = 0; i < inventory.length; i++) {
								//if element is null ignore it and run loop again
								if (inventory[i] == null)
									continue;
								//if the element's id has J as their first letter meaning it's a book print its information.
								if (inventory[i].getId().charAt(0) == 'J') {
									System.out.println(inventory[i].toString());
								}
							}
							break;
						case 3:
							//Go through inventory array
							for (int i = 0; i < inventory.length; i++) {
								//if element is null ignore it and run loop again
								if (inventory[i] == null)
									continue;
								//if the element's id has M as their first letter meaning it's a book print its information.
								if (inventory[i].getId().charAt(0) == 'M') {
									System.out.println(inventory[i].toString());
								}
							}
							break;
						default:
							System.out.print("Invalid choice, try again.");	
						}
						break;
					//Option to show all items from all categories.	
					case 5:
						//Goes through whole inventory array and displays all item's information using toString.
						for (int i = 0; i < inventory.length; i++) {
							//Ignores elements that are null
							if (inventory[i] == null)
								continue;
							System.out.println(inventory[i].toString());
						}
						break;
					//This option will just break and go back to the main menu	
					case 6:
						break;
					//if they press an invalid option this message is displayed and the program reverts to the main menu.	
					default:
						System.out.print("Invalid choice, try again.");
					}
					break;
				//This shows all client options	
				case 2:
					//ask user which client option they want
					System.out.print("Which client option do you want?"
							+ "\n1. Add a client"
							+ "\n2. Edit a client"
							+ "\n3. delete a client \n");
					//Store their choice
					int clientChoice = input.nextInt();
					switch(clientChoice) {
					//This option adds a client meaning it creates a new client object and also adds it to the client array.
					case 1:
						//Asks how many they want to add, the number decides how many times the loop after this will run.
						System.out.print("How many clients do you wish to add?");
						int nbOfClients = input.nextInt();
						//Loops runs based on the amount of times the user wants and adds a client object to the array using the addClient method. View client class for explanation.
						for (int i = 0; i < nbOfClients; i++) {
							Client.addClient(clientsArray);
						}
						//Message to display success
						System.out.println("Client successfully added.\n");
						break;
					//option to edit a client	
					case 2:
						//display all client ids to user can choose one
						allClientIds(clientsArray);
						//ask which one they wish to edit
						System.out.print("Enter the ID of the client you wish to edit: ");
						String clientId = input.next();
						//take that id and put it in this method along with the array the client is stored in.
						//This method will go through the array and find client with that id and ask for new information and store it in the object.
						Client.updateClient(clientId, clientsArray);
						break;
					//option to delete a client from array	
					case 3:
						//show all client Ids so they can choose.
						allClientIds(clientsArray);
						//uses deleteClient method. asks for client id and deletes it from array. View class Client
						Client.deleteClient(clientsArray);
						break;
					}
					break;
				//Option to lease an item to a client	
				case 3:
					Client clientToLease = null;
					String idToLease;
					//loop runs until they enter a valid client id
					while (clientToLease == null) {
						//show all client Ids so they can choose.
						allClientIds(clientsArray);
						//asks for a client Id
						System.out.print("Enter the Id of the client you wish to lease an item to: ");
						//variable used to store both client id and item id to use for leasing.
						idToLease = input.next();
						//New client object has the same data as the client with given id.
						clientToLease = Client.findClientById(idToLease, clientsArray);
					}
					//Show all item ids so they can choose.
					allItemIds(inventory);
					//ask for an item id to lease
					System.out.print("Enter the Id of the item you wish to lease to the client: ");
					idToLease = input.next();
					//new item object has the same data as the item with given id.
					Items itemToLease = Items.findItemById(idToLease, inventory);
					//Lease object made by using the client and item objects
					Lease lease2 = new Lease(clientToLease, itemToLease);
					//method used to add the lease object to the array.
					Lease.addLease(lease2, leaseData);
					//Print result
					System.out.println("Client " + clientToLease.getId() + " has now leased item " + itemToLease.getId());
					break;
				//Option to return a leased item from a client	
				case 4:
					//show all client Ids so they can choose.
					allClientIds(clientsArray);
					//ask them to choose a client Id and store it
					System.out.print("Enter the Id of the client making a return: ");
					//variable used to store both client and item ids to return 
					String idToReturn;
					idToReturn = input.next();
					//new client object has the same data as the object with given id
					Client clientToReturn = Client.findClientById(idToReturn, clientsArray);
					//Items array stores an array of all the items the client is leasing through the clientLeases method.
					Items[] returnItems = Lease.clientLeases(clientToReturn, leaseData);
			        // Check if the array contains non-null elements
			        boolean isEmpty = true;
			        for (Items element : returnItems) {
			            if (element != null) {
			                isEmpty = false;
			                break;
			            }
			        }
					if (isEmpty == false) {
						//Show all items the client is leasing so they can choose one.
						System.out.println("This client is leasing the following item(s): ");
						//Print all Ids of the items in the returnItems array so the user can choose one to return.
						for (int i = 0; i < returnItems.length; i++) {
							//if null ignore it and repeat
							if (returnItems[i] == null)
								continue;
							else {
								//else print id of item.
								System.out.println(returnItems[i].getId());
							}
						}
						//make user choose an id of an item to return and store it
						System.out.print("Enter the Id of the item you would like to return: ");
						idToReturn = input.next();
						//use the return method to remove it from both the array of Leases and returnItems array.
						Lease.returnItem(idToReturn, leaseData, returnItems);
					}
					else {
						System.out.println("This client is not leasing any items.");
					}
					break;
				//Option to show all leased items by a client	
				case 5:
					//show all client Ids so they can choose.
					allClientIds(clientsArray);
					//ask user to pick a client id and store it
					System.out.print("Enter the Id of the client to view their leases: ");
					String IdForLeases = input.next();
					//new client object has same data as the one with the id
					Client clientToSeeLeases = Client.findClientById(IdForLeases, clientsArray);
					//Show all the items they are using
					System.out.println("This client is leasing the following item(s): ");
					//Items array clientLeases stores an array of all the items the client is leasing.
					Items[] clientLeases = Lease.clientLeases(clientToSeeLeases, leaseData);
					//printArray function displays the information for all items in the Items array by using their toString methods. View explanation at the end. 
					printArray(clientLeases);
					break;
				//Option to view all leased items by all clients	
				case 6:
					//print message
					System.out.println("These are all the leased items in our data-base.");
					//go through the array of leases and print the information
					for (int i = 0; i < leaseData.length; i++) {
						//If null ignore the element.
						if (leaseData[i] == null)
							continue;
						else {
							//else prints the toString of the lease object and the toString of the Item in the Lease object to give a detailed view.
							System.out.print(leaseData[i].toString()+ "\n" + leaseData[i].getItem().toString() + "\n");
						}
					}
					break;
				//option to view the biggest book	
				case 7:
					//initialize Books object by using the getBiggestBook method which uses an array as a parameter and returns an object. See the end for description 
					Books biggestBook = getBiggestBook(booksArray);
			        if (biggestBook != null) {
			        	//if the object isn't null print this message
			            System.out.println("The biggest book is " + biggestBook.getId());
			            //also print it's information with toString
			            System.out.println(biggestBook.toString());
			        } else {
			        	//if null then no books in the inventory
			            System.out.println("No books in the inventory.");
			        }
			        break;
			    //option to make a deep copy of a Books array   
				case 8:
					//initialize new Books array using the copyBooks method. This method takes a Books array and outputs a new Books array which is a deep copy of the original.
					Books[] newBooksArray = copyBooks(booksArray);
					//print messag
			        System.out.println("\nArray deep copied successfully. New copied books array:");
			        //Display array using printArray
			        printArray(newBooksArray);
			        break;
			    //option to exist the program   
				case 9:
					System.out.print("The program has ended.");
					System.exit(0);
					break;
				//any number other than 1-9 will display this message and repeat the menu	
				default:
					System.out.print("Invalid choice, try again.\n");
					continue;
				}
			}while(repeat);
		}
		//If the user selects 2 the pre-defined scenario runs
		else if(startChoice == 2) {
			//Objects and users created with different parameters and constructors all used such as default, parametized and copy
			Books book1 = new Books();
			Books book2 = new Books("Americana", "Adichie", 2013, 533);
			Books book3 = new Books(book2);
			Books book4 = new Books("random", "jared", 2006, 534);
			Journals journal1 = new Journals();
			Journals journal2 = new Journals("Dracula", "Stoker", 1897, 440);
			Journals journal3 = new Journals(journal2);
			Medias media1 = new Medias("Jungle", "Drake", 2015, "Music");
			Medias media2 = new Medias();
			Medias media3 = new Medias(media1);
			Client client1 = new Client("Alex", 1578739456, "alexjh98@yahoo.com");
			Client client2 = new Client("Jeff", 1389156794, "jeffbezos@gmail.com");
			Client client3 = new Client("Jillian", 1987456732, "jillian1213@outlook.com");
			//Books array containing all book items created above.
			Books[] bookData = new Books[6];
			bookData[0] = book1;
			bookData[1] = book2;
			bookData[2] = book3;
			bookData[3] = book4;
			//Journals array containing all journal items created above.
			Journals[] journalData = new Journals[6];
			journalData[0] = journal1;
			journalData[1] = journal2;
			journalData[2] = journal3;
			//Medias array containing all media items created above.
			Medias[] mediaData = new Medias[7];
			mediaData[0] = media1;
			mediaData[1] = media2;
			mediaData[2] = media3;
			//Array containing all items
			Items[] itemStorage = {book1, book2, book3, book4, journal1, journal2, journal3, media1, media2, media3};
			//Array containing all users
			Client[] clientData = {client1, client2, client3};
			System.out.println("Information of items and clients:");
			//Using the printArray method and toString to display all items and clients
			printArray(itemStorage);
			printArray(clientData);
			//Using equals method to test for equality of objects with different scenarios
			System.out.println("Testing for equality:");
			//Comparing two objects of different types, should return false
			System.out.println("Does client " + client1.getId() + " equal book " + book1.getId() + ": " + client1.equals(book1));
			System.out.println("Does journal " + journal2.getId() + " equal media " + media1.getId() + ": " + journal2.equals(media1));
			//Comparing two objects of the same class with different values, should return false
			System.out.println("Does client " + client1.getId() + " equal client " + client3.getId() + ": " + client1.equals(client3));
			System.out.println("Does journal " + journal2.getId() + " equal journal " + journal1.getId() + ": " + journal2.equals(journal1));
			//Comparing two objects of the same class with the same values, should return true;
			System.out.println("Does book " + book2.getId() + " equal book " + book3.getId() + ": " + book2.equals(book3));
			System.out.println("Does media " + media3.getId() + " equal media " + media1.getId() + ": " + media3.equals(media1));
			//Displaying the biggest book using the getBiggestBook method.
			System.out.println("\nThe biggest book available is:");
			Books bigBook = getBiggestBook(bookData);
	        if (bigBook != null) {
	            System.out.println(bigBook.getId());
	            System.out.println(bigBook.toString());
	        } else {
	            System.out.println("No books in the inventory.");
	        }
	        //Making a deep copy of the booksData array and displaying both arrays after
	        //Making the deep copy
	        Books[] copiedArray = copyBooks(bookData);
	        System.out.println("==>Displaying original books array: ");
	        printArray(bookData);
	        System.out.println("==>Displaying copied books array: ");
	        printArray(copiedArray);
	        
		}
		//If user chooses 3 or another number the program quits
		else {
			System.out.println("The program has ended.");
			System.exit(0);
		}
		//Close scanner
		input.close();
	}
	//This method goes through an array of items and prints all their IDs, used to show user the ids of items so the user can choose.
	public static void allItemIds(Items[] inventory) {
		System.out.print("All available items: \n");
		for (int i = 0; i < inventory.length; i++) {
			//if element is null ignore it and repeat
			if (inventory[i] == null)
				continue;
			//else display elements id
			System.out.println(inventory[i].getId());
		}
	}
	//This method goes through an array of clients and prints all their IDs, used to show user the ids of clients so the user can choose.
	public static void allClientIds(Client[] arr) {
		System.out.print("All available clients: \n");
		for (int i = 0; i < arr.length; i++) {
			//if element is null ignore it and repeat
			if (arr[i] == null)
				continue;
			//else print its id
			System.out.println(arr[i].getId());
		}
	}
	//This method is used to find the Books object with the highest amount of pages from a Books array.
    public static Books getBiggestBook(Items[] arr) {
    	//Initiae new Books object to null
        Books biggestBook = null;
        //max Counter used to compare pages
        int maxPages = -1;
        //goes through all items in Books array and checks if their pages are higher than maxPages and if so switches them.
        for (Items item : arr) {
            if (item instanceof Books) {
                Books currentBook = (Books) item;
                if (currentBook.getNumberOfPages() > maxPages) {
                    maxPages = currentBook.getNumberOfPages();
                    biggestBook = currentBook;
                }
            }
        }
        return biggestBook;
    }
    // Method to make a deep copy of an array of Books using an original array as a parameter and returning an array of Books
    public static Books[] copyBooks(Books[] firstArray) {
    	// Handle null array case
        if (firstArray == null) {
            return null;  
        }
        //Make new array object and initialize it to the length of the first array
        Books[] copiedArray = new Books[firstArray.length];
        //loop goes through all firstArray element
        for (int i = 0; i < firstArray.length; i++) {
        	//if they are not null, copy them into new array
            if (firstArray[i] != null) {
                // Create a deep copy of the Book
                copiedArray[i] = new Books(firstArray[i]);
            }
        }
        //return new array
        return copiedArray;
    }
    //This method is used to print information for arrays of any object type by going through the elements and using the toString method.
    public static void printArray(Object[] array) {
        for (Object i : array) {
        	//if element is not null print its toString
            if (i != null) {
                System.out.println(i.toString());
            }
        }
    }
}
