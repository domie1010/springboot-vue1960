package com.entity;

public class Zhanneixin {
    private Integer id;
	private String shoujianren;	private String neirong;	private String wenjian;	private String fasongren;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShoujianren() {
        return shoujianren;
    }
    public void setShoujianren(String shoujianren) {
        this.shoujianren = shoujianren == null ? null : shoujianren.trim();
    }	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }	public String getWenjian() {
        return wenjian;
    }
    public void setWenjian(String wenjian) {
        this.wenjian = wenjian == null ? null : wenjian.trim();
    }	public String getFasongren() {
        return fasongren;
    }
    public void setFasongren(String fasongren) {
        this.fasongren = fasongren == null ? null : fasongren.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
