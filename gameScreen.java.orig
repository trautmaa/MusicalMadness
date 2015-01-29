import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class gameScreen {
	public JButton button;
	public ArrayList<JButton> buttonList;
	public String correctAnswer;
	public ArrayList<String> xAnswer;
	
	public gameScreen(int numRight, int numTries, String gameType, String gameType2, Container pane){
		buttonList= new ArrayList<JButton>();
        pane.setLayout(new BorderLayout());
        Dimension panelD = new Dimension(1000,600);
        pane.setPreferredSize(panelD);
        //Constructs the appropriate screen given the game type inputs.
        if(gameType=="Pitch Perfector"){
        	pitchScreen newScreen = new pitchScreen(numRight, numTries,gameType2, pane);
        	buttonList=newScreen.getButtons();
        	correctAnswer=newScreen.getCorrectAnswer();
        	xAnswer=newScreen.getWrongAnswers();
        }
        else if(gameType=="Tuning Tester"){
        	//Not Implemented
        	tuningScreen newScreen =new tuningScreen(numRight, numTries,gameType2, pane);
        	buttonList=newScreen.getButtons();
        	correctAnswer=newScreen.getCorrectAnswer();
        	xAnswer=newScreen.getxAnswers();
        }
        else{
        	instrumentScreen newScreen = new instrumentScreen(numRight, numTries,gameType2, pane);
        	buttonList=newScreen.getButtons();
        	correctAnswer=newScreen.getCorrectAnswer();
        	xAnswer=newScreen.getWrongAnswers();
        }
        
        /*JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		pane.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3));
        pane.add(bottomPanel, BorderLayout.SOUTH);
        
		// Add a label
		
		JPanel topPanel = new JPanel();
		pane.add(topPanel, BorderLayout.NORTH);
        
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
        
    
        // Add buttons to interface
        //bottomPanel.add(pressed);
        bottomPanel.add(button1);
        bottomPanel.add(button2);
        bottomPanel.add(button3);
        bottomPanel.add(button4);
        topPanel.add(button5);
        topPanel.add(button6);
        topPanel.add(buttonB);
        
        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(buttonB);*/
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
