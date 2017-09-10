package vn.menugo.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.menugo.server.Exception.FailedCreatingEx;
import vn.menugo.server.Service.CategoryRepositoryService;
import vn.menugo.server.Service.ProviderRepositoryService;
import vn.menugo.server.model.*;
import vn.menugo.server.modelDTO.CategoryDTO;
import vn.menugo.server.modelDTO.ItemDTO;
import vn.menugo.server.modelDTO.ModelMapping;


import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 7/8/2017.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryRepositoryService service;

    @Autowired
    private ProviderRepositoryService pservice;

    @RequestMapping(value="",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> createCategory (
            @RequestBody Category category
    ) {

        Category c = new Category(UUID.randomUUID(),category.getName(),category.getDefaultImage());
        Provider provider = pservice.findByUuid(category.getProvider().getUuid());

        c.setProvider(provider);

        try {
            service.create(c);
        }catch (Exception e) {
            logger.error("Create category failed", e);
            throw new FailedCreatingEx("Create category failed");
        }

        provider.getCat().add(c);
        pservice.update(provider);

        logger.info("Create category successfully");
        return new ResponseEntity<String>(String.format("Create provider %s successfully",c.getName()), HttpStatus.CREATED);
    }

    @RequestMapping(value="list",  produces = {"application/json", "text/json"},method = RequestMethod.GET)
    public ResponseEntity<Wrap> getCategories () {

        List<Category> list = service.findAll();
        List<CategoryDTO> cdto = ModelMapping.convertToListDTO(list, CategoryDTO.class);

        Wrap w= new Wrap<List<CategoryDTO>>(cdto);
        return new ResponseEntity<Wrap>(w, HttpStatus.OK);
    }

    @RequestMapping(value= "{uuid}/menu",  produces = {"application/json", "text/json"}, method = RequestMethod.GET)
    public ResponseEntity<Wrap> getMenu(@PathVariable("uuid") UUID uuid ) {

        Category cat = service.findByUuid(uuid);

        List<MenuItem> menu =cat.getMenu();
        List<ItemDTO> menuDTO = ModelMapping.convertToListDTO(menu,ItemDTO.class);

        Wrap w= new Wrap< List<ItemDTO>>(menuDTO);

        return new ResponseEntity<Wrap>(w,HttpStatus.OK);
    }

    @RequestMapping(value= "{uuid}",  produces = {"application/json", "text/json"}, method = RequestMethod.GET)
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("uuid") UUID uuid ) {

        Category c = service.findByUuid(uuid);
        CategoryDTO cdto = ModelMapping.convertToDTO(c, CategoryDTO.class);

        return new ResponseEntity<CategoryDTO>(cdto,HttpStatus.OK);
    }
}
