package system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryGUIAddReservationPanel.
 */
public class LibraryGUIAddReservationPanel extends JPanel
{
   
   /** The add button panel. */
   private ButtonPanel addButtonPanel;
   
   /** The text field panel for reserving. */
   private TextFieldPanel textFieldPanelForReserving;
   
   /** The error label. */
   private JLabel errorLabel;

   /** The Constant RESERVE_MODE. */
   public static final String RESERVE_MODE = "Reserve";
   
   /** The Constant TITLE_MODE. */
   public static final String TITLE_MODE = "Main Menu";

   /** The Constant ITEMID. */
   private static final String ITEMID = "ItemID";
   
   /** The Constant EMAIL. */
   private static final String EMAIL = "Email";
   
   /** The Constant DATE_FROM. */
   private static final String DATE_FROM = "Date From";
   
   /** The Constant RESERVATION_ID. */
   private static final String RESERVATION_ID = "Reservation ID";

   /**
    * Instantiates a new library gui add reservation panel.
    */
   public LibraryGUIAddReservationPanel()
   {
      createComponents();
      addComponentsToPanel();
   }

   /**
    * Gets the button panel.
    *
    * @return the button panel
    */
   public ButtonPanel getButtonPanel()
   {
      return addButtonPanel;
   }

   /**
    * Gets the text field panel.
    *
    * @return the text field panel
    */
   public TextFieldPanel getTextFieldPanel()
   {
      return textFieldPanelForReserving;
   }

   /**
    * Sets the error message.
    *
    * @param message the new error message
    */
   public void setErrorMessage(String message)
   {
      errorLabel.setText(message);
   }

   /**
    * Gets the input.
    *
    * @return the input
    */
   public String[] getInput()
   {
      String[] input = new String[4];
      input[0] = textFieldPanelForReserving.getTextField(EMAIL).getText();
      input[1] = textFieldPanelForReserving.getTextField(ITEMID).getText();
      input[2] = textFieldPanelForReserving.getTextField(DATE_FROM).getText();
      input[3] = textFieldPanelForReserving.getTextField(RESERVATION_ID).getText();

      return input;
   }

   /**
    * Clear.
    */
   public void clear()
   {
      textFieldPanelForReserving.getTextField(EMAIL).setText("");
      textFieldPanelForReserving.getTextField(ITEMID).setText("");
      textFieldPanelForReserving.getTextField(DATE_FROM).setText("");
      textFieldPanelForReserving.getTextField(RESERVATION_ID).setText("");
      errorLabel.setText("");
   }

   /**
    * Creates the components.
    */
   private void createComponents()
   {
      textFieldPanelForReserving = new TextFieldPanel(EMAIL, ITEMID, DATE_FROM,
            RESERVATION_ID);
      addButtonPanel = new ButtonPanel(new FlowLayout(), RESERVE_MODE,
            TITLE_MODE);
      errorLabel = new JLabel();
      errorLabel.setForeground(Color.RED);
   }

   /**
    * Adds the components to panel.
    */
   private void addComponentsToPanel()
   {
      setLayout(new BorderLayout());
      add(textFieldPanelForReserving, BorderLayout.NORTH);
      add(addButtonPanel, BorderLayout.SOUTH);
      add(errorLabel, BorderLayout.CENTER);
   }
}