package app.home.dao;

import java.util.List;

import app.home.model.FindCookOrder;
import app.home.model.User;

public interface FindCookOrderMapper {

	List<FindCookOrder> selectAll();

	List<FindCookOrder> selectNotSure();

	List<FindCookOrder> selectNotFinish();

	List<FindCookOrder> selectYesFinish();

	FindCookOrder selectId(String id);

	int updateZhuangtaiNSure(String id);

	int updateZhuangtaiNFinish(String id);

	int deleteByPrimaryKey(int id);

	FindCookOrder selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(FindCookOrder id);

	int addCookOrederInfo(FindCookOrder info);
}
