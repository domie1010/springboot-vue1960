<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="zhuanjihsgb" scope="page" class="com.bean.ZhuanjiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zhuanji.xls");
%>
<html>
  <head>
    <title>专辑</title>
  </head>

  <body >
 <%
			String sql="select * from zhuanji  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>专辑名</td>    <td align='center'>作者</td>    <td  width='90' align='center'>音乐</td>    <td  width='65' align='center'>发布日期</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=zhuanjihsgb.getAllZhuanji(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.zhuanjiming}</td>    <td>${u.zuozhe}</td>    <td width='90' align='center'><a href='play.jsp?spwj=${u.yinle}' target='_blank'>点此播放</a></td>    <td>${u.faburiqi}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

