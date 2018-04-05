var condi = $("#mysearch").val();
$(document).ready(function () {
    studentTable(condi);
    $("#addstufile").click(function () {
        var path = $("#abspath").val();
        $("#addspace").html("");
        var space = [];
        space.push('<div class="panel">');
        space.push(' <div class="panel-content">');
        space.push('     <div class="row">');
        space.push('         <div class="col-md-12">');
        space.push('             <form class="form-inline" action="' + path + ServerAddress.UploadFile + '" enctype="multipart/form-data"  method="post" id="fromStudent">');
        space.push('                 <h5 class="mb-lg ">学生列表导入</h5>');
        space.push('                 <input type="hidden" id="path" name="path" value="student" /><!-- 告诉后台我这是什么文件类型 -->');
        space.push('                 <input type="hidden" id="isInsert" name="isInsert" value="true" /><!-- 给后台传递确认导入信号 -->');
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
        space.push('                     <input type="submit" class="btn btn-wide btn-primary" onclick="subloading()" value="确认导入"/>');
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
        jQuery.getScript("../js/adminStudent.js");
    });

    $("#addstu").click(function () {
        $("#addspace").html("");
        var space = [];
        space.push('<div class="panel">');
        space.push('    <div class="panel-content">');
        space.push('        <div class="row">');
        space.push('            <div class="col-md-12">');
        space.push('                <form class="form-inline" id="addfrom"><h5 class="mb-lg ">请输入学生信息</h5>');
        space.push('                    <div class="form-group">');
        space.push('                        <span>姓名:<input type="text" class="form-control" id="name" name="name" placeholder="姓名"></span></div>&nbsp;&nbsp;');
        space.push('                    <div class="form-group">');
        space.push('                        <span>学号:<input type="text" class="form-control" id="stuno" name="stuno" placeholder="学号"></span></div>');
        space.push('                    <br><br>');
        space.push('                    <div class="form-group">');
        space.push('                    <span>性别:&nbsp;&nbsp;&nbsp;&nbsp;');
        space.push('                    男&nbsp;<input type="radio" id="sex1" name="sex" value="男">&nbsp;&nbsp;&nbsp;&nbsp;');
        space.push('                    女&nbsp;<input type="radio" id="sex2" name="sex" value="女"></span></div>');
        space.push('                    <div class="form-group">');
        space.push('                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;');
        space.push('                        <span>年龄:<input type="number" class="form-control" id="age" name="age" value=20 step=1></span></div>');
        space.push('                    <br><br>');
        space.push('                    <div class="form-group">');
        space.push('                        <span>年级:<input type="number" class="form-control" id="stulevel" name="stulevel" placeholder="年级" value=2017 step=1></span></div>&nbsp;&nbsp;');
        space.push('                    <div class="form-group">');
        space.push('                        <span>专业:<input type="text" class="form-control" id="stumajor" name="stumajor" placeholder="专业"></span></div>&nbsp;&nbsp;');
        space.push('                    <div class="form-group">');
        space.push('                        <span>班级:<input type="text" class="form-control" id="stuclass" name="stuclass" placeholder="班级"></span></div><br><br>');
        space.push('                    <div class="form-group">');
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
        jQuery.getScript("../js/adminStudent.js");
    });

});

//加载动画
function subloading() {
    var ii = layer.load();
    //15秒后还没转跳就表示失败了！
    //  setTimeout(function(){
    //      layer.close(ii);
    //      alert("操作失败!");
    //  }, 10000);
}

//添加学生
function addbtn() {
    var path = $("#abspath").val();
    var name = $("#name").val();
    var stuno = $("#stuno").val();
    var sex = $("input[name='sex']").val();
    var age = $("#age").val();
    var stulevel = $("#stulevel").val();
    var stumajor = $("#stumajor").val();
    var stuclass = $("#stuclass").val();
    $.ajax({
        type: "POST",
        url: path + ServerAddress.StudentAdd,
        data: {
            name: name,
            stuno: stuno,
            sex: sex,
            age: age,
            stulevel: stulevel,
            stumajor: stumajor,
            stuclass: stuclass
        },
        dataType: "JSON",
        success: function (data) {
            var result = eval(data);
            var statu = result.statu;
            var pageMessage = result.pageMessage;
            alert(pageMessage);
            if (statu == '200') {
                studentTable("");
                $("#addfrom")[0].reset();
            }
        },
        error: function () {
            alert("请求出错！");
        }
    });

}

//获取学生列表
function studentTable(condition) {
    var admin = $("#admin").val();
    var path = $("#abspath").val();
    $.ajax({
        type: "POST",
        url: path + ServerAddress.GetAllStudentList,
        data: {
            admin: admin,
            condition: condition
        },
        dataType: "json",
        success: function (json, xhr) {
            $("#tbody").html("");
            var i = 0;
            $.each(json, function () {
                var tbody = [];
                var courseStr = json[i].stucourses.toString().replace(",", "-#-");
                tbody.push('<tr>');
                tbody.push('    <td><input type="checkbox" id="checkbox' + json[i].id + '" name="checkboxdel" onclick="addonedelbtn()" value="' + json[i].stuid + '" /></td>');
                tbody.push('    <td>' + (i + 1) + '</td>');
                tbody.push('    <td id="stuname' + json[i].id + '">' + json[i].stuname + '</td>');
                tbody.push('    <td id="stuid' + json[i].id + '">' + json[i].stuid + '</td>');
                tbody.push('    <td id="stusex' + json[i].id + '">' + json[i].stusex + '</td>');
                tbody.push('    <td id="stuage' + json[i].id + '">' + json[i].stuage + '</td>');
                tbody.push('    <td id="stulevel' + json[i].id + '">' + json[i].stulevel + '</td>');
                tbody.push('    <td id="stuspedt' + json[i].id + '">' + json[i].stuspedt + '</td>');
                tbody.push('    <td id="stuclassid' + json[i].id + '">' + json[i].stuclassid + '</td>');
                tbody.push('    <td>');
                tbody.push('        <button class="btn btn-wide btn-primary btn-xs" onclick="displayCourse(\'' + courseStr + '\',' + i + ')" id="displayCourse' + i + '">查看课程</button><div id="chocourse' + i + '"></div>');
                tbody.push('    </td>');
                tbody.push('    <td>');
                tbody.push('        <button class="btn btn-success " onclick="eidtStu(' + json[i].id + ')" id="updateStu' + json[i].id + '">修改</button>');
                tbody.push('        <button class="btn btn-danger " onclick="deleteStu(\'' + json[i].stuid + '\')" id="deleteStu' + json[i].id + '">删除</button>');
                tbody.push('    </td>');
                tbody.push('</tr>');
                $("#tbody").append(tbody.join(""));
                i++;
            });
        },
        error: function () {
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

//添加一个删除摁纽
function addonedelbtn() {
    var twobtn = [];
    twobtn.push('<button class="btn btn-danger" onclick="batchdelStu()">删除</button>&nbsp;');
    twobtn.push('<button class="btn btn-success" onclick="allselect()" id="allselect">全选</button>');
    $("#checkboxcol").html(twobtn.join(""));
}

//全不选
function allselect() {
    $("input[name='checkboxdel']").each(function () {
        $(this).attr("checked", true);
    });
    $("#allselect").attr("onclick", "allnotselect()");
    $("#allselect").attr("class", "btn btn-warning");
    $("#allselect").html("全不选");
}

//全选
function allnotselect() {
    $("input[name='checkboxdel']").each(function () {
        $(this).attr("checked", false);
    });
    $("#allselect").attr("onclick", "allselect()");
    $("#allselect").attr("class", "btn btn-success");
    $("#allselect").html("全选");
}

//编辑学生信息
function eidtStu(i) {
    $("#updateStu" + i).html("确认");
    $("#updateStu" + i).attr("onclick", function () {
        return "updateStu(" + i + ")";
    });
    var i = i;
    var stuname = $("#stuname" + i).html();
    var stuid = $("#stuid" + i).html();
    var stusex = $("#stusex" + i).html();
    var stuage = $("#stuage" + i).html();
    var stulevel = $("#stulevel" + i).html();
    var stuspedt = $("#stuspedt" + i).html();
    var stuclassid = $("#stuclassid" + i).html();
    $("#stuname" + i).html('<input type="text" class="form-control" id="inpstuname' + i + '" name="inpstuname" placeholder="姓名" value="' + stuname + '" />');
    $("#stuid" + i).html('<input type="text" class="form-control" id="inpstuid' + i + '" name="inpstuid" placeholder="学号" value="' + stuid + '" />');
    $("#stusex" + i).html('<input type="text" class="form-control" id="inpstusex' + i + '" name="inpstusex" placeholder="性别" value="' + stusex + '" />');
    $("#stuage" + i).html('<input type="number" class="form-control" id="inpstuage' + i + '" name="inpstuage" placeholder="年龄" value=' + stuage + ' />');
    $("#stulevel" + i).html('<input type="text" class="form-control" id="inpstulevel' + i + '" name="inpstulevel" placeholder="年级" value=\"' + stulevel + '\" />');
    $("#stuspedt" + i).html('<input type="text" class="form-control" id="inpstuspedt' + i + '" name="inpstuspedt" placeholder="专业" value="' + stuspedt + '" />');
    $("#stuclassid" + i).html('<input type="text" class="form-control" id="inpstuclassid' + i + '" name="inpstuclassid" placeholder="班级" value="' + stuclassid + '" />');
}

//提交更改信息
function updateStu(i) {
    var path = $("#abspath").val();
    var stuname = $("#inpstuname" + i).val();
    var stuid = $("#inpstuid" + i).val();
    var stusex = $("#inpstusex" + i).val();
    var stuage = $("#inpstuage" + i).val();
    var stulevel = $("#inpstulevel" + i).val();
    var stuspedt = $("#inpstuspedt" + i).val();
    var stuclassid = $("#inpstuclassid" + i).val();
    $.ajax({
        type: "POST",
        url: path + ServerAddress.StudentUpdate,
        data: {
            id: i,
            stuname: stuname,
            stuid: stuid,
            stusex: stusex,
            stuage: stuage,
            stulevel: stulevel,
            stuspedt: stuspedt,
            stuclassid: stuclassid
        },
        dataType: "JSON",
        success: function (data, xhr) {
            if (data == '200') {
                location.replace(location.href);
            } else {
                alert("修改失败！");
                location.replace(location.href);
            }
        },
        error: function () {
            alert("请求错误");
        }
    });
}

//显示学生已选课程
function displayCourse(courses, i) {
    var courseArr = courses.split("-#-");
    $("#displayCourse" + i).html("关闭查看");
    $("#displayCourse" + i).attr("class", function () {
        return "btn btn-wide btn-warning btn-xs";
    });
    $("#displayCourse" + i).attr("onclick", function () {
        return "closeCourse(\'" + courses + "\'," + i + ")";
    });
    $("#chocourse" + i).html(courseArr);
}

//显示学生已选课程
function closeCourse(courses, i) {
    $("#displayCourse" + i).html("查看课程");
    $("#displayCourse" + i).attr("class", function () {
        return "btn btn-wide btn-primary btn-xs";
    });
    $("#displayCourse" + i).attr("onclick", function () {
        return "displayCourse(\'" + courses + "\'," + i + ")";
    });
    $("#chocourse" + i).html("");
}

//删除学生
function deleteStu(stuid) {
    var path = $("#abspath").val();
    if (confirm("你确定要删除学号：" + stuid + " 的学生么？")) {
        $.post(path + ServerAddress.StudentDelete,
            {
                stuid: stuid

            }, function (data) {
                if (data = "200") {
                    studentTable("");
                } else {
                    alert("删除失败");
                }
            });
    }
}

//批量删除学生
function batchdelStu() {
    var path = $("#abspath").val();
    var delArr = [];
    var count = 0;
    $('input[name="checkboxdel"]:checked').each(function () {
        delArr.push($(this).val());
        count++;
    });
    if (confirm("确定要删除这" + count + "项么？")) {
        if (delArr.length == 0) {
            alert("你还没选中任何记录！");
            return;
        } else {
            $.ajax({
                type: "POST",
                url: path + ServerAddress.StudentDelete,
                data: {
                    batch: 'batch',
                    stuid: delArr.join(",")
                },
                dataType: "json",
                beforeSend: function () {
                    layer.load();
                },
                success: function (data) {
                    if (data.statu == "200") {
                        alert(data.pageMessage + delArr.length + "条记录！");
                        location.href = data.pagePath;
                    } else {
                        alert("删除失败！");
                    }
                }
            });
        }
    }
}

//取消
function cancel() {
    var file = $("#file1").val(null);
    resetfile();
    $("#addspace").empty();
}

//重置已选文件
function resetfile() {
    var file = $("#file1").val(null);
    $("#spanFile").html("·只能上传后缀名为.xls、.xlsx文件");
    $("#afile").attr("class", function () {
        return "btn btn-wide btn-o btn-success btn-lg";
    });
}

function doAjax(dataForm, url) {
    var eStr = "";
    $.ajax({
        type: "POST",
        url: url,
        data: dataForm,
        contentType: false,
        processData: false,
        // async:false,
        complete: function (e, xhr, settings) {
            studentTable("");
            alert(e);
        }
    });
}

//搜索学生
function searchstu() {
    condi = $("#mysearch").val();
    if (condi.length != 0) {
        studentTable(condi);
    }
}