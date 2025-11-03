package com.mediaTech.tournamentTracker.Entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "tournament_details")
public class Tournaments {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String tournamentName;
    private String location;
    private String result;
    private double prize;
    private LocalDate date;
    private String note;


    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId userId;

    public Tournaments(ObjectId id, String tournamentName, String location, String result, double prize, LocalDate date, String note, ObjectId userId) {
        this.id = id;
        this.tournamentName = tournamentName;
        this.location = location;
        this.result = result;
        this.prize = prize;
        this.date = date;
        this.note = note;
        this.userId = userId;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }



    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
