package vn.menugo.server.Service;

import vn.menugo.server.model.User;

import java.util.UUID;

/**
 * Created by itn0309 on 8/3/2017.
 */
public interface UserCrudService {
    void create(User user);
    User delete(UUID uuid);
    User update(User user);
}
