package server.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.model.RaceEntity;
import server.service.interfaces.RaceService;
import server.service.interfaces.RegistrationService;

import java.util.Optional;

@Controller
public class RaceController {
    @Autowired
    private RaceService raceService;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping(value = "/nextRace")
    public String getNextRace(Model model) {
        RaceEntity nextRace = null;
        try {
            nextRace = raceService.getNextRace();
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return "nextRace";
        }
        model.addAttribute("ok", true);
        model.addAttribute("nextRace", nextRace);
        model.addAttribute("registrations", registrationService.getAllRegistrationsForRace(nextRace.getId()));
        return "nextRace";
    }
}
