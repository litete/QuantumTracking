package app.home.service;

import app.home.model.FewTJdShopIndex;
import app.home.model.LittleTjdShopIndex;
import app.home.model.TJdShopIndex;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */
public interface ShopIndexService {
    //查询一天的数据
    List<FewTJdShopIndex> selectFocusIndex(TJdShopIndex tJdShopIndex);
    //查询一个月的数据
    List<LittleTjdShopIndex> selectFocusIndexAddDateId(TJdShopIndex tJdShopIndex);
}
