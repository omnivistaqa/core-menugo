package vn.menogo.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import vn.menogo.server.Service.ProviderRepositoryService;
import vn.menogo.server.model.Provider;

import java.util.List;
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

    @RequestMapping(value="", produces = {"application/json", "text/json"},method = RequestMethod.GET)
    public ResponseEntity<String> createProvider (
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "image", required = true) String image,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "address", required = true) String address,
            @RequestParam(value = "url", required = true) String url,
            @RequestParam(value = "gps", required = true) String gps,
            @RequestParam(value = "openHour", required = true) String openHour,
            @RequestParam(value = "star", required = true) String star
    ) {

        Provider p = new Provider(UUID.randomUUID(),name,image,description,  address,  url,  gps,  openHour,  star);
        service.create(p);
        return new ResponseEntity<String>(String.format("Create provider %s successfully",name), HttpStatus.CREATED);
    }

    @RequestMapping(value="list",  produces = {"application/json", "text/json"},method = RequestMethod.GET)
    public ResponseEntity<List<Provider>> getProviders () {

        List<Provider> list = service.findAll();
        return new ResponseEntity<List<Provider>>(list, HttpStatus.OK);
    }
}
