
$().ready(function() {
	setIcon();
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
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

function setIcon(){
    $("#type").blur(function () {
        var type=$("#type").val();
        if(type==0){
            $("#formIcon").css("display","inline");
        }else{
            $("#formIcon").css("display","none");
        }
    });
}
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/permission/permission/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
                parent.location.reload();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	if($("#type").val()==0){
        $("#signupForm").validate({
            rules : {
                parentId : {
                    required : true
                },
                name : {
                    required : true
                },
                type : {
                    required : true
                },
				img:{
                    required : true
				}

            },
            messages : {
                parentId : {
                    required : icon + "请输入父id"
                },
                name : {
                    required : icon + "请输入权限描述"
                },
                type : {
                    required : icon + "请输入类型"
                },
				img:{
                    required : icon + "请选择图标"
				}

            }
        })
	}else{
        $("#signupForm").validate({
            rules : {
                parentId : {
                    required : true
                },
                name : {
                    required : true
                },
                type : {
                    required : true
                }

            },
            messages : {
                parentId : {
                    required : icon + "请输入父id"
                },
                name : {
                    required : icon + "请输入权限描述"
                },
                type : {
                    required : icon + "请输入类型"
                },

            }
        })
	}

}