 window.i=0;
$(function () {
   $("#type").blur(function () {
       var type=$("#type").val();
           if(type==0){
           $("#formIcon").css("display","inline");
       }else{
           $("#formIcon").css("display","none");
           }
   });
   
});

function getIcosList() {
    layer.open({
        type : 2,
        title : '选择',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '480px', '90%' ],
        content : '/permission/permission/getIcon/-1' // iframe的url
    });
}