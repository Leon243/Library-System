package system.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class TextFieldPanel.
 */
public class TextFieldPanel extends JPanel
{
	
	/** The text fields. */
	private JTextField[] textFields;
	
	/** The labels. */
	private JLabel[] labels;

	/**
	 * Instantiates a new text field panel.
	 *
	 * @param layout the layout
	 * @param size the size
	 * @param textFieldLabels the text field labels
	 */
	public TextFieldPanel(LayoutManager layout, int size, String... textFieldLabels)
	{
		textFields = new JTextField[textFieldLabels.length];
		labels = new JLabel[textFieldLabels.length];
		for (int i = 0; i < textFields.length; i++)
		{
			textFields[i] = new JTextField(size);
			labels[i] = new JLabel(textFieldLabels[i]);
		}
		addComponentsToPanel(layout);
	}

	/**
	 * Instantiates a new text field panel.
	 *
	 * @param textFieldLabels the text field labels
	 */
	public TextFieldPanel(String... textFieldLabels)
	{
		this(new GridLayout(textFieldLabels.length, 1, 5, 5), 10, textFieldLabels); // vertical
	}

	/**
	 * Adds the components to panel.
	 *
	 * @param layout the layout
	 */
	private void addComponentsToPanel(LayoutManager layout)
	{
		if (layout == null)
		{
			layout = new GridLayout(textFields.length, 1, 5, 5);
		}
		setLayout(layout);
		if (layout instanceof BorderLayout)
		{
			String[] position =
			{ BorderLayout.NORTH, BorderLayout.SOUTH,
					BorderLayout.WEST, BorderLayout.EAST, BorderLayout.CENTER };
			int size = Math.min(position.length, textFields.length);
			
			for (int i = 0; i < size; i++)
			{
				JPanel onePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				onePanel.add(textFields[i]);
				onePanel.add(labels[i]);
				add(onePanel, position[i]);
			}
		}
		else
		{
			if (layout instanceof GridLayout)
			{
				if (((GridLayout) layout).getColumns()
						* ((GridLayout) layout).getRows() != textFields.length)
				{
					((GridLayout) layout).setVgap(5);
					((GridLayout) layout).setColumns(1);
					((GridLayout) layout).setRows(textFields.length);
				}
			}
			for (int i = 0; i < textFields.length; i++)
			{
				JPanel onePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				onePanel.add(textFields[i]);
				onePanel.add(labels[i]);
				add(onePanel);
			}
		}
	}

	// ..............

	/**
	 * Gets the text field.
	 *
	 * @param index the index
	 * @return the text field
	 */
	public JTextField getTextField(int index)
	{
		if (index < textFields.length && index >= 0)
			return textFields[index];
		return null;
	}

	/**
	 * Gets the text field.
	 *
	 * @param text the text
	 * @return the text field
	 */
	public JTextField getTextField(String text)
	{
		for (int i = 0; i < labels.length; i++)
			if (labels[i].getText().equals(text))
				return textFields[i];
		return null;
	}

	/**
	 * Adds the action listener to all text fields.
	 *
	 * @param listener the listener
	 */
	public void addActionListenerToAllTextFields(ActionListener listener)
	{
		if (listener == null)
			return;
		for (int i = 0; i < textFields.length; i++)
		{
			if (textFields[i] != null)
			{
				textFields[i].addActionListener(listener);
			}
		}
	}

	/**
	 * Adds the action listener to one text field.
	 *
	 * @param listener the listener
	 * @param index the index
	 */
	public void addActionListenerToOneTextField(ActionListener listener, int index)
	{
		JTextField oneTextField = getTextField(index);
		if (oneTextField != null)
			oneTextField.addActionListener(listener);
	}

	/**
	 * Adds the action listener to one text field.
	 *
	 * @param listener the listener
	 * @param textFieldText the text field text
	 */
	public void addActionListenerToOneTextField(ActionListener listener,
			String textFieldText)
	{
		JTextField oneTextField = getTextField(textFieldText);
		if (oneTextField != null)
			oneTextField.addActionListener(listener);
	}

}
