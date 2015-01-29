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


public class aboutScreen {
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	public JButton button;
	public ArrayList<JButton> buttonList;
    
	public  aboutScreen(Container pane){
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
        
		
		JPanel topPanel = new JPanel();
		pane.add(topPanel, BorderLayout.NORTH);
		
		JButton homeButton = new JButton(new ImageIcon("src/images/HomeButton.png"));
		homeButton.setBorder(LineBorder.createGrayLineBorder());
        homeButton.setToolTipText("Home");
        buttonList.add(homeButton);
        topPanel.add(homeButton);
		
        JTextArea historyHeader = new JTextArea("About", 1, 5);
        historyHeader.setBackground(Color.BLUE);
        historyHeader.setEditable(false);
        historyHeader.setFont(font1);
        historyHeader.setForeground(Color.WHITE);
        //text.setFont(newFont("Serif", Font.ITALIC,16));
        topPanel.add(historyHeader);
    
        JTextArea historyBody = new JTextArea("Ear Hero was developed in Spring, " +
        		"2014 by Austin Lane, Zach Lynn, Alex Trautman, and Sef van Kan.", 10, 10);
        historyBody.setEditable(false);
        historyBody.setBackground(Color.BLUE);
        historyBody.setFont(font2);
        historyBody.setForeground(Color.WHITE);
        //text.setFont(newFont("Serif", Font.ITALIC,16));
        centerPanel.add(historyBody);
	}
	
	public ArrayList<JButton> getButtons(){
		return buttonList;
	}
}
