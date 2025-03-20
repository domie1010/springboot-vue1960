package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zhanneixin;

public interface ZhanneixinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhanneixin record);

    int insertSelective(Zhanneixin record);

    Zhanneixin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhanneixin record);
	
    int updateByPrimaryKey(Zhanneixin record);
	public Zhanneixin quchongZhanneixin(Map<String, Object> fasongren);
	public List<Zhanneixin> getAll(Map<String, Object> map);
	public List<Zhanneixin> getsyzhanneixin1(Map<String, Object> map);
	public List<Zhanneixin> getsyzhanneixin3(Map<String, Object> map);
	public List<Zhanneixin> getsyzhanneixin2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zhanneixin> getByPage(Map<String, Object> map);
	public List<Zhanneixin> select(Map<String, Object> map);
//	所有List
}

