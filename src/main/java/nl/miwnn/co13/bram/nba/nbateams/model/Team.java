package nl.miwnn.co13.bram.nba.nbateams.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author Bram van Ham
 * A team that a player is playing for
 **/
@Entity
public class Team {
    @Id    @GeneratedValue
    private Long teamId;
    private String nameTeam;
    private String cityOfTeam;
    private String stateOfTeam;

    @ManyToOne
    private Player player;

    public Team(String nameTeam, String cityOfTeam, String stateOfTeam) {
        this.nameTeam = nameTeam;
        this.cityOfTeam = cityOfTeam;
        this.stateOfTeam = stateOfTeam;
    }

    public Team() {
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public String getCityOfTeam() {
        return cityOfTeam;
    }

    public void setCityOfTeam(String cityOfTeam) {
        this.cityOfTeam = cityOfTeam;
    }

    public String getStateOfTeam() {
        return stateOfTeam;
    }

    public void setStateOfTeam(String stateOfTeam) {
        this.stateOfTeam = stateOfTeam;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
}