import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images
{
	private static BufferedImage[] blocks;
	private static BufferedImage[] players;
	private static BufferedImage[] hud;
//	private static BufferedImage[] enemies;
//	private static BufferedImage[] traps;
//	private static BufferedImage[] checkpoints;
	
	
	public Images() throws IOException
	{
		blocks = new BufferedImage[2];
		blocks[0] = ImageIO.read(
				getClass().getResourceAsStream("grass.jpg"));
		blocks[1] = ImageIO.read(
				getClass().getResourceAsStream("wall.jpg"));
		
		
		
		players = new BufferedImage[4];
		players[0] =  ImageIO.read(
				getClass().getResourceAsStream("spriteR.png"));
		players[1] =  ImageIO.read(
				getClass().getResourceAsStream("spriteL.png"));
		players[2] =  ImageIO.read(
				getClass().getResourceAsStream("spriteU.png"));
		players[3] =  ImageIO.read(
				getClass().getResourceAsStream("spriteD.png"));

		
		hud = new BufferedImage[2];
		hud[0] =  ImageIO.read(
				getClass().getResourceAsStream("heart.png"));
//		enemies[1] =  ImageIO.read(
//				getClass().getResourceAsStream("robot_enemy_left.gif"));
//		
//		powerups = new BufferedImage[5]; 
//		powerups[0] = ImageIO.read(
//				getClass().getResourceAsStream("powerup_green.png"));
//		powerups[1] = ImageIO.read(
//				getClass().getResourceAsStream("pupGiant.gif"));
//		powerups[2] = ImageIO.read(
//				getClass().getResourceAsStream("pupShrink.gif"));
//		powerups[3] = ImageIO.read(
//				getClass().getResourceAsStream("pupSpeed.gif"));
//		powerups[4] = ImageIO.read(
//				getClass().getResourceAsStream("pupHealth.gif"));
//		
//		traps = new BufferedImage[1];
//		traps[0] = ImageIO.read(
//				getClass().getResourceAsStream("lava.png"));
//		
//		checkpoints = new BufferedImage[3];
//		checkpoints[0] = ImageIO.read(
//				getClass().getResourceAsStream("checkpoint_1_off.gif"));
//		checkpoints[1] = ImageIO.read(
//				getClass().getResourceAsStream("checkpoint_1_on.gif"));
//		checkpoints[2] = ImageIO.read(
//				getClass().getResourceAsStream("flag_finish.png"));
		
		
	}

	public static BufferedImage[] getBlocks()
	{
		return blocks;
	}
	public static BufferedImage[] getPlayers()
	{
		return players;
	}
	public static BufferedImage[] getHud()
	{
		return hud;
	}
//	public static BufferedImage[] getEnemies()
//	{
//		return enemies;
//	}
//	public static BufferedImage[] getTraps()
//	{
//		return traps;
//	}
//	public static BufferedImage[] getCheckpoints()
//	{
//		return checkpoints;
//	}
}