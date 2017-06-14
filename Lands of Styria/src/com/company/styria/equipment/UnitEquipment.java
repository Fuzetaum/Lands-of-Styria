package com.company.styria.equipment;

public class UnitEquipment {
	private Equipment leftHand;
	private Weapon rightHand;
	private Helmet head;
	private Armor chest;
	private Legs legs;
	private Accessory acc1;
	private Accessory acc2;
	
	public UnitEquipment() {
		this.leftHand = null; this.rightHand = null; this.head = null; this.chest = null;
		this.legs = null; this.acc1 = null; this.acc2 = null;
	}
	
	public Equipment getLeftHand() {return this.leftHand;}
	public Weapon getRightHand() {return this.rightHand;}
	public Helmet getHead() {return this.head;}
	public Armor getChest() {return this.chest;}
	public Legs getLegs() {return this.legs;}
	public Accessory getAccessory1() {return this.acc1;}
	public Accessory getAccessory2() {return this.acc2;}

	public void setLeftHand(Equipment newEquip) {this.leftHand = newEquip;}
	public void setRightHand(Weapon newEquip) {
			this.rightHand = newEquip;
			if(newEquip.getEquipType() == TwoHandedWeapon.class)
				this.leftHand = newEquip;
	}
	public void setHead(Helmet newEquip) {this.head = newEquip;}
	public void setChest(Armor newEquip) {this.chest = newEquip;}
	public void setLegs(Legs newEquip) {this.legs = newEquip;}
	public void setAccessory1(Accessory newEquip) {this.acc1 = newEquip;}
	public void setAccessory2(Accessory newEquip) {this.acc2 = newEquip;}
	
	public Integer getTotalHP() {
		Integer total = 0;
		if(this.acc1 != null) total += this.acc1.getHP();
		if(this.acc2 != null) total += this.acc2.getHP();
		return total;
	}
	public Integer getTotalSP() {
		Integer total = 0;
		if(this.acc1 != null) total += this.acc1.getSP();
		if(this.acc2 != null) total += this.acc2.getSP();
		return total;
	}
	public Integer getTotalAttack() {
		Integer total = 0;
		if(this.acc1 != null) total += this.acc1.getAttack();
		if(this.acc2 != null) total += this.acc2.getAttack();
		if(this.rightHand != null)
			total += this.rightHand.getPhysAtk();
		return total;
	}
	public Integer getTotalMagAtk() {
		Integer total = 0;
		if(this.acc1 != null) total += this.acc1.getMagAtk();
		if(this.acc2 != null) total += this.acc2.getMagAtk();
		if(this.rightHand != null)
			total += this.rightHand.getMagAtk();
		return total;
	}
	public Integer getTotalArmor() {
		Integer total = 0;
		if(this.head != null) total += this.head.getArmor();
		if(this.chest != null) total += this.chest.getArmor();
		if(this.legs != null) total += this.legs.getArmor();
		if(this.acc1 != null) total += this.acc1.getArmor();
		if(this.acc2 != null) total += this.acc2.getArmor();
		if(this.leftHand != null)
			if(this.leftHand.getEquipType() == Shield.class)
				total += Shield.class.cast(this.leftHand).getArmor();
		return total;
	}
	public Integer getTotalMagRes() {
		Integer total = 0;
		if(this.head != null) total += this.head.getMagRes();
		if(this.chest != null) total += this.chest.getMagRes();
		if(this.legs != null) total += this.legs.getMagRes();
		if(this.acc1 != null) total += this.acc1.getMagRes();
		if(this.acc2 != null) total += this.acc2.getMagRes();
		if(this.leftHand != null)
			if(this.leftHand.getEquipType() == Shield.class)
				total += Shield.class.cast(this.leftHand).getMagRes();
		return total;
	}
	public Integer getTotalSpeed() {
		Integer total = 0;
		if(this.acc1 != null) total += this.acc1.getSpeed();
		if(this.acc2 != null) total += this.acc2.getSpeed();
		return total;
	}
}
