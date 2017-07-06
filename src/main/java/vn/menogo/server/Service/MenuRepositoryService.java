package vn.menogo.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menogo.server.Repo.MenuRepository;
import vn.menogo.server.Repo.ProviderRepository;
import vn.menogo.server.model.Menu;
import vn.menogo.server.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/10/2017.
 */
@Service
public class MenuRepositoryService implements MenuCrudService {

    private final MenuRepository repository;

    @Autowired
    MenuRepositoryService(MenuRepository repository){
        this.repository=repository;
    }
    @Override
    public void create(Menu newEntry) {

        Menu menu = repository.save(newEntry);
    }

    @Override
    public Menu delete(UUID uuid) {
        return null;
    }

    @Override
    public List<Menu> findAll() {
        return null;
    }

    @Override
    public Menu findByUuid(UUID uuid) {
        return null;
    }

    @Override
    public Menu update(Menu newEntry) {
        return null;
    }

    @Override
    public List<Menu> findByProvider(Provider provider) {
        return repository.findByProvider(provider);
    }

}
