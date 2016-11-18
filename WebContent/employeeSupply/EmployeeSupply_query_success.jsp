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
    border: 0 none;
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
	float:left;
	margin-right:10px;
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
	text-align:center;
	width:98%;
	font-size:12px;
}
</style>
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="8" height="11" border="0" alt=""></span>&nbsp;上级管理<span>&nbsp;</span>
		<span><img src="../images/arror.gif" width="8" height="11" border="0" alt=""></span>&nbsp;餐补列表<span>&nbsp;</span>
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="<%=path%>/employeeSupply/EmployeeSupply_query.action">刷新记录</a>
		</div>
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="<%=path%>/employeeSupply/EmployeeSupply_filter.jsp">导出Excel</a>
		</div>
	</div>
</div>
<div id="mainContainer" style="width:1000px; height:500px; overflow:scroll;">
<!-- 从session中获取集合 -->

<table class="default" width="100%" cellspacing="0" id="dataTableDetail" align="center">
	<col width="5%">
	<col width="8%">
	<col width="8%">
	<col width="8%">
	<col width="14%">
	<col width="14%">
	<col width="14%">
	<col width="10%">
	<col width="8%">
	<col width="8%">
	<col width="3%">
	<tr class="title">
		<td>序号</td>
		<td>报销金额</td>
		<td>用餐人数</td>
		<td>用餐次数</td>
		<td>是否有外部协作单位</td>
		<td>用餐人员员工编号</td>
		<td>用餐人员姓名</td>
		<td>日期</td>
		<td>是否假期</td>
		<td>工作事由</td>
		<td>操作</td>
	</tr>
	
	<!-- 遍历开始 -->
	<s:iterator value="#session.EmployeeSupply_list" var="emp">
	<tr class="list">
		<td><s:property value="#emp.sid"/></td>
		<td><s:property value="#emp.sreimburse"/></td>
		<td><s:property value="#emp.snumbs"/></td>
		<td><s:property value="#emp.stimes"/></td>
		<td><s:property value="#emp.scooperate"/></td>
		<td><s:property value="#emp.senum"/></td>
		<td><s:property value="#emp.sename"/></td>
		<td><s:date name="#emp.sday" format="yyyy年MM月dd日"/></td>
		<td><s:property value="#emp.sholiday"/></td>
		<td><s:property value="#emp.sreason"/></td>
		<td><a href="<%=path%>/employeeTaxi/EmployeeSupply_delete.action?eid=<s:property value="#emp.sid"/>" onclick="javascript: return confirm('真的要删除吗？');">删除</a></td>
	</tr>
	</s:iterator>
	<!-- 遍历结束 -->
</table>
</div>
</body>
</html>