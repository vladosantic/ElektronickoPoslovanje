package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.dto.ObjavaDto;
import ba.sum.fsre.elektronickoPoslovanje.model.LokacijaEntity;
import ba.sum.fsre.elektronickoPoslovanje.model.ObjavaEntity;
import ba.sum.fsre.elektronickoPoslovanje.model.UserEntity;
import ba.sum.fsre.elektronickoPoslovanje.repository.UserRepository;
import ba.sum.fsre.elektronickoPoslovanje.service.LokacijaService;
import ba.sum.fsre.elektronickoPoslovanje.service.ObjavaService;
import ba.sum.fsre.elektronickoPoslovanje.service.SlackNotifier;
import ba.sum.fsre.elektronickoPoslovanje.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/objava")
public class ObjavaController {
    @Autowired
    private ObjavaService objavaService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private SlackNotifier slackNotifier;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping
    public ObjavaEntity createObjava(@RequestBody ObjavaEntity objava) {

        objava.setDatumObjave(new Timestamp(System.currentTimeMillis()));

        ObjavaEntity createdObjava = objavaService.create(objava);

        // Pravi se da ovo ne vidiš :D
        Integer autorId = createdObjava.getKorisnikId().getId().intValue();
        String imeAutora = jdbcTemplate.queryForObject("SELECT name FROM users WHERE id = ?", new Object[]{autorId}, String.class);

        Integer lokacijaId = createdObjava.getLokacijaId().getId().intValue();
        String imeLokacije = jdbcTemplate.queryForObject("SELECT naziv FROM lokacija WHERE id = ?", new Object[]{lokacijaId}, String.class);

        Integer zivotinjaId = createdObjava.getZivotinjaId().getId().intValue();
        String imeZivotinje = jdbcTemplate.queryForObject("SELECT ime FROM zivotinja WHERE id = ?", new Object[]{zivotinjaId}, String.class);

        String formattedString = "NOVA OBJAVA!!!\n" +
                "Autor: " + imeAutora +
                "\nLokacija: " + imeLokacije +
                "\nŽivotinja: " + imeZivotinje +
                "\nDatum objave: " + createdObjava.getDatumObjave() +
                "\nTekst objave: " + createdObjava.getTekstObjave() +
                "\nZa više informacija posjetite našu web stranicu.";

        // Send a message to the Slack channel
        slackNotifier.sendToSlack("C06L2JKK2GY", formattedString);

        // Send WebSocket update to "/topic/objavaUpdates"
        simpMessagingTemplate.convertAndSend("/topic/objavaUpdates", createdObjava);

        return createdObjava;
    }

    @GetMapping
    public List<ObjavaDto> getAllObjavas() {
        return objavaService.findAllDtos();
    }

    @GetMapping("/{id}")
    public Optional<ObjavaDto> getObjavaById(@PathVariable Integer id) {
        return objavaService.findDtoById(id);
    }

    @PutMapping("/{id}")
    public ObjavaDto updateObjava(@PathVariable Integer id, @RequestBody ObjavaEntity objava) {
        return objavaService.update(objava);
    }

    @DeleteMapping("/{id}")
    public void deleteObjava(@PathVariable Integer id) {
        objavaService.delete(id);
    }
}
