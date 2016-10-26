package com.company.styria.equipment;

public abstract class Helmet extends Equipment {
	@Override
	public Object getEquipType() {return Helmet.class;}
	@Override
	public Integer getEquipSlot() {return Equipment.EQUIPSLOT_HEAD;}
}
