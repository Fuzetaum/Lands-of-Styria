package com.company.styria.equipment;

public class Armor extends Equipment {
	protected Integer armor;
	protected Integer magRes;
	
	@Override
	public Object getEquipType() {return Armor.class;}
	@Override
	public Integer getEquipSlot() {return Equipment.EQUIPSLOT_CHEST;}
	public Integer getArmor() {return this.armor;}
	public Integer getMagRes() {return this.magRes;}
}
