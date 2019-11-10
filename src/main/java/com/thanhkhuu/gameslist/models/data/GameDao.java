package com.thanhkhuu.gameslist.models.data;

import com.thanhkhuu.gameslist.models.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GameDao extends CrudRepository<Game, Integer> {

}
