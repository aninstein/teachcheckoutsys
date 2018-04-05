
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



});

//获取表格数据
function getTable(condition) {
    $.ajax({
        type:"POST",
        url:path+ServerAddress.GetMySjList,
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
                tbody.push('    <td id="sjname'+json[i].id+'">'+json[i].sjname+'</td>');
                tbody.push('    <td id="sjtag'+json[i].id+'">'+json[i].sjtag+'</td>');
                tbody.push('    <td id="sjdescribe'+json[i].id+'">'+json[i].sjdescribe+'</td>');
                tbody.push('    <td id="sjtinum'+json[i].id+'">'+json[i].sjtinum+'</td>');
                tbody.push('    <td id="sjcourseid'+json[i].id+'">'+json[i].sjcourseid+'-'+json[i].sjcoursechp+'</td>');
                tbody.push('    <td id="sjreplynum'+json[i].id+'">'+json[i].sjreplynum+'&nbsp;&nbsp;<button type="button" class="btn btn-danger">谁未答题？</button></td>');
                tbody.push('    <td id="sjright'+json[i].id+'">'+json[i].sjright+'%</td>');
                tbody.push('    <td id="sjcreatetime'+json[i].id+'">'+json[i].sjcreatetime+'</td>');
                tbody.push('    <td id="control'+json[i].id+'">');
                tbody.push('        <button type="button" class="btn btn-success">查看</button>');
                tbody.push('        <button type="button" class="btn btn-primary">修改</button>');
                tbody.push('        <button type="button" class="btn btn-danger">删除</button>');
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