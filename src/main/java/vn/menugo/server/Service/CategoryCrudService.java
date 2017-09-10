package vn.menugo.server.Service;

import vn.menugo.server.model.Category;

import java.util.UUID;

/**
 * Created by itn0309 on 7/8/2017.
 */
public interface CategoryCrudService {
    void create(Category cat);
    Category delete(UUID uuid);
    Category update(Category cat);
}
