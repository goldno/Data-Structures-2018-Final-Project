
public class Enemy {
	private int maxHealth=100;
	private int health=maxHealth;
	private int type;
	private int attack=20;
	private boolean turnEnded=true;
	private boolean dead=false;
	
	public Enemy(int t) {
		type=t;
	}
	
	public void update(Player p) {
		if(health<0) {
			dead=true;
		}
		fight(p);
	}
	
	public void fight(Player p) {
		if(p.isTurnEnded()==true) {
			p.setHealth(p.getHealth()-attack);
			turnEnded=true;
		}
	}
	
	public boolean isTurnEnded() {
		return turnEnded;
	}
	public void setHealth(int h) {
		health=h;
	}
	public int getHealth() {
		return health;
	}
	public void setType(int t) {
		type=t;
	}
	public int getAttackPower() {
		return attack;
	}
}
