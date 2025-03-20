<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>音乐网站</title>
<meta name="generator" content="" />
<meta name="author" content="" />

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="qtimages/js/jquery-1.8.3.min.js"></script>
<script src="qtimages/js/jquery.superslide.2.1.js"></script>
<link rel="stylesheet" type="text/css" href="qtimages/css/common.css">
<link type="text/css" rel="stylesheet" href="qtimages/css/flexslider.css" />
<link rel="stylesheet" type="text/css" href="qtimages/css/index.css">
<link rel="stylesheet" type="text/css" href="qtimages/css/main.css">
<link href="qtimages/css/index1.css" rel="stylesheet">
<link href="qtimages/css/zzsc.css" rel="stylesheet" type="text/css">

<script src="qtimages/js/hsggundong.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
.STYLE1 {color: #FFCC99}
-->
</style>
</head>
<body>
	
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
<jsp:include page="sidebufen2.jsp"></jsp:include>



<div class="layout">
   <div class="ind_tit">
     <h2 class="STYLE1">音乐人</h2>
   </div>
</div>


<div class="layout">
    <div class="scrollpic">
      <div id="mybtns"> <a href="javascript:;" id="right"></a><a href="javascript:;" id="left"></a>  </div>
      <div id="myscroll">
        <div id="myscrollbox">
          <ul>
		  
		  <c:forEach items="${syduliyinleren1}" var="a">
            <li>
              <a href="dlylrDetail.do?id=${a.id}"><img src="${a.zhaopian}" width="265" height="209" /><span>
              <div align="center">${a.xingming}</div>
              </span></a>    
		    </li>
			
			
		
			</c:forEach>
			
          </ul>
        </div>
      </div>
    </div>
</div>



<div class="layout"></div>
   <jsp:include page="qtdown.jsp"></jsp:include>
</body> 
</html>
