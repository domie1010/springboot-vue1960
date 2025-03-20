package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YinlexinxiMapper;
import com.entity.Yinlexinxi;
import com.server.YinlexinxiServer;
@Service
public class YinlexinxiServerImpi implements YinlexinxiServer {
   @Resource
   private YinlexinxiMapper gdao;
	@Override
	public int add(Yinlexinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yinlexinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yinlexinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yinlexinxi> getsyyinlexinxi1(Map<String, Object> map) {
		return gdao.getsyyinlexinxi1(map);
	}
	public List<Yinlexinxi> getsyyinlexinxi2(Map<String, Object> map) {
		return gdao.getsyyinlexinxi2(map);
	}
	public List<Yinlexinxi> getsyyinlexinxi3(Map<String, Object> map) {
		return gdao.getsyyinlexinxi3(map);
	}
	
	@Override
	public Yinlexinxi quchongYinlexinxi(Map<String, Object> account) {
		return gdao.quchongYinlexinxi(account);
	}

	@Override
	public List<Yinlexinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yinlexinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yinlexinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

