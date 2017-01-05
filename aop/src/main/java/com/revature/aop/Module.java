package com.revature.aop;

import org.springframework.stereotype.Service;

/**
 * Not concerned with Logging at all. Just does its own thing
 *
 */
@Service(value="module")
public class Module {
	
	public int moreFun(int x, int y){
		return x * y;
	}
	
	public int moreFun(){
		if(Math.random() > 0.5){
			throw new RuntimeException("It's raining outside");
		}
		return 5 * 15;
	}
	
	public String fun(){
		if(Math.random() > 0.5){
			throw new RuntimeException("It's raining outside");
		}
		return "Fun fun fun fun!";
	}

	public void dontDoThis(){
		System.out.println("public void dontDoThis()");
	}
	
	public void doFun(){
		System.out.println("public void doFun()");
	}
	
	public void doWork(){
		System.out.println("public void doWork()");
	}
	
	public void doWork(String a){
		System.out.println("public void doWork(String a)");
	}
	
	public void doWork(String a, int b){
		System.out.println("public void doWork(String a, int b)");
	}
	
	public void doWork(String a, String b){
		System.out.println("public void doWork(String a, String b)");
	}
}
