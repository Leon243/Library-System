package test;

import java.text.ParseException;
import java.util.ArrayList;

import system.database.LibraryDatabaseAdapter;
import system.domain.model.Borrower;
import system.domain.model.BorrowerList;
import system.domain.model.Item;
import system.domain.model.ItemList;
import system.domain.model.Library;


// TODO: Auto-generated Javadoc
/**
 * The Class TestWithSQL.
 */
public class TestWithSQL {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ParseException the parse exception
	 */
	public static void main(String[] args) throws ParseException {

		Library library = new Library();
		// library.addBook(444, "123", "555555555", 000000000);
		System.out.println(library.searchByTitle("555555555"));
		
		ItemList list = new ItemList();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(list.listOfItem());
//		LibraryDatabaseAdapter libAdap = new LibraryDatabaseAdapter();
//		ArrayList<Item> itemList = new ArrayList<Item>();
//		itemList = libAdap.getListFromDB();
//		for (int i = 0; i < itemList.size(); i++) {
//			System.out.println(itemList.get(i).toString());
//		}
//		System.out.println();
//		System.out
//				.println("*****************************************************************");
//		System.out.println();
//		
//		ArrayList<Borrower> borrowerList = new ArrayList<Borrower>();
//		borrowerList = libAdap.getListOfBorrowers();
//		library.addBorrower("Atis", "atis.sirmais@gmail.com", "student");
//		library.removeItemById(123);
//		itemList = libAdap.getListFromDB();
//		for (int i = 0; i < itemList.size(); i++) {
//			System.out.println(itemList.get(i).toString());
//		}

	}
}
