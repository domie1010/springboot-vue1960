﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改专辑</TITLE>
	    <link rel="stylesheet" href="kindeditor_a5/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor_a5/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor_a5/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor_a5/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor_a5/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="jieshao"]', {
				cssPath : 'kindeditor_a5/plugins/code/prettify.css',
				uploadJson : 'kindeditor_a5/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor_a5/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="zhuanji_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateZhuanji.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改专辑<input type="hidden" name="id" value="${zhuanji.id}" /></td>
						</tr>
						<tr ><td width="200">专辑名：</td><td><input name='zhuanjiming' type='text' id='zhuanjiming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelzhuanjiming' /></td></tr>		<tr ><td width="200">作者：</td><td><input name='zuozhe' type='text' id='zuozhe' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelzuozhe' /></td></tr>		<tr ><td width="200">音乐：</td><td><input name='yinle' type='text' id='yinle' size='50' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('yinle')" style='border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelyinle' /></td></tr>		<tr ><td width="200">发布日期：</td><td><input name='faburiqi' type='text' id='faburiqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelfaburiqi' /></td></tr>		<tr ><td width="200">介绍：</td><td><textarea name="jieshao" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.zhuanjiming.value='${zhuanji.zhuanjiming}';</script>	<script language="javascript">document.form1.zuozhe.value='${zhuanji.zuozhe}';</script>	<script language="javascript">document.form1.yinle.value='${zhuanji.yinle}';</script>	<script language="javascript">document.form1.faburiqi.value='${zhuanji.faburiqi}';</script>	<script language="javascript">document.form1.jieshao.value='${zhuanji.jieshao}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var zhuanjimingobj = document.getElementById("zhuanjiming"); if(zhuanjimingobj.value==""){document.getElementById("clabelzhuanjiming").innerHTML="&nbsp;&nbsp;<font color=red>请输入专辑名</font>";return false;}else{document.getElementById("clabelzhuanjiming").innerHTML="  "; } 	var zuozheobj = document.getElementById("zuozhe"); if(zuozheobj.value==""){document.getElementById("clabelzuozhe").innerHTML="&nbsp;&nbsp;<font color=red>请输入作者</font>";return false;}else{document.getElementById("clabelzuozhe").innerHTML="  "; } 	var yinleobj = document.getElementById("yinle"); if(yinleobj.value==""){document.getElementById("clabelyinle").innerHTML="&nbsp;&nbsp;<font color=red>请输入音乐</font>";return false;}else{document.getElementById("clabelyinle").innerHTML="  "; } 	var faburiqiobj = document.getElementById("faburiqi"); if(faburiqiobj.value==""){document.getElementById("clabelfaburiqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入发布日期</font>";return false;}else{document.getElementById("clabelfaburiqi").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
