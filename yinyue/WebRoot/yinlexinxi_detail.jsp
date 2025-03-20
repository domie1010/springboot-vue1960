<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>音乐信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  音乐信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>标题：</td><td width='39%'>${yinlexinxi.biaoti}</td>
     <td>作者：</td>
     <td>${yinlexinxi.zuozhe}</td>
   </tr><tr>
     <td>分类标签：</td>
     <td>${yinlexinxi.fenleibiaoqian}</td>
     <td>相关描述：</td>
     <td>${yinlexinxi.xiangguanmiaoshu}</td>
   </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
  </table>

  </body>
</html>

