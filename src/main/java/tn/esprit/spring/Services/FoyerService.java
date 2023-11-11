package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Repositories.FoyerRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class FoyerService implements IFoyerService {
    FoyerRepository foyerRepository;

    @Override
    public Foyer AddFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> AddAllFoyer(List<Foyer> ls) {
        return foyerRepository.saveAll(ls);
    }

    @Override
    public Foyer editFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> findAllFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findByIDFoyer(long id) {
        return foyerRepository.findById(id).orElse(Foyer.builder().build());
    }

    @Override
    public void DeleteByIDFoyer(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void deleteFoyer(Foyer f) {
        foyerRepository.delete(f);

    }
}
