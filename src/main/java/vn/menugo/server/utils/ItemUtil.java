package vn.menugo.server.utils;

import org.springframework.beans.factory.annotation.Autowired;
import vn.menugo.server.Service.MenuItemRepositoryService;
import vn.menugo.server.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itn0309 on 9/9/2017.
 */
public class ItemUtil {

    @Autowired
    private static MenuItemRepositoryService mService;

    public static long countPrice (List<MenuItem> items){
        long result= 0;
        if(items != null){
            for (MenuItem item: items){
                result += item.getPrice();
            }
        }
        return result;

    }

}
