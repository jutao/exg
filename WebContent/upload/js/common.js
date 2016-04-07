/* 
用途：校验ip地址的格式 
输入：strIP：ip地址 
返回：如果通过验证返回true,否则返回false； 
*/ 
function isIP(strIP) { 
	if (isNull(strIP)) return false; 
	var re=/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g //匹配IP地址的正则表达式 
	if(re.test(strIP)){ 
		if( RegExp.$1 <256 && RegExp.$2<256 && RegExp.$3<256 && RegExp.$4<256) return true; 
	} 
	return false; 
} 
 
/* 
用途：检查输入字符串是否为空或者全部都是空格 
输入：str 
返回： 
如果全是空返回true,否则返回false 
*/ 
function isNull( str ){ 
	if ( str == "" ) return true; 
	var regu = "^[ ]+$"; 
	var re = new RegExp(regu); 
	return re.test(str); 
} 

//是否是正整数
function isPositiveInteger( str ){ 
	var regu = /^[0-9]{1,}$/; 
	return regu.test(str); 
} 

/* 
用途：检查输入对象的值是否符合整数格式 
输入：str 输入的字符串 
返回：如果通过验证返回true,否则返回false 
*/ 
function isInteger( str ){ 
	var regu = /^[-]{0,1}[0-9]{1,}$/; 
	return regu.test(str); 
} 

/* 
用途：检查输入手机号码是否正确 
输入： 
s：字符串 
返回： 
如果通过验证返回true,否则返回false 
*/ 
function checkMobile( s ){ 
	var regu =/^[1][3][0-9]{9}$/; 
	var re = new RegExp(regu); 
	if (re.test(s)){ 
		return true; 
	}else{ 
		return false; 
	} 
} 
 
 
/* 
用途：检查输入字符串是否符合正整数格式 
输入： 
s：字符串 
返回： 
如果通过验证返回true,否则返回false 
*/ 
function isNumber( s ){ 
	var regu = "^[0-9]+$"; 
	var re = new RegExp(regu); 
	if (s.search(re) != -1){ 
		return true; 
	}else{ 
		return false; 
	} 
} 

//是否是正数
function isPositiveDecimal( str ){ 
	if(isPositiveInteger(str)) return true; 
	else{
		var re = /^(\d+)[\.]+(\d+)$/; 
		if (re.test(str)) { 
			if(RegExp.$1==0&&RegExp.$2==0) return false; 
			return true; 
		}else{ 
			return false; 
		} 
	}
} 

/* 
用途：检查输入字符串是否是带小数的数字格式,可以是负数 
输入： 
s：字符串 
返回： 
如果通过验证返回true,否则返回false 
*/ 
function isDecimal( str ){ 
	if(isInteger(str)) return true; 
	var re = /^[-]{0,1}(\d+)[\.]+(\d+)$/; 
	if (re.test(str)) { 
		if(RegExp.$1==0&&RegExp.$2==0) return false; 
		return true; 
	}else{ 
		return false; 
	} 
} 
 
/* 
用途：检查输入对象的值是否符合端口号格式 
输入：str 输入的字符串 
返回：如果通过验证返回true,否则返回false 
*/ 
function isPort( str ){ 
	return (isNumber(str) && str<65536); 
} 
 
/* 
用途：检查输入对象的值是否符合E-Mail格式 
输入：str 输入的字符串 
返回：如果通过验证返回true,否则返回false 
*/ 
function isEmail( str ){ 
	var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/; 
	if(myReg.test(str)) return true; 
	return false; 
} 
 
/* 
用途：检查输入字符串是否符合金额格式 
格式定义为带小数的正数，小数点后最多三位 
输入： 
s：字符串 
返回： 
如果通过验证返回true,否则返回false 
*/ 
function isMoney( s ){ 
	if(isPositiveInteger(str)) return true; 
	else{
		var regu = "^[0-9]+[\.][0-9]{0,3}$"; 
		var re = new RegExp(regu); 
		if (re.test(s)){ 
			return true; 
		}else{ 
			return false; 
		} 
	}
} 
/* 
用途：检查输入字符串是否只由英文字母和数字和下划线组成 
输入： 
s：字符串 
返回： 
如果通过验证返回true,否则返回false 
*/ 
function isNumberOr_Letter( s ){//判断是否是数字或字母 
	var regu = "^[0-9a-zA-Z\_]+$"; 
	var re = new RegExp(regu); 
	if (re.test(s)) { 
		return true; 
	}else{ 
		return false; 
	} 
} 
/* 
用途：检查输入字符串是否只由英文字母和数字组成 
输入： 
s：字符串 
返回： 
如果通过验证返回true,否则返回false
*/ 
function isNumberOrLetter( s ){//判断是否是数字或字母 
	var regu = "^[0-9a-zA-Z]+$"; 
	var re = new RegExp(regu); 
	if (re.test(s)) { 
		return true; 
	}else{ 
		return false; 
	} 
} 

/* 
用途：检查输入字符串是否只由汉字、字母、数字组成 
输入： 
value：字符串 
返回： 
如果通过验证返回true,否则返回false 
*/ 
function isChinaOrNumbOrLett( s ){//判断是否是汉字、字母、数字组成 
	var regu = "^[0-9a-zA-Z\u4e00-\u9fa5]+$"; 
	var re = new RegExp(regu); 
	if (re.test(s)) { 
		return true; 
	}else{ 
		return false; 
	} 
} 
 
/* 
用途：判断是否是日期 
输入：date：日期；fmt：日期格式 
返回：如果通过验证返回true,否则返回false 
*/ 
function isDate( date, fmt ) { 
	if (fmt==null) fmt="yyyyMMdd"; 
	var yIndex = fmt.indexOf("yyyy"); 
	if(yIndex==-1) return false; 
	var year = date.substring(yIndex,yIndex+4); 
	var mIndex = fmt.indexOf("MM"); 
	if(mIndex==-1) return false; 
	var month = date.substring(mIndex,mIndex+2); 
	var dIndex = fmt.indexOf("dd"); 
	if(dIndex==-1) return false; 
	var day = date.substring(dIndex,dIndex+2); 
	if(!isNumber(year)||year>"2100" || year< "1900") return false; 
	if(!isNumber(month)||month>"12" || month< "01") return false; 
	if(day>getMaxDay(year,month) || day< "01") return false; 
	return true; 
} 
 
function getMaxDay(year,month) { 
	if(month==4||month==6||month==9||month==11) 
	return "30"; 
	if(month==2) 
	if(year%4==0&&year%100!=0 || year%400==0) 
	return "29"; 
	else 
	return "28"; 
	return "31"; 
} 
 
/* 
用途：字符1是否以字符串2结束 
输入：str1：字符串；str2：被包含的字符串 
返回：如果通过验证返回true,否则返回false 
*/ 
function isLastMatch(str1,str2){ 
	var index = str1.lastIndexOf(str2); 
	if(str1.length==index+str2.length) return true; 
	return false; 
} 
 
 
/* 
用途：字符1是否以字符串2开始 
输入：str1：字符串；str2：被包含的字符串 
返回：如果通过验证返回true,否则返回false 
*/ 
function isFirstMatch(str1,str2) 
{ 
	var index = str1.indexOf(str2); 
	if(index==0) return true; 
	return false; 
} 
 
/* 
用途：字符1是包含字符串2 
输入：str1：字符串；str2：被包含的字符串 
返回：如果通过验证返回true,否则返回false 
*/ 
function isMatch(str1,str2){ 
	var index = str1.indexOf(str2); 
	if(index==-1) return false; 
	return true; 
} 
 
/* 
用途：检查输入的起止日期是否正确，规则为两个日期的格式正确， 
且结束如期>=起始日期 
输入： 
startDate：起始日期，字符串 
endDate：结束如期，字符串 
返回： 
如果通过验证返回true,否则返回false 
*/ 
function checkTwoDate( startDate,endDate ) { 
	if( !isDate(startDate) ) { 
	alert("起始日期不正确!"); 
	return false; 
	} else if( !isDate(endDate) ) { 
	alert("终止日期不正确!"); 
	return false; 
	} else if( startDate > endDate ) { 
	alert("起始日期不能大于终止日期!"); 
	return false; 
	} 
	return true; 
} 
 
/* 
用途：检查输入的Email信箱格式是否正确 
输入： 
strEmail：字符串 
返回： 
如果通过验证返回true,否则返回false 
*/ 
function checkEmail(strEmail) { 
	//var emailReg = /^[_a-z0-9]+@([_a-z0-9]+\.)+[a-z0-9]{2,3}$/; 
	var emailReg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/; 
	if( emailReg.test(strEmail) ){ 
		return true; 
	}else{ 
		alert("您输入的Email地址格式不正确！"); 
		return false; 
	} 
}

/*
用途：检查输入的电话号码格式是否正确
输入：
strPhone：字符串
返回：
如果通过验证返回true,否则返回false
*/
function checkPhone( strPhone ) { 
	var phoneRegWithArea = /^[0][1-9]{2,3}-[0-9]{5,10}$/; 
	var phoneRegNoArea = /^[1-9]{1}[0-9]{5,8}$/; 
	var prompt = "您输入的电话号码不正确!"
	if( strPhone.length > 9 ) {
		if( phoneRegWithArea.test(strPhone) ){
			return true; 
		}else{
			alert( prompt );
			return false; 
		}
	}else{
		if( phoneRegNoArea.test( strPhone ) ){
			return true; 
		}else{
			alert( prompt );
			return false; 
		}
	}
}

function linkUrl(url){
	window.location=url;
}

function getFormAsString(frmObj) {
    var query = "";
	for (var i = 0; i < frmObj.length; i++) {
        var element = frmObj.elements[i];
        if (element.type.indexOf("checkbox") == 0 || 
            element.type.indexOf("radio") == 0) { 
            if (element.checked) {
                query += element.name + '=' + escape(element.value) + "&";
            }
		} else if (element.type.indexOf("select") == 0) {
			for (var j = 0; j < element.length ; j++) {
				if (element.options[j].selected) {
                    query += element.name + '=' + escape(element.options[j].value) + "&";
                }
			}
        } else {
            query += element.name + '=' 
                  + escape(element.value) + "&"; 
        }
    } 
    return query;
}

function channelV(action,done,start,range){
	var url=action + "?" + getFormAsString(document.getElementById('formId'));
	url=url.substring(0,url.lastIndexOf("&"));
	url=url + "&done=" + done + "&start=" + start + "&range=" + range;
	url=unescape(url);
	window.location=url;
}

function submitForm(id){
	var form=document.getElementById(id);
	form.submit();
}

function trim(str) { 
    if (str != null) {
        var i; 
        for (i=0; i<str.length; i++) {
            if (str.charAt(i)!=" ") {
                str=str.substring(i,str.length); 
                break;
            } 
        } 
    
        for (i=str.length-1; i>=0; i--) {
            if (str.charAt(i)!=" ") {
                str=str.substring(0,i+1); 
                break;
            } 
        } 
        
        if (str.charAt(0)==" ") {
            return ""; 
        } else {
            return str; 
        }
    }
}

function isEmpty(str){
	str=trim(str);
	if(str.length==0){
		return true;
	}else{
		return false;
	}
}

function isInteger(str){
	var integer=parseInt(str);
	if(isNaN(integer)){
		return false;
	}else{
		return true;
	}
}

function inRange(value,min,max){
	if(value>=min && value<=max){
		return true;
	}else{
		return false;
	}
}

//Function for showing and hiding elements that use 'display:none' to hide
function toggleDisplay(targetId)
{
    if (document.getElementById) {
        target = document.getElementById(targetId);
    	if (target.style.display == "none"){
    		target.style.display = "";
    	} else {
    		target.style.display = "none";
    	}
    }
}

// toggle visibility 
function toggleVisibility(targetId) {
    if (document.getElementById) {
        target = document.getElementById(targetId);
    	if (target.style.visibility == "hidden"){
    		target.style.visibility = "visible";
    	} else {
    		target.style.visibility = "hidden";
    	}
    }
}

//Function to clear a form of all it's values
function clearForm(formId) {
	var frmObj=document.getElementById(formId);
	for (var i = 0; i < frmObj.length; i++) {
        var element = frmObj.elements[i];
		if(element.type.indexOf("text") == 0 || 
				element.type.indexOf("password") == 0) {
					element.value="";
		} else if (element.type.indexOf("radio") == 0) {
			element.checked=false;
		} else if (element.type.indexOf("checkbox") == 0) {
			element.checked = false;
		} else if (element.type.indexOf("select") == 0) {
			for(var j = 0; j < element.length ; j++) {
				element.options[j].selected=false;
			}
            element.options[0].selected=true;
		}
	} 
}


/* Function to hide form elements that show through
   the search form when it is visible */
function toggleForm(frmObj, iState) // 1 visible, 0 hidden 
{
	for(var i = 0; i < frmObj.length; i++) {
		if (frmObj.elements[i].type.indexOf("select") == 0 || frmObj.elements[i].type.indexOf("checkbox") == 0) {
            frmObj.elements[i].style.visibility = iState ? "visible" : "hidden";
		}
	} 
}

/* This function is used to select a checkbox by passing
 * in the checkbox id
 */
function toggleChoice(elementId) {
    var element = document.getElementById(elementId);
    if (element.checked) {
        element.checked = false;
    } else {
        element.checked = true;
    }
}

/* This function is used to select a radio button by passing
 * in the radio button id and index you want to select
 */
function toggleRadio(elementId, index) {
    var element = document.getElementsByName(elementId)[index];
    element.checked = true;
}

/* This function is used to open a pop-up window */
function openWindow(url, winTitle, winParams) {
	winName = window.open(url, winTitle, winParams);
    winName.focus();
}

/* This function is to open search results in a pop-up window */
function openSearch(url, winTitle) {
    var screenWidth = parseInt(screen.availWidth)-10;
    var screenHeight = parseInt(screen.availHeight)-50;

    var winParams = "width=" + screenWidth + ",height=" + screenHeight;
        winParams += ",left=0,top=0,toolbar=no,scrollbars=yes,resizable=yes,status=yes";

    openWindow(url, winTitle, winParams);
}

/* This function is used to set cookies */
function setCookie(name,value,expires,path,domain,secure) {
  document.cookie = name + "=" + escape (value) +
    ((expires) ? "; expires=" + expires.toGMTString() : "") +
    ((path) ? "; path=" + path : "") +
    ((domain) ? "; domain=" + domain : "") + ((secure) ? "; secure" : "");
}

/* This function is used to get cookies */
function getCookie(name) {
	var prefix = name + "=" 
	var start = document.cookie.indexOf(prefix) 

	if (start==-1) {
		return null;
	}
	
	var end = document.cookie.indexOf(";", start+prefix.length) 
	if (end==-1) {
		end=document.cookie.length;
	}

	var value=document.cookie.substring(start+prefix.length, end) 
	return unescape(value);
}

/* This function is used to delete cookies */
function deleteCookie(name,path,domain) {
  if (getCookie(name)) {
    document.cookie = name + "=" +
      ((path) ? "; path=" + path : "") +
      ((domain) ? "; domain=" + domain : "") +
      "; expires=Thu, 01-Jan-70 00:00:01 GMT";
  }
}

function confirmDelete(formId, msg) {   
    var form = document.getElementById(formId);
    //var msg = "Are you sure you want to delete this " + obj + "?";
	ans = confirm(msg);
	if (ans) {
        return true;
	} else {
        return false;
    }
}

// This function is used by the login screen to validate user/pass
// are entered. 
function validateRequired(form) {                                    
    var bValid = true;
    var focusField = null;
    var i = 0;                                                                                          
    var fields = new Array();                                                                           
    oRequired = new required();                                                                         
                                                                                                        
    for (x in oRequired) {                                                                              
        if ((form[oRequired[x][0]].type == 'text' || form[oRequired[x][0]].type == 'textarea' || form[oRequired[x][0]].type == 'select-one' || form[oRequired[x][0]].type == 'radio' || form[oRequired[x][0]].type == 'password') && form[oRequired[x][0]].value == '') {
           if (i == 0)
              focusField = form[oRequired[x][0]]; 
              
           fields[i++] = oRequired[x][1];
            
           bValid = false;                                                                             
        }                                                                                               
    }                                                                                                   
                                                                                                       
    if (fields.length > 0) {
       focusField.focus();
       alert(fields.join('\n'));                                                                      
    }                                                                                                   
                                                                                                       
    return bValid;                                                                                      
}

function goback(){
	window.history.back();
}

function rusure(str){ 	
	question = confirm(str); 	
	if (question !="0")
	{
		alert('操作成功');
		return true;
	}else{
		return false;
	}
} 

function isNumber(str){
	strRef = "1234567890";
	for (i=0;i<str.length;i++) {
		tempChar= str.substring(i,i+1);
		if (strRef.indexOf(tempChar,0)==-1) {
			return false; 
		}
	}
	return true;
}

function checkIdcard(idcard){
	var Errors=new Array(
	"验证通过!",
	"身份证号码位数不对!",
	"身份证号码出生日期超出范围或含有非法字符!",
	"身份证号码校验错误!",
	"身份证地区非法!");
	var area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",
			  32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",
			  45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",
			  64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}
	var idcard,Y,JYM;
	var S,M;
	var idcard_array = new Array();
	idcard_array = idcard.split("");
	//地区检验
	if(area[parseInt(idcard.substr(0,2))]==null) return Errors[4];
	//身份号码位数及格式检验
	switch(idcard.length){
		case 15:
			if ((parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){
				ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;						            	//测试出生日期的合法性
			} else {
				ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;            			                //测试出生日期的合法性
			}
			if(ereg.test(idcard)) return Errors[0];
			else return Errors[2];
		break;
		case 18:
			//18位身份号码检测
			//出生日期的合法性检查 
			//闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
			//平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
			if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){
				ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;	                //闰年出生日期的合法性正则表达式
			} else {
				ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;               //平年出生日期的合法性正则表达式
			}
			if(ereg.test(idcard)){//测试出生日期的合法性
				//计算校验位
				S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
				+ (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
				+ (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
				+ (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
				+ (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
				+ (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
				+ (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
				+ parseInt(idcard_array[7]) * 1 
				+ parseInt(idcard_array[8]) * 6
				+ parseInt(idcard_array[9]) * 3 ;
				Y = S % 11;
				M = "F";
				JYM = "10X98765432";
				M = JYM.substr(Y,1);//判断校验位
				if(M == idcard_array[17]) return Errors[0]; //检测ID的校验位
				else return Errors[3];
			}else return Errors[2];
		break;
		default:
			return Errors[1];
		break;
	}
}

function isValidDate(year,month,day) {
	if (month < 1 || month > 12) return false;
	if (day < 1 || day > 31) return false;
	if ((month == 4 || month == 6 || month == 9 || month == 11) &&	(day == 31)) return false;
	if (month == 2) {
		var leap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		if (day>29 || (day == 29 && !leap)) return false;
	}
	return true;
}

//日期检验如2006-01-01,2006/01/01,20060101
function checkMultiDate(dateStr,splitSymbol){
	var flag=true;
	var array=new Array();
	var year,month,day;
	if(splitSymbol.length==0){
		if(dateStr.length!=8) flag=false;
		if(flag==true){
			if(isNumber(dateStr)==false) flag=false;
		}
		if(flag==true){
			year=dateStr.substring(0,4);
			month=dateStr.substring(4,6);
			day=dateStr.substring(6,8);
			flag=isValidDate(year,month,day);
		}
	}else{
		array=dateStr.split(splitSymbol);
		if(array.length!=3) flag=false;
		else{
			for(i=0;i<array.length;i++){
				switch(i){
					case 0:
						year=array[i];
						break;
					case 1:
						month=array[i];
						break;
					case 2:
						day=array[i];
						break;
				}
			}
			flag=isNumber(year);
			if(flag==true) flag=isNumber(month);
			if(flag==true) flag=isNumber(day);
			if(flag==true) flag=isValidDate(year,month,day);
		}
	}
	return flag;
}

//checkbox全选与全不选及以逗号分割取得值
function checkAll(e, itemName)
{
  var aa = document.getElementsByName(itemName);
  for (var i=0; i<aa.length; i++)
   aa[i].checked = e.checked;
}
function checkItem(e, allName)
{
  var all = document.getElementsByName(allName)[0];
  if(!e.checked) all.checked = false;
  else
  {
    var aa = document.getElementsByName(e.name);
    for (var i=0; i<aa.length; i++)
     if(!aa[i].checked) return;
    all.checked = true;
  }
}
function getvalues(name){
    coll=document.getElementsByName(name); 
    var values="";  
    for(var   i=0;i<coll.length;i++)   
		if(coll[i].checked) values+=coll[i].value + ","; 
	if(values.length>0) values=values.substring(0,values.length-1);
    return values;
}
//将选中的记录发送到后台删除
function getDeleteAllIds(link){
    var ids=getvalues('mm');
    
	if(ids.length>0){
	    var question=confirm('确定要删除选中的记录吗？');
		if(question==true) window.location.href=link + ids;
	}
}

function getImportAllIds(link)
{
  var ids = getvalues('mm');
   if (ids.length>0)
    {
      var question = confirm('are you sure?');
      if (question==true) window.location.href=link + ids;
    }
}

function GetNameAndId(PagePath,Id,Name)
{
	var values = window.showModalDialog(PagePath,"","dialogWidth=800px;dialogHeight=600px");
    if(values!=null)
     {
		document.getElementById(Id).value=values[0];
		document.getElementById(Name).value=values[1];
     }
}

//form提交必须写到每个页面
function submit(form,url){
	form.action=url; 
	form.method = "POST"; 
	form.encoding="application/x-www-form-urlencoded"; 
	form.submit();
}

//上传文件form提交必须写到每个页面
function uploadSubmit(form,url){
	form.action=url; 
	form.method = "POST"; 
	form.encoding="multipart/form-data"; 
	form.submit();
}