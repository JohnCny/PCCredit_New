$().ready(function() {//验证信息
	var container = $('div.alert');
	// 在键盘按下并释放及提交后验证提交表单
	$("#Form").validate({
		rules: {
			"2_1": {
				maxlength: 11,
				je: true
			},
			"3_1": {
				maxlength: 11,
				je: true
			},
			"4_1": {
				maxlength: 11,
				je: true
			},
			"5_1": {
				maxlength: 11,
				je: true
			},
			"6_1": {
				maxlength: 11,
				je: true
			},
			"7_1": {
				maxlength: 11,
				je: true
			},
			"8_1": {
				maxlength: 11,
				je: true
			},
			"9_1": {
				maxlength: 11,
				je: true
			},
			"10_1": {
				maxlength: 11,
				je: true
			},
			"11_1": {
				maxlength: 11,
				je: true
			},
			"12_1": {
				maxlength: 11,
				je: true
			},
			"13_1": {
				maxlength: 11,
				je: true
			},
			"15_1": {
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
	if(table=="yfzk"){//现金及银行存款&应付账款
        $("#"+table).append("<tr class='add'>" +								
								"<td class='lev3'><input type='text' name='name_2' class='short'/></td>"+
								"<td>" +
									"<input type='text' name='2_1' onblur='count(2,2)' class='short'/>" +
								"</td>" +
								"<td class='lev3'><input type='text' name='name_23' class='short'/></td>"+
								"<td>" +
									"<input type='text' name='3_1' onblur='count(3,3)' class='short'/>" +
								"</td>" +
                            "</tr>");
    }
	if(table=="yszk"){//应收账款&预收账款
        $("#"+table).append("<tr class='add'>" +
								"<td class='lev3'><input type='text' name='name_4' class='short'/></td>"+
								"<td>" +
									"<input type='text' name='4_1' onblur='count(4,2)' class='short'/>" +
								"</td>" +
								"<td class='lev3'><input type='text' name='name_5' class='short'/></td>"+
								"<td>" +
									"<input type='text' name='5_1' onblur='count(5,3)' class='short' />" +
								"</td>" +
                            "</tr>");		
    }
	if(table=="yfkx"){//预付款项&短期借款
        $("#"+table).append("<tr class='add'>" +
								"<td class='lev3'><input type='text' name='name_6' class='short'/></td>"+
								"<td>" +
									"<input type='text' name='6_1' onblur='count(6,2)' class='short' />" +
								"</td>" +
								"<td class='lev3'><input type='text' name='name_7' class='short'/></td>"+
								"<td>"+
									"<input type='text' name='7_1' onblur='count(7,3)' class='short' />" +
								"</td>" +
                            "</tr>");	
    }
	if(table=="ch"){//存货&社会集资
        $("#"+table).append("<tr class='add'>" +
								"<td class='lev3'><input type='text' name='name_8' class='short'/></td>"+
								"<td>" +
									"<input type='text' name='8_1' onblur='count(8,2)' class='short' />" +
								"</td>" +
								"<td class='lev3'><input type='text' name='name_9' class='short'/></td>"+
								"<td>" +
									"<input type='text' name='9_1' onblur='count(9,3)' class='short' />" +
								"</td>" +
                            "</tr>");	
    }
	if(table=="gdzc"){//固定资产&长期借款
        $("#"+table).append("<tr class='add'>" +
								"<td class='lev3'><input type='text' name='name_10' class='short'/></td>"+
								"<td>" +
									"<input type='text' name='10_1' onblur='count(10,2)' class='short' />" +
								"</td>" +
								"<td class='lev3'><input type='text' name='name_11' class='short'/></td>"+
								"<td>" +
									"<input type='text' name='11_1' onblur='count(11,3)' class='short' />" +
								"</td>" +
                            "</tr>");	
    }
	if(table=="qt"){//其他经营资产&其他
        $("#"+table).append("<tr class='add'>" +
								"<td class='lev3'><input type='text' name='name_12' class='short'/></td>" +
								"<td>" +
									"<input type='text' name='12_1' onblur='count(12,2)' class='short'/>" +
								"</td>" +
								"<td class='lev3'><input type='text' name='name_13' class='short'/></td>" +
								"<td>" +
									"<input type='text' name='13_1' onblur='count(13,3)' class='short' />" +
								"</td>" +
                            "</tr>");	
    } 
	if(table=="dbye"){//为他人担保余额
        $("#"+table).append("<tr class='add'>" +
								"<td class='lev3'></td>" +
								"<td></td>" +
								"<td class='lev3'><input type='text' name='name_15' class='short'/></td>" +
								"<td>" +
									"<input type='text' name='15_1' onblur='count(15,3)' class='short'/>" +
								"</td>" +
                            "</tr>");	
    } 
	
}

function count(num,num2){
	sum(num);
	sum4(num2);
	tj();
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

function sum4(num){//流动资产和短期负债
	var sum=0;
	for(i=0;i<4;i++){
		var a=$("strong[name="+(num+2*i)+"]").html().substring(1);
		if(a==""){a=0;}else{a=parseInt(a);}
		sum+=a;
	}
	$("strong[name="+(num-2)+"]").html("￥"+sum)
}
function getValue(num){//获取值
	var b=$("strong[name="+num+"]").html().substring(1);
	if(b==""){b=0;}
	else{b=parseInt(b);}
	return b;
}		
function division(m,n){//除法
	var ansow=0;
	if(getValue(m)=="0"){
		ansow=0
	}
	else{
		ansow=getValue(m)/getValue(n)*100;
		ansow=Math.round(ansow*100)/100;
	}
	return ansow;
}
function tj(){//统计
	$("strong[name=16]").html("￥"+(getValue(1)+getValue(11)+getValue(13)+getValue(15)));//负债总计
	$("strong[name=18]").html("￥"+(getValue(0)+getValue(10)+getValue(12)));//资产总计
	$("strong[name=17]").html("￥"+(getValue(18)-getValue(16)));//所有者权益
	$("strong[name=19]").html("￥"+getValue(18));//负债及所有者权益			
	
	$("strong[name=20]").html(division(16,17)+"%");//借款金额/所有者权益
	$("strong[name=21]").html(division(16,18)+"%");//资产负债率
	$("strong[name=22]").html(division(0,1)+"%");//流动比率
}