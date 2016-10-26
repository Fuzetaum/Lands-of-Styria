package com.company.styria.equipment;

public abstract class Equipment {
	public static final Integer EQUIPSLOT_HAND=0;
	public static final Integer EQUIPSLOT_2HAND=1;
	public static final Integer EQUIPSLOT_HEAD=2;
	public static final Integer EQUIPSLOT_CHEST=3;
	public static final Integer EQUIPSLOT_LEGS=4;
	public static final Integer EQUIPSLOT_ACCESSORY=5;
	
	public abstract Integer getEquipSlot();
	public abstract Object getEquipType();
}