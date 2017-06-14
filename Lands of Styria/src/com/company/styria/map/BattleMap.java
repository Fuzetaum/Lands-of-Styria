package com.company.styria.map;

import java.util.ArrayList;
import java.util.List;

public class BattleMap {
	private Integer x;
	private Integer y;
	private List<List<BattleMapTile>> tiles;
	
	public BattleMap(Integer x, Integer y) {
		this.x = x; this.y = y;
		this.tiles = new ArrayList<List<BattleMapTile>>(this.x.intValue());
		for(int i=0; i<x; i++)
			this.tiles.add(new ArrayList<BattleMapTile>(this.y.intValue()));
	}
	
	/*Generates the battle map tiles. Randomly places hills, cliffs and obstacles.
	 * @param theme theme of the battle map, for landscape adjustment
	 * */
	public void generateBattleMapTiles(Short theme) {}
	
	public Integer getHeight() {return this.x;}
	public Integer getWidth() {return this.y;}
}
