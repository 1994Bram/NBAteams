package nl.miwnn.co13.bram.nba.nbateams.controller;

import nl.miwnn.co13.bram.nba.nbateams.model.Player;
import nl.miwnn.co13.bram.nba.nbateams.model.Team;
import nl.miwnn.co13.bram.nba.nbateams.repositories.PlayerRepository;
import nl.miwnn.co13.bram.nba.nbateams.repositories.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Bram van Ham
 * Handles all requests regarding Teams
 **/
@Controller
public class TeamController {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository, PlayerRepository playerRepository, PlayerRepository playerRepository1) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository1;
    }

    @GetMapping("/team")
    private String showTeamsOverview(Model model) {
        List<Team> teams = new ArrayList<>();
        model.addAttribute("allTeams", teamRepository.findAll());
        return "teamsOverview";
    }

    @GetMapping("/team/new")
    private String showTeamForm(Model model) {
        model.addAttribute("team", new Team());
        return "teamForm";
    }

    @PostMapping("/team/new")
    private String saveTeam(@ModelAttribute("team") Team teamToBeSaved, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            teamRepository.save(teamToBeSaved);
        }
        return "redirect:/team";
    }

    @GetMapping("/team/new/{playerId}")
    private String createNewTeam(@PathVariable("playerId") Long playerId) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if (optionalPlayer.isPresent()) {
            Team team = new Team();
            team.setPlayer(optionalPlayer.get());
            teamRepository.save(team);
        }
        return "redirect:/";
    }
}