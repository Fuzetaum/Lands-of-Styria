package com.company.styria.equipment;

public class Accessory extends Equipment {
	private Integer HP;
	private Integer SP;
	private Integer atk;
	private Integer magAtk;
	private Integer armor;
	private Integer magRes;
	private Integer speed;
	
	public Accessory(Integer HP,Integer SP,Integer attack,Integer magAtk,
			Integer armor,Integer magRes,Integer speed) {
		this.HP=HP;this.SP=SP;this.atk=attack;this.magAtk=magAtk;
		this.armor=armor;this.magRes=magRes;this.speed=speed;
	}
	
	@Override
	public Object getEquipType() {return Accessory.class;}
	@Override
	public Integer getEquipSlot() {return Equipment.EQUIPSLOT_ACCESSORY;}
	public Integer getHP() {return (this.HP != 0)? this.HP : 0;}
	public Integer getSP() {return (this.SP != 0)? this.SP : 0;}
	public Integer getAttack() {return (this.atk != 0)? this.atk : 0;}
	public Integer getMagAtk() {return (this.magAtk != 0)? this.magAtk : 0;}
	public Integer getArmor() {return (this.armor != 0)? this.armor : 0;}
	public Integer getMagRes() {return (this.magRes != 0)? this.magRes : 0;}
	public Integer getSpeed() {return (this.speed != 0)? this.speed : 0;}
}
