package com.dice.persistence;

import org.springframework.data.repository.CrudRepository;

import com.dice.domain.Game;

interface  HelperGameRepository extends CrudRepository<Game, Integer> {

}
