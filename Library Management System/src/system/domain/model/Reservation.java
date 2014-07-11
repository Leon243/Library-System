package system.domain.model;


// TODO: Auto-generated Javadoc
/**
 * The Class Reservation.
 */
public class Reservation {

	/** The email. */
	private String email;
	
	/** The date from. */
	private MyDate dateFrom;
	
	/** The reservation id. */
	private int reservationID;
	
	/** The item id. */
	private int itemID;

	/**
	 * Instantiates a new reservation.
	 *
	 * @param email the email
	 * @param dateFrom the date from
	 * @param reservationID the reservation id
	 * @param itemID the item id
	 */
	public Reservation(String email, MyDate dateFrom, int reservationID,
			int itemID) {
		super();
		this.email = email;
		this.dateFrom = dateFrom;
		this.reservationID = reservationID;
		this.itemID = itemID;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the date from.
	 * 
	 * @return the dateFrom
	 */
	public MyDate getDateFrom() {
		return dateFrom;
	}

	/**
	 * Gets the reservation id.
	 * 
	 * @return the reservationID
	 */
	public int getReservationID() {
		return reservationID;
	}

	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public int getItemID() {
		return itemID;
	}

	/**
	 * adds all information in one string.
	 *
	 * @return the string of reservation
	 */
	public String toString() {
		return "Reservation ID: " + getReservationID()
				+ ", Borrower by e-mail: " + getEmail() + ", Date: "
				+ getDateFrom() + ", Item ID: " + this.itemID;
	}

}
