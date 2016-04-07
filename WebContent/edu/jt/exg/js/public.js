//翻页下拉框跳转
function pageselect(){
	var pagedown=document.getElementById("pagedown");
	var url=pagedown.options[pagedown.selectedIndex].value;
	if(url!="") window.location.href=url;
}

function pageselect1(){
	var pagedown=document.getElementById("pagedown1");
	var url=pagedown.options[pagedown.selectedIndex].value;
	if(url!="") window.location.href=url;
}

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
function isNull(str){ 
	if ( str == "" ) return true; 
	var regu = "^[ ]+$"; 
	var re = new RegExp(regu); 
	return re.test(str); 
} 

//是否是正整数
function isPositiveInteger(str){ 
	var regu = /^[0-9]{1,}$/; 
	return regu.test(str); 
}

//大于0的正整数
function isPositiveIntegerBiggerThanZero(str){
	var flag=true;
	if(isEmpty(str)==true) flag=false;
	else{
		var value=parseInt(str);
		if(isNumber(str)==false) flag=false;
		else if(value<=0) flag=false;
	}
	return flag;
}

//大于0的2个正整数比较大小
function isBiggerFor2PositiveIntegerBiggerThanZero(bigger,smaller){
	var biggerFlag=isPositiveIntegerBiggerThanZero(bigger);
	var smallerFlag=isPositiveIntegerBiggerThanZero(smaller);
	if(biggerFlag==true && smallerFlag==true){
		var biggerValue=parseInt(bigger);
		var smallerValue=parseInt(smaller);
		if(biggerValue>=smallerValue) return true;
		else return false;
	}else return false;
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
	if (re.test(s)) return true; 
	else return false; 
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
	if (s.search(re) != -1)return true; 
	else return false;  
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
	}else return false; 
}

//正小数
function isPositiveDecimal(str){
	if(isPositiveInteger(str)) return true; 
	var re = /^(\d+)[\.]+(\d+)$/; 
	if (re.test(str)) { 
		if(RegExp.$1==0&&RegExp.$2==0) return false; 
		return true; 
	}else return false; 
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
用途：检查输入字符串是否只由英文字母和数字和下划线组成 
输入： 
s：字符串 
返回： 
如果通过验证返回true,否则返回false 
*/ 
function isNumberOr_Letter( s ){//判断是否是数字或字母 
	var regu = "^[0-9a-zA-Z\_]+$"; 
	var re = new RegExp(regu); 
	if (re.test(s)) return true; 
	else return false; 
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
	if (re.test(s)) return true; 
	else return false;  
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
	if (re.test(s)) return true; 
	else return false;  
} 

/* 
用途：判断是否是日期 
输入：date：日期；fmt：日期格式 
返回：如果通过验证返回true,否则返回false 
*/ 
function isDate( date, fmt ) { 
	if (fmt==null) fmt="yyyy-MM-dd"; 
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
	alert("start date is invalid!"); 
	return false; 
	} else if( !isDate(endDate) ) { 
	alert("end date is invalid"); 
	return false; 
	} else if( startDate > endDate ) { 
	alert("start date can't big than end date"); 
	return false; 
	} 
	return true; 
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
	var prompt = "please check your phone number!"
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

//去除空格
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
        
        if (str.charAt(0)==" ") return ""; 
        else return str; 
    }
}

function isEmpty(str){
	str=trim(str);
	if(str.length==0) return true;
	else return false;
}

function goback(){
	window.history.back();
}

//checkbox全选与全不选及以逗号分割取得值
function checkAll(e, itemName){
  var aa = document.getElementsByName(itemName);
  for (var i=0; i<aa.length; i++)
   aa[i].checked = e.checked;
}
function checkItem(e, allName){
  var all = document.getElementsByName(allName)[0];
  if(!e.checked) all.checked = false;
  else{
    var aa = document.getElementsByName(e.name);
    for (var i=0; i<aa.length; i++)
     if(!aa[i].checked) return;
    all.checked = true;
  }
}
function getvalues(name){
    coll=document.getElementsByName(name); 
    var values="";  
    for(var i=0;i<coll.length;i++)   
	if(coll[i].checked) values+=coll[i].value + ","; 
	if(values.length>0) values=values.substring(0,values.length-1);
    return values;
}
function getDeleteAllIds(link,msg){
	alert(link + ids);
    var ids=getvalues('mm');
    alert(link + ids);
    if(ids.length>0){
	var question=confirm(msg);
	if(question==true) window.location.href=link + ids;
    }
}

function rusure(str){ 	
    question = confirm(str); 	
    if (question !="0") return true;
    else return false;
}

function quit(str){ 	
    question = confirm(str); 	
    if (question !="0"){
	window.opener=null;
	window.close();
    }
}

//modify window initial size
function windowResize(width,height){
		var xposition = (screen.width - width) / 2;  
		var yposition = (screen.height - height) / 2; 
		window.resizeTo(width, height);
		window.moveTo(xposition,yposition);
}

/* This function is used to open a pop-up window */
function openWindow(url, winTitle, winParams) {
	winName = window.open(url, winTitle, winParams);
	winName.focus();
}

/* open a pop-up window on the center of the screen */
function openCenterWindow( url, winTitle, width, height){  
	xposition=0; yposition=0;  
	if ((parseInt(navigator.appVersion) >= 4 )){  
		xposition = (screen.width - width) / 2;  
		yposition = (screen.height - height) / 2;  
	}  
	theproperty= "width=" + width + ","   
		+ "height=" + height + ","   
		+ "location=0,"   
		+ "menubar=0,"  
		+ "resizable=1,"  
		+ "scrollbars=0,"  
		+ "status=0,"   
		+ "titlebar=0,"  
		+ "toolbar=0,"  
		+ "hotkeys=0,"  
		+ "screenx=" + xposition + "," //仅适用于Netscape  
		+ "screeny=" + yposition + "," //仅适用于Netscape  
		+ "left=" + xposition + "," //IE  
		+ "top=" + yposition; //IE   
	window.open( url,winTitle,theproperty );  
}

/* This function is to open search results in a pop-up window */
function openSearch(url, winTitle) {
    var screenWidth = parseInt(screen.availWidth)-10;
    var screenHeight = parseInt(screen.availHeight)-50;

    var winParams = "width=" + screenWidth + ",height=" + screenHeight;
        winParams += ",left=0,top=0,toolbar=no,scrollbars=yes,resizable=yes,status=yes";

    openWindow(url, winTitle, winParams);
}

/* 多选传参 */
function multiSendto(){
	var data;
	data=getvalues('mm');
	if(!data) window.close();
	else{
		window.opener.document.all.getParms.value=data;
		var focusTagName=window.opener.document.all.setFocusId.value;
		window.opener.document.getElementsByName(focusTagName)[0].focus();
		window.close();
	}
}

/* 单选传参 */
function singleSendto(){
	var data;
	var rd;
	rd = document.getElementsByName("mm");
	for (var i=0; i<rd.length; i++){
     		if (rd[i].checked){
          		data = rd[i].value;
          		break;
     		}
	}
	window.opener.document.all.getParms.value=data;
	var focusTagName=window.opener.document.all.setFocusId.value;
	window.opener.document.getElementsByName(focusTagName)[0].focus();
	window.close();
}

/* applet加载color调色，参数buttonSetup包括applet按钮显示名|rgb值输出text名组成 */
function jAppletLoading(JavaClassName,buttonSetup,widthValue,heightValue){
		var appletStr="<object classid='clsid:8AD9C840-044E-11D1-B3E9-00805F499D93' width='" + widthValue + "' height='" + heightValue + "' codebase='http://java.sun.com/products/plugin/1.2.2/jinstall-1_2_2-win.cab#Version=1,2,2,0'>";
		appletStr+="<param name='java_code' value='" + JavaClassName + "'>";
		appletStr+="<param name='java_codebase' value='.'>";
		appletStr+="<param name='type' value='application/x-java-applet;'>";
		appletStr+="<param name='buttonSetup' value='" + buttonSetup + "'>";
		appletStr+="<comment>";
		appletStr+="<EMBED type='application/x-java-applet;' width='" + widthValue + "' height='" + heightValue + "' pluginspage='http://java.sun.com/products/plugin/' java_code='applet.RGBApplet.class' java_codebase='.' buttonSetup='" + buttonSetup + "'/>";
		appletStr+="<noembed>";
		appletStr+="</noembed>";
		appletStr+="</comment>";
		appletStr+="</object>";
		document.write(appletStr);
}

//得到浏览器的语言
function getBrowserLanguage(){
	var language=window.navigator.userLanguage;
	var languageStr=language.toString();
	if(languageStr.indexOf('cn')!=-1) languageStr='cn';
	else if(languageStr.indexOf('tw')!=-1) languageStr='tw';
	else if(languageStr.indexOf('en')!=-1) languageStr='en';
	else if(languageStr.indexOf('ja')!=-1) languageStr='ja';
	else if(languageStr.indexOf('de')!=-1) languageStr='de';
	else if(languageStr.indexOf('fr')!=-1) languageStr='fr';
	else if(languageStr.indexOf('ko')!=-1) languageStr='ko';
	else if(languageStr.indexOf('ru')!=-1) languageStr='ru';
	else languageStr='en';
	return languageStr;
}

/*
	selectId 下拉列表id
	totalItemsStr 要生成的项 eg:"aaa;aaa|bbb;bbb|ccc;ccc|ddd;ddd|eee;eee"
	recorderSplitMark 记录分割符号
	valueTextSplit 键值分割符号
*/
function generateSelectItem(selectId,totalItemsStr,recorderSplitMark,valueTextSplit){
	var selectcolumns=document.getElementById(selectId);
	selectcolumns.options.length=0;
	selectcolumns[selectcolumns.length] = new Option("", ""); 
	if(totalItemsStr!="null"){
		recorders=totalItemsStr.split(recorderSplitMark);
		for(var i=0;i<recorders.length;i++){
			recorder=recorders[i].split(valueTextSplit);
			selectcolumns[selectcolumns.length] = new Option(recorder[0], recorder[1]);
		}
	}
}

/*
 * 得到单选按钮的值
 */
function getRadioValue(name){
	var tmp=document.getElementsByName(name);
	var data;
	for (var i=0; i<tmp.length; i++){
 		if (tmp[i].checked){
      		data = tmp[i].value;
      		break;
 		}
	}
	return data;
}

/*
 * 清楚radio选择
 */
function clearRadioValue(name){
	var tmp=document.getElementsByName(name);
	for (var i=0; i<tmp.length; i++){
 		tmp[i].checked=false;
	}
}

/*
 * 初始化下拉列表的当前值
 * selectId 下拉列表id
 * text 当前值
 */
function setSelectValue(selectId,text){
	var selectcolumns=document.getElementById(selectId);
	for(var i=0;i<selectcolumns.options.length;i++){
		if(selectcolumns.options[i].value==text){
			selectcolumns.selectedIndex=i;
			break;
		}
	}
}

//关闭页面不弹出提示
function Close(){   
	var ua = navigator.userAgent;   
	var ie = navigator.appName == "Microsoft Internet Explorer"?true:false;   
	if(ie){   
		var IEversion = parseFloat(ua.substring(ua.indexOf("MSIE")+5,ua.indexOf(";",ua.indexOf("MSIE"))));     
		if(IEversion < 5.5){   
			var str = "<object id = 'noTipClose' classid='clsid:ADB880A6-D8FF-11CF-9377-00AA003B7A11'>";   
			str += "<param name='Command' value='Close'/></object>";   
			document.body.insertAdjacentHTML("beforeEnd",str);   
			document.all.noTipClose.Click();   
		}else{   
			window.opener = null;   
			window.open('','_self','');   
			window.close();   
		}   
	}else{   
		widow.close();   
	}   
}

//弹出隐藏层
function ShowDiv(bg_div){
document.getElementById(bg_div).style.display='block';
var bgdiv = document.getElementById(bg_div);
bgdiv.style.width = document.body.scrollWidth;
// bgdiv.style.height = $(document).height();
$("#"+bg_div).height($(document).height());
};
function HideDiv(bg_div){
	document.getElementById(bg_div).style.display='none';	
}