package vn.menogo.server.Repo;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import vn.menogo.server.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/10/2017.
 */
public interface ProviderRepository extends Repository<Provider, UUID> {

    public List<Provider> findByName(String name);
    public Provider findByUuid(UUID uuid);
    public List<Provider> findAll();
    public Provider save(Provider p);


}
