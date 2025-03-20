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

import com.entity.Zhuanji;
import com.server.ZhuanjiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZhuanjiController {
	@Resource
	private ZhuanjiServer zhuanjiService;


   
	@RequestMapping("addZhuanji.do")
	public String addZhuanji(HttpServletRequest request,Zhuanji zhuanji,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zhuanji.setAddtime(time.toString().substring(0, 19));
		zhuanjiService.add(zhuanji);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zhuanjiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zhuanjiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZhuanji.do")
	public String doUpdateZhuanji(int id,ModelMap map,Zhuanji zhuanji){
		zhuanji=zhuanjiService.getById(id);
		map.put("zhuanji", zhuanji);
		return "zhuanji_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("zhuanjiDetail.do")
	public String zhuanjiDetail(int id,ModelMap map,Zhuanji zhuanji){
		zhuanji=zhuanjiService.getById(id);
		map.put("zhuanji", zhuanji);
		return "zhuanji_detail";
	}
//	前台详细
	@RequestMapping("zjDetail.do")
	public String zjDetail(int id,ModelMap map,Zhuanji zhuanji){
		zhuanji=zhuanjiService.getById(id);
		map.put("zhuanji", zhuanji);
		return "zhuanjidetail";
	}
//	
	@RequestMapping("updateZhuanji.do")
	public String updateZhuanji(int id,ModelMap map,Zhuanji zhuanji,HttpServletRequest request,HttpSession session){
		zhuanjiService.update(zhuanji);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zhuanjiList.do";
	}

//	分页查询
	@RequestMapping("zhuanjiList.do")
	public String zhuanjiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuanji zhuanji, String zhuanjiming, String zuozhe, String yinle, String faburiqi1,String faburiqi2, String jieshao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhuanjiming==null||zhuanjiming.equals("")){pmap.put("zhuanjiming", null);}else{pmap.put("zhuanjiming", zhuanjiming);}		if(zuozhe==null||zuozhe.equals("")){pmap.put("zuozhe", null);}else{pmap.put("zuozhe", zuozhe);}		if(yinle==null||yinle.equals("")){pmap.put("yinle", null);}else{pmap.put("yinle", yinle);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(jieshao==null||jieshao.equals("")){pmap.put("jieshao", null);}else{pmap.put("jieshao", jieshao);}		
		int total=zhuanjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuanji> list=zhuanjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuanji_list";
	}
	
	@RequestMapping("zhuanjiList2.do")
	public String zhuanjiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuanji zhuanji, String zhuanjiming, String zuozhe, String yinle, String faburiqi1,String faburiqi2, String jieshao,HttpServletRequest request){
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
		if(zhuanjiming==null||zhuanjiming.equals("")){pmap.put("zhuanjiming", null);}else{pmap.put("zhuanjiming", zhuanjiming);}		if(yinle==null||yinle.equals("")){pmap.put("yinle", null);}else{pmap.put("yinle", yinle);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(jieshao==null||jieshao.equals("")){pmap.put("jieshao", null);}else{pmap.put("jieshao", jieshao);}		
		
		int total=zhuanjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuanji> list=zhuanjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuanji_list2";
	}	
	
	@RequestMapping("zjList.do")
	public String zjList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuanji zhuanji, String zhuanjiming, String zuozhe, String yinle, String faburiqi1,String faburiqi2, String jieshao){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhuanjiming==null||zhuanjiming.equals("")){pmap.put("zhuanjiming", null);}else{pmap.put("zhuanjiming", zhuanjiming);}		if(zuozhe==null||zuozhe.equals("")){pmap.put("zuozhe", null);}else{pmap.put("zuozhe", zuozhe);}		if(yinle==null||yinle.equals("")){pmap.put("yinle", null);}else{pmap.put("yinle", yinle);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(jieshao==null||jieshao.equals("")){pmap.put("jieshao", null);}else{pmap.put("jieshao", jieshao);}		
		int total=zhuanjiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuanji> list=zhuanjiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuanjilist";
	}
	
	@RequestMapping("deleteZhuanji.do")
	public String deleteZhuanji(int id,HttpServletRequest request){
		zhuanjiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zhuanjiList.do";
	}
	
	
}
