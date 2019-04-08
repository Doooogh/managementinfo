$(function () {
$(".formicon").click(function () {
    var iclass=$(this).attr("iclass");
    parent.$("#img").val(iclass);
    parent.$("#ficon").attr("class","layui-icon  "+iclass);
    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
    parent.layer.close(index);
});
});