package tn.esprit.spring.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.DAO.Entities.Chamber;

public interface ChamberRepository  extends JpaRepository<Chamber,Long> {
}
