package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Duliyinleren;

public interface DuliyinlerenServer {

  public int add(Duliyinleren po);

  public int update(Duliyinleren po);
  
  
  
  public int delete(int id);

  public List<Duliyinleren> getAll(Map<String,Object> map);
  public List<Duliyinleren> getsyduliyinleren1(Map<String,Object> map);
  public List<Duliyinleren> getsyduliyinleren2(Map<String,Object> map);
  public List<Duliyinleren> getsyduliyinleren3(Map<String,Object> map);
  public Duliyinleren quchongDuliyinleren(Map<String, Object> acount);

  public Duliyinleren getById( int id);

  public List<Duliyinleren> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Duliyinleren> select(Map<String, Object> map);
}
//	所有List
