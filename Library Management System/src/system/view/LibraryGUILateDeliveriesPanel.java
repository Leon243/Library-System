package system.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryGUILateDeliveriesPanel.
 */
public class LibraryGUILateDeliveriesPanel extends JPanel
{
   
   /** The late deliveries button panel. */
   private ButtonPanel lateDeliveriesButtonPanel;
   
   /** The text area. */
   private JTextArea textArea;

   /** The Constant OK_MODE. */
   public static final String OK_MODE = "OK";
   
   /** The Constant TITLE_MODE. */
   public static final String TITLE_MODE = "Main Menu";

   /**
    * Instantiates a new library gui late deliveries panel.
    */
   public LibraryGUILateDeliveriesPanel()
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
      return lateDeliveriesButtonPanel;
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
      lateDeliveriesButtonPanel = new ButtonPanel(new FlowLayout(), OK_MODE, TITLE_MODE);
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
      add(lateDeliveriesButtonPanel, BorderLayout.SOUTH);
   }
}
