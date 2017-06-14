package com.company.styria.equipment;

public class Helmet extends Equipment {
	private Integer armor;
	private Integer magRes;
	
	public Helmet(Integer armor, Integer magRes) {
		this.armor=armor;this.magRes=magRes;
	}
	
	@Override
	public Object getEquipType() {return Helmet.class;}
	@Override
	public Integer getEquipSlot() {return Equipment.EQUIPSLOT_HEAD;}
	
	public Integer getArmor() {return this.armor;}
	public Integer getMagRes() {return this.magRes;}
}
