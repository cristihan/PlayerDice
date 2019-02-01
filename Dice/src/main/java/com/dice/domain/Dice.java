package com.dice.domain;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	
	private int sides;
	private Random generateRandom = new Random();
	private ThreadLocalRandom random = ThreadLocalRandom.current();
	
	public Dice() {
		sides = random.nextInt(1, 7);
	}
	
	public Dice(int sides) throws Exception {
		if(sides <=0)
			throw new Exception();
		this.sides = sides;
		sides = random.nextInt(sides);
	}
	
	
	public int getSides() {
		return sides;
	}

	
	
	
	

}
