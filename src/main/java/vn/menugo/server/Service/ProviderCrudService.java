package vn.menugo.server.Service;

import vn.menugo.server.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/11/2017.
 */
public interface ProviderCrudService {
    void create(Provider newEntry);
    Provider delete(UUID uuid);
    Provider update(Provider newEntry);
    List<Provider> findAll();
    Provider findByUuid(UUID uuid);
}
