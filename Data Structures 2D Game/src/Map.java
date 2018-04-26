import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Map {
	private String path;
	private int width;
	private int height;
	
	private String line;
	
	private Block[][] blocks;
	
	public Map(String path) throws NumberFormatException, IOException
	{
		this.path = path;
		
		loadMap();
	}
	
	// read map from file
	public void loadMap() throws NumberFormatException, IOException
	{
		InputStream is = this.getClass().getResourceAsStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		width = Integer.parseInt(br.readLine());
		height = Integer.parseInt(br.readLine());
		
		blocks = new Block[height][width];
		
		for(int y=0; y<height; y++) {
			line = br.readLine();
			String[] tokens = line.split(" ");
			
			for(int x=0; x<width; x++) {
				blocks[y][x] = new Block(
						x*Block.blockSize, 
						y*Block.blockSize, 
						Integer.parseInt(tokens[x]));
			}
		}
	}
	
	public void update() {}
	
	// draw map tiles on screen
	public void draw(Graphics g) {
		for(int i=0; i<blocks.length; i++) {
			for(int j=0; j<blocks[0].length; j++) {
				blocks[i][j].draw(g);
			}
		}
	}
	
	public Block[][] getBlocks() {
		return blocks;
	}
}
