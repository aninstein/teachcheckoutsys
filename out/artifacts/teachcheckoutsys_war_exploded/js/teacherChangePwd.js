

$(document).ready(function () {
	//点击确认更改
	$("#ip_confirm_btn").click(function () {

        var path=$("#abspath").val();

		var orgpassword=$("#org_password").val();
        var newpassword=$("#new_password").val();
        var renewpassword=$("#renew_password").val();
        if(newpassword!=renewpassword){
        	alert("两次输入密码不一致！");
            reset()
		} else if(orgpassword==renewpassword){
            alert("不能与当前密码相同！");
            reset()
		}else {
            $.post(path+ServerAddress.TeachersChangePwd,
                {
                    orgpassword:orgpassword,
                    newpassword:newpassword
                },
                function (data){
                    var result = JSON.parse(data);
                    var statu =JSON.stringify(result.statu);
                    var pagePath=JSON.stringify(result.pagePath);
                    var pageMessage=JSON.stringify(result.pageMessage);
                    alert(pageMessage);
					if(statu!='"200"'){
                        reset()
					}else {
						//注销登陆
						$.get(path+ServerAddress.Teacherlogout,{});
						location.href=pagePath.substring(1,pagePath.length-1);
					}
                });
		}
    });
	
	//点击取消
	$("#ip_cancel_btn").click(function () {
        window.history.back(-1);
    });
	
});

function reset() {
    $("#org_password").val("");
    $("#new_password").val("");
    $("#renew_password").val("");
}

