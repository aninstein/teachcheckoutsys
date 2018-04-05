

$(document).ready(function(){
	
	//后面还要增加课程、班级
	$("#confirmchange").click(function(){
		var path=$("#abspath").val();
        var Id=$("#Id").val();
		var teacherId=$("#teacherId").val();
		var name=$("#myname").val();
		var teachlevel=$("#teachlevel").val();
		var username=$("#myusername").val();
		var email=$("#myemail").val();
		var tel=$("#mytel").val();
		var courseArray=getArrayByName('button','courses');
		$.ajax({
			type: "POST",
			url: path+ServerAddress.TeacherInfoModify,
			data:{
                Id:Id,
                teacherId:teacherId,
				name:name,
                teachlevel:teachlevel,
				username:username,
				email:email,
				tel:tel,
                courseArray:courseArray.join(",")//转换成字符串传递，到后台解析
			},
			dataType: "JSON",
            success: function(data,xhr){
				var result=eval(data);
				var statu=result.statu;
                var pagePath=result.pagePath;
                var pageMessage=result.pageMessage;
                alert(pageMessage);
                location.href = pagePath;//不做字符串剪切的话，会在路径里面留有两个“”
			},
			error: function(){
				alert("请求失败！");
			}
		});
		
	});
	
	
	//搜索课程
	$("#addcourse").keypress(function(){
		var path=$("#abspath").val();
		var addcourse=$("#addcourse").val();
		$.ajax({
            type: "POST",
            url: path+ServerAddress.TeacherGetCourseList,
            data: {
            	addcourse:addcourse
            },
            dataType: "JSON",
            beforeSend: function(){
            	var licon=[];
            	licon.push('<i class="fa fa-spinner fa-spin fa-2x fa-fw"></i>');
            	licon.push('<span class="sr-only">Loading...</span>');
            	$("#courseListLi").html(licon.join(""));
            },
            success: function(data){
            	if(data==null){
            		
            	}else{
	            	var result = eval(data);
	            	$("#courseListLi").html("");
	            	var i=0;
	            	$.each(result,function(){
	            		var licon=[];
	                	licon.push('<li><a href="javascript:void(0);" onclick="addcourse(\''+result[i].courseName+'\')"><div class="text">');
	                	licon.push('<span class="title">'+result[i].courseName+'</span>&nbsp;&nbsp;');
	                	licon.push('<span class="subtitle">'+result[i].courseId+'</span>');
	                	licon.push('</div></a></li>');
	                	$("#courseListLi").append(licon.join(""));
	                	i++;
	            	});
            	}
			}
        });
		
	});
});

function addcourse(course){
	//获取当前已经选择的课程数组
    var mycourse=getArrayByName('button','courses');
    //把点击选择的放进数组
    mycourse.push(course);
    //数组去重
    var mySet=new Set(mycourse);
    mycourse=Array.from(mySet);

    //清空当前
    $("#mycoures").html("");

    var licon=[];
    //i复原为0
    var i=0;
    $.each(mycourse,function(){
        // mycourse.push($(chcourse[i]).html());
		if(mycourse[i]!="无") {
            licon.push('<button class="btn btn-wide btn-primary btn-xs" name="courses" id="courses' + i + '" onclick="removebtn(\'courses' + i + '\')">' + mycourse[i] + '</button>&nbsp;');
            i++;
        }
    });
    $("#mycoures").append(licon.join(""));
}

//根据name取数组
function getArrayByName(element,name){
	var nameArray=$(element+"[name='"+name+"']");
	var array=[];
	var i=0;
	$.each(nameArray,function(){
        array.push($(nameArray[i]).html());
        i++;
	});
	return array;
}

function removebtn(deletebtn) {
    $("#"+deletebtn).remove();
}