package com.thanhkhuu.gameslist.models.data;

import com.thanhkhuu.gameslist.models.GamePlatform;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GamePlatformDao extends CrudRepository<GamePlatform, Integer> {
}
