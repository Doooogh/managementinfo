$().ready(function() {
	getImg();
	validateRule();

});
/*window.onload=function () {
	alert(6464);
	getImg();
}*/
$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});

function getImg() {
	var type=$("#perType").val();
	var id=$("#id").val();
	if(type==0){
		$("#formIcon").css("display","inline");
		var img=$("#img").val();
		$("#getIcon").append("\t<i class=\"layui-icon  "+img+"\" id=\"ficon\"style=\"margin-right: 15px;font-size: 25px !important;\"></i>\n" +
            "<input type=\"button\" class=\"btn btn-warning\" id=\"setIcon\"  onclick=\"getIcosList("+id+") \"  value=\"选择图标\"/>\n");
	}
}

function getIcosList(id) {
	layer.open({
        type : 2,
        title : '选择',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '480px', '90%' ],
        content : '/permission/permission/getIcon/'+id // iframe的url
	});
}
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/permission/permission/update",
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
				parent.parent.window.reLoad();

			} else {
				parent.layer.alert(data.msg)
			}
		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}