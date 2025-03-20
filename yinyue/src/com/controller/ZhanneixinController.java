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

import com.entity.Zhanneixin;
import com.server.ZhanneixinServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZhanneixinController {
	@Resource
	private ZhanneixinServer zhanneixinService;


   
	@RequestMapping("addZhanneixin.do")
	public String addZhanneixin(HttpServletRequest request,Zhanneixin zhanneixin,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zhanneixin.setAddtime(time.toString().substring(0, 19));
		zhanneixinService.add(zhanneixin);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zhanneixinList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zhanneixinList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZhanneixin.do")
	public String doUpdateZhanneixin(int id,ModelMap map,Zhanneixin zhanneixin){
		zhanneixin=zhanneixinService.getById(id);
		map.put("zhanneixin", zhanneixin);
		return "zhanneixin_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("zhanneixinDetail.do")
	public String zhanneixinDetail(int id,ModelMap map,Zhanneixin zhanneixin){
		zhanneixin=zhanneixinService.getById(id);
		map.put("zhanneixin", zhanneixin);
		return "zhanneixin_detail";
	}
//	前台详细
	@RequestMapping("znxDetail.do")
	public String znxDetail(int id,ModelMap map,Zhanneixin zhanneixin){
		zhanneixin=zhanneixinService.getById(id);
		map.put("zhanneixin", zhanneixin);
		return "zhanneixindetail";
	}
//	
	@RequestMapping("updateZhanneixin.do")
	public String updateZhanneixin(int id,ModelMap map,Zhanneixin zhanneixin,HttpServletRequest request,HttpSession session){
		zhanneixinService.update(zhanneixin);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zhanneixinList.do";
	}

//	分页查询
	@RequestMapping("zhanneixinList.do")
	public String zhanneixinList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanneixin zhanneixin, String shoujianren, String neirong, String wenjian, String fasongren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(fasongren==null||fasongren.equals("")){pmap.put("fasongren", null);}else{pmap.put("fasongren", fasongren);}		
		int total=zhanneixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanneixin> list=zhanneixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanneixin_list";
	}
	
	@RequestMapping("zhanneixinList3.do")
	public String zhanneixinList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanneixin zhanneixin, String shoujianren, String neirong, String wenjian, String fasongren,HttpServletRequest request){
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
		
		pmap.put("shoujianren", (String)request.getSession().getAttribute("username"));
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		
		
		int total=zhanneixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanneixin> list=zhanneixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanneixin_list3";
	}	@RequestMapping("zhanneixinList2.do")
	public String zhanneixinList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanneixin zhanneixin, String shoujianren, String neirong, String wenjian, String fasongren,HttpServletRequest request){
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
		
		pmap.put("fasongren", (String)request.getSession().getAttribute("username"));
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		
		
		int total=zhanneixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanneixin> list=zhanneixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanneixin_list2";
	}	
	
	@RequestMapping("znxList.do")
	public String znxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanneixin zhanneixin, String shoujianren, String neirong, String wenjian, String fasongren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(fasongren==null||fasongren.equals("")){pmap.put("fasongren", null);}else{pmap.put("fasongren", fasongren);}		
		int total=zhanneixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanneixin> list=zhanneixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanneixinlist";
	}
	
	@RequestMapping("deleteZhanneixin.do")
	public String deleteZhanneixin(int id,HttpServletRequest request){
		zhanneixinService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zhanneixinList.do";
	}
	
	
}
