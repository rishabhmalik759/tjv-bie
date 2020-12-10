package server.service.interfaces;

import javassist.NotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import server.model.UserEntity;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    List<UserEntity> findAll();

    UserEntity findById(Long id) throws NotFoundException;

    UserEntity save(UserEntity user) throws InvalidAttributesException;

    UserEntity update(Long id, UserEntity user) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;

    UserEntity findByName(String username) throws NotFoundException;
}
