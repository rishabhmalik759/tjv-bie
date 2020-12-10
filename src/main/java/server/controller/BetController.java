package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.model.BetEntity;
import server.model.UserEntity;
import server.service.interfaces.BetService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class BetController {
    @Autowired
    private BetService betService;

    @GetMapping(value = "/nextRace/{id}/makeBet")
    public String betMaker() {

        return "makeBet";
    }
    @GetMapping(value = "/myBets")
    public String getAllUsersBets( @AuthenticationPrincipal UserEntity user, Model model) {
        model.addAttribute("bets", betService.findAllByUser(user));
        return "userBetsList";
    }
    @PostMapping(value = "/nextRace/{id}/makeBet")
    public String makeBet(@AuthenticationPrincipal UserEntity user) {


        return "redirect:/nextRace";
    }

}
