package com.company.styria.engine;

import com.company.styria.unit.Unit;

public class CombatEngine {
	/* Decides if attacker's attack is a double hit on target 
	 * If the attacker speed is at least 3 points higher, then the attack will be a double hit
	 * */
	public static boolean isAttackDouble(Unit attacker, Unit target) {
		boolean hits = false;
		if(attacker.getBaseSpeed() > (target.getBaseSpeed()+2)) hits = true;
		return hits;
	}
	
	/* 
	 * Calculates the damage received by the target and apply it
	 * */
	public static void dealPhysicalDamage(Unit attacker, Unit target) {
		Integer damage = 
				Math.max(0,attacker.getEffectivePhysicalDamage() - target.getEffectiveArmor());
		target.damageUnit(damage);
	}
}
