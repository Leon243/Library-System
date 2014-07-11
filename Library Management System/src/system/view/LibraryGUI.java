package system.view;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import system.controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryGUI.
 */
public class LibraryGUI extends JFrame
{
   
   /** The late deliveries panel. */
   private LibraryGUILateDeliveriesPanel lateDeliveriesPanel;
   
   /** The lend panel. */
   private LibraryGUILendPanel lendPanel;
   
   /** The return item panel. */
   private LibraryGUIReturnItemPanel returnItemPanel;
   
   /** The add reservation panel. */
   private LibraryGUIAddReservationPanel addReservationPanel;
   
   /** The remove reservation panel. */
   private LibraryGUIRemoveReservationPanel removeReservationPanel;
   
   /** The output res panel. */
   private LibraryGUIOutputReservationsPanel outputResPanel;
   
   /** The search panel. */
   private LibraryGUISearchPanel searchPanel;
   
   /** The add book panel. */
   private LibraryGUIAddBookPanel addBookPanel;
   
   /** The add article panel. */
   private LibraryGUIAddArticlePanel addArticlePanel;
   
   /** The remove item panel. */
   private LibraryGUIRemoveItemPanel removeItemPanel;
   
   /** The add borrower panel. */
   private LibraryGUIAddBorrowerPanel addBorrowerPanel;
   
   /** The main menu panel. */
   private LibraryGUITitlePanel mainMenuPanel;
   
   /** The card panel. */
   private JPanel cardPanel;
   
   /** The card layout. */
   private CardLayout cardLayout;
   
   /** The mode. */
   private String mode;

   /** The Constant RESERVE_MODE. */
   public static final String RESERVE_MODE = "Reserve";
   
   /** The Constant REMOVERESERVATION_MODE. */
   public static final String REMOVERESERVATION_MODE = "Remove Reservation";
   
   /** The Constant SEARCH_MODE. */
   public static final String SEARCH_MODE = "Search";
   
   /** The Constant LATEDELIVERIES_MODE. */
   public static final String LATEDELIVERIES_MODE = "Late Deliveries";
   
   /** The Constant LEND_MODE. */
   public static final String LEND_MODE = "Borrow Item";
   
   /** The Constant RETURN_MODE. */
   public static final String RETURN_MODE = "Return Item";
   
   /** The Constant ADDBOOK_MODE. */
   public static final String ADDBOOK_MODE = "Add Book";
   
   /** The Constant ADDARTICLE_MODE. */
   public static final String ADDARTICLE_MODE = "Add Article";
   
   /** The Constant REMOVE_MODE. */
   public static final String REMOVE_MODE = "Remove Item";
   
   /** The Constant SHOW_RESERVATIONS_MODE. */
   public static final String SHOW_RESERVATIONS_MODE = "Show Reservations";
   
   /** The Constant ADDBORROWER_MODE. */
   public static final String ADDBORROWER_MODE = "Add Borrower";
   
   /** The Constant TITLE_MODE. */
   public static final String TITLE_MODE = "Main Menu";

   /**
    * Instantiates a new library gui.
    */
   public LibraryGUI()
   {
      super("Library GUI");

      createComponents();
      initializeComponents();
      addComponentsToFrame();
   }

   /**
    * Start gui.
    *
    * @param controller the controller
    */
   public void startGui(Controller controller)
   {
      mainMenuPanel.getButtonPanel().addActionListenerToAllButtons(controller);
      addBookPanel.getButtonPanel().addActionListenerToAllButtons(controller);
      addArticlePanel.getButtonPanel()
            .addActionListenerToAllButtons(controller);
      outputResPanel.getButtonPanel().addActionListenerToAllButtons(controller);
      addReservationPanel.getButtonPanel().addActionListenerToAllButtons(
            controller);
      removeReservationPanel.getButtonPanel().addActionListenerToAllButtons(
            controller);
      searchPanel.getButtonPanel().addActionListenerToAllButtons(controller);
      removeItemPanel.getButtonPanel()
            .addActionListenerToAllButtons(controller);
      lendPanel.getButtonPanel().addActionListenerToAllButtons(controller);
      returnItemPanel.getButtonPanel()
            .addActionListenerToAllButtons(controller);
      lateDeliveriesPanel.getButtonPanel().addActionListenerToAllButtons(
            controller);
      addBorrowerPanel.getButtonPanel().addActionListenerToAllButtons(
            controller);
      setVisible(true);
   }

   /**
    * Sets the text.
    *
    * @param text the new text
    */
   public void setText(String text)
   {
      outputResPanel.setText(text);
      searchPanel.setText(text);
      lateDeliveriesPanel.setText(text);
      mainMenuPanel.setText(text);
   }

   /**
    * Sets the mode.
    *
    * @param mode the new mode
    */
   public void setMode(String mode)
   {
      this.mode = mode;
      cardLayout.show(cardPanel, mode);

      if (mode.equals(RESERVE_MODE))
      {
         addReservationPanel.clear();
         addReservationPanel.getTextFieldPanel().getTextField(0).requestFocus();
      }
      else if (mode.equals(REMOVERESERVATION_MODE))
      {
         removeReservationPanel.clear();
         removeReservationPanel.getTextFieldPanel().getTextField(0)
               .requestFocus();
      }
      else if (mode.equals(ADDBOOK_MODE))
      {
         addBookPanel.clear();
         addBookPanel.getTextFieldPanel().getTextField(0).requestFocus();
      }
      else if (mode.equals(ADDARTICLE_MODE))
      {
         addArticlePanel.clear();
         addArticlePanel.getTextFieldPanel().getTextField(0).requestFocus();
      }
      else if (mode.equals(REMOVE_MODE))
      {
         removeItemPanel.clear();
         removeItemPanel.getTextFieldPanel().getTextField(0).requestFocus();
      }
      else if (mode.equals(SEARCH_MODE))
      {
         searchPanel.clear();
         searchPanel.getTextFieldPanel().getTextField(0).requestFocus();
      }
      else if (mode.equals(LEND_MODE))
      {
         lendPanel.clear();
         lendPanel.getTextFieldPanel().getTextField(0).requestFocus();
      }
      else if (mode.equals(RETURN_MODE))
      {
         returnItemPanel.clear();
         returnItemPanel.getTextFieldPanel().getTextField(0).requestFocus();
      }
      else if (mode.equals(ADDBORROWER_MODE))
      {
         addBorrowerPanel.clear();
         addBorrowerPanel.getTextFieldPanel().getTextField(0).requestFocus();
      }
   }

   /**
    * Gets the mode.
    *
    * @return the mode
    */
   public String getMode()
   {
      return mode;
   }

   /**
    * Gets the input.
    *
    * @return the input
    */
   public String[] getInput()
   {
      if (mode.equals(RESERVE_MODE))
         return addReservationPanel.getInput();
      else if (mode.equals(REMOVERESERVATION_MODE))
         return removeReservationPanel.getInput();
      else if (mode.equals(ADDBOOK_MODE))
         return addBookPanel.getInput();
      else if (mode.equals(ADDARTICLE_MODE))
         return addArticlePanel.getInput();
      else if (mode.equals(REMOVE_MODE))
         return removeItemPanel.getInput();
      else if (mode.equals(SEARCH_MODE))
         return searchPanel.getInput();
      else if (mode.equals(LEND_MODE))
         return lendPanel.getInput();
      else if (mode.equals(RETURN_MODE))
         return returnItemPanel.getInput();
      else if (mode.equals(ADDBORROWER_MODE))
         return addBorrowerPanel.getInput();
      return null;
   }

   /**
    * Sets the error text.
    *
    * @param message the new error text
    */
   public void setErrorText(String message)
   {
      addBookPanel.setErrorMessage(message);
      addArticlePanel.setErrorMessage(message);
      addReservationPanel.setErrorMessage(message);
      removeReservationPanel.setErrorMessage(message);
      searchPanel.setErrorMessage(message);
      removeItemPanel.setErrorMessage(message);
      lendPanel.setErrorMessage(message);
      returnItemPanel.setErrorMessage(message);
      addBorrowerPanel.setErrorMessage(message);
   }

   /**
    * Creates the components.
    */
   private void createComponents()
   {
      outputResPanel = new LibraryGUIOutputReservationsPanel();
      addReservationPanel = new LibraryGUIAddReservationPanel();
      removeReservationPanel = new LibraryGUIRemoveReservationPanel();
      searchPanel = new LibraryGUISearchPanel();
      removeItemPanel = new LibraryGUIRemoveItemPanel();
      addBookPanel = new LibraryGUIAddBookPanel();
      addArticlePanel = new LibraryGUIAddArticlePanel();
      lendPanel = new LibraryGUILendPanel();
      returnItemPanel = new LibraryGUIReturnItemPanel();
      lateDeliveriesPanel = new LibraryGUILateDeliveriesPanel();
      addBorrowerPanel = new LibraryGUIAddBorrowerPanel();
      mainMenuPanel = new LibraryGUITitlePanel();

      cardLayout = new CardLayout();
      cardPanel = new JPanel(cardLayout);

      mode = TITLE_MODE;
   }

   /**
    * Initialize components.
    */
   private void initializeComponents()
   {
      setSize(1300, 600); // set frame size
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   /**
    * Adds the components to frame.
    */
   private void addComponentsToFrame()
   {
      cardPanel.add(mainMenuPanel, TITLE_MODE);
      cardPanel.add(outputResPanel, SHOW_RESERVATIONS_MODE);
      cardPanel.add(addReservationPanel, RESERVE_MODE);
      cardPanel.add(removeReservationPanel, REMOVERESERVATION_MODE);
      cardPanel.add(searchPanel, SEARCH_MODE);
      cardPanel.add(removeItemPanel, REMOVE_MODE);
      cardPanel.add(addBookPanel, ADDBOOK_MODE);
      cardPanel.add(addArticlePanel, ADDARTICLE_MODE);
      cardPanel.add(lendPanel, LEND_MODE);
      cardPanel.add(returnItemPanel, RETURN_MODE);
      cardPanel.add(lateDeliveriesPanel, LATEDELIVERIES_MODE);
      cardPanel.add(addBorrowerPanel, ADDBORROWER_MODE);

      setContentPane(cardPanel);
   }
}
