import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * A GUI for Austin Lane, Zach Lynn, Alex Trautman, and Sef van Kan's Musical Madness
 * final project for Software Design.
 * 5/27/14
 *
 */
public class MusicalMadness implements ActionListener {
	protected String newLabel;
	protected JPanel centerPanel;
	protected JPanel bottomPanel;
	protected JPanel topPanel;
	protected JTextArea text;
	protected JTextArea instructionHeader;
	protected JTextArea instructionBody;
	protected JFrame frame;
	protected JPanel homePanel;
	protected String gameMode;
	/**
	 * Initializes the GUI, creates the panels, calls the button-generating methods.
	 */
	 
	
	public MusicalMadness() {
		// Set up the bounding frame
		JFrame frame = new JFrame("Ear Hero");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Set up the text and button panels
		//JPanel labelPanel = new JPanel();
		//frame.add(labelPanel, BorderLayout.WEST);

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		frame.add(centerPanel, BorderLayout.CENTER);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3));
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
		// Add a label
		
		topPanel = new JPanel();
		frame.add(topPanel, BorderLayout.NORTH);
		
		text = new JTextArea("Ear Hero", 1, 5);
		text.setEditable(false);
		Font font = new Font("Verdana", Font.BOLD, 40);
        text.setFont(font);
        text.setForeground(Color.BLUE);
		//text.setFont(newFont("Serif", Font.ITALIC,16));
		topPanel.add(text);

		// Call the method to add some buttons
		addButtons();
		frame.setSize(800, 600);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Adds main screen buttons to the frame.
	 */
	protected void addButtons() {
		JButton button1 = new JButton("Pitch Perfector");
		JButton button2 = new JButton("Tuning Tester");
		JButton button3 = new JButton("Name that Instrument");

		// Set the buttons up to register actions
		button1.setActionCommand(button1.getText());
		button2.setActionCommand(button2.getText());
		button3.setActionCommand(button3.getText());

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

		// Add buttons to interface
		centerPanel.add(button1);
		centerPanel.add(button2);
		centerPanel.add(button3);
		
		JButton button4 = new JButton("Keyboard Tool");
		JButton button5 = new JButton("Score History");
		JButton button6 = new JButton("Instructions");
		JButton button7 = new JButton("About");

		// Set the buttons up to register actions
		button4.setActionCommand(button4.getText());
		button5.setActionCommand(button5.getText());
		button6.setActionCommand(button6.getText());
		button7.setActionCommand(button7.getText());

		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);

		// Add buttons to interface
		bottomPanel.add(button4);
		bottomPanel.add(button5);
		bottomPanel.add(button6);
		bottomPanel.add(button7);

	}


    /**
	 * changeScreen updates the frame based on which button was clicked. This function checks
	 * the value of the input screen and updates the frame correspondingly.
	 */
    protected void changeScreen(String newScreen){
        centerPanel.removeAll();
        bottomPanel.removeAll();
        topPanel.removeAll();
        
        Font font1 = new Font("Verdana", Font.BOLD, 40);
        Font font2 = new Font("Verdana", Font.BOLD, 12);
        
        if(newScreen.equals("Home")){
            System.out.println("Loading Home Screen");
            addButtons();
            topPanel.removeAll();
            text = new JTextArea("Ear Hero", 1, 5);
            text.setEditable(false);
            text.setFont(font1);
            text.setForeground(Color.BLUE);
		    topPanel.add(text);
            }
        else{
            JButton homeButton = new JButton("Home");
            homeButton.setActionCommand(homeButton.getText());
            homeButton.addActionListener(this);
            topPanel.add(homeButton);
        
            if(newScreen.equals("Instructions")){
                System.out.println("Loading Instruction Screen");
                //new instructionScreen();
                /*
                instructionHeader = new JTextArea("Ear Hero Instructions", 1, 5);
                instructionHeader.setEditable(false);
                instructionHeader.setFont(font1);
                instructionHeader.setForeground(Color.BLUE);
		        //text.setFont(newFont("Serif", Font.ITALIC,16));
		        topPanel.add(instructionHeader);
		    
		        instructionBody = new JTextArea("Blah blah blah here are the instructions", 10, 10);
		        instructionBody.setEditable(false);
                instructionBody.setFont(font2);
                instructionBody.setForeground(Color.BLUE);
		        //text.setFont(newFont("Serif", Font.ITALIC,16));
		        centerPanel.add(instructionBody);
		    */
                }
            else if(newScreen.equals("Game Select Screen")){
                System.out.println("Loading Game Select Screen");
            
                JTextArea selectionHeader = new JTextArea("Choose Gamemode", 1, 5);
                selectionHeader.setEditable(false);
                selectionHeader.setFont(font1);
                selectionHeader.setForeground(Color.BLUE);
		        //text.setFont(newFont("Serif", Font.ITALIC,16));
		        topPanel.add(selectionHeader);
		    
		        JButton button1 = new JButton("Marathon");
		        JButton button2 = new JButton("Test");
		        JButton button3 = new JButton("Practice");
		    
		        button1.addActionListener(this);
		        button2.addActionListener(this);
		        button3.addActionListener(this);

		        // Add buttons to interface
		        centerPanel.add(button1);
		        centerPanel.add(button2);
		        centerPanel.add(button3);
                }
            else if(newScreen.equals("About")){
                JTextArea historyHeader = new JTextArea("About", 1, 5);
                historyHeader.setEditable(false);
                historyHeader.setFont(font1);
                historyHeader.setForeground(Color.BLUE);
		        //text.setFont(newFont("Serif", Font.ITALIC,16));
		        topPanel.add(historyHeader);
		    
		        JTextArea historyBody = new JTextArea("Ear Hero was developed in Spring, " +
		        		"2014 by Austin Lane, Zach Lynn, Alex Trautman, and Sef van Kan.", 10, 10);
		        historyBody.setEditable(false);
                historyBody.setFont(font2);
                historyBody.setForeground(Color.BLUE);
		        //text.setFont(newFont("Serif", Font.ITALIC,16));
		        centerPanel.add(historyBody);
                }
            else if(newScreen.equals("Score History")){
                JTextArea historyHeader = new JTextArea("High Scores", 1, 5);
                historyHeader.setEditable(false);
                historyHeader.setFont(font1);
                historyHeader.setForeground(Color.BLUE);
		        topPanel.add(historyHeader);
		    
		        JTextArea historyBody = new JTextArea("Here are all the high scores.", 10, 10);
		        historyBody.setEditable(false);
                historyBody.setFont(font2);
                historyBody.setForeground(Color.BLUE);
		        centerPanel.add(historyBody);
                }
            else if(newScreen.equals("Keyboard Tool")){
            	JTextArea keyboardHeader = new JTextArea("Make Music!", 1, 5);
                keyboardHeader.setFont(font1);
                keyboardHeader.setForeground(Color.BLUE);
                keyboardHeader.setEditable(false);
		        topPanel.add(keyboardHeader);
                
               
                //Change the grid layout to 6x4 for our keyboard
                centerPanel.setLayout(new GridLayout(4,6));
                
                //First Row Keyboard Buttons
                JButton button1 = new JButton("F#");
                JButton button2 = new JButton("A");
                JButton button3 = new JButton("C");
                JButton button4 = new JButton("D");
                JButton button5 = new JButton("E");
                JButton button6 = new JButton("G");
                
                //Second Row Keyboard Buttons
                JButton button7 = new JButton("B");
                JButton button8 = new JButton("C");
                JButton button9 = new JButton("D");
                JButton button10 = new JButton("F");
                JButton button11 = new JButton("G");
                
                //First Row Keyboard Labels
                JLabel label1 = new JLabel("Q", JLabel.CENTER);
                JLabel label2 = new JLabel("W", JLabel.CENTER);
                JLabel label3 = new JLabel("E", JLabel.CENTER);
                JLabel label4 = new JLabel("R", JLabel.CENTER);
                JLabel label5 = new JLabel("T", JLabel.CENTER);
                JLabel label6 = new JLabel("Y", JLabel.CENTER);
                
                //Second Row Keyboard Labels
                JLabel label7 = new JLabel("A", JLabel.CENTER);
                JLabel label8 = new JLabel("S", JLabel.CENTER);
                JLabel label9 = new JLabel("D", JLabel.CENTER);
                JLabel label10 = new JLabel("F", JLabel.CENTER);
                JLabel label11 = new JLabel("G", JLabel.CENTER);
                JLabel label12 = new JLabel(""); //just a blank label so the grid will work
                
                
                //Add First Row Labels
                centerPanel.add(label1);
                centerPanel.add(label2);
                centerPanel.add(label3);
                centerPanel.add(label4);
                centerPanel.add(label5);
                centerPanel.add(label6);
                
                //Add First Row Buttons
                centerPanel.add(button1);
                centerPanel.add(button2);
                centerPanel.add(button3);
                centerPanel.add(button4);
                centerPanel.add(button5);
                centerPanel.add(button6);
                
                //Add Second Row Labels
                centerPanel.add(label7);
                centerPanel.add(label8);
                centerPanel.add(label9);
                centerPanel.add(label10);
                centerPanel.add(label11);
                centerPanel.add(label12);
                
                //Add Second Row Buttons
                centerPanel.add(button7);
                centerPanel.add(button8);
                centerPanel.add(button9);
                centerPanel.add(button10);
                centerPanel.add(button11);
                
                }
            else if (newScreen.equals("Pitch Perfector-Marathon")||
            		 newScreen.equals("Pitch Perfector-Practice")||
            		 newScreen.equals("Pitch Perfector-Test")){
                //Note Panel Buttons
                JButton button1 = new JButton("Note 1");
                button1.setSize(500,500);
                JButton button2 = new JButton("Note 2");
                JButton button3 = new JButton("Note 3");
                JButton button4 = new JButton("Note 4");
                JLabel button5 = new JLabel("Round: 1/10", JLabel.CENTER);
                JLabel button6 = new JLabel("Score: 500", JLabel.CENTER);
            
                //Top Panel Buttons
                JButton buttonB = new JButton("Help");
                
                //Create Music Note Icon
                //ImageIcon musicNote = createImageIcon("Documents/workspace/Musical Madness/bin/note.gif");
                
                // Set the buttons up to register actions
                button1.setActionCommand(button1.getText());
                button2.setActionCommand(button2.getText());
                button3.setActionCommand(button3.getText());
                button4.setActionCommand(button4.getText());
                buttonB.setActionCommand(buttonB.getText());
            
                
                button1.addActionListener(this);
                button2.addActionListener(this);
                button3.addActionListener(this);
                button4.addActionListener(this);
                buttonB.addActionListener(this);
            
                // Add buttons to interface
                //bottomPanel.add(pressed);
                bottomPanel.add(button1);
                bottomPanel.add(button2);
                bottomPanel.add(button3);
                bottomPanel.add(button4);
                topPanel.add(button5);
                topPanel.add(button6);
                topPanel.add(buttonB);
                }
            else if (newScreen.equals("Tuning Tester-Marathon")||
           		 newScreen.equals("Tuning Tester-Practice")||
           		 newScreen.equals("Tuning Tester-Test")){
               //Note Panel Buttons
               JButton button1 = new JButton("Play Mystery Note");
               button1.setSize(500,500);
               JButton button2 = new JButton("Play Known Notes");
               JButton button3 = new JButton("Note 1");
               JButton button4 = new JButton("Note 2");
               JButton button5 = new JButton("Note 3");
               JButton button6 = new JButton("Note 4");
               JLabel button7 = new JLabel("Round: 1/10", JLabel.CENTER);
               JLabel button8 = new JLabel("Score: 500", JLabel.CENTER);
               JLabel button9 = new JLabel("Which note was the mystery note?", JLabel.CENTER);

           
               //Top Panel Buttons
               JButton buttonB = new JButton("Help");
               
               //Create Music Note Icon
               //ImageIcon musicNote = createImageIcon("Documents/workspace/Musical Madness/bin/note.gif");
               
               // Set the buttons up to register actions
               button1.setActionCommand(button1.getText());
               button2.setActionCommand(button2.getText());
               button3.setActionCommand(button3.getText());
               button4.setActionCommand(button4.getText());
               button5.setActionCommand(button4.getText());
               button6.setActionCommand(button4.getText());
               buttonB.setActionCommand(buttonB.getText());
           
               
               button1.addActionListener(this);
               button2.addActionListener(this);
               button3.addActionListener(this);
               button4.addActionListener(this);
               button5.addActionListener(this);
               button6.addActionListener(this);
               buttonB.addActionListener(this);
           
               // Add buttons to interface
               bottomPanel.add(button9);
               bottomPanel.add(button3);
               bottomPanel.add(button4);
               bottomPanel.add(button5);
               bottomPanel.add(button6);
               centerPanel.add(button1);
               centerPanel.add(button2);
               topPanel.add(button7);
               topPanel.add(button8);
               topPanel.add(buttonB);
               }
            else if (newScreen.equals("Name That Instrument-Marathon")||
              		 newScreen.equals("Name That Instrument-Practice")||
              		 newScreen.equals("Name That Instrument-Test")){
            	System.out.println("Yet to implement Name That Instrument :)");
            }
            else{
              System.out.println("How did you get here?");
                }
        }
		
		centerPanel.revalidate();
        bottomPanel.revalidate();
		topPanel.revalidate();
		System.out.println(newScreen);
    }
    
	/**
	 * Determine which button was pressed and change the label based on which button was pressed.
	 * Pass the label into changeScreen()
	 */
	public void actionPerformed(ActionEvent arg0) {
		// Determine which button was pressed and change the label text appropriately
		String result = arg0.getActionCommand();
		newLabel="";
		if (result.equalsIgnoreCase("Pitch Perfector")||
		result.equalsIgnoreCase("Tuning Tester")||result.equalsIgnoreCase("Name that Instrument")) {
		    newLabel = "Game Select Screen";
		    gameMode=result;
		} else if (result.equalsIgnoreCase("Keyboard Tool")) {
			newLabel = "Keyboard Tool";
		} else if (result.equalsIgnoreCase("Score History")) {
			newLabel = "Score History";
		} else if (result.equalsIgnoreCase("Instructions")) {
		    newLabel = "Instructions";
		} else if (result.equalsIgnoreCase("About")) {
		    newLabel = "About";
		}
		else if (result.equalsIgnoreCase("Marathon")){
		    if(gameMode=="Tuning Tester"){
		        newLabel = "Tuning Tester-Marathon";
		    }
		    else if(gameMode=="Pitch Perfector"){
		        newLabel = "Pitch Perfector-Marathon";
		    }
		    else{
		        newLabel = "Name That Instrument-Marathon";
		    }
		} else if (result.equalsIgnoreCase("Test")){
		    if(gameMode=="Tuning Tester"){
		        newLabel = "Tuning Tester-Test";
		    }
		    else if(gameMode=="Pitch Perfector"){
		        newLabel = "Pitch Perfector-Test";
		    }
		    else{
		        newLabel = "Name That Instrument-Test";
		    }
		} else if (result.equalsIgnoreCase("Practice")){
		    if(gameMode=="Tuning Tester"){
		        newLabel = "Tuning Tester-Practice";
		    }
		    else if(gameMode=="Pitch Perfector"){
		        newLabel = "Pitch Perfector-Practice";
		    }
		    else{
		        newLabel = "Name That Instrument-Practice";
		    }
		}else {
			newLabel = "Home";
			gameMode = "";
		}
		changeScreen(newLabel);
	}
    
	/**
	 * Generates and runs the GUI.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MusicalMadness();

	}

}
