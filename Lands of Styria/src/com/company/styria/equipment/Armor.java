package com.company.styria.equipment;

public abstract class Armor extends Equipment {
	protected Integer physDef;
	protected Integer magDef;
	
	@Override
	public Object getEquipType() {return Armor.class;}
	@Override
	public Integer getEquipSlot() {return Equipment.EQUIPSLOT_CHEST;}
	public Integer getPhysDef() {return this.physDef;}
	public Integer getMagDef() {return this.magDef;}
}
