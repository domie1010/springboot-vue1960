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

import com.entity.Duliyinleren;
import com.server.DuliyinlerenServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class DuliyinlerenController {
	@Resource
	private DuliyinlerenServer duliyinlerenService;


   
	@RequestMapping("addDuliyinleren.do")
	public String addDuliyinleren(HttpServletRequest request,Duliyinleren duliyinleren,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		duliyinleren.setAddtime(time.toString().substring(0, 19));
		duliyinlerenService.add(duliyinleren);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "duliyinlerenList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:duliyinlerenList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateDuliyinleren.do")
	public String doUpdateDuliyinleren(int id,ModelMap map,Duliyinleren duliyinleren){
		duliyinleren=duliyinlerenService.getById(id);
		map.put("duliyinleren", duliyinleren);
		return "duliyinleren_updt";
	}
	
	@RequestMapping("doUpdateDuliyinleren2.do")
	public String doUpdateDuliyinleren2(ModelMap map,Duliyinleren duliyinleren,HttpServletRequest request){
		duliyinleren=duliyinlerenService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("duliyinleren", duliyinleren);
		return "duliyinleren_updt2";
	}
	
@RequestMapping("updateDuliyinleren2.do")
	public String updateDuliyinleren2(int id,ModelMap map,Duliyinleren duliyinleren){
		duliyinlerenService.update(duliyinleren);
		return "redirect:doUpdateDuliyinleren2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("duliyinlerenDetail.do")
	public String duliyinlerenDetail(int id,ModelMap map,Duliyinleren duliyinleren){
		duliyinleren=duliyinlerenService.getById(id);
		map.put("duliyinleren", duliyinleren);
		return "duliyinleren_detail";
	}
//	前台详细
	@RequestMapping("dlylrDetail.do")
	public String dlylrDetail(int id,ModelMap map,Duliyinleren duliyinleren){
		duliyinleren=duliyinlerenService.getById(id);
		map.put("duliyinleren", duliyinleren);
		return "duliyinlerendetail";
	}
//	
	@RequestMapping("updateDuliyinleren.do")
	public String updateDuliyinleren(int id,ModelMap map,Duliyinleren duliyinleren,HttpServletRequest request,HttpSession session){
		duliyinlerenService.update(duliyinleren);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:duliyinlerenList.do";
	}

//	分页查询
	@RequestMapping("duliyinlerenList.do")
	public String duliyinlerenList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Duliyinleren duliyinleren, String yonghuming, String mima, String xingming, String xingbie, String shouji, String shenfenzheng, String jifen1,String jifen2, String zhaopian, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(jifen1==null||jifen1.equals("")){pmap.put("jifen1", null);}else{pmap.put("jifen1", jifen1);}		if(jifen2==null||jifen2.equals("")){pmap.put("jifen2", null);}else{pmap.put("jifen2", jifen2);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=duliyinlerenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Duliyinleren> list=duliyinlerenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "duliyinleren_list";
	}
	
	
	
	@RequestMapping("dlylrList.do")
	public String dlylrList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Duliyinleren duliyinleren, String yonghuming, String mima, String xingming, String xingbie, String shouji, String shenfenzheng, String jifen1,String jifen2, String zhaopian, String jianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(jifen1==null||jifen1.equals("")){pmap.put("jifen1", null);}else{pmap.put("jifen1", jifen1);}		if(jifen2==null||jifen2.equals("")){pmap.put("jifen2", null);}else{pmap.put("jifen2", jifen2);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=duliyinlerenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Duliyinleren> list=duliyinlerenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "duliyinlerenlist";
	}
	
	@RequestMapping("deleteDuliyinleren.do")
	public String deleteDuliyinleren(int id,HttpServletRequest request){
		duliyinlerenService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:duliyinlerenList.do";
	}
	
	@RequestMapping("quchongDuliyinleren.do")
	public void quchongDuliyinleren(Duliyinleren duliyinleren,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yonghuming", duliyinleren.getYonghuming());
		   System.out.println("yonghuming==="+duliyinleren.getYonghuming());
		   System.out.println("yonghuming222==="+duliyinlerenService.quchongDuliyinleren(map));
		   JSONObject obj=new JSONObject();
		   if(duliyinlerenService.quchongDuliyinleren(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "用户名可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
