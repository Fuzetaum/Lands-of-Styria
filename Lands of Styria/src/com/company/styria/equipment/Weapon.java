package com.company.styria.equipment;

public abstract class Weapon extends Equipment{
	private Integer basePhysAtk;
	private Integer baseMagAtk;
	private Float defenseModifier;
	
	public Integer getphysAtk() {return this.basePhysAtk;}
	public Integer getMagAtk() {return this.baseMagAtk;}
	@Override
	public Object getEquipType() {return Weapon.class;}
	
	protected void setPhysAtk(Integer newVal) {this.basePhysAtk = newVal;}
	protected void setMagAtk(Integer newVal) {this.baseMagAtk = newVal;}
	protected void setDefenseModifier(Float newVal) {this.defenseModifier = newVal;}
	
	protected Integer calculatePhysAtk() {
		Float result = this.basePhysAtk * this.defenseModifier;
		return new Integer(result.intValue());
	}
	
	protected Integer calculateMagAtk() {
		Float result = this.baseMagAtk * this.defenseModifier;
		return new Integer(result.intValue());
	}
}
