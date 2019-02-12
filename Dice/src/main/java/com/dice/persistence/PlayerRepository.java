package com.dice.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dice.domain.Game;
import com.dice.domain.Player;
import com.dice.utilities.InvalidParamException;
import com.dice.utilities.NotFoundException;



public class PlayerRepository {

	@Autowired
	private HelperPlayerRepository repository;
	
	private HelperGameRepository gameRepository;

	public void createPlayer(Player player) throws InvalidParamException {
		if (player == null)
			throw new InvalidParamException();
		try {
			repository.save(player);
		} catch (Exception e) {
			throw new InvalidParamException();
		}

	}
	
	public void createGame(Game game) throws InvalidParamException {
		if(game == null)
			throw new InvalidParamException();
		gameRepository.save(game);
	}

	public List<Player> getAllPlayer() {
		List<Player> result = new ArrayList<>();
		for (Player p : repository.findAll()) {
			result.add(p);
		}
		return result;
	}
	
	/*
	 * Este metodo hay que utilizarlo y comprobarlo
	 * o si no borrarlo
	 */
	public void removeByPlayer(Player player) {
		repository.removeByPlayer(player);
	}

	public void removePlayer(int playerId) throws NotFoundException {
		repository.deleteById(playerId);
	}

	public Player getPlayerById(int playerId) throws NotFoundException {
		try {
			return repository.findById(playerId).get();
		} catch (Exception exception) {
			throw new NotFoundException();
		}

	}
	
	
	/*
	 * Este metodo hay que comprobarlo o borrarlo
	 * para base de datos
	 */
	public void updatePlayer(String name) {
		repository.updateByPlayer(name);
	}

}
