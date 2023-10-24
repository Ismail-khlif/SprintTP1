package tn.esprit.spring.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Chamber;
import tn.esprit.spring.DAO.Entities.TypeChamber;

import java.lang.reflect.Type;
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


}
