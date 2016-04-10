function requireCheck(elem) {

	var must = $("#" + elem).val();
	must = trim(must);
	if (must == undefined || must == '') {
		$("#" + elem + "_valid").text("必填项！");
		$("#" + elem).focus();
		return false
	} else {
		$("#" + elem + "_valid").text(" ");
		return true;
	}
}
function checkFormForCreateOrUpdate() {
	var flg = true;
	// s:select处理
	$("#usertype").val($("#usertypeSelect").find("option:selected").val());
	$("#gender").val($("#genderSelect").find("option:selected").val());
	$("#address_province").val(
			$("#address_provinceSelect").find("option:selected").val());
	$("#address_city").val(
			$("#address_citySelect").find("option:selected").val());
	$("#address_area").val(
			$("#address_areaSelect").find("option:selected").val());
	$("#occupation").val($("#occupationSelect").find("option:selected").val());
	$("#bankname").val($("#banknameSelect").find("option:selected").val());
	$("#bank_provinces_citiesSelect").val(
			$("#bank_provinces_cities").find("option:selected").val());
	$("#invalid").val($("#invalidSelect").find("option:selected").val());

	// 必须填
	if (!requireCheck("userid")) {
		return false;
	} //
	if (!requireCheck("usertype")) {
		return false;
	} //
	if (!requireCheck("invalid")) {
		return false;
	} // 有效无效区分
	return true;
}

function checkFormForQuery() {
	// s:select处理
	$("#usertype").val($("#usertypeSelect").find("option:selected").val());
	$("#gender").val($("#genderSelect").find("option:selected").val());
	$("#address_province").val(
			$("#address_provinceSelect").find("option:selected").val());
	if ($("#address_citySelect").find("option:selected").val() != "0")
		$("#address_city").val(
				$("#address_citySelect").find("option:selected").val());
	if ($("#address_areaSelect").find("option:selected").val() != "0")
		$("#address_area").val(
				$("#address_areaSelect").find("option:selected").val());
	$("#occupation").val($("#occupationSelect").find("option:selected").val());
	$("#bankname").val($("#banknameSelect").find("option:selected").val());
	$("#bank_provinces_citiesSelect").val(
			$("#bank_provinces_cities").find("option:selected").val());
	$("#invalid").val($("#invalidSelect").find("option:selected").val());


	return true;
}

$(function() {

	$("#logout").click(function() {
		window.location.href = 'LoginAction.action?action=logout';
	});
});


function finder() {
	if (checkFormForQuery() == true) {
		$("#start").val('0');
		var form = $("#form1");
		$("#trid").css('display', 'none');
		$("#load").css('display', '');
		form.submit();
	}
}

function submit(formId, actionStr) {
	$("#trid").css('display', 'none');
	$("#load").css('display', '');
	$("#" + formId).attr("action", actionStr).submit();
}