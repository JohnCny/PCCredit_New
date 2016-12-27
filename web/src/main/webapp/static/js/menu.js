//切换iframe里的内容用于主页面
function Iframe(src){
	$('#iframe').attr('src',src)
}

function showMenu(obj){//一级菜单
	if($(obj).html().indexOf("ul")>0){//单击项如果有二级菜单
		$(obj).parent().find(".second-nav").hide();//隐藏菜单中所有二级菜单
		$(obj).parent().find(".active").each(function(){//遍历菜单中已选择项是否有二级菜单
			if($(this).html().indexOf("ul")>0)//已选中项有二级菜单
				$(this).attr("class","menu-list");//取消选中样式，否则不取消
		});
		
		$(obj).find(".second-nav").show();//显示单击项的二级菜单	
		$(obj).attr("class","active");//单击项样式改为选中	
	}		
	else{//如果单击项没二级菜单
		$(obj).parent().find(".second-nav").hide();//隐藏所有二级菜单
		$(obj).parent().find(".active").attr("class","menu-list")//取消一级菜单所有选中样式
		$(obj).parent().find(".second-active").attr("class","")//取消二级菜单所有选中样式			
		$(obj).attr("class","active")//单击项样式改为选中
	}
}
function setNav(){
	$(".nav li").attr("class","menu-list")
	$(".second-nav li").attr("class","")
	$(".second-nav").hide();
	$(".small-list li").attr("class","")
}
function checkSecond(obj,e){//二级菜单
	$(obj).parent().parent().parent().find(".active").attr("class","menu-list")//取消一级菜单所有选中样式
	$(obj).parent().parent().parent().find(".second-active").attr("class","")//取消二级菜单所有选中样式			
	$(obj).parent().parent().attr("class","active")//单击项所在一级菜单样式改为选中
	$(obj).attr("class","second-active")////单击项所在二级菜单样式改为选中
	//e.cancelBubble(); 
	//设置相应小nav样式
	$(".small-left").find(".active").attr("class","menu-list")
	$(".small-left").find(".second-active").attr("class","")
	$("#"+$(obj).attr("id")+"1").attr("class","second-active")
	$("#"+$(obj).attr("id")+"1").parent().parent().parent().attr("class","menu-list active")
	e.stopPropagation();//取消冒泡，不执行父类showMenu(obj)事件
}
function changeNav(){
	if($(".left").css("display")=="block"){
		$(".left").hide();
		$(".small-left").show();
		$(".top").css("left","52px")
		$(".bottom").css("left","52px")
	}
	else{	
		$(".small-left").hide();
		$(".left").show();
		$(".top").css("left","240px")
		$(".bottom").css("left","240px")
	}
}
function setSmallList(obj,id){//小Nav样式切换
	$(obj).parent().parent().parent().parent().find(".active").attr("class","menu-list")//取消一级菜单所有选中样式
	$(obj).parent().parent().parent().parent().find(".second-active").attr("class","")//取消二级菜单所有选中样式	
	$(obj).parent().parent().parent().attr("class","menu-list active")//单击项所在一级菜单样式改为选中
	$(obj).attr("class","second-active")//单击项样式改为选中
	$("#"+id).click();
}