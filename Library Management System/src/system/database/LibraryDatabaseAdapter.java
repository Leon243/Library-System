package system.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import system.database.MyDatabase;
import system.domain.model.Article;
import system.domain.model.Book;
import system.domain.model.BorrowedItem;
import system.domain.model.Borrower;
import system.domain.model.Item;
import system.domain.model.ItemList;
import system.domain.model.ListOfBorrowedItems;
import system.domain.model.MyDate;
import system.domain.model.Reservation;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryDatabaseAdapter.
 */
public class LibraryDatabaseAdapter {
	
	/** The Constant DATABASE_NAME. */
	public static final String DATABASE_NAME = "library";
	
	/** The Constant USER. */
	private static final String USER = "root";
	
	/** The Constant PASSWORD. */
	private static final String PASSWORD = "";
	
	/** The Constant DEBUG. */
	private static final boolean DEBUG = true;
	
	/** The sql. */
	private String sql;
	
	/** The db. */
	private MyDatabase db;

	/**
	 * Instantiates a new library database adapter.
	 */
	public LibraryDatabaseAdapter() {
		db = new MyDatabase(DATABASE_NAME, USER, PASSWORD);
		db.setDebugMode(DEBUG);
	}

	/**
	 * Connect.
	 *
	 * @return true, if successful
	 */
	public boolean connect() {
		return db.openDatabase();
	}

	/**
	 * Disconnect.
	 *
	 * @return true, if successful
	 */
	public boolean disconnect() {
		return db.closeDatabase();
	}

	/**
	 * Adds the book.
	 *
	 * @param itemID the item id
	 * @param author the author
	 * @param title the title
	 * @param ISBN the isbn
	 */
	public void addBook(int itemID, String author, String title, int ISBN) {
		db.openDatabase();
		sql = "INSERT INTO `books`( `itemID`, `author`, `title`, `ISBN`) VALUES ('"
				+ itemID
				+ "' , '"
				+ author
				+ "' , '"
				+ title
				+ "' , '"
				+ ISBN
				+ "')";
		db.update(sql);
		db.closeDatabase();
	}

	/**
	 * Adds the aarticle.
	 *
	 * @param itemID the item id
	 * @param author the author
	 * @param title the title
	 * @param magazine the magazine
	 */
	public void addAarticle(int itemID, String author, String title,
			String magazine) {
		db.openDatabase();
		sql = "INSERT INTO `article`( `itemID`, `author`, `title`, `magazine`) VALUES ('"
				+ itemID
				+ "' , '"
				+ author
				+ "' , '"
				+ title
				+ "' , '"
				+ magazine + "')";
		db.update(sql);
		db.closeDatabase();
	}

	/**
	 * Gets the list of books.
	 *
	 * @return the list of books
	 */
	public ArrayList<Item> getListOfBooks() {
		db.openDatabase();
		ArrayList<Item> bookList = new ArrayList<Item>();
		String sql = "SELECT `itemID`, `author`, `title`, `ISBN` FROM books";
		ArrayList<Object[]> result = db.query(sql);
		for (int i = 0; i < result.size(); i++) {
			int itemID = Integer.parseInt(result.get(i)[0].toString());
			String author = (String) result.get(i)[1];
			String title = (String) result.get(i)[2];
			int ISBN = Integer.parseInt(result.get(i)[3].toString());

			Item readItem = new Book(itemID, author, title, ISBN);
			bookList.add(readItem);
		}
		db.closeDatabase();
		return bookList;
	}

	/**
	 * Gets the list of articles.
	 *
	 * @return the list of articles
	 */
	public ArrayList<Item> getListOfArticles() {
		db.openDatabase();
		ArrayList<Item> articleList = new ArrayList<Item>();
		String sql = "SELECT `itemID`, `author`, `title`, `magazine` FROM article";
		ArrayList<Object[]> result = db.query(sql);
		for (int i = 0; i < result.size(); i++) {
			int itemID = Integer.parseInt(result.get(i)[0].toString());
			String author = (String) result.get(i)[1];
			String title = (String) result.get(i)[2];
			String magazine = (String) result.get(i)[3];

			Item readItem = new Article(itemID, author, title, magazine);
			articleList.add(readItem);
		}
		db.closeDatabase();
		return articleList;
	}

	/**
	 * Gets the list from db.
	 *
	 * @return the list from db
	 */
	public ArrayList<Item> getListFromDB() {
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList = getListOfBooks();
		ArrayList<Item> articleList = new ArrayList<Item>();
		articleList = getListOfArticles();
		for (int i = 0; i < articleList.size(); i++) {
			itemList.add(articleList.get(i));
		}
		return itemList;
	}

	/**
	 * Adds the borrower.
	 *
	 * @param name the name
	 * @param email the email
	 * @param status the status
	 */
	public void addBorrower(String name, String email, String status) {
		db.openDatabase();
		sql = "INSERT INTO `borrower`( `name`, `email`, `status`) VALUES ('"
				+ name + "' , '" + email + "' , '" + status + "')";
		db.update(sql);
		db.closeDatabase();
	}

	/**
	 * Gets the list of borrowers.
	 *
	 * @return the list of borrowers
	 */
	public ArrayList<Borrower> getListOfBorrowers() {
		db.openDatabase();
		ArrayList<Borrower> borrowerList = new ArrayList<Borrower>();
		
		String sql = "SELECT `name`, `email`, `status` FROM borrower";
		ArrayList<Object[]> result = db.query(sql);
		
		for (int i = 0; i < result.size(); i++) {
			String name = (String) result.get(i)[0];
			String email = (String) result.get(i)[1];
			String status = (String) result.get(i)[2];

			Borrower readItem = new Borrower(name, email, status);
			borrowerList.add(readItem);
		}
		db.closeDatabase();
		return borrowerList;
	}

	/**
	 * Removes the by email.
	 *
	 * @param email the email
	 */
	public void removeByEmail(String email) {
		db.openDatabase();
		sql = "DELETE FROM `borrower` WHERE email = '" + email + "'";
		db.update(sql);
		db.closeDatabase();

	}

	/**
	 * Removes the item by id.
	 *
	 * @param itemID the item id
	 */
	public void removeItemById(int itemID) {
		Item item = ItemList.getItemByID(itemID);
		if (item != null) {

			if (item.equalsTo(item) == 1) {
				db.openDatabase();
				sql = "DELETE FROM `books` WHERE itemID =" + itemID;
				db.update(sql);
				db.closeDatabase();
			} else if (item.equalsTo(item) == 2) {
				db.openDatabase();
				sql = "DELETE FROM `article` WHERE itemID =" + itemID;
				db.update(sql);
				db.closeDatabase();
			}
		} else
			System.err.println("Item was not found in the List with ItemID: "
					+ itemID);
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

		// Convert MyDate to SQL date Format
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date parsed = format.parse(dateFrom.toString());
		java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
		db.openDatabase();
		sql = "INSERT INTO `reservation`( `email`, `itemID`, `dateFrom`,`reservationID`) VALUES ('"
				+ email
				+ "' , '"
				+ itemID
				+ "' , '"
				+ sqlDate
				+ "', '"
				+ reservationID + "')";
		db.update(sql);
		db.closeDatabase();

	}

	/**
	 * Gets the list of reservations.
	 *
	 * @return the list of reservations
	 */
	public ArrayList<Reservation> getListOfReservations() {

		db.openDatabase();
		ArrayList<Reservation> reservList = new ArrayList<Reservation>();

		String sql = "SELECT `email`, `itemID`, `dateFrom`,`reservationID` FROM reservation";
		ArrayList<Object[]> result = db.query(sql);

		for (int i = 0; i < result.size(); i++) {

			String email = (String) result.get(i)[0];
			int itemID = Integer.parseInt(result.get(i)[1].toString());

			// Read date from Database
			Date dateFrom = (Date) result.get(i)[2];
			int reservationID = Integer.parseInt(result.get(i)[3].toString());

			// Convert SQL date to MyDate
			MyDate date = new MyDate();
			MyDate dateFr = date.fromString(dateFrom.toString());

			Reservation readItem = new Reservation(email, dateFr,
					reservationID, itemID);
			reservList.add(readItem);
		}
		db.closeDatabase();
		return reservList;
	}

	/**
	 * Removes the reservation.
	 *
	 * @param reservationID the reservation id
	 */
	public void removeReservation(int reservationID) {
		Item item = ItemList.getItemByReservationID(reservationID);
		if (item != null) {

			if (item.equalsTo(item) == 1) {
				db.openDatabase();
				sql = "DELETE FROM `reservation` WHERE reservationID ="
						+ reservationID;
				db.update(sql);
				db.closeDatabase();

			}
		} else
			System.out.println("LibraryDatabaseAdapter.removeReservation()");
		System.err
				.println("Item was not found in the List with ReservationID: "
						+ reservationID);
	}

	/**
	 * Adds the borrowed item.
	 *
	 * @param dateFrom the date from
	 * @param dateTill the date till
	 * @param itemID the item id
	 * @param email the email
	 * @throws ParseException the parse exception
	 */
	public void addBorrowedItem(MyDate dateFrom, MyDate dateTill, int itemID,
			String email) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedFrom = format.parse(dateFrom.toString());
		java.sql.Date sqlDateFrom = new java.sql.Date(parsedFrom.getTime());

		Date parsedTill = format.parse(dateTill.toString());
		java.sql.Date sqlDateTill = new java.sql.Date(parsedTill.getTime());
		db.openDatabase();
		sql = "INSERT INTO `borroweditems`( `dateFrom`, `dateTo`, `itemID`,`email`) VALUES ('"
				+ sqlDateFrom
				+ "' , '"
				+ sqlDateTill
				+ "' , '"
				+ itemID
				+ "', '" + email + "')";
		db.update(sql);
		db.closeDatabase();
	}

	/**
	 * Gets the list of borrowed items.
	 *
	 * @return the list of borrowed items
	 */
	public ArrayList<BorrowedItem> getListOfBorrowedItems() {

		db.openDatabase();
		ArrayList<BorrowedItem> borrowedItemList = new ArrayList<BorrowedItem>();

		String sql = "SELECT `dateFrom`, `dateTo`, `itemID`,`email` FROM borroweditems";
		ArrayList<Object[]> result = db.query(sql);

		for (int i = 0; i < result.size(); i++) {

			// Read date from Database
			Date dateFrom = (Date) result.get(i)[0];
			Date dateTo = (Date) result.get(i)[1];
			int itemID = Integer.parseInt(result.get(i)[2].toString());
			String email = (String) result.get(i)[3];

			// Convert SQL date to MyDate
			MyDate date = new MyDate();
			MyDate mDateFrom = date.fromString(dateFrom.toString());
			MyDate mDateTill = date.fromString(dateTo.toString());

			BorrowedItem readItem = new BorrowedItem(mDateFrom, mDateTill,
					itemID, email);
			borrowedItemList.add(readItem);
		}
		db.closeDatabase();
		return borrowedItemList;
	}

	/**
	 * Return item.
	 *
	 * @param itemID the item id
	 */
	public void returnItem(int itemID) {

		if (ListOfBorrowedItems.isItemIDInList(itemID)) {

			db.openDatabase();
			sql = "DELETE FROM `borroweditems` WHERE itemID =" + itemID;
			db.update(sql);
			db.closeDatabase();

		} else
			System.out.println("LibraryDatabaseAdapter.returnItem()");
		System.err.println("Item was not found in the List with itemID: "
				+ itemID);
	}
	
}
