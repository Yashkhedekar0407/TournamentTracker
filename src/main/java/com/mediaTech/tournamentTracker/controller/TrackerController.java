package com.mediaTech.tournamentTracker.controller;

import com.mediaTech.tournamentTracker.Entity.Tournaments;
import com.mediaTech.tournamentTracker.service.TournamentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TrackerController {
    @Autowired
    private TournamentService tournamentservice;

    @PostMapping("/{userid}")
    public ResponseEntity<Tournaments> saveTournament(@PathVariable ObjectId userid, @RequestBody Tournaments tournament){
        tournament.setUserId(userid);
        return  new ResponseEntity<Tournaments>(tournamentservice.saveTournamentDetail(tournament), HttpStatus.OK);
    }
    @GetMapping()
    public  ResponseEntity<List<Tournaments>> getAllTournaments(){
        return new ResponseEntity<>(tournamentservice.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{userid}")
    public ResponseEntity<List<Tournaments>> getById(@PathVariable ObjectId userid){
        return new ResponseEntity<>(tournamentservice.getById(userid),HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTournament(@PathVariable ObjectId id){
        tournamentservice.deleteTournament(id);
        return new ResponseEntity<>("deleted succesfully",HttpStatus.OK);
    }

}
