package system.domain.model;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class LateDeliveryList.
 */
public class LateDeliveryList {

	/** The late delivery list. */
	private ArrayList<LateDelivery> lateDeliveryList;

	/**
	 * Instantiates a new late delivery list.
	 */
	public LateDeliveryList() {
		lateDeliveryList = new ArrayList<LateDelivery>();
	}

	/**
	 * Adds the late delivery.
	 *
	 * @param email the email
	 * @param itemID the item id
	 * @param date the date
	 */
	public void addLateDelivery(String email, int itemID, MyDate date) {
		LateDelivery late = new LateDelivery(email, itemID, date);
		lateDeliveryList.add(late);
	}

	/**
	 * Gets the late deliveries.
	 *
	 * @return the late deliveries
	 */
	public ArrayList<LateDelivery> getLateDeliveries() {
		return lateDeliveryList;
	}

	/**
	 * Removes the from late delivery list.
	 *
	 * @param itemID the item id
	 * @return the late delivery
	 */
	public LateDelivery removeFromLateDeliveryList(int itemID) {
		for (int i = 0; i < lateDeliveryList.size(); i++) {
			if (lateDeliveryList.get(i).getItemID() == itemID) {
				return lateDeliveryList.remove(i);
			}
		}
		return null;
	}

	/**
	 * Email time.
	 *
	 * @param date the date
	 * @return the int
	 */
	public int emailTime(MyDate date) {
		int fourDays = 4;
		int twoDays = 2;
		int deadLine = 0;

		if (date.daysBetween(MyDate.now()) <= deadLine) {
			return 0;
		} else if (date.daysBetween(MyDate.now()) <= 2) {
			return twoDays;
		} else if (date.daysBetween(MyDate.now()) <= 4) {
			return fourDays;
		} else
			return -1;
	}

	/**
	 * Checks if is item borrowed.
	 *
	 * @param itemID the item id
	 * @return true, if is item borrowed
	 */
	public boolean isItemBorrowed(int itemID) {
		return ListOfBorrowedItems.isItemIDInList(itemID);
	}
	
	/**
	 * Gets the late delivery by status.
	 *
	 * @param status the status
	 * @return the late delivery by status
	 */
	public LateDelivery getLateDeliveryByStatus(int status)
	{
		for (int i = 0; i < lateDeliveryList.size(); i++) {
			if(lateDeliveryList.get(i).getStatus() == status)
			{
				return lateDeliveryList.get(i);
			}
			
		}
		return null;
	}

	// check what is the date in Borrowed item list
	// take item id and check

}
