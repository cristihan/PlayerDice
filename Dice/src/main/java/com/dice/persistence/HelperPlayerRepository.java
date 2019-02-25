package com.dice.persistence;

import org.springframework.data.repository.CrudRepository;

import com.dice.domain.Player;






// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

interface HelperPlayerRepository extends CrudRepository<Player, Integer> {

}
