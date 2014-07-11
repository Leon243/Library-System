package system.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryGUISearchForReservationsPanel.
 */
public class LibraryGUISearchForReservationsPanel extends JPanel
{
   
   /** The show res button panel. */
   private ButtonPanel showResButtonPanel;
   
   /** The text area. */
   private JTextArea textArea;

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
   
   /** The Constant SHOWRESERVATIONS_MODE. */
   public static final String SHOWRESERVATIONS_MODE = "Show Reservations";
   
   /** The Constant ADDBORROWER_MODE. */
   public static final String ADDBORROWER_MODE = "Add Borrower";

   /**
    * Instantiates a new library gui search for reservations panel.
    */
   public LibraryGUISearchForReservationsPanel()
   {
      createComponents();
      addComponentsToPanel();
   }

   /**
    * Sets the text.
    *
    * @param text the new text
    */
   public void setText(String text)
   {
      textArea.setText(text);
   }

   /**
    * Gets the button panel.
    *
    * @return the button panel
    */
   public ButtonPanel getButtonPanel()
   {
      return showResButtonPanel;
   }

   /**
    * Gets the text area.
    *
    * @return the text area
    */
   public JTextArea getTextArea()
   {
      return textArea;
   }

   /**
    * Creates the components.
    */
   private void createComponents()
   {
      textArea = new JTextArea(3, 5);
      showResButtonPanel = new ButtonPanel(new FlowLayout(), RESERVE_MODE,
            REMOVERESERVATION_MODE, SHOWRESERVATIONS_MODE, ADDBOOK_MODE,
            ADDARTICLE_MODE, REMOVE_MODE, SEARCH_MODE, LEND_MODE, RETURN_MODE,
            LATEDELIVERIES_MODE, ADDBORROWER_MODE);
      textArea.setText("Press the buttons");
      textArea.setEditable(false);
   }

   /**
    * Adds the components to panel.
    */
   private void addComponentsToPanel()
   {
      setLayout(new BorderLayout());
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      add(showResButtonPanel, BorderLayout.SOUTH);
   }
}
