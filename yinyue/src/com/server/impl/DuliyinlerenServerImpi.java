package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DuliyinlerenMapper;
import com.entity.Duliyinleren;
import com.server.DuliyinlerenServer;
@Service
public class DuliyinlerenServerImpi implements DuliyinlerenServer {
   @Resource
   private DuliyinlerenMapper gdao;
	@Override
	public int add(Duliyinleren po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Duliyinleren po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Duliyinleren> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Duliyinleren> getsyduliyinleren1(Map<String, Object> map) {
		return gdao.getsyduliyinleren1(map);
	}
	public List<Duliyinleren> getsyduliyinleren2(Map<String, Object> map) {
		return gdao.getsyduliyinleren2(map);
	}
	public List<Duliyinleren> getsyduliyinleren3(Map<String, Object> map) {
		return gdao.getsyduliyinleren3(map);
	}
	
	@Override
	public Duliyinleren quchongDuliyinleren(Map<String, Object> account) {
		return gdao.quchongDuliyinleren(account);
	}

	@Override
	public List<Duliyinleren> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Duliyinleren> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Duliyinleren getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

