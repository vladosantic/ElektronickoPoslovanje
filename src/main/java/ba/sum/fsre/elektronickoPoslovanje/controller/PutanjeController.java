package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.model.UserEntity;
import ba.sum.fsre.elektronickoPoslovanje.repository.UserRepository;
import ba.sum.fsre.elektronickoPoslovanje.service.ObjavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@Controller
public class PutanjeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ObjavaService objavaService;

    @GetMapping("/udomi")
    public String udomi(){
        return "udomi";

    }
    @GetMapping("/dodaj")
    public String dodaj(Model model, Principal principal) {
        // Retrieve the logged user's id from the Principal object
        if (principal != null) {
            String loggedInUserId = principal.getName(); // Assuming the username is the user id
            model.addAttribute("loggedInUserId", loggedInUserId);
        }

        return "dodaj";
    }
    @GetMapping("/api/loggedInUserId")
    public ResponseEntity<Map<String, Long>> getLoggedInUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            // Assuming your UserEntity has an email property
            UserEntity userEntity = userRepository.findByEmail(userDetails.getUsername());

            if (userEntity != null) {
                Long userId = userEntity.getId();
                Map<String, Long> result = Collections.singletonMap("userId", userId);
                return ResponseEntity.ok(result);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @GetMapping("/objava/{id}")
    public String prikazObjavu(@PathVariable Long id, Model model) {


        // Dodaj objavu u model kako bi je prikazali na stranici
        model.addAttribute("objavaId", id);


        return "objava/prikazObjave";
    }

    @GetMapping("/objava/uredjivanje/{id}")
    public String uredjivanjeObjavu(@PathVariable Long id, Model model) {


        // Dodaj objavu u model kako bi je prikazali na stranici
        model.addAttribute("objavaId", id);


        return "objava/uredjivanjeObjave";
    }

    @GetMapping("/zivotinje")
    public String prikazZivotinja() {


        return "zivotinje/zivotinje";
    }
    @GetMapping("/zivotinja/dodaj")
    public String dodajZivotinja() {


        return "zivotinje/dodajZivotinju";
    }
    @GetMapping("/zivotinja/uredi/{id}")
    public String uredjivanjeZivotinja(@PathVariable Long id, Model model) {

        model.addAttribute("objavaId", id);


        return "zivotinje/uredi";
    }
    @GetMapping("/vrsta")
    public String vrsta() {


        return "vrsta/vrsta";
    }

}
