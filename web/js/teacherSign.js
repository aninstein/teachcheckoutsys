

$(document).ready(function () {
	//点击登陆
	$("#ip_sign").click(function () {
		var teacherId=$("#teacherId").val();
        var username=$("#username").val();
        var email=$("#email").val();
        var password=$("#password").val();
        var repassword=$("#repassword").val();
        
        
        var path=$("#abspath").val();
//      alert(path+ServerAddress.TeacherLogin);
		if (password != repassword) {
			alert("两次密码不一致！");
		} else {
			if (checkEmail(email)&&checkUsername(username)) {
				$.post(path + ServerAddress.TeacherSign,
					{
						teacherId : teacherId,
						username : username,
						email : email,
						password : password
					},
					function(data) {
						var result = JSON.parse(data);
						var pagePath = JSON.stringify(result.pagePath);
						var pageMessage = JSON.stringify(result.pageMessage);
						if (pageMessage.length != 0) {
							alert(pageMessage);
						}
						location.href = pagePath.substring(1, pagePath.length - 1); //不做字符串剪切的话，会在路径里面留有两个“”
					});
			}
		}
	});
	
	//点击注册
	$("#ip_sign_btn").click(function () {
		location.href = "teacher_sign.jsp";
    });
	
});

function checkEmail(text){
	var re=/^[^\s]+@[^\s]+\.[^\s]+$/;
	
	if(re.test(text))
	{
		return true;
	}
	else
	{
		alert("邮箱格式不正确！");
		return false;
	}
}

function checkUsername(user){
	var re=/^[a-zA-Z]{1}[0-9a-zA-Z]{5,15}$/;
	if(re.test(user))
	{
		return true;
	}
	else
	{
		alert("用户名格式不正确！");
		return false;
	}
}

