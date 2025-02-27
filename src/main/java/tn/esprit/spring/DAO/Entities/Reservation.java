package tn.esprit.spring.DAO.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;

    @Column(name="anneeReservation")
    private Date anneeReservation ;

    @Column(name="estValide")
    private Boolean estValide ;

    @ManyToMany(cascade = CascadeType.ALL)
    public Set<Etudiant> etudiants = new HashSet<>();
}
