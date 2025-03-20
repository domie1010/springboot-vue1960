package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZhanneixinMapper;
import com.entity.Zhanneixin;
import com.server.ZhanneixinServer;
@Service
public class ZhanneixinServerImpi implements ZhanneixinServer {
   @Resource
   private ZhanneixinMapper gdao;
	@Override
	public int add(Zhanneixin po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zhanneixin po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zhanneixin> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zhanneixin> getsyzhanneixin1(Map<String, Object> map) {
		return gdao.getsyzhanneixin1(map);
	}
	public List<Zhanneixin> getsyzhanneixin2(Map<String, Object> map) {
		return gdao.getsyzhanneixin2(map);
	}
	public List<Zhanneixin> getsyzhanneixin3(Map<String, Object> map) {
		return gdao.getsyzhanneixin3(map);
	}
	
	@Override
	public Zhanneixin quchongZhanneixin(Map<String, Object> account) {
		return gdao.quchongZhanneixin(account);
	}

	@Override
	public List<Zhanneixin> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zhanneixin> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zhanneixin getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

