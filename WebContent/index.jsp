<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>exg</title>
<meta http-equiv="refresh" content="0; url=<%=basePath %>LoginAction.action" />
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
</head>
<body id="theme-default" class="full_block">
	
	<div id="login_page">
		<div class="login_container">
		</div>
	</div>
</body>
</html>