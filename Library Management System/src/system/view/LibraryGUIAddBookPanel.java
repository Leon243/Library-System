package system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryGUIAddBookPanel.
 */
public class LibraryGUIAddBookPanel extends JPanel
{
   
   /** The add button panel. */
   private ButtonPanel addButtonPanel;
   
   /** The text field panel for book. */
   private TextFieldPanel textFieldPanelForBook;
   
   /** The error label. */
   private JLabel errorLabel;

   /** The Constant ADDBOOK_MODE. */
   public static final String ADDBOOK_MODE = "Add Book";
   
   /** The Constant TITLE_MODE. */
   public static final String TITLE_MODE = "Main Menu";

   /** The Constant ITEMID. */
   private static final String ITEMID = "ItemID";
   
   /** The Constant TITLE. */
   private static final String TITLE = "Title";
   
   /** The Constant ISBN. */
   private static final String ISBN = "Isbn";
   
   /** The Constant AUTHOR. */
   private static final String AUTHOR = "Author";

   /**
    * Instantiates a new library gui add book panel.
    */
   public LibraryGUIAddBookPanel()
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
      return textFieldPanelForBook;
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
      input[0] = textFieldPanelForBook.getTextField(ITEMID).getText();
      input[1] = textFieldPanelForBook.getTextField(AUTHOR).getText();
      input[2] = textFieldPanelForBook.getTextField(TITLE).getText();
      input[3] = textFieldPanelForBook.getTextField(ISBN).getText();

      return input;
   }

   /**
    * Clear.
    */
   public void clear()
   {
      textFieldPanelForBook.getTextField(ITEMID).setText("");
      textFieldPanelForBook.getTextField(AUTHOR).setText("");
      textFieldPanelForBook.getTextField(TITLE).setText("");
      textFieldPanelForBook.getTextField(ISBN).setText("");
      errorLabel.setText("");
   }

   /**
    * Creates the components.
    */
   private void createComponents()
   {
      textFieldPanelForBook = new TextFieldPanel(ITEMID, AUTHOR, TITLE, ISBN);
      addButtonPanel = new ButtonPanel(new FlowLayout(), ADDBOOK_MODE,
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
      add(textFieldPanelForBook, BorderLayout.NORTH);
      add(addButtonPanel, BorderLayout.SOUTH);
      add(errorLabel, BorderLayout.CENTER);
   }
}
