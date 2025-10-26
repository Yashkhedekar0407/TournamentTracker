package com.mediaTech.tournamentTracker.Repository;

import com.mediaTech.tournamentTracker.Entity.Tournaments;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TournamentRepo extends MongoRepository<Tournaments,ObjectId> {
    @Query("{'userId':?0}")
public List<Tournaments> findByUserId(ObjectId id);
}
