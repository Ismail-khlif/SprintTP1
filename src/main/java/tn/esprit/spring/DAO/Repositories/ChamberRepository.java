package tn.esprit.spring.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Chamber;
import tn.esprit.spring.DAO.Entities.TypeChamber;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public interface ChamberRepository  extends JpaRepository<Chamber,Long> {
    Chamber findByNumerochamberAndTypeC(long numero , TypeChamber type);
    // select * from chamber where numhamber> ?

    Chamber findByNumerochamber(long numero);
    List<Chamber> findByTypeC(TypeChamber type);
    List<Chamber> findByBloc(Bloc b);
    List<Chamber> findByBlocAndTypeC(Bloc b , TypeChamber type);
    List<Chamber> getByNumerochamberGreaterThan(long value);
    //select *from Chamber where numberchamber != null
    List<Chamber> getByNumerochamberIsNotNull();


    List<Chamber> findByBlocFoyerUniversiteNomUniversiteAndResAnneeReservationAndResEtuNomEt(String nomUni , Date annee
    ,String nomET);


    // Recherche par numéro de chamber
    @Query("select c from Chamber c where c.numerochamber=?1")
    List<Chamber> selectByNum(long num);


    @Query("select c from Chamber c where c.numerochamber=:num")
    List<Chamber> selectByNum2(@Param(value="num") long num)  ;

    @Query(value="select * from chamber where numeroChamber=?1" , nativeQuery = true)
    List<Chamber> selectByNumSQL( long num)  ;
}
