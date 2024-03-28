package nl.miwnn.co13.bram.nba.nbateams.repositories;

import nl.miwnn.co13.bram.nba.nbateams.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
public interface PlayerRepository extends JpaRepository<Player, Long> {
}