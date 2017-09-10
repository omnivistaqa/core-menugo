package vn.menugo.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.menugo.server.Service.UserRepositoryService;
import vn.menugo.server.model.Bill;
import vn.menugo.server.model.Provider;
import vn.menugo.server.model.User;
import vn.menugo.server.model.Wrap;
import vn.menugo.server.modelDTO.BillDTO;
import vn.menugo.server.modelDTO.ModelMapping;
import vn.menugo.server.modelDTO.ProviderDTO;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 8/20/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepositoryService uService;

    @RequestMapping(value="list",  produces = {"application/json", "text/json"},method = RequestMethod.GET)
    public ResponseEntity< List<User>> getUsers () {

        List<User> list = uService.findAll();
        //List<ProviderDTO> pdto = ModelMapping.convertToListDTO(list, ProviderDTO.class);
        //Wrap w = new Wrap< List<ProviderDTO>>(pdto);
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="", method = RequestMethod.POST,produces = {"application/json", "text/json"})
    public ResponseEntity<String> createUser (
            @RequestBody User user
    ) {

        User u = new User(UUID.randomUUID(), user.getName(),user.getPass(),user.getEmail(),user.getAddress());
        uService.create(u);
        return new ResponseEntity<String>(String.format("Create user %s successfully",user.getName()), HttpStatus.CREATED);
    }

    //View bill by user
    @RequestMapping(value="{uuid}/bill",  produces = {"application/json", "text/json"},method = RequestMethod.GET)
    public ResponseEntity<Wrap> getBills (@PathVariable("uuid") UUID uuid ) {

        User user = uService.findByUuid(uuid);

        List<Bill> bills = user.getBills();

        List<BillDTO> billDTO = ModelMapping.convertToListDTO(bills, BillDTO.class);
        Wrap w = new Wrap<List<BillDTO>>(billDTO);
        return new ResponseEntity<Wrap>(w, HttpStatus.OK);
    }

}
