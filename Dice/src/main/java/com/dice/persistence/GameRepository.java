package com.dice.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dice.domain.Game;
import com.dice.utilities.InvalidParamException;


@Repository
public class GameRepository {
	
	@Autowired
	private HelperGameRepository repository;
	
	public void saveGame(Game game) throws InvalidParamException {
		if(game ==null)
			throw new InvalidParamException();
		try {
			repository.save(game);
		} catch (Exception e) {
			throw new InvalidParamException();
		}
		
	}

}
