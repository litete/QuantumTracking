package app.home.dao;

import java.util.List;

import app.home.model.FindCookOrder;
import app.home.model.Veg;

public interface VegMapper {

	List<Veg> selectAll();

	int addVegInfo(Veg vegMany);

	int deleteByPrimaryKey(int id);

	List<Veg> selectUrl(int id);
	
	Veg selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Veg id);
}
