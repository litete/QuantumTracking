package app.home.service.impl;

import app.home.dao.ShopIndexMapper;
import app.home.model.FewTJdShopIndex;
import app.home.model.LittleTjdShopIndex;
import app.home.model.TJdShopIndex;
import app.home.service.ShopIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */
@Service("shopIndexService")
public class ShopIndexServiceImpl implements ShopIndexService{
    private ShopIndexMapper thisMapper;

    public ShopIndexMapper getThisMapper() {
        return thisMapper;
    }
    @Autowired
    public void setThisMapper(ShopIndexMapper thisMapper) {
        this.thisMapper = thisMapper;
    }

    @Override
    public List<FewTJdShopIndex> selectFocusIndex(TJdShopIndex tJdShopIndex) {
        return thisMapper.selectFocusIndex(tJdShopIndex);
    }

    @Override
    public List<LittleTjdShopIndex> selectFocusIndexAddDateId(TJdShopIndex tJdShopIndex) {
        return thisMapper.selectFocusIndexAddDateId();
    }


}
