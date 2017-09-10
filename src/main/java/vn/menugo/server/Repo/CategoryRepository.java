package vn.menugo.server.Repo;

import org.springframework.data.repository.Repository;
import vn.menugo.server.model.Category;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 7/8/2017.
 */
public interface CategoryRepository extends Repository<Category, UUID> {
    Category findByUuid(UUID uuid);
    List<Category> findAll();
    Category save(Category name);
}
