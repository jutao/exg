<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>order_taskquery</title>
    <style>.doubleselect br{display:none}</style>
    <meta http-equiv="Cache-Control" content="no-store">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="0">
    <LINK href="../theme/style.css" rel="stylesheet" type="text/css">
	<base href="<%=basePath%>">
	<!--必须先加载否则js中的jquery脚本会报错未定义-->
	<script language="javascript" src="edu/jt/exg/js/jquery-1.11.1.js"></script>
    <script language="javascript" src="edu/jt/exg/js/public.js"></script>
    <script language="javascript" src="edu/jt/exg/js/order_task.js"></script>
    <style type="text/css">
		<!--
		  body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		  }
		-->
	</style>
    <sx:head/>
    <script language='javascript'>
	    $(function(){
		  	$("#form1").submit(function(){
		  		return checkFormForQuery();
			});
			
			$("#f").click(function(){
				ShowDiv('fade');
		  		finder();
			});
			
			$("#f").dblclick(function(){
				javascript:void(0);
			});
			
			$("#r").click(function(){
		  		window.setTimeout(function(){window.location='Order_taskAction.action?action=initquery';return true;},0);
			});
			
			$("#mmAll").click(function(){
		  		checkAll(this,'mm');
			});
			
			$("#a").click(function(){
				getDeleteAllIds('edu/jt/exg/action/Order_taskAction.action?action=deleteSelected&ids=','<s:text name="Common.Delete_All_Msg"/>');
				window.location.reload();
			});
			
			$("#mm").click(function(){
		  		checkItem(this,'mmAll');
			});
			
			$("#t").mouseout(function(){
		  		rowOver(this);
			});
			
			$("#t").mouseout(function(){
		  		rowOut(this);
			});
			
			$("#t").click(function(){
		  		selectRow(this);
			});
		});
	</script>
</head>
<body>
  <!--主键、附件、password不作为查询条件出列-->
   <s:form id="form1" name="form1" action="edu/jt/exg/action/Order_taskAction.action?action=query" namespace="/edu/jt/exg/action">
<s:hidden id="start" name="start"></s:hidden><br>
<s:text name="Logo.CurrentPosition"/>>>XXX
	<TABLE id="queryTable" style="width:auto" border="1" bordercolordark="#FFFFFF" bordercolorlight="cccccc" cellpadding="3" cellspacing="0" align="center">
		<TR><TD colspan="4" class="titlebg"><s:text name="Common.Query"/></TD></TR>
		
<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_task.Taskkey"/></s:div></TD>
	<TD><s:textfield id="taskkey" name="taskkey" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_task.Orderkey"/></s:div></TD>
	<TD><s:textfield id="orderkey" name="orderkey" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_task.Invalid"/></s:div></TD>
	<TD>
		<s:hidden id="invalid" name="invalid"></s:hidden>
		<s:select id="invalidSelect" name="invalidSelect" list="invalidMap" cssClass="select"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_task.Register_time"/></s:div></TD>
	<TD>
		<s:hidden id="register_timeFrom" name="register_timeFrom"></s:hidden>
		<sx:datetimepicker id="register_timeDateFrom" name="register_timeDateFrom" displayFormat="yyyy-MM-dd"/>
		<s:hidden id="register_timeHourFrom" name="register_timeHourFrom"></s:hidden>
		<s:select id="register_timeHourSelectFrom" name="register_timeHourSelectFrom" list="register_timeHourMapFrom" cssClass="select"/>：
		<s:hidden id="register_timeMinuteFrom" name="register_timeMinuteFrom"></s:hidden>
		<s:select id="register_timeMinuteSelectFrom" name="register_timeMinuteSelectFrom" list="register_timeMinuteMapFrom" cssClass="select"/>-
		<s:hidden id="register_timeTo" name="register_timeTo"></s:hidden>
		<sx:datetimepicker id="register_timeDateTo" name="register_timeDateTo" displayFormat="yyyy-MM-dd"/>
		<s:hidden id="register_timeHourTo" name="register_timeHourTo"></s:hidden>
		<s:select id="register_timeHourSelectTo" name="register_timeHourSelectTo" list="register_timeHourMapTo" cssClass="select"/>：
		<s:hidden id="register_timeMinuteTo" name="register_timeMinuteTo"></s:hidden>
		<s:select id="register_timeMinuteSelectTo" name="register_timeMinuteSelectTo" list="register_timeMinuteMapTo" cssClass="select"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_task.Update_time"/></s:div></TD>
	<TD>
		<s:hidden id="update_timeFrom" name="update_timeFrom"></s:hidden>
		<sx:datetimepicker id="update_timeDateFrom" name="update_timeDateFrom" displayFormat="yyyy-MM-dd"/>
		<s:hidden id="update_timeHourFrom" name="update_timeHourFrom"></s:hidden>
		<s:select id="update_timeHourSelectFrom" name="update_timeHourSelectFrom" list="update_timeHourMapFrom" cssClass="select"/>：
		<s:hidden id="update_timeMinuteFrom" name="update_timeMinuteFrom"></s:hidden>
		<s:select id="update_timeMinuteSelectFrom" name="update_timeMinuteSelectFrom" list="update_timeMinuteMapFrom" cssClass="select"/>-
		<s:hidden id="update_timeTo" name="update_timeTo"></s:hidden>
		<sx:datetimepicker id="update_timeDateTo" name="update_timeDateTo" displayFormat="yyyy-MM-dd"/>
		<s:hidden id="update_timeHourTo" name="update_timeHourTo"></s:hidden>
		<s:select id="update_timeHourSelectTo" name="update_timeHourSelectTo" list="update_timeHourMapTo" cssClass="select"/>：
		<s:hidden id="update_timeMinuteTo" name="update_timeMinuteTo"></s:hidden>
		<s:select id="update_timeMinuteSelectTo" name="update_timeMinuteSelectTo" list="update_timeMinuteMapTo" cssClass="select"/>
	</TD>
</TR>

	</TABLE>
	<p align="center">
		<button id="f" class="button qing" style="width:110px; height:24px" title=<s:text name="Common.Submit"/>><s:text name="Common.Submit"/></button>&nbsp;
		<button id="r" class="button qing" style="width:110px; height:24px" title=<s:text name="Common.Reset"/>><s:text name="Common.Reset"/></button>
	</p>
	<p align="center">
		<a href="edu/jt/exg/action/Order_taskAction.action?action=initcreate" target="_self"><img src ='<%=basePath%>edu/jt/exg/images/add.gif' border='0' title=<s:text name="Common.Create_New"/>/><s:text name="Common.Create_New"/></a>
		<s:set id="showPage" name="showPage" value="ShowPage"/>
		<s:if test="order_taskList.size()>0">		
			<table style="width:auto" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align="center">
						<s:if test="showPage.page.length()>0">
							<table style="width:auto" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="center">
										<s:text name="Common.Total_Count"/><s:property value="showPage.page" escape="false"/>
									</td>
								</tr>
							</table>
						</s:if>
					</td>
				</tr>
			</table>
			<table id="ServiceListTable" style="width:auto" border="1" bordercolordark="#FFFFFF" bordercolorlight="cccccc" cellpadding="3" cellspacing="0">
			<tr>
				<td class="tdbg">
					<input type="checkbox" id="mmAll" name="mmAll"><br>
							<a id="a" href="#" target="_self"><s:text name="Common.Delete"/></a>
				</td>
				<td class="tdbg"><s:text name="Common.Serial_Number"/></td>
						<td class="tdbg"><s:text name="Order_task.Taskkey"/></td>
		<td class="tdbg"><s:text name="Order_task.Orderkey"/></td>
		<td class="tdbg"><s:text name="Order_task.Invalid"/></td>
		<td class="tdbg"><s:text name="Order_task.Register_time"/></td>
		<td class="tdbg"><s:text name="Order_task.Update_time"/></td>

				<td class="tdbg"><s:text name="Common.Control"/></td>
			</tr>
			<s:iterator value="order_taskList" status="stuts" id="R">               
				<tr id="t">
					<td>
						<input type="checkbox" id="mm" name="mm" value='<s:property value="#R.id"/>'>&nbsp;
					</td>
					<td><s:property value="#R.rownum"/>&nbsp;</td>
							<td><s:property value="#R.taskkey"/>&nbsp;</td>
		<td><s:property value="#R.orderkey"/>&nbsp;</td>
		<td><s:property value="#R.invalid"/>&nbsp;</td>
		
<td><s:date name="#R.register_time" format="yyyy-MM-dd hh:mm:ss"/>&nbsp;</td>

		
<td><s:date name="#R.update_time" format="yyyy-MM-dd hh:mm:ss"/>&nbsp;</td>


					<td>
						<a href="edu/jt/exg/action/Order_taskAction.action?action=detail&id=<s:property value="#R.id"/>" target="_blank"><img src='<%=basePath%>edu/jt/exg/images/detail.gif' border='0' title=<s:text name="Common.Detail"/>></a>
						<a href="edu/jt/exg/action/Order_taskAction.action?action=initupdate&id=<s:property value="#R.id"/>" target="_self"><img src='<%=basePath%>edu/jt/exg/images/update.gif' border='0' title=<s:text name="Common.Modify"/>></a>
						<a href="edu/jt/exg/action/Order_taskAction.action?action=delete&id=<s:property value="#R.id"/>" target="_self"><img src ='<%=basePath%>edu/jt/exg/images/del.gif' border='0' title=<s:text name="Common.Delete"/> onclick="return rusure('<s:text name="Common.Alert_Del"/>');"/></a>
					</td>
				</tr>
			</s:iterator>
		</table>
		</s:if>
		<table style="width:auto" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<s:if test="showPage.page1.length()>0">
						<table style="width:auto" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="center">
									<s:text name="Common.Total_Count"/><s:property value="showPage.page1" escape="false"/>
								</td>
							</tr>
						</table>
					</s:if>
				</td>
			</tr>
		</table>
</s:form>
<div id="fade" class="black_overlay" style="text-align:center;">
<img src="<%=basePath%>/edu/jt/exg/images/loading51.gif" width="124" height="124" style=" margin-top:20%"></div>
<%@ include file="../html/TableMovingChangeColor.html"%>
</body>
</html>