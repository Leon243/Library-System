package system.view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonPanel.
 */
public class ButtonPanel extends JPanel
{
   
   /** The buttons. */
   private JButton[] buttons;

   /**
    * Instantiates a new button panel.
    *
    * @param layout the layout
    * @param buttonTexts the button texts
    */
   public ButtonPanel(LayoutManager layout, String... buttonTexts)
   {
      buttons = new JButton[buttonTexts.length];
      for (int i = 0; i < buttons.length; i++)
         buttons[i] = new JButton(buttonTexts[i]);

      addButtonsToPanel(layout);
   }

   /**
    * Instantiates a new button panel.
    *
    * @param buttonTexts the button texts
    */
   public ButtonPanel(String... buttonTexts) // vertical
   {
      this(new GridLayout(buttonTexts.length, 1, 5, 5), buttonTexts);
   }

   /**
    * Instantiates a new button panel.
    *
    * @param layout the layout
    * @param numberOfButtons the number of buttons
    */
   public ButtonPanel(LayoutManager layout, int numberOfButtons)
   {
      String[] buttonTexts = new String[numberOfButtons];
      for (int i = 0; i < buttonTexts.length; i++)
         buttonTexts[i] = String.valueOf((i + 1));

      buttons = new JButton[buttonTexts.length];
      for (int i = 0; i < buttons.length; i++)
         buttons[i] = new JButton(buttonTexts[i]);

      addButtonsToPanel(layout);
   }

   /**
    * Instantiates a new button panel.
    *
    * @param numberOfButtons the number of buttons
    */
   public ButtonPanel(int numberOfButtons) // vertical
   {
      this(new GridLayout(numberOfButtons, 1, 5, 5), numberOfButtons);
   }

   /**
    * Gets the number of buttons.
    *
    * @return the number of buttons
    */
   public int getNumberOfButtons()
   {
      return buttons.length;
   }

   /**
    * Sets the button labels.
    *
    * @param labels the new button labels
    */
   public void setButtonLabels(String... labels)
   {
      int length = Math.min(labels.length, buttons.length);
      for (int i = 0; i < length; i++)
      {
         buttons[i].setText(labels[i]);
      }
   }

   /**
    * Gets the button.
    *
    * @param index the index
    * @return the button
    */
   public JButton getButton(int index)
   {
      if (index < buttons.length && index >= 0)
         return buttons[index];
      return null;
   }

   /**
    * Gets the button.
    *
    * @param text the text
    * @return the button
    */
   public JButton getButton(String text)
   {
      for (int i = 0; i < buttons.length; i++)
         if (buttons[i].getText().equals(text))
            return buttons[i];
      return null;
   }

   /**
    * Adds the action listener to all buttons.
    *
    * @param listener the listener
    */
   public void addActionListenerToAllButtons(ActionListener listener)
   {
      if (listener == null)
         return;
      for (int i = 0; i < buttons.length; i++)
      {
         if (buttons[i] != null)
         {
            buttons[i].addActionListener(listener);
         }
      }
   }

   /**
    * Adds the action listener to one button.
    *
    * @param listener the listener
    * @param index the index
    */
   public void addActionListenerToOneButton(ActionListener listener, int index)
   {
      JButton oneButton = getButton(index);
      if (oneButton != null)
         oneButton.addActionListener(listener);
   }

   /**
    * Adds the action listener to one button.
    *
    * @param listener the listener
    * @param buttonText the button text
    */
   public void addActionListenerToOneButton(ActionListener listener,
         String buttonText)
   {
      JButton oneButton = getButton(buttonText);
      if (oneButton != null)
         oneButton.addActionListener(listener);
   }

   /**
    * Adds the buttons to panel.
    *
    * @param layout the layout
    */
   private void addButtonsToPanel(LayoutManager layout)
   {
      if (layout == null)
      {
         layout = new GridLayout(buttons.length, 1, 5, 5);
      }
      setLayout(layout);
      if (layout instanceof BorderLayout)
      {
         String[] position = { BorderLayout.NORTH, BorderLayout.SOUTH,
               BorderLayout.WEST, BorderLayout.EAST, BorderLayout.CENTER };
         int size = Math.min(position.length, buttons.length);
         for (int i = 0; i < size; i++)
         {
            add(buttons[i], position[i]);
         }
      }
      else
      {
         for (int i = 0; i < buttons.length; i++)
         {
            add(buttons[i]);
         }
      }
   }

}
