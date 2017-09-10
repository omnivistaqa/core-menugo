package vn.menugo.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.menugo.server.Exception.FailedCreatingEx;
import vn.menugo.server.Service.CategoryRepositoryService;
import vn.menugo.server.Service.MenuItemRepositoryService;
import vn.menugo.server.Service.ProviderRepositoryService;
import vn.menugo.server.model.Category;
import vn.menugo.server.model.MenuItem;
import vn.menugo.server.model.Provider;
import vn.menugo.server.model.Wrap;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by itn0309 on 6/13/2017.
 */
@RestController
@RequestMapping("/item")
public class MenuItemController {

    private static final Logger logger = LoggerFactory.getLogger(MenuItemController.class);

    @Autowired
    private MenuItemRepositoryService mService;

    @Autowired
    private ProviderRepositoryService pService;

    @Autowired
    private CategoryRepositoryService cService;

    @RequestMapping(value="",  method = RequestMethod.POST,produces = {"application/json", "text/json"})
    public ResponseEntity<String> createMenuItem (
            @RequestBody MenuItem menuItem

    ) {

        MenuItem item = new MenuItem(UUID.randomUUID(),menuItem.getName(),menuItem.getPrice(),menuItem.getDescription(),menuItem.getNote());

        Provider provider = pService.findByUuid(menuItem.getProvider().getUuid());
        Category category = cService.findByUuid(menuItem.getCategory().getUuid());
        item.setProvider(provider);
        item.setCategory(category);
        try {
            mService.create(item);
        }catch (Exception e) {
            logger.error("Create item failed", e);
            throw new FailedCreatingEx("Create item failed");
        }
        provider.getMenu().add(item);
        category.getMenu().add(item);

        pService.update(provider);
        cService.update(category);

        logger.info("Create item successfully");
        return new ResponseEntity<String>(String.format("Create menu %s successfully",menuItem.getName()), HttpStatus.CREATED);
    }

    @RequestMapping(value= "{uuid}",  produces = {"application/json", "text/json"}, method = RequestMethod.GET)
    public ResponseEntity<MenuItem> getItem(@PathVariable("uuid") UUID uuid ) {

        MenuItem item = mService.findByUuid(uuid);

        return new ResponseEntity<MenuItem>(item,HttpStatus.OK);
    }
}


