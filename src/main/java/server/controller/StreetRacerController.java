package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.model.StreetRacerEntity;
import server.service.interfaces.StreetRacerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/racers")
public class StreetRacerController {
    @Autowired
    private StreetRacerService racerService;

    @GetMapping(value = "")
    public String getAll(Model model) {
        model.addAttribute("racers", racerService.findAllSortedByWins());
        return "racerList";
    }

    @GetMapping(value = "/{id}/statistics")
    public String getStatistics(@PathVariable(value = "id") Long id, Model model) {

        return "racerStatistics";
    }

}
