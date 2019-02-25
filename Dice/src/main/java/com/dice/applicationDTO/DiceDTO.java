package com.dice.applicationDTO;

import com.dice.domain.Dice;
import com.dice.utilities.InvalidParamException;

public class DiceDTO {
	
	private int sides;
	private int result;
	
	public DiceDTO() {
		
	}
	
	public int getSides() {
		return sides;
	}

	public int getResult() {
		return result;
	}

	public DiceDTO(Dice dice) throws InvalidParamException {
		if(dice == null)
			throw new InvalidParamException();
		this.sides = dice.getSides();
		this.result = dice.getResult();
	}
	
	

}
