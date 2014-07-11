package system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryGUISearchPanel.
 */
public class LibraryGUISearchPanel extends JPanel
{
   
   /** The search button panel. */
   private ButtonPanel searchButtonPanel;
   
   /** The text field panel for title. */
   private TextFieldPanel textFieldPanelForTitle;
   
   /** The error label. */
   private JLabel errorLabel;
   
   /** The text area. */
   private JTextArea textArea;

   /** The Constant SEARCH_MODE. */
   public static final String SEARCH_MODE = "Search";
   
   /** The Constant TITLE_MODE. */
   public static final String TITLE_MODE = "Main Menu";

   /** The Constant TITLE. */
   private static final String TITLE = "Title";

   /**
    * Instantiates a new library gui search panel.
    */
   public LibraryGUISearchPanel()
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
    * Gets the text area.
    *
    * @return the text area
    */
   public JTextArea getTextArea()
   {
      return textArea;
   }

   /**
    * Gets the button panel.
    *
    * @return the button panel
    */
   public ButtonPanel getButtonPanel()
   {
      return searchButtonPanel;
   }

   /**
    * Gets the text field panel.
    *
    * @return the text field panel
    */
   public TextFieldPanel getTextFieldPanel()
   {
      return textFieldPanelForTitle;
   }

   /**
    * Gets the input.
    *
    * @return the input
    */
   public String[] getInput()
   {
      String[] input = { textFieldPanelForTitle.getTextField(TITLE).getText() };
      textFieldPanelForTitle.getTextField(TITLE).setText("");
      return input;
   }

   /**
    * Clear.
    */
   public void clear()
   {
      textFieldPanelForTitle.getTextField(TITLE).setText("");
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
      textArea = new JTextArea(3, 5);
      textFieldPanelForTitle = new TextFieldPanel(TITLE);
      searchButtonPanel = new ButtonPanel(new FlowLayout(), SEARCH_MODE,
            TITLE_MODE);
      errorLabel = new JLabel();
      errorLabel.setForeground(Color.RED);
      textArea.setText("Press the buttons");
      textArea.setEditable(false);
   }

   /**
    * Adds the components to panel.
    */
   private void addComponentsToPanel()
   {
      setLayout(new BorderLayout());
      add(textFieldPanelForTitle, BorderLayout.NORTH);
      add(searchButtonPanel, BorderLayout.SOUTH);
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      add(errorLabel, BorderLayout.CENTER);
   }
}
