package tn.esprit.spring.DAO.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="chamber")
public class Chamber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChamber ;

    @Column(name="numeroChamber")
    private int numerochamber ;

    @Column(name="TypeC")
    private TypeChamber typeC ;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Bloc> blocs;

    @ManyToOne(cascade =  CascadeType.ALL)
    Reservation res  ;

}
