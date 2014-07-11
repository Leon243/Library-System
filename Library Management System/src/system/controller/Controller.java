package system.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;

import system.domain.model.Article;
import system.domain.model.Book;
import system.domain.model.BorrowedItem;
import system.domain.model.Borrower;
import system.domain.model.Item;
import system.domain.model.Library;
import system.domain.model.MyDate;
import system.domain.model.Reservation;
import system.view.LibraryGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements ActionListener
{
   
   /** The library. */
   private Library library;
   
   /** The gui. */
   private LibraryGUI gui;

   /**
    * Instantiates a new controller.
    *
    * @param library the library
    * @param gui the gui
    */
   public Controller(Library library, LibraryGUI gui)
   {
      this.library = library;
      this.gui = gui;
   }

   /* (non-Javadoc)
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   public void actionPerformed(ActionEvent event)
   {
      String mode = ((JButton) event.getSource()).getText();
      if (mode.equals(LibraryGUI.TITLE_MODE))
      {
         gui.setMode(LibraryGUI.TITLE_MODE);
      }
      else if (gui.getMode().equals(LibraryGUI.TITLE_MODE))
      {
         gui.setMode(mode);
      }

      // /////////////////////////////////////////////// SHOW RESERVATIONS
      // ////////////////////

      else if (mode.equals(LibraryGUI.SHOW_RESERVATIONS_MODE))
      {
         gui.setMode(LibraryGUI.SHOW_RESERVATIONS_MODE);
         String text = library.getAllReservations();
         gui.setText(text);
         gui.setMode(LibraryGUI.SHOW_RESERVATIONS_MODE);
      }

      // /////////////////////////////////////// SHOW LATE DELIVERIES
      // ///////////
      else if (mode.equals(LibraryGUI.LATEDELIVERIES_MODE))
      {
         gui.setMode(LibraryGUI.LATEDELIVERIES_MODE);
         String text = library.lateDeliveries();
         gui.setText(text);
      }
      else if (gui.getMode().equals(LibraryGUI.LATEDELIVERIES_MODE))
      {
         gui.setMode(mode);
      }

      // //////////////////////////////////////// RESERVE
      // ////////////////////////////////////////

      else if (mode.equals(LibraryGUI.RESERVE_MODE))
      {
         String[] input = gui.getInput();
         MyDate dateFrom = new MyDate();
         int itemID = Integer.parseInt(input[1]);
         int reservationID = Integer.parseInt(input[3]);
         String email = (String) input[0];
         Reservation reservation = new Reservation(email, dateFrom,
               reservationID, itemID);
         // validate - should be a method in the model
         if (input[0].equals("") || input[1].equals("") || dateFrom == null
               || input[3].equals(""))
         {
            gui.setErrorText("Wrong input format");
         }
         else
         {
            try
            {
               library.addReservation(email, dateFrom, reservationID, itemID);
            }
            catch (ParseException e)
            {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            gui.setText("Added: " + reservation);
            gui.setMode(LibraryGUI.TITLE_MODE);
         }
      }

      // //////////////////////////////////////// REMOVE RESERVATION
      // ////////////////////////////////////////

      else if (mode.equals(LibraryGUI.REMOVERESERVATION_MODE))
      {
         int reservationID = -1;
         Reservation reservation = null;

         String input = gui.getInput()[0];

         try
         {
            reservationID = Integer.parseInt(input);
         }
         catch (Exception e)
         {
            input = "";
         }

         // validate
         if (input.equals("") || reservationID < 0)
         {
            gui.setErrorText("Wrong input format");
         }
         else
         {
            reservation = library.removeRservationById(reservationID);
            if (reservation != null)
            {
               gui.setText("Removed: " + reservation);
            }
            else
            {
               gui.setText("No reservation has been removed");
            }
            gui.setMode(LibraryGUI.TITLE_MODE);
         }
      }

      // ////////////////////////////////////// ADD BORROWER ////////////

      else if (mode.equals(LibraryGUI.ADDBORROWER_MODE))
      {
         String[] input = gui.getInput();
         String name = (String) input[0];
         String email = (String) input[1];
         String status = (String) input[2];
         Borrower borrower = new Borrower(name, email, status);
         // validate - should be a method in the model
         if (name.equals("") || email.equals("") || status.equals(""))
         {
            gui.setErrorText("Wrong input format");
         }
         else
         {
            library.addBorrower(name, email, status);
            gui.setText("Borrower Added: " + borrower.toString());
            gui.setMode(LibraryGUI.TITLE_MODE);
         }
      }

      // //////////////////////////////////////// ADD BOOK
      // //////////////////////////////////////

      else if (mode.equals(LibraryGUI.ADDBOOK_MODE))
      {
         String[] input = gui.getInput();
         int itemID = Integer.parseInt(input[0]);
         int ISBN = Integer.parseInt(input[3]);
         String author = (String) input[1];
         String title = (String) input[2];

         Book book = new Book(itemID, author, title, ISBN);
         // validate - should be a method in the model
         if (itemID < 0 || author.equals("") || title.equals("") || ISBN < 0)
         {
            gui.setErrorText("Wrong input format");
         }
         else
         {
            library.addBook(itemID, author, title, ISBN);
            gui.setText("Book Added: " + book.toString());
            gui.setMode(LibraryGUI.TITLE_MODE);
         }
      }

      // //////////////////////////////////////// ADD ARTICLE
      // ////////////////////////////////////////

      else if (mode.equals(LibraryGUI.ADDARTICLE_MODE))
      {
         String[] input = gui.getInput();
         int itemID = Integer.parseInt(input[0]);
         String author = (String) input[1];
         String title = (String) input[2];
         String magazine = (String) input[3];
         Article article = new Article(itemID, author, title, magazine);
         // validate - should be a method in the model
         if (itemID < 0 || author.equals("") || title.equals("")
               || magazine.equals(""))
         {
            gui.setErrorText("Wrong input format");
         }
         else
         {
            library.addArticle(itemID, author, title, magazine);
            gui.setText("Article Added: " + article.toString());
            gui.setMode(LibraryGUI.TITLE_MODE);
         }
      }

      // //////////////////////////////////////// REMOVE ITEM
      // ////////////////////////////////////////

      else if (mode.equals(LibraryGUI.REMOVE_MODE))
      {
         int itemID = -1;
         Item item = null;

         String input = gui.getInput()[0];

         try
         {
            itemID = Integer.parseInt(input);
         }
         catch (Exception e)
         {
            input = "";
         }

         // validate
         if (input.equals("") || itemID < 0)
         {
            gui.setErrorText("Wrong input format");
         }
         else
         {
            item = library.removeItemById(itemID);
            if (item != null)
            {
               gui.setText("Removed: " + item);
            }
            else
            {
               gui.setText("No item has been removed");
            }
            gui.setMode(LibraryGUI.TITLE_MODE);
         }
      }

      // //////////////////////////////////////// SEARCH FOR ITEM BY TITLE
      // ////////////////////////////////////////

      else if (mode.equals(LibraryGUI.SEARCH_MODE))
      {
         String title = "";
         String item = null;

         String input = gui.getInput()[0];

         try
         {
            title = input;
         }
         catch (Exception e)
         {
            input = "";
         }

         // validate
         if (input.equals("") || title == null)
         {
            gui.setErrorText("Wrong input format");
         }
         else
         {
            item = library.searchByTitle(title);
            if (item != null)
            {
               gui.setText("Found: " + item);
            }
            else
            {
               gui.setText("No items of searched title found");
            }
            gui.setMode(LibraryGUI.TITLE_MODE);
         }
      }

      // ////////////////////////////////////// LEND ITEM ////////////////////

      else if (mode.equals(LibraryGUI.LEND_MODE)) {
         String[] input = gui.getInput();
         int itemID = Integer.parseInt(input[0]);
         String email = (String) input[1];

         // BorrowedItem item = new BorrowedItem(itemID, email);
         // validate - should be a method in the model
         if (itemID < 1 || email.equals("")) {
            gui.setErrorText("Wrong input format");
         } else {
            try {
               library.borrowAnItem(itemID, email);
               // gui.setText("Borrowed: " + item);
            } catch (ParseException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            gui.setMode(LibraryGUI.TITLE_MODE);
         }
      }

      // ///////////////////////////////////// RETURN ITEM
      // //////////////////////

      else if (mode.equals(LibraryGUI.RETURN_MODE))
      {
         int itemID = -1;
         BorrowedItem item = null;

         String input = gui.getInput()[0];

         try
         {
            itemID = Integer.parseInt(input);
         }
         catch (Exception e)
         {
            input = "";
         }

         // validate
         if (input.equals("") || itemID < 0)
         {
            gui.setErrorText("Wrong input format");
         }
         else
         {
            item = library.returnAnItem(itemID);
            if (item != null)
            {
               gui.setText("Returned: " + item);
            }
            else
            {
               gui.setText("No item has been returned");
            }
            gui.setMode(LibraryGUI.TITLE_MODE);
         }
      }
   }
}