<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>独立音乐人详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  独立音乐人详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>用户名：</td><td width='39%'>${duliyinleren.yonghuming}</td><td  rowspan=7 align=center><a href=${duliyinleren.zhaopian} target=_blank><img src=${duliyinleren.zhaopian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>密码：</td><td width='39%'>${duliyinleren.mima}</td></tr><tr><td width='11%' height=44>姓名：</td><td width='39%'>${duliyinleren.xingming}</td></tr><tr><td width='11%' height=44>性别：</td><td width='39%'>${duliyinleren.xingbie}</td></tr><tr><td width='11%' height=44>手机：</td><td width='39%'>${duliyinleren.shouji}</td></tr><tr><td width='11%' height=44>身份证：</td><td width='39%'>${duliyinleren.shenfenzheng}</td></tr><tr><td width='11%' height=44>积分：</td><td width='39%'>${duliyinleren.jifen}</td></tr><tr><td width='11%' height=100  >简介：</td><td width='39%' colspan=2 height=100 >${duliyinleren.jianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

