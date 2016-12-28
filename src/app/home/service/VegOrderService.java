package app.home.service;

import java.util.List;

import app.home.model.FindCookOrder;
import app.home.model.VegOrder;

public interface VegOrderService {
	List<VegOrder> select();

	List<VegOrder> selectNotSure();

	List<VegOrder> selectNotFinish();

	List<VegOrder> selectYesFinish();

	VegOrder selectId(String id);

	Integer updateZhuangtaiNSure(String id);

	Integer updateZhuangtaiNFinish(String id);

	int remove(int id);
	
	VegOrder find(String id);

	Integer save(VegOrder info);
	
	int addVegOrederInfo(VegOrder info);
}
