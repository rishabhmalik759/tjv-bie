package server.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.model.RaceEntity;
import server.model.RegistrationEntity;
import server.model.StreetRacerEntity;
import server.model.UserEntity;
import server.service.interfaces.RaceService;
import server.service.interfaces.RegistrationService;
import server.service.interfaces.StreetRacerService;

import javax.naming.directory.InvalidAttributesException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private RaceService raceService;
    @Autowired
    private StreetRacerService racerService;

    @PostMapping(value = "/registerToRace")
    String createRegistration(@AuthenticationPrincipal UserEntity user) {
        RaceEntity race=null;
        StreetRacerEntity racer=null;
        try {
            race=raceService.getNextRace();
            racer=racerService.findById(user.getId());
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return "redirect:/nextRace";
        }
        RegistrationEntity reservation = new RegistrationEntity(race,racer);
        try {
            registrationService.save(reservation);
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return "redirect:/nextRace";
        }
        return "redirect:/nextRace";
    }
}
