$(function () {
    $("#formSubmit").click(function () {
        postData();
        }
    );
    function postData() {
        alert("提交数据");
        $.ajax({
            type:"POST",
            url:"/uedito/postData",
            data: $("#form_content").serialize(),
            success:function (data) {
                alert(data.msg);
                layer.msg("操作成功");
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
                        //Hash地址的定位
                        var layid = location.hash.replace(/^#test=/, '');
                        element.tabChange('test', layid);

                        element.on('tab(test)', function(elem){
                            location.hash = 'test='+ $(this).attr('lay-id');
                        });

                    });
                }
            },
            error:function () {
                alert("服务器错误");
            }
        });

    }
});