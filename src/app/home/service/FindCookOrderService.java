package app.home.service;

import java.util.List;

import app.home.model.FindCookOrder;
import app.home.model.User;
import app.home.model.Veg;

public interface FindCookOrderService {

	List<FindCookOrder> select();

	List<FindCookOrder> selectNotSure();

	List<FindCookOrder> selectNotFinish();

	List<FindCookOrder> selectYesFinish();

	FindCookOrder selectId(String id);

	Integer updateZhuangtaiNSure(String id);

	Integer updateZhuangtaiNFinish(String id);

	int remove(int id);

	FindCookOrder find(String id);
	
	Integer save(FindCookOrder info);
	
	int addCookOrederInfo(FindCookOrder info);
}
