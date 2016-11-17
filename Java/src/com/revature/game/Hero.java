package com.revature.game;

import java.io.Serializable;
					// marker interface
					// no methods
public class Hero implements Serializable{
	
	private String name = "Unnamed";
	private int level = 1;
	private int hitPoints;
	private int manaPoints;
	private int experiencePoints;
	private String clazz;
	// this variable will not be serialized
	private transient String weapon = "Hands";

	@Override
	public String toString() {
		return "Hero [name=" + name + ", level=" + level + ", hitPoints=" + hitPoints + ", manaPoints=" + manaPoints
				+ ", experiencePoints=" + experiencePoints + ", clazz=" + clazz + ", weapon=" + weapon + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	public int getManaPoints() {
		return manaPoints;
	}
	public void setManaPoints(int manaPoints) {
		this.manaPoints = manaPoints;
	}
	public int getExperiencePoints() {
		return experiencePoints;
	}
	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public Hero(String name, int level, int hitPoints, int manaPoints, int experiencePoints, String clazz,
			String weapon) {
		super();
		this.name = name;
		this.level = level;
		this.hitPoints = hitPoints;
		this.manaPoints = manaPoints;
		this.experiencePoints = experiencePoints;
		this.clazz = clazz;
		this.weapon = weapon;
	}
	public Hero() {
		super();
	}
	
	
	
}
