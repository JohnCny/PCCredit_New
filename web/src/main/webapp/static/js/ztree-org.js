function baseTree(url, setting) {
    var height = $(window).height();
    var height = $(window).height();
    $(".treeBox").css("height", (parseInt(height) - 170) + "px");
    $(".wdlb").css("height", (parseInt(height) - 176) + "px");
    var zTreeObj;
    $.ajax({
        type: 'GET',
        url: url,
        success: function (res) {
            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, res.data);
        }
    });
}