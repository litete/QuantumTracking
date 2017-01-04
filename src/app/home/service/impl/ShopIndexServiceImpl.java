package app.home.service.impl;

import app.home.dao.ShopIndexMapper;
import app.home.model.*;
import app.home.service.ShopIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<BrandIndex> selectFocusIndex(AcceptJson acceptJson) {
        return thisMapper.selectFocusIndex(acceptJson);
    }

    @Override
    public List<LittleTjdShopIndex> selectFocusIndexAddDateId(AcceptJsonSelect acceptJsonSelect) {
        return thisMapper.selectFocusIndexAddDateId(acceptJsonSelect);
    }


}
