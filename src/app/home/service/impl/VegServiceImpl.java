package app.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.home.dao.VegMapper;
import app.home.model.FindCookOrder;
import app.home.model.Veg;
import app.home.service.VegService;

@Service("vegService")
public class VegServiceImpl implements VegService {
	
	private VegMapper thisMapper;

	public VegMapper getThisMapper() {
		return thisMapper;
	}
	
	@Autowired
	public void setThisMapper(VegMapper thisMapper) {
		this.thisMapper = thisMapper;
	}

	@Override
	public List<Veg> select() {
		// TODO Auto-generated method stub
		return thisMapper.selectAll();
	}

	@Override
	public int addVegInfo(Veg vegMany) {
		// TODO Auto-generated method stub
		return thisMapper.addVegInfo(vegMany);
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return thisMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Veg> selectUrl(int id) {
		// TODO Auto-generated method stub
		return thisMapper.selectUrl(id);
	}
	
	public Integer save(Veg info) {
		return thisMapper.updateByPrimaryKeySelective(info);
	}

	public Veg find(String id) {
		return thisMapper.selectByPrimaryKey(id);
	}

}
