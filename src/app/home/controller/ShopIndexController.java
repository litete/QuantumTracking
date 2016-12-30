package app.home.controller;

import app.home.model.FewTJdShopIndex;
import app.home.model.LittleTjdShopIndex;
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
    public  void selectIndexByCondition(String data){
        System.out.println("data:"+data);
        TJdShopIndex tJdShopIndex=new TJdShopIndex();
        ObjectMapper obj=new ObjectMapper();
        try {
            tJdShopIndex=obj.readValue(data,TJdShopIndex.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("tJdShopIndex"+tJdShopIndex);
        List<FewTJdShopIndex> fewTJdShopIndexBar = thisService.selectFocusIndex( tJdShopIndex);
        List<LittleTjdShopIndex> littleTjdShopIndexeLine=thisService.selectFocusIndexAddDateId(tJdShopIndex);


    }
}
