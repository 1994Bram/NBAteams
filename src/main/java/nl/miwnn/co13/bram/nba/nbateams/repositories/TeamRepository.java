package nl.miwnn.co13.bram.nba.nbateams.repositories;

import nl.miwnn.co13.bram.nba.nbateams.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
public interface TeamRepository extends JpaRepository<Team, Long> {
}
