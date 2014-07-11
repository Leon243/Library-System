package system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryGUIReturnItemPanel.
 */
public class LibraryGUIReturnItemPanel extends JPanel
{
   
   /** The return button panel. */
   private ButtonPanel returnButtonPanel;
   
   /** The text field panel for id. */
   private TextFieldPanel textFieldPanelForID;
   
   /** The error label. */
   private JLabel errorLabel;

   /** The Constant RETURN_MODE. */
   public static final String RETURN_MODE = "Return Item";
   
   /** The Constant TITLE_MODE. */
   public static final String TITLE_MODE = "Main Menu";

   /** The Constant ITEMID. */
   private static final String ITEMID = "ItemID";

   /**
    * Instantiates a new library gui return item panel.
    */
   public LibraryGUIReturnItemPanel()
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
      return returnButtonPanel;
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
      String[] input = { textFieldPanelForID.getTextField(ITEMID)
            .getText() };
      textFieldPanelForID.getTextField(ITEMID).setText("");
      return input;
   }

   /**
    * Clear.
    */
   public void clear()
   {
      textFieldPanelForID.getTextField(ITEMID).setText("");
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
      textFieldPanelForID = new TextFieldPanel(ITEMID);
      returnButtonPanel = new ButtonPanel(new FlowLayout(), RETURN_MODE,
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
      add(returnButtonPanel, BorderLayout.SOUTH);
      add(errorLabel, BorderLayout.CENTER);
   }
}
