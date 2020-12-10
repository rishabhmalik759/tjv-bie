package server.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import server.model.StreetRacerEntity;
import server.model.UserEntity;
import server.service.interfaces.StreetRacerService;
import server.service.interfaces.UserService;

import javax.naming.directory.InvalidAttributesException;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StreetRacerService racerService;

    @GetMapping(value = "/users")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping(value = "/users/{id}", produces = "application/json")
    public String getUser(@PathVariable(value = "id") Long id) {
        return "greeting";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String addUser(@RequestParam String username, @RequestParam String password, @RequestParam("role") String role, Map<String, Object> model, RedirectAttributes redirectAttrs) {
        if (username.length() < 3) {
            model.put("errorMessage", true);
            model.put("message", "Username should be at least 3 characters.");
            return "registration";
        }
        if (password.length() < 3) {
            model.put("errorMessage", true);
            model.put("message", "Password should be at least 3 characters.");
            return "registration";
        }
        UserEntity user = new UserEntity(username, password);
        try {
            userService.findByName(user.getUsername());
        } catch (NotFoundException e) {
            //e.printStackTrace();
            user.setAccount(100);
            try {
                userService.save(user);
            } catch (InvalidAttributesException ex) {
                //ex.printStackTrace();
            }

            if (role.equals("racer")) {
                StreetRacerEntity racer = new StreetRacerEntity();
                racer.setUser(user);
                try {
                    racerService.save(racer);
                } catch (InvalidAttributesException ex) {
                    //ex.printStackTrace();
                }
                user.setRacer(racer);
                try {
                    userService.save(user);
                } catch (InvalidAttributesException ex) {
                    //ex.printStackTrace();
                }
            }

            redirectAttrs.addFlashAttribute("messageBool", true);
            redirectAttrs.addFlashAttribute("message", "You are successfully registered. Please log in.");
            return "redirect:/login";
        }
        model.put("errorMessage", true);
        model.put("message", "That username already exists.");
        return "registration";

    }

}
