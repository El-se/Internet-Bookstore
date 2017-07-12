
/*注册提交按钮 图片切换*/



$(function(){
	
	
	$("#submitBtn").hover(
			function(){
				$(this).attr("src","/goods/images/regist2.jpg");
			}
			,
			function(){
				$(this).attr("src","/goods/images/regist1.jpg");
			}
	)
	
	
	
	
	
	
	
	
	
	$(".errorClass").each(function(){
			showError($(this))
	})


	
	
	
	
	
	
	
	
	
	$(".inputClass").focus(function(){
			var labelid = $(this).attr("id")+"Error"
			$("#"+labelid).text("")
			showError($($("#"+labelid)))
	})
	
	
	
	
	
	$(".inputClass").blur(function(){
		
		//var labelid = $(this).attr("id")+"Error"
		
		eval("yanzheng"+$(this).attr("id")+"()")
	})
	
	
})
	/*图片切换*/

function _hyz(){
	
	$("#imgVerifyCode").attr("src","/goods/getverify?"+new Date())
	
	
}



function showError(element){
	value = element.text()
	if(!value){
		element.css("display","none")
	}else{
		element.css("display","")
	}
}



function yanzhengloginname(){
	//是否为空
	var value = $("#loginname").val()
	if(!value){
		$("#loginnameError").text("用户名不能为空")
		showError($("#loginnameError"))
		return false
	}
	
	//长度限制
	if(value.length<2||value.length>13){
		$("#loginnameError").text("用户名在2-13之间")
		showError($("#loginnameError"))
		return false
	}
	var flag = false
	$.ajax({
		//发给服务器的值
		data:"loginname="+value,
		//发送的值的类型
		datatype:"text",
		//是否缓存
		cache:false,
		//请求方式
		type:"post",
		//是否为异步请求
		async:false,
		//请求的路径
		url:"/goods/valiloginname",
		//接受的结果与处理方式
		success:function(res){
			if(res=="true"){
				flag=true;
			}else{
				$("#loginnameError").text("用户名已注册")
				showError($("#loginnameError"))
				flag=false
			}
		}
	})
	return flag
}
function yanzhengloginpass(){
	//是否为空
		var passvalue = $("#loginpass").val()
		if(!passvalue){
			$("#loginpassError").text("密码不能为空")
			showError($("#loginpassError"))
			return false
		}
		
		//长度限制
		if(passvalue.length>6){
			$("#loginpassError").text("密码不能多于6位")
			showError($("#loginpassError"))
			return false
		}
		return true
}
function yanzhengreloginpass(){
	//是否为空
			var repassvalue = $("#reloginpass").val()
			var pass_value = $("#loginpass").val()
			
			if(!repassvalue){
				$("#reloginpassError").text("密码不能为空")
				showError($("#reloginpassError"))
				return false
			}
	//是否一致
			if(repassvalue!=pass_value){
				$("#reloginpassError").text("密码不一致")
				showError($("#reloginpassError"))
				return false
			}
			return true
}
function yanzhengemail(){
	//是否为空
			var emailvalue = $("#email").val()
			if(!emailvalue){
				$("#emailError").text("邮箱不能为空")
				showError($("#emailError"))
				return false
			}
	//邮箱格式
			var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
			if(!reg.test(emailvalue)){
				$("#emailError").text("邮箱格式不正确")
				showError($("#emailError"))
				return false
			}
	//是否注册
			var flag = false
			$.ajax({
				
				//发给服务器的值
				data:{email:emailvalue},
				//发送的值的类型
				datatype:'json',
				//是否缓存
				cache:false,
				//请求方式
				type:'post',
				//是否为异步请求
				async:false,
				//请求的路径
				url:'/goods/valiemail',
				//接受的结果与处理方式
				success:function(res){
					if(res){
						flag=true;
					}else{
						$("#emailError").text("邮箱已注册过")
						showError($("#emailError"))
						flag=false
					}
				}
			})
			return flag
}
function yanzhengverifyCode(){
	//是否为空
	var verifyCodevalue = $("#verifyCode").val()
	if(!verifyCodevalue){
		$("#verifyCodeError").text("验证码不能为空")
		showError($("#verifyCodeError"))
		return false
	}
	//是否四位
	if(verifyCodevalue.length!=4){
		$("#verifyCodeError").text("验证码填写错误")
		showError($("#verifyCodeError"))
		return false
	}
	//是否一致
	var flag = false
	$.ajax({
		
		data:{verifyCodevalue:verifyCodevalue},
		datatype:'json',
		cache:false,
		//请求方式
		type:'post',
		//是否为异步请求
		async:false,
		//请求的路径
		url:'/goods/verifycodeerror',
		//接受的结果与处理方式
		success:function(res){
			if(res){
				flag=true;
			}else{
				$("#verifyCodeError").text("验证码填写错误")
				showError($("#verifyCodeError"))
				flag=false;
			}
		}
	})
	return flag
}


