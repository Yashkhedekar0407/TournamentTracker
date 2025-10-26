package com.mediaTech.tournamentTracker.service;

import com.mediaTech.tournamentTracker.Entity.Tournaments;
import com.mediaTech.tournamentTracker.Repository.TournamentRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepo tournamentRepo;

    public Tournaments saveTournamentDetail( Tournaments tournament) {
        return  tournamentRepo.save(tournament);

    }

    public List<Tournaments> getAll() {
        return tournamentRepo.findAll();
    }

    public List<Tournaments> getById(ObjectId id) {
        return tournamentRepo.findByUserId(id);
    }

    public void deleteTournament(ObjectId id) {
         tournamentRepo.deleteById(id);
    }
}
