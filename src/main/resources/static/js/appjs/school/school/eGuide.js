$(function () {
    $.ajax({
        type:"GET",
        url:"/school/school/getEnrollmentGuide",
        data:{
            id:$("#id").val()
        },
        success:function (data) {
            $("#content").append(data);
        },
        error:function () {
            layer.msg("服务器错误");
        }
    });
});