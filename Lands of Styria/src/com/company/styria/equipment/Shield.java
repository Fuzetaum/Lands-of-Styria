package com.company.styria.equipment;

public class Shield extends Equipment {
	private Integer armor;
	private Integer magRes;
	
	public Shield(Integer armor,Integer magRes) {
		this.armor=armor;this.magRes=magRes;
	}
	
	@Override
	public Object getEquipType() {return Shield.class;}
	@Override
	public Integer getEquipSlot() {return Equipment.EQUIPSLOT_HAND;}
	
	public Integer getArmor() {return this.armor;}
	public Integer getMagRes() {return this.magRes;}
}
