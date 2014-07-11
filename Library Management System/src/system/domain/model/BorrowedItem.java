package system.domain.model;

// TODO: Auto-generated Javadoc
/**
 * The Class BorrowedItem.
 */
public class BorrowedItem {
	
	/** The date from. */
	private MyDate dateFrom;
	
	/** The date till. */
	private MyDate dateTill;
	
	/** The item id. */
	private int itemID;
	
	/** The email. */
	private String email;

	/**
	 * Instantiates a new borrowed item.
	 *
	 * @param dateFrom the date from
	 * @param dateTill the date till
	 * @param itemID the item id
	 * @param email the email
	 */
	public BorrowedItem(MyDate dateFrom, MyDate dateTill, int itemID,
			String email) {
		super();
		this.dateFrom = dateFrom;
		this.dateTill = dateTill;
		this.itemID = itemID;
		this.email = email;
	}

	/**
	 * Gets the date from.
	 *
	 * @return the date from
	 */
	public MyDate getDateFrom() {
		return dateFrom;
	}

	/**
	 * Gets the date till.
	 *
	 * @return the date till
	 */
	public MyDate getDateTill() {
		return dateTill;
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
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Borrower's e-mail: " + getEmail() + "\n" + "Borrowed Item ID: "
				+ getItemID() + "\n" + "Date From: " + getDateFrom() + "\n"
				+ "Date Till: " + getDateTill() + "\n";
	}
}
