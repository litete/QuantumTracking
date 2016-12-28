package app.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.home.dao.FindCookOrderMapper;
import app.home.model.FindCookOrder;
import app.home.model.User;
import app.home.service.FindCookOrderService;

@Service("findCookOrderService")
public class FindCookOrderServiceImpl implements FindCookOrderService {
	
	private FindCookOrderMapper thisMapper;

	public FindCookOrderMapper getThisMapper() {
		return thisMapper;
	}

	@Autowired
	public void setThisMapper(FindCookOrderMapper thisMapper) {
		this.thisMapper = thisMapper;
	}


	public List<FindCookOrder> select() {
		return thisMapper.selectAll();
	}

	@Override
	public List<FindCookOrder> selectNotSure() {
		// TODO Auto-generated method stub
		return thisMapper.selectNotSure();
	}

	@Override
	public List<FindCookOrder> selectNotFinish() {
		// TODO Auto-generated method stub
		return thisMapper.selectNotFinish();
	}

	@Override
	public List<FindCookOrder> selectYesFinish() {
		// TODO Auto-generated method stub
		return thisMapper.selectYesFinish();
	}

	@Override
	public FindCookOrder selectId(String id) {
		// TODO Auto-generated method stub
		return thisMapper.selectId(id);
	}

	@Override
	public Integer updateZhuangtaiNSure(String id) {
		// TODO Auto-generated method stub
		return thisMapper.updateZhuangtaiNSure(id);
	}

	@Override
	public Integer updateZhuangtaiNFinish(String id) {
		// TODO Auto-generated method stub
		return thisMapper.updateZhuangtaiNFinish(id);
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return thisMapper.deleteByPrimaryKey(id);
	}
	
	public Integer save(FindCookOrder info) {
		return thisMapper.updateByPrimaryKeySelective(info);
	}

	public FindCookOrder find(String id) {
		return thisMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addCookOrederInfo(FindCookOrder info) {
		// TODO Auto-generated method stub
		return thisMapper.addCookOrederInfo(info);
	}

}
