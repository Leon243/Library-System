package system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryGUIAddBorrowerPanel.
 */
public class LibraryGUIAddBorrowerPanel extends JPanel
{
   
   /** The add button panel. */
   private ButtonPanel addButtonPanel;
   
   /** The text field panel for borrower. */
   private TextFieldPanel textFieldPanelForBorrower;
   
   /** The error label. */
   private JLabel errorLabel;

   /** The Constant ADDBORROWER_MODE. */
   public static final String ADDBORROWER_MODE = "Add Borrower";
   
   /** The Constant TITLE_MODE. */
   public static final String TITLE_MODE = "Main Menu";

   /** The Constant NAME. */
   private static final String NAME = "Name";
   
   /** The Constant EMAIL. */
   private static final String EMAIL = "Email";
   
   /** The Constant STATUS. */
   private static final String STATUS = "Status";

   /**
    * Instantiates a new library gui add borrower panel.
    */
   public LibraryGUIAddBorrowerPanel()
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
      return textFieldPanelForBorrower;
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
      String[] input = new String[3];
      input[0] = textFieldPanelForBorrower.getTextField(NAME).getText();
      input[1] = textFieldPanelForBorrower.getTextField(EMAIL).getText();
      input[2] = textFieldPanelForBorrower.getTextField(STATUS).getText();

      return input;
   }

   /**
    * Clear.
    */
   public void clear()
   {
      textFieldPanelForBorrower.getTextField(NAME).setText("");
      textFieldPanelForBorrower.getTextField(EMAIL).setText("");
      textFieldPanelForBorrower.getTextField(STATUS).setText("");
      errorLabel.setText("");
   }

   /**
    * Creates the components.
    */
   private void createComponents()
   {
      textFieldPanelForBorrower = new TextFieldPanel(NAME, EMAIL, STATUS);
      addButtonPanel = new ButtonPanel(new FlowLayout(), ADDBORROWER_MODE,
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
      add(textFieldPanelForBorrower, BorderLayout.NORTH);
      add(addButtonPanel, BorderLayout.SOUTH);
      add(errorLabel, BorderLayout.CENTER);
   }
}
