<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/default.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 1 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:10px;
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	margin-top:20px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:left;
	width:98%;
	font-size:16px;
}
</style>
<body>
<script type="text/javascript" src="../js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;员工打车<span>&nbsp;</span>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;添加记录<span>&nbsp;</span>
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">
<!-- 从session中获取集合 -->
<strong>修改打车记录</strong>
<br>
<br>

<form name="modifyForm" action="<%=path%>/employeeTaxi/EmployeeTaxi_save.action" method="post">
<table width="1000" align="center">


<tr>
    <td width="30%">序号：</td>
    <td><input type="text" name="eid" value='<s:property value="#session.modify_EmployeeTaxi.eid"/>'  readonly="readonly"/></td>
  </tr>

<tr>
    <td width="150">工号：</td>
    <td><input type="text" name="enumb" value='<s:property value="#session.modify_EmployeeTaxi.enumb"/>'  readonly="readonly" /></td>
  </tr>

  <tr>
    <td width="150">姓名：</td>
    <td><input type="text" name="ename" value='<s:property value="#session.modify_EmployeeTaxi.ename"/>' /></td>
  </tr>
  
  <tr>
    <td width="150">打车日期：</td>
    <td><input name="etaxiday" type="text" size="20" value='<s:property value="#session.modify_EmployeeTaxi.etaxiday"/>' 
      maxlength="10" onclick="new Calendar().show(this);"/>
    </td>
  </tr>
  
   <tr>
    <td width="150">打车目的地：</td>
    <td><input type="text" name="etaxigo" value='<s:property value="#session.modify_EmployeeTaxi.etaxigo"/>' /></td>
  </tr>
  
  <tr>
    <td width="150">打车费用：</td>
    <td><input type="text" name="etaxicost" value='<s:property value="#session.modify_EmployeeTaxi.etaxicost"/>' /></td>
  </tr>
  
  
  <tr>
    <td colspan="2" ><input class="button" type="submit" value="确认修改"></td>
     <td colspan="2" ><a href="<%=path%>/employeeTaxi/EmployeeTaxi_query.action">返回打车列表？</a></td>
  </tr>
</table>
</form>


</div>
</body>
</html>