package tn.esprit.spring.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.DAO.Entities.Etudiant;
import tn.esprit.spring.DAO.Entities.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {

    //  List<Reservation> findByEstValide();
    List<Reservation> findByEtudiants(Etudiant etudiant);
    List<Reservation> findByAnneeReservation(Date dateReservation);

    List<Reservation> findByAnneeReservationAndEstValide(Date anneeReservation, Boolean estValide);

    //List<Reservation> findByAnneeReservationAndEstValide(int annee , Boolean valide);
}
