import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;


public class gameModeScreen {
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	public JButton button;
	public ArrayList<JButton> buttonList;
	public String gametype;
    
	public  gameModeScreen(Container pane){
		buttonList= new ArrayList<JButton>();
        pane.setLayout(new GridBagLayout());
        Dimension panelD = new Dimension(500,300);
        pane.setPreferredSize(panelD);
        GridBagConstraints c = new GridBagConstraints();
		
        JLabel text = new JLabel(new ImageIcon("src/images/SelectGameModeTitle.png"));
		
		
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        //c.gridwidth=3;
        c.gridy = 0;
        
        pane.add(text,c);
        
        JButton marathonButton = new JButton(new ImageIcon("src/images/MarathonButton.png"));
        marathonButton.setBorder(LineBorder.createGrayLineBorder());
        marathonButton.setToolTipText("Marathon");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(marathonButton, c);
        buttonList.add(marathonButton);
        
        JButton testButton = new JButton(new ImageIcon("src/images/TestButton.png"));
        testButton.setBorder(LineBorder.createGrayLineBorder());
        testButton.setToolTipText("Test");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(testButton, c);
        buttonList.add(testButton);
        
        JButton practiceButton = new JButton(new ImageIcon("src/images/PracticeButton.png"));
        practiceButton.setBorder(LineBorder.createGrayLineBorder());
        practiceButton.setToolTipText("Practice");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(practiceButton, c);
        buttonList.add(practiceButton);
        
        button = new JButton(new ImageIcon("src/images/HomeButton.png"));
        button.setBorder(LineBorder.createGrayLineBorder());
        button.setToolTipText("Home");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(button, c);
        buttonList.add(button);
        
	}
	
	public ArrayList<JButton> getButtons(){
		return buttonList;
	}
}
