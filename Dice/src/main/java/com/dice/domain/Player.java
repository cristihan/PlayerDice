package com.dice.domain;

import java.util.ArrayList;
import java.util.List;

import com.dice.application.DTO.PlayerDTO;
import com.dice.utilities.NameRequiredException;
import com.dice.utilities.NotFoundException;

public class Player {
	
	private String name;
	private int wins = 0;
	private List<GameDice> resultPlay = new ArrayList<>();
	private static final String ANONYMOUS="Anonimo";
	
	public Player(String name) throws NotFoundException {
		if(name == null || name.equals(""))
			throw new NotFoundException();
		this.name = name;
	}
	
	public Player(PlayerDTO player) throws NameRequiredException {
		if(player == null || player.getName() == null)
			throw new NameRequiredException();
		if(!player.getName().equals("") && !player.getName().equalsIgnoreCase(ANONYMOUS)){
			this.name = player.getName();
		}else {
			this.name = ANONYMOUS;
		}
	}
	
	

}
