package system.domain.model;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ListOfBorrowedItems.
 */
public class ListOfBorrowedItems {
	
	/** The borrowed item. */
	private static ArrayList<BorrowedItem> borrowedItem;

	/**
	 * Instantiates a new list of borrowed items.
	 */
	public ListOfBorrowedItems() {
		borrowedItem = new ArrayList<BorrowedItem>();

	}

	/**
	 * Copy from database.
	 *
	 * @param dateFrom the date from
	 * @param dateTill the date till
	 * @param itemID the item id
	 * @param email the email
	 */
	public void copyFromDatabase(MyDate dateFrom, MyDate dateTill, int itemID,
			String email) {
		BorrowedItem newBorrowedItem = new BorrowedItem(dateFrom, dateTill,
				itemID, email);
		borrowedItem.add(newBorrowedItem);
	}

	/**
	 * Borrow an item.
	 *
	 * @param dateFrom the date from
	 * @param dateTill the date till
	 * @param itemID the item id
	 * @param email the email
	 */
	public static void borrowAnItem(MyDate dateFrom, MyDate dateTill,
			int itemID, String email) {
		if (ItemList.isItemIDInList(itemID)
				&& BorrowerList.isBorrowerInList(email)
				&& !(ItemList.isItemReserved(itemID))
				&& !(isItemIDInList(itemID))) {

			BorrowedItem newBorrowedItem = new BorrowedItem(dateFrom, dateTill,
					itemID, email);
			borrowedItem.add(newBorrowedItem);
		} else {
			System.out.println("ListOfBorrowedItems.borrowAnItem()");
			System.err.println("  The item ID: " + itemID
					+ " or \n  The Borrower email is wrong: " + email);
		}
	}

	/**
	 * Return item.
	 *
	 * @param itemID the item id
	 * @return the borrowed item
	 */
	public static BorrowedItem returnItem(int itemID) {
		if (!isEmpty()) {
			for (int i = 0; i < borrowedItem.size(); i++) {
				if (borrowedItem.get(i).getItemID() == itemID) {
					return borrowedItem.remove(i);
				}
			}

		} else
			System.out.println("There is no such Item in List");
		return null;
	}

	/**
	 * Checks if is item id in list.
	 *
	 * @param itemID the item id
	 * @return true, if is item id in list
	 */
	public static boolean isItemIDInList(int itemID) {
		if (!isEmpty()) {
			for (int i = 0; i < borrowedItem.size(); i++) {
				if (borrowedItem.get(i).getItemID() == itemID) {
					return true;
				}
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "";
		if (!isEmpty()) {
			for (int i = 0; i < borrowedItem.size(); i++) {
				s += borrowedItem.get(i).toString() + "\n";
			}
		} else
			return "The Borroed Item List is Empty";
		return s;
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public static boolean isEmpty() {
		if (borrowedItem.size() < 1) {
			return true;
		} else
			return false;
	}

}
