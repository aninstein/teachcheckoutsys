var condi = $("#mysearch").val();
var path=$("#abspath").val();
var admin=$("#admin").val();

$(document).ready(function () {
    path=$("#abspath").val();
    condi = $("#mysearch").val();
    admin=$("#admin").val();
    getTable(condi);

});


function getTable(condition) {

    $.ajax({
        type:"POST",
        url:path+ServerAddress.GetTeachersList,
        data:{
            admin:admin,
            condition:"auditing"//表示只要正在审核中的
        },
        dataType:"json",
        success:function (json,xhr) {
            $("#tbody").html("");
            var i=0;
            $.each(json,function () {
                var tbody=[];
                tbody.push('<tr>');
                tbody.push('    <td><input type="checkbox" id="" name="" /></td>');
                tbody.push('            <td>'+(i+1)+'</td>');
                tbody.push('            <td id="teacherid'+json[i].id+'">'+json[i].teacherid+'</td>');
                tbody.push('            <td id="teacheremail'+json[i].id+'">'+json[i].teacheremail+'</td>');
                tbody.push('            <td id="teacherusername'+json[i].id+'">'+json[i].teacherusername+'</td>');
                tbody.push('            <td><input type="button" class="btn btn-o btn-primary" id="pass'+json[i].id+'" name="pass" onclick="pass(\''+json[i].teacherid+'\')" value="通过审核" /></td>');
                tbody.push('            <td><input type="button" class="btn btn-o btn-success" id="setadmin'+json[i].id+'" name="setadmin" onclick="setadmin(\''+json[i].teacherid+'\')" value="设置管理员" /></td>');
                tbody.push('            <td>');
                tbody.push('    <button class="btn btn-wide btn-danger" onclick="clearThis(\''+json[i].teacherid+'\')">清除</button>');
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

//通过审核
function pass(id) {
    var data={
        "teacherid":id,
        "pass":"pass",
        "admin":admin
    };
    doAjax(data,path+ServerAddress.SetAdmin);
}

//设置管理员
function setadmin(id) {
    var data={
        "teacherid":id,
        "admin":admin
    };
    doAjax(data,path+ServerAddress.SetAdmin);
}

//清除记录
function clearThis(id) {
    var data={
        "delid":id,
    };
    doAjax(data,path+ServerAddress.TeachersDelete);
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