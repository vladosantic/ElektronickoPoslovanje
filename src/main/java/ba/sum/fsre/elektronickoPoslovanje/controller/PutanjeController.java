package ba.sum.fsre.elektronickoPoslovanje.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PutanjeController {

    @GetMapping("/udomi")
    public String udomi(){
        return "udomi";
    }
}
