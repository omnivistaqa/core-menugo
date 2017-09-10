package vn.menugo.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.Repo.BillRepository;
import vn.menugo.server.Repo.UserRepository;
import vn.menugo.server.model.User;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 8/3/2017.
 */
@Service
public class UserRepositoryService implements  UserCrudService {

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User delete(UUID uuid) {
        return null;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    public User findByUuid(UUID uuid) {
        return userRepository.findByUuid(uuid);
    }

    public List<User> findAll(){return userRepository.findAll();}
}
