package vn.menogo.server.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Created by itn0309 on 6/28/2017.
 */
public class JSONConverter {
    public static JSONObject buidlItemObject(List list){

        JSONObject obj = new JSONObject();
        String sList = JSONArray.toJSONString(list);
        obj.put("items", sList);
        return obj;
    }
}
