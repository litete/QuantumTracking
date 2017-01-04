package app.home.dao;


import app.home.model.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */

public interface ShopIndexMapper {
    List<BrandIndex> selectFocusIndex(AcceptJson acceptJson);
    List<LittleTjdShopIndex> selectFocusIndexAddDateId(AcceptJsonSelect acceptJsonSelect);

}
