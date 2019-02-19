package com.dice.domain;

import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Dice {

	@Column(name = "sides")
	private int sides;

	@Column(name = "result")
	private int result;

	private ThreadLocalRandom random = ThreadLocalRandom.current();

	public Dice() {
		result = random.nextInt(1, 8);

	}

	public Dice(int sides) throws Exception {
		if (sides <= 0)
			throw new Exception();

		this.sides = sides;
		result = random.nextInt(sides);
	}

	public void rollDice() {
		result = random.nextInt(1, 8);
	}

	public int getSides() {
		return sides;
	}

	public int getResult() {
		return result;
	}

}
