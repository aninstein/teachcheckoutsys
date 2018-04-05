$(document).ready(function () {
    $("#ip_login_btn").click(function () {

        if($("#stuNo").val().length==0||$("#courseNo").val().length==0){
            alert("输入内容不能为空！");
        }else {
            var stuNo=$("#stuNo").val();
            var courseNo=$("#courseNo").val();
            var pat=/^[0-9a-zA-Z]{0,9}$/;
            if(!pat.test(stuNo)||!pat.test(courseNo)){
                alert("输入内容格式错误！");
            } else {
                // 百度地图API功能
                var map = new BMap.Map("allmap");
                var point = new BMap.Point(116.331398, 39.897445);
                map.centerAndZoom(point, 12);
                var geolocation = new BMap.Geolocation();
                geolocation.getCurrentPosition(function (r) {
                    if (this.getStatus() == BMAP_STATUS_SUCCESS) {
                        var mk = new BMap.Marker(r.point);
                        map.addOverlay(mk);
                        map.panTo(r.point);
                        $.ajax({
                            url: ServerAddress.StudentQiandao,
                            type: "POST",
                            data: {
                                stuNo: stuNo,
                                courseNo: courseNo,
                                lng: r.point.lng + "",
                                lat: r.point.lat + ""
                            },
                            dataType: "json",
                            async: false,
                            complete: function (e, xhr, settings) {
                                var json = JSON.parse(e.responseText)
                                alert(e.responseText);
                            }
                        });
//                    alert('您的位置：'+r.point.lng+','+r.point.lat);
                    }
                    else {
                        alert('failed' + this.getStatus());
                    }
                }, {enableHighAccuracy: true});
            }
        }
    });

});