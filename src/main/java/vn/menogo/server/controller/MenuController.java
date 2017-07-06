package vn.menogo.server.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.menogo.server.Service.MenuRepositoryService;
import vn.menogo.server.Service.ProviderRepositoryService;
import vn.menogo.server.model.Menu;
import vn.menogo.server.model.Provider;
import vn.menogo.server.model.Wrap;
import vn.menogo.server.utils.JSONConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by itn0309 on 6/13/2017.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepositoryService mService;

    @Autowired
    private ProviderRepositoryService pService;

    @RequestMapping(value="",  produces = {"application/json", "text/json"},method = RequestMethod.GET)
    public ResponseEntity<String> createMenu (
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "price", required = true) Long price,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "note", required = true) String note,
            @RequestParam(value = "providerName", required = true) String providerName

    ) {

        Menu menu = new Menu(UUID.randomUUID(),name,price,description,note);
        List<Provider> providers = pService.findByName(providerName);
        menu.setProvider(providers.get(0));
        mService.create(menu);
        return new ResponseEntity<String>(String.format("Create menu %s successfully",name), HttpStatus.CREATED);
    }


    @RequestMapping(value= "provider/{name}",  produces = {"application/json", "text/json"}, method = RequestMethod.GET)
    public ResponseEntity<Wrap> getMenuByProvider (@PathVariable("name") String providerName ) {

        List<Provider> providers = pService.findByName(providerName);

        List<Menu> menus =mService.findByProvider(providers.get(0));

        Wrap result = new Wrap (menus);

        return new ResponseEntity<Wrap>(result,HttpStatus.OK);
    }
}


