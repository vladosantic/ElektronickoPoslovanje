package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.dto.CommentUpdateMessage;
import ba.sum.fsre.elektronickoPoslovanje.dto.KomentarDto;
import ba.sum.fsre.elektronickoPoslovanje.model.KomentarEntity;
import ba.sum.fsre.elektronickoPoslovanje.model.ObjavaEntity;
import ba.sum.fsre.elektronickoPoslovanje.model.UserEntity;
import ba.sum.fsre.elektronickoPoslovanje.service.KomentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/komentar")
public class KomentarController {

    @Autowired
    private KomentarService komentarService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping
    public KomentarEntity createKomentar(@RequestBody KomentarEntity komentar) {

        KomentarEntity komentar1 = komentarService.create(komentar);
            CommentUpdateMessage updateMessage = new CommentUpdateMessage("New post added", komentar1);
            simpMessagingTemplate.convertAndSend("/topic/commentUpdates/" + komentar1.getObjavaId().getId(), updateMessage);

        return  komentar1;
    }

    @GetMapping
    public List<KomentarDto> getAllKomentars() {
        return komentarService.findAllDtos();
    }

    @GetMapping("/{id}")
    public Optional<KomentarDto> getKomentarById(@PathVariable Integer id) {
        return komentarService.findDtoById(id);
}

    @PutMapping("/{id}")
    public KomentarDto updateKomentar(@PathVariable Integer id, @RequestBody KomentarEntity komentar) {
        return komentarService.update(komentar);
    }

    @DeleteMapping("/{id}")
    public void deleteKomentar(@PathVariable Integer id) {

        Optional<KomentarDto> komentar1 = komentarService.findDtoById(id);


        CommentUpdateMessage updateMessage = new CommentUpdateMessage("Delete post", id);
        simpMessagingTemplate.convertAndSend("/topic/commentUpdates/" + komentar1.get().getObjavaId(), updateMessage);
        komentarService.delete(id);
    }


}
