package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZhuanjiMapper;
import com.entity.Zhuanji;
import com.server.ZhuanjiServer;
@Service
public class ZhuanjiServerImpi implements ZhuanjiServer {
   @Resource
   private ZhuanjiMapper gdao;
	@Override
	public int add(Zhuanji po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zhuanji po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zhuanji> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zhuanji> getsyzhuanji1(Map<String, Object> map) {
		return gdao.getsyzhuanji1(map);
	}
	public List<Zhuanji> getsyzhuanji2(Map<String, Object> map) {
		return gdao.getsyzhuanji2(map);
	}
	public List<Zhuanji> getsyzhuanji3(Map<String, Object> map) {
		return gdao.getsyzhuanji3(map);
	}
	
	@Override
	public Zhuanji quchongZhuanji(Map<String, Object> account) {
		return gdao.quchongZhuanji(account);
	}

	@Override
	public List<Zhuanji> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zhuanji> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zhuanji getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

