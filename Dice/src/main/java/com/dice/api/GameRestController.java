package com.dice.api;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dice.applicationDTO.GameDTO;
import com.dice.controller.GameController;
import com.dice.utilities.InvalidParamException;
import com.dice.utilities.NotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@CrossOrigin
@RequestMapping("/players/{playerId}/games")//Esta Peticion URL afectara a toda las peticiones de la clase
public class GameRestController {
	
	@Autowired
	private GameController controller;
	
	private String toJson(Object object) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);
		
	}
	
	//POST /players/{id}/games/ : un jugador específic realitza una tirada dels daus.
	@PostMapping(produces = "application/json;charset=UTF-8")
	public String playGame(@PathVariable int playerId, @RequestBody String json) throws NotFoundException, InvalidParamException, JSONException {
		JSONObject jsonObj=new JSONObject(json);
		String numberDice = jsonObj.getString("numberDice");
		GameDTO game = controller.createGame(playerId, Integer.parseInt(numberDice));
		return toJson(game);
		
	}
	
	//DELETE /players/{id}/games: elimina les tirades del jugador.
	@DeleteMapping(produces = "application/json;charset=UTF-8")
	public void removeAllGames(@PathVariable int playerId) throws NotFoundException, InvalidParamException {
		controller.deleteGamesPlayer(playerId);		
		
	}
	
	//GET /players/{id}/games: retorna el llistat de jugades per un jugador.
	@GetMapping(produces = "application/json;charset=UTF-8")
	public String getPlayerGameList(@PathVariable int playerId) throws NotFoundException, InvalidParamException {
		 List<GameDTO> games = controller.getAllGamesByPlayer(playerId);
		 return toJson(games);
		
	}
}
