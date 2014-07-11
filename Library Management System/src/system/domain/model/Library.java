package system.domain.model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import system.database.LibraryDatabaseAdapter;

// TODO: Auto-generated Javadoc
/**
 * The Class Library.
 */
public class Library {
	
	/** The item. */
	private ItemList item;
	
	/** The lit borrowed items. */
	private ListOfBorrowedItems litBorrowedItems;
	
	/** The lib data. */
	private LibraryDatabaseAdapter libData;
	
	/** The list of borrowers. */
	private BorrowerList listOfBorrowers;

	/**
	 * Instantiates a new library.
	 *
	 * @throws ParseException the parse exception
	 */
	public Library() throws ParseException  {
		super();
		item = new ItemList();
		libData = new LibraryDatabaseAdapter();
		litBorrowedItems = new ListOfBorrowedItems();
		listOfBorrowers = new BorrowerList();
		setBorrowerListFromDB();
		setReservationLists();
		setBorrowedItemList();
	}

	/**
	 * Sets the borrower list from db.
	 */
	private void setBorrowerListFromDB() {
		ArrayList<Borrower> tempBorowerList = new ArrayList<>();
		tempBorowerList = libData.getListOfBorrowers();
		for (int i = 0; i < tempBorowerList.size(); i++) {
			BorrowerList.addFromDatabase(tempBorowerList.get(i));
		}
		tempBorowerList = null;

	}

	// private void setBorrowerInList(String name, String email, String status)
	// {
	// BorrowerList.addBorrower(name, email, status);
	// }

	/**
	 * Adds the book.
	 *
	 * @param itemID the item id
	 * @param author the author
	 * @param title the title
	 * @param ISBN the isbn
	 */
	public void addBook(int itemID, String author, String title, int ISBN) {
		if (!(ItemList.isItemIDInList(itemID))) {
			item.addBook(itemID, author, title, ISBN);
			libData.addBook(itemID, author, title, ISBN);
		} else
			System.err.println("ItemID is already in List with ID: " + itemID);
	}

	/**
	 * Adds the article.
	 *
	 * @param itemID the item id
	 * @param author the author
	 * @param title the title
	 * @param magazine the magazine
	 */
	public void addArticle(int itemID, String author, String title,
			String magazine) {
		if (!(ItemList.isItemIDInList(itemID))) {
			item.addArticle(itemID, author, title, magazine);
			libData.addAarticle(itemID, author, title, magazine);
		} else
			System.err.println("ItemID is already in List with ID: " + itemID);
	}

	/**
	 * Search by title.
	 *
	 * @param title the title
	 * @return the string
	 */
	public String searchByTitle(String title) {
		return item.searchByTitle(title);
	}

	/**
	 * Removes the item by id.
	 *
	 * @param itemID the item id
	 * @return the item
	 */
	public Item removeItemById(int itemID) {
		if (ItemList.isItemIDInList(itemID)) {
			libData.removeItemById(itemID);
			return item.removeItemById(itemID);
		} else
			System.err.println("ItemID is not in the list with ID: " + itemID);
		return null;
	}

	/**
	 * Adds the borrower.
	 *
	 * @param name the name
	 * @param email the email
	 * @param status the status
	 */
	public void addBorrower(String name, String email, String status) {
		if (!(BorrowerList.isBorrowerInList(email))) {
			BorrowerList.addBorrower(name, email, status);
			libData.addBorrower(name, email, status);
		} else
			System.err.println("Borrower already is in the List with email: "
					+ email);
	}

	/**
	 * Removes the borrower by email.
	 *
	 * @param email the email
	 */
	public void removeBorrowerByEmail(String email) {
		if (BorrowerList.isBorrowerInList(email)) {
			BorrowerList.removeByEmail(email);
			libData.removeByEmail(email);
		} else
			System.err
					.println("Borrower already is not in the List with email: "
							+ email);
	}

	/**
	 * Adds the reservation.
	 *
	 * @param email the email
	 * @param dateFrom the date from
	 * @param reservationID the reservation id
	 * @param itemID the item id
	 * @throws ParseException the parse exception
	 */
	public void addReservation(String email, MyDate dateFrom,
			int reservationID, int itemID) throws ParseException {
		ReservationList.addReservation(email, dateFrom, reservationID, itemID);

		libData.addReservation(email, dateFrom, reservationID, itemID);
	}

	/**
	 * Removes the rservation by id.
	 *
	 * @param reservationID the reservation id
	 * @return the reservation
	 */
	public Reservation removeRservationById(int reservationID) {
		libData.removeReservation(reservationID);
		return ReservationList.removeReservationByID(reservationID);
	}

	/**
	 * Gets the reservations.
	 *
	 * @param itemID the item id
	 * @return the reservations
	 */
	public String getReservations(int itemID) {
		String s = "";
		// System.out.println(ItemList.getItemByID(itemID));
		ArrayList<Reservation> list = new ArrayList<>();
		list = ItemList.getItemByID(itemID).getListOfReservation();
		for (int i = 0; i < list.size(); i++) {
			s += list.get(i).toString();
		}
		return s;
	}

	/**
	 * Gets the all reservations.
	 *
	 * @return the all reservations
	 */
	public String getAllReservations() {
		String s = "";
		ArrayList<Reservation> list = new ArrayList<>();
		list = libData.getListOfReservations();
		for (int i = 0; i < list.size(); i++) {
			s += list.get(i).toString() + "\n";
		}
		return s;
	}

	/**
	 * Gets the all borrowed items.
	 *
	 * @return the all borrowed items
	 */
	public String getAllBorrowedItems() {
		String s = "";
		ArrayList<BorrowedItem> list = new ArrayList<>();
		list = libData.getListOfBorrowedItems();
		for (int i = 0; i < list.size(); i++) {
			s += list.get(i).toString() + "\n";
		}
		return s;
	}

	/**
	 * Sets the reservation.
	 *
	 * @param email the email
	 * @param dateFrom the date from
	 * @param reservationID the reservation id
	 * @param itemID the item id
	 * @throws ParseException the parse exception
	 */
	private void setReservation(String email, MyDate dateFrom,
			int reservationID, int itemID) throws ParseException {
		ReservationList.addReservation(email, dateFrom, reservationID, itemID);
	}

	/**
	 * Sets the reservation lists.
	 *
	 * @throws ParseException the parse exception
	 */
	private void setReservationLists() throws ParseException {
		ArrayList<Reservation> tempReserv = new ArrayList<>();
		tempReserv = libData.getListOfReservations();
		for (int i = 0; i < tempReserv.size(); i++) {
			setReservation(tempReserv.get(i).getEmail(), tempReserv.get(i)
					.getDateFrom(), tempReserv.get(i).getReservationID(),
					tempReserv.get(i).getItemID());
		}
		tempReserv = null;
	}

	/**
	 * Sets the borrowed item.
	 *
	 * @param dateFrom the date from
	 * @param dateTill the date till
	 * @param itemID the item id
	 * @param email the email
	 * @throws ParseException the parse exception
	 */
	private void setBorrowedItem(MyDate dateFrom, MyDate dateTill, int itemID,
			String email) throws ParseException {
		litBorrowedItems.copyFromDatabase(dateFrom, dateTill, itemID, email);
	}

	/**
	 * Sets the borrowed item list.
	 *
	 * @throws ParseException the parse exception
	 */
	private void setBorrowedItemList() throws ParseException {
		ArrayList<BorrowedItem> tempReserv = new ArrayList<>();
		tempReserv = libData.getListOfBorrowedItems();
		for (int i = 0; i < tempReserv.size(); i++) {
			setBorrowedItem(tempReserv.get(i).getDateFrom(), tempReserv.get(i)
					.getDateTill(), tempReserv.get(i).getItemID(), tempReserv
					.get(i).getEmail());
		}
		tempReserv = null;
	}

	/**
	 * List of item.
	 *
	 * @return the string
	 */
	public String listOfItem() {
		return item.listOfItem();
	}

	/**
	 * Late deliveries.
	 *
	 * @return the string
	 */
	public String lateDeliveries() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Borrow an item.
	 *
	 * @param itemID the item id
	 * @param email the email
	 * @throws ParseException the parse exception
	 */
	public void borrowAnItem(int itemID, String email) throws ParseException {
		if (!ListOfBorrowedItems.isItemIDInList(itemID)) {
			MyDate dateFrom = new MyDate();
			MyDate dateTill = new MyDate();
			dateFrom = MyDate.now();
			dateTill = MyDate.now();
			System.out.println(dateFrom + " ^^^^^^^^^^^^^^^6");
			System.out.println(dateTill + " ^^^^^^^^^^^^^^");
			Borrower borrower = BorrowerList.getBorrowerByEmail(email);
			if (borrower != null) {

				String status = borrower.getStatus();
				System.out.println(borrower.getStatus());
				System.out.println(dateFrom);
				System.out.println(dateTill);
				if (status.equalsIgnoreCase("student")) {
					dateTill.stepForwardMonths(6);
				} else {
					dateTill.stepForwardMonths(1);
				}
				System.out.println(dateFrom + " ***********");
				System.out.println(dateTill + " ***********");
				ListOfBorrowedItems.borrowAnItem(dateFrom, dateTill, itemID,
						email);
				libData.addBorrowedItem(dateFrom, dateTill, itemID, email);
			}

		} else {
			System.out.println("Library.borrowAnItem()");
			System.err.println("can not borrow this item with itemID: "
					+ itemID);
		}
	}

	/**
	 * Return an item.
	 *
	 * @param itemID the item id
	 * @return the borrowed item
	 */
	public BorrowedItem returnAnItem(int itemID) {
		libData.returnItem(itemID);
		return ListOfBorrowedItems.returnItem(itemID);

	}

	/**
	 * List of borrowed items.
	 *
	 * @return the array list
	 */
	public ArrayList<BorrowedItem> listOfBorrowedItems() {
		return libData.getListOfBorrowedItems();
	}

}
