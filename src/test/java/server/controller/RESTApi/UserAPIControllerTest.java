package server.controller.RESTApi;

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
import server.service.interfaces.UserService;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserAPIControllerTest {

    @InjectMocks
    private UserAPIController controller;

    @Mock
    private UserService userService;

    private UserEntity user;

    @Before
    public void setUp() throws NotFoundException {
        user = new UserEntity("user", "12345");
        Mockito.when(userService.findById(1L)).thenReturn(user);
    }

    @Test
    public void getUser() {
        assertEquals(controller.getUser(1L), ResponseEntity.ok(user));
    }
}