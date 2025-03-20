package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yinlexinxi;

public interface YinlexinxiServer {

  public int add(Yinlexinxi po);

  public int update(Yinlexinxi po);
  
  
  
  public int delete(int id);

  public List<Yinlexinxi> getAll(Map<String,Object> map);
  public List<Yinlexinxi> getsyyinlexinxi1(Map<String,Object> map);
  public List<Yinlexinxi> getsyyinlexinxi2(Map<String,Object> map);
  public List<Yinlexinxi> getsyyinlexinxi3(Map<String,Object> map);
  public Yinlexinxi quchongYinlexinxi(Map<String, Object> acount);

  public Yinlexinxi getById( int id);

  public List<Yinlexinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yinlexinxi> select(Map<String, Object> map);
}
//	所有List
