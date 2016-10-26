package com.company.styria.units;

public abstract class Unit {
	protected Integer maxHP;
	protected Integer maxSP;
	protected Integer basePhysAtk;
	protected Integer baseMagAtk;
	protected Integer basePhysDef;
	protected Integer baseMagDef;
	
	public Integer getMaxHP() {return this.maxHP;}
	public Integer getMaxSP() {return this.maxSP;}
	public Integer getBasePhysAtk() {return this.basePhysAtk;}
	public Integer getBaseMagAtk() {return this.baseMagAtk;}
	public Integer getBasePhysDef() {return this.basePhysDef;}
	public Integer getBaseMagDef() {return this.baseMagDef;}
}