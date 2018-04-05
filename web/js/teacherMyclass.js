/**
 * Created by 慈祥的昌老师 on 2017/12/1.
 */

var condi = $("#teacherid").val();
var path=$("#abspath").val();
var admin=$("#admin").val();

//选择id的数组
var chooseids=[];

$(document).ready(function () {
    path = $("#abspath").val();
    admin=$("#admin").val();
    condi = $("#teacherid").val();
    getTable(condi);

    $("#addfrom").hide();
    $("#stulist").hide();

    //添加班级摁纽
    $("#addclass").click(function () {
        $("#addfrom").show();
        $("#stulist").show();
    });

    //取消
    $("#add_cancel").click(function () {
        $("#addfrom").hide();
        $("#stulist").hide();
    });

    //确认添加按钮
    $("#add_btn").click(function () {
        var data={
            "classname":$("#classname").val(),
            "subject":$("#subject").val(),
            "major":$("#major").val(),
            "chooseids":chooseids.join(","),
            "teacherid":$("#teacherid").val(),
            "teachername":$("#teachername").html()
        };
        doAjax(data,path+ServerAddress.ClassAdd);
    });

    //显示所有已选学生按钮
    $("#choosestu").click(function () {
        var data={
            "condition":"choosestuid",
            "choosestuid":chooseids.join(","),
            "admin":admin
        };
        if(chooseids.length>0){
            $.ajax({
                type: "POST",
                url: path+ServerAddress.GetAllStudentList,
                data: data,
                dataType:"json",
                async:false,
                beforeSend:function () {
                    layer.load();
                },
                success: function (redata, xhr, settings) {
                    layer.closeAll('loading');
                    $("#tbody").empty();
                    var i=0;
                    $.each(redata,function () {
                        var tbody=[];
                        tbody.push('<tr>');
                        tbody.push('    <td><input type="checkbox" id="thecheckbox'+redata[i].stuid+'" name="thecheckbox" onclick="choosedthis(\''+redata[i].stuid+'\')"></td>');
                        tbody.push('    <td id="no'+redata[i].id+'">'+(i+1)+'</td>');
                        tbody.push('    <td id="stuname'+redata[i].id+'">'+redata[i].stuname+'</td>');
                        tbody.push('    <td id="stuid'+redata[i].id+'">'+redata[i].stuid+'</td>');
                        tbody.push('</tr>');
                        $("#tbody").append(tbody.join(""));
                        i++;
                    });

                    //把已选择的打上勾
                    $.each(chooseids,function (index,value) {
                        $("#thecheckbox"+value).attr("checkbox",true);
                    });

                },
                error:function () {
                    layer.msg("请求失败！");
                }
            });
        }
    });

    //搜索学生
    $("#mystusearch").blur(function () {
        var mystusearch=$("#mystusearch").val();
        if(mystusearch.length!=0){
            var data={
                "condition":mystusearch,
                "admin":admin
            };
            $.ajax({
                type: "POST",
                url: path+ServerAddress.GetAllStudentList,
                data: data,
                dataType:"json",
                async:false,
                beforeSend:function () {
                    layer.load();
                },
                success: function (redata, xhr, settings) {
                    layer.closeAll('loading');
                    $("#tbody").empty();
                    var i=0;
                    $.each(redata,function () {
                        var tbody=[];
                        tbody.push('<tr>');
                        tbody.push('    <td><input type="checkbox" id="thecheckbox'+redata[i].stuid+'" name="thecheckbox" onclick="choosedthis(\''+redata[i].stuid+'\')"></td>');
                        tbody.push('    <td id="no'+redata[i].id+'">'+(i+1)+'</td>');
                        tbody.push('    <td id="stuname'+redata[i].id+'">'+redata[i].stuname+'</td>');
                        tbody.push('    <td id="stuid'+redata[i].id+'">'+redata[i].stuid+'</td>');
                        tbody.push('</tr>');
                        $("#tbody").append(tbody.join(""));
                        i++;
                    });

                    //把已选择的打上勾
                    $.each(chooseids,function (index,value) {
                        $("#thecheckbox"+value).attr("checkbox",true);
                    });

                },
                error:function () {
                    layer.msg("请求失败！");
                }
            });
        }
    });

});

//获取表格数据
function getTable(condition) {
    $.ajax({
        type:"POST",
        url:path+ServerAddress.GetClasstableList,
        data:{
            admin:admin,
            condition:condition
        },
        dataType:"json",
        success:function (json,xhr) {
            $("#theul").empty();
            var i=0;
            $.each(json,function () {
                var tbody=[];
                tbody.push('<li>');
                tbody.push('    <a href="teacher_myclass_class.jsp?classid='+json[i].classid+'" >');
                tbody.push('        <div class="panel-content">');
                tbody.push('            <h1 class="title">'+json[i].classname+'</h1>');
                tbody.push('        </div>');
                tbody.push('        <div class="text">');
                tbody.push('            <span class="title">人数'+json[i].classnum+'</span>');
                tbody.push('            <span class="subtitle">任教：'+json[i].classsubject+'</span>');
                tbody.push('        </div>');
                tbody.push('    </a>');
                tbody.push('</li>');
                $("#theul").append(tbody.join(""));
                i++;
            });

        },
        error:function () {
            layer.msg("请求失败！");
        }
    });
}

//确认选择
function choosedthis(id) {

    var isE=0;
    var len=chooseids.length;
    if(len==0){
        chooseids.push(id);
    } else {
        //如果存在就会被删掉
        for (var i = 0; i < len; i++) {
            if (chooseids[i] == Number(id)) {
                chooseids = chooseids.delarr(i);
                isE = 1;
            } else {
                if (i == chooseids.length - 1 && isE == 0) {
                    chooseids.push(id);
                    break;
                }
            }
        }
    }

}

//删除数组方法
Array.prototype.delarr=function(n) {
    if(n<0)
        return this;
    else
        return this.slice(0,n).concat(this.slice(n+1,this.length));
};


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
            layer.closeAll('loading');
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