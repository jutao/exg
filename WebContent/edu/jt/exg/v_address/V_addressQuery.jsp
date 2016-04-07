<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>v_addressquery</title>
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
    <script language="javascript" src="edu/jt/exg/js/v_address.js"></script>
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
		  		window.setTimeout(function(){window.location='V_addressAction.action?action=initquery';return true;},0);
			});
			
			$("#mmAll").click(function(){
		  		checkAll(this,'mm');
			});
			
			$("#a").click(function(){
				getDeleteAllIds('edu/jt/exg/action/V_addressAction.action?action=deleteSelected&ids=','<s:text name="Common.Delete_All_Msg"/>');
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
   <s:form id="form1" name="form1" action="edu/jt/exg/action/V_addressAction.action?action=query" namespace="/edu/jt/exg/action">
<s:hidden id="start" name="start"></s:hidden><br>
<s:text name="Logo.CurrentPosition"/>>>XXX
	<TABLE id="queryTable" style="width:auto" border="1" bordercolordark="#FFFFFF" bordercolorlight="cccccc" cellpadding="3" cellspacing="0" align="center">
		<TR><TD colspan="4" class="titlebg"><s:text name="Common.Query"/></TD></TR>
		
<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="V_address.Province_name"/></s:div></TD>
	<TD><s:textfield id="province_name" name="province_name" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="V_address.City_code"/></s:div></TD>
	<TD><s:textfield id="city_code" name="city_code" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="V_address.City_name"/></s:div></TD>
	<TD><s:textfield id="city_name" name="city_name" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="V_address.Area_code"/></s:div></TD>
	<TD><s:textfield id="area_code" name="area_code" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="V_address.Area_name"/></s:div></TD>
	<TD><s:textfield id="area_name" name="area_name" cssClass="text" size="15"/></TD>
</TR>

	</TABLE>
	<p align="center">
		<button id="f" class="button qing" style="width:110px; height:24px" title=<s:text name="Common.Submit"/>><s:text name="Common.Submit"/></button>&nbsp;
		<button id="r" class="button qing" style="width:110px; height:24px" title=<s:text name="Common.Reset"/>><s:text name="Common.Reset"/></button>
	</p>
	<p align="center">
		<a href="edu/jt/exg/action/V_addressAction.action?action=initcreate" target="_self"><img src ='<%=basePath%>edu/jt/exg/images/add.gif' border='0' title=<s:text name="Common.Create_New"/>/><s:text name="Common.Create_New"/></a>
		<s:set id="showPage" name="showPage" value="ShowPage"/>
		<s:if test="v_addressList.size()>0">		
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
						<td class="tdbg"><s:text name="V_address.Province_name"/></td>
		<td class="tdbg"><s:text name="V_address.City_code"/></td>
		<td class="tdbg"><s:text name="V_address.City_name"/></td>
		<td class="tdbg"><s:text name="V_address.Area_code"/></td>
		<td class="tdbg"><s:text name="V_address.Area_name"/></td>

				<td class="tdbg"><s:text name="Common.Control"/></td>
			</tr>
			<s:iterator value="v_addressList" status="stuts" id="R">               
				<tr id="t">
					<td>
						<input type="checkbox" id="mm" name="mm" value='<s:property value="#R.province_code"/>'>&nbsp;
					</td>
					<td><s:property value="#R.rownum"/>&nbsp;</td>
							<td><s:property value="#R.province_name"/>&nbsp;</td>
		<td><s:property value="#R.city_code"/>&nbsp;</td>
		<td><s:property value="#R.city_name"/>&nbsp;</td>
		<td><s:property value="#R.area_code"/>&nbsp;</td>
		<td><s:property value="#R.area_name"/>&nbsp;</td>

					<td>
						<a href="edu/jt/exg/action/V_addressAction.action?action=detail&province_code=<s:property value="#R.province_code"/>" target="_blank"><img src='<%=basePath%>edu/jt/exg/images/detail.gif' border='0' title=<s:text name="Common.Detail"/>></a>
						<a href="edu/jt/exg/action/V_addressAction.action?action=initupdate&province_code=<s:property value="#R.province_code"/>" target="_self"><img src='<%=basePath%>edu/jt/exg/images/update.gif' border='0' title=<s:text name="Common.Modify"/>></a>
						<a href="edu/jt/exg/action/V_addressAction.action?action=delete&province_code=<s:property value="#R.province_code"/>" target="_self"><img src ='<%=basePath%>edu/jt/exg/images/del.gif' border='0' title=<s:text name="Common.Delete"/> onclick="return rusure('<s:text name="Common.Alert_Del"/>');"/></a>
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