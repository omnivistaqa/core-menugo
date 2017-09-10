package vn.menugo.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.Repo.ProviderRepository;
import vn.menugo.server.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/10/2017.
 */
@Service
public class ProviderRepositoryService implements ProviderCrudService {

    private final ProviderRepository repository;

    @Autowired
    ProviderRepositoryService(ProviderRepository repository){
        this.repository=repository;
    }
    @Override
    public void create(Provider newEntry) {

        Provider p = repository.save(newEntry);
    }

    @Override
    public Provider delete(UUID uuid) {
        return null;
    }

    @Override
    public List<Provider> findAll() {

        List<Provider> providers = repository.findAll();
        return providers;
    }

    @Override
    public Provider findByUuid(UUID uuid) {
        return repository.findByUuid(uuid);
    }

    public List<Provider> findByName(String name){
        return repository.findByName(name);
    }

    @Override
    public Provider update(Provider newEntry) {
        return repository.save(newEntry);
    }
}
