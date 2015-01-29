
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import java.awt.event.*;



	public class keyboardtoolScreen implements KeyListener {
		final static boolean shouldFill = true;
	    final static boolean shouldWeightX = true;
	    final static boolean RIGHT_TO_LEFT = false;
		public JButton button;
		public ArrayList<JButton> buttonList;
		public Synthesizer synth;
		public MidiChannel[] channels;
		public Instrument[] instr;
		public int pitch;
		public int channel;
	    public int prevChannel;
	    public int volume;
		
		public  keyboardtoolScreen(Container pane, int prevChannel){
			
			Font font1 = new Font("Verdana", Font.BOLD, 120);
			Font font2 = new Font("Verdana", Font.PLAIN, 25);
			Font font3 = new Font("Verdana", Font.PLAIN, 35);
			buttonList= new ArrayList<JButton>();
	        pane.setLayout(new BorderLayout());
	        Dimension panelD = new Dimension(500,300);
	        pane.setPreferredSize(panelD);
	        volume=80;
			
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
			
	        JTextArea keyboardHeader = new JTextArea("Make Music!", 1, 5);
            keyboardHeader.setFont(font1);
            keyboardHeader.setForeground(Color.WHITE);
            keyboardHeader.setBackground(Color.BLUE);
            keyboardHeader.setEditable(false);
	        topPanel.add(keyboardHeader);
            
           
            //Change the grid layout to 6x4 for our keyboard
            centerPanel.setLayout(new GridLayout(6,10));
            
            //Button Keyboard
            JButton keyboardButton1 = new JButton(new ImageIcon("src/images/PianoButton.png"));
            keyboardButton1.setToolTipText("Ch0");
            keyboardButton1.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton2 = new JButton(new ImageIcon("src/images/GuitarButton.png"));
            keyboardButton2.setToolTipText("Ch1");
            keyboardButton2.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton3 = new JButton(new ImageIcon("src/images/BassButton.png"));
            keyboardButton3.setToolTipText("Ch2");
            keyboardButton3.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton4 = new JButton(new ImageIcon("src/images/ViolinButton.png"));
            keyboardButton4.setToolTipText("Ch3");
            keyboardButton4.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton5 = new JButton(new ImageIcon("src/images/SaxophoneButton.png"));
            keyboardButton5.setToolTipText("Ch4");
            keyboardButton5.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton6 = new JButton(new ImageIcon("src/images/RecorderButton.png"));
            keyboardButton6.setToolTipText("Ch5");
            keyboardButton6.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton7 = new JButton(new ImageIcon("src/images/BagpipeButton.png"));
            keyboardButton7.setToolTipText("Ch6");
            keyboardButton7.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton8 = new JButton(new ImageIcon("src/images/BanjoButton.png"));
            keyboardButton8.setToolTipText("Ch7");
            keyboardButton8.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton9 = new JButton(new ImageIcon("src/images/SteelDrumButton.png"));
            keyboardButton9.setToolTipText("Ch8");
            keyboardButton9.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton10 = new JButton(new ImageIcon("src/images/GunButton.png"));
            keyboardButton10.setToolTipText("ChA");
            keyboardButton10.setBorder(LineBorder.createGrayLineBorder());


            JButton keyboardButton11 = new JButton(new ImageIcon("src/images/CButton.png"));
            keyboardButton11.setToolTipText("C");
            keyboardButton11.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton12 = new JButton(new ImageIcon("src/images/DButton.png"));
            keyboardButton12.setToolTipText("D");
            keyboardButton12.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton13 = new JButton(new ImageIcon("src/images/EButton.png"));
            keyboardButton13.setToolTipText("E");
            keyboardButton13.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton14 = new JButton(new ImageIcon("src/images/FButton.png"));
            keyboardButton14.setToolTipText("F");
            keyboardButton14.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton15 = new JButton(new ImageIcon("src/images/GButton.png"));
            keyboardButton15.setToolTipText("G");
            keyboardButton15.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton16 = new JButton(new ImageIcon("src/images/AButton.png"));
            keyboardButton16.setToolTipText("A");
            keyboardButton16.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton17 = new JButton(new ImageIcon("src/images/BButton.png"));
            keyboardButton17.setToolTipText("B");
            keyboardButton17.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton18 = new JButton("");
            JButton keyboardButton19 = new JButton("");
            JLabel keyboardButton20 = new JLabel("");
            
            JButton keyboardButton21 = new JButton(new ImageIcon("src/images/C#Button.png"));
            keyboardButton21.setToolTipText("C#");
            keyboardButton21.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton22 = new JButton(new ImageIcon("src/images/D#Button.png"));
            keyboardButton22.setToolTipText("D#");
            keyboardButton22.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton23 = new JButton("");
            JButton keyboardButton24 = new JButton(new ImageIcon("src/images/F#Button.png"));
            keyboardButton24.setToolTipText("F#");
            keyboardButton24.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton25 = new JButton(new ImageIcon("src/images/G#Button.png"));
            keyboardButton25.setToolTipText("G#");
            keyboardButton25.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton26 = new JButton(new ImageIcon("src/images/A#Button.png"));
            keyboardButton26.setToolTipText("A#");
            keyboardButton26.setBorder(LineBorder.createGrayLineBorder());
            JButton keyboardButton27 = new JButton("");
            JLabel keyboardButton28 = new JLabel("");
            JLabel keyboardButton29 = new JLabel("to", JLabel.CENTER);
            JButton keyboardButton30 = new JButton("type");
            
            keyboardButton29.setFont(font3);
            keyboardButton30.setFont(font3);
            keyboardButton30.addKeyListener(this);
            
            
            //Add buttons to buttonlist
            
            buttonList.add(keyboardButton1);
            buttonList.add(keyboardButton2);
            buttonList.add(keyboardButton3);
            buttonList.add(keyboardButton4);
            buttonList.add(keyboardButton5);
            buttonList.add(keyboardButton6);
            buttonList.add(keyboardButton7);
            buttonList.add(keyboardButton8);
            buttonList.add(keyboardButton9);
            buttonList.add(keyboardButton10);
            buttonList.add(keyboardButton11);
            buttonList.add(keyboardButton12);
            buttonList.add(keyboardButton13);
            buttonList.add(keyboardButton14);
            buttonList.add(keyboardButton15);
            buttonList.add(keyboardButton16);
            buttonList.add(keyboardButton17);
            buttonList.add(keyboardButton21);
            buttonList.add(keyboardButton22);
            buttonList.add(keyboardButton24);
            buttonList.add(keyboardButton25);
            buttonList.add(keyboardButton26);
            
            
            //Label Keyboard
            JLabel label1 = new JLabel("Q", JLabel.CENTER);
            JLabel label2 = new JLabel("W", JLabel.CENTER);
            JLabel label3 = new JLabel("E", JLabel.CENTER);
            JLabel label4 = new JLabel("R", JLabel.CENTER);
            JLabel label5 = new JLabel("T", JLabel.CENTER);
            JLabel label6 = new JLabel("Y", JLabel.CENTER);
            JLabel label7 = new JLabel("U", JLabel.CENTER);
            JLabel label8 = new JLabel("I", JLabel.CENTER);
            JLabel label9 = new JLabel("O", JLabel.CENTER);
            JLabel label10 = new JLabel("P", JLabel.CENTER);
            
            label1.setFont(font2);
            label2.setFont(font2);
            label3.setFont(font2);
            label4.setFont(font2);
            label5.setFont(font2);
            label6.setFont(font2);
            label7.setFont(font2);
            label8.setFont(font2);
            label9.setFont(font2);
            label10.setFont(font2);
            
            JLabel label11 = new JLabel("A", JLabel.CENTER);
            JLabel label12 = new JLabel("S", JLabel.CENTER);
            JLabel label13 = new JLabel("D", JLabel.CENTER);
            JLabel label14 = new JLabel("F", JLabel.CENTER);
            JLabel label15 = new JLabel("G", JLabel.CENTER);
            JLabel label16 = new JLabel("H", JLabel.CENTER);
            JLabel label17 = new JLabel("J", JLabel.CENTER);
            JLabel label18 = new JLabel("K", JLabel.CENTER);
            JLabel label19 = new JLabel("L", JLabel.CENTER);
            JLabel label20 = new JLabel("", JLabel.CENTER);
            
            label11.setFont(font2);
            label12.setFont(font2);
            label13.setFont(font2);
            label14.setFont(font2);
            label15.setFont(font2);
            label16.setFont(font2);
            label17.setFont(font2);
            label18.setFont(font2);
            label19.setFont(font2);
            label20.setFont(font2);
            
            JLabel label21 = new JLabel("Z", JLabel.CENTER);
            JLabel label22 = new JLabel("X", JLabel.CENTER);
            JLabel label23 = new JLabel("C", JLabel.CENTER);
            JLabel label24 = new JLabel("V", JLabel.CENTER);
            JLabel label25 = new JLabel("B", JLabel.CENTER);
            JLabel label26 = new JLabel("N", JLabel.CENTER);
            JLabel label27 = new JLabel("M", JLabel.CENTER);
            JLabel label28 = new JLabel("", JLabel.CENTER);
            JLabel label29 = new JLabel("Click", JLabel.CENTER);
            JLabel label30 = new JLabel("here", JLabel.CENTER);
            
            label21.setFont(font2);
            label22.setFont(font2);
            label23.setFont(font2);
            label24.setFont(font2);
            label25.setFont(font2);
            label26.setFont(font2);
            label27.setFont(font2);
            label28.setFont(font2);
            label29.setFont(font3);
            label30.setFont(font3);
           
            //Add labels and buttons
            centerPanel.add(label1);
            centerPanel.add(label2);
            centerPanel.add(label3);
            centerPanel.add(label4);
            centerPanel.add(label5);
            centerPanel.add(label6);
            centerPanel.add(label7);
            centerPanel.add(label8);
            centerPanel.add(label9);
            centerPanel.add(label10);
            
            centerPanel.add(keyboardButton1);
            centerPanel.add(keyboardButton2);
            centerPanel.add(keyboardButton3);
            centerPanel.add(keyboardButton4);
            centerPanel.add(keyboardButton5);
            centerPanel.add(keyboardButton6);
            centerPanel.add(keyboardButton7);
            centerPanel.add(keyboardButton8);
            centerPanel.add(keyboardButton9);
            centerPanel.add(keyboardButton10);
            
            
            centerPanel.add(label11);
            centerPanel.add(label12);
            centerPanel.add(label13);
            centerPanel.add(label14);
            centerPanel.add(label15);
            centerPanel.add(label16);
            centerPanel.add(label17);
            centerPanel.add(label18);
            centerPanel.add(label19);
            centerPanel.add(label20);
            
            
            centerPanel.add(keyboardButton11);
            centerPanel.add(keyboardButton12);
            centerPanel.add(keyboardButton13);
            centerPanel.add(keyboardButton14);
            centerPanel.add(keyboardButton15);
            centerPanel.add(keyboardButton16);
            centerPanel.add(keyboardButton17);
            centerPanel.add(keyboardButton18);
            centerPanel.add(keyboardButton19);
            centerPanel.add(keyboardButton20);
            
            centerPanel.add(label21);
            centerPanel.add(label22);
            centerPanel.add(label23);
            centerPanel.add(label24);
            centerPanel.add(label25);
            centerPanel.add(label26);
            centerPanel.add(label27);
            centerPanel.add(label28);
            centerPanel.add(label29);
            centerPanel.add(label30);
            
            centerPanel.add(keyboardButton21);
            centerPanel.add(keyboardButton22);
            centerPanel.add(keyboardButton23);
            centerPanel.add(keyboardButton24);
            centerPanel.add(keyboardButton25);
            centerPanel.add(keyboardButton26);
            centerPanel.add(keyboardButton27);
            centerPanel.add(keyboardButton28);
            centerPanel.add(keyboardButton29);
            centerPanel.add(keyboardButton30);
            
            try{
            	//Open the synth
				Synthesizer synth = MidiSystem.getSynthesizer();
				synth.open();
				channels = synth.getChannels();
				
				//Load the instruments
				instr = synth.getDefaultSoundbank().getInstruments();
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
            }
            catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void keyTyped(KeyEvent k){
			
		}
		public void keyPressed(KeyEvent k){
			System.out.println("Key Pressed");		
			int key = k.getKeyCode();
			//If an instrument/channel select key is pressed, change the channel. If a note key is pressed, play the note.
			if (key == KeyEvent.VK_Q){
				volume = 80;
				channel=0;
			} else if (key == KeyEvent.VK_W){
				volume = 80;
				channel=1;
			} else if (key == KeyEvent.VK_E){
				volume = 80;
				channel=2;
			} else if (key == KeyEvent.VK_R){
				volume = 80;
				channel=3;
			} else if (key == KeyEvent.VK_T){
				volume = 80;
				channel=4;
			} else if (key == KeyEvent.VK_Y){
				volume = 80;
				channel=5;
			} else if (key == KeyEvent.VK_U){
				volume = 80;
				channel=6;
			} else if (key == KeyEvent.VK_I){
				volume = 80;
				channel=7;
			} else if (key == KeyEvent.VK_O){
				volume = 80;
				channel=8;
			} else if (key == KeyEvent.VK_P){
				volume = 127;
				channel=10;
			}
			else{
				channel=prevChannel;
			}
			
			if(key==KeyEvent.VK_A){
				channels[channel].noteOn( 60, volume );
			} else if (key == KeyEvent.VK_Z){
				channels[channel].noteOn( 61, volume );
			} else if (key == KeyEvent.VK_S){
				channels[channel].noteOn( 62, volume );
			} else if (key == KeyEvent.VK_X){
				channels[channel].noteOn( 63, volume );
			} else if (key == KeyEvent.VK_D){
				channels[channel].noteOn( 64, volume );
			} else if (key == KeyEvent.VK_F){
				channels[channel].noteOn( 65, volume );
			} else if (key == KeyEvent.VK_V){
				channels[channel].noteOn( 66, volume );
			} else if (key == KeyEvent.VK_G){
				channels[channel].noteOn( 67, volume );
			} else if (key == KeyEvent.VK_B){
				channels[channel].noteOn( 68, volume );
			} else if (key == KeyEvent.VK_H){
				channels[channel].noteOn( 69, volume );
			} else if (key == KeyEvent.VK_N){
				channels[channel].noteOn( 70, volume );
			} else if (key == KeyEvent.VK_J){
				channels[channel].noteOn( 71, volume );
			}
			
			prevChannel=channel;
		}
					
		public void keyReleased(KeyEvent k){
			int key = k.getKeyCode();
			
			if(key==KeyEvent.VK_A){
				channels[channel].noteOff( 60, volume );
			} else if (key == KeyEvent.VK_Z){
				channels[channel].noteOff( 61, volume );
			} else if (key == KeyEvent.VK_S){
				channels[channel].noteOff( 62, volume );
			} else if (key == KeyEvent.VK_X){
				channels[channel].noteOff( 63, volume );
			} else if (key == KeyEvent.VK_D){
				channels[channel].noteOff( 64, volume );
			} else if (key == KeyEvent.VK_F){
				channels[channel].noteOff( 65, volume );
			} else if (key == KeyEvent.VK_V){
				channels[channel].noteOff( 66, volume );
			} else if (key == KeyEvent.VK_G){
				channels[channel].noteOff( 67, volume );
			} else if (key == KeyEvent.VK_B){
				channels[channel].noteOff( 68, volume );
			} else if (key == KeyEvent.VK_H){
				channels[channel].noteOff( 69, volume );
			} else if (key == KeyEvent.VK_N){
				channels[channel].noteOff( 70, volume );
			} else if (key == KeyEvent.VK_J){
				channels[channel].noteOff( 71, volume );
			} 
			
			}
		
		public ArrayList<JButton> getButtons(){
			return buttonList;
		}
	}
