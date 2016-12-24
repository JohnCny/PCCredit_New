var myDataTable = function(options){
	var table = options.tableId.DataTable({
		"aLengthMenu":[10,20,40,60],
		"searching":false,//禁用搜索,自定义搜索
		"lengthChange":true,
		"paging": true,//开启表格分页
		"bProcessing" : true,
		"bServerSide" : true,
		"bAutoWidth" : false,
		"sort" : "position",
		"deferRender":true,//延迟渲染
		"bStateSave" : false, //在第三页刷新页面，会自动到第一页
		"iDisplayLength" : 10,
		"iDisplayStart" : 0,
		"dom": '<l<\'#topPlugin\'>f>rt<ip><"clear">',
		"ordering": false,//全局禁用排序
		"ajax" : options.ajax,
		"aoColumns" : options.aoColumns,
		/*"columnDefs" :[{
			"orderable" : false, // 禁用排序
			"targets" : [0], // 指定的列
			"data" : "id",
			"render" : function(data, type, full, meta) {
				return '<input type="checkbox" value="'+ data + '" name="id"/>';
			}
		}],*/
		"oLanguage" : { // 国际化配置
			"sProcessing" : "正在获取数据，请稍后...",
			"sLengthMenu" : "&nbsp;&nbsp;<span>每页显示</span>&nbsp;_MENU_&nbsp;条 ",
			"sZeroRecords" : "没有找到数据",
			"sInfo" : "共 _TOTAL_ 条数据，显示第 _START_ 到第 _END_ 条",
			"sInfoEmpty" : "",
			"sInfoFiltered" : "共 _TOTAL_ 条数据，显示第 _START_ 到第 _END_ 条",
			"sInfoPostFix" : "",
			"sSearch" : "搜索",
			"sUrl" : "",
			"oPaginate" : {
				"sFirst" : "第一页",
				"sPrevious" : "上一页",
				"sNext" : "下一页",
				"sLast" : "最后一页"
			}
		},
		"initComplete" : function(data){
			//上方topPlugin DIV中追加HTML
			//删除用户按钮的HTMLDOM
			var topPlugin='<a href="" class="btn btn-primary btn-sm addBtn" ><i class="icon-add"></i>新 增</a>' +
				/*'<button class="btn btn-danger btn-sm" id="deleteAll">批量删除</button>' +*/
				'<button class="btn btn-info btn-sm" id="expCsv">导出全部</button>' +
				'<button class="btn btn-warning btn-sm" id="reset">重置搜索条件</button>';
			$("#topPlugin").append(topPlugin);//在表格上方topPlugin DIV中追加HTML
			$(".addBtn").attr("href",options.urlNew);
			$(document).on("click",".deleteOne",function(){
				var id=$(this).data("id");
				$.ajax({
					url : options.urlDel+id,
					type : "DELETE",
					success: function(data){
						if(data.code == 200){
							alert("删除成功");
						}else{
							alert("删除失败");
						}

					}
				});
			});
			$(document).on("click",".resetBtn",function () {
				var id = $(this).data("id");
				$.ajax({
					url:"/user",
					data: {"id":id,"password":"123"},
					type:"PUT",
					success:function (data) {
						if(data.code == 200){
							alert("重置成功");
						}
					},
					error:function () {
						alert("重置失败");
					}
					
				})
			});
			$(document).on("click",".activeBtn",function(){
			 		var self = $(this);
					var id = self.data("id");
			 		var temp = self.data("status");
			 		console.log(temp);
			 		var status = temp?0:1;
			 		// $.ajax({
			 		// 	type : "PUT",
					// 	 url : "/user",
			 		// 	data : {"id":id,"status":status},
					// 	 success : function(res){
					// 	 console.log(status);
			 		// 	if(res.code == "200"){
					// 	if(status == 1){
			 		// 	self.removeClass("btn-success").addClass("btn-default").html("点击解锁").attr("data-status",status);
					// 	 }else if(status == 0){
					//  self.removeClass("btn-default").addClass("btn-success").html("点击锁定").attr("data-status",status);
					// 			}
					// 		 }
                    //
					// 	}
					// })
					switch (status){
						case 1:
							$.ajax({
								type : "PUT",
								url : "/user",
								data : {"id":id,"status":status},
								success:function (res) {
									if (res.code == "200"){
										self.removeClass("btn-success").addClass("btn-default").html("点击解锁").attr("data-status",status);
									}
								}
							});
							break;
						case 0:
							$.ajax({
								type : "PUT",
								url : "/user",
								data : {"id":id,"status":status},
								success:function (res) {
									if (res.code == "200"){
										self.removeClass("btn-default").addClass("btn-success").html("点击锁定").attr("data-status",status);
									}
								}
							});
					}
			 });
			/* 点击置空搜索内容 */
			$(document).delegate('#reset','click',function() {
				$(".formReset input").val("");
			});

			/* 自定义搜索  姓名  联系方式  证件号码  创建时间 */
			$(document).delegate('.searchBtn','click',function() {
				table.ajax.reload();
			});
		},
	});
}


/**
 * 表格加载渲染完毕后执行的方法
 * @param data
 */
/*function initComplete(data){
	//上方topPlugin DIV中追加HTML
	//删除用户按钮的HTMLDOM
	var topPlugin='<a href="" class="btn btn-primary btn-sm addBtn" ><i class="icon-add"></i>新 增</a>' +
		'<button class="btn btn-danger btn-sm" id="deleteAll">批量删除</button>' +
		'<button class="btn btn-info btn-sm" id="expCsv">导出全部</button>' +
		'<button class="btn btn-warning btn-sm" id="reset">重置搜索条件</button>';
	$("#topPlugin").append(topPlugin);//在表格上方topPlugin DIV中追加HTML
	$(".addBtn").attr("href",'sdfafd');
}*/






/**
 * 单行删除按钮点击事件响应
 */


/**
 * 点击确认删除按钮
 */










/**
 * 多选选中和取消选中,同时选中第一个单元格单选框,并联动全选单选框
 */
$('#example tbody').on('click', 'tr', function(event) {
	var allChecked=$('input[name=allChecked]')[0];//关联全选单选框
	$($(this).children()[0]).children().each(function(){
		if(this.type=="checkbox" && (!$(event.target).is(":checkbox") && $(":checkbox",this).trigger("click"))){
			if(!this.checked){
				this.checked = true;
				addValue(this);
				var selected=table.rows('.selected').data().length;//被选中的行数
				//全选单选框的状态处理
				var recordsDisplay=table.page.info().recordsDisplay;//搜索条件过滤后的总行数
				var iDisplayStart=table.page.info().start;// 起始行数
				if(selected === table.page.len()||selected === recordsDisplay||selected === (recordsDisplay - iDisplayStart)){
					allChecked.checked = true;
				}
			}else{
				this.checked = false;
				cancelValue(this);
				allChecked.checked = false;
			}
		}
	});
	$(this).toggleClass('selected');//放在最后处理，以便给checkbox做检测
});
/**
 * 全选按钮被点击事件
 */
$('input[name=allChecked]').click(function(){
	if(this.checked){
		$('#example tbody tr').each(function(){
			if(!$(this).hasClass('selected')){
				$(this).click();
			}
		});
	}else{
		$('#example tbody tr').click();
	}
});

/**
 * 单选框被选中时将它的value放入隐藏域
 */
function addValue(para) {
	var userIds = $("input[name=userIds]");
	if(userIds.val() === ""){
		userIds.val($(para).val());
	}else{
		userIds.val(userIds.val()+","+$(para).val());
	}
}

/**
 * 单选框取消选中时将它的value移除隐藏域
 */
function cancelValue(para){
	//取消选中checkbox要做的操作
	var userIds = $("input[name=allChecked]");
	var array = userIds.val().split(",");
	userIds.val("");
	for (var i = 0; i < array.length; i++) {
		if (array[i] === $(para).val()) {
			continue;
		}
		if (userIds.val() === "") {
			userIds.val(array[i]);
		} else {
			userIds.val(userIds.val() + "," + array[i]);
		}
	}
}


//   function exp1(){
//	   $("#exp").attr("src",contextPath+"/department/export.do?t=" + new Date().getTime());
//   }
$(document).delegate('#expCsv','click',function() {

   $("#exp").attr("src",contextPath+"/department/export.do?t=" + new Date().getTime());
   });

$(document).delegate('.addBtn','click',function() {

	$('#myModal-add-info').modal('show');
   });
$(document).delegate('#deleteAll','click',function() {
   var theArray=[];
   $("input[name=id]:checked").each(function() {
		  theArray.push($(this).val());
		});
   if(theArray.length<1){
	   alert("请至少选择一个");
   }else{
	   alert(theArray);
   }

   });
$(document).delegate('.upOrderStatus','click',function() {
	var id=$(this).data("id");
	//alert(id);
	$("#titleId").html(id);
	$('#editOrderStatus').modal("show");
});





