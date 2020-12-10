package server.controller.RESTapi;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.model.RegistrationEntity;
import server.service.interfaces.RegistrationService;

import javax.naming.directory.InvalidAttributesException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationAPIController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(registrationService.findAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getRegistration(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(registrationService.findById(id));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> createRegistration(@Valid @RequestBody RegistrationEntity registration) {
        try {
            return ResponseEntity.ok(registrationService.save(registration));
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> updateRegistration(@PathVariable(value = "id") Long id, @Valid @RequestBody RegistrationEntity registration) {
        try {
            return ResponseEntity.ok(registrationService.update(id, registration));
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (InvalidAttributesException e) {
            //e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> deleteRegistration(@PathVariable(value = "id") Long id) {
        try {
            registrationService.delete(id);
        } catch (NotFoundException e) {
            //e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
