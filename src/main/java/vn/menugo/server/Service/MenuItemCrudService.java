package vn.menugo.server.Service;

import vn.menugo.server.model.MenuItem;
import vn.menugo.server.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/11/2017.
 */
interface MenuItemCrudService {
    void create(MenuItem item);
    MenuItem delete(UUID uuid);
    MenuItem update(MenuItem item);
    List<MenuItem> findAll();
    MenuItem findByUuid(UUID uuid);
    List<MenuItem> findByProvider(Provider provider);

}
