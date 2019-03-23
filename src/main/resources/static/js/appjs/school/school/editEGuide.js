$(function () {
    setContent();
    $("#formSubmit").click(function () {
        postData();
        }
    );
    function postData() {
        $.ajax({
            type:"POST",
            url:"/uedito/postData",
            data: $("#form_content").serialize(),
            success:function (data) {
                var tid= $('.layui-tab-title .layui-this', window.parent.document).attr("lay-id");
                if(data.code==0){
                    layui.use('element', function(){
                        var $ = layui.jquery
                            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
                        element=parent.window.e;
                        //触发事件
                        var active = {
                            tabDelete: function(othis){
                                //删除指定Tab项
                                element.tabDelete('bodyTab', tid); //删除：“商品管理”
                                othis.addClass('layui-btn-disabled');
                            }
                        };

                        active.tabDelete();
                        layer.msg(data.msg);
                    });
                }
            },
            error:function () {
                alert("服务器错误");
            }
        });

    }

  
});
function setContent() {
    var str=$("#s_content").val();
    if(str!=null||str!=""){
        ue.ready(function() {
            //设置编辑器的内容
            ue.setContent(str);
        });
    }
}