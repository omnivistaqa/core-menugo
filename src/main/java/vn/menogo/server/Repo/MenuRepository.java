package vn.menogo.server.Repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import vn.menogo.server.model.Menu;
import vn.menogo.server.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/10/2017.
 */
public interface MenuRepository extends Repository<Menu, UUID> {

    public List<Menu> findByName(String name);


    public List<Menu> findByProvider(Provider provider);

    public Menu findByUuid(UUID uuid);
    public List<Menu> findAll();
    public Menu save(Menu p);

}
