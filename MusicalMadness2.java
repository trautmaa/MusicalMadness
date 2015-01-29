import javax.imageio.ImageIO;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")

public class MusicalMadness2 implements ActionListener{
	protected JFrame frame;
    public String gameType;
    public String gameType2;
    public String correctAnswer;
    public ArrayList<String> xAnswer;
    public int numRight;
    public int numTries;
    public ArrayList<Integer> iTestScore;
    public ArrayList<Integer> iMarathonScore;
    public ArrayList<Integer> pTestScore;
    public ArrayList<Integer> pMarathonScore;
    public NoteDict noteDict;
    public int currChannel;

    //Adds listeners to the new screen's buttons.
    public void addListeners(ArrayList<JButton> buttonList){
    	for (int i = 0; i < buttonList.size(); i++) {
    		//If the text is blank, the ToolTipText is used instead
    		if(buttonList.get(i).getText()==""){
    			buttonList.get(i).setActionCommand(buttonList.get(i).getToolTipText());
    		}
    		else{
    			buttonList.get(i).setActionCommand(buttonList.get(i).getText());
    		}
			buttonList.get(i).addActionListener(this);
		}
    }
    
    /**
     * The default constructor creates a frame and adds the home screen to it.
     */
	public MusicalMadness2() {
		// Set up the bounding frame
		frame = new JFrame("Ear Hero");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		
		frame.setSize(1441, 840);
		frame.setResizable(false);
		
		//Generates the home screen
		homeScreen newScreen = new homeScreen(frame.getContentPane());
		addListeners(newScreen.getButtons());
		
		frame.setBackground(Color.BLUE);
		frame.pack();
		frame.setVisible(true);
		
		//Initializes game type, answer and score variables
		gameType="";
		gameType2="";
		xAnswer=new ArrayList<String>();
		xAnswer.add("Sef");
		xAnswer.add("Alex");
		xAnswer.add("Zach");
	    iTestScore=new ArrayList<Integer>();
	    iMarathonScore=new ArrayList<Integer>();
	    pTestScore=new ArrayList<Integer>();
	    pMarathonScore=new ArrayList<Integer>();
	    currChannel=0;
	    
	    noteDict = new NoteDict();
	}
	
	//Adds new entries in the correct entry for the high score list. The size of each high score list is limited to five.
	public void checkScores(ArrayList<Integer> scoreList, int newScore){
		if(scoreList.size()==0){
			scoreList.add(newScore);
		}
		else{
			ArrayList<Integer> tempList =new ArrayList<Integer>();
			for(int i=0; i<scoreList.size();i++){
				if(newScore>=scoreList.get(i)){
					for(int j=0; j<scoreList.size();j++){
						if(i==j){
							tempList.add(newScore);
						}
						tempList.add(scoreList.get(j));
					}	
				}
			}
			scoreList=tempList;
			if(scoreList.size()==6){
				scoreList.remove(5);
			}
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// Determine which button was pressed and navigate to the appropriate screen
		String result = arg0.getActionCommand();
		
		//First the pane is cleared
		frame.getContentPane().removeAll();
		frame.repaint();
		
		//Checks to see which button was pressed
		if(result=="Instructions"){
			instructionScreen newScreen = new instructionScreen(frame.getContentPane());
			addListeners(newScreen.getButtons());
		}
		else if(result=="About"){
			aboutScreen newScreen = new aboutScreen(frame.getContentPane());
			addListeners(newScreen.getButtons());
		}
		else if(result=="Pitch Perfector"||result=="Tuning Tester"||result=="Name That Instrument"){
			//The game type is set and the numRight/numTries are reset
			gameType=result;
			numRight=0;
			numTries=0;
			gameModeScreen newScreen = new gameModeScreen(frame.getContentPane());
			addListeners(newScreen.getButtons());
		}
		else if(result=="Marathon"||result=="Test"||result=="Practice"){
			gameType2=result;
			//Make the game screen that corresponds with the 2 game types
			gameScreen newScreen = new gameScreen(numRight, numTries, gameType, gameType2, frame.getContentPane());
			addListeners(newScreen.getButtons());
			//Obtains the action commands for the right and wrong answers
			xAnswer=newScreen.getxAnswers();
			correctAnswer=newScreen.getCorrectAnswer();
		}
		//Answer is correct
		else if(result.equals(correctAnswer)){
			numRight=numRight+1;
			numTries=numTries+1;
			//Ends the game
			if(gameType2=="Test"&& numTries==11){
				createDialogBox(false,true);
				homeScreen newScreen = new homeScreen(frame.getContentPane());
				addListeners(newScreen.getButtons());
				if(gameType=="Name That Instrument"){
					checkScores(iTestScore,numRight);
				}
				else{
					checkScores(pTestScore,numRight);
				}
				gameType="";
				gameType2="";
			}
			//Continues the game
			else{
				gameScreen newScreen = new gameScreen(numRight, numTries, gameType, gameType2, frame.getContentPane());
				createDialogBox(true,true);
				xAnswer=newScreen.getxAnswers();
				correctAnswer=newScreen.getCorrectAnswer();
				addListeners(newScreen.getButtons());
			}
		}
		//Answer is incorrect
		else if(result.equals(xAnswer.get(0))||result.equals(xAnswer.get(1))||result.equals(xAnswer.get(2))){
			numTries=numTries+1;
			if(gameType2=="Test"){
				//End the game
				if(numTries==11){
					homeScreen newScreen = new homeScreen(frame.getContentPane());
					createDialogBox(false,false);
					addListeners(newScreen.getButtons());
					gameType="";
					gameType2="";
					if(gameType=="Name That Instrument"){
						checkScores(iTestScore,numRight);
					}
					else{
						checkScores(pTestScore,numRight);
					}
				}
				else{
					gameScreen newScreen = new gameScreen(numRight, numTries, gameType, gameType2, frame.getContentPane());
					createDialogBox(true,false);
					addListeners(newScreen.getButtons());
					xAnswer=newScreen.getxAnswers();
					correctAnswer=newScreen.getCorrectAnswer();
				}
			}
			else if(gameType2=="Marathon"){
				//End the game
				if(5-numTries+numRight==0){
					homeScreen newScreen = new homeScreen(frame.getContentPane());
					addListeners(newScreen.getButtons());
					gameType="";
					gameType2="";
					if(gameType=="Name That Instrument"){
						checkScores(iMarathonScore,numRight);
					}
					else{
						checkScores(pMarathonScore,numRight);
					}
					createDialogBox(false,false);
				}
				else{
					gameScreen newScreen = new gameScreen(numRight, numTries, gameType, gameType2, frame.getContentPane());
					addListeners(newScreen.getButtons());
					xAnswer=newScreen.getxAnswers();
					correctAnswer=newScreen.getCorrectAnswer();
					createDialogBox(true,false);
				}	
			}
			else{
				createDialogBox(true,false);
				gameScreen newScreen = new gameScreen(numRight, numTries, gameType, gameType2, frame.getContentPane());
				addListeners(newScreen.getButtons());
				xAnswer=newScreen.getxAnswers();
				correctAnswer=newScreen.getCorrectAnswer();
			}
		}
		else if(result=="Score History"){
			//scoreScreen takes the two scorelists as input
			scoreScreen newScreen = new scoreScreen(iTestScore, iMarathonScore, pTestScore, pMarathonScore, frame.getContentPane());
			addListeners(newScreen.getButtons());
		}
		else if(result=="Keyboard"){
			keyboardtoolScreen newScreen = new keyboardtoolScreen(frame.getContentPane(), currChannel);
			addListeners(newScreen.getButtons());
		}
		//If one of the note buttons is pressed, a note is played.
		else if(result=="C"||result=="D"||result=="E"||result=="F"||result=="G"||result=="A"||result=="B"||result=="C#"||result=="D#"||result=="F#"||result=="G#"||result=="A#"){
            System.out.println(Integer.toString(currChannel));
			int pitch = noteDict.getPitchInt(result);
            int channel = currChannel; // 0 is a piano, 9 is percussion, other channels are for other instruments
            int volume = 80; // between 0 et 127
            int duration = 400; // in milliseconds
            try{
                    Synthesizer synth = MidiSystem.getSynthesizer();
                    synth.open();
                    MidiChannel[] channels = synth.getChannels();
                    //Load the instruments
    				Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
    				//Grand Piano
    				synth.loadInstrument(instr[0]);
    				channels[0].programChange(0);
    				//Acoustic Guitar
    				synth.loadInstrument(instr[24]);
    				channels[1].programChange(24);
    				//Electric Bass
    				synth.loadInstrument(instr[34]);
    				channels[2].programChange(34);
    				//Violin
    				synth.loadInstrument(instr[40]);
    				channels[3].programChange(40);
    				//Alto Sax
    				synth.loadInstrument(instr[65]);
    				channels[4].programChange(65);
    				//Recorder
    				synth.loadInstrument(instr[74]);
    				channels[5].programChange(74);
    				//Bagpipes
    				synth.loadInstrument(instr[109]);
    				channels[6].programChange(109);
    				//Banjo
    				synth.loadInstrument(instr[105]);
    				channels[7].programChange(105);
    				//Steel Drum
    				synth.loadInstrument(instr[114]);
    				channels[8].programChange(114);
    				//Gun Shot
    				synth.loadInstrument(instr[127]);
    				channels[10].programChange(127);
                    
            
                    channels[channel].noteOn( pitch, volume ); // C note
                    Thread.sleep( duration );
                    channels[channel].noteOff( pitch );
                    
                    synth.close();
            }
            catch (Exception e) {
                    e.printStackTrace();
            }
            
            keyboardtoolScreen newScreen = new keyboardtoolScreen(frame.getContentPane(),currChannel);
            addListeners(newScreen.getButtons());
		}
		//If one of the channel buttons is pressed, the instrument type is changed
		else if(result=="Ch0"||result=="Ch1"||result=="Ch2"||result=="Ch3"||result=="Ch4"||result=="Ch5"||result=="Ch6"||result=="Ch7"||result=="Ch8"||result=="ChA"){
            if(result.charAt(2)=="A".charAt(0)){
            	currChannel=10;
            }
            else{
            	currChannel=Character.getNumericValue(result.charAt(2));
            }
            System.out.println(Integer.toString(currChannel));
            keyboardtoolScreen newScreen = new keyboardtoolScreen(frame.getContentPane(), currChannel);
            addListeners(newScreen.getButtons());
		}
		else{
			//Generates the home screen and resets the game variables
			homeScreen newScreen = new homeScreen(frame.getContentPane());
			addListeners(newScreen.getButtons());
			currChannel=0;
			gameType="";
			gameType2="";
			xAnswer.add("Sef");
			xAnswer.add("Alex");
			xAnswer.add("Zach");
		}
		frame.setBackground(Color.BLUE);
		frame.validate();
	}
	
	//Gives the user feedback after they submit a guess. 
	public void createDialogBox(Boolean game, Boolean correct ) {
		if(game==true){
			if(correct==true){
				JOptionPane.showMessageDialog(frame, "That's Right!");
			}
			else{
				JOptionPane.showMessageDialog(frame, "Nice Try! \n The Correct Answer Was " + correctAnswer);
			}
		}
		else{
			if(gameType2=="Test"){
				JOptionPane.showMessageDialog(frame, "Game Over! \n Final Score: " + Integer.toString(numRight)+"/10");
			}
			else{
				JOptionPane.showMessageDialog(frame, "Game Over! \n Final Score: " + Integer.toString(numRight));
			}
		}
	}
	
	public static void main(String[] args) {
        //Instantiates the GUI
        new MusicalMadness2();
            }		
}