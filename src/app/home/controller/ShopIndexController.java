package app.home.controller;

import app.home.model.FewTJdShopIndex;
import app.home.model.TJdShopIndex;
import app.home.model.TJdShopIndex1;
import app.home.service.ShopIndexService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */
@Controller
@RequestMapping("/shopIndex")
public class ShopIndexController extends BaseController {
private ShopIndexService thisService;

    public ShopIndexService getThisService() {
        return thisService;
    }
   @Autowired
    public void setThisService(ShopIndexService thisService) {
        this.thisService = thisService;
    }

    @RequestMapping("/selectIndex")
    @ResponseBody
    public  void selectIndexByCondition(String selectIndexJson){
        TJdShopIndex tJdShopIndex=new TJdShopIndex();
        TJdShopIndex1 tJdShopIndex1=new TJdShopIndex1();
        ObjectMapper obj=new ObjectMapper();
        try {
            tJdShopIndex=obj.readValue(selectIndexJson,TJdShopIndex.class);
            tJdShopIndex1=obj.readValue(selectIndexJson,TJdShopIndex1.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<FewTJdShopIndex> fewTJdShopIndex = thisService.selectFocusIndex();
        String fewTJdShopIndexJson = null;
        HashMap<String,List> hashMap=new HashMap<String, List>();
        try {
            fewTJdShopIndexJson =obj.writeValueAsString(hashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fewTJdShopIndexJson);
    }
}
