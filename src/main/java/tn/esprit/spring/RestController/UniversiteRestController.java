package tn.esprit.spring.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Universite;
import tn.esprit.spring.Services.IUniversite;
@RestController
@AllArgsConstructor
public class UniversiteRestController {
    IUniversite iUniversiteService;

    @PutMapping("/updateUniversite/{nomFoyer}/{nomUniversite}")
    Universite affecterFoyerAuniversite(@PathVariable("nomFoyer") String idFoyer , @PathVariable("nomUniversite") String nomUniversite){
        return iUniversiteService.affecterFoyerAuniversite(idFoyer,nomUniversite);
    }

    @PutMapping("desaffecterUniversite/{idUnive}")
    Universite descaffecterFoyer(@PathVariable("idUnive")long id){
        return iUniversiteService.desaffecterFoyerAUniversite(id);
    }

    @PostMapping("/addUniversite")
    Universite addUniversite(@RequestBody Universite u){

        System.out.println("add universite");
        return iUniversiteService.addUniversite(u);
    }

    @DeleteMapping("/deleteUniversite")
    void deleteUniversite(@RequestBody Universite u){
        iUniversiteService.deleteUniversite(u);
    }

}
