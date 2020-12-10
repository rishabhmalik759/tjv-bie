package server.service.implementations;

import javassist.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.UserEntity;
import server.service.interfaces.UserService;

import javax.naming.directory.InvalidAttributesException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public UserEntity findById(Long id) throws NotFoundException {
        Optional<UserEntity> user = userRepository.findById(id);
        if (!user.isPresent()) throw new NotFoundException("User with that id do not exists");
        return user.get();
    }

    @Override
    @Transactional
    public UserEntity save(UserEntity user)throws InvalidAttributesException {
        if(!user.validate()) throw new InvalidAttributesException("");
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public UserEntity update(Long id, UserEntity user) throws NotFoundException, InvalidAttributesException {
        UserEntity userDB = findById(id);
        userDB.set(user);
        return save(userDB);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        userRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public UserEntity findByName(String username) throws NotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new NotFoundException("User with that username do ton exists.");
        }
        return user.get();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            return findByName(s);
        } catch (NotFoundException e) {
            //e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
