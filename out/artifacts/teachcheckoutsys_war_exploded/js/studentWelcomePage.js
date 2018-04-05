function Qiandao(){
	var sno=$("#ip_sno").val();
	var sname=$("#ip_sname").val();
	
	$.post("InsertQianDaoServlet",
		{
			sno:sno,
			sname:sname
		},
		function(data,status){
			if(data==1)
			{
				alert("您好，"+sname+"欢迎登录师生实时答题系统！");
				location.href = "studentLookTeacherList.html";
			}
		});
}