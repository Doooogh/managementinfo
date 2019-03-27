
var prefix = "/school/school"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
					           // name:$('#searchName').val(),
					           name:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
																{
									field : 'id', 
									title : 'id' 
								},
																{
									field : 'name', 
									title : '学校名字' 
								},
																{
									field : 'id',
									title : '招生简章' ,
									formatter:function (value,row,index) {
										var str="<a style=\"text-decoration: none\" onclick=\"lookEnrollmentGuide("+value+")\">查看</a>\n" +
                                            "<a style=\"text-decoration: none;margin-left: 5px\" onclick=\"editEnrollmentGuide("+value+")\">编辑</a>";
										return str;
                                    }
								},
																{
									field : 'id',
									title : '试题库' ,
									formatter:function (value,row,index) {
										var str="<a style=\"text-decoration:none;\" onclick=\"lookTestQuestion("+value+")\">查看</a>";
										return str;
									}
								},
								{
									field : 'id',
									title : '视频库',
                                    formatter:function (value,row,index) {
                                        var str="<a style=\"text-decoration:none;\" onclick=\"lookVideoDatabase("+value+")\">查看</a>";
                                        return str;
                                    }
								},
								{
									field : 'id',
									title : '分数线',
                                    formatter:function (value,row,index) {
                                        var str="<a style=\"text-decoration:none;\" onclick=\"lookGradeMark("+value+")\">查看</a>";
                                        return str;
                                    }
								},
															{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.id
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id) {
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});

}

//查看招生简章
function lookEnrollmentGuide(id) {
    var houseTitle='招生简章';
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
        element=parent.window.e;
        var tid='newTab'+new Date().getTime();
        //触发事件
        var active = {
            tabAdd: function(){
                $('#top_tabs_box', window.parent.document).attr("lay-allowClose","true");
                //新增一个Tab项
                element.tabAdd('bodyTab', {
                    title: houseTitle //用于演示
                    ,content:"<iframe src='" + "/school/school/lookEnrollmentGuide/"+id+"' ></iframe>"
                    ,id: tid //实际使用一般是规定好的id，这里以时间戳模拟下
                });

            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('bodyTab', tid); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            ,tabChange: function(){
                //切换到指定Tab项
                element.tabChange('bodyTab',tid); //切换到：用户管理
            }
        };


        active.tabAdd();
        active.tabChange();


        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });

    });
}
function editEnrollmentGuide(id) {
    var title='招生简章编辑';
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
        element=parent.window.e;
        var tid='newTab'+new Date().getTime();
        //触发事件
        var active = {
            tabAdd: function(){
                $('#top_tabs_box', window.parent.document).attr("lay-allowClose","true");
                //新增一个Tab项
                element.tabAdd('bodyTab', {
                    title: title //用于演示
                    ,content:"<iframe src='" + "/school/school/editEnrollmentGuide/"+id+"' ></iframe>"
                    ,id: tid //实际使用一般是规定好的id，这里以时间戳模拟下
                });

            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('bodyTab', tid); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            ,tabChange: function(){
                //切换到指定Tab项
                element.tabChange('bodyTab',tid); //切换到：用户管理
            }
        };


        active.tabAdd();
        active.tabChange();


        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });

    });
}
function lookTestQuestion(id) {
    var title='试题库';
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
        element=parent.window.e;
        var tid='newTab'+new Date().getTime();
        //触发事件
        var active = {
            tabAdd: function(){
                $('#top_tabs_box', window.parent.document).attr("lay-allowClose","true");
                //新增一个Tab项
                element.tabAdd('bodyTab', {
                    title: title //用于演示
                    ,content:"<iframe src='" + "/school/school/lookTestQuestion/"+id+"' ></iframe>"
                    ,id: tid //实际使用一般是规定好的id，这里以时间戳模拟下
                });

            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('bodyTab', tid); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            ,tabChange: function(){
                //切换到指定Tab项
                element.tabChange('bodyTab',tid); //切换到：用户管理
            }
        };


        active.tabAdd();
        active.tabChange();


        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });

    });
}

function lookVideoDatabase(id) {
    var title='视频库';
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
        element=parent.window.e;
        var tid='newTab'+new Date().getTime();
        //触发事件
        var active = {
            tabAdd: function(){
                $('#top_tabs_box', window.parent.document).attr("lay-allowClose","true");
                //新增一个Tab项
                element.tabAdd('bodyTab', {
                    title: title //用于演示
                    ,content:"<iframe src='" + "/school/school/lookVideoDatabase/"+id+"' ></iframe>"
                    ,id: tid //实际使用一般是规定好的id，这里以时间戳模拟下
                });

            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('bodyTab', tid); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            ,tabChange: function(){
                //切换到指定Tab项
                element.tabChange('bodyTab',tid); //切换到：用户管理
            }
        };


        active.tabAdd();
        active.tabChange();


        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });

    });
}

function lookGradeMark(id) {
    var title='分数线';
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
        element=parent.window.e;
        var tid='newTab'+new Date().getTime();
        //触发事件
        var active = {
            tabAdd: function(){
                $('#top_tabs_box', window.parent.document).attr("lay-allowClose","true");
                //新增一个Tab项
                element.tabAdd('bodyTab', {
                    title: title //用于演示
                    ,content:"<iframe src='" + "/grademark/gradeMark?scId="+id+"' ></iframe>"
                    ,id: tid //实际使用一般是规定好的id，这里以时间戳模拟下
                });

            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('bodyTab', tid); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            ,tabChange: function(){
                //切换到指定Tab项
                element.tabChange('bodyTab',tid); //切换到：用户管理
            }
        };


        active.tabAdd();
        active.tabChange();


        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });

    });
}