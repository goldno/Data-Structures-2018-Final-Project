import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Main extends JPanel {
	static JFrame frame;
	static int x=frame.WIDTH/2;
	static int y=frame.HEIGHT/2;
	static Player player;
	static Enemy e;
	private Hud h;
	private Map[] maps = new Map[2];
	private int currentMap=0;
	private int nextMap = currentMap+1;
	static int width=1100; //790
	static int height=695; //695
	private Font font1 = new Font("Cooper Black", Font.PLAIN, 15);

	public Main() throws IOException {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
			     if(key == KeyEvent.VK_LEFT)
			        player.setLeft(false);
			     if(key == KeyEvent.VK_RIGHT)
			        player.setRight(false);
			     if(key == KeyEvent.VK_UP)
			        player.setUp(false);
			     if(key == KeyEvent.VK_DOWN)
			    	player.setDown(false);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
			     if(key == KeyEvent.VK_LEFT)
			       player.setLeft(true);
			     if(key == KeyEvent.VK_RIGHT)
			       player.setRight(true);
			     if(key == KeyEvent.VK_UP)
			       player.setUp(true);
			     if(key == KeyEvent.VK_DOWN)
			       player.setDown(true);
			}
		});
		setFocusable(true);
		
		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent m) {
				int x=m.getX();
				int y=m.getY();
				System.out.println(x+", "+y);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
	    new Images(); 
	    maps[0]=new Map("map1");
	    maps[1]=new Map("map2");
	    currentMap=0;
	    player=new Player(45,45,maps[currentMap].getBlocks());
	    h=new Hud();
	}
	
	private void update() {
		player.update(player,e);
		h.update(player);
//		if(player.isDead()) {
//			gameOver();
//			currentMap=nextMap;
//		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		maps[currentMap].draw(g);
	    player.draw(g);
	    h.draw(g);
	    
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	public static String getPlayerName() {
		String name = JOptionPane.showInputDialog(null,"Enter Your Name","Player Name",JOptionPane.OK_OPTION);
		return name;
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		frame = new JFrame("2D Game");
		Main game = new Main();
		frame.add(game);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.update();
			game.repaint();
			Thread.sleep(10);
		}
	}
}