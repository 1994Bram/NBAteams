package nl.miwnn.co13.bram.nba.nbateams.controller;

import nl.miwnn.co13.bram.nba.nbateams.model.Player;
import nl.miwnn.co13.bram.nba.nbateams.repositories.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bram van Ham
 * Handles all request regarding players
 **/

@Controller
public class PlayersController {
    private final PlayerRepository playerRepository;

    public PlayersController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/")
    private String showPlayersOverview(Model model) {
        List<Player> players = new ArrayList<>();

        model.addAttribute("allPlayers", playerRepository.findAll());

        return "playersOverview";
    }

    @GetMapping("/player/new")
    private String showPlayerForm(Model model) {
        model.addAttribute("player", new Player());

        return "playerForm";
    }

    @PostMapping("/player/new")
    private String savePlayer(@ModelAttribute("player") Player playerToBeSaved, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            playerRepository.save(playerToBeSaved);
        }

        return "redirect:/";
    }
}
