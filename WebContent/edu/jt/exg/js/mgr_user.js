
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

	//必须填
	if (!requireCheck("userid")) {return false;} //
	if (!requireCheck("usertype")) {return false;} //
	if (!requireCheck("invalid")) {return false;} //有效无效区分

	// editor处理
	// 上传处理
	/*
	 * if (navigator.userAgent.indexOf("Firefox") > 0) {
	 * document.getElementById("icon").value = document
	 * .getElementById("iconFileUpload").contentDocument
	 * .getElementById("saveFiles").value; } else {
	 * document.getElementById("icon").value =
	 * window.frames["iconFileUpload"].document
	 * .getElementById("saveFiles").value; }
	 */

	// s:optiontransferselect处理
	// 手动timestamp的时、分处理
	return true;
}

function checkFormForQuery() {
	/*
	 * var flg=true; // 邮箱 var email = $("#email").val(); email = trim(email);
	 * var filter =
	 * /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; if
	 * (email != '') { if (filter.test(email)) { flg=true; } else {
	 * alert('您的电子邮件格式不正确'); return false; } } // 正整数 var userid =
	 * $("#userid").val(); userid = trim(userid); var type = /^1\d{10}$/; var re =
	 * new RegExp(type); if (userid != '') { if (userid.match(re) == null) {
	 * alert("用户Id必须是11位数字，以1开头!"); return false; } else { flg=true; } } else {
	 * flg=true; }
	 * 
	 * var recommender_code = $("#recommender_code").val(); recommender_code =
	 * trim(recommender_code); var type = /^1\d{10}$/; var re = new
	 * RegExp(type); if (recommender_code != '') { if
	 * (recommender_code.match(re) == null) { alert("推荐人Id必须是11位数字，以1开头!");
	 * return false; } else { flg= true; } } else { flg= true; }
	 * 
	 * var point = $("#point").val(); point = trim(point); var type =
	 * /^[0-9]*[1-9][0-9]*$/; var re = new RegExp(type); if (point != '') { if
	 * (point.match(re) == null) { alert("积分必须是大于等于零的整数!"); return false; } else {
	 * flg= true; } }else { flg= true; }
	 * 
	 * var card_number = $("#card_number").val(); card_number =
	 * trim(card_number); var type = /^[0-9]*[1-9][0-9]*$/; var re = new
	 * RegExp(type); if (card_number != '') { if (card_number.match(re) == null) {
	 * alert("银行卡号必须是大于等于零的整数!"); return false; } else { flg=true; } } else {
	 * flg=true; }
	 */
	/*
	 * 
	 * //正小数
	 * 
	 * var balanceFrom=$("#balanceFrom").val(); balanceFrom=trim(balanceFrom);
	 * if(balanceFrom!=''){ if(isPositiveDecimal(balanceFrom)==false){
	 * alert('balanceFrom number must be positive decimal!'); return false; } }
	 * $("#balanceFrom").val(balanceFrom); var balanceTo=$("#balanceTo").val();
	 * balanceTo=trim(balanceTo); if(balanceTo!=''){
	 * if(isPositiveDecimal(balanceTo)==false){ alert('balanceTo number must be
	 * positive decimal!'); return false; } }
	 * 
	 * $("#balanceTo").val(balanceTo);
	 */

	// s:optiontransferselect处理
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

	// 手动timestamp的时、分处理

	// 自动timestamp的时、分处理

	/*
	 * $("#register_timeHourFrom").val($("#register_timeHourSelectFrom").find("option:selected").val());
	 * $("#register_timeMinuteFrom").val($("#register_timeMinuteSelectFrom").find("option:selected").val());
	 * $("#register_timeHourTo").val($("#register_timeHourSelectTo").find("option:selected").val());
	 * $("#register_timeMinuteTo").val($("#register_timeMinuteSelectTo").find("option:selected").val());
	 * 
	 * $("#update_timeHourFrom").val($("#update_timeHourSelectFrom").find("option:selected").val());
	 * $("#update_timeMinuteFrom").val($("#update_timeMinuteSelectFrom").find("option:selected").val());
	 * $("#update_timeHourTo").val($("#update_timeHourSelectTo").find("option:selected").val());
	 * $("#update_timeMinuteTo").val($("#update_timeMinuteSelectTo").find("option:selected").val());
	 */

	return true;
}

$(function() {
	// 金额输入转换
	$(".moneytype").each(function() {
		$(this).focus(function() {
			if (!isNull($(this).val())) {
				$(this).val(rmoney($(this).val()));
			}
		});
	});
	$(".moneytype").each(function() {
		$(this).blur(function() {
			$(this).val(rmoney($(this).val()));
			if (!isNull($(this).val()) & !isNaN($(this).val())) {
				$(this).val(fmoney($(this).val(), 2));
			} else {
				$(this).val("");
			}
		});
	});

	$("#logout").click(function() {
		window.location.href = 'LoginAction.action?action=logout';
	});
});

// 金额数字转换成带格式99,999,999.99
function fmoney(s, n) {
	n = n > 0 && n <= 20 ? n : 2;
	s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
	var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1];
	t = "";
	for (i = 0; i < l.length; i++) {
		t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
	}
	return t.split("").reverse().join("") + "." + r;
}
// 带格式还原数字
function rmoney(s) {
	return parseFloat(s.replace(/[^\d\.-]/g, ""));
}

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