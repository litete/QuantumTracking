package app.home.service;

import java.util.List;

import app.home.model.Cook;

public interface CookService {
	
	List<Cook> select();

	int addCookInfo(Cook CookMany);

	int remove(int id);

	List<Cook> selectUrl(int id);
	
	Cook find(String id);

	Integer save(Cook info);
}
