package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Repositories.BlocRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class BlocService implements IBlocService{
    BlocRepository blocRepository ;
    public List<Bloc> findByNomBloc(String nomBloc){
        return blocRepository.findByNomBloc(nomBloc);
    }

    @Override
    public List<Bloc> findByCapacityBloc(int capacity) {
        return blocRepository.findByCapaciteBloc(capacity);
    }

    @Override
    public List<Bloc> findByNomBlocAndCapacityBloc( String nomBloc , int capacity ) {
        return blocRepository.findBlocByNomBlocAndCapaciteBloc(nomBloc ,capacity );
    }

    @Override
    public List<Bloc> findByNomBlocIgn(String nomBloc) {
        return blocRepository.findBlocByNomBlocIgnoreCase(nomBloc);
    }

    @Override
    public List<Bloc> findBlocByCapaciteBlocGreaterThan(int capacity) {
        return blocRepository.findBlocByCapaciteBlocGreaterThan(capacity);
    }

    @Override
    public List<Bloc> findBlocByNomBlocContaining(String nomBloc) {
        return blocRepository.findBlocByNomBlocContaining(nomBloc);
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b); //ajouter many
    }

    @Override
    public List<Bloc> addAllBlocs(List<Bloc> ls) {
        return blocRepository.saveAll(ls);
    }

    @Override
    public Bloc editBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findById(long id) {
        //return blocRepository.findById(id);
        return blocRepository.findById(id).orElse(Bloc.builder().idBloc(0).nomBloc("No Bloc Founded").build());

    }

    @Override
    public void deleteByID(long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public void delete(Bloc b) {
        blocRepository.delete(b);
    }
}
