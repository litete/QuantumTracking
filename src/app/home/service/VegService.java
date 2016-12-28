package app.home.service;

import java.util.List;

import app.home.model.FindCookOrder;
import app.home.model.Veg;

public interface VegService {

	List<Veg> select();

	int addVegInfo(Veg vegMany);

	int remove(int id);

	List<Veg> selectUrl(int id);
	
	Veg find(String id);

	Integer save(Veg info);
}
