package app.home.dao;

import java.util.List;

import app.home.model.VegOrder;

public interface VegOrderMapper {

	List<VegOrder> selectAll();

	List<VegOrder> selectNotSure();

	List<VegOrder> selectNotFinish();

	List<VegOrder> selectYesFinish();

	VegOrder selectId(String id);

	int updateZhuangtaiNSure(String id);

	int updateZhuangtaiNFinish(String id);

	int deleteByPrimaryKey(int id);

	VegOrder selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(VegOrder id);

	int addVegOrederInfo(VegOrder info);
}
