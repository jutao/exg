<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>User</title>
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
    <script language="javascript">
    	//等待加载editor控件
    	$(function(){
			//等待加载editor控件
    		document.body.style.display='none';   
		window.setTimeout('show()',2000);
	  		
		var ajaxFlag=true;//通过所有ajax验证的标志位
		$("#s").click(function(){
			if(checkFormForCreateOrUpdate()==true){
			    			var data1="";

					//所有需要ajax验证的都要在这里完成
					if(ajaxFlag==true){//只要=false就认为有验证不通过
						//防止重复提交
						ShowDiv('fade');
						$("#form1").attr("action", "edu/jt/exg/action/UserAction.action?action=update").submit();
					}else alert('<s:text name="Common.ValidationFailAlert"/>');
				}
			});
			
			$("#b").click(function(){
				window.location.href='<%=basePath%>/edu/jt/exg/action/UserAction.action?action=initquery';
			});
		});
	function show(){   
	      	$(document.body).css('display', ''); 
	      	//EDiaryEditor必须延时加载
		
	}
    </script>
</head>
<body>
<s:form id="form1" name="form1" action="" namespace="/edu/jt/exg/action"><br>
<s:text name="Logo.CurrentPosition"/>>>XXX
		<TABLE style="width:auto" border="1" bordercolordark="#FFFFFF" bordercolorlight="cccccc" cellpadding="3" cellspacing="0" align="center">
			<TR><TD colspan="2" class="titlebg"><s:text name="Common.Modify"/></TD></TR>
			
<s:hidden id="id" name="id"></s:hidden>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Level"/></s:div></TD>
	<TD><s:textfield id="level" name="level" cssClass="text" size="15"/></TD>
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
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Icon"/></s:div></TD>
	<TD>
		<s:hidden id="icon" name="icon"></s:hidden>
		<iframe id="iconFileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=no&type=img&id=icon" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
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
	<TD><s:textfield id="balance" name="balance" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Point"/></s:div></TD>
	<TD><s:textfield id="point" name="point" cssClass="text" size="15"/></TD>
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
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Qualificat"/></s:div></TD>
	<TD>
		<s:hidden id="qualificat" name="qualificat"></s:hidden>
		<iframe id="qualificatFileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=no&type=img&id=qualificat" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
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

		</TABLE>
	</s:form>
		<p align="center">
			<button id="s" class="button qing" style="width:110px; height:24px" ondblclick="javascript:void(0);"><s:text name="Common.Submit"/></button>&nbsp;&nbsp;&nbsp;
			<button id="b" class="button qing" style="width:110px; height:24px" title=<s:text name="Common.Back"/>><s:text name="Common.Back"/></button>
		</p>
<div id="fade" class="black_overlay" style="text-align:center;">
<img src="<%=basePath%>/edu/jt/exg/images/loading51.gif" width="124" height="124" style=" margin-top:20%"></div>
</body>
</html>