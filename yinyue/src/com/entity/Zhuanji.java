package com.entity;

public class Zhuanji {
    private Integer id;
	private String zhuanjiming;	private String zuozhe;	private String yinle;	private String faburiqi;	private String jieshao;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getZhuanjiming() {
        return zhuanjiming;
    }
    public void setZhuanjiming(String zhuanjiming) {
        this.zhuanjiming = zhuanjiming == null ? null : zhuanjiming.trim();
    }	public String getZuozhe() {
        return zuozhe;
    }
    public void setZuozhe(String zuozhe) {
        this.zuozhe = zuozhe == null ? null : zuozhe.trim();
    }	public String getYinle() {
        return yinle;
    }
    public void setYinle(String yinle) {
        this.yinle = yinle == null ? null : yinle.trim();
    }	public String getFaburiqi() {
        return faburiqi;
    }
    public void setFaburiqi(String faburiqi) {
        this.faburiqi = faburiqi == null ? null : faburiqi.trim();
    }	public String getJieshao() {
        return jieshao;
    }
    public void setJieshao(String jieshao) {
        this.jieshao = jieshao == null ? null : jieshao.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
