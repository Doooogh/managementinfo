$(function () {
    $("#submit").click(function () {
        $.ajax({
            type:'POST',
            url:'/login',
            data:{
                username:$("#username").val(),
                password:$("#password").val()
            },
            dataType:'json',
            success:function (data) {
                if(data.code==0){
                    parent.location.href = '/index';
                }else {
                    var msg=data.msg;
                    $("#msg").text(msg);
                }
            },
            error:function () {
                layer.msg("服务器错误");
            }
        });
    });

});