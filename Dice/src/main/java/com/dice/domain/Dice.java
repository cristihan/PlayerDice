package com.dice.domain;


import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	
	private int sides;
	
	private ThreadLocalRandom random = ThreadLocalRandom.current();
	private int result;
	
	public Dice() {
		result = random.nextInt(1, 7);
	}
	
	public Dice(int sides) throws Exception {
		if(sides <=0)
			throw new Exception();
		
		this.sides = sides;
		result = random.nextInt(sides);
	}
	
	
	public int getSides() {
		return sides;
	}	

	public void setSides(int sides) {
		this.sides = sides;
	}


	public void setResult(int result) {
		this.result = result;
	}

	public int getResult() {
		return result;
	}
	
	

	
	
	
	

}
