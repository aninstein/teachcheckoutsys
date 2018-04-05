/**
 * Created by 慈祥的昌老师 on 2017/12/1.
 */

var condi = $("#teacherid").val();
var path=$("#abspath").val();
var admin=$("#admin").val();

$(document).ready(function () {

    condi = $("#teacherid").val();
    path=$("#abspath").val();
    admin=$("#admin").val();

    $("#confirmtest").click(function () {
        questionArr = [];
        var opi=0;
        $("div[name='questionoption']").each(function () {

            var question = $(this).find("#sjquestion").val();

            var answers = [];
            $(this).find("input[name='option']").each(function () {
                answers.push($(this).val());
            });
            var correctAnswer = $(this).find("input[name='radioquestion"+opi+"']").val();
            var one_question = new Questions(question, answers, Number(correctAnswer));

            //一道题
            questionArr.push(one_question);
            opi++;
        });


        var data={
            "sjname":$("#sjname").val(),
            "sjtag":$("#sjtag").val(),
            "sjdecri":$("#sjdecri").val(),
            "sjsubject":$("#sjsubject").val(),
            "sjsubjectchp":$("#sjsubjectchp").val(),
            "sjtinum":questionArr.length,
            "questions":JSON.stringify(questionArr),
            "teacherid":$("#teacherid").val(),
            "teachername":$("#theteachername").val()
        };

        doAjax(data,path+ServerAddress.SjAdd);

    });

    // $(document).on('change','#sjfile1',function(){
    //
    //     var file = $("#sjfile1").val();
    //
    //     /*获取文件名部分*/
    //     var strFileName=file.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1");  //正则表达式获取文件名，不带后缀
    //     var FileExt=file.replace(/.+\./,"");   //正则表达式获取后缀
    //     if(FileExt=="xls"||FileExt=="xlsx"){
    //         layer.confirm('确认上传试卷'+strFileName+FileExt+'么？', {
    //             btn: ['上传', '取消']
    //             ,yes: function(){
    //
    //                 //这里获取后台所需数据
    //                 var formData = new FormData($("#dataForm")[0]);
    //
    //                 $.ajax({
    //                     type: "POST",
    //                     url: ServerAddress.uploadFilesOSS,
    //                     data: formData,
    //                     contentType: false,
    //                     processData: false,
    //                     async:false,
    //                     beforeSend:function () {
    //                         layer.load();
    //                     },
    //                     complete: function (e, xhr, settings) {
    //                         layer.closeAll();
    //                         var result = JSON.parse(e.responseText);
    //                         if (e.status === 200) {
    //                             $.ajax({
    //                                 type: "POST",
    //                                 url: path+ServerAddress.SjAddByFile,
    //                                 data: {
    //                                     downurl:result.filePath,
    //                                     author:$("#teacherid").val(),
    //                                     authorname:$("#theteachername").val(),
    //                                     type:$("#serviceName").val(),
    //                                     filename:$("#fileName").val()+"."+$("#ext").val()
    //                                 },
    //                                 async:false,
    //                                 dataType:"json",
    //                                 beforeSend:function () {
    //                                     layer.load();
    //                                 },
    //                                 success:function (data,xhr) {
    //
    //                                     layer.closeAll();
    //
    //                                     $("#sjname").val(data.sjname);
    //                                     $("#sjtag").val(data.sjtag);
    //                                     $("#sjdecri").val(data.sjdescribe);
    //                                     $("#sjsubject").val(data.sjcourseid);
    //                                     $("#sjsubjectchp").val(data.sjcoursechp);
    //
    //                                     var correctAnswer=[];
    //                                     var thisquestionid=0;
    //                                     $.each(data.sjcontain,function () {
    //
    //                                         var thisq=$(this)[0];
    //
    //                                         var question=[];
    //                                         question.push('<div class="panel" name="thequestion" id="thequestion">');
    //                                         question.push('    <div class="panel-content">');
    //                                         question.push('        <div class="row">');
    //                                         question.push('            <div class="col-sm-12">');
    //                                         question.push('                <div class="form-horizontal form-stripe">');
    //                                         question.push('                    <div class="form-group">');
    //                                         question.push('                        <div class="col-sm-offset-2 col-sm-10">');
    //                                         question.push('                            <button type="button" class="btn btn-wide btn-primary" name="addoption" onclick="addoption(\''+thisquestionid+'\')">添加选项</button>');
    //                                         question.push('                            <button type="button" class="btn btn-wide btn-warning" name="deloption" onclick="deloption(\''+thisquestionid+'\')">删除选项</button>');
    //                                         question.push('                            <button type="button" class="btn btn-wide btn-danger" name="delquestion" onclick="delquestion(\''+thisquestionid+'\')">删除此题</button>');
    //                                         question.push('                        </div>');
    //                                         question.push('                    </div>');
    //                                         question.push('                    <div class="form-group">');
    //                                         question.push('                        <label for="sjquestion" class="col-sm-2 control-label">&nbsp;&nbsp;&nbsp;<strong name="strongquestionid">'+(thisquestionid+1)+'</strong>题目问题</label>');
    //                                         question.push('                        <div class="col-sm-10">');
    //                                         question.push('                            <div name="questionoption" id="questionoption">');
    //                                         question.push('                            <input type="text" class="form-control" name="sjquestion" id="sjquestion" placeholder="题目问题" value="'+thisq.question+'" />');
    //
    //                                         var answerslist=eval(thisq.answers);
    //                                         for(var j=0;j<answerslist.length;j++){
    //                                             question.push('                                <span name="spanoption" id="spanoption">');
    //                                             question.push('                                <input type="radio" name="radioquestion" value="'+(j+1)+'" />');
    //                                             question.push('                                <b>'+Alphabet.character((j+1))+'</b>');
    //                                             question.push('                                <input type="text" class="form-control" placeholder="选项内容" name="option" value="'+answerslist[j]+'" /></span>');
    //                                         }
    //
    //                                         question.push('                            </div>');
    //                                         question.push('                        </div>');
    //                                         question.push('                    </div>');
    //                                         question.push('                </div>');
    //                                         question.push('            </div>');
    //                                         question.push('        </div>');
    //                                         question.push('    </div>');
    //                                         question.push('</div>');
    //
    //                                         correctAnswer.push(Number(thisq.correctAnswer));
    //
    //                                         thisquestionid++;
    //
    //                                         $("#tectti").append(question.join(""));
    //                                     });
    //                                     //进行一次排序,当插入完毕一定要先进行排序
    //                                     quessort();
    //
    //                                     //设置正确答案
    //                                     setRadio(correctAnswer);
    //
    //                                     //显示试题数目
    //                                     $("#questionnum").html(thisquestionid);
    //
    //                                 },
    //                                 error:function () {
    //                                     layer.msg("读取失败!");
    //                                 }
    //                             });
    //                         } else {
    //                             layer.msg(e.status);
    //                         }
    //                     }
    //                 });
    //             }
    //         });
    //         //清空文件
    //         var file = $("#file1").val(null);
    //     }
    //     else{
    //         //清空文件
    //         var file = $("#file1").val(null);
    //         layer.msg("只能上传后缀名为.xls或者.xlsx的文件！");
    //         return;
    //     }
    // });

});

function setRadio(correctAnswer){

    //选择
    var i=0;
    $("div[name='questionoption']").each(function () {
        $(this).find("input[type='radio']").get((correctAnswer[i]-1)).checked=true;
        i++;
    });
}

//添加试题
questionno=0;
ti=[];
function addquestions(){
    var sj=new Sj(questionno,new Array(1,2,3,4));
    ti.push(sj);
    var question=[];
    var thisquestionid=ti[ti.length-1].tiid;
    question.push('<div class="panel" name="thequestion" id="thequestion">');
    question.push('    <div class="panel-content">');
    question.push('        <div class="row">');
    question.push('            <div class="col-sm-12">');
    question.push('                <div class="form-horizontal form-stripe">');
    question.push('                    <div class="form-group">');
    question.push('                        <div class="col-sm-offset-2 col-sm-10">');
    question.push('                            <button type="button" class="btn btn-wide btn-primary" name="addoption" onclick="addoption(\''+thisquestionid+'\')">添加选项</button>');
    question.push('                            <button type="button" class="btn btn-wide btn-warning" name="deloption" onclick="deloption(\''+thisquestionid+'\')">删除选项</button>');
    question.push('                            <button type="button" class="btn btn-wide btn-danger" name="delquestion" onclick="delquestion(\''+thisquestionid+'\')">删除此题</button>');
    question.push('                        </div>');
    question.push('                    </div>');
    question.push('                    <div class="form-group">');
    question.push('                        <label for="sjquestion" class="col-sm-2 control-label">&nbsp;&nbsp;&nbsp;<strong name="strongquestionid">'+(thisquestionid+1)+'</strong>题目问题</label>');
    question.push('                        <div class="col-sm-10">');
    question.push('                            <div name="questionoption" id="questionoption">');
    question.push('                            <input type="text" class="form-control" name="sjquestion" id="sjquestion" placeholder="题目问题">');
    question.push('                                <span name="spanoption" id="spanoption">');
    question.push('                                <input type="radio" name="radioquest-ion" value="1" />');
    question.push('                                <b>A</b>');
    question.push('                                <input type="text" class="form-control" placeholder="选项内容" name="option" /></span>');
    question.push('                                <span name="spanoption" id="spanoption">');
    question.push('                                <input type="radio" name="radioquestion" value="2" />');
    question.push('                                <b>B</b>');
    question.push('                                <input type="text" class="form-control" placeholder="选项内容" name="option" /></span>');
    question.push('                                <span name="spanoption" id="spanoption">');
    question.push('                                <input type="radio" name="radioquestion" value="3" />');
    question.push('                                <b>C</b>');
    question.push('                                <input type="text" class="form-control" placeholder="选项内容" name="option" /></span>');
    question.push('                                <span name="spanoption" id="spanoption">');
    question.push('                                <input type="radio" name="radioquestion" value="4" />');
    question.push('                                <b>D</b>');
    question.push('                                <input type="text" class="form-control" placeholder="选项内容" name="option" /></span>');
    question.push('                            </div>');
    question.push('                        </div>');
    question.push('                    </div>');
    question.push('                </div>');
    question.push('            </div>');
    question.push('        </div>');
    question.push('    </div>');
    question.push('</div>');
    $("#tectti").append(question.join(""));
    //试题数加1

    questionno++;

    //进行一次排序
    quessort();

    //显示试题数目
    $("#questionnum").html(questionno);


}

//删除试题
function delquestion(qno){
    $("#thequestion"+qno).remove();

    questionno--;

    //显示试题数目
    $("#questionnum").html(questionno);

    //进行一次排序
    quessort();
}

//通过文件导入试卷
function inputfile() {

    // var space = [];
    // space.push('<div class="panel">');
    // space.push(' <div class="panel-content">');
    // space.push('     <div class="row">');
    // space.push('         <div class="col-md-12">');
    // space.push('             <form class="form-inline"  enctype="multipart/form-data"  method="post" id="dataForm">');
    // space.push('                 <h5 class="mb-lg ">教师列表导入</h5>');
    // space.push('                 <input type="hidden" id="serviceName" name="serviceName" value="sj" /><!-- 告诉后台我这是什么文件类型 -->');
    // space.push('                 <input type="hidden" id="path" name="path" value="teachsys/upload" /><!-- 给后台传递确认导入信号 -->');
    // space.push('                 <input type="hidden" id="fileName" name="fileName" value="试卷模板" /><!-- 告诉后台我这是什么文件类型 -->');
    // space.push('                 <input type="hidden" id="ext" name="ext" value="xls" /><!-- 给后台传递确认导入信号 -->');
    // space.push('                 <div class="form-group">');
    // space.push('                     <span>');
    // space.push('						<a class="btn btn-wide btn-o btn-success btn-lg" id="afile" href="javascript:void(0);">选择文件');
    // space.push('                        <input type="file" name="file1" id="file1" /></a>');
    // space.push('					</span>');
    // space.push('				</div>');
    // space.push('				<div class="form-group">');
    // space.push('				<span id="spanFile">·只能上传后缀名为.xls、.xlsx文件</span>');
    // space.push('				</div>');
    // space.push('				<br><br>');
    // space.push('                 <div class="form-group">');
    // space.push('                     <input type="button" class="btn btn-wide btn-primary" onclick="uploadTable()" value="确认导入"/>');
    // space.push('					<input type="button" class="btn btn-wide btn-warning" onclick="resetfile()" value="重新选择"/>');
    // // space.push('					<input type="button" class="btn btn-wide" id="add_cancel" onclick="cancel()" value="取消"/>');
    // space.push('                 </div>');
    // space.push('             </form>');
    // space.push('         </div>');
    // space.push('     </div>');
    // space.push(' </div>');
    // space.push('</div>');

    //iframe层-父子操作
    layer.open({
        type: 2,
        area: ['550px','300px'],
        fixed: false, //不固定
        maxmin: true,
        content: 'upload.html'
    });
}

function uploadTable(){

    var file = $("#file1").val();

    /*获取文件名部分*/
    var strFileName=file.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1");  //正则表达式获取文件名，不带后缀
    var FileExt=file.replace(/.+\./,"");   //正则表达式获取后缀
    if(FileExt=="xls"||FileExt=="xlsx"){
        layer.confirm('确认上传试卷'+strFileName+FileExt+'么？', {
            btn: ['上传', '取消']
            ,yes: function(){

                //这里获取后台所需数据
                var formData = new FormData($("#dataForm")[0]);
                alert($("#serviceName").val());

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
                        layer.closeAll();
                        var result = JSON.parse(e.responseText);
                        if (e.status === 200) {
                            $.ajax({
                                type: "POST",
                                url: path+ServerAddress.SjAddByFile,
                                data: {
                                    downurl:result.filePath,
                                    author:$("#teacherid").val(),
                                    authorname:$("#theteachername").val(),
                                    type:$("#serviceName").val(),
                                    filename:$("#fileName").val()+"."+$("#ext").val()
                                },
                                async:false,
                                dataType:"json",
                                beforeSend:function () {
                                    layer.load();
                                },
                                success:function (data,xhr) {

                                    layer.closeAll();

                                    $("#sjname").val(data.sjname);
                                    $("#sjtag").val(data.sjtag);
                                    $("#sjdecri").val(data.sjdescribe);
                                    $("#sjsubject").val(data.sjcourseid);
                                    $("#sjsubjectchp").val(data.sjcoursechp);

                                    var correctAnswer=[];
                                    var thisquestionid=0;
                                    $.each(data.sjcontain,function () {

                                        var thisq=$(this)[0];

                                        var question=[];
                                        question.push('<div class="panel" name="thequestion" id="thequestion">');
                                        question.push('    <div class="panel-content">');
                                        question.push('        <div class="row">');
                                        question.push('            <div class="col-sm-12">');
                                        question.push('                <div class="form-horizontal form-stripe">');
                                        question.push('                    <div class="form-group">');
                                        question.push('                        <div class="col-sm-offset-2 col-sm-10">');
                                        question.push('                            <button type="button" class="btn btn-wide btn-primary" name="addoption" onclick="addoption(\''+thisquestionid+'\')">添加选项</button>');
                                        question.push('                            <button type="button" class="btn btn-wide btn-warning" name="deloption" onclick="deloption(\''+thisquestionid+'\')">删除选项</button>');
                                        question.push('                            <button type="button" class="btn btn-wide btn-danger" name="delquestion" onclick="delquestion(\''+thisquestionid+'\')">删除此题</button>');
                                        question.push('                        </div>');
                                        question.push('                    </div>');
                                        question.push('                    <div class="form-group">');
                                        question.push('                        <label for="sjquestion" class="col-sm-2 control-label">&nbsp;&nbsp;&nbsp;<strong name="strongquestionid">'+(thisquestionid+1)+'</strong>题目问题</label>');
                                        question.push('                        <div class="col-sm-10">');
                                        question.push('                            <div name="questionoption" id="questionoption">');
                                        question.push('                            <input type="text" class="form-control" name="sjquestion" id="sjquestion" placeholder="题目问题" value="'+thisq.question+'" />');

                                        var answerslist=eval(thisq.answers);
                                        for(var j=0;j<answerslist.length;j++){
                                            question.push('                                <span name="spanoption" id="spanoption">');
                                            question.push('                                <input type="radio" name="radioquestion" value="'+(j+1)+'" />');
                                            question.push('                                <b>'+Alphabet.character((j+1))+'</b>');
                                            question.push('                                <input type="text" class="form-control" placeholder="选项内容" name="option" value="'+answerslist[j]+'" /></span>');
                                        }

                                        question.push('                            </div>');
                                        question.push('                        </div>');
                                        question.push('                    </div>');
                                        question.push('                </div>');
                                        question.push('            </div>');
                                        question.push('        </div>');
                                        question.push('    </div>');
                                        question.push('</div>');

                                        correctAnswer.push(Number(thisq.correctAnswer));

                                        thisquestionid++;

                                        $("#tectti").append(question.join(""));
                                    });
                                    //进行一次排序,当插入完毕一定要先进行排序
                                    quessort();

                                    //设置正确答案
                                    setRadio(correctAnswer);

                                    //显示试题数目
                                    $("#questionnum").html(thisquestionid);

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
        });
        //清空文件
        var file = $("#file1").val(null);
    }
    else{
        //清空文件
        var file = $("#file1").val(null);
        layer.msg("只能上传后缀名为.xls或者.xlsx的文件！");
        return;
    }
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



//添加选项
function addoption(qno){
    var j=0;
    $("#questionoption"+qno).find("span[name='spanoption']").each(function () {
       j++;
    });
    var newoption=[];
    newoption.push('<span name="spanoption" id="spanoption">');
    newoption.push('<input type="radio" name="radioquestion" value="'+(j+1)+'" />');
    newoption.push('<b>'+Alphabet.character((j+1))+'</b>');
    newoption.push('<input type="text" class="form-control" placeholder="选项内容" name="option" /></span>');
    $("#questionoption"+qno).append(newoption.join(""));

    //进行一次排序
    quessort();
}

//删除选项
function deloption(qno) {
    var spanoption=[];
    //把所有元素存在数组中
    $("#questionoption"+qno).find("span[name='spanoption']").each(function () {
        spanoption.push($(this));
    });
    //删除最后一个数组元素
    spanoption[spanoption.length-1].remove();

    //进行一次排序
    quessort();
}

//删除数组方法
Array.prototype.delarr=function(n) {
    if(n<0)
        return this;
    else
        return this.slice(0,n).concat(this.slice(n+1,this.length));
};


//排序试题
function quessort() {
    var i=0;
    //整个题目的div
    $("div[name='thequestion']").each(function () {
        $(this).attr("id","thequestion"+i);
        i++;
    });

    //题目问题
    i=0;
    $("div[name='sjquestion']").each(function () {
        $(this).attr("id","sjquestion"+i);
        i++;
    });

    //添加选项摁纽
    i=0;
    $("button[name='addoption']").each(function () {
        $(this).attr("onclick",function () {
            return "addoption(\'"+i+"\')";
        });
        i++;
    });

    //删除选项摁纽
    i=0;
    $("button[name='deloption']").each(function () {
        $(this).attr("onclick",function () {
            return "deloption(\'"+i+"\')";
        });
        i++;
    });

    //删除本题摁纽
    i=0;
    $("button[name='delquestion']").each(function () {
        $(this).attr("onclick",function () {
            return "delquestion(\'"+i+"\')";
        });
        i++;
    });

    //显示题号
    i=0;
    $("strong[name='strongquestionid']").each(function () {
        $(this).html(i+1);
        i++;
    });

    //选项部分的div
    i=0;
    $("div[name='questionoption']").each(function () {
        $(this).attr("id","questionoption"+i);
        i++;
    });

    //选择
    i=0;
    $("div[name='questionoption']").each(function () {
        $(this).find("input[type='radio']").each(function () {
            $(this).attr("name","radioquestion"+i);
        });
        i++;
    });

}

//ajax
function doAjax(data,url){
    alert(url);
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        dataType:"json",
        async:false,
        beforeSend:function () {
            layer.load();
        },
        success: function (redata, xhr, settings) {
            layer.closeAll('loading');
            layer.msg(redata.pageMessage);
            if(redata.pagePath.length!=0){
                location.href=redata.pagePath;
            }
        },
        error:function () {
            layer.msg("请求失败！");
        }
    });
}