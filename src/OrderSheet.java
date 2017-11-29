import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class OrderSheet implements ActionListener
{
	JFrame mainFrame;
	
	JPanel namePanel;
	JLabel nameLabel;
	JTextField nameText;
	
	JPanel sizePanel;
	JLabel sizeLabel;
	JRadioButton sizeButton1;
	JRadioButton sizeButton2;
	JRadioButton sizeButton3;
	ButtonGroup sizeGroup;
	
	JPanel crustPanel;
	JLabel crustLabel;
	JComboBox crustBox;
	
	JPanel toppingsPanel;
	JLabel toppingsLabel;
	JList toppingsList;
	JScrollPane toppingsScroller;
	
	JPanel extrasPanel;
	JLabel extrasLabel;
	JCheckBox extrasBox1;
	JCheckBox extrasBox2;
	JCheckBox extrasBox3;
	
	JPanel commentPanel;
	JLabel commentLabel;
	JTextArea commentText;
	JScrollPane commentScroller;
	
	JPanel buttonPanel;
	JButton buttonButton;
	
	public void actionPerformed(ActionEvent event)
	{
		Object Event = event.getSource();
		
		if(Event == buttonButton)
		{
			String boxText1;
			String boxText2;
			String boxText3;
			
			if (extrasBox1.isSelected())
			{
				boxText1 = extrasBox1.getText();
			}
			else
			{
				boxText1 = null;
			}
			
			if (extrasBox2.isSelected())
			{
				if ((boxText1 != null))
				{
					boxText2 = ", " + extrasBox2.getText();
				}
				else
				{
					boxText2 = extrasBox2.getText();
				}
			}
			else
			{
				boxText2 = null;
			}
			
			if (extrasBox3.isSelected())
			{
				if ((boxText1 != null) && (boxText2 != null))
				{
					boxText3 = " and " + extrasBox3.getText();
				}
				else
				{
					boxText3 = extrasBox3.getText();
				}
			}
			else
			{
				boxText3 = null;
			}
			
			String order = "Your order was:\n"
						 + "A " + sizeGroup.getSelection() 
						 + ", " + crustBox.getSelectedItem() 
						 + " pizza with " + toppingsList.getSelectedIndex()
						 + " and a side of " + boxText1 + boxText2 + boxText3
						 + ". Your extra comments were:\n"
						 + commentText.getText();
		}
	}

	public static void main(String[] args) 
	{
		new OrderSheet();

	}
	public OrderSheet()
	{
		mainFrame = new JFrame();
		
		namePanel = new JPanel();
		nameLabel = new JLabel("Name:");
		nameText = new JTextField(20);
		
		sizePanel = new JPanel();
		sizeLabel = new JLabel("Pizza Size:");
		sizeButton1 = new JRadioButton("9''");
		sizeButton2 = new JRadioButton("11''");
		sizeButton3 = new JRadioButton("13''");
		sizeGroup = new ButtonGroup();
		
		crustPanel = new JPanel();
		crustLabel = new JLabel("Crust Type:");
		String[] crusts = {"Thin", "Pan Fried", "Stuffed Crust", "Meatballs?!?!"};
		crustBox = new JComboBox(crusts);
		
		toppingsPanel = new JPanel();
		toppingsLabel = new JLabel("Toppings:");
		String[] toppings = {"Pepperoni", "Hawaiian", "Meat Feast", "McDonalds"};
		JList toppingsList = new JList(toppings);
		toppingsScroller = new JScrollPane(toppingsList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		extrasPanel = new JPanel();
		extrasLabel = new JLabel("Extras:");
		extrasBox1 = new JCheckBox("Bread Sticks");
		extrasBox2 = new JCheckBox("Garlic Bread");
		extrasBox3 = new JCheckBox("Vimto");
		
		commentPanel = new JPanel();
		commentLabel = new JLabel("Final Comments:");
		commentText = new JTextArea(5, 20);
		commentScroller = new JScrollPane(commentText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		buttonPanel = new JPanel();
		buttonButton = new JButton("Place Order");
		
		
		JPanel mainPanel = (JPanel)mainFrame.getContentPane();
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		

		namePanel.add(nameLabel);
		namePanel.add(nameText);
		
		sizeGroup.add(sizeButton1);
		sizeGroup.add(sizeButton2);
		sizeGroup.add(sizeButton3);
		
		sizePanel.add(sizeLabel);
		sizePanel.add(sizeButton1);
		sizePanel.add(sizeButton2);
		sizePanel.add(sizeButton3);
		
		crustPanel.add(crustLabel);
		crustPanel.add(crustBox);
		
		toppingsPanel.add(toppingsLabel);
		toppingsPanel.add(toppingsScroller);
		
		extrasPanel.add(extrasLabel);
		extrasPanel.add(extrasBox1);
		extrasPanel.add(extrasBox2);
		extrasPanel.add(extrasBox3);
		
		commentPanel.add(commentLabel);
		commentPanel.add(commentScroller);
		
		buttonButton.addActionListener(this);
		buttonPanel.add(buttonButton);
		
		
		mainFrame.add(namePanel);
		mainFrame.add(sizePanel);
		mainFrame.add(crustPanel);
		mainFrame.add(toppingsPanel);
		mainFrame.add(extrasPanel);
		mainFrame.add(commentPanel);
		mainFrame.add(buttonPanel);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}

}
