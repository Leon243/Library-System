package test;

import java.text.ParseException;

import system.domain.model.Book;
import system.domain.model.BorrowedItem;
import system.domain.model.BorrowerList;
import system.domain.model.ItemList;
import system.domain.model.Library;
import system.domain.model.ListOfBorrowedItems;
import system.domain.model.MyDate;
import system.domain.model.ReservationList;

// TODO: Auto-generated Javadoc
/**
 * The Class TestClass.
 */
public class TestClass {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ParseException the parse exception
	 */
	public static void main(String[] args) throws ParseException {

		Library library = new Library();
		// LibraryDatabaseAdapter libdata = new LibraryDatabaseAdapter();
		// list.addBook(123, "123", "321", 2222);
		// list.addBook(333, "asd", "asd", 12333);
		// libdata.addBook(list.getItemByID(333));
		// System.out.println(list.getItemByID(333));
		library.addBook(3333, "Karlis", "LoL", 134888788);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"
				+ ItemList.getItemByID(3333));
		library.addBook(22, "Gatis", "Ideja", 123123123);
		library.addArticle(23, "Martins", "Get Shit Done", "FEBE");
		System.out.println(library.listOfItem());

		BorrowerList broList = new BorrowerList();
		broList.addBorrower("Gatis", "www.asd.asd@asd", "Student");
		broList.addBorrower("Gatis", "www.asd.asd@asd", "Student");
		// broList.removeByEmail("www.asd.asd@asd");
		// broList.removeByEmail("www.asd.asd@asd");
		System.out.println(broList.toString());

		Book book = new Book(123, "asd", "asd", 1234555);
		System.out.println(book);
		// System.out.println("***************************************");
		// System.out.println(list.listOfItem());
		System.out.println();
		System.out
				.println("****************Test Reservation*******************************");

		System.out.println("is this email in the list = "
				+ BorrowerList.isBorrowerInList("www.asd.asd@asd"));
		System.out.println("BorrowerList is empty = " + BorrowerList.isEmpty());
		System.out.println("is this item id in the list = "
				+ ItemList.isItemIDInList(22));
		MyDate dateFrom = new MyDate(23, 03, 2013);
		MyDate dateTo = new MyDate(23, 9, 2013);
		// resList.addReservation(email, itemID, dateFrom, reservationID)
		// resList.addReservation("www.asd.asd@asd", 22, dateFrom, 1544);

		System.out.println();
		System.out
				.println("********************Test Borrowed Item*************************");

		BorrowedItem item1 = new BorrowedItem(dateFrom, dateTo, 22,
				"www.asd.asd@asd");
		System.out.println(item1.toString());

		System.out.println();
		System.out
				.println("********************Test Borrowed Item List*************************");

		ListOfBorrowedItems borowList = new ListOfBorrowedItems();
		borowList.borrowAnItem(dateFrom, dateTo, 22, "www.asd.asd@asd");
		borowList.borrowAnItem(dateFrom, dateTo, 22, "www.asd.asd@asd");
		borowList.borrowAnItem(dateFrom, dateTo, 22, "www.asd.asd@asd");

		System.out.println(borowList.toString());
		borowList.returnItem(22);
		System.out.println("**************************");
		System.out.println("Just one item \n" + borowList.toString());
		borowList.returnItem(22);
		System.out.println(borowList.toString());
		borowList.returnItem(22);

		System.out
				.println("***************************** Test the Library ********************");

		System.out
				.println("************* test search by title and add/remove ************");
		library.addBook(666, "Lubo", "The Passage", 12345555);
		library.addArticle(11, "Roman", "PlayBoy", "Kokoting");
		System.out.println(library.listOfItem());
		library.removeItemById(666);
		System.out.println(library.searchByTitle("The Passage"));
		System.out.println(library.searchByTitle("Get Shit Done"));
		System.out.println();
		System.out.println("************* test Reservation ************");
		System.out.println();
		library.addReservation("www.asd.asd@asd", dateFrom, 22, 44);
		System.out.println("\n");
		System.out.println("*********************************");
		library.addReservation("gfdgfdg@asdasd@asd", dateTo, 22, 98);
//		System.out.println(library.getReservations(22));
	}
}
