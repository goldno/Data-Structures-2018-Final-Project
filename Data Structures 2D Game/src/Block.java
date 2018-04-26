import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Block extends Rectangle {
	private static final long serialVersionUID = 1L;
	public static final int blockSize = 60;
	private int id;
	private int x;
	private int y;
	
//	private int eHealth;
//	private Enemy e;
	
	public Block(int x,int y,int id) {
		setBounds(x,y,blockSize,blockSize);
		this.id=id;
		this.x=x;
		this.y=y;
	}
	public void update() {
	}
	
	//draw tiles with images
	public void draw(Graphics g) {
		if(id == 0) {
			g.drawImage(Images.getBlocks()[0], x, y, width, height, null);
		}
		if(id == 1) {
			g.drawImage(Images.getBlocks()[1], x, y, width, height, null);
		}
		if(id == 2) {
			g.drawImage(Images.getBlocks()[1], x, y, width, height, null);
		}
		if(id == 3) {
			g.drawImage(Images.getBlocks()[2], x, y, width, height, null);
		}
		if(id == 4) {
			g.drawImage(Images.getBlocks()[3], x, y, width, height, null);
		}
	}
	
	public void setID(int id) {
		this.id=id;
	}
	public int getID() {
		return id;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public boolean canPass() {
		if(id>5)
			return true;
		return false;
	}
//	public double getX() {
//		return x;
//	}
//	public double getY() {
//		return y;
//	}
}
