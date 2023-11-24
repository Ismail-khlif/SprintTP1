package tn.esprit.spring.RestController;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Reservation;
import tn.esprit.spring.Services.IChamberService;
import tn.esprit.spring.Services.IReservationService;
import tn.esprit.spring.Services.MailService;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class ReservationRestController {
    IReservationService iReservationService;
    IChamberService iChamberService ;

    MailService mailService;


    @GetMapping("findAllReservation")
    List<Reservation> findAll(){

        //mailService.sendEmail("ahmed.mellouli@esprit.tn","test0","test baba 3zizi");
        return iReservationService.findAllReservations();
    }

    @GetMapping("findReservationByID/{id}")
    Reservation findbyIDReservation(@PathVariable("id") String id){
        return iReservationService.findByIdReservation(id);
    }

    @PostMapping("addReservation")
    Reservation addReservation(@RequestBody Reservation r){
        return iReservationService.addReservation(r);
    }

    @PostMapping("addAllReservation")
    List<Reservation> addAllReservation(@RequestBody List<Reservation> ls){

        //mailService.sendEmail("ahmed.mellouli@esprit.tn","test0","test baba 3zizi");
        return  iReservationService.addAllReservation(ls);
    }

    @PutMapping("updateReservation")
    Reservation updateReservation(@RequestBody Reservation r){
        return iReservationService.editReservation(r);
    }

    @DeleteMapping("DeleteReservation/{id}")
    void DeleteReservationByID(@PathVariable("id") String id){
        iReservationService.deleteById(id);
    }

    @DeleteMapping("DeleteReservation")
    void DeleteReservation(@RequestBody Reservation r){
        iReservationService.deleteReservation(r);
    }

    @PostMapping("generateReservation/{numchamber}/{cin}")
    Reservation addReseravationavecChamber(@PathVariable("numchamber") int numero ,  @PathVariable("cin") long cin){
        return iReservationService.ajouterReservationEtAssignerAChambreEtAEtudiant(numero, cin);
    }
    @GetMapping("/listerReservationsEtudiant/{cin}")
    public List<Reservation> listerReservationsEtudiant(@PathVariable Long cin) {
        mailService.sendEmail("ahmed.mellouli@esprit.tn","test0","test baba 3zizi");
        return iReservationService.listerReservationsEtudiant(cin);
    }

    @GetMapping("/filterByDate")
    public List<Reservation> filterReservationsByDate(
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return iReservationService.filtrerReservationsParDate(date);

    }

    @GetMapping("/filter")
    public List<Reservation> filterReservations(
            @RequestParam("annee")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date annee,
            @RequestParam("valide") Boolean valide
    ) {
        return iReservationService.filtrerReservationsParAnneeEtValide(annee, valide);
    }

    @GetMapping("/chambers/{id}/reservations")
    public Set<Reservation> listerReservationsPourChambre(@PathVariable Long id) {
        return iChamberService.listerReservationsPourChambre(id);
    }
}