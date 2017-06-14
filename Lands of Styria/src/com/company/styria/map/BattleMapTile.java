package com.company.styria.map;

public class BattleMapTile {
	private Integer x;
	private Integer y;
	private Integer level;
	private boolean obstacle=false;
	
	public BattleMapTile(Integer x, Integer y, Integer level) {
		this.x = x; this.y = y; this.level = level;
	}
	
	public Integer getX() {return this.x;}
	public Integer getY() {return this.y;}
	public Integer getLevel() {return this.level;}
	public boolean hasObstacle() {return this.obstacle;}
	
	public void putObstacle() {this.obstacle = true;}
	
	public boolean equals(BattleMapTile tile) {
		if(tile.x.equals(this.x)) return false;
		else if(tile.y.equals(this.y)) return false;
		return true;
	}
}
