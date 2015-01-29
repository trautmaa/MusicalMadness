import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;


public class instructionScreen{
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	public JButton button;
	public ArrayList<JButton> buttonList;
    
	public instructionScreen(Container pane){
		Font font1 = new Font("Verdana", Font.BOLD, 80);
        Font font2 = new Font("Verdana", Font.BOLD, 20);
		buttonList= new ArrayList<JButton>();
        pane.setLayout(new BorderLayout());
        Dimension panelD = new Dimension(500,300);
        pane.setPreferredSize(panelD);
		
        JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		pane.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3));
        pane.add(bottomPanel, BorderLayout.SOUTH);
        
		// Add a label
		
		JPanel topPanel = new JPanel();
		pane.add(topPanel, BorderLayout.NORTH);
		
		JButton homeButton = new JButton(new ImageIcon("src/images/HomeButton.png"));
		homeButton.setBorder(LineBorder.createGrayLineBorder());
		homeButton.setToolTipText("Home");
        buttonList.add(homeButton);
        topPanel.add(homeButton);
        
		JTextArea instructionHeader = new JTextArea("How To Play", 1, 5);
		instructionHeader.setBackground(Color.BLUE);
        instructionHeader.setEditable(false);
        instructionHeader.setFont(font1);
        instructionHeader.setForeground(Color.WHITE);
        //text.setFont(newFont("Serif", Font.ITALIC,16));
        topPanel.add(instructionHeader);
    
        JTextArea instructionBody = new JTextArea("Welcome to Ear Hero! This program contains a collection of minigames \n" +
        		"and tools to help you improve your ear for music. The pitch perfector game asks you to identify a random note. \n" +
        		"Name That Instrument plays some notes and asks the user to identify the instrument. There are three game modes. \n" +
        		"In marathon mode, the game ends after 5 incorrect answers. In test mode, the game ends after 10 attempts. \n" +
        		"In practice mode, the game continues indefinitely. Scores can be viewed by clicking the score history button \n" +
        		"The keyboard tool lets you turn your keyboard (or mouse) into a piano or percussion instrument! Have fun!", 10, 10);
        instructionBody.setBackground(Color.BLUE);
        instructionBody.setEditable(false);
        instructionBody.setFont(font2);
        instructionBody.setForeground(Color.WHITE);
        centerPanel.add(instructionBody);
		
        /*JTextArea text = new JTextArea("Ear Hero", 1, 5);
		text.setEditable(false);
		Font font = new Font("Verdana", Font.BOLD, 40);
        text.setFont(font);
        text.setForeground(Color.BLUE);
		
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx=2;
        c.gridx = 1;
        c.gridwidth=1;
        c.gridy = 0;
        
        pane.add(text,c);
        
        JTextArea text1 = new JTextArea("Blah blah blah...", 1, 5);
		text1.setEditable(false);
		Font font1 = new Font("Verdana", Font.BOLD, 16);
        text1.setFont(font1);
        text1.setForeground(Color.BLUE);
		
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridwidth=1;
        c.gridy = 1;
        
        pane.add(text1,c);
        
        button = new JButton("Home");
        if (shouldWeightX) {
        	c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(button, c);
        buttonList.add(button);*/
	}
	
	public ArrayList<JButton> getButtons(){
		return buttonList;
	}
}
