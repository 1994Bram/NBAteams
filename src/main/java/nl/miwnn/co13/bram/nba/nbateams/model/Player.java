package nl.miwnn.co13.bram.nba.nbateams.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author Bram van Ham
 * A player that plays for a Team
 **/
@Entity
public class Player {
    @Id @GeneratedValue
    private Long playerId;
    private String namePlayer;
    private int birthYear;
    private String birthPlace;

    public Player(String namePlayer, int birthYear, String birthPlace) {
        this.namePlayer = namePlayer;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
    }

    @ManyToOne
    private Team team;

    public Player() {
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
