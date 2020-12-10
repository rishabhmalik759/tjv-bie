package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.model.BetTypeEntity;
import server.service.interfaces.BetTypeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/betTypes")
public class BetTypeController {
    @Autowired
    private BetTypeService betTypeService;


}
