package com.mediaTech.tournamentTracker.service;

import com.mediaTech.tournamentTracker.Entity.Users;
import com.mediaTech.tournamentTracker.Repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userrepo;

    public List<Users> getAllUsers() {
        return  userrepo.findAll();
    }

    public Users saveUser(Users user) {
        return userrepo.save(user);
    }

    public Optional<Users> getByID(ObjectId id) {

        return userrepo.findById(id);
    }

    public Users getIDFromUsername(String username, String password) {

        Users user = userrepo.getIDFromCredential(username,password);

        if (user!=null){
            return user;
        }
        else {
            return null;
        }

    }
}
