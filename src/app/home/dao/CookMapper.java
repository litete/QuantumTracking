package app.home.dao;

import java.util.List;

import app.home.model.Cook;

public interface CookMapper {

	List<Cook> selectAll();

	int addCookInfo(Cook cookMany);

	int deleteByPrimaryKey(int id);

	List<Cook> selectUrl(int id);
	
	Cook selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Cook id);
}
