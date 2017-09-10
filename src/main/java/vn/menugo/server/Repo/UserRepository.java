package vn.menugo.server.Repo;

import org.springframework.data.repository.Repository;
import vn.menugo.server.model.User;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 8/3/2017.
 */
public interface UserRepository extends Repository<User, UUID> {
    User findByUuid(UUID uuid);
    List<User> findAll();
    User save(User name);
}
