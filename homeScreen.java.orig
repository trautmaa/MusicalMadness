import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;


public class homeScreen {
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	public JButton button;
	public ArrayList<JButton> buttonList;
	
	public  homeScreen(Container pane){
		if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
		buttonList= new ArrayList<JButton>();
        pane.setLayout(new GridBagLayout());
        Dimension panelD = new Dimension(1441, 840);
        pane.setPreferredSize(panelD);
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
        	//natural height, maximum width
        	c.fill = GridBagConstraints.HORIZONTAL;
        }
        
        JLabel text = new JLabel(new ImageIcon("src/images/EarHeroTitle.png"));
		
        
        c.gridx = 0;
        c.weighty = 1.0;
        c.gridwidth=5;
        c.gridy = 0;
		
        pane.add(text,c);
        
        //This button gives access to the third game mode, Tuning Tester. We did not have time to implement the mode, so we commented
        //out this button, which makes it impossible to access Tuning Tester.
        
        /*JButton button1 = new JButton(new ImageIcon("src/images/TuningTesterButton.png"));
        button1.setToolTipText("Tuning Tester");
        button1.setBorder(LineBorder.createGrayLineBorder());
        button1.setBorder(LineBorder.createGrayLineBorder());
        //c.weightx=1;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth=1;
        //c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(button1, c);
        buttonList.add(button1);*/
        
        JButton button2 = new JButton(new ImageIcon("src/images/NameThatInstrumentButton.png"));//NameThatInstrumentButton.png"));
        button2.setToolTipText("Name That Instrument");
        button2.setBorder(LineBorder.createGrayLineBorder());
        c.gridwidth=1;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(button2, c);
        buttonList.add(button2);
        
        JButton button3 = new JButton(new ImageIcon("src/images/PitchPerfectorButton.png"));//images/PitchPerfectorButton.png"));
        button3.setToolTipText("Pitch Perfector");
        button3.setBorder(LineBorder.createGrayLineBorder());
        c.gridwidth=1;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(button3, c);
        buttonList.add(button3);
        
        JButton button4 = new JButton(new ImageIcon("src/images/AboutButton.png"));//images/AboutButton.png"));
        button4.setToolTipText("About");
        button4.setBorder(LineBorder.createGrayLineBorder());
        button4.setBackground(Color.BLUE);
        c.ipady = 1;      
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 2;
        pane.add(button4, c);
        buttonList.add(button4);
        
        JButton button5 = new JButton(new ImageIcon("src/images/InstructionsButton.png"));//InstructionsButton.png"));
        button5.setToolTipText("Instructions");
        button5.setBorder(LineBorder.createGrayLineBorder());
        button5.setBackground(Color.BLUE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       
        c.weighty = 1.0;   
        c.gridx = 0;       
        c.gridwidth = 1;   
        c.gridy = 2;       
        pane.add(button5, c);
        buttonList.add(button5);
        
        JButton button6 = new JButton(new ImageIcon("src/images/KeyboardButtonTool.png"));//KeyBoardButton.png"));
        button6.setToolTipText("Keyboard");
        button6.setBorder(LineBorder.createGrayLineBorder());
        button6.setBackground(Color.BLUE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       
        c.weighty = 1.0;   
        c.gridx = 1;       
        c.gridwidth = 1;   
        c.gridy = 2;       
        pane.add(button6, c);
        buttonList.add(button6);
        
        JButton button7 = new JButton(new ImageIcon("src/images/ScoreHistoryButton.png"));
        button7.setBorder(LineBorder.createGrayLineBorder());
        button7.setToolTipText("Score History");
        button7.setBackground(Color.BLUE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       
        c.weighty = 1.0; 
        c.gridx = 2;       
        c.gridwidth = 1;   
        c.gridy = 2;       
        pane.add(button7, c);
        buttonList.add(button7);
       
	}
	
	
	public ArrayList<JButton> getButtons(){
		return buttonList;
	}
}
