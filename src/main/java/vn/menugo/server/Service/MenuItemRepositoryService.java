package vn.menugo.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.Repo.MenuItemRepository;
import vn.menugo.server.model.MenuItem;
import vn.menugo.server.model.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/10/2017.
 */
@Service
public class MenuItemRepositoryService implements MenuItemCrudService {

    private final MenuItemRepository repository;

    @Autowired
    MenuItemRepositoryService(MenuItemRepository repository){
        this.repository=repository;
    }
    @Override
    public void create(MenuItem newEntry) {

        MenuItem MenuItem = repository.save(newEntry);
    }

    @Override
    public MenuItem delete(UUID uuid) {
        return null;
    }

    @Override
    public List<MenuItem> findAll() {
        return null;
    }

    @Override
    public MenuItem findByUuid(UUID uuid) {
        return repository.findByUuid(uuid);
    }

    @Override
    public MenuItem update(MenuItem newEntry) {
        return repository.save(newEntry);
    }

    @Override
    public List<MenuItem> findByProvider(Provider provider) {
        return repository.findByProvider(provider);
    }

    public  List<MenuItem> findFullObjects(List<MenuItem> items){

        List<MenuItem>  newList =new ArrayList<MenuItem>();
        if(items != null){
            for (MenuItem item: items){
                MenuItem newItem = repository.findByUuid(item.getUuid());
                newList.add(newItem);
            }
        }
        return newList;
    }

}
