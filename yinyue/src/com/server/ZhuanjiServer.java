package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zhuanji;

public interface ZhuanjiServer {

  public int add(Zhuanji po);

  public int update(Zhuanji po);
  
  
  
  public int delete(int id);

  public List<Zhuanji> getAll(Map<String,Object> map);
  public List<Zhuanji> getsyzhuanji1(Map<String,Object> map);
  public List<Zhuanji> getsyzhuanji2(Map<String,Object> map);
  public List<Zhuanji> getsyzhuanji3(Map<String,Object> map);
  public Zhuanji quchongZhuanji(Map<String, Object> acount);

  public Zhuanji getById( int id);

  public List<Zhuanji> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zhuanji> select(Map<String, Object> map);
}
//	所有List
