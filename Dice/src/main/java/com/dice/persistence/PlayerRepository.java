package com.dice.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dice.domain.Player;
import com.dice.utilities.InvalidParamException;
import com.dice.utilities.NotFoundException;

@Repository
public class PlayerRepository {

	@Autowired
	private HelperPlayerRepository repository;
	

	public void savePlayer(Player player) throws InvalidParamException {
		if (player == null)
			throw new InvalidParamException();
		try {
			repository.save(player);
		} catch (Exception e) {
			throw new InvalidParamException();
		}

	}

	public List<Player> getAllPlayer() {
		List<Player> result = new ArrayList<>();
		for (Player p : repository.findAll()) {
			result.add(p);
		}
		return result;
	}
	
	public void deletePlayer(int playerId) throws NotFoundException {
		repository.deleteById(playerId);
	}

	public Player getPlayerById(int playerId) throws NotFoundException {
		try {
			return repository.findById(playerId).get();
		} catch (Exception exception) {
			throw new NotFoundException();
		}

	}

	

}
