package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yinlexinxi;

public interface YinlexinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yinlexinxi record);

    int insertSelective(Yinlexinxi record);

    Yinlexinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yinlexinxi record);
	
    int updateByPrimaryKey(Yinlexinxi record);
	public Yinlexinxi quchongYinlexinxi(Map<String, Object> zuozhe);
	public List<Yinlexinxi> getAll(Map<String, Object> map);
	public List<Yinlexinxi> getsyyinlexinxi1(Map<String, Object> map);
	public List<Yinlexinxi> getsyyinlexinxi3(Map<String, Object> map);
	public List<Yinlexinxi> getsyyinlexinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yinlexinxi> getByPage(Map<String, Object> map);
	public List<Yinlexinxi> select(Map<String, Object> map);
//	所有List
}

