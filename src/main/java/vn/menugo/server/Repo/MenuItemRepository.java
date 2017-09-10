package vn.menugo.server.Repo;

import org.springframework.data.repository.Repository;
import vn.menugo.server.model.MenuItem;
import vn.menugo.server.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/10/2017.
 */
public interface MenuItemRepository extends Repository<MenuItem, UUID> {

    public List<MenuItem> findByName(String name);
    public MenuItem findByUuid(UUID uuid);
    public List<MenuItem> findByProvider(Provider provider);

    public List<MenuItem> findAll();
    public MenuItem save(MenuItem p);

}
