<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>taskDetail</title>
    <style>.doubleselect br{display:none}</style>
    <meta http-equiv="Cache-Control" content="no-store">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="0">
    <LINK href="../theme/style.css" rel="stylesheet" type="text/css">
	<base href="<%=basePath%>">
    <script language="javascript" src="edu/jt/exg/js/jquery-1.11.1.js"></script>
    <script language="javascript" src="edu/jt/exg/js/public.js"></script>
    <script language="javascript" src="edu/jt/exg/js/task.js"></script>
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
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Taskid"/></s:div></TD>
	<TD><s:property value="taskid"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Userkey"/></s:div></TD>
	<TD><s:property value="userkey"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Serverkey"/></s:div></TD>
	<TD><s:property value="serverkey"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Tip"/></s:div></TD>
	<TD><s:property value="tip"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Epson"/></s:div></TD>
	<TD><s:property value="epson"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Pro_description"/></s:div></TD>
	<TD><s:property value="pro_description"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Pro_image1"/></s:div></TD>
	<TD>
		<s:hidden id="pro_image1" name="pro_image1"></s:hidden>
		<iframe id="pro_image1FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=pro_image1" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Pro_image2"/></s:div></TD>
	<TD>
		<s:hidden id="pro_image2" name="pro_image2"></s:hidden>
		<iframe id="pro_image2FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=pro_image2" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Pro_image3"/></s:div></TD>
	<TD>
		<s:hidden id="pro_image3" name="pro_image3"></s:hidden>
		<iframe id="pro_image3FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=pro_image3" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Pro_image4"/></s:div></TD>
	<TD>
		<s:hidden id="pro_image4" name="pro_image4"></s:hidden>
		<iframe id="pro_image4FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=pro_image4" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Pro_image5"/></s:div></TD>
	<TD>
		<s:hidden id="pro_image5" name="pro_image5"></s:hidden>
		<iframe id="pro_image5FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=pro_image5" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Solve_image1"/></s:div></TD>
	<TD>
		<s:hidden id="solve_image1" name="solve_image1"></s:hidden>
		<iframe id="solve_image1FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=solve_image1" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Solve_image2"/></s:div></TD>
	<TD>
		<s:hidden id="solve_image2" name="solve_image2"></s:hidden>
		<iframe id="solve_image2FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=solve_image2" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Solve_image3"/></s:div></TD>
	<TD>
		<s:hidden id="solve_image3" name="solve_image3"></s:hidden>
		<iframe id="solve_image3FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=solve_image3" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Seat"/></s:div></TD>
	<TD><s:property value="seat"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Status"/></s:div></TD>
	<TD><s:property value="status"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Invalid"/></s:div></TD>
	<TD><s:property value="invalid"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Register_time"/></s:div></TD>
	<TD>
		<s:date name="register_time" format="yyyy-MM-dd hh:mm:ss"/>&nbsp;
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Task.Update_time"/></s:div></TD>
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