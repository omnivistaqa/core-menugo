package vn.menugo.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.menugo.server.Exception.FailedCreatingEx;
import vn.menugo.server.Service.BillRepositoryService;
import vn.menugo.server.Service.MenuItemRepositoryService;
import vn.menugo.server.Service.UserRepositoryService;
import vn.menugo.server.model.*;
import vn.menugo.server.modelDTO.BillDTO;
import vn.menugo.server.modelDTO.BillMenuItemDTO;
import vn.menugo.server.modelDTO.ModelMapping;
import vn.menugo.server.modelRO.BillMenuItemRO;
import vn.menugo.server.modelRO.BillRO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 8/2/2017.
 */
@RestController
@RequestMapping("/bill")
public class BillController {

    private static final Logger logger = LoggerFactory.getLogger(BillController.class);
    private static final int OPENING = 0;
    private static final int CLOSED = 1;
    @Autowired
    private BillRepositoryService bService;

    @Autowired
    private UserRepositoryService uService;

    @Autowired
    private MenuItemRepositoryService mService;

    @RequestMapping(value="",method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseEntity<String> createBill(
            @RequestBody BillRO billRO
    ) {

        String result;
        Bill b = new Bill(UUID.randomUUID(),billRO.getType());
        User user = uService.findByUuid(billRO.getUser());



        b.setUser(user);
        b.setStatus(OPENING);
        b.setDate(new Date());

        for ( BillMenuItemRO receivedBMI : billRO.getItems()) {
            BillMenuItem bmi = new BillMenuItem();
            bmi.setBill(b);

            //need to handle when getUuid return NULL
            bmi.setMenuItem(mService.findByUuid( receivedBMI.getUuid() ));
            bmi.setNumber(receivedBMI.getNumber());
            bmi.setNote(receivedBMI.getNote());
            b.getBillMenuItem().add(bmi);
        }

        //Count price for all items of the bill
        //List<MenuItem> fullList = mService.findFullObjects(bill.getListItem());
        //long price = ItemUtil.countPrice(fullList);
        //b.setPrice(price);

        try {
            bService.create(b);
        }catch (Exception e) {
            result = "Create bill failed";
            logger.error(result, e);
            throw new FailedCreatingEx(result);
        }

        user.getBills().add(b);
        uService.update(user);

        result= String.format("Create bill %s for %s successfully",b.getType(),user.getName());
        logger.info(result);
        return new ResponseEntity<String>(result, HttpStatus.CREATED);
    }

    //View info Basic of a bill
    @RequestMapping(value="{uuid}",  produces = {"application/json", "text/json"},method = RequestMethod.GET)
    public ResponseEntity<Wrap> getBill (@PathVariable("uuid") UUID uuid ) {

        Bill bill = bService.findByUuid(uuid);
        BillDTO billDTO = ModelMapping.convertToDTO(bill, BillDTO.class);
        Wrap w = new Wrap<BillDTO>(billDTO);
        return new ResponseEntity<Wrap>(w, HttpStatus.OK);
    }

     //View list menuItem of a bill
    @RequestMapping(value= "{uuid}/menu",  produces = {"application/json", "text/json"}, method = RequestMethod.GET)
    public ResponseEntity<Wrap> getMenu(@PathVariable("uuid") UUID uuid ) {

        Bill bill = bService.findByUuid(uuid);
        List<BillMenuItem> bmiList =bill.getBillMenuItem();
        List<BillMenuItemRO> bmiROList = new ArrayList<>();
        for(BillMenuItem bmi:bmiList){
            BillMenuItemRO bmiRO = new BillMenuItemRO();
            bmiRO.setUuid(bmi.getMenuItem().getUuid());
            bmiRO.setNumber(bmi.getNumber());
            bmiRO.setNote(bmi.getNote());
            bmiROList.add(bmiRO);
        }


        Wrap w= new Wrap< List<BillMenuItemRO>>(bmiROList);

        return new ResponseEntity<Wrap>(w,HttpStatus.OK);
    }

    @RequestMapping(value="status",  produces = {"application/json", "text/json"},method = RequestMethod.POST)
    public ResponseEntity<String> updateBillStatus (@RequestBody Bill specBill) {

        String result;
        Bill bill = bService.findByUuid(specBill.getUuid());
        if(bill !=null){
            bill.setStatus(specBill.getStatus());
            try{
                bService.update(bill);
                result = String.format("update status for bill %s successfully",specBill.getUuid());
                logger.info(result);
            }catch (Exception e){
                result =  String.format("update status for bill %s failed",specBill.getUuid());
                logger.error(result, e);
                throw new FailedCreatingEx(result);
            }
        } else {
            result =  String.format("Cannot find the bill %s ",specBill.getUuid());
            logger.error("result");
        }
        return new ResponseEntity<String>(result, HttpStatus.CREATED);
    }
}


