package app.home.service;

import app.home.model.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */
public interface ShopIndexService {
    //查询一天的数据
    List<BrandIndex> selectFocusIndex(AcceptJson acceptJson);
    //查询一个月的数据
    List<LittleTjdShopIndex> selectFocusIndexAddDateId(AcceptJsonSelect acceptJsonSelect);
}
