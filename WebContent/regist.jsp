<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="user-scalable=no,width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1,, minimal-ui" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<title>新用户注册</title>
<script type="text/javascript">

    $(document).ready(function(){

    	$("#submit").click(function(){
    		//
    		var phoneNum = $("#usename").val();
    		var message = $("#message").val();
    		var password = $("#pwd").val();
    		var confirmPassword = $("#confirmPwd").val();
    		//手机号码的check
    		if(!phoneCheck()){
    			return ;
    		}
    		//alert("FF:"+f);
    		//手机验证码check
    		if(message == ""){
    			alert("请输入手机验证码");
    			return ;
    		}
    		//密码的check
    		if((password + "").length < 6 || (password + "").length > 20){
    		    alert("请使用字母和数字重新设置，6-20位");
    		    return ;
    		}
    		var lv = 0;
    		if(password.match(/[a-z]/g)){lv++;}
    		if(password.match(/[0-9]/g)){lv++;}
    		if(lv != 2){
    		    alert("请使用字母和数字重新设置，6-20位");
    		    return ;
    		}
    		if(password != confirmPassword){
    		    alert("两次输入不一致，请重新设置");
    		    return ;
    		}
    		//从URL中获取邀请人id
    		var inviteUsername = "13305373611";
    		var url = location.search; 			//获取url中"?"符后的字串
   		   	if (url.indexOf("?") != -1) {    	//判断是否有参数
   		      	var str = url.substr(1); 		//从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
   		      	strs = str.split("=");
   		     	inviteUsername = strs[1];          	//直接弹出第一个参数
   		   	}
    		var data={
    				"mobile":phoneNum,
    				"sms":message,
    				"passwd":password,
    				"inviteUsername":inviteUsername
    		};
    		$.ajax({
    			type: "post",
    			url : "RegistServlet",
    			dataType:"json",
    			data:data,
    			success: function(result){
    				if(result.code == "2")
   					{
        				window.location.href="registSucc.jsp";	
   					}else{
    					alert(result.msg);
   					}
    			},
    			failure: function(msg){
    				alert("请求错误，请检查网络设置");
    			}
    		});
    		//
    		
    	});
    	
    	$("#reset").click(function(){
    		phoneNum = $("#usename").val("");
    		message = $("#message").val("");
    		password = $("#pwd").val("");
    		confirmPassword = $("#confirmPwd").val("");
    		$("#sms").val("获取");
    		clearInterval(intervalid); 
    		count = 60;
    		$("#sms").removeAttr("disabled");
    	});
    	
    });
 	//发送短信验证码
    function sendSMS(){
    	if(!phoneCheck()){
			return ;
		}
    	//倒计时
    	startClock();
    	var phoneNum = $("#usename").val();
    	var data={
				"mobile":phoneNum,
				"category": "regist"
		};
    	$.ajax({
			type: "post",
			url : "GetSMSServlet",
			dataType:"json",
			data:data,
			success: function(result){
				if(result.code == "3"){
					alert(result.msg);
					window.location.href="registSucc.jsp";
				}else if(result.code == "2"){
					
				}else{
					clearInterval(intervalid); 
					$("#sms").val("获取");
		   			$("#sms").removeAttr("disabled"); 
		   			count = 60;
					alert(result.msg);
				}
			},
			error: function(result){
				alert("请求错误，请检查网络设置");
			}
		});
    	
    }
    
    function phoneCheck(){
		var phoneNum = $("#usename").val();
		//手机号码的check
		if(phoneNum == ""){
		    alert("请输入手机号码");
		}else if((phoneNum + "").length != 11){
		    alert("请输入正确的手机号码");
		}else{
		    var myreg = /^13[0-9]{1}[0-9]{8}$|15[0189]{1}[0-9]{8}$|18[0-9]{9}$/;
		    if(!myreg.test(phoneNum))
		    {
		        alert("请输入正确的手机号码");
		    }else{
				return true;
			}
		}
		return false;
	}
	
    //开始短信验证码倒计时
    var count = 60;
    var intervalid;
    function startClock(){
    	intervalid = setInterval("clock()",1000);
    }
    //计时中。。
    function clock()
    {
   		$("#sms").val(--count+"秒");
   		$("#sms").attr("disabled",true); 
   		if(count == 0){
   			clearInterval(intervalid); 
   			$("#sms").val("重新发送");
   			$("#sms").removeAttr("disabled"); 
   			count = 60;
   		}
   	}
</script >
<style>
	body{
		margin:0px;
		padding:0px;
		/* background:#FFFFCC; */
		background:#FFF;
	}
	.main{
		margin-left:10%;
		margin-right:10%;
	}
	table{
		width:100%;
	}
	tr td input{
		width:100%;
		height:35px;
		font-size:18px;
	}
	.butt{
		height:35px;
		width:120px;
		font-size:18px;
		color: #fef4e9;
		border: solid 1px #da7c0c;
		background: -webkit-gradient(linear, left top, left bottom, from(#faa51a), to(#f47a20));
		text-shadow: 0 1px 1px rgba(0,0,0,.3);
		-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
		webkit-border-radius: .5em;
		border-radius: 8px;
		cursor: pointer;
		text-align: center;
	}

</style>
</head>
<body style="font-family:'微软雅黑'">
	<div class="main">
	<!-- <img src="image/logo/wllc4.png"/>  -->
	
		<table id="tab" style="font-size:24px;line-height:50px;">
			<tr>
				<td style="height:8%;">&nbsp;</td>
			</tr>
			<tr>
				<td style="text-align:center;"><span style="font-size:30px;"><b>用户注册</b></span></td>
			</tr>
			<tr>
				<td><input id="usename" type="number" placeholder="请输入手机号码"/></td>
			</tr>
			<tr>
				<td >
					<div style="float:left;width:55%;"><input id="message" type="number" placeholder="请输入验证码"/></div>
					<div style="float:right;width:35%;"><input id="sms"  type="button" class="butt" style="width:100%;" value="获取" onclick="sendSMS();"/></div>
				</td>
			</tr>
			<tr>
				<td><input id="pwd" type="password" placeholder="请输入密码"/></td>
			</tr>
			<tr>
				<td><input id="confirmPwd" type="password" placeholder="请再次确认密码"/></td>
			</tr>
			<tr>
				<td style="height: 10%;"></td>
			</tr>
			<tr>
				<td>
					<div style="float:left;"><input id="reset" type="button" class="butt" value="重置"/></div>
					<div style="float:right;"><input id="submit" type="button" class="butt" value="提交"/></div>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>