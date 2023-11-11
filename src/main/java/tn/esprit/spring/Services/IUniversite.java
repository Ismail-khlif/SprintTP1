package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.Universite;

public interface IUniversite {
    Universite addUniversite(Universite u);
    void deleteUniversite(Universite u);

    Universite affecterFoyerAuniversite(String idFoyer , String nomUniversite);

    Universite desaffecterFoyerAUniversite(long idUniversite);

}
