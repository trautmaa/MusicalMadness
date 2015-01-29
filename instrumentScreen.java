import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Instrument;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class instrumentScreen implements ActionListener {
	public ArrayList<JButton> buttonList;
	public String correctAnswer;
	public ArrayList<String> wrongAnswers;
	public ArrayList<String> allAnswers;
	public String randNote;
	
	
	//generate panels and home button
	public instrumentScreen(int numRight, int numTries, String gameType, Container pane){
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
		
		JTextArea historyHeader = new JTextArea("Name That Instrument", 1, 5);
        historyHeader.setBackground(Color.BLUE);
        historyHeader.setEditable(false);
        historyHeader.setForeground(Color.WHITE);
        topPanel.add(historyHeader);
		
		JButton homeButton = new JButton("Home");
        buttonList.add(homeButton);
        topPanel.add(homeButton);
        
      //generate other text
	    JLabel button5 = new JLabel("",JLabel.CENTER);
        JLabel button6 = new JLabel("",JLabel.CENTER);
        if(gameType=="Test"){
        	button5.setText("Round: " + Integer.toString(numTries)+ "/10");
        	button6.setText("Score: "+ Integer.toString(numRight) + "/"+ Integer.toString(numTries));
        }
        else if(gameType=="Marathon"){
        	button5.setText("Round: " + Integer.toString(numTries));
        	button6.setText("Lives Remaining: "+ Integer.toString(5-numTries+numRight));
        }
        else{
        	button5.setText("");
        	button6.setText("Score: Fun!");
        }
        
	    JButton buttonB = new JButton("Help");
	    
        //generate possible answers
        NoteDict dict = new NoteDict(); //create new note dictionary
        Random rand = new Random();
        //put them in ArrayList allAnswers if they aren't already
        allAnswers = new ArrayList<String>();
        while (allAnswers.size() < 4) {
        	randNote = dict.getRandomInstrumentString();
        	if (!allAnswers.contains(randNote)) {
        		allAnswers.add(randNote);
        	}
        }
        //pick an answer to be correct
        correctAnswer = allAnswers.get(rand.nextInt(4));
        //add wrong answers to list
        wrongAnswers = new ArrayList<String>();
        for (int i=0; i<4; i++) {
        	String curAnswer = allAnswers.get(i);
        	if (!(curAnswer == correctAnswer)) {
        		wrongAnswers.add(curAnswer);
        	}
        }
	    
      //button for mystery note
	    JButton mysteryButton = new JButton("Play Mystery Instrument");
	    
        //generate buttons for answers        
	    JButton button1 = new JButton(allAnswers.get(0));
	    JButton button2 = new JButton(allAnswers.get(1));
	    JButton button3 = new JButton(allAnswers.get(2));
	    JButton button4 = new JButton(allAnswers.get(3));
	    
	    /*TODO: Create Music Note Icon
	    ImageIcon musicNote = createImageIcon("Documents/workspace/Musical Madness/bin/note.gif");
	    */

	    // Add buttons to interface
	    //bottomPanel.add(pressed);
	    bottomPanel.add(button1);
	    bottomPanel.add(button2);
	    bottomPanel.add(button3);
	    bottomPanel.add(button4); 
	    
	    centerPanel.add(mysteryButton);
	    
	    topPanel.add(button5);
	    topPanel.add(button6);
	    topPanel.add(buttonB);
	    
	    buttonList.add(button1);
	    buttonList.add(button2);
	    buttonList.add(button3);
	    buttonList.add(button4);
	    buttonList.add(buttonB);
	    mysteryButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		NoteDict dict = new NoteDict();
		int channel = 0;
        int volume = 80;
        int duration = 1000;
        dict = new NoteDict();
        try{
                Synthesizer synth = MidiSystem.getSynthesizer();
                synth.open();
                MidiChannel[] channels = synth.getChannels();
                Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
                synth.loadInstrument(instr[dict.getInstrumentInt(correctAnswer)]);
                channels[0].programChange(dict.getInstrumentInt(correctAnswer));
        
                channels[channel].noteOn(64, volume );
                Thread.sleep( duration );
                channels[channel].noteOff(64);
                
                channels[channel].noteOn(60, volume);
                Thread.sleep( duration );
                channels[channel].noteOff(64);
                
                channels[channel].noteOn( 62, volume );
                Thread.sleep( duration );
                channels[channel].noteOff( 64 );
                
                channels[channel].noteOn( 60, volume );
                Thread.sleep( duration );
                channels[channel].noteOff( 64 );
                
                synth.close();
        }
        catch (Exception e) {
                e.printStackTrace();
        }
	}

	public ArrayList<JButton> getButtons(){
		return buttonList;
	}
	public String getCorrectAnswer(){
		return correctAnswer;
	}
	public ArrayList<String> getWrongAnswers(){
		return wrongAnswers;
	}
}
