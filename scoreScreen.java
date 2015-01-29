import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;


public class scoreScreen {
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	public JButton button;
	public ArrayList<JButton> buttonList;
    
	public  scoreScreen(ArrayList<Integer> iTestScore, ArrayList<Integer> iMarathonScore, ArrayList<Integer> pTestScore, ArrayList<Integer> pMarathonScore, Container pane){
		Font font1 = new Font("Verdana", Font.BOLD, 80);
        Font font2 = new Font("Verdana", Font.BOLD, 20);
		buttonList= new ArrayList<JButton>();
        pane.setLayout(new BorderLayout());
        Dimension panelD = new Dimension(500,300);
        pane.setPreferredSize(panelD);
		
        JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 2));
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
        
        JTextArea historyHeader = new JTextArea("High Scores", 1, 5);
        historyHeader.setEditable(false);
        historyHeader.setFont(font1);
        historyHeader.setForeground(Color.WHITE);
        historyHeader.setBackground(Color.BLUE);
        topPanel.add(historyHeader);
        
        String text = "";
        if(iMarathonScore.size()!=0){
        	for(int i=0; i<iMarathonScore.size();i++){
        		text=text + iMarathonScore.get(i) +"\n";
        	}
        }
        
        GridBagConstraints c = new GridBagConstraints();
        
        JTextArea marathonBody = new JTextArea("Name That Instrument \n Marathon Mode. \n" + text, 10, 10);
        marathonBody.setEditable(false);
        marathonBody.setFont(font2);
        marathonBody.setForeground(Color.WHITE);
        marathonBody.setBackground(Color.BLUE);
        
        c.gridx = 0;
        c.gridy = 0;
        
        centerPanel.add(marathonBody,c);
        
        text = "";
        if(pMarathonScore.size()!=0){
        	for(int i=0; i<pMarathonScore.size();i++){
        		text=text + pMarathonScore.get(i) +"\n";
        	}
        }
        
        JTextArea marathonBody1 = new JTextArea("Pitch Perfector \n Marathon Mode. \n" + text, 10, 10);
        marathonBody1.setEditable(false);
        marathonBody1.setFont(font2);
        marathonBody1.setForeground(Color.WHITE);
        marathonBody1.setBackground(Color.BLUE);
        
        c.gridx = 1;
        c.gridy = 0;
        
        centerPanel.add(marathonBody1,c);

        
        text = "";
        if(iTestScore.size()!=0){
        	for(int i=0; i<iTestScore.size();i++){
        		text=text + iTestScore.get(i) + "\n";
        	}
        }
        
        JTextArea testBody = new JTextArea("Name That Instrument \n Test Mode. \n" + text, 10, 10);
        testBody.setEditable(false);
        testBody.setFont(font2);
        testBody.setForeground(Color.WHITE);
        testBody.setBackground(Color.BLUE);
        
        c.gridx = 0;
        c.gridy = 1;
        
        centerPanel.add(testBody,c);
        
        text = "";
        if(pTestScore.size()!=0){
        	for(int i=0; i<pTestScore.size();i++){
        		text=text + pTestScore.get(i) + "\n";
        	}
        }
        
        JTextArea testBody1 = new JTextArea("Pitch Perfector \n Test Mode. \n" + text, 10, 10);
        testBody1.setEditable(false);
        testBody1.setFont(font2);
        testBody1.setForeground(Color.WHITE);
        testBody1.setBackground(Color.BLUE);
        
        c.gridx = 1;
        c.gridy = 1;
        
        centerPanel.add(testBody1,c);
	}
	
	public ArrayList<JButton> getButtons(){
		return buttonList;
	}
}
