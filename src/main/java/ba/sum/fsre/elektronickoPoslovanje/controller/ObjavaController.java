package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.dto.ObjavaDto;
import ba.sum.fsre.elektronickoPoslovanje.model.ObjavaEntity;
import ba.sum.fsre.elektronickoPoslovanje.model.UserEntity;
import ba.sum.fsre.elektronickoPoslovanje.repository.UserRepository;
import ba.sum.fsre.elektronickoPoslovanje.service.ObjavaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private WebSocketController webSocketController;


    @PostMapping
    public ObjavaEntity createObjava(@RequestBody ObjavaEntity objava) {

        objava.setDatumObjave(new Timestamp(System.currentTimeMillis()));

        ObjavaEntity createdObjava = objavaService.create(objava);

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
