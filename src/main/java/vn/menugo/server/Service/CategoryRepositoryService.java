package vn.menugo.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.Repo.CategoryRepository;
import vn.menugo.server.model.Category;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 7/8/2017.
 */
@Service
public class CategoryRepositoryService implements CategoryCrudService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryRepositoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void create(Category cat) {
        Category c = categoryRepository.save(cat);
    }

    @Override
    public Category delete(UUID uuid) {
        return null;
    }

    @Override
    public Category update(Category cat) {
        return categoryRepository.save(cat);
    }

    public Category findByUuid(UUID uuid) {
        return categoryRepository.findByUuid(uuid);
    }

    public List<Category> findAll(){return categoryRepository.findAll();}
}
