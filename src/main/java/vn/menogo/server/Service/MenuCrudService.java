package vn.menogo.server.Service;

import vn.menogo.server.model.Menu;
import vn.menogo.server.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/11/2017.
 */
public interface MenuCrudService {
    void create(Menu newEntry);
    Menu delete(UUID uuid);
    List<Menu> findAll();
    Menu findByUuid(UUID uuid);
    Menu update(Menu newEntry);
    List<Menu> findByProvider(Provider provider);

}
