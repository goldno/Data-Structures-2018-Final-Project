import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

public class Player {
	private boolean right;
	private boolean left;
	private boolean up;
	private boolean down;
	private boolean isLeft;
	private boolean isRight;
	private boolean isUp;
	private boolean isDown;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private int moveSpeed = 3;
	private boolean canMove=true;
	private int maxHealth = 100;
	private int health = maxHealth;
	private int lives = 3;
	private int gems=0;
	
	private boolean finishLevel=false;
	private int levelsFinished=0;
	private boolean dead = false;
	
	private Block[][] p;
	
	public Player(int width, int height, Block[][] p) throws IOException
	{
		x=Main.x;
		y=Main.y;
		this.width = width;
		this.height = height;
		this.p = p;
		isDown=true;
	}
	
	// get player rectangle bounds
	public Rectangle getRectangle() {
		return new Rectangle(x, y, width+2, height+2);
	}
	
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean d) {
		dead=d;
	}
	public int getLives() {
		return lives;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int h) {
		health=h;
	}
	public void stopMovement() {
		up=down=left=right=false;
	}
	public void setMovement(boolean m) {
		canMove=m;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public boolean getFinshedLevel() {
		return finishLevel;
	}
	public int getLevelsFinished() {
		return levelsFinished;
	}
	public void setFinishedLevel(boolean f) {
		finishLevel=f;
	}
	
	public void update(Player player)
	{	
		// get player's last x and y
		int lastX=x;
		int lastY=y;
		
		// move player
		if(right && canMove==true) {
			x+=moveSpeed;
			health-=1;
			isRight=true;
			left=down=up=false;
			isLeft=isUp=isDown=false;
		}
		if(left && canMove==true) {
			x-=moveSpeed;
			isLeft=true;
			right=down=up=false;
			isRight=isUp=isDown=false;
		}
		if(up && canMove==true) {
			y-=moveSpeed;
			isUp=true;
			right=left=down=false;
			isLeft=isRight=isDown=false;
		}
		if(down && canMove==true) {
			y+=moveSpeed;
			isDown=true;
			right=left=up=false;
			isLeft=isRight=isUp=false;
		}
		
		// check window collision
		if(x>730)
			x=730;
		if(x<0)
			x=0;
		if(y>610)
			y=610;
		if(y<0)
			y=0;
		
		// check tile collision
		for(int i=0; i<p.length; i++) {
			for(int j=0; j<p[0].length; j++) {
	
			if(p[i][j].getID() == 1)
			{
				if(isUp && p[i][j].intersects(player.getRectangle())) {
					up=false;
					x=lastX;
					y=lastY;
				}
				if(isLeft && p[i][j].intersects(player.getRectangle())) {
					left=false;
					x=lastX;
					y=lastY;
				}
				if(isRight && p[i][j].intersects(player.getRectangle())) {
					right=false;
					x=lastX;
					y=lastY;
				}
				if(isDown && p[i][j].intersects(player.getRectangle())) {
					down=false;
					x=lastX;
					y=lastY;
				}
				
			}
			if(p[i][j].getID()==4) {
				levelsFinished+=1;
				finishLevel=true;
			}
//				// powerup 1 giant
//				if(p[i][j].getID() == 2) 
//				{
//					if(playerColi == true) 
//					{
//						p[i][j].setID(0);
//						hasPowerup = true;
//						getGiantPowerup();						
//					}
//				}
			}
		}
		
		if(health<=0) {
			lives-=1;
			health=maxHealth;
		}
		if(lives<=0) {
			dead=true;
			lives=0;
			health=0;
		}
}
	
	// draw player sprite
	public void draw(Graphics g) {
		if(isLeft) {
			g.drawImage(Images.getPlayers()[1], x, y, width, height, null);
		}
		if(isRight) {
			g.drawImage(Images.getPlayers()[0], x, y, width, height, null);
		}
		if(isUp) {
			g.drawImage(Images.getPlayers()[2], x, y, width, height, null);
		}
		if(isDown) {
			g.drawImage(Images.getPlayers()[3], x, y, width, height, null);
		}
	}
	
	// set player direction
	public void setLeft(boolean left) {
		this.left=left;
	}
	public void setRight(boolean right) {
		this.right=right;
	}
	public void setUp(boolean up) {
		this.up=up;
	}
	public void setDown(boolean down) {
		this.down=down;
	}
}
