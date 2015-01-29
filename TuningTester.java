import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

/**
 * A simple GUI with some buttons and associated actions.
 * @author adalal
 *
 */
public class TuningTester implements ActionListener {
	protected JLabel pressed;
	protected JLabel noteGraphic;
	protected JPanel buttonPanelTop;
	protected JPanel buttonPanelNotes;
	protected JPanel graphicPanel;

	/**
	 * Initializes the GUI, creates the panels, calls the button-generating methods.
	 */
	public TuningTester() {
		// Set up the bounding frame
		JFrame frame = new JFrame("Name That Pitch!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(200, 200);
		frame.pack();
		frame.setVisible(true);

		// Set up the text and button panels
		JPanel labelPanel = new JPanel();
		frame.add(labelPanel, BorderLayout.CENTER);

		buttonPanelNotes = new JPanel();
		buttonPanelNotes.setLayout(new GridLayout(1, 6));
		frame.add(buttonPanelNotes, BorderLayout.SOUTH);
		
		// Set up the top panel
		buttonPanelTop = new JPanel();
		buttonPanelTop.setLayout(new GridLayout(1,1));
		frame.add(buttonPanelTop, BorderLayout.BEFORE_FIRST_LINE);
		
		// Set up the graphic panel
		graphicPanel = new JPanel();
		graphicPanel.setLayout(new GridLayout(1,2));
		frame.add(graphicPanel, BorderLayout.CENTER);
		
		// Add graphics label to graphic panel
		noteGraphic = new JLabel("Picture of music note goes here");
		graphicPanel.add(noteGraphic);
		//graphicPanel.add(pressed);

		// Add a label
		pressed = new JLabel("Sounds like a...");

		// Call the method to add some buttons
		addButtons();
	}

	/**
	 * Add four buttons to the button panel and associate action listeners with them.
	 */
	protected void addButtons() {
		//Note Panel Buttons
		JButton button1 = new JButton("Note 1");
		button1.setSize(500,500);
		JButton button2 = new JButton("Note 2");
		JButton button3 = new JButton("Note 3");
		JButton button4 = new JButton("Note 4");
		JLabel button5 = new JLabel("Round: 1/10");
		JLabel button6 = new JLabel("Score: 500");

		//Top Panel Buttons
		JButton buttonA = new JButton("Home");
		JButton buttonB = new JButton("Help");
		
		// Set the buttons up to register actions
		button1.setActionCommand(button1.getText());
		button2.setActionCommand(button2.getText());
		button3.setActionCommand(button3.getText());
		button4.setActionCommand(button4.getText());
		buttonA.setActionCommand(buttonA.getText());
		buttonB.setActionCommand(buttonB.getText());

		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		buttonA.addActionListener(this);
		buttonB.addActionListener(this);

		// Add buttons to interface
		//buttonPanelNotes.add(pressed);
		buttonPanelNotes.add(button5);
		buttonPanelNotes.add(pressed);
		buttonPanelNotes.add(button1);
		buttonPanelNotes.add(button2);
		buttonPanelNotes.add(button3);
		buttonPanelNotes.add(button4);
		buttonPanelNotes.add(button6);		
		buttonPanelTop.add(buttonA);
		buttonPanelTop.add(buttonB);
	}

	/**
	 * Determine which button was pressed and change the label based on which button was pressed.
	 */
	public void actionPerformed(ActionEvent arg0) {
		// Determine which button was pressed and change the label text appropriately
		String result = arg0.getActionCommand();
		String newLabel = "";
		if (result.equalsIgnoreCase("Help")) {
			newLabel = "Pressed Help";
			createDialogBox();
		} else if (result.equalsIgnoreCase("Note 1")) {
			newLabel = "Pressed Note 1";
		} else if (result.equalsIgnoreCase("Note 2")) {
			newLabel = "Pressed Note 2";
		} else if (result.equalsIgnoreCase("Note 3")) {
			newLabel = "Pressed Note 3";
		} else if (result.equalsIgnoreCase("Note 4")) {
			newLabel = "Pressed Note 4";
		} else if (result.equalsIgnoreCase("Home")) {
			newLabel = "Pressed Home";
		} else {
			newLabel = "Something went horribly wrong here";
		}
		pressed.setText(newLabel);

	}
	
	public void createDialogBox() {
		// Set up the bounding frame
				JFrame frame = new JFrame("Help");
				//frame.setVisible(false);
		JOptionPane.showMessageDialog(frame, "Listen to the pitch and select a note.");
	}

	/**
	 * Generates and runs the GUI.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TuningTester();

	}

}