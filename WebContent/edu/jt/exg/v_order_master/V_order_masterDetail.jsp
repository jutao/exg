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
<title><s:text name="V_order_master.Title.detail" /></title>
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<!--     <LINK href="../theme/style.css" rel="stylesheet" type="text/css"> -->
<link href="<%=basePath%>edu/jt/exg//css/reset.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/layout.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/themes.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/typography.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/styles.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/shCore.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/jquery.jqplot.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/jquery-ui-1.8.18.custom.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/data-table.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/form.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/ui-elements.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/wizard.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/sprite.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg//css/gradient.css" rel="stylesheet"
	type="text/css">
<!--[if IE 7]>
<link rel="stylesheet" type="text/css" href="edu/jt/exg//css/ie/ie7.css" />
<![endif]-->
<!--[if IE 8]>
<link rel="stylesheet" type="text/css" href="edu/jt/exg//css/ie/ie8.css" />
<![endif]-->
<!--[if IE 9]>
<link rel="stylesheet" type="text/css" href="edu/jt/exg//css/ie/ie9.css" />
<![endif]-->
<base href="<%=basePath%>">
<script type="text/javascript"
	src="<%=basePath%>edu/jt/exg//js/jsAddress.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery-1.7.1.min.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery-ui-1.8.18.custom.min.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.ui.touch-punch.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/chosen.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/bootstrap-dropdown.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/bootstrap-colorpicker.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/sticky.full.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.noty.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/selectToUISlider.jQuery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/fg.menu.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.tagsinput.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.cleditor.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.tipsy.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.peity.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.simplemodal.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.jBreadCrumb.1.1.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.colorbox-min.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.idTabs.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/jquery.multiFieldExtender.min.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.confirm.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/elfinder.min.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/accordion.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/autogrow.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/check-all.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/data-table.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/ZeroClipboard.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/TableTools.min.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jeditable.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/duallist.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/easing.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/full-calendar.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/input-limiter.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/inputmask.jquery.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/iphone-style-checkbox.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/meta-data.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/quicksand.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/raty.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/smart-wizard.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/stepy.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/treeview.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/ui-accordion.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/vaidation.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/mosaic.1.0.1.min.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.collapse.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.cookie.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.autocomplete.min.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/localdata.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/excanvas.min.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/jquery.jqplot.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/chart-plugins/jqplot.dateAxisRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/chart-plugins/jqplot.cursor.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/chart-plugins/jqplot.logAxisRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/chart-plugins/jqplot.canvasTextRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/chart-plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/chart-plugins/jqplot.highlighter.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/chart-plugins/jqplot.pieRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/chart-plugins/jqplot.barRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/chart-plugins/jqplot.categoryAxisRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/chart-plugins/jqplot.pointLabels.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg//js/chart-plugins/jqplot.meterGaugeRenderer.min.js"></script>
<script src="<%=basePath%>edu/jt/exg//js/custom-scripts.js"></script>
<!--必须先加载否则js中的jquery脚本会报错未定义-->
<%-- <script src="edu/jt/exg//js/jquery-1.11.1.js"></script> --%>
<script src="edu/jt/exg//js/public.js"></script>
<script src="edu/jt/exg//js/v_order_master.js"></script>
<%-- <script src="edu/jt/exg//js/common.js"></script> --%>
<script language="javascript">
$(function(){
	var location = (window.location+'').split('/'); 
	var bPath = location[0]+'//'+location[2]+'/'+location[3]; 
	var pic = document.getElementById("req_icon1");
	pic.src = bPath+$("#req_icon").val();
	
	var pic = document.getElementById("outcome_image11");
	pic.src = bPath+$("#outcome_image1").val();
	
	var pic = document.getElementById("outcome_image21");
	pic.src = bPath+$("#outcome_image2").val();
	
	var pic = document.getElementById("outcome_image31");
	pic.src = bPath+$("#outcome_image3").val();
	//等待加载editor控件
	//************************************************************************************************************
	var ajaxFlag=true;//通过所有ajax验证的标志位
	$("#publish_new").click(function(){
		if(checkFormForCreateOrUpdate()==true){
	    			var data1="";
	//所有需要ajax验证的都要在这里完成
			if(ajaxFlag==true){//只要=false就认为有验证不通过
				//防止重复提交
				ShowDiv('fade');
		$("#form1").attr("action", "V_order_masterAction.action?action=create").submit();
			}else alert('<s:text name="Common.ValidationFailAlert"/>');
		}
	
	});
	$("#save_draft").click(function(){
		if(checkFormForCreateOrUpdate()==true){
			$("#status").val("10");
			ShowDiv('fade');
			$("#form1").attr("action", "V_order_masterAction.action?action=create").submit();
		}
	});
	$("#publish_new").click(function(){
		if(checkFormForCreateOrUpdate()==true){
			$("#status").val("20");
			ShowDiv('fade');
			$("#form1").attr("action", "V_order_masterAction.action?action=create").submit();
		}
	});
	$("#back").click(function(){
		<%-- window.location.href='<%=basePath%>V_order_masterAction.action?action=initquery'; --%>
		window.history.back(-1);
				});
	});
</script>
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
										<s:text name="V_order_master.Title.detail"></s:text>
									</h6>
								</div>
								<fieldset>
									<legend>
										<s:text name="Common.basic" />
									</legend>
									<ul>

										<li class="clearfix">
											<div class="form_grid_4">
												<label class="field_title"><s:text
														name="V_order_master.Req_icon" /></label>
												<div class="form_input">
													<s:hidden id="req_icon" name="req_icon"></s:hidden>
													<img id="req_icon1" alt="" src=""> <span
														id="req_icon1_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="V_order_master.Orderid" /></label>
												<div class="form_input">
													<s:textfield id="orderid" name="orderid" readonly="true" />
													<span id="orderid_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="V_order_master.Repair_userkey" /></label>
												<div class="form_input">
													<s:textfield id="repair_userkey" name="repair_userkey"
														readonly="true" />
													<span id="repair_userkey_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="V_order_master.Outcome" /> </label>
												<div class="form_input">
													<s:textfield id="outcome" name="outcome" readonly="true" />
													<span id="outcome_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="V_order_master.Req_name" /> </label>
												<div class="form_input">
													<s:textfield id="req_name" name="req_name" readonly="true" />
													<span id="req_name_valid" class="red">&nbsp;</span>
												</div>
											</div>

										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="V_order_master.Req_id" /> </label>
												<div class="form_input">
													<s:textfield id="req_id" name="req_id" readonly="true" />
													<span id="req_id_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="V_order_master.Status" /> </label>
												<div class="form_input">
													<s:textfield id="status" name="status" readonly="true" />
													<span id="status_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="V_order_master.Invalid" /> </label>
												<div class="form_input">
													<s:textfield id="invalid" name="invalid" readonly="true" />
													<br> <span id="invalid_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_4">
												<label class="field_title"><s:text
														name="V_order_master.Outcome_image1" /></label>
												<div class="form_input">
													<s:hidden id="outcome_image1" name="outcome_image1"></s:hidden>
													<img id="outcome_image11" alt="" src=""> <span
														id="outcome_image11_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_4">
												<label class="field_title"><s:text
														name="V_order_master.Outcome_image2" /></label>
												<div class="form_input">
													<s:hidden id="outcome_image2" name="outcome_image2"></s:hidden>
													<img id="outcome_image21" alt="" src=""> <span
														id="outcome_image21_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_4">
												<label class="field_title"><s:text
														name="V_order_master.Outcome_image3" /></label>
												<div class="form_input">
													<s:hidden id="outcome_image3" name="outcome_image3"></s:hidden>
													<img id="outcome_image31" alt="" src=""> <span
														id="outcome_image31_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>

										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="V_order_master.Register_time" /> </label>
												<div class="form_input">
													<s:date name="register_time" format="yyyy-MM-dd hh:mm:ss" />
													<span id="register_time_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="V_order_master.Update_time" /> </label>
												<div class="form_input">
													<s:date name="update_time" format="yyyy-MM-dd hh:mm:ss" />
													<span id="update_time_valid" class="red">&nbsp;</span>
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
		<div id="fade" class="black_overlay" style="text-align: center;">
			<img src="<%=basePath%>/edu/jt/exg//images/loading51.gif" width="124"
				height="124" style="margin-top: 20%">
		</div>
	</div>
</body>
</html>