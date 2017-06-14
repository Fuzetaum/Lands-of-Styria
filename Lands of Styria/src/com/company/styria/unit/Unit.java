package com.company.styria.unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.company.styria.equipment.UnitEquipment;

public abstract class Unit {
	protected Integer starTier;
	protected Integer level;
	protected Integer maxHP;
	protected Integer currentHP;
	protected Integer maxSP;
	protected Integer currentSP;
	protected Integer basePhysAtk;
	protected Integer baseMagAtk;
	protected Integer baseArmor;
	protected Integer baseMagRes;
	protected Integer baseSpeed;
	protected UnitEquipment equipment;
	
	public Integer getStarTier() {return this.starTier;}
	public Integer getLevel() {return this.level;}
	public Integer getMaxHP() {return this.maxHP;}
	public Integer getCurrentHP() {return this.currentHP;}
	public Integer getMaxSP() {return this.maxSP;}
	public Integer getCurrentSP() {return this.currentSP;}
	public Integer getBasePhysAtk() {return this.basePhysAtk;}
	public Integer getBaseMagAtk() {return this.baseMagAtk;}
	public Integer getBaseArmor() {return this.baseArmor;}
	public Integer getBaseMagRes() {return this.baseMagRes;}
	public Integer getBaseSpeed() {return this.baseSpeed;}
	public UnitEquipment getEquipment() {return this.equipment;}
	
	public void increaseStarTier() {this.starTier += 1;}
	
	public void levelUp() {
		Integer targetAttr = new Double(Math.random()).intValue()%7;
		boolean changed = false;
		List<Integer> attributes = new ArrayList<Integer>(7);
		attributes.forEach(field -> field = 0);
		attributes.set(targetAttr, 1);
		for(Integer i=1;i<this.starTier;i++) {
			while(!changed) {
				targetAttr = new Double(Math.random()).intValue()%7;
				if(attributes.get(targetAttr) == 0) {
					attributes.set(targetAttr, 1);
					changed = true;
				}
			}
			changed = false;
		}
		//Increase attributes according to list
		Iterator<Integer> i = attributes.iterator();
		for(Integer attr=0; attr<7; attr++)
			switch(attr) {
			case 0:
				this.maxHP += i.next()*3; break;
			case 1:
				this.maxSP += i.next()*3; break;
			case 2:
				this.basePhysAtk += i.next(); break;
			case 3:
				this.baseMagAtk += i.next(); break;
			case 4:
				this.baseArmor += i.next(); break;
			case 5:
				this.baseMagRes += i.next(); break;
			case 6:
				this.baseSpeed += i.next(); break;
			}
	}
	
	public void damageUnit(Integer damage) {
		if((this.currentHP - damage) > 0) this.currentHP -= damage;
		else this.currentHP = 0;
	}
	public void healUnit(Integer amount) {
		if((this.maxHP - this.currentHP) > amount) this.currentHP += amount;
		else this.currentHP = this.maxHP;
	}
	public void useSP(Integer cost) {this.currentSP -= cost;}
	public void regenerateSP(Integer amount) {
		if((this.maxSP - this.currentSP) > amount) this.currentSP += amount;
		else this.currentSP = this.maxSP;
	}
	
	public boolean isCastable(Integer SPCost) {return (SPCost > this.currentSP)? false : true;}
	
	public Integer getEffectiveMaxHP() {
		Integer hp = this.maxHP;
		if(this.equipment.getAccessory1() != null) hp += this.equipment.getAccessory1().getHP();
		if(this.equipment.getAccessory2() != null) hp += this.equipment.getAccessory2().getHP();
		return hp;
	}
	public Integer getEffectiveMaxSP() {
		Integer sp = this.maxSP;
		if(this.equipment.getAccessory1() != null) sp += this.equipment.getAccessory1().getSP();
		if(this.equipment.getAccessory2() != null) sp += this.equipment.getAccessory2().getSP();
		return sp;
	}
	public Integer getEffectivePhysicalDamage() {
		Integer damage=this.basePhysAtk;
		if(this.equipment.getRightHand() != null) damage += this.equipment.getRightHand().getPhysAtk();
		if(this.equipment.getAccessory1() != null) damage += this.equipment.getAccessory1().getAttack();
		if(this.equipment.getAccessory2() != null) damage += this.equipment.getAccessory2().getAttack();
		return damage;
	}
	public Integer getEffectiveMagicalDamage() {
		Integer damage=this.baseMagAtk;
		if(this.equipment.getRightHand() != null) damage += this.equipment.getRightHand().getMagAtk();
		if(this.equipment.getAccessory1() != null) damage += this.equipment.getAccessory1().getMagAtk();
		if(this.equipment.getAccessory2() != null) damage += this.equipment.getAccessory2().getMagAtk();
		return damage;
	}
	public Integer getEffectiveArmor() {
		Integer totalArmor = this.baseArmor;
		if(this.equipment.getHead() != null) totalArmor += this.equipment.getHead().getArmor();
		if(this.equipment.getChest() != null) totalArmor += this.equipment.getChest().getArmor();
		if(this.equipment.getLegs() != null) totalArmor += this.equipment.getLegs().getArmor();
		if(this.equipment.getAccessory1() != null) totalArmor += this.equipment.getAccessory1().getArmor();
		if(this.equipment.getAccessory2() != null) totalArmor += this.equipment.getAccessory2().getArmor();
		return totalArmor;
	}
	public Integer getEffectiveMagicResistance() {
		Integer totalRes = this.baseMagRes;
		if(this.equipment.getHead() != null) totalRes += this.equipment.getHead().getMagRes();
		if(this.equipment.getChest() != null) totalRes += this.equipment.getChest().getMagRes();
		if(this.equipment.getLegs() != null) totalRes += this.equipment.getLegs().getMagRes();
		if(this.equipment.getAccessory1() != null) totalRes += this.equipment.getAccessory1().getMagRes();
		if(this.equipment.getAccessory2() != null) totalRes += this.equipment.getAccessory2().getMagRes();
		return totalRes;
	}
	public Integer getEffectiveSpeed() {
		Integer speed = this.baseSpeed;
		if(this.equipment.getAccessory1() != null) speed += this.equipment.getAccessory1().getSpeed();
		if(this.equipment.getAccessory2() != null) speed += this.equipment.getAccessory2().getSpeed();
		return speed;
	}
	
	public boolean isDead() {return (this.currentHP == 0)? true : false;}
}