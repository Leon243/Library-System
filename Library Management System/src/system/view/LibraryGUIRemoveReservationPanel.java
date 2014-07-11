package system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryGUIRemoveReservationPanel.
 */
public class LibraryGUIRemoveReservationPanel extends JPanel
{
   
   /** The remove button panel. */
   private ButtonPanel removeButtonPanel;
   
   /** The text field panel for id. */
   private TextFieldPanel textFieldPanelForID;
   
   /** The error label. */
   private JLabel errorLabel;

   /** The Constant REMOVERESERVATION_MODE. */
   public static final String REMOVERESERVATION_MODE = "Remove Reservation";
   
   /** The Constant TITLE_MODE. */
   public static final String TITLE_MODE = "Main Menu";

   /** The Constant RESERVATION_ID. */
   private static final String RESERVATION_ID = "Reservation ID";

   /**
    * Instantiates a new library gui remove reservation panel.
    */
   public LibraryGUIRemoveReservationPanel()
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
      return removeButtonPanel;
   }

   /**
    * Gets the text field panel.
    *
    * @return the text field panel
    */
   public TextFieldPanel getTextFieldPanel()
   {
      return textFieldPanelForID;
   }

   /**
    * Gets the input.
    *
    * @return the input
    */
   public String[] getInput()
   {
      String[] input = { textFieldPanelForID.getTextField(RESERVATION_ID)
            .getText() };
      textFieldPanelForID.getTextField(RESERVATION_ID).setText("");
      return input;
   }

   /**
    * Clear.
    */
   public void clear()
   {
      textFieldPanelForID.getTextField(RESERVATION_ID).setText("");
      errorLabel.setText("");
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
    * Creates the components.
    */
   private void createComponents()
   {
      textFieldPanelForID = new TextFieldPanel(RESERVATION_ID);
      removeButtonPanel = new ButtonPanel(new FlowLayout(), REMOVERESERVATION_MODE,
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
      add(textFieldPanelForID, BorderLayout.NORTH);
      add(removeButtonPanel, BorderLayout.SOUTH);
      add(errorLabel, BorderLayout.CENTER);
   }
}