import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class tuningScreen {
	public ArrayList<JButton> buttonList;
	public String correctAnswer;
	public ArrayList<String> xAnswer;
	
	public tuningScreen(int numRight, int numTries, String gameType, Container pane){
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
		
		JButton homeButton = new JButton("Home");
        buttonList.add(homeButton);
        topPanel.add(homeButton);
	    
		JButton button1 = new JButton("Play Mystery Note");
        button1.setSize(500,500);
        JButton button2 = new JButton("Play Known Notes");
        JButton button3 = new JButton("Note 1");
        JButton button4 = new JButton("Note 2");
        JButton button5 = new JButton("Note 3");
        JButton button6 = new JButton("Note 4");
        
        JLabel button7 = new JLabel("",JLabel.CENTER);
        JLabel button8 = new JLabel("",JLabel.CENTER);
        if(gameType=="Test"){
        	button7.setText("Round: " + Integer.toString(numTries)+ "/10");
        	button8.setText("Score: "+ Integer.toString(numRight) + "/"+ Integer.toString(numTries));
        }
        else if(gameType=="Marathon"){
        	button7.setText("Round: " + Integer.toString(numTries));
        	button8.setText("Lives Remaining: "+ Integer.toString(5-numTries+numRight));
        }
        else{
        	button7.setText("Have Fun!");
        	button8.setText("Score: Fun!");
        }
        
        
        
        JLabel button9 = new JLabel("Which note was the mystery note?", JLabel.CENTER);

    
        //Top Panel Buttons
        JButton buttonB = new JButton("Help");
        
        //Create Music Note Icon
        //ImageIcon musicNote = createImageIcon("Documents/workspace/Musical Madness/bin/note.gif");
    
        Random rand = new Random();
        xAnswer=new ArrayList<String>();
	    int correctIndex = rand.nextInt(4) + 1;
	    for(int i=1; i<5; i++){
	    	if(i==correctIndex){
	    		correctAnswer="Note "+Integer.toString(correctIndex);
	    		System.out.println(correctAnswer);
	    	}
	    	else{
	    		xAnswer.add("Note "+Integer.toString(i));
	    	}
	    }
        
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
	    
	    buttonList.add(button1);
	    buttonList.add(button2);
	    buttonList.add(button3);
	    buttonList.add(button4);
	    buttonList.add(button5);
	    buttonList.add(button6);
	    buttonList.add(buttonB);
	}

	public ArrayList<JButton> getButtons(){
		return buttonList;
	}
	
	public String getCorrectAnswer(){
		return correctAnswer;
	}
	public ArrayList<String> getxAnswers(){
		return xAnswer;
	}
}
