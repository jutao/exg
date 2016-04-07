<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>goto</title>
    <meta http-equiv="Cache-Control" content="no-store">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="0">
	<script language="javascript">
		function dostart(){
			var s=unescape(window.location.href);
			var action='';
			var pv;
			var v = s.indexOf("?");
			var page='';
  			if(v!=-1){
  				pv=s.indexOf('go2page=');
  				actionPos=s.indexOf('action=');
  				action=s.substring(s.indexOf('action=')+7,pv-1);
  				page=s.substring(pv+8,s.length);
  				s=s.substring(v+1,pv-1);
  				document.all.params.value=s;
  				var form=document.getElementById("form1");
				form.action=page + '?action=' + action; 
				form.method = "POST"; 
				form.encoding="application/x-www-form-urlencoded"; 
				form.submit();
  			}
		}
	</script>
</head>
<body onload="dostart();">
<s:form id="form1" name="form1" action="#"> 
	<s:hidden name="params"></s:hidden>
</s:form>
</body>
</html>