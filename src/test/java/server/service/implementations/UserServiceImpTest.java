package server.service.implementations;

import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import server.controller.RESTapi.UserAPIController;
import server.model.UserEntity;
import server.repository.UserRepository;
import server.service.interfaces.UserService;

import javax.naming.directory.InvalidAttributesException;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImpTest {

    @InjectMocks
    private UserServiceImp service;

    @Mock
    private UserRepository repository;

    private UserEntity user;

    @Before
    public void setUp() throws NotFoundException {
        user = new UserEntity("user", "12345");
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(repository.findByUsername("test")).thenReturn(Optional.empty());
    }

    @Test
    public void findById() throws NotFoundException {
        assertEquals(service.findById(1L), user);
    }

    @Test(expected = InvalidAttributesException.class)
    public void save() throws InvalidAttributesException {
        service.save(user);
    }

    @Test(expected = NotFoundException.class)
    public void findByNameExc() throws NotFoundException {
        service.findByName("test");
    }

    @Test
    public void findByName() throws NotFoundException {
        Mockito.when(repository.findByUsername("user")).thenReturn(Optional.of(user));
        assertEquals(service.findByName("user"), user);
    }
}