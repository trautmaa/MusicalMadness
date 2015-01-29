import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class graphics extends JFrame{

	private ImageIcon backgroundIcon;
	private JPanel mainPanel;
	private JTabbedPane pane;
	
	public graphics(){
		try{
	        backgroundIcon = new ImageIcon(ImageIO.read(new File("src/images/Background.png")));
					}catch(IOException ex){}	
	//sets up the YahtzeeGUI frame
			this.setSize(1000,700);
			this.setTitle("Yahtzee");
			this.setResizable(false); 
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//Sets the location based on the screen
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension d = tk.getScreenSize();
			int x = d.width/8;
			int y = d.height/8;
			this.setLocation(x,y);
			
			//finish panel setup
			createHomeView();
}

	public void createHomeView()
	{
		JTabbedPane homeTabbedView = new JTabbedPane();
		
		JPanel mainPanel = new MainPanel();


		homeTabbedView.addTab("Home", backgroundIcon, mainPanel);

		
		this.add(homeTabbedView);
		this.setVisible(true);
	}
}