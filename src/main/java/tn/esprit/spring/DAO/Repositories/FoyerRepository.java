package tn.esprit.spring.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.DAO.Entities.Foyer;

public interface FoyerRepository extends JpaRepository<Foyer,String> {
}
