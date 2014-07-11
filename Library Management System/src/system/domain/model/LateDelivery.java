package system.domain.model;

// TODO: Auto-generated Javadoc
/**
 * The Class LateDelivery.
 */
public class LateDelivery {
	
	/** The email. */
	private String email;
	
	/** The item id. */
	private int itemID;
	
	/** The date. */
	private MyDate date;
	
	/** The status. */
	private int status;

	/**
	 * Instantiates a new late delivery.
	 *
	 * @param email the email
	 * @param itemID the item id
	 * @param date the date
	 */
	public LateDelivery(String email, int itemID, MyDate date) {
		super();
		this.email = email;
		this.itemID = itemID;
		this.date = date;
		this.status = -1;
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
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public int getItemID() {
		return itemID;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public MyDate getDate() {
		return date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "";
		return s += this.date + " " + this.email + " " + this.itemID + " "
				+ this.status;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return this.status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
}
