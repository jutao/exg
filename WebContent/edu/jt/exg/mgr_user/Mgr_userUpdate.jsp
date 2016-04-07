<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<%-- <%@ taglib prefix="sx" uri="/struts-dojo-tags"%> --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String userName = (String) (request.getSession()
			.getAttribute("userName"));
%>
<html>
<head>
<title><s:text name="Mgr_user.Title_update" /></title>
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<!--     <LINK href="../theme/style.css" rel="stylesheet" type="text/css"> -->

<link href="<%=basePath%>edu/jt/exg/css/reset.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/layout.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/themes.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/typography.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/styles.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/shCore.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/jquery.jqplot.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/jquery-ui-1.8.18.custom.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/data-table.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/form.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/ui-elements.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/wizard.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/sprite.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/gradient.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>edu/jt/exg/css/webuploader.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>edu/jt/exg/css/diyUpload.css">
<!--[if IE 7]>
<link rel="stylesheet" type="text/css" href="edu/jt/exg/css/ie/ie7.css" />
<![endif]-->
<!--[if IE 8]>
<link rel="stylesheet" type="text/css" href="edu/jt/exg/css/ie/ie8.css" />
<![endif]-->
<!--[if IE 9]>
<link rel="stylesheet" type="text/css" href="edu/jt/exg/css/ie/ie9.css" />
<![endif]-->

<base href="<%=basePath%>">
<script type="text/javascript" src="<%=basePath%>edu/jt/exg/js/jsAddress.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery-1.7.1.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery-ui-1.8.18.custom.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.ui.touch-punch.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/chosen.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/bootstrap-dropdown.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/bootstrap-colorpicker.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/sticky.full.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.noty.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/selectToUISlider.jQuery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/fg.menu.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.tagsinput.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.cleditor.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.tipsy.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.peity.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.simplemodal.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.jBreadCrumb.1.1.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.colorbox-min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.idTabs.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/jquery.multiFieldExtender.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.confirm.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/elfinder.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/accordion.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/autogrow.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/check-all.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/data-table.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/ZeroClipboard.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/TableTools.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jeditable.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/duallist.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/easing.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/full-calendar.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/input-limiter.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/inputmask.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/iphone-style-checkbox.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/meta-data.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/quicksand.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/raty.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/smart-wizard.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/stepy.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/treeview.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/ui-accordion.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/vaidation.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/mosaic.1.0.1.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.collapse.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.cookie.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.autocomplete.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/localdata.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/excanvas.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.jqplot.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.dateAxisRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.cursor.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.logAxisRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.canvasTextRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.highlighter.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.pieRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.barRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.categoryAxisRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.pointLabels.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.meterGaugeRenderer.min.js"></script>
	<script	src="<%=basePath%>edu/jt/exg/js/webuploader.html5only.min.js"></script>
<script	src="<%=basePath%>edu/jt/exg/js/diyUpload.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/custom-scripts.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.validate.js"></script>
<!--必须先加载否则js中的jquery脚本会报错未定义-->
<%-- <script src="edu/jt/exg/js/jquery-1.11.1.js"></script> --%>
<script src="edu/jt/exg/js/public.js"></script>
<script src="edu/jt/exg/js/mgr_user.js"></script>
<%-- <script src="edu/jt/exg/js/mgr_user_zz.js"></script> --%>
<%-- <script src="edu/jt/exg/js/common.js"></script> --%>

</head>
<body id="theme-default" class="full_block">
<s:include value="../common/header.jsp" />
	<s:include value="../common/left_bar.jsp" />
	<div id="container">
		
		<div style="overflow: hidden; background-color: #FFF;">
			<div class="page_title gray_sai">
				<div class="top_search">
					<ul id="search_box">
						<li style="margin-left: 10px;">
							<button id="publish_new" name="publish_new"
								class="btn_small btn_blue">
								<s:text name="Action_publish_new" />
							</button>
						</li>
						<li style="margin-left: 10px;">
							<button id="back" name="back" class="btn_small btn_gray">
								<s:text name="Common.Back" />
							</button>
						</li>
					</ul>
				</div>
			</div>
			<div id="content">
				<div class="grid_container">
					<div class="grid_12 form_container left_label field_set">
						<s:form id="form1" name="form1" action="" namespace="/">
							<s:hidden id="status" name="status" />
							<div class="widget_wrap tabby">
								<div class="widget_top">
									<span class="h_icon blocks_images"></span>
									<h6>
										<s:text name="Mgr_user.Title_update"></s:text>
									</h6>
								</div>
								<fieldset>
									<legend><s:text name="Common.basic" /></legend>
									<ul>
										<li class="clearfix">
											<div class="form_grid_6" style="display: none">
													<label class="field_title"><s:text name="Mgr_user.Id" /><span class="req">*</span></label>
													<div class="form_input">
														<s:textfield id="id" name="id" maxlength="100" />
														<span id="id_valid" class="red">&nbsp;</span>
													</div>
											</div>
											<div class="form_grid_6">
													<label class="field_title"><s:text name="Mgr_user.Userid" /><span class="req">*</span></label>
													<div class="form_input">
														<s:textfield id="userid" name="userid" maxlength="100" />
														<span id="userid_valid" class="red">&nbsp;</span>
													</div>
											</div>
											<%-- <div class="form_grid_6">
													<label class="field_title"><s:text name="Mgr_user.Usertype" /><span class="req">*</span></label>
													<div class="form_input">
														<s:textfield id="usertype" name="usertype" maxlength="100" />
														<span id="usertype_valid" class="red">&nbsp;</span>
													</div>
											</div> --%>
											<div class="form_grid_6">
												<label class="field_title"><s:text name="Mgr_user.Usertype" /><span class="req">*</span></label>
												<div class="form_input">
													<s:hidden id="usertype" name="usertype"></s:hidden>
													<s:select id="usertypeSelect" name="usertypeSelect"
														list="usertypeMap" cssClass="chzn-select"
														style=" width:200px" />
													<span id="usertype_valid" class="red">&nbsp;</span>
												</div>
											</div> 
										</li>
										
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Mgr_user.Name" /></label>
												<div class="form_input">
													<s:textfield id="name" name="name" maxlength="100"/>
													<span id="name_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Mgr_user.Login_password" /></label>
												<div class="form_input">
													<s:textfield id="login_password" name="login_password"
														cssClass="text" maxlength="100"/>
													<span id="login_password_valid" class="red">&nbsp;</span>
												</div>
											</div>
											
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Mgr_user.Yubei1" /></label>
												<div class="form_input">
													<s:textfield id="yubei1" name="yubei1" maxlength="100"/>
													<span id="yubei1_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Mgr_user.Yubei2" /></label>
												<div class="form_input">
													<s:textfield id="yubei2" name="yubei2" maxlength="100" />
													<span id="yubei2_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>

										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Mgr_user.Yubei3" /></label>
												<div class="form_input">
													<s:textfield id="yubei3" name="yubei3" maxlength="100"/>
													<span id="yubei3_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Mgr_user.Invalid" /><span class="req">*</span></label>
												<div class="form_input">
													<s:hidden id="invalid" name="invalid"></s:hidden>
													<s:select id="invalidSelect" name="invalidSelect"
														list="invalidMap" cssClass="chzn-select"
														style=" width:200px" />
													<span id="invalid_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
									</ul>
								</fieldset>
							</div>
						</s:form>
					</div>
				</div>
			</div>
		</div>
		<div id="zzz" class="black_overlay12" style="text-align: center;"><%-- 
			<img src="<%=basePath%>/edu/jt/exg/images/loading51.gif" width="124"
				height="124" style="margin-top: 20%"> --%>
		</div>
	</div>
</body>
<script language="javascript">
$(function(){
	var ajaxFlag=true;//通过所有ajax验证的标志位

	
	$("#publish_new").click(function(){
		if(checkFormForCreateOrUpdate()==true){
			ShowDiv('zzz');
			$("#form1").attr("action", "Mgr_userAction.action?action=update").submit();
		}
	});

	$("#back").click(function(){
		window.history.back(-1);
				});
});
</script>
</html>