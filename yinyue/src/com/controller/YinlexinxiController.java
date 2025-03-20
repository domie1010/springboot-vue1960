package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Yinlexinxi;
import com.server.YinlexinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YinlexinxiController {
	@Resource
	private YinlexinxiServer yinlexinxiService;


   
	@RequestMapping("addYinlexinxi.do")
	public String addYinlexinxi(HttpServletRequest request,Yinlexinxi yinlexinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yinlexinxi.setAddtime(time.toString().substring(0, 19));
		yinlexinxiService.add(yinlexinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yinlexinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yinlexinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYinlexinxi.do")
	public String doUpdateYinlexinxi(int id,ModelMap map,Yinlexinxi yinlexinxi){
		yinlexinxi=yinlexinxiService.getById(id);
		map.put("yinlexinxi", yinlexinxi);
		return "yinlexinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("yinlexinxiDetail.do")
	public String yinlexinxiDetail(int id,ModelMap map,Yinlexinxi yinlexinxi){
		yinlexinxi=yinlexinxiService.getById(id);
		map.put("yinlexinxi", yinlexinxi);
		return "yinlexinxi_detail";
	}
//	前台详细
	@RequestMapping("ylxxDetail.do")
	public String ylxxDetail(int id,ModelMap map,Yinlexinxi yinlexinxi){
		yinlexinxi=yinlexinxiService.getById(id);
		map.put("yinlexinxi", yinlexinxi);
		return "yinlexinxidetail";
	}
//	
	@RequestMapping("updateYinlexinxi.do")
	public String updateYinlexinxi(int id,ModelMap map,Yinlexinxi yinlexinxi,HttpServletRequest request,HttpSession session){
		yinlexinxiService.update(yinlexinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yinlexinxiList.do";
	}

//	分页查询
	@RequestMapping("yinlexinxiList.do")
	public String yinlexinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yinlexinxi yinlexinxi, String biaoti, String yinle, String zuozhe, String fenleibiaoqian, String xiangguanmiaoshu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(yinle==null||yinle.equals("")){pmap.put("yinle", null);}else{pmap.put("yinle", yinle);}		if(zuozhe==null||zuozhe.equals("")){pmap.put("zuozhe", null);}else{pmap.put("zuozhe", zuozhe);}		if(fenleibiaoqian==null||fenleibiaoqian.equals("")){pmap.put("fenleibiaoqian", null);}else{pmap.put("fenleibiaoqian", fenleibiaoqian);}		if(xiangguanmiaoshu==null||xiangguanmiaoshu.equals("")){pmap.put("xiangguanmiaoshu", null);}else{pmap.put("xiangguanmiaoshu", xiangguanmiaoshu);}		
		int total=yinlexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yinlexinxi> list=yinlexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yinlexinxi_list";
	}
	
	@RequestMapping("yinlexinxiList2.do")
	public String yinlexinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yinlexinxi yinlexinxi, String biaoti, String yinle, String zuozhe, String fenleibiaoqian, String xiangguanmiaoshu,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("zuozhe", (String)request.getSession().getAttribute("username"));
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(yinle==null||yinle.equals("")){pmap.put("yinle", null);}else{pmap.put("yinle", yinle);}		if(fenleibiaoqian==null||fenleibiaoqian.equals("")){pmap.put("fenleibiaoqian", null);}else{pmap.put("fenleibiaoqian", fenleibiaoqian);}		if(xiangguanmiaoshu==null||xiangguanmiaoshu.equals("")){pmap.put("xiangguanmiaoshu", null);}else{pmap.put("xiangguanmiaoshu", xiangguanmiaoshu);}		
		
		int total=yinlexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yinlexinxi> list=yinlexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yinlexinxi_list2";
	}	
	
	@RequestMapping("ylxxList.do")
	public String ylxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yinlexinxi yinlexinxi, String biaoti, String yinle, String zuozhe, String fenleibiaoqian, String xiangguanmiaoshu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(yinle==null||yinle.equals("")){pmap.put("yinle", null);}else{pmap.put("yinle", yinle);}		if(zuozhe==null||zuozhe.equals("")){pmap.put("zuozhe", null);}else{pmap.put("zuozhe", zuozhe);}		if(fenleibiaoqian==null||fenleibiaoqian.equals("")){pmap.put("fenleibiaoqian", null);}else{pmap.put("fenleibiaoqian", fenleibiaoqian);}		if(xiangguanmiaoshu==null||xiangguanmiaoshu.equals("")){pmap.put("xiangguanmiaoshu", null);}else{pmap.put("xiangguanmiaoshu", xiangguanmiaoshu);}		
		int total=yinlexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yinlexinxi> list=yinlexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yinlexinxilist";
	}
	
	@RequestMapping("deleteYinlexinxi.do")
	public String deleteYinlexinxi(int id,HttpServletRequest request){
		yinlexinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yinlexinxiList.do";
	}
	
	
}
