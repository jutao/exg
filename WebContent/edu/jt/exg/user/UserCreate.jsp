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
<title><s:text name="User.Title_create" /></title>
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
<link href="<%=basePath%>edu/jt/exg//css/typography.css" rel="stylesheet"
	type="text/css">
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
<link href="<%=basePath%>edu/jt/exg//css/data-table.css" rel="stylesheet"
	type="text/css">
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
<link rel="stylesheet" type="text/css" href="<%=basePath%>edu/jt/exg//css/webuploader.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>edu/jt/exg//css/diyUpload.css">
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
<script type="text/javascript" src="<%=basePath%>edu/jt/exg//js/jsAddress.js"></script>
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
<script src="<%=basePath%>edu/jt/exg//js/iphone-style-checkbox.jquery.js"></script>
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
<script src="<%=basePath%>edu/jt/exg//js/jquery.validate.js"></script>
<script	src="<%=basePath%>edu/jt/exg//js/webuploader.html5only.min.js"></script>
<script	src="<%=basePath%>edu/jt/exg//js/diyUpload.js"></script>
<!--必须先加载否则js中的jquery脚本会报错未定义-->
<%-- <script src="edu/jt/exg//js/jquery-1.11.1.js"></script> --%>
<script src="edu/jt/exg//js/public.js"></script>
<script src="edu/jt/exg//js/user.js"></script>
<script src="edu/jt/exg//js/user_zz.js"></script>
<%-- <script src="edu/jt/exg//js/common.js"></script> --%>


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
										<s:text name="User.Title_create"></s:text>
									</h6>
								</div>
								<fieldset>
									<legend>
										<s:text name="Common.basic" />
									</legend>
									<ul>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Icon" /><span class="req">*</span></label>
												<s:hidden id="icon" name="icon"></s:hidden>
												<div id="box"><div id="box_icon" ></div></div>
											    <script type="text/javascript">
													$('#box_icon').diyUpload({
														url:'http://192.168.0.20/fileuploadserver/fileupload.php?category=icon&filename=',
														success:function( data ) {
														console.info( data );	
														 var location = (window.location+'').split('/'); 
											    		var bPath = location[0]+'//'+location[2]+'/'+location[3]; 
											    		
														for (var i = 0; i < data.length; i++) {
															var filepath = data[i].filepath;
															console.info( filepath );
																	 									 
																	 /* filepath= bPath+filepath; */
																	 console.info( filepath );  
																	 $("#icon").val(filepath); 
															}
															$("#icon").val(filepath);
																									
														},
														error:function( err ) {
															console.info( err );	
														},
														<%-- server:"<%=basePath%>", --%>
														fileNumLimit:1,
														fileSizeLimit:170 * 150,
														fileSingleSizeLimit:170 * 150
																						
													});
												</script>
												<span id="icon_valid" class="red">&nbsp;</span>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Level" /><span class="req">*</span></label>
												<div class="form_input">
													<s:textfield id="level" name="level" maxlength="100" />
													<span id="level_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Userid" /><span class="req">*</span></label>
												<div class="form_input">
													<s:textfield id="userid" name="userid" maxlength="100" />
													<span id="userid_valid" class="red">&nbsp;</span>
												</div>
											</div>
											
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Name" /></label>
												<div class="form_input">
													<s:textfield id="name" name="name" maxlength="100" />
													<span id="name_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Nickname" /></label>
												<div class="form_input">
													<s:textfield id="nickname" name="nickname" maxlength="10"/>
													<span id="nickname_valid" class="red">&nbsp;</span>
												</div>
											</div>
										
										</li>
										<li class="clearfix">
												<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Id_number" /></label>
												<div class="form_input">
													<s:textfield id="id_number" name="id_number"
														maxlength="100" />
													<span id="id_number_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Email" /></label>
												<div class="form_input">
													<s:textfield id="email" name="email"
														maxlength="100" />
													<span id="email_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Gender" /></label>
												<div class="form_input">
													<s:hidden id="gender" name="gender"></s:hidden>
													<s:select id="genderSelect" name="genderSelect"
														list="genderMap" cssClass="chzn-select"
														style=" width:200px" />
													<span id="gender_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Category" /></label>
												<div class="form_input">
													<s:hidden id="category" name="category"></s:hidden>
													<s:select id="categorySelect" name="categorySelect"
														list="categoryMap" cssClass="chzn-select"
														style=" width:200px" />
													<span id="category_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Usertype" /></label>
												<div class="form_input">
													<s:hidden id="usertype" name="usertype"></s:hidden>
													<s:checkboxlist id="usertypecheck" name="usertypecheck" list="usertypeMap" value="usertypeList"/>
													<span id="usertype_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Qualificat" /><span class="req">*</span></label>
												<s:hidden id="qualificat" name="qualificat"></s:hidden>
												<div id="box1"><div id="box1_icon" ></div></div>
											    <script type="text/javascript">
													$('#box1_icon').diyUpload({
														url:'http://192.168.0.20/fileuploadserver/fileupload.php?category=icon&filename=',
														success:function( data ) {
														console.info( data );	
														 var location = (window.location+'').split('/'); 
											    		var bPath = location[0]+'//'+location[2]+'/'+location[3]; 
											    		
														for (var i = 0; i < data.length; i++) {
															var filepath = data[i].filepath;
															console.info( filepath );
																	 									 
																	 /* filepath= bPath+filepath; */
																	 console.info( filepath );  
																	 $("#qualificat").val(filepath); 
															}
															$("#qualificat").val(filepath);
																									
														},
														error:function( err ) {
															console.info( err );	
														},
														<%-- server:"<%=basePath%>", --%>
														fileNumLimit:1,
														fileSizeLimit:170 * 150,
														fileSingleSizeLimit:170 * 150
																						
													});
												</script>
												<span id="qualificat_valid" class="red">&nbsp;</span>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Interest" /></label>
												<div class="form_input">
													<s:textfield id="interest" name="interest" maxlength="100" />
													<span id="interest_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Occupation" /></label>
												<div class="form_input">
													<s:textfield id="occupation" name="occupation" maxlength="100" />
													<span id="occupation_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6" style="display:none">
												<label class="field_title"><s:text
														name="User.AdressJson" /></label>
												<div class="form_input" >
													<s:textfield id="adressJson" name="adressJson"
														maxlength="100" />
													<span id="adressJson_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Address_province" /></label>
												<div class="form_input">
													<s:hidden id="address_province" name="address_province"></s:hidden>
													<s:select id="address_provinceSelect" name="address_provinceSelect"
														list="address_provinceMap" cssClass="chzn-select"
														style=" width:200px" />
													<br> <span id="address_province_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Address_city" /></label>
												<div class="form_input">
													<s:hidden id="address_city" name="address_city"></s:hidden>
													<s:select id="address_citySelect" name="address_citySelect"
														list="address_cityMap" cssClass="chzn-select"
														style=" width:200px" />
													<br> <span id="address_city_valid" class="red">&nbsp;</span>
												</div>
											</div> 
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Address_area" /></label>
												<div class="form_input">
													<s:hidden id="address_area" name="address_area"></s:hidden>
													<s:select id="address_areaSelect" name="address_areaSelect"
														list="address_areaMap" cssClass="chzn-select"
														style=" width:200px" />
													<br> <span id="address_area_valid" class="red">&nbsp;</span>
												</div>
											</div> 
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Address_details" /></label>
												<div class="form_input">
													<s:textfield id="address_details" name="address_details"
														maxlength="100" />
													<span id="address_details_valid" class="red">&nbsp;</span>
												</div>
											</div>

										</li>

										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Hometown" /></label>
												<div class="form_input">
													<s:textfield id="hometown" name="hometown"
														maxlength="100" />
													<span id="hometown_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Recommender_code" /></label>
												<div class="form_input">
													<s:textfield id="recommender_code" name="recommender_code"
														maxlength="100" />
													<span id="recommender_code_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Yubei1" /></label>
												<div class="form_input">
													<s:textfield id="yubei1" name="yubei1" maxlength="100" />
													<span id="yubei1_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Yubei2" /></label>
												<div class="form_input">
													<s:textfield id="yubei2" name="yubei2" maxlength="100" />
													<span id="yubei2_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>

										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Yubei3" /></label>
												<div class="form_input">
													<s:textfield id="yubei3" name="yubei3" maxlength="100" />
													<span id="yubei3_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Invalid" /><span class="req">*</span></label>
												<div class="form_input">
													<s:hidden id="invalid" name="invalid"></s:hidden>
													<s:select id="invalidSelect" name="invalidSelect"
														list="invalidMap" cssClass="chzn-select"
														value="0" style=" width:200px" />
													
													<span id="invalid_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
									</ul>
								</fieldset>

								<fieldset>
									<legend>
										<s:text name="Common.account"></s:text>
									</legend>
									<ul>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Balance" /></label>
												<div class="form_input">
													<s:textfield id="balance" name="balance"
														cssClass="moneytype" maxlength="12" style="width:200">
														<s:param name="value">
															<f:formatNumber type="number" value="${balance}"
																pattern="#,##0.00#" />
														</s:param>
													</s:textfield>
													<span id="balance_valid" class="red">&nbsp;</span>
												</div>
											</div>

											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Point" /></label>
												<div class="form_input">
													<s:textfield id="point" name="point" maxlength="100" />
													<%-- <s:textfield id="point" name="point" cssClass="moneytype"
														maxlength="12" style="width:200">
														<s:param name="value">
															<f:formatNumber type="number" value="${point}"
																pattern="#,##0.00#" />
														</s:param>
													</s:textfield> --%>
													<span id="point_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
									</ul>
								</fieldset>

								<fieldset>
									<legend>
										<s:text name="Common.bank"></s:text>
									</legend>
									<ul>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Bankname" /></label>
												<div class="form_input">
													<s:hidden id="bankname" name="bankname"></s:hidden>
													<s:select id="banknameSelect" name="banknameSelect"
														list="banknameMap" cssClass="chzn-select"
														style=" width:200px" />
													<span id="bankname_valid" class="red">&nbsp;</span>
												</div>
											</div>

											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Card_number" /></label>
												<div class="form_input">
													<s:textfield id="card_number" name="card_number"
														maxlength="100" />
													<span id="card_number_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Bank_branch" /></label>
												<div class="form_input">
													<s:textfield id="bank_branch" name="bank_branch"
														maxlength="100" />
													<span id="bank_branch_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
									</ul>
								</fieldset>

								<fieldset>
									<legend>
										<s:text name="Common.password"></s:text>
									</legend>
									<ul>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Login_password" /></label>
												<div class="form_input">
													<s:textfield id="login_password" name="login_password"
														cssClass="text" size="10" />
													<span id="login_password_valid" class="red">&nbsp;</span>
												</div>
											</div>

											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Gesture_password" /></label>
												<div class="form_input">
													<s:textfield id="gesture_password" name="gesture_password"
														cssClass="text" size="10" />
													<span id="gesture_password_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="User.Trading_password" /></label>
												<div class="form_input">
													<s:textfield id="trading_password" name="trading_password"
														maxlength="100" />
													<span id="trading_password_valid" class="red">&nbsp;</span>
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
	</div>
	<div id="zzz" class="black_overlay12" style="text-align: center;"><%-- 
		<img src="<%=basePath%>/edu/jt/exg//images/loading51.gif" width="124"
			height="124" style="margin-top: 20%"> --%>
	</div>
</body>
<script language="javascript">
$(function(){
	//等待加载editor控件
	//************************************************************************************************************
	var ajaxFlag=true;//通过所有ajax验证的标志位

	$("#publish_new").click(function(){
		if(checkFormForCreateOrUpdate()==true){
			ShowDiv('zzz');
			$("#form1").attr("action", "UserAction.action?action=create").submit();
		}
	});

	
	$("#back").click(function(){
		<%-- window.location.href='<%=basePath%>UserAction.action?action=initquery'; --%>
		window.history.back(-1);
				});
});
</script>
</html>