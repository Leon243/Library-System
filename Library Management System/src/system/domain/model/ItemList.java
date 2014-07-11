package system.domain.model;

import java.sql.SQLException;
import java.util.ArrayList;

import system.database.LibraryDatabaseAdapter;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemList. adds Book object and Article object in to one list
 */

public class ItemList {

	/** The item list. */
	private static ArrayList<Item> itemList;
	
	/** The lib data. */
	private LibraryDatabaseAdapter libData;

	/**
	 * Instantiates a new item list.
	 * 
	 */
	public ItemList()  {
		itemList = new ArrayList<Item>();
		libData = new LibraryDatabaseAdapter();
		itemList = libData.getListFromDB();
	}

	/**
	 * Adds the reservation.
	 *
	 * @param email the email
	 * @param dateFrom the date from
	 * @param reservationID the reservation id
	 * @param itemID the item id
	 */
	public void addReservation(String email, MyDate dateFrom,
			int reservationID, int itemID) {
		Item item = getItemByID(itemID);
		item.addReservation(email, dateFrom, reservationID, itemID);
	}

	/**
	 * Gets the item reservation.
	 *
	 * @param itemID the item id
	 * @return the item reservation
	 */
	public String getItemReservation(int itemID) {
		Item item = getItemByID(itemID);
		return item.getListOfReservation().get(0).toString();
	}

	/**
	 * Adds the book.
	 * 
	 * @param itemID
	 *            the item id
	 * @param author
	 *            the author
	 * @param title
	 *            the title
	 * @param ISBN
	 *            the isbn
	 */
	public void addBook(int itemID, String author, String title, int ISBN) {
		Item book = new Book(itemID, author, title, ISBN);
		itemList.add(book);
	}

	/**
	 * Adds the article.
	 * 
	 * @param itemID
	 *            the item id
	 * @param author
	 *            the author
	 * @param title
	 *            the title
	 * @param magazine
	 *            the magazine
	 */
	public void addArticle(int itemID, String author, String title,
			String magazine) {
		Item article = new Article(itemID, author, title, magazine);
		itemList.add(article);
	}

	/**
	 * Checks if is empty.
	 * 
	 * @return true, if is empty
	 */
	public static boolean isEmpty() {
		if (itemList.size() < 1)
			return true;

		else
			return false;
	}

	/**
	 * Gets the item by id.
	 * 
	 * @param itemID
	 *            the item id
	 * @return the item by id
	 */
	public static Item getItemByID(int itemID) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getItemID() == itemID)
				return itemList.get(i);

		}
		return null;
	}

	/**
	 * Gets the item by reservation id.
	 *
	 * @param reservationID the reservation id
	 * @return the item by reservation id
	 */
	public static Item getItemByReservationID(int reservationID) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getReservedItem(reservationID) != -1) {
				return itemList.get(i);
			}
		}
		System.out.println("Item.getReservedItem()");
		System.err.println("Item not Found with ReservationID: "
				+ reservationID);
		return null;
	}

	/**
	 * Checks if is item reserved.
	 *
	 * @param itemID the item id
	 * @return true, if is item reserved
	 */
	public static boolean isItemReserved(int itemID) {
		return getItemByID(itemID).getListOfReservation() == null;
	}

	/**
	 * Removes the item by id.
	 *
	 * @param itemID the item id
	 * @return the item
	 */
	public Item removeItemById(int itemID) {
		if (!isEmpty()) {
			for (int i = 0; i < itemList.size(); i++) {
				if (itemList.get(i).getItemID() == itemID) {
					return itemList.remove(i);
				}
			}
		} else
			System.out.println("We did not find such ID");
		return null;
	}

	/**
	 * Search by title.
	 *
	 * @param title the title
	 * @return the string
	 */
	public String searchByTitle(String title) {
		String s = "";
		if (!isEmpty()) {
			for (int i = 0; i < itemList.size(); i++) {
				if (itemList.get(i).getTitle().equalsIgnoreCase(title)) {
					s += itemList.get(i).toString();
				}
			}
		}
		if (s.equalsIgnoreCase("")) {
			System.err.println("Item by Title: " + title
					+ " is not in the Library");
		}
		return s;
	}

	/**
	 * List of item.
	 * 
	 * @return the string
	 */
	public String listOfItem() {
		String s = "";
		if (itemList.size() > 0) {

			for (int i = 0; i < itemList.size(); i++) {
				s += itemList.get(i) + "\n";
			}
		} else
			return "no item in Library";
		return s;
	}

	/**
	 * Checks if is item id in list.
	 * 
	 * @param itemID
	 *            the item id
	 * @return true, if is item id in list
	 */
	public static boolean isItemIDInList(int itemID) {
		if (!isEmpty()) {

			for (int i = 0; i < itemList.size(); i++) {
				if (itemList.get(i).getItemID() == itemID) {
					return true;
				}
			}
		}
		return false;
	}
}
