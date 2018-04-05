$(document).ready(function(){
	
	getOnlySjListStr();
	
	
});


function getOnlySjListStr()
{
	var teacherid=localStorage.studentTapTeacherId;
	
	$.post(ServerAddress.teacherCommitSJToGetServlet,
	{
		teacherid:teacherid
	},
     function(data,status)
     {
     	
     	var returnStr=$.parseJSON(data);
     	var rcode=returnStr.rcode;
     	var onlySjList=returnStr.jsonStr;
     	
//	         	var sjname=onlySjList[0].sjname;
//	         	decodeURI()解码    encodeURI()转码
//				sjname=decodeURI(sjname);
		
		var onlySjListStr=JSON.stringify(onlySjList);
		localStorage.onlySjListStr=onlySjListStr;
     	
     	if(rcode*1==0)
     	{
     		if(onlySjList.length==0)
     		{
     			$("body").text("Ta很懒 ，还没有出试题");
     		}
     		
// 			alert("获取成功");
			var $div_sj_list=$("#div_sj_list");
			for (var i = 0; i < onlySjList.length; i++) {
				
				add_ti_item($div_sj_list,i);
				
			}
   			
     	}
     	else
     	{
   			alert("rcode="+rcode);
     	}
     });
	         
}

function add_ti_item($div_ti_list,i)
{
	var teacher=$.parseJSON(localStorage.studentTapTeacher);
	
	var onlySjList=$.parseJSON(localStorage.onlySjListStr);
	var onlySj=onlySjList[i];
	
	var div_sj_item_text=
						'	<div class="div_sj_item">                         '+
						'		<p class="p_sj_tag">标记:'+onlySj.sjtag+'</p>                  '+
						'		<p class="p_sj_name">'+onlySj.sjname+'</p>            '+
						'		<p class="p_sj_note">试卷备注:'+onlySj.sjnote+'</p>            '+
						'		<p class="p_sj_teacher">'+teacher.nickname+'</p>               '+
						'	</div>                                             ';
	
	$div_ti_list.append(div_sj_item_text);
	var $this_item=$(div_sj_list).children().last();
	$this_item[0].index=onlySj.sjid;
	
	addEventToTiItem($this_item,onlySj);
	
	return 	$this_item;
}

function addEventToTiItem($this_item,onlySj)
{
	$this_item.on("tapone",function(){
		
//		localStorage.studentTapsjid=$this_item[0].index;
		
		var sjcheckedcode=prompt("请输入此试卷的答题验证码","");
		
		if(sjcheckedcode===null)      //点击了prompt的取消按钮
		{
			return ;
		}
		
		if(sjcheckedcode!==onlySj.sjcheckedcode)
		{
			alert("此试卷的答题验证码错误    请重试");
			return ;
		}
		
		
		
		localStorage.studentTapsjid=$this_item[0].index;
		
		location.href = "studentLookOneSj.html";

	});
	
}

