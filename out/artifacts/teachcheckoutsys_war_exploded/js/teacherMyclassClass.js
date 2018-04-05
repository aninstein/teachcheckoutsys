/**
 * Created by Administrator on 2017/12/3.
 */

var condi = $("#classid").val();
var path=$("#abspath").val();
var admin=$("#admin").val();

$(document).ready(function () {

    path = $("#abspath").val();
    admin=$("#admin").val();
    condi = $("#classid").val();
    getTable(condi);

    $("#addspace").hide();

    $("#addstu").click(function () {
        $("#addspace").show();
        $("#addstu").attr("id",function () {
            return "cancel";
        });
    });

    $("#cancel").click(function () {
        $("#addspace").hide();
        $("#cancel").attr("id",function () {
            return "addstu";
        });
    });

    $("#mysearch").blur(function () {
        var mysearch=$("#mysearch").val();
        if(mysearch.length!=0){
            var data={
                "condition":mysearch,
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
                    $("#tbodyup").empty();
                    var i=0;
                    $.each(redata,function () {

                        if($("#stuid"+redata[i].id).html()==redata[i].stuid){
                            i++;
                            return true;
                        }

                        var tbody=[];
                        tbody.push('<tr id="tr'+redata[i].stuid+'">');
                        tbody.push('    <td><input type="button" class="btn btn-success btn-xs" value="添加" id="thecheckbox'+redata[i].stuid+'" name="thecheckbox" onclick="choosedthis(\''+redata[i].stuid+'\')"></td>');
                        tbody.push('    <td id="no'+redata[i].id+'">'+(i+1)+'</td>');
                        tbody.push('    <td id="stuname'+redata[i].id+'">'+redata[i].stuname+'</td>');
                        tbody.push('    <td id="stuid'+redata[i].id+'">'+redata[i].stuid+'</td>');
                        tbody.push('</tr>');
                        $("#tbodyup").append(tbody.join(""));
                        i++;
                    });
                },
                error:function () {
                    layer.msg("请求失败！");
                }
            });
        }
    });

});

function choosedthis(stuid) {
    $("#tr"+stuid).remove();
    var data={
        "admin":admin,
        "stuid":stuid,
        "classid":condi
    };
    doAjax(data,path+ServerAddress.ClassCheckAdd);
}

//显示表格
function getTable(condition) {
    $.ajax({
        type:"POST",
        url:path+ServerAddress.ClassCheck,
        data:{
            admin:admin,
            condition:condition
        },
        dataType:"json",
        success:function (json,xhr) {
            $("#tbody").empty();
            var i=0;
            $.each(json,function () {
                var tbody=[];
                tbody.push('<tr>');
                tbody.push('    <td>'+(i+1)+'</td>');
                tbody.push('    <td id="stuname'+json[i].id+'">'+json[i].stuname+'</td>');
                tbody.push('    <td id="stuid'+json[i].id+'" name="thestuid">'+json[i].stuid+'</td>');
                tbody.push('    <td id="stuspedt'+json[i].id+'">'+json[i].stuspedt+'</td>');
                tbody.push('    <td>');
                tbody.push('        <button type="button" class="btn btn-wide btn-danger btn-xs" onclick="delstu(\''+json[i].stuid+'\')">删除</button>');
                tbody.push('    </td>');
                tbody.push('</tr>');
                $("#tbody").append(tbody.join(""));
                i++;
            });
        },
        error:function () {
            layer.msg("请求失败！");
        }
    });
}

function delstu(stuid){
    var data={
        "stuid":stuid,
        "classid":condi,
        "admin":admin
    };
    doAjax(data,path+ServerAddress.ClassCheckDelete);
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
            layer.closeAll('loading');
            layer.msg(redata.pageMessage);
            if(redata.pagePath.length!=0){
                // location.href=redata.pagePath+"?classid="+condi;
                location.replace(location.href);
            }
            getTable(condi);
        },
        error:function () {
            layer.msg("请求失败！");
        }
    });
}