package app.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.home.dao.CookMapper;
import app.home.model.Cook;
import app.home.service.CookService;

@Service("cookService")
public class CookServiceImpl implements CookService {

	private CookMapper thisMapper;

	public CookMapper getThisMapper() {
		return thisMapper;
	}

	@Autowired
	public void setThisMapper(CookMapper thisMapper) {
		this.thisMapper = thisMapper;
	}

	@Override
	public List<Cook> select() {
		// TODO Auto-generated method stub
		return thisMapper.selectAll();
	}

	@Override
	public int addCookInfo(Cook cookMany) {
		// TODO Auto-generated method stub
		return thisMapper.addCookInfo(cookMany);
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return thisMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Cook> selectUrl(int id) {
		// TODO Auto-generated method stub
		return thisMapper.selectUrl(id);
	}

	public Integer save(Cook info) {
		return thisMapper.updateByPrimaryKeySelective(info);
	}

	public Cook find(String id) {
		return thisMapper.selectByPrimaryKey(id);
	}
}
