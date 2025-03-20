package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zhuanji;

public interface ZhuanjiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhuanji record);

    int insertSelective(Zhuanji record);

    Zhuanji selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhuanji record);
	
    int updateByPrimaryKey(Zhuanji record);
	public Zhuanji quchongZhuanji(Map<String, Object> zuozhe);
	public List<Zhuanji> getAll(Map<String, Object> map);
	public List<Zhuanji> getsyzhuanji1(Map<String, Object> map);
	public List<Zhuanji> getsyzhuanji3(Map<String, Object> map);
	public List<Zhuanji> getsyzhuanji2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zhuanji> getByPage(Map<String, Object> map);
	public List<Zhuanji> select(Map<String, Object> map);
//	所有List
}

