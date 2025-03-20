<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


 <div class="layout" style="border-bottom:1px solid #dedede;">
   <div class="ind_tit" style="margin-top:40px;">
     <h2>我们和最优秀的团队合作，创造价值，共赢未来。</h2>
   </div>
 </div>
  <div class="layout">
    <div class="firend">
      <ul>
	     <%
			String sqlyqlj="select  * from youqinglianjie   order by id desc limit 0,5";
			ResultSet RS_resultyqlj=connDbBean.executeQuery(sqlyqlj);
while(RS_resultyqlj.next())
{
		%>
        <li><a href="<%=RS_resultyqlj.getString("wangzhi")%>"><img src="<%=RS_resultyqlj.getString("logo")%>" alt="<%=RS_resultyqlj.getString("wangzhanmingcheng")%>" width="181" title="<%=RS_resultyqlj.getString("wangzhanmingcheng")%>"></a></li>
          <%
								  }
								  %>
 
      </ul>
      <ul>
 
      </ul>
    </div>
  </div>
    <div class="layout bg5">
    <div class="footer">
      <ul>
        <h3>产品与服务</h3>
        <a><li>产品方案</li></a>
        <a><li>技术服务</li></a>
      </ul>
      <ul>
        <h3>客户与合作</h3>
        <a><li>主要客户</li></a>
        <a><li>战略伙伴</li></a>
        <a><li>典型案例</li></a>
      </ul>
      <ul>
        <h3>资讯中心</h3>
        <a><li>公司动态</li></a>
        <a><li>媒体视频</li></a>
        <a><li>真我风采</li></a>
        <ax><li>友情链接</li></a>
      </ul>
      <ul>
        <h3>英雄加盟</h3>
        <a><li>招贤纳士</li></a>
        <a><li>关怀与成长</li></a>
        <a><li>职业发展</li></a>
        <a><li>总经理致辞</li></a>
      </ul>
      <ul style="width:97px;float:right;text-align:center;">
        <h3>官方微信</h3>
        <img src="qtimages/picture/1484283352.jpg" alt="官方微信" title="官方微信">
      </ul>
    </div>
  </div>
  <div class="layout bg3">
    <div class="foot">
      <div class="foot_lef">
        <div class="goumai_b">
          <div class="slideTxtBox">
            <div class="hd">
              <ul>
                  <li class="on">上海</li>
                  <li>深圳</li>
                  <li>西安</li>
                  <li>成都</li>
              </ul>
            </div>
            <div class="bd">
              <div  style="display: block;">上海市长宁区新华路728号华联发展大厦908-910室 </div>
              <div  style="display: none;">深圳市龙岗区坂田街道黄君山111号山海商业广场C栋4-5楼 </div>
              <div  style="display: none;">西安市高新区天谷八路环普科技产业园C座301室 </div>
              <div  style="display: none;">成都市高新区天府三街288号大有智慧广场1栋8楼</div>
            </div>
          </div>
          <script type="text/javascript">jQuery(".slideTxtBox").slide();</script>
           <!--  <script type="text/javascript">jQuery(".slideTxtBox").slide({trigger:"click"});</script> -->
        </div>
      </div>
      <div class="foot_rig">
        <div class="foot_rig_t">
          <a href="#"><span><img src="qtimages/picture/l_01.png"></span></a>
          <a href="#"><span><img src="qtimages/picture/l_02.png"></span></a>
          <a href="#"><span><img src="qtimages/picture/l_03.png"></span></a>
          <a href="#"><span><img src="qtimages/picture/l_04.png"></span></a>
        </div>
        <div class="foot_rig_o">@ 2019  音乐网站 . All Rights Reserved. <a href="#">沪ICP备xxxxxx号</a>&nbsp;</div>
      </div>
    </div>
  </div>
  <p id="back-to-top"><a href="#top"><span></span></a></p>
  
  </div>
  <script>
      $(function () {
          //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
          $(function () {
              $(window).scroll(function () {
                  if ($(window).scrollTop() > 100) {
                      $("#back-to-top").fadeIn(900);
                  }
                  else {
                      $("#back-to-top").stop().fadeOut(900);
                  }
              });
              //当点击跳转链接后，回到页面顶部位置
              $("#back-to-top").click(function () {
                  $('body,html').stop().animate({ scrollTop: 0 }, 100); //1000代表1秒时间回到顶点
                  return false;
              });
          });
      });
  </script> 