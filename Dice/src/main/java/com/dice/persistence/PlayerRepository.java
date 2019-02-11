package com.dice.persistence;

import org.springframework.beans.factory.annotation.Autowired;

import com.dice.domain.Player;
import com.dice.utilities.InvalidParamException;

public class PlayerRepository {
	
	@Autowired
	private HelperPlayerRepository repository;
	
	public void addPlayer(Player player) throws InvalidParamException {
		if(player ==null) {
			throw new InvalidParamException();
			
			
		}
	}

}
