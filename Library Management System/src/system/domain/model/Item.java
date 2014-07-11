package system.domain.model;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Item.
 */
public abstract class Item {
	
	/** The item id. */
	private int itemID;
	
	/** The author. */
	private String author;
	
	/** The title. */
	private String title;
	
	/** The book. */
	private Book book;
	
	/** The article. */
	private Article article;
	
	/** The reserv list. */
	private ReservationList reservList;

	/**
	 * Instantiates a new item.
	 * 
	 * @param itemID
	 *            the item id
	 * @param author
	 *            the author
	 * @param title
	 *            the title
	 */
	public Item(int itemID, String author, String title) {
		super();

		this.itemID = itemID;
		this.author = author;
		this.title = title;
		reservList = new ReservationList();

	}

	/**
	 * Gets the reserved item.
	 *
	 * @param reservationID the reservation id
	 * @return the reserved item
	 */
	public int getReservedItem(int reservationID) {
		for (int i = 0; i < reservList.getSize(); i++) {
			if (reservList.getListOfReservations().get(i).getReservationID() == reservationID) {
				return reservList.getListOfReservations().get(i).getItemID();
			}
		}

		return -1;
	}

	/**
	 * Gets the item id.
	 * 
	 * @return the itemID
	 */
	public int getItemID() {
		return itemID;
	}

	/**
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the isbn.
	 *
	 * @return the isbn
	 */
	public int getISBN() {
		return this.book.getISBN();
	}

	/**
	 * Gets the magazine.
	 *
	 * @return the magazine
	 */
	public String getMagazine() {
		return this.article.getMagazine();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public abstract String toString();

	/**
	 * Equals to.
	 *
	 * @param obj the obj
	 * @return the int
	 */
	public abstract int equalsTo(Object obj);

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
		ReservationList.addReservation(email, dateFrom, reservationID, itemID);
	}

	/**
	 * Gets the list of reservation.
	 *
	 * @return the list of reservation
	 */
	public ArrayList<Reservation> getListOfReservation() {

		return reservList.getListOfReservations();
	}
}
