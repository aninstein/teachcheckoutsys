var condi = $("#mysearch").val();
var path=$("#abspath").val();
var admin=$("#admin").val();
$(document).ready(function () {
    path = $("#abspath").val();
    admin=$("#admin").val();
    getTable(condi);

    $("#addstufile").click(function () {
        var path = $("#abspath").val();
        $("#addspace").html("");
        var space = [];
        space.push('<div class="panel">');
        space.push(' <div class="panel-content">');
        space.push('     <div class="row">');
        space.push('         <div class="col-md-12">');
        space.push('             <form class="form-inline"  enctype="multipart/form-data"  method="post" id="dataForm">');
        space.push('                 <h5 class="mb-lg ">教师列表导入</h5>');
        // space.push('                 <input type="hidden" id="path" name="path" value="teacher" /><!-- 告诉后台我这是什么文件类型 -->');
        // space.push('                 <input type="hidden" id="isInsert" name="isInsert" value="true" /><!-- 给后台传递确认导入信号 -->');
        space.push('                 <input type="hidden" id="serviceName" name="serviceName" value="teacher" /><!-- 告诉后台我这是什么文件类型 -->');
        space.push('                 <input type="hidden" id="path" name="path" value="teachsys/upload" /><!-- 给后台传递确认导入信号 -->');
        space.push('                 <input type="hidden" id="fileName" name="fileName" value="教师表模板" /><!-- 告诉后台我这是什么文件类型 -->');
        space.push('                 <input type="hidden" id="ext" name="ext" value="xls" /><!-- 给后台传递确认导入信号 -->');
        space.push('                 <div class="form-group">');
        space.push('                     <span>');
        space.push('						<a class="btn btn-wide btn-o btn-success btn-lg" id="afile" href="javascript:void(0);">选择文件');
        space.push('                        <input type="file" name="file1" id="file1" /></a>');
        space.push('					</span>');
        space.push('				</div>');
        space.push('				<div class="form-group">');
        space.push('				<span id="spanFile">·只能上传后缀名为.xls、.xlsx文件</span>');
        space.push('				</div>');
        space.push('				<br><br>');
        space.push('                 <div class="form-group">');
        space.push('                     <input type="button" class="btn btn-wide btn-primary" onclick="uploadTable()" value="确认导入"/>');
        space.push('					<input type="button" class="btn btn-wide btn-warning" onclick="resetfile()" value="重新选择"/>');
        space.push('					<input type="button" class="btn btn-wide" id="add_cancel" onclick="cancel()" value="取消"/>');
        space.push('                 </div>');
        space.push('             </form>');
        space.push('         </div>');
        space.push('     </div>');
        space.push(' </div>');
        space.push('</div>');
        $("#addspace").append(space.join(""));
        //再动态加载一次js
    });

    $("#addstu").click(function () {
        $("#addspace").html("");
        var space = [];
        space.push('<div class="panel">');
        space.push('    <div class="panel-content">');
        space.push('        <div class="row">');
        space.push('            <div class="col-md-12">');
        space.push('                <form class="form-inline" id="addfrom"><h5 class="mb-lg ">请输入教师信息</h5>');
        space.push('                    <div class="form-group">');
        space.push('                        <span>姓名:<input type="text" class="form-control" id="name" name="name" placeholder="姓名"></span></div>&nbsp;&nbsp;');
        space.push('                    <div class="form-group">');
        space.push('                        <span>用户名:<input type="text" class="form-control" id="username" name="username" placeholder="用户名"></span></div>&nbsp;&nbsp;');
        space.push('					<div class="form-group">');
        space.push('                        <span>教师编号:<input type="text" class="form-control" id="teacherNo" name="teacherNo" placeholder="教师编号"></span></div>&nbsp;&nbsp;');
        space.push('                    <br><br>');
        space.push('                    <div class="form-group">');
        space.push('                        <span>邮箱:<input type="email" class="form-control" id="email" name="email" placeholder="邮箱"></span></div>&nbsp;&nbsp;');
        space.push('                    <div class="form-group">');
        space.push('                        <span>电话:<input type="text" class="form-control" id="tel" name="tel" placeholder="电话"></span></div>&nbsp;&nbsp;');
        space.push('					<div class="form-group"><span>职称:');
        space.push('						<select id="teachlevel" name="teachlevel">');
        space.push('									<option value="助教">助教</option>');
        space.push('									<option value="讲师">讲师</option>');
        space.push('									<option value="高级讲师">高级讲师</option>');
        space.push('									<option value="副教授">副教授</option>');
        space.push('									<option selected="selected" value="教授">教授</option>');
        space.push('						</select></span></div><br><br>');
        space.push('                   <div class="form-group">');
        space.push('                        <button type="button" class="btn btn-primary" id="add_btn" onclick="addbtn()" >添加</button>');
        space.push('					    <button type="button" class="btn btn-primary" id="add_cancel" onclick="cancel()">取消</button>');
        space.push('                    </div>');
        space.push('                </form>');
        space.push('            </div>');
        space.push('        </div>');
        space.push('    </div>');
        space.push('</div>');
        $("#addspace").append(space.join(""));
        //再动态加载一次js
    });

});

//选择文件时候的操作
$(document).on('change', '#file1', function () {
    var file = $("#file1").val();
    /*获取文件名部分*/
    var strFileName = file.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi, "$1");  //正则表达式获取文件名，不带后缀
    var FileExt = file.replace(/.+\./, "");   //正则表达式获取后缀
    if (FileExt == "xls" || FileExt == "xlsx") {
        var fileName = strFileName.trim() + '.' + FileExt.trim();

        //给input赋值
        $("#fileName").val(strFileName.trim());
        $("#ext").val(FileExt.trim());

        //改变a标签样式
        $("#afile").attr("class", function () {
            return "btn btn-wide btn-success btn-lg";
        });
    }
    else {
        alert("只能上传后缀名为.xls或者.xlsx的文件！");
        return;
    }
    $("#spanFile").html("文件名：" + fileName);
});

//上传导入表格
function uploadTable() {
    var formData = new FormData($("#dataForm")[0]);
    $.ajax({
        type: "POST",
        url: ServerAddress.uploadFilesOSS,
        data: formData,
        contentType: false,
        processData: false,
        async:false,
        beforeSend:function () {
            layer.load();
        },
        complete: function (e, xhr, settings) {
            var result = JSON.parse(e.responseText);
            if (e.status === 200) {
                $.ajax({
                    type: "POST",
                    url: path+ServerAddress.TeacherAddByExcel,
                    data: {
                        downurl:result.filePath,
                        author:$("#teacherid").val(),
                        authorname:$("#teachername").val(),
                        type:$("#serviceName").val(),
                        filename:$("#fileName").val()+"."+$("#ext").val()
                    },
                    async:false,
                    dataType:"json",
                    beforeSend:function () {
                        layer.load();
                    },
                    success:function (data,xhr) {
                        if(data.contain.length!=0){
                            layer.confirm('教师编号'+data.contain+'已存在，是否覆盖？', {
                                btn: ['覆盖', '取消']
                                ,yes: function(){
                                    layer.msg("没有这个功能！哈哈哈哈！");
                                    layer.msg(data.pageMessage);
                                    location.href=data.pagePath;
                                }
                            });
                        }else {
                            layer.msg(data.pageMessage);
                            location.href=data.pagePath;
                        }

                    },
                    error:function () {
                        layer.msg("读取失败!");
                    }
                });
            } else {
                layer.msg(e.status);
            }
        }
    });
}

//获取表格数据
function getTable(condition) {
    $.ajax({
        type:"POST",
        url:path+ServerAddress.GetTeachersList,
        data:{
            admin:admin,
            condition:condition
        },
        dataType:"json",
        success:function (json,xhr) {
            $("#tbody").html("");
            var i=0;
            $.each(json,function () {
                var tbody=[];
                var courseStr=json[i].teachercourse.toString().replace(",","-#-");
                var classStr=json[i].teacherclass.toString().replace(",","-#-");
                tbody.push('<tr>');
                tbody.push('    <td><input type="checkbox" id="checkbox'+json[i].id+'" name="checkboxdel" onclick="addonedelbtn()" value="'+json[i].teacherid+'" /></td>');
                tbody.push('    <td>'+(i+1)+'</td>');
                tbody.push('    <td id="teachername'+json[i].id+'">'+json[i].teachername+'</td>');
                tbody.push('    <td id="teacherusername'+json[i].id+'">'+json[i].teacherusername+'</td>');
                tbody.push('    <td id="teacherid'+json[i].id+'">'+json[i].teacherid+'</td>');
                tbody.push('    <td id="teacheremail'+json[i].id+'">'+json[i].teacheremail+'</td>');
                tbody.push('    <td id="teachertel'+json[i].id+'">'+json[i].teachertel+'</td>');
                tbody.push('    <td id="teacherlevel'+json[i].id+'">'+json[i].teacherlevel+'</td>');
                tbody.push('    <td><input type="checkbox" id="setadmin'+json[i].id+'" name="setadmin" onclick="setadmin('+json[i].teacherid+')"></td>');
                tbody.push('    <td><button class="btn btn-primary">查看课程</button></td>');
                tbody.push('    <td><button class="btn btn-primary">查看班级</button></td>');
                tbody.push('    <td>');
                tbody.push('       <button class="btn btn-success " onclick="eidt('+json[i].id+')" id="updateThis'+json[i].id+'">修改</button>');
                tbody.push('       <button class="btn btn-danger " onclick="deleteThis(\''+json[i].teacherid+'\')" id="deleteThis'+json[i].id+'">删除</button>');
                tbody.push('    </td>');
                tbody.push('</tr>');
                $("#tbody").append(tbody.join(""));
                if(Number(json[i].teacherstatu)==3){
                    $("#setadmin"+json[i].id).attr("checked", true);
                }
                i++;
            });

        },
        error:function () {
            layer.msg("请求失败！");
        }
    });
}

//添加教师
function addbtn(){
    var teachlevel = $("#teachlevel").val();
    var name = $("#name").val();
    var tel = $("#tel").val();
    var teacherNo = $("#teacherNo").val();
    var email = $("#email").val();
    var username = $("#username").val();
    var data={
        "teachlevel":teachlevel,
        "name":name,
        "tel":tel,
        "teacherNo":teacherNo,
        "email":email,
        "username":username
    };
    doAjax(data,path+ServerAddress.TeacherAdd);
}

//取消
function cancel() {
    var file = $("#file1").val(null);
    resetfile();
    $("#addspace").empty();
}

//重置文件
function resetfile() {
    var file = $("#file1").val(null);
    $("#spanFile").html("·只能上传后缀名为.xls、.xlsx文件");
    $("#afile").attr("class",function(){
        return"btn btn-wide btn-o btn-success btn-lg";
    });
}

//加载动画
function subloading() {
    var ii = layer.load();
}

//修改教师信息
function eidt(i) {
    $("#updateThis"+i).html("确认");
    $("#updateThis"+i).attr("onclick",function () {
        return "updateThis("+i+")";
    });
    $("#updateThis"+i).attr("class",function () {
        return "btn btn-primary";
    });
    var teachlevel = $("#teacherlevel"+i).html();
    var name = $("#teachername"+i).html();
    var tel = $("#teachertel"+i).html();
    var teacherNo = $("#teacherid"+i).html();
    var email = $("#teacheremail"+i).html();
    var username = $("#teacherusername"+i).html();

    $("#teacherlevel"+i).html('<input type="text" class="form-control" id="inpteachlevel'+i+'" name="inpteachlevel" placeholder="职称" value="'+teachlevel+'" />');
    $("#teachername"+i).html('<input type="text" class="form-control" id="inpname'+i+'" name="inpname" placeholder="姓名" value="'+name+'" />');
    $("#teachertel"+i).html('<input type="text" class="form-control" id="inptel'+i+'" name="inptel" placeholder="电话" value="'+tel+'" />');
    $("#teacherid"+i).html('<input type="text" class="form-control" id="inpteacherNo'+i+'" name="inpteacherNo" placeholder="教师编号" value="'+teacherNo+'" />');
    $("#teacheremail"+i).html('<input type="text" class="form-control" id="inpemail'+i+'" name="inpemail" placeholder="邮箱" value="'+email+'" />');
    $("#teacherusername"+i).html('<input type="text" class="form-control" id="inpusername'+i+'" name="inpusername" placeholder="用户名" value="'+username+'" />');


}

//确认修改
function updateThis(i) {
    var data={
        "admin":admin,
        "teachlevel":$("#inpteachlevel"+i).val(),
        "name":$("#inpname"+i).val(),
        "tel":$("#inptel"+i).val(),
        "teacherId":$("#inpteacherNo"+i).val(),
        "email":$("#inpemail"+i).val(),
        "username":$("#inpusername"+i).val(),
        "Id":i
    }
    doAjax(data,path+ServerAddress.TeacherInfoModify);
}

//删除学生
function deleteThis(id) {
    if(confirm("你确定要删除教师编号为："+id+" 的老师么？")) {
        var data={"delid": id};
        doAjax(data,path + ServerAddress.TeachersDelete);
    }
}

//批量删除
function addonedelbtn() {
    var twobtn=[];
    twobtn.push('<button class="btn btn-danger" onclick="batchdel()">删除</button>&nbsp;');
    twobtn.push('<button class="btn btn-success" onclick="allselect()" id="allselect">全选</button>');
    $("#checkboxcol").html(twobtn.join(""));
}

//真正执行删除
function batchdel() {
    var delArr=[];
    var count=0;
    $('input[name="checkboxdel"]:checked').each(function() {
        delArr.push($(this).val());
        count++;
    });
    layer.confirm('您确定要删除这 '+count+'项么？', {
        btn: ['是的','取消'] //按钮
    ,yes: function(){
            var data={
                batch:'batch',
                delid:delArr.join(",")
            };
            doAjax(data,path+ServerAddress.TeachersDelete)
        }
    });
}

//全选
function allselect(){
    $("input[name='checkboxdel']").each(function() {
        $(this).attr("checked", true);
    });
    $("#allselect").attr("onclick","allnotselect()");
    $("#allselect").attr("class","btn btn-warning");
    $("#allselect").html("全不选");
}

//全不选
function allnotselect() {
    $("input[name='checkboxdel']").each(function() {
        $(this).attr("checked", false);
    });
    $("#allselect").attr("onclick","allselect()");
    $("#allselect").attr("class","btn btn-success");
    $("#allselect").html("全选");
}

//搜索教师
function searchThis() {
    condi=$("#mysearch").val();
    if(condi.length!=0) {
        getTable(condi);
    }
}

//设置管理员
function setadmin(teacherid){
    var data={
        "admin":admin,
        "teacherid":teacherid
    };
    doAjax(data,path+ServerAddress.SetAdmin)
}

function doAjax(data,url){
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        dataType:"json",
        // async:false,
        beforeSend:function () {
            layer.load();
        },
        success: function (redata, xhr, settings) {
            layer.msg(redata.pageMessage);
            if(redata.pagePath.length!=0){
                location.href=redata.pagePath;
            }
            getTable("");
        },
        error:function () {
            layer.msg("请求失败！");
        }
    });
}