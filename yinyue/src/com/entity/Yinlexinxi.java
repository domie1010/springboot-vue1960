package com.entity;

public class Yinlexinxi {
    private Integer id;
	private String biaoti;	private String yinle;	private String zuozhe;	private String fenleibiaoqian;	private String xiangguanmiaoshu;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? null : biaoti.trim();
    }	public String getYinle() {
        return yinle;
    }
    public void setYinle(String yinle) {
        this.yinle = yinle == null ? null : yinle.trim();
    }	public String getZuozhe() {
        return zuozhe;
    }
    public void setZuozhe(String zuozhe) {
        this.zuozhe = zuozhe == null ? null : zuozhe.trim();
    }	public String getFenleibiaoqian() {
        return fenleibiaoqian;
    }
    public void setFenleibiaoqian(String fenleibiaoqian) {
        this.fenleibiaoqian = fenleibiaoqian == null ? null : fenleibiaoqian.trim();
    }	public String getXiangguanmiaoshu() {
        return xiangguanmiaoshu;
    }
    public void setXiangguanmiaoshu(String xiangguanmiaoshu) {
        this.xiangguanmiaoshu = xiangguanmiaoshu == null ? null : xiangguanmiaoshu.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
