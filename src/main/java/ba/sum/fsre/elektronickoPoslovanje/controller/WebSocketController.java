package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.model.ObjavaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/updateObjava")
    @SendTo("/topic/objavaUpdates")
    public ObjavaEntity sendObjavaUpdate(ObjavaEntity objava) {
        // Handle and process the received objava, e.g., save to the database
        return objava;
    }
}
