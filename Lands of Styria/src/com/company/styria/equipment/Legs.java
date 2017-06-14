package com.company.styria.equipment;

public class Legs extends Equipment {
	private Integer armor;
	private Integer magRes;
	
	public Legs(Integer armor, Integer magRes) {
		this.armor=armor;this.magRes=magRes;
	}
	
	@Override
	public Object getEquipType() {return Legs.class;}
	@Override
	public Integer getEquipSlot() {return Equipment.EQUIPSLOT_LEGS;}
	
	public Integer getArmor() {return this.armor;}
	public Integer getMagRes() {return this.magRes;}
}
