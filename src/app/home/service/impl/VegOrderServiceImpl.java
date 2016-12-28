package app.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.home.dao.VegOrderMapper;
import app.home.model.VegOrder;
import app.home.service.VegOrderService;

@Service("vegOrderService")
public class VegOrderServiceImpl implements VegOrderService {
	
	private VegOrderMapper thisMapper;

	public VegOrderMapper getThisMapper() {
		return thisMapper;
	}
	
	@Autowired
	public void setThisMapper(VegOrderMapper thisMapper) {
		this.thisMapper = thisMapper;
	}

	@Override
	public List<VegOrder> select() {
		// TODO Auto-generated method stub
		return thisMapper.selectAll();
	}
	
	@Override
	public List<VegOrder> selectNotSure() {
		// TODO Auto-generated method stub
		return thisMapper.selectNotSure();
	}

	@Override
	public List<VegOrder> selectNotFinish() {
		// TODO Auto-generated method stub
		return thisMapper.selectNotFinish();
	}

	@Override
	public List<VegOrder> selectYesFinish() {
		// TODO Auto-generated method stub
		return thisMapper.selectYesFinish();
	}
	
	@Override
	public VegOrder selectId(String id) {
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
	
	public Integer save(VegOrder info) {
		//info.setUtime(System.currentTimeMillis());
		return thisMapper.updateByPrimaryKeySelective(info);
	}

	public VegOrder find(String id) {
		return thisMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addVegOrederInfo(VegOrder info) {
		// TODO Auto-generated method stub
		return thisMapper.addVegOrederInfo(info);
	}

}
