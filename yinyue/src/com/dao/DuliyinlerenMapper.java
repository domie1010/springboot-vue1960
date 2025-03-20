package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Duliyinleren;

public interface DuliyinlerenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Duliyinleren record);

    int insertSelective(Duliyinleren record);

    Duliyinleren selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Duliyinleren record);
	
    int updateByPrimaryKey(Duliyinleren record);
	public Duliyinleren quchongDuliyinleren(Map<String, Object> yonghuming);
	public List<Duliyinleren> getAll(Map<String, Object> map);
	public List<Duliyinleren> getsyduliyinleren1(Map<String, Object> map);
	public List<Duliyinleren> getsyduliyinleren3(Map<String, Object> map);
	public List<Duliyinleren> getsyduliyinleren2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Duliyinleren> getByPage(Map<String, Object> map);
	public List<Duliyinleren> select(Map<String, Object> map);
//	所有List
}

