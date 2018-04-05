$(document).ready(function(){
	
	var sjid=localStorage.studentTapsjid;
	
	
	
	getSjFromServer(sjid);                               //get-->global_sj
	
	
	$("#p_commmit_sj").on("tapone",function(){
		
		
		var ansSj=getAnsSj(sjid);
		
		var checkedResult=checkAnsSjIsAllAns(ansSj);
		if(checkedResult!='')
		{
			alert(checkedResult);
			return ;
		}
		sendSjIsRightResultToServer(ansSj);
		
		
		
//		var sjIsRightResult=ToGetSjIsRightResult(global_sj,ansSj);
//		setTotal_p_sj_right_error(sjIsRightResult);
//		toSetSjPageIsRight(sjIsRightResult);
//		sendSjIsRightResultToServer(ansSj);
		
	});
	
	
	
});

var global_sj;


function checkAnsSjIsAllAns(ansSj)
{
	var checkedResult='';
	
	var anstis=ansSj.ansti;
	for (var i = 0; i < anstis.length; i++) {
		var ansti=anstis[i];
		
		anschoosetab=ansti.anschoosetab;
		if(anschoosetab==='')
		{
			checkedResult+="请将第"+(i+1)+"题回答完成\n";
		}
		
	}
	
	return checkedResult;
	
}



function sendSjIsRightResultToServer(ansSj)
{
	var ansSjStr=JSON.stringify(ansSj);
	
	$.post(ServerAddress.studentSendSjIsRightResultServer,
	{
		ansSjStr:ansSjStr
	},
     function(data,status)
     {
     	
     	var returnStr=$.parseJSON(data);
     	var rcode=returnStr.rcode;
     	
     	if(rcode*1==0)
     	{
// 			alert("请求成功");
   			
   			var sjIsRightResult=ToGetSjIsRightResult(global_sj,ansSj);
			setTotal_p_sj_right_error(sjIsRightResult);
			toSetSjPageIsRight(sjIsRightResult);

     	}
     	else
     	{
   			alert("rcode="+rcode);
     	}
     });
}

function setTotal_p_sj_right_error(sjIsRightResult)
{
	var $p_sj_right_error=$("#p_sj_right_error");
	
	var right_num=0;
	var error_num=0;
	
	for (var i = 0; i < sjIsRightResult.length; i++) 
	{
		if(sjIsRightResult[i]*1==1)
		{
			right_num=right_num+1;
		}
		else
		{
			error_num=error_num+1;
		}
	}
	
	$p_sj_right_error.text("正确题数:"+right_num+"          错误题数:"+error_num);
	$p_sj_right_error.css("visibility","visible");
}

function getAnsSj(sjid)
{
	var ansSj=new AnsSj();
	ansSj.sjid=sjid;
	
	var $div_ti_items=$(".div_ti_item");
	
	var $div_ti_choose_lists=$(".div_ti_choose_list");
	
	for (var i = 0; i < $div_ti_choose_lists.length; i++) 
	{
		
		var div_ti_item=$div_ti_items[i];
		
		var div_ti_choose_list=$div_ti_choose_lists[i];
		
		var ansti=new AnsTi();
		ansti.tiid=div_ti_item.index;
		
		var $div_choose_items=$(div_ti_choose_list).children(".div_choose_item");
		for (var j = 0; j < $div_choose_items.length; j++)
		{
			var div_choose_item=$div_choose_items[j];
			
			var p_choose_item_radio=$(div_choose_item).children(".p_choose_item_radio")[0];
			if(p_choose_item_radio.checked)
			{
				ansti.anschoosetab=j;
			}
			
		}
		
		ansSj.ansti[i]=ansti;
	}
	
//	alert("jjj="+JSON.stringify(ansSj));
	return ansSj;
}

function ToGetSjIsRightResult(sj,ansSj)
{
	var sjResult=[];
	
	var rightTinum=0;
	
	var sjTis=sj.ti;
	var ansTis=ansSj.ansti;
	
	for (var i = 0; i < sjTis.length; i++) 
	{
		var ti=sjTis[i];
		var ansTi=ansTis[i];
		
		if(ti.tirightchoosetab*1==ansTi.anschoosetab*1)
		{
			sjResult[i]=1;
		}
		else
		{
			sjResult[i]=0;
		}
	}
	
	return sjResult;
}


function toSetSjPageIsRight(sjIsRightResult)
{
	var $div_ti_item_header_isrights=$(".div_ti_item_header_isright");
	for (var i = 0; i < $div_ti_item_header_isrights.length; i++) {
		var div_ti_item_header_isright=$div_ti_item_header_isrights[i];
		
		if(sjIsRightResult[i]*1==1)
		{
			$(div_ti_item_header_isright).text("正确");
		}
		else
		{
			$(div_ti_item_header_isright).text("错误");
		}
		
		$(div_ti_item_header_isright).css("visibility","visible")
	}
	
	var $div_ti_item_header_right_choosetabs=$(".div_ti_item_header_right_choosetab");
	for (var i = 0; i < $div_ti_item_header_right_choosetabs.length; i++) 
	{
		$($div_ti_item_header_right_choosetabs[i]).css("visibility","visible")
	}
	
}


function getSjFromServer(sjid)
{
	$.post(ServerAddress.studentGetOneSJAllInfServlet,
	{
		sjid:sjid
	},
     function(data,status)
     {
     	
     	var returnStr=$.parseJSON(data);
     	var rcode=returnStr.rcode;
     	var sj=returnStr.jsonStr;
     	
//   	localStorage.sj=JSON.stringify(sj);
//		alert(JSON.stringify(sj));
     	
     	if(rcode*1==0)
     	{
// 			alert("获取成功");
			global_sj=sj;
			
			setSj(sj);
			setSjHeader(sj);

     	}
     	else
     	{
   			alert("rcode="+rcode);
     	}
     });
}

function setSj(sj1)
{
	var $div_ti_list=$("#div_ti_list");
	
	var sj=sj1;
	var teacher;
	
//	setSjHeader(sj,teacher);
	
	var tis=sj.ti;
//	alert(tis.length);
	
	for (var i = 0; i < tis.length; i++) {
		var ti=tis[i];
		
		var $div_ti_item=addTiitem($div_ti_list,ti);
		
		addTi_item_header($div_ti_item,ti);
		addTi_item_desc($div_ti_item,ti);
		var $div_ti_choose_list=addTi_choose_list($div_ti_item,ti);
		
		var choosetabs=ti.choosetab;
		for (var j = 0; j < choosetabs.length; j++) {
			var choosetab=choosetabs[j];
			
			addChoose_item($div_ti_choose_list,ti,choosetab);
			
		}
		
	}
	
	
}


function setSjHeader(sj)
{
	var teacher=$.parseJSON(localStorage.studentTapTeacher);
	
	$("#p_sj_teacher_nickname").text("出题人昵称: "+teacher.nickname);
	$("#p_sj_name").text("试卷名称: "+sj.sjname);
	
}

function addTiitem($div_ti_list,ti)
{
	var div_ti_item_text=
					'	<div class="div_ti_item">                         '+
					'	</div>                                            ';
	
	$div_ti_list.append(div_ti_item_text);
	var $this_item=$div_ti_list.children().last();
	
	$this_item[0].index=ti.tiid;             //**********************



	return 	$this_item;
}


function addTi_item_header($div_ti_item,ti)
{
	var div_ti_item_header_text=
						'	<div class="div_ti_item_header">                              '+
						'		<p class="div_ti_item_header_num">'+(ti.tinum*1+1)+'</p>					  '+
						'		<p class="div_ti_item_header_isright" style="visibility: hidden;">正确</p>			   '+
						'		<p class="div_ti_item_header_right_choosetab" style="visibility: hidden;" >'+"&nbsp;&nbsp;&nbsp;正确选项: "+(DigToChar(ti.tirightchoosetab*1+1))+'</p>	       '+
						'	</div>															';
	
	$div_ti_item.append(div_ti_item_header_text);
	var $this_item=$div_ti_item.children().last();
	
//	$this_item[0].index=onlySj.sjid;
	
	
	return 	$this_item;
}

function addTi_item_desc($div_ti_item,ti)
{
	var div_ti_item_desc_text= '<p class="div_ti_item_desc">'+(ti.tidesc)+'</p>';		
	
	
	$div_ti_item.append(div_ti_item_desc_text);
	var $this_item=$div_ti_item.children().last();
	
//	$this_item[0].index=onlySj.sjid;
	
	
	return 	$this_item;
}

function addTi_choose_list($div_ti_item,ti)
{
	var div_ti_choose_list_text=
						'	<div class="div_ti_choose_list">                '+
						'	</div>											';
	
	$div_ti_item.append(div_ti_choose_list_text);
	var $this_item=$div_ti_item.children().last();
	
//	$this_item[0].index=onlySj.sjid;
	
	
	return 	$this_item;
}

function addChoose_item($div_ti_choose_list,ti,choosetab)
{
	var div_choose_item_text=
							'	<div class="div_choose_item">                                                '+
							'		<input class="p_choose_item_radio" type="radio" name="ti'+(ti.tinum*1)+'" value="" />   '+
							'		<p class="p_choose_item_desc" >'+DigToChar(choosetab.choosetabnum*1+1)+":   "+(choosetab.choosetabdesc)+'</p>                          '+
							'	</div>                                                                      ';
	
	$div_ti_choose_list.append(div_choose_item_text);
	var $this_item=$div_ti_choose_list.children().last();
	
//	$this_item[0].index=onlySj.sjid;
	
	
	return 	$this_item;
}






