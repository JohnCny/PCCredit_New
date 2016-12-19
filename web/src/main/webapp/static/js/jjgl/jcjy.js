$().ready(function() {//验证信息
	var container = $('div.alert');
	// 在键盘按下并释放及提交后验证提交表单
	$("#Form").validate({
		rules: {
			"1_1": {
				maxlength: 11,
				je: true
			},
			"2_1": {
				maxlength: 11,
				je: true
			},
			"3_1": {
				maxlength: 11,
				je: true
			},
			"4": {
				maxlength: 11,
				je: true
			},
			"5": {
				maxlength: 11,
				je: true
			},
			"6": {
				maxlength: 11,
				je: true
			},
			"7": {
				maxlength: 11,
				je: true
			}
		},
		errorContainer: container,
		errorLabelContainer: $("ol", container),
		wrapper: 'li'
	});
});
$.extend($.validator.messages, {
	maxlength: $.validator.format("金额最多可以输入 {0} 个字符")
});

function addTd(table){   
	//----------------------贷前调查——交叉检验--------------------------
	if(table=="qcqyhj"){//期初权益合计&期初权益合计
		$("#"+table).append("<tr class='add'>"+
								"<td class='lev1'><input type='text' name='name_1' class='short'/></td>"+
								"<td><input type='text' name='1_1' onblur='count(1)' class='short'/></td>"+
								"<td class='lev1'><input type='text' name='name_2' class='short'/></td>"+
								"<td><input type='text' name='2_1' onblur='count(2)' class='short'/></td>"+
							"</tr>");
    }
	if(table=="dxzchj"){//大项支出合计
		$("#"+table).append("<tr class='add'>"+
								"<td class='lev1'><input type='text' name='name_3' class='short'/></td>"+
								"<td><input type='text' name='3_1' onblur='count(3)' class='short'/></td>"+
							"</tr>");
    }
}
function count(num){			
	sum(num);
	$("strong[name=8]").html("￥"+(getValue(1)+getValue(2)-getValue(3)+getValue1(4)+getValue1(5)-getValue1(6)-getValue1(7)));//应有权益=期初权益+分析期间收入-大项支出+其他收入+升值-折旧（计入资产负债表的）-表外资产
	$("strong[name=10]").html("￥"+(getValue(8)-getValue(9)));//权益差额=应有权益-实际权益
	$("strong[name=11]").html("￥"+getValue(2));//分析期间累计收入=分析期间收入合计	
	$("strong[name=12]").html(Math.round(getValue(10)/getValue(11)*10000)/100+"%");//权益交叉检验比率= 权益差额/分析期间累计收入
}
function sum(num){//单项求和
	var sum=0;
	var length=$("input[name="+num+"_1]").length;
	for(i=0;i<length;i++){
		var a=$("input[name="+num+"_1]")[i].value;
		if(a==""){a=0;}else{a=parseInt(a);}
		sum+=a;
	}
	$("strong[name="+num+"]").html("￥"+sum);
}
function getValue(num){//获取值
	var b=$("strong[name="+num+"]").html().substring(1);
	if(b==""){b=0;}
	else{b=parseInt(b);}
	return b;
}	
function getValue1(num){//获取值
	var b=$("input[name="+num+"]").val()
	if(b==""){b=0;}
	else{b=parseInt(b);}
	return b;
}	