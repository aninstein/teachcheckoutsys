

$(document).ready(function () {
	//点击登陆
	$("#ip_login_btn").click(function () {
		var username=$("#ip_username").val();
        var password=$("#ip_password").val();
        var path=$("#abspath").val();
//        alert(path+ServerAddress.TeacherLogin);
        if(checkEmail(username)){
        	
            $.post(path+ServerAddress.TeacherLogin,
                {
                    username:username,
                    password:password
                },
                function (data){
                	var result = JSON.parse(data);
                	var pagePath=JSON.stringify(result.pagePath);
                	var pageMessage=JSON.stringify(result.pageMessage);
                    if(pageMessage!='"200"'){
                        alert(pageMessage);
                    }
                    location.href = pagePath.substring(1, pagePath.length-1);//不做字符串剪切的话，会在路径里面留有两个“”
                });
            
		}
		else {
        	alert("邮箱格式不正确！");
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
		return false;
	}
}

