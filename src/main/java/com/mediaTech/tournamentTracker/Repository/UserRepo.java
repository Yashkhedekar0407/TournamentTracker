package com.mediaTech.tournamentTracker.Repository;

import com.mediaTech.tournamentTracker.Entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepo extends MongoRepository<Users, ObjectId> {

        @Query("{'userName':?0,'password':?1}")
    Users getIDFromCredential(String username, String password);
}
