<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>userquery</title>
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
    <script language="javascript" src="edu/jt/exg/js/user.js"></script>
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
		  		window.setTimeout(function(){window.location='UserAction.action?action=initquery';return true;},0);
			});
			
			$("#mmAll").click(function(){
		  		checkAll(this,'mm');
			});
			
			$("#a").click(function(){
				getDeleteAllIds('edu/jt/exg/action/UserAction.action?action=deleteSelected&ids=','<s:text name="Common.Delete_All_Msg"/>');
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
   <s:form id="form1" name="form1" action="edu/jt/exg/action/UserAction.action?action=query" namespace="/edu/jt/exg/action">
<s:hidden id="start" name="start"></s:hidden><br>
<s:text name="Logo.CurrentPosition"/>>>XXX
	<TABLE id="queryTable" style="width:auto" border="1" bordercolordark="#FFFFFF" bordercolorlight="cccccc" cellpadding="3" cellspacing="0" align="center">
		<TR><TD colspan="4" class="titlebg"><s:text name="Common.Query"/></TD></TR>
		
<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Level"/></s:div></TD>
	<TD>
		<s:textfield id="levelFrom" name="levelFrom" cssClass="text" size="15"/>-
		<s:textfield id="levelTo" name="levelTo" cssClass="text" size="15"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Userid"/></s:div></TD>
	<TD><s:textfield id="userid" name="userid" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Name"/></s:div></TD>
	<TD><s:textfield id="name" name="name" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Nickname"/></s:div></TD>
	<TD><s:textfield id="nickname" name="nickname" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Id_number"/></s:div></TD>
	<TD><s:textfield id="id_number" name="id_number" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Email"/></s:div></TD>
	<TD><s:textfield id="email" name="email" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Gender"/></s:div></TD>
	<TD>
		<s:hidden id="gender" name="gender"></s:hidden>
		<s:select id="genderSelect" name="genderSelect" list="genderMap" cssClass="select"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Address_province"/></s:div></TD>
	<TD>
		<s:hidden id="address_province" name="address_province"></s:hidden>
		<s:select id="address_provinceSelect" name="address_provinceSelect" list="address_provinceMap" cssClass="select"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Address_city"/></s:div></TD>
	<TD>
		<s:hidden id="address_city" name="address_city"></s:hidden>
		<s:select id="address_citySelect" name="address_citySelect" list="address_cityMap" cssClass="select"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Address_area"/></s:div></TD>
	<TD>
		<s:hidden id="address_area" name="address_area"></s:hidden>
		<s:select id="address_areaSelect" name="address_areaSelect" list="address_areaMap" cssClass="select"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Address_details"/></s:div></TD>
	<TD><s:textfield id="address_details" name="address_details" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Hometown"/></s:div></TD>
	<TD><s:textfield id="hometown" name="hometown" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Occupation"/></s:div></TD>
	<TD><s:textfield id="occupation" name="occupation" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Interest"/></s:div></TD>
	<TD><s:textfield id="interest" name="interest" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Bankname"/></s:div></TD>
	<TD>
		<s:hidden id="bankname" name="bankname"></s:hidden>
		<s:select id="banknameSelect" name="banknameSelect" list="banknameMap" cssClass="select"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Bank_branch"/></s:div></TD>
	<TD><s:textfield id="bank_branch" name="bank_branch" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Card_number"/></s:div></TD>
	<TD><s:textfield id="card_number" name="card_number" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Balance"/></s:div></TD>
	<TD>
		<s:textfield id="balanceFrom" name="balanceFrom" cssClass="text" size="15"/>-
		<s:textfield id="balanceTo" name="balanceTo" cssClass="text" size="15"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Point"/></s:div></TD>
	<TD>
		<s:textfield id="pointFrom" name="pointFrom" cssClass="text" size="15"/>-
		<s:textfield id="pointTo" name="pointTo" cssClass="text" size="15"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Recommender_code"/></s:div></TD>
	<TD><s:textfield id="recommender_code" name="recommender_code" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Login_password"/></s:div></TD>
	<TD><s:textfield id="login_password" name="login_password" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Gesture_password"/></s:div></TD>
	<TD><s:textfield id="gesture_password" name="gesture_password" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Trading_password"/></s:div></TD>
	<TD><s:textfield id="trading_password" name="trading_password" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Category"/></s:div></TD>
	<TD>
		<s:hidden id="category" name="category"></s:hidden>
		<s:select id="categorySelect" name="categorySelect" list="categoryMap" cssClass="select"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Usertype"/></s:div></TD>
	<TD><s:checkbox id="usertype" name="usertype"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Yubei1"/></s:div></TD>
	<TD><s:textfield id="yubei1" name="yubei1" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Yubei2"/></s:div></TD>
	<TD><s:textfield id="yubei2" name="yubei2" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Yubei3"/></s:div></TD>
	<TD><s:textfield id="yubei3" name="yubei3" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Invalid"/></s:div></TD>
	<TD>
		<s:hidden id="invalid" name="invalid"></s:hidden>
		<s:select id="invalidSelect" name="invalidSelect" list="invalidMap" cssClass="select"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Register_time"/></s:div></TD>
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
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Update_time"/></s:div></TD>
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
		<a href="edu/jt/exg/action/UserAction.action?action=initcreate" target="_self"><img src ='<%=basePath%>edu/jt/exg/images/add.gif' border='0' title=<s:text name="Common.Create_New"/>/><s:text name="Common.Create_New"/></a>
		<s:set id="showPage" name="showPage" value="ShowPage"/>
		<s:if test="userList.size()>0">		
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
						<td class="tdbg"><s:text name="User.Level"/></td>
		<td class="tdbg"><s:text name="User.Userid"/></td>
		<td class="tdbg"><s:text name="User.Name"/></td>
		<td class="tdbg"><s:text name="User.Nickname"/></td>
		<td class="tdbg"><s:text name="User.Icon"/></td>
		<td class="tdbg"><s:text name="User.Id_number"/></td>
		<td class="tdbg"><s:text name="User.Email"/></td>
		<td class="tdbg"><s:text name="User.Gender"/></td>
		<td class="tdbg"><s:text name="User.Address_province"/></td>
		<td class="tdbg"><s:text name="User.Address_city"/></td>
		<td class="tdbg"><s:text name="User.Address_area"/></td>
		<td class="tdbg"><s:text name="User.Address_details"/></td>
		<td class="tdbg"><s:text name="User.Hometown"/></td>
		<td class="tdbg"><s:text name="User.Occupation"/></td>
		<td class="tdbg"><s:text name="User.Interest"/></td>
		<td class="tdbg"><s:text name="User.Bankname"/></td>
		<td class="tdbg"><s:text name="User.Bank_branch"/></td>
		<td class="tdbg"><s:text name="User.Card_number"/></td>
		<td class="tdbg"><s:text name="User.Balance"/></td>
		<td class="tdbg"><s:text name="User.Point"/></td>
		<td class="tdbg"><s:text name="User.Recommender_code"/></td>
		<td class="tdbg"><s:text name="User.Login_password"/></td>
		<td class="tdbg"><s:text name="User.Gesture_password"/></td>
		<td class="tdbg"><s:text name="User.Trading_password"/></td>
		<td class="tdbg"><s:text name="User.Category"/></td>
		<td class="tdbg"><s:text name="User.Usertype"/></td>
		<td class="tdbg"><s:text name="User.Qualificat"/></td>
		<td class="tdbg"><s:text name="User.Yubei1"/></td>
		<td class="tdbg"><s:text name="User.Yubei2"/></td>
		<td class="tdbg"><s:text name="User.Yubei3"/></td>
		<td class="tdbg"><s:text name="User.Invalid"/></td>
		<td class="tdbg"><s:text name="User.Register_time"/></td>
		<td class="tdbg"><s:text name="User.Update_time"/></td>

				<td class="tdbg"><s:text name="Common.Control"/></td>
			</tr>
			<s:iterator value="userList" status="stuts" id="R">               
				<tr id="t">
					<td>
						<input type="checkbox" id="mm" name="mm" value='<s:property value="#R.id"/>'>&nbsp;
					</td>
					<td><s:property value="#R.rownum"/>&nbsp;</td>
								<td><s:property value="#R.level"/>&nbsp;</td>
		<td><s:property value="#R.userid"/>&nbsp;</td>
		<td><s:property value="#R.name"/>&nbsp;</td>
		<td><s:property value="#R.nickname"/>&nbsp;</td>
		<td><s:property value="#R.icon" escape="false"/>&nbsp;</td>
		<td><s:property value="#R.id_number"/>&nbsp;</td>
		<td><s:property value="#R.email"/>&nbsp;</td>
		<td><s:property value="#R.gender"/>&nbsp;</td>
		<td><s:property value="#R.address_province"/>&nbsp;</td>
		<td><s:property value="#R.address_city"/>&nbsp;</td>
		<td><s:property value="#R.address_area"/>&nbsp;</td>
		<td><s:property value="#R.address_details"/>&nbsp;</td>
		<td><s:property value="#R.hometown"/>&nbsp;</td>
		<td><s:property value="#R.occupation"/>&nbsp;</td>
		<td><s:property value="#R.interest"/>&nbsp;</td>
		<td><s:property value="#R.bankname"/>&nbsp;</td>
		<td><s:property value="#R.bank_branch"/>&nbsp;</td>
		<td><s:property value="#R.card_number"/>&nbsp;</td>
			<td><s:property value="#R.balance"/>&nbsp;</td>
			<td><s:property value="#R.point"/>&nbsp;</td>
		<td><s:property value="#R.recommender_code"/>&nbsp;</td>
		<td><s:property value="#R.login_password"/>&nbsp;</td>
		<td><s:property value="#R.gesture_password"/>&nbsp;</td>
		<td><s:property value="#R.trading_password"/>&nbsp;</td>
		<td><s:property value="#R.category"/>&nbsp;</td>
		<td><s:property value="#R.usertype"/>&nbsp;</td>
		<td><s:property value="#R.qualificat" escape="false"/>&nbsp;</td>
		<td><s:property value="#R.yubei1"/>&nbsp;</td>
		<td><s:property value="#R.yubei2"/>&nbsp;</td>
		<td><s:property value="#R.yubei3"/>&nbsp;</td>
		<td><s:property value="#R.invalid"/>&nbsp;</td>
		
<td><s:date name="#R.register_time" format="yyyy-MM-dd hh:mm:ss"/>&nbsp;</td>

		
<td><s:date name="#R.update_time" format="yyyy-MM-dd hh:mm:ss"/>&nbsp;</td>


					<td>
						<a href="edu/jt/exg/action/UserAction.action?action=detail&id=<s:property value="#R.id"/>" target="_blank"><img src='<%=basePath%>edu/jt/exg/images/detail.gif' border='0' title=<s:text name="Common.Detail"/>></a>
						<a href="edu/jt/exg/action/UserAction.action?action=initupdate&id=<s:property value="#R.id"/>" target="_self"><img src='<%=basePath%>edu/jt/exg/images/update.gif' border='0' title=<s:text name="Common.Modify"/>></a>
						<a href="edu/jt/exg/action/UserAction.action?action=delete&id=<s:property value="#R.id"/>" target="_self"><img src ='<%=basePath%>edu/jt/exg/images/del.gif' border='0' title=<s:text name="Common.Delete"/> onclick="return rusure('<s:text name="Common.Alert_Del"/>');"/></a>
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