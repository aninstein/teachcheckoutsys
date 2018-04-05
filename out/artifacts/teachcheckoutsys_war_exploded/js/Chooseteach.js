(document).ready(function() {

	getPassTeacherList();
});


function getPassTeacherList() {
	
	$.post(ServerAddress.studentGetAllPassTeacher, {

		},
		function(data, status) {
			var returnStr = $.parseJSON(data);
			var rcode = returnStr.rcode;
			var passteacherList = returnStr.passteacherList;

			if (rcode * 1 == 0) {
//				alert("获得教师列表的数据成功 ");
//					       			console.log(JSON.stringify(passteacherList));
				
				showTeacherList(passteacherList);
			} 
			else 
			{
				alert("rcode=" + rcode);
			}
		});
		

}

function showTeacherList(passteacherList)
{
	$div_teacher_list=$("#div_teacher_list");
//	alert(passteacherList.length);
	
	for (var i = 0; i < passteacherList.length; i++) {
		
		var teacher=passteacherList[i];
		
		add_teacher_item($div_teacher_list,teacher,i+1);
		
	}
	
	addTapEvent(passteacherList);
}

function add_teacher_item($div_teacher_list,teacher,i)
{
	
	//***+*******
	var div_teacher_item_text=
						'	<li><div class="left-element"><h1>'+i+'</h1></div> <div class="text div_teacher_item">          '+ 
						'		<span class="title">教师姓名：'+teacher.realname+'</span>   '+   						
						'		<span class="subtitle">任教课程：'+teacher.nickname+'</span> '+
						'	</div></li>      ';
	$div_teacher_list.append(div_teacher_item_text);
	var $this_item=$div_teacher_list.children().last();
							
	return $this_item;
}

function addTapEvent(passteacherList)
{
	var $div_teacher_items=$(".div_teacher_item");
	
	for (var i = 0; i < $div_teacher_items.length; i++) {
		div_teacher_item=$div_teacher_items[i];
		
		div_teacher_item.index=i;
		
		$(div_teacher_item).on("tapone",function(){
			
			var teacherid=passteacherList[this.index].teacherid;
			
//			alert(teacherid);
			localStorage.studentTapTeacherId=teacherid;
			
			localStorage.studentTapTeacher=JSON.stringify(passteacherList[this.index]);  //***
			
			location.href = "studentLookSjList.html";
			
		});
		
	}
}





