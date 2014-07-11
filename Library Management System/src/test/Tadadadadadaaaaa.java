package test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import system.domain.model.BorrowedItem;
import system.domain.model.Borrower;
import system.domain.model.BorrowerList;
import system.domain.model.ItemList;
import system.domain.model.LateDelivery;
import system.domain.model.Library;
import system.domain.model.ListOfBorrowedItems;
import system.domain.model.MyDate;



// TODO: Auto-generated Javadoc
/**
 * The Class Tadadadadadaaaaa.
 */
public class Tadadadadadaaaaa {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ParseException the parse exception
	 */
	public static void main(String[] args) throws ParseException {

		MyDate dateFrom = new MyDate();
		MyDate dateTill = new MyDate();
		Library library = new Library();
//		library.addBorrower("Ice", "Tea", "Bread");
//		library.borrowAnItem(dateFrom, dateTill, 11, "emailKKKK");
//		System.out.println(library.getAllBorrowedItems());
//		library.borrowAnItem( 11, "www.ffs.sk");
//		System.out.println(dateFrom.toString());
//		System.out.println(dateFrom.stepForwardMonths(6).toString());
//		library.getAllBorrowedItems();
		int itemID = 11;
		String email = "www.FFS.sk";
		System.out.println(ItemList.isItemIDInList(itemID));
			System.out.println(BorrowerList.isBorrowerInList(email));
				System.out.println(!(ItemList.isItemReserved(itemID)));
//				System.out.println(!(isItemIDInList(itemID)));
				
				LateDelivery late = new LateDelivery("asdasd", 222, dateTill);
				late.setStatus(4);
				System.out.println(late.getStatus());
		
		
	}

}
