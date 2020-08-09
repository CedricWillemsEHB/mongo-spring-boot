package com.opencodez.repository;

import com.opencodez.model.Player;
import com.opencodez.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository  extends MongoRepository<Room, String> {
    Room findFirstByX(int x);
}
