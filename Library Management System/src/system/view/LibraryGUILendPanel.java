package system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryGUILendPanel.
 */
public class LibraryGUILendPanel extends JPanel
{
   
   /** The add button panel. */
   private ButtonPanel addButtonPanel;
   
   /** The text field panel for borrowing. */
   private TextFieldPanel textFieldPanelForBorrowing;
   
   /** The error label. */
   private JLabel errorLabel;

   /** The Constant LEND_MODE. */
   public static final String LEND_MODE = "Borrow Item";
   
   /** The Constant TITLE_MODE. */
   public static final String TITLE_MODE = "Main Menu";

   /** The Constant ITEMID. */
   private static final String ITEMID = "ItemID";
   
   /** The Constant EMAIL. */
   private static final String EMAIL = "Email";

   /**
    * Instantiates a new library gui lend panel.
    */
   public LibraryGUILendPanel()
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
      return textFieldPanelForBorrowing;
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
      String[] input = new String[2];
      input[0] = textFieldPanelForBorrowing.getTextField(ITEMID).getText();
      input[1] = textFieldPanelForBorrowing.getTextField(EMAIL).getText();

      return input;
   }

   /**
    * Clear.
    */
   public void clear()
   {
      textFieldPanelForBorrowing.getTextField(ITEMID).setText("");
      textFieldPanelForBorrowing.getTextField(EMAIL).setText("");
      errorLabel.setText("");
   }

   /**
    * Creates the components.
    */
   private void createComponents()
   {
      textFieldPanelForBorrowing = new TextFieldPanel(ITEMID, EMAIL);
      addButtonPanel = new ButtonPanel(new FlowLayout(), LEND_MODE, TITLE_MODE);
      errorLabel = new JLabel();
      errorLabel.setForeground(Color.RED);
   }

   /**
    * Adds the components to panel.
    */
   private void addComponentsToPanel()
   {
      setLayout(new BorderLayout());
      add(textFieldPanelForBorrowing, BorderLayout.NORTH);
      add(addButtonPanel, BorderLayout.SOUTH);
      add(errorLabel, BorderLayout.CENTER);
   }
}
