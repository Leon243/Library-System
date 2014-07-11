package system.domain.model;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class BorrowerList.
 */
public class BorrowerList {

	/** The borrower list. */
	private static ArrayList<Borrower> borrowerList;

	/**
	 * Instantiates a new borrower list.
	 */
	public BorrowerList() {
		borrowerList = new ArrayList<Borrower>();
	}

	/**
	 * Adds the borrower.
	 * 
	 * @param name
	 *            the name
	 * @param email
	 *            the email
	 * @param status
	 *            the status
	 */
	public static void addBorrower(String name, String email, String status) {
		if (!isBorrowerInList(email)) {
			Borrower borower = new Borrower(name, email, status);
			borrowerList.add(borower);
		}
	}
	
	/**
	 * Adds the from database.
	 *
	 * @param borrower the borrower
	 */
	public static void addFromDatabase(Borrower borrower)
	{
		borrowerList.add(borrower);
	}

	/**
	 * Gets the borrower by email.
	 * 
	 * @param email
	 *            the email
	 * @return the borrower by email
	 */
	public static Borrower getBorrowerByEmail(String email) {
		if (!isEmpty()) {
			for (int i = 0; i < borrowerList.size(); i++) {
				if (email.equals(borrowerList.get(i).getEmail())) {
					return borrowerList.get(i);
				}
			}
		}
		return null;
	}

	/**
	 * Removes the by email.
	 * 
	 * @param email
	 *            the email
	 */
	public static void removeByEmail(String email) {
		if (!isEmpty()) {
			for (int i = 0; i < borrowerList.size(); i++) {
				if (email.equals(borrowerList.get(i).getEmail())) {
					borrowerList.remove(i);
				}
			}
		}
	}

	/**
	 * Checks if is borrower in list.
	 * 
	 * @param email
	 *            the email
	 * @return true, if is borrower in list
	 */
	public static boolean isBorrowerInList(String email) {
		if (!isEmpty())

			for (int i = 0; i < borrowerList.size(); i++) {
				if (borrowerList.get(i).getEmail().equalsIgnoreCase(email)) {
					return true;
				}
			}

		return false;
	}

	/**
	 * Checks if is empty.
	 * 
	 * @return true, if is empty
	 */
	public static boolean isEmpty() {
		if (borrowerList.size() < 1) {
			return true;
		}
		return false;
	}

	/**
	 * List all borrowers.
	 *
	 * @return the string
	 */
	public String listAllBorrowers() {
		String s = "";
		for (int i = 0; i < borrowerList.size(); i++) {
			s += borrowerList.get(i).toString();
		}
		return s;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "";
		if (borrowerList.size() > 0) {

			for (int i = 0; i < borrowerList.size(); i++) {
				s += borrowerList.get(i) + "\n";
			}
		} else
			return "no borrower in this list";
		return s;
	}
}
