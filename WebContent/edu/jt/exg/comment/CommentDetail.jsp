<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>commentDetail</title>
    <style>.doubleselect br{display:none}</style>
    <meta http-equiv="Cache-Control" content="no-store">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="0">
    <LINK href="../theme/style.css" rel="stylesheet" type="text/css">
	<base href="<%=basePath%>">
    <script language="javascript" src="edu/jt/exg/js/jquery-1.11.1.js"></script>
    <script language="javascript" src="edu/jt/exg/js/public.js"></script>
    <script language="javascript" src="edu/jt/exg/js/comment.js"></script>
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
	$(function(){
    		//等待加载editor控件
    		document.body.style.display='none';   
		window.setTimeout('show()',2000);
	  		
	  	$("#c").click(function(){
			javascript:window.close();
		});
	});
		
	function show(){   
	      	$(document.body).css('display', ''); 
	      	//EDiaryEditor必须延时加载
		
	}
    </script>
</head>
<body><br>
<s:text name="Logo.CurrentPosition"/>>>XXX
	<TABLE style="width:auto" border="1" bordercolordark="#FFFFFF" bordercolorlight="cccccc" cellpadding="3" cellspacing="0" align="center">
		<TR><TD colspan="2" class="titlebg"><s:text name="Common.Detail"/></TD></TR>
		
<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Comment.Userkey"/></s:div></TD>
	<TD><s:property value="userkey"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Comment.Targetkey"/></s:div></TD>
	<TD><s:property value="targetkey"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Comment.Detail"/></s:div></TD>
	<TD><s:property value="detail"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Comment.Pic1"/></s:div></TD>
	<TD>
		<s:hidden id="pic1" name="pic1"></s:hidden>
		<iframe id="pic1FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=pic1" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Comment.Pic2"/></s:div></TD>
	<TD>
		<s:hidden id="pic2" name="pic2"></s:hidden>
		<iframe id="pic2FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=pic2" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Comment.Pic3"/></s:div></TD>
	<TD>
		<s:hidden id="pic3" name="pic3"></s:hidden>
		<iframe id="pic3FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=pic3" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Comment.Category"/></s:div></TD>
	<TD><s:property value="category"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Comment.Display"/></s:div></TD>
	<TD><s:property value="display"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Comment.Invalid"/></s:div></TD>
	<TD><s:property value="invalid"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Comment.Register_time"/></s:div></TD>
	<TD>
		<s:date name="register_time" format="yyyy-MM-dd hh:mm:ss"/>&nbsp;
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Comment.Update_time"/></s:div></TD>
	<TD>
		<s:date name="update_time" format="yyyy-MM-dd hh:mm:ss"/>&nbsp;
	</TD>
</TR>

	</TABLE>
	<p align="center">
		<button id="c" class="button qing" style="width:110px; height:24px"><s:text name="Common.Close"/></button>
	</p>
</body>
</html>