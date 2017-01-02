package app.home.dao;


import app.home.model.FewTJdShopIndex;
import app.home.model.LittleTjdShopIndex;
import app.home.model.TJdShopIndex;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */

public interface ShopIndexMapper {
    List<FewTJdShopIndex> selectFocusIndex(TJdShopIndex tJdShopIndex);
    List<LittleTjdShopIndex> selectFocusIndexAddDateId();

}
