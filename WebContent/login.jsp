<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE HTML>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title><s:text name="Login.title"/></title>
    <meta http-equiv="Cache-Control" content="no-store">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="0">
	<meta name="viewport" content="width=device-width"/>
<!--     <LINK href="../theme/style.css" rel="stylesheet" type="text/css"> -->
<link href="edu/jt/exg/css/reset.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/layout.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/themes.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/typography.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/styles.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/shCore.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/jquery.jqplot.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/jquery-ui-1.8.18.custom.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/data-table.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/form.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/ui-elements.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/wizard.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/sprite.css" rel="stylesheet" type="text/css">
<link href="edu/jt/exg/css/gradient.css" rel="stylesheet" type="text/css">
<!--[if IE 7]>
<link rel="stylesheet" type="text/css" href="edu/jt/exg/css/ie/ie7.css" />
<![endif]-->
<!--[if IE 8]>
<link rel="stylesheet" type="text/css" href="edu/jt/exg/css/ie/ie8.css" />
<![endif]-->
<!--[if IE 9]>
<link rel="stylesheet" type="text/css" href="edu/jt/exg/css/ie/ie9.css" />
<![endif]-->
<!-- Jquery -->
<base href="<%=basePath%>">
<script src="edu/jt/exg/js/jquery-1.7.1.min.js"></script>
<script src="edu/jt/exg/js/jquery-ui-1.8.18.custom.min.js"></script>
<script src="edu/jt/exg/js/jquery.ui.touch-punch.js"></script>
<script src="edu/jt/exg/js/chosen.jquery.js"></script>
<script src="edu/jt/exg/js/uniform.jquery.js"></script>
<script src="edu/jt/exg/js/bootstrap-dropdown.js"></script>
<script src="edu/jt/exg/js/bootstrap-colorpicker.js"></script>
<script src="edu/jt/exg/js/sticky.full.js"></script>
<script src="edu/jt/exg/js/jquery.noty.js"></script>
<script src="edu/jt/exg/js/selectToUISlider.jQuery.js"></script>
<script src="edu/jt/exg/js/fg.menu.js"></script>
<script src="edu/jt/exg/js/jquery.tagsinput.js"></script>
<script src="edu/jt/exg/js/jquery.cleditor.js"></script>
<script src="edu/jt/exg/js/jquery.tipsy.js"></script>
<script src="edu/jt/exg/js/jquery.peity.js"></script>
<script src="edu/jt/exg/js/jquery.simplemodal.js"></script>
<script src="edu/jt/exg/js/jquery.jBreadCrumb.1.1.js"></script>
<script src="edu/jt/exg/js/jquery.colorbox-min.js"></script>
<script src="edu/jt/exg/js/jquery.idTabs.min.js"></script>
<script src="edu/jt/exg/js/jquery.multiFieldExtender.min.js"></script>
<script src="edu/jt/exg/js/jquery.confirm.js"></script>
<script src="edu/jt/exg/js/elfinder.min.js"></script>
<script src="edu/jt/exg/js/accordion.jquery.js"></script>
<script src="edu/jt/exg/js/autogrow.jquery.js"></script>
<script src="edu/jt/exg/js/check-all.jquery.js"></script>
<script src="edu/jt/exg/js/data-table.jquery.js"></script>
<script src="edu/jt/exg/js/ZeroClipboard.js"></script>
<script src="edu/jt/exg/js/TableTools.min.js"></script>
<script src="edu/jt/exg/js/jeditable.jquery.js"></script>
<script src="edu/jt/exg/js/duallist.jquery.js"></script>
<script src="edu/jt/exg/js/easing.jquery.js"></script>
<script src="edu/jt/exg/js/full-calendar.jquery.js"></script>
<script src="edu/jt/exg/js/input-limiter.jquery.js"></script>
<script src="edu/jt/exg/js/inputmask.jquery.js"></script>
<script src="edu/jt/exg/js/iphone-style-checkbox.jquery.js"></script>
<script src="edu/jt/exg/js/meta-data.jquery.js"></script>
<script src="edu/jt/exg/js/quicksand.jquery.js"></script>
<script src="edu/jt/exg/js/raty.jquery.js"></script>
<script src="edu/jt/exg/js/smart-wizard.jquery.js"></script>
<script src="edu/jt/exg/js/stepy.jquery.js"></script>
<script src="edu/jt/exg/js/treeview.jquery.js"></script>
<script src="edu/jt/exg/js/ui-accordion.jquery.js"></script>
<script src="edu/jt/exg/js/vaidation.jquery.js"></script>
<script src="edu/jt/exg/js/mosaic.1.0.1.min.js"></script>
<script src="edu/jt/exg/js/jquery.collapse.js"></script>
<script src="edu/jt/exg/js/jquery.cookie.js"></script>
<script src="edu/jt/exg/js/jquery.autocomplete.min.js"></script>
<script src="edu/jt/exg/js/localdata.js"></script>
<script src="edu/jt/exg/js/excanvas.min.js"></script>
<script src="edu/jt/exg/js/jquery.jqplot.min.js"></script>
<script src="edu/jt/exg/js/chart-plugins/jqplot.dateAxisRenderer.min.js"></script>
<script src="edu/jt/exg/js/chart-plugins/jqplot.cursor.min.js"></script>
<script src="edu/jt/exg/js/chart-plugins/jqplot.logAxisRenderer.min.js"></script>
<script src="edu/jt/exg/js/chart-plugins/jqplot.canvasTextRenderer.min.js"></script>
<script src="edu/jt/exg/js/chart-plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
<script src="edu/jt/exg/js/chart-plugins/jqplot.highlighter.min.js"></script>
<script src="edu/jt/exg/js/chart-plugins/jqplot.pieRenderer.min.js"></script>
<script src="edu/jt/exg/js/chart-plugins/jqplot.barRenderer.min.js"></script>
<script src="edu/jt/exg/js/chart-plugins/jqplot.categoryAxisRenderer.min.js"></script>
<script src="edu/jt/exg/js/chart-plugins/jqplot.pointLabels.min.js"></script>
<script src="edu/jt/exg/js/chart-plugins/jqplot.meterGaugeRenderer.min.js"></script>
<script src="edu/jt/exg/js/custom-scripts.js"></script>
	<!--必须先加载否则js中的jquery脚本会报错未定义-->
<%-- 	<script language="javascript" src="edu/jt/exg/js/jquery-1.11.1.js"></script> --%>
    <script language="javascript" src="edu/jt/exg/js/public.js"></script>
    <script language="javascript" src="edu/jt/exg/js/mgr_user.js"></script>

    <script language='javascript'>
	    $(function(){
	    	$(window).resize(function(){
				$('.login_container').css({
					position:'absolute',
					left: ($(window).width() - $('.login_container').outerWidth())/2,
					top: ($(window).height() - $('.login_container').outerHeight())/2
				});
			});
			// To initially run the function:
			$(window).resize();
	    	
		  	$("#form1").submit(function(){
		  		return checkFormForQuery();
			});
		  	
			$("#login").click(function(){
// 				setTimeout(function(){
					var ajaxFlag=false;//通过所有ajax验证的标志位
					var user=$("#user").val();
					var pass=$("#password").val();
					if(user!=null&&user!=undefined&&user!=""
							&&pass!=null&&pass!=undefined&&pass!=""){
						ShowDiv('fade');
						var data1=user+":"+pass;
				    	$.post("ValidationServlet","data="+data1+"&index=100&returnFlag=false",function(data,status){
				    		data=data.replace("\r\n","");
				    		if(data=='true'){
				    			ajaxFlag=true;
				    		}
							if(ajaxFlag==true){//只要=false就认为有验证不通过
								//防止重复提交
								window.location.href='<%=basePath%>Mgr_userAction.action?action=initquery';
							}else {
								$("#msg_box").fadeOut("slow");
								$("#msg_box").fadeIn("slow");
								HideDiv("fade");
							}
				    	});
					}
					
// 				}, 500);
				
			});
			

			
			$("#login").dblclick(function(){
				javascript:void(0);
			});
			
			$("#login").bind('focus mouseover', function(){
				$("#login").attr({"class":"login_btn blue_d"});
			});
			$("#login").bind('blur mouseout',function(){
				$("#login").attr({"class":"login_btn black_w"});
			});
			
		});
	    
	</script>
	<script type="text/javascript">
	function keyLogin(){  
		  if (event.keyCode==13)                         
		//按Enter键的键值为13  
		     document.getElementById("login").click(); 
		//调用登录按钮的登录事件  
		}  
	</script>
</head>
<body id="theme-default" class="full_block" onkeydown="keyLogin();">
	<div id="login_page">
		<div class="login_container" align="center">
			<img src="<%=basePath%>/edu/jt/exg/images/logo1.png" >
<!-- 			<div class="login_header black_w"> -->
<!-- 				<div class="header_left logo"> -->
<%-- 					<img src="<%=basePath%>/edu/jt/exg/images/logo1.png" height="50"> --%>
<!-- 				</div> -->
<!-- 			</div> -->
			<br><br><br><br>
			<s:form id="form1" name="form1">
			<div id="msg_box" class="login_invalid " style="display:none">
				<span class="icon"></span><s:text name="Login.UsernamePasswordAlert"/>
			</div>
			<div class="login_form">
				<h3 class="black_gel">管理员登录</h3>
				<ul>
					<li class="login_user">
						<s:textfield id="user" name="user" required="true" requiredposition="right"/>
					</li>
					<li class="login_pass">
						<s:password id="password" name="password"></s:password>
					</li>
				</ul>
			</div>
			</s:form>
	
			
			<button  id="login" class="login_btn black_w"><s:text name="Login.Login"/></button> 
<!-- 			<ul class="login_opt_link"> -->
<%-- 				<li><a href="forgot-pass.html"><s:text name="Login.ForgetPassword"/></a></li> --%>
<!-- 				<li class="remember_me right"> -->
<!-- 				<input name="" class="rem_me" type="checkbox" value="checked"> -->
<!-- 				记住密码</li> -->
<!-- 			</ul> -->
		</div>
	</div>
<div id="fade" class="black_overlay" style="text-align:center;">
<img src="<%=basePath%>/edu/jt/exg/images/loading51.gif" width="124" height="124" style=" margin-top:20%"></div>
<%@ include file="edu/jt/exg/html/TableMovingChangeColor.html"%>
</body>
</html>