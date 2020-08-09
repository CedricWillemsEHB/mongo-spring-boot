package com.opencodez.repository;

import com.opencodez.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {
    Player findFirstByName(String name);

}
