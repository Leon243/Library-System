package system.domain.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Borrower.
 */
public class Borrower {

	/** The name. */
	private String name;
	
	/** The email. */
	private String email;
	
	/** The status. */
	private String status;

	/**
	 * Instantiates a new borrower.
	 *
	 * @param name the name
	 * @param email the email
	 * @param status the status
	 */
	public Borrower(String name, String email, String status) {
		super();
		this.name = name;
		this.email = email;
		this.status = status;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Borrower name: " + getName() + ", e-mail: " + getEmail()
				+ ", status: " + getStatus();
	}

}
