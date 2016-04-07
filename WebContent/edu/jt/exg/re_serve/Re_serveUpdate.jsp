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
<title><s:text name="Re_serve.Title.update" /></title>
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
<script src="edu/jt/exg//js/re_serve.js"></script>
<%-- <script src="edu/jt/exg//js/common.js"></script> --%>
<script language="javascript">
$(function(){
	var location = (window.location+'').split('/'); 
	var bPath = location[0]+'//'+location[2]+'/'+location[3]; 
	
	var location = (window.location+'').split('/'); 
	var bPath = location[0]+'//'+location[2]+'/'+location[3]; 
	var dataSrc=bPath+$("#top_pic1").val();
	$("#mybox_1").append('<img src="'+dataSrc+'" >');
	
	var dataSrc=bPath+$("#pic1").val();
	$("#mybox1").append('<img src="'+dataSrc+'" >');
	
	var dataSrc=bPath+$("#pic2").val();
	$("#mybox2").append('<img src="'+dataSrc+'" >');
	
	var dataSrc=bPath+$("#pic3").val();
	$("#mybox3").append('<img src="'+dataSrc+'" >');
	
	var dataSrc=bPath+$("#pic4").val();
	$("#mybox4").append('<img src="'+dataSrc+'" >');
	
	var dataSrc=bPath+$("#pic5").val();
	$("#mybox5").append('<img src="'+dataSrc+'" >');
	
	//等待加载editor控件
	//************************************************************************************************************
	var ajaxFlag=true;//通过所有ajax验证的标志位
/* 	$("#publish_new").click(function(){
		if(checkFormForCreateOrUpdate()==true){
	    			var data1="";
	//所有需要ajax验证的都要在这里完成
			if(ajaxFlag==true){//只要=false就认为有验证不通过
				//防止重复提交
				ShowDiv('fade');
		$("#form1").attr("action", "Re_serveAction.action?action=create").submit();
			}else alert('<s:text name="Common.ValidationFailAlert"/>');
		}
	
	}); */
	$("#publish_new").click(function(){
		if(checkFormForCreateOrUpdate()==true){
		 	/* ShowDiv('zzz');  */
			$("#form1").attr("action", "Re_serveAction.action?action=update").submit();
		}
	});
	$("#back").click(function(){
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
							<div class="widget_wrap tabby">
								<div class="widget_top">
									<span class="h_icon blocks_images"></span>
									<h6>
										<s:text name="Re_serve.Title.update"></s:text>
									</h6>
								</div>
								<fieldset>
									<legend><s:text name="Common.basic" /></legend>
									<ul>
										<li class="clearfix">
											<div class="form_grid_6" style="display:none">
												<label class="field_title"><s:text
														name="Re_serve.Id" /><span class="req">*</span></label>
												<div class="form_input">
													<s:textfield id="id" name="id" maxlength="100" />
													<span id="id_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Re_serve.Serveid" /><span class="req">*</span></label>
												<div class="form_input">
													<s:textfield id="serveid" name="serveid" readonly="true" />
													<span id="serveid_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Re_serve.Name" /><span class="req">*</span></label>
												<div class="form_input">
													<s:textfield id="name" name="name" maxlength="100" />
													<span id="name_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Re_serve.Price" /></label>
												<div class="form_input">
													<s:textfield id="price" name="price" maxlength="100" />
													<span id="price_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Re_serve.Varieties" /><span class="req">*</span></label>
												<div class="form_input">
													<s:hidden id="varieties" name="varieties"></s:hidden>
													<s:checkbox id="varieties" name="varieties"/>
													<span id="varieties_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_12">
												<label class="field_title"><s:text
														name="Re_serve.Description" /><span class="req">*</span></label>
												<div class="form_input">
													<s:textarea id="description" name="description"
														cols="50" rows="2" cssClass="txt_editor"/>
													<span id="description_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_12">
												<label class="field_title"><s:text
														name="Re_serve.Top_pic1" /></label>
												<div class="form_input">
													<s:hidden id="top_pic1" name="top_pic1"></s:hidden>
													<div id="mybox_1"><div id="mybox_icon_1" ></div></div>
													<div id="box_1"><div id="box_icon_1" ></div></div>
												    <script type="text/javascript">
												    var dataSrc2=$("#top_pic1").val();
												    
												    dataSrc2=dataSrc2.split('/');
												    if(dataSrc2[3]!=null){
												    var s=dataSrc2[3].indexOf(".");
												    if(s==-1){
												    	dataSrc2[3]="";
												    }
												    }else{
												    	dataSrc2[3]="";
												    }
														$('#box_icon_1').diyUpload({
															
															url:'http://192.168.0.20/fileuploadserver/fileupload.php?category=product&filename='+dataSrc2[3],
															success:function( data ) {
															console.info( data );	
															/*  var location = (window.location+'').split('/'); 
												    		var bPath = location[0]+'//'+location[2]+'/'+location[3];  */
															for (var i = 0; i < data.length; i++) {
																var filepath = data[i].filepath;
																console.info( filepath );
																		 									 
																		 console.info( filepath );  
																		 $("#top_pic1").val(filepath); 
																}
																$("#top_pic1").val(filepath);
																										
															},
															error:function( err ) {
																console.info( err );	
															},
															fileNumLimit:1,
															fileSizeLimit:1200 * 600,
															fileSingleSizeLimit:1200 * 600
																							
														});
													</script>
													<span id="top_pic1_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_4">
												<label class="field_title"><s:text
														name="Re_serve.Pic1" /></label>
												<div class="form_input">
													<s:hidden id="pic1" name="pic1"></s:hidden>
														<div id="mybox1"><div id="mybox_icon1" ></div></div>
													<div id="box1"><div id="box_icon1" ></div></div>
												    <script type="text/javascript">
												    var dataSrc2=$("#pic1").val();
												    dataSrc2=dataSrc2.split('/');
												    if(dataSrc2[3]!=null){
													    var s=dataSrc2[3].indexOf(".");
													    if(s==-1){
													    	dataSrc2[3]="";
													    }
													    }else{
													    	dataSrc2[3]="";
													    }
														$('#box_icon1').diyUpload({
															
															url:'http://192.168.0.20/fileuploadserver/fileupload.php?category=product&filename='+dataSrc2[3],
															success:function( data ) {
															console.info( data );	
															/*  var location = (window.location+'').split('/'); 
												    		var bPath = location[0]+'//'+location[2]+'/'+location[3];  */
															for (var i = 0; i < data.length; i++) {
																var filepath = data[i].filepath;
																console.info( filepath );
																		 									 
																		 console.info( filepath );  
																		 $("#pic1").val(filepath); 
																}
																$("#pic1").val(filepath);
																										
															},
															error:function( err ) {
																console.info( err );	
															},
															fileNumLimit:1,
															fileSizeLimit:1200 * 600,
															fileSingleSizeLimit:1200 * 600
																							
														});
													</script>
													<span id="pic1_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_4">
												<label class="field_title"><s:text
														name="Re_serve.Pic2" /></label>
												<div class="form_input">
													<s:hidden id="pic2" name="pic2"></s:hidden>
													<div id="mybox2"><div id="mybox_icon2" ></div></div>
													<div id="box2"><div id="box_icon2" ></div></div>
												    <script type="text/javascript">
												    var dataSrc2=$("#pic2").val();
												    dataSrc2=dataSrc2.split('/');
												    if(dataSrc2[3]!=null){
													    var s=dataSrc2[3].indexOf(".");
													    if(s==-1){
													    	dataSrc2[3]="";
													    }
													    }else{
													    	dataSrc2[3]="";
													    }
														$('#box_icon2').diyUpload({
															
															url:'http://192.168.0.20/fileuploadserver/fileupload.php?category=product&filename='+dataSrc2[3],
															success:function( data ) {
															console.info( data );	
															/*  var location = (window.location+'').split('/'); 
												    		var bPath = location[0]+'//'+location[2]+'/'+location[3];  */
															for (var i = 0; i < data.length; i++) {
																var filepath = data[i].filepath;
																console.info( filepath );
																		 									 
																		 console.info( filepath );  
																		 $("#pic2").val(filepath); 
																}
																$("#pic2").val(filepath);
																										
															},
															error:function( err ) {
																console.info( err );	
															},
															fileNumLimit:1,
															fileSizeLimit:1200 * 600,
															fileSingleSizeLimit:1200 * 600
																							
														});
													</script>
													<span id="pic2_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_4">
												<label class="field_title"><s:text
														name="Re_serve.Pic3" /></label>
												<div class="form_input">
													<s:hidden id="pic3" name="pic3"></s:hidden>
													<div id="mybox3"><div id="mybox_icon3" ></div></div>
													<div id="box3"><div id="box_icon3" ></div></div>
												    <script type="text/javascript">
												    var dataSrc2=$("#pic3").val();
												    dataSrc2=dataSrc2.split('/');
												    if(dataSrc2[3]!=null){
													    var s=dataSrc2[3].indexOf(".");
													    if(s==-1){
													    	dataSrc2[3]="";
													    }
													    }else{
													    	dataSrc2[3]="";
													    }
														$('#box_icon3').diyUpload({
															
															url:'http://192.168.0.20/fileuploadserver/fileupload.php?category=product&filename='+dataSrc2[3],
															success:function( data ) {
															console.info( data );	
															/*  var location = (window.location+'').split('/'); 
												    		var bPath = location[0]+'//'+location[2]+'/'+location[3];  */
															for (var i = 0; i < data.length; i++) {
																var filepath = data[i].filepath;
																console.info( filepath );
																		 									 
																		 console.info( filepath );  
																		 $("#pic3").val(filepath); 
																}
																$("#pic3").val(filepath);
																										
															},
															error:function( err ) {
																console.info( err );	
															},
															fileNumLimit:1,
															fileSizeLimit:1200 * 600,
															fileSingleSizeLimit:1200 * 600
																							
														});
													</script>
													<span id="pic3_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_4">
												<label class="field_title"><s:text
														name="Re_serve.Pic4" /></label>
												<div class="form_input">
													<s:hidden id="pic4" name="pic4"></s:hidden>
													<div id="mybox4"><div id="mybox_icon4" ></div></div>
													<div id="box4"><div id="box_icon4" ></div></div>
												    <script type="text/javascript">
												    var dataSrc2=$("#pic4").val();
												    dataSrc2=dataSrc2.split('/');
												    if(dataSrc2[3]!=null){
													    var s=dataSrc2[3].indexOf(".");
													    if(s==-1){
													    	dataSrc2[3]="";
													    }
													    }else{
													    	dataSrc2[3]="";
													    }
														$('#box_icon4').diyUpload({
															
															url:'http://192.168.0.20/fileuploadserver/fileupload.php?category=product&filename='+dataSrc2[3],
															success:function( data ) {
															console.info( data );	
															/*  var location = (window.location+'').split('/'); 
												    		var bPath = location[0]+'//'+location[2]+'/'+location[3];  */
															for (var i = 0; i < data.length; i++) {
																var filepath = data[i].filepath;
																console.info( filepath );
																		 									 
																		 console.info( filepath );  
																		 $("#pic4").val(filepath); 
																}
																$("#pic4").val(filepath);
																										
															},
															error:function( err ) {
																console.info( err );	
															},
															fileNumLimit:1,
															fileSizeLimit:1200 * 600,
															fileSingleSizeLimit:1200 * 600
																							
														});
													</script>
													<span id="pic4_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_4">
												<label class="field_title"><s:text
														name="Re_serve.Pic5" /></label>
												<div class="form_input">
													<s:hidden id="pic5" name="pic5"></s:hidden>
													<div id="mybox5"><div id="mybox_icon5" ></div></div>
													<div id="box5"><div id="box_icon5" ></div></div>
												    <script type="text/javascript">
												    var dataSrc2=$("#pic5").val();
												    dataSrc2=dataSrc2.split('/');
												    if(dataSrc2[3]!=null){
													    var s=dataSrc2[3].indexOf(".");
													    if(s==-1){
													    	dataSrc2[3]="";
													    }
													    }else{
													    	dataSrc2[3]="";
													    }
														$('#box_icon5').diyUpload({
															
															url:'http://192.168.0.20/fileuploadserver/fileupload.php?category=product&filename='+dataSrc2[3],
															success:function( data ) {
															console.info( data );	
															/*  var location = (window.location+'').split('/'); 
												    		var bPath = location[0]+'//'+location[2]+'/'+location[3];  */
															for (var i = 0; i < data.length; i++) {
																var filepath = data[i].filepath;
																console.info( filepath );
																		 									 
																		 console.info( filepath );  
																		 $("#pic5").val(filepath); 
																}
																$("#pic5").val(filepath);
																										
															},
															error:function( err ) {
																console.info( err );	
															},
															fileNumLimit:1,
															fileSizeLimit:1200 * 600,
															fileSingleSizeLimit:1200 * 600
																							
														});
													</script>
													<span id="pic5_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Re_serve.Yubei1" /></label>
												<div class="form_input">
													<s:textfield id="yubei1" name="yubei1" maxlength="100" />
													<span id="yubei1_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Re_serve.Yubei2" /></label>
												<div class="form_input">
													<s:textfield id="yubei2" name="yubei2" maxlength="100" />
													<span id="yubei2_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Re_serve.Yubei3" /></label>
												<div class="form_input">
													<s:textfield id="yubei3" name="yubei3" maxlength="100" />
													<span id="yubei3_valid" class="red">&nbsp;</span>
												</div>
											</div>
											<div class="form_grid_6">
												<label class="field_title"><s:text name="Re_serve.Display" /></label>
												<div class="form_input">
													<s:textfield id="display" name="display" maxlength="100" />
													<span id="display_valid" class="red">&nbsp;</span>
												</div>
											</div>
										</li>
										<li class="clearfix">
											<div class="form_grid_6">
												<label class="field_title"><s:text
														name="Re_serve.Invalid" /><span class="req">*</span></label>
												<div class="form_input">
													<s:hidden id="invalid" name="invalid"></s:hidden>
													<s:select id="invalidSelect" name="invalidSelect"
														list="invalidMap" cssClass="chzn-select"
														style=" width:200px" />
													<br> <span id="invalid_valid" class="red">&nbsp;</span>
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
		<div id="zz" class="black_overlay12" style="text-align: center;"><%-- 
			<img src="<%=basePath%>/edu/jt/exg//images/loading51.gif" width="124"
				height="124" style="margin-top: 20%"> --%>
		</div>
	</div>
</body>
</html>