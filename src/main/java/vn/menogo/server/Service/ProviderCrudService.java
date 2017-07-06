package vn.menogo.server.Service;

import vn.menogo.server.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/11/2017.
 */
public interface ProviderCrudService {
    void create(Provider newEntry);
    Provider delete(UUID uuid);
    List<Provider> findAll();
    Provider findByUuid(UUID uuid);
    Provider update(Provider newEntry);

}
