<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>站内信详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  站内信详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>收件人：</td><td width='39%'>${zhanneixin.shoujianren}</td>     <td width='11%'>内容：</td><td width='39%'>${zhanneixin.neirong}</td></tr><tr>     <td width='11%'>文件：</td><td width='39%'><a href="${zhanneixin.wenjian}">点此下载</a></td>     <td width='11%'>发送人：</td><td width='39%'>${zhanneixin.fasongren}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

