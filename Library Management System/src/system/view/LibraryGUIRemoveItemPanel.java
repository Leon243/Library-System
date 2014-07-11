package system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryGUIRemoveItemPanel.
 */
public class LibraryGUIRemoveItemPanel extends JPanel
{
   
   /** The remov item button panel. */
   private ButtonPanel removItemButtonPanel;
   
   /** The text field panel for id. */
   private TextFieldPanel textFieldPanelForID;
   
   /** The error label. */
   private JLabel errorLabel;
   
   /** The Constant REMOVE_MODE. */
   public static final String REMOVE_MODE = "Remove";
   
   /** The Constant TITLE_MODE. */
   public static final String TITLE_MODE = "Main Menu";
   
   /** The Constant ITEMID. */
   private static final String ITEMID = "ItemID";
   
   /**
    * Instantiates a new library gui remove item panel.
    */
   public LibraryGUIRemoveItemPanel()
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
      return removItemButtonPanel;
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
      removItemButtonPanel = new ButtonPanel(new FlowLayout(), REMOVE_MODE,
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
      add(removItemButtonPanel, BorderLayout.SOUTH);
      add(errorLabel, BorderLayout.CENTER);
   }
}
