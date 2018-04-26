import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Hud {
	private JFrame hud;
	private JPanel p;
//	private Player player;
//	private Rectangle bg;
//	private BufferedImage lives;
//	private BufferedImage health;
	
	private JButton attackButton;
	private JButton blockButton;
	private JButton flee;
	private JLabel name;
	private JLabel health;
	private JLabel lives;
	private JTextArea txt;
	private JLabel space1;
	private JLabel space2;
	private JLabel space3;
	private JLabel space4;
	private JLabel space5;
	
	private Font font1 = new Font("Cooper Black", Font.PLAIN, 20);
	private Font font2 = new Font("Cooper Black", Font.PLAIN, 15);
	private int livesP;
	private int healthP;
	private String playerName=Main.getPlayerName();
	
	private ArrayList<String> info;
	private ArrayList<String> infoLog;
	private boolean isText=false;
	private int infoCount=0;
	private int infoTxt=0;
	
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			if(ev.getSource()==attackButton) {
				Player.setAttackPressed(true);
			}
			else if(ev.getSource()==blockButton) {
				
			}
		}
	}
	
	public Hud() {
		info = new ArrayList<String>();
//		info.add("Info goes here!");
		infoLog = new ArrayList<String>();
		
		p = new JPanel(); //HUD JPanel
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBackground(Color.WHITE);
		p.setPreferredSize(new Dimension(315,315));
		p.setLocation(100,100);
		Main.frame.add(p,BorderLayout.EAST);
		
		name = new JLabel("NAME: "+playerName); //player name text
		p.add(name);
		
		space1 = new JLabel("_____________________________________________");
		p.add(space1);
		
		health = new JLabel("HEALTH: "); //player health text
		p.add(health);
		
		space2 = new JLabel("_____________________________________________");
		p.add(space2);
		
		lives = new JLabel("LIVES: "); //player lives text
		p.add(lives);
		
		space3 = new JLabel("_____________________________________________");
		p.add(space3);
		
		attackButton = new JButton("ATTACK"); //player attack button
		p.add(attackButton);
		
//		space5 = new JLabel("________________________________");
//		p.add(space5);
		
		blockButton = new JButton("BLOCK"); //player block button
		p.add(blockButton);
		
		
		
//		txt = new JTextArea();
//		p.add(txt);
//		txt.setText("This is the info!");
		
		for(int i=0; i<p.getComponentCount(); i++) { //Set JPanel allignment
			JComponent jc = (JComponent)p.getComponent(i);
			jc.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		
		MyActionListener listener = new MyActionListener();
		attackButton.addActionListener(listener);
		blockButton.addActionListener(listener);

	}
	
	public void update(Player p) {
		livesP = p.getLives();
		healthP = p.getHealth()*2;
	}
	
	public void addInfo(String txt) {
		info.add(txt);
	}
	
	public void draw(Graphics g) {
		health.setText("HEALTH: "+healthP);
		lives.setText("LIVES: "+livesP);
	}
}
