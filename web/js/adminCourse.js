var condi = $("#mysearch").val();
var path=$("#abspath").val();
var admin=$("#admin").val();

//上课日数组
var classtimeid=0;


$(document).ready(function () {
    path = $("#abspath").val();
    admin=$("#admin").val();
    getTable(condi);

    $("#fileupload").hide();
    $("#classadd").hide();

    //显示上传导入的控件
    $("#addstufile").click(function () {
        $("#fileupload").show();
        $("#classadd").hide();
    });

    //显示添加课程的控件
    $("#addstu").click(function () {
        $("#fileupload").hide();
        $("#classadd").show();
    });

    //添加一个上课时间
    $("#addclasstimebtn").click(function () {
        var classtime=[];
        classtime.push('<span id="oneclass'+classtimeid+'">&nbsp;&nbsp;'+(classtimeid+2)+'、<select class="form-control" name="classweekday">');
        classtime.push('	<option value="1">星期一</option>');
        classtime.push('	<option value="2">星期二</option>');
        classtime.push('	<option value="3">星期三</option>');
        classtime.push('	<option value="4">星期四</option>');
        classtime.push('	<option value="5">星期五</option>');
        classtime.push('	<option value="6">星期六</option>');
        classtime.push('	<option value="7">星期日</option>');
        classtime.push('</select>');
        classtime.push('<select class="form-control" name="classtno">');
        classtime.push('	<option selected="selected" value="1、2节">1、2节</option>');
        classtime.push('	<option value="3、4节">3、4节</option>');
        classtime.push('	<option value="5、6节">5、6节</option>');
        classtime.push('	<option value="7、8节">7、8节</option>');
        classtime.push('	<option value="10节">10节</option>');
        classtime.push('	<option value="11节">11节</option>');
        classtime.push('	<option value="12节">12节</option>');
        classtime.push('</select></span>');
        $("#classtime").append(classtime.join(""));
        classtimeid++;

        $("#subclasstimebtn").attr("style",function () {
           return "display:inline";
        });
    });

    //减少一个上课时间
    $("#subclasstimebtn").click(function () {
        classtimeid--;
        $("#oneclass"+classtimeid).remove();
        if(classtimeid==0){
            $("#subclasstimebtn").attr("style",function () {
                return "display:none";
            });
        }
    });

    //添加课程
    $("#add_btn").click(function () {
        var week=$("select[name='classweekday']");
        var classtno=$("select[name='classtno']");
        var weekdays=[];
        var classtnotime=[];
        $.each(week,function () {
            weekdays.push($(this).val());
        });
        $.each(classtno,function () {
            classtnotime.push($(this).val());
        });
        var data={
            "teacher" : $("#teacher").val(),
            "stunum" : $("#stunum").val(),
            "grade" : $("#grade").val(),
            "name" : $("#name").val(),
            "location" : $("#location").val(),
            "week":weekdays.join(","),
            "majorlist" : $("#major").val().replace("，",","),
            "courseid" : $("#courseid").val(),
            "classtime" : classtnotime.join(",")
        };
        doAjax(data,path+ServerAddress.CourseAdd);
    });

    //取消
    $("input[name='add_cancel']").click(function () {
        resetfile();
        $("#fileupload").hide();
        $("#classadd").hide();
    });

});

//获取表格数据
function getTable(condition) {
    $.ajax({
        type:"POST",
        url:path+ServerAddress.GetCoursesList,
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
                tbody.push('<tr>');
                tbody.push('    <td><input type="checkbox" id="checkbox'+json[i].courseid+'" name="checkboxdel" onclick="addonedelbtn()" value="'+json[i].coursesid+'"></td>');
                tbody.push('    <td>'+(i+1)+'</td>');
                tbody.push('    <td id="coursesid'+json[i].id+'">'+json[i].coursesid+'</td>');
                tbody.push('    <td id="coursesname'+json[i].id+'">'+json[i].coursesname+'</td>');
                tbody.push('    <td id="coursesmajor'+json[i].id+'">'+json[i].coursesmajor.join(",")+'</td>');
                tbody.push('    <td id="coursesgrade'+json[i].id+'">'+json[i].coursesgrade+'</td>');
                tbody.push('    <td id="coursesteacher'+json[i].id+'">'+json[i].coursesteacher+'</td>');
                tbody.push('    <td id="coursesstunum'+json[i].id+'">'+json[i].coursesstunum+'</td>');
                tbody.push('    <td id="coursesplace'+json[i].id+'">'+json[i].coursesplace+'</td>');
                tbody.push('    <td id="coursesweek'+json[i].id+'">'+json[i].coursesweek+'</td>');
                tbody.push('    <td id="coursestime'+json[i].id+'">'+json[i].coursestime+'</td>');
                tbody.push('    <td>');
                tbody.push('        <button class="btn btn-success" onclick="eidt('+json[i].id+')" id="updateThis'+json[i].id+'">修改</button>');
                tbody.push('        <button class="btn btn-danger" onclick="deleteThis(\''+json[i].coursesid+'\')" id="deleteThis'+json[i].id+'">删除</button>');
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


//修改课程信息
function eidt(i) {
    $("#updateThis"+i).html("确认");
    $("#updateThis"+i).attr("onclick",function () {
        return "updateThis("+i+")";
    });
    $("#updateThis"+i).attr("class",function () {
        return "btn btn-primary";
    });


    /*
     * 最复杂的在这里！
     * */


}


//批量删除,先添加两个摁纽
function addonedelbtn() {
    var twobtn=[];
    twobtn.push('<button class="btn btn-danger" onclick="batchdel()">删除</button>&nbsp;');
    twobtn.push('<button class="btn btn-success" onclick="allselect()" id="allselect">全选</button>');
    $("#checkboxcol").html(twobtn.join(""));
}

//删除课程
function deleteThis(id) {
    layer.confirm("你确定要删除课程编号为："+id+" 的课程么？",{
        btn:["删除","取消"],
        yes:function () {
            var data={"delid": id};
            doAjax(data,path + ServerAddress.CourseDlete);
        }
    });
}

//真正执行批量删除
function batchdel() {
    var delArr=[];
    var count=0;
    $('input[name="checkboxdel"]:checked').each(function() {
        delArr.push($(this).val());
        count++;
    });
    layer.confirm('您确定要删除这 '+count+'项么？', {
        btn: ['删除','取消'] //按钮
        ,yes: function(){
            var data={
                batch:'batch',
                delid:delArr.join(",")
            };
            doAjax(data,path+ServerAddress.CourseDlete)
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

//搜索
function searchThis(){
    condi=$("#mysearch").val();
    if(condi.length!=0) {
        getTable(condi);
    }
}

//ajax
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