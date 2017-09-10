package vn.menugo.server.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import vn.menugo.server.Service.ProviderRepositoryService;
import vn.menugo.server.model.Category;
import vn.menugo.server.model.MenuItem;
import vn.menugo.server.model.Provider;
import vn.menugo.server.model.Wrap;
import vn.menugo.server.modelDTO.CategoryDTO;
import vn.menugo.server.modelDTO.ItemDTO;
import vn.menugo.server.modelDTO.ModelMapping;
import vn.menugo.server.modelDTO.ProviderDTO;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by itn0309 on 6/11/2017.
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderRepositoryService service;

    @RequestMapping("test")
    public ResponseEntity<String> handleRequest (RequestEntity<String> requestEntity) {
        System.out.println("request body : " + requestEntity.getBody());
        HttpHeaders headers = requestEntity.getHeaders();
        System.out.println("request headers : " + headers);
        HttpMethod method = requestEntity.getMethod();
        System.out.println("request method : " + method);
        System.out.println("request url: " + requestEntity.getUrl());

        ResponseEntity<String> responseEntity = new ResponseEntity<>("my response body",
                HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value="", method = RequestMethod.POST,produces = {"application/json", "text/json"})
    public ResponseEntity<String> createProvider (
            @RequestBody Provider provider
    ) {

        Provider p = new Provider(UUID.randomUUID(), provider.getName(),provider.getImage(),provider.getDescription(),  provider.getAddress(),  provider.getUrl(), provider.getLatitude(), provider.getLongitude() , provider.getOpenHour(),  provider.getStar());
        service.create(p);
        return new ResponseEntity<String>(String.format("Create provider %s successfully",provider.getName()), HttpStatus.CREATED);
    }

    @RequestMapping(value="list",  produces = {"application/json", "text/json"},method = RequestMethod.GET)
    public ResponseEntity<Wrap> getProviders () {

        List<Provider> list = service.findAll();
        List<ProviderDTO> pdto = ModelMapping.convertToListDTO(list, ProviderDTO.class);
        Wrap w = new Wrap< List<ProviderDTO>>(pdto);
        return new ResponseEntity<Wrap>(w, HttpStatus.OK);
    }

    @RequestMapping(value= "{uuid}/menu",  produces = {"application/json", "text/json"}, method = RequestMethod.GET)
    public ResponseEntity<Wrap> getMenu(@PathVariable("uuid") UUID uuid ) {

        Provider provider = service.findByUuid(uuid);

        List<MenuItem> menu =provider.getMenu();
        List<ItemDTO> menuDTO = ModelMapping.convertToListDTO(menu, ItemDTO.class);

        Wrap w = new Wrap< List<ItemDTO>>(menuDTO);

        return new ResponseEntity<Wrap>(w,HttpStatus.OK);
    }

    @RequestMapping(value= "{uuid}/category",  produces = {"application/json", "text/json"}, method = RequestMethod.GET)
    public ResponseEntity<Wrap> getCategory(@PathVariable("uuid") UUID uuid ) {

        Provider p = service.findByUuid(uuid);

        List<Category> listCat =p.getCat();
        List<CategoryDTO>  listCatDTO = ModelMapping.convertToListDTO(listCat, CategoryDTO.class);

        Wrap w = new Wrap< List<CategoryDTO>>(listCatDTO);

        return new ResponseEntity<Wrap>(w,HttpStatus.OK);
    }

    @RequestMapping(value= "{uuid}",  produces = {"application/json", "text/json"}, method = RequestMethod.GET)
    public ResponseEntity<ProviderDTO> getProvider(@PathVariable("uuid") UUID uuid ) {

        Provider p = service.findByUuid(uuid);
        ProviderDTO pdto = ModelMapping.convertToDTO(p,ProviderDTO.class);

        return new ResponseEntity<ProviderDTO>(pdto,HttpStatus.OK);
    }
}
