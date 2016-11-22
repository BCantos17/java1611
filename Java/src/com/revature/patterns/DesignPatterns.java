package com.revature.patterns;

public class DesignPatterns {

	static PowerWeapon weaponA = null;
	static PowerWeapon weaponB = null;
	
	public static void main(String[] args) throws InterruptedException {
		// Make 2 threads that try to access Singleton
		// Notice the race condition
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				weaponA = TorqueBow.getInstance();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				weaponB = TorqueBow.getInstance();
				weaponB.fire();
			}
		});
		t1.start(); t2.start();
		t1.join(); t2.join();
		System.out.println(weaponA);
		System.out.println(weaponB);
		System.out.println(weaponA == weaponB);
	}
	
}

/**
 * Singleton code.
 * Only want one copy of an object in memory
 * 	1. Resource intensive objects
 * 	2. Components: we don't need multiple copies
 * @author Owner
 *
 */
interface PowerWeapon extends Gun{
	public void fire();
}
class TorqueBow implements PowerWeapon{
	private static TorqueBow INSTANCE; // singleton copy
	private static final Object lock = new Object(); //obtain intrinsic lock on this
	private TorqueBow(){} //no one can call my constructor
	public static TorqueBow getInstance(){
		// code not needed to be synchronized
		synchronized(lock){
			if(INSTANCE == null)
				// only create object if INSTANCE is null
				INSTANCE = new TorqueBow(); //only 1st time method is called
		}
		// code not needed to be synchronized
		return INSTANCE; // if not null, just return INSTANCE
	}
	public void fire(){}
}


/**
 * Factory code
 * @author Owner
 *
 */
interface Gun{}
class AK47 implements Gun{} // decoupled from 
class M16 implements Gun{}   // these classes
class Factory{
	public static Gun newGun(){ // factory method
		return new AK47();
	} 
}
