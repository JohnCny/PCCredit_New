//切换iframe里的内容用于iframe内部页面	
function iframe(page){
	window.location.href = page;
	//window.location.href = "/" + page;
	// alert(window.location.href);
}
var date=new Date();
var year=date.getFullYear();
var month=creattime(date.getMonth()+1);
var day=creattime(date.getDate()); 
function creattime(i){
	if(i<10)
		{i="0"+i};
	return i;
}
function datepicker(){
	$('.datepicker').datepicker();
	//给空的datepicker一个默认当天值
	$('.datepicker').each(function(){
		if(this.value==""){
			this.value=year+"-"+month+"-"+day;
		}
	});
}
/**
 * 消息闪现
 */
function setTimeOut(){
    setTimeout(function(){
        $(".alert-success").fadeOut("slow");
        $(".alert-error").fadeOut("slow");
    },3000)
}
function addTd(table){    
	if(table=="tpsm"){//图片说明
		var num=$("#"+table+" tr").length
        $("#"+table).append("<tr>"+
								"<td class='pull-right'>图片说明：</td>"+
								"<td><input type='text'/></td>"+
								"<td class='pull-right'>是否必选：</td>"+
								"<td>"+
									"<span class='hideInput'><input type='radio' name='radio"+num+"'/><label onclick='setRadio(this)' class='radio'>是</label></span>"+
									"<span class='hideInput'><input type='radio' name='radio"+num+"'/><label onclick='setRadio(this)' class='radio'>否</label></span>"+
								"</td>"+
							"</tr>");      
    } 
	//----------------------担保抵押调查表--------------------------
	if(table=="gtjkr"){//共同借款人
        $("#"+table).append("<tr class='add'>" +
								"<th rowspan='2'>" +
									"姓名<input type='text' name='name' onchange='spryMaxLength(this,32)' class='tbInput'/>"+
								"</th>" +
								"<td>" +
									"与客户关系" +
									"<input type='text' name='relationship' onchange='spryMaxLength(this,32)' class='tbInput'/>" +
								"</td>		" +					
								"<td>" +
									"身份证号码<input type='text' name='id_number' onchange='checkIdcard(this)' class='tbInput'/>" +
								"</td>" +
								"<td>" +
									"家庭电话<input type='text' name='phone' class='tbInput' onkeyup='value=value.replace(/[^0-9]/g,&apos;&apos;)' onblur='getLength(this)'/>" +
								"</td>" +
								"<td>" +
									"主营业务或职务<input type='text' name='main_business' onchange='spryMaxLength(this,128)' class='tbInput'/>" +
								"</td>	" +
								"<td>" +
									"经营地址或工作单位地址<input type='text' name='address' onchange='spryMaxLength(this,256)' class='tbInput'/>" +
								"</td>	" +
								"<td>" +
									"主要资产<input type='text' name='major_assets' onchange='spryMaxLength(this,256)' class='tbInput'/>" +
								"</td>" +
								"<td>" +
									"月收入<input type='text' name='monthly_income' onkeyup='setJe(this);' maxlength='11' class='tbInput'/>" +
								"</td>" +
                            "</tr>"+
                            "<tr class='add'>" +
								"<td colspan='2'>" +
									"家庭详细地址<input type='text' name='home_addr' onchange='spryMaxLength(this,128)' class='tbInput'/>" +
								"</td>" +	
								"<td>" +
									"户籍所在地<input type='text' name='hj_addr' onchange='spryMaxLength(this,128)' class='tbInput'/>" +
								"</td>	" +
								"<td>" +
									"住房性质" +
									"<select name='home'>"+
										"<option value='自有产权(按揭)'>自有产权(按揭)</option>"+
										"<option value='自有产权(无按揭)'>自有产权(无按揭)</option>"+
										"<option value='小产权'>小产权</option>"+
										"<option value='租用'>租用</option>"+
										"<option value='其他'>其他</option>"+
									"</select>" +
								"</td>" +
								"<td colspan='3'>" +
									"备注<input type='text' name='remark' onchange='spryMaxLength(this,256)' class='tbInput'/>" +
								"</td>" +
                            "</tr>"

                            );
    }
    if(table=="dbr"){//担保人
        $("#"+table).append("<tr class='add'>" +
								"<th rowspan='2'>姓名<input type='text' name='name_db' value='' onchange='spryMaxLength(this,32)' class='tbInput'/></th>" +
								"<td>与客户关系<input type='text' name='address_db' value='' onchange='spryMaxLength(this,256)' class='tbInput'/></td>" +							
								"<td>" +
									"身份证号码<input type='text' name='id_number_db' value='' onchange='checkIdcard(this)' class='tbInput'/>" +
								"</td>	" +
								"<td>" +
									"家庭电话<input type='text' name='workunit_db' value='' onchange='spryMaxLength(this,256)' class='tbInput'/>" +
								"</td>" +
								"<td>" +
									"主营业务或职务<input type='text' name='phone_db' value='' onkeyup='value=value.replace(/[^0-9]/g,&apos;&apos;)' maxlength='11' class='tbInput'/>" +									
								"</td>	" +
								"<td>" +
									"经营地址或工作单位地址" +
									"<input type='text' name='relationship_db' value='' onchange='spryMaxLength(this,32)' class='tbInput'/>" +
								"</td>" +
								"<!--add By WX-->" +
								"<td>" +
									"主要资产<input type='text' name='major_assets' value='' onchange='spryMaxLength(this,256)' class='tbInput'/>" +
								"</td>" +
								"<td>" +
									"月收入<input type='text' name='monthly_income' value='' onkeyup='setJe(this);' maxlength='11' class='tbInput' onclick='setJe(this);'/>" +
								"</td>" +
							"</tr>"+
                            "<tr class='add'>" +
								"<td colspan='2'>" +
									"家庭详细地址<input type='text' name='' onchange='spryMaxLength(this,128)' class='tbInput'/>" +
								"</td>" +	
								"<td>" +
									"户籍所在地<input type='text' name='' onchange='spryMaxLength(this,128)' class='tbInput'/>" +
								"</td>	" +
								"<td>" +
									"住房性质" +
									"<select name=''>"+
										"<option value='1'>自有产权(按揭)</option>"+
										"<option value='2'>自有产权(无按揭)</option>"+
										"<option value='3'>小产权</option>"+
										"<option value='4'>租用</option>"+
										"<option value='5'>其他</option>"+
									"</select>" +
								"</td>" +
								"<td colspan='3'>" +
									"备注<input type='text' name='' onchange='spryMaxLength(this,256)' class='tbInput'/>" +
								"</td>" +
                            "</tr>"
                              );
    }
    if(table=="jydyw"){//建议抵押物
        $("#"+table).append("<tr class='add'>" +
								"<td>" +
									"<input type='text' name='obj_name' value='' onchange='spryMaxLength(this,32)' class='tbInput'/>" +
								"</td>		" +	
								"<td>" +
									"<input type='text' name='owner_address' value='' onchange='spryMaxLength(this,128)' class='tbInput'/><br/>" +
								"</td>		" +		
								"<td>" +
									"<input type='text' name='description' value='' onchange='spryMaxLength(this,256)' class='tbInput'/><br/>" +
								"</td>	" +
								"<td>" +
									"<input type='text' name='registration_number' value='' onkeyup='value=value.replace(/[^0-9]/g,&apos;&apos;)' maxlength='11' class='tbInput'/><br/>" +									
								"</td>	" +
								"<td>" +
									"<input type='text' name='appraisal' value='' onkeyup='setJe(this);' maxlength='11' class='tbInput' onclick='setJe(this)'/>" +
								"</td>" +
								"<td>" +
									"<input type='text' name='mortgage' value='' onkeyup='setJe(this);' maxlength='11' class='tbInput' onclick='setJe(this)'/>" +
								"</td>		" +		
								"<td><input type='checkbox' id=''/></td>	" +
                            "</tr>");
    }
	//----------------------贷前调查——固定资产清单--------------------------
	if(table=="fdcxd"){//房地产详单
        $("#"+table).append("<tr class='insideTb center'>"+								
								"<td>"+
									"<input type='text' name='name'/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='purchase_date' class='datepicker' data-date-format='yyyy-mm-dd' readonly/>"+
								"</td>"+									        
								"<td>"+
									"<input type='text' name='purchase_price' maxlength='11' onblur='count(this,\"purchase_price\",\"rate\",\"total\",\"total_price\",\"rate_price\");sub()'/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='rate' onblur='count(this,\"purchase_price\",\"rate\",\"total\",\"total_price\",\"rate_price\");sub()' style='width:40px'/>%"+
								"</td>"+
								"<td>"+
									"<input type='text' name='total' maxlength='10' onblur='count(this,\"purchase_price\",\"rate\",\"total\",\"total_price\",\"rate_price\");sub()'/>"+	
								"</td>"+
								"<td>"+
									"<input type='text' name='total_price' class='subData1' value='0' readonly/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='rate_price'  class='subData2' value='0' readonly/>"+
								"</td>"+			
							"</tr>");
		datepicker();
    } 
if(table=="sbjqcxd"){//设备及器材详单
        $("#"+table).append("<tr class='insideTb center'>"+								
								"<td>"+
									"<input type='text' name='name' />"+
								"</td>"+
								"<td>"+
									"<input type='text' name='purchase_date' class='datepicker' data-date-format='yyyy-mm-dd' readonly/>"+
								"</td>"+									        
								"<td>"+
									"<input type='text' name='purchase_price' maxlength='11' onblur='count(this,\"purchase_price\",\"rate\",\"total\",\"total_price\",\"rate_price\");sub()'/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='rate' onblur='count(this,\"purchase_price\",\"rate\",\"total\",\"total_price\",\"rate_price\");sub()' style='width:40px'/>%"+
								"</td>"+
								"<td>"+
									"<input type='text' name='total' maxlength='10' onblur='count(this,\"purchase_price\",\"rate\",\"total\",\"total_price\",\"rate_price\");sub()'/>"+	
								"</td>"+
								"<td>"+
									"<input type='text' name='total_price' class='subData3' value='0' readonly/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='rate_price' class='subData4' value='0' readonly/>"+
								"</td>"+			
							"</tr>");
		datepicker();
    } 
if(table=="clxd"){//车辆详单
        $("#"+table).append("<tr class='insideTb center'>"+									
								"<td>"+
									"<input type='text' name='name' />"+
								"</td>"+
								"<td>"+
									"<input type='text' name='purchase_date' class='datepicker' data-date-format='yyyy-mm-dd' readonly/>"+
								"</td>"+									        
								"<td>"+
									"<input type='text' name='purchase_price' maxlength='11' onblur='count(this,\"purchase_price\",\"rate\",\"total\",\"total_price\",\"rate_price\");sub()'/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='rate' onblur='count(this,\"purchase_price\",\"rate\",\"total\",\"total_price\",\"rate_price\");sub()' style='width:40px'/>%"+
								"</td>"+
								"<td>"+
									"<input type='text' name='total' maxlength='10' onblur='count(this,\"purchase_price\",\"rate\",\"total\",\"total_price\",\"rate_price\");sub()'/>"+	
								"</td>"+
								"<td>"+
									"<input type='text' name='total_price' class='subData5' value='0' readonly/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='rate_price' class='subData6' value='0' readonly/>"+
								"</td>"+			
							"</tr>");
		datepicker();
    } 
	//----------------------贷前调查——库存--------------------------
	if(table=="kcxx"){//库存信息
        $("#"+table).append("<tr class='insideTb center'>"+								
								"<td>"+
									"<input type='text' name='name' />"+
								"</td>"+	
								"<td>"+
									"<input type='text' name='amount' class='subData1' maxlength='32' onblur='count(this,\"amount\",\"purchase_price\",\"purchase_total_price\");sub()'/>"+																
								"</td>"+
								"<td>"+
									"<input type='text' name='purchase_price' maxlength='18' onblur='count(this,\"amount\",\"purchase_price\",\"purchase_total_price\");sub()'/>"+										
								"</td>"+
								"<td>"+
									"<input type='text' name='purchase_total_price' class='subData2' value='0' readonly/>"+										
								"</td>"+							
							"</tr>");
    } 
}
//表格删除行
function removeTd(table){  
	var tr= document.getElementById(table).getElementsByTagName("tr");
	if(tr.length>1){//至少要保留一行
		document.getElementById(table).deleteRow(tr.length-1);//删除最后一行
	}
}

/*全选*/
function checkAll(obj,name){
	var arrSon = document.getElementsByName(name);
	if($(obj).attr("checked")!="checked"){
		$(obj).attr("checked","checked")
		for(i=0;i<arrSon.length;i++) {
			if(arrSon[i].checked!=true)
				arrSon[i].click();
		}
	}
	else{
		$(obj).removeAttr("checked")
		for(i=0;i<arrSon.length;i++) {
			if(arrSon[i].checked!=false)
				arrSon[i].click();
		}
	}
}

function setCheckbox(obj){//多选样式
	//alert($(obj).parent().find("input[type=checkbox]").attr("checked"))
	if($(obj).parent().find("input[type=checkbox]").attr("checked")!="checked"){
		$(obj).attr("class","checkbox checkbox_a")
		$(obj).parent().find("input[type=checkbox]").attr("checked",true)
	}
	else{
		$(obj).attr("class","checkbox")
		$(obj).parent().find("input[type=checkbox]").attr("checked",false)
	}	
}
function setRadio(obj){//单选样式
	$(obj).parent().parent().find("input[type=radio]").attr("checked",false)
	$(obj).parent().parent().find("label").attr("class","radio")
	$(obj).parent().find("input[type=radio]").attr("checked",true)
	$(obj).parent().find("label").attr("class","radio radio_a")	
}
function setRadio2(obj){//单选样式（列表）
	$(obj).parent().parent().parent().parent().find("input[type=radio]").attr("checked",false)
	$(obj).parent().parent().parent().parent().find("label").attr("class","radio")
	$(obj).parent().find("input[type=radio]").attr("checked",true)
	$(obj).parent().find("label").attr("class","radio radio_a")	
}
function setTab(obj,src){//切换tab页
	$(obj).parent().find("li").attr("class","")
	$(obj).attr("class","active")
	$("iframe").attr("src",src)
}
function setTab2(obj,id){//切换tab页
	$(obj).parent().find("li").attr("class","")
	$(obj).attr("class","active")
	$(".tabContent").hide();
	$("#"+id).show();
}
//table搜索
function search(obj){         
    var value=$(obj).val();
    if(value==""){
        $("tr").show();
    }
    else{
        $("td[name=search]").each(function(){
            if(this.innerHTML.indexOf(value)>=0){
                $(this).parent().show();
            }                       
            else{
                $(this).parent().hide();
            }
                
        })
    }

}
function checkSelect(obj,id){//添加选中项（select多选）
	var text=$(obj).find('option:selected').text()
	if($("#"+id).html().indexOf(text)<0){
		$("#"+id).html($("#"+id).html()+"<span onclick='delSelect(this)'>"+text+"</span>")
	}
}
function  delSelect(obj){//删除选中项		
	$(obj).remove()
}
function selectTR(obj){//单选行
	$(obj).parent().find("tr td").css("background","#fff");
	$(obj).find("td").css("background","#dff0d8");//改变行背景
	$(obj).parent().find("").removeAttr("checked")
	$(obj).parent().find("label").attr("class","radio")
	$(obj).find("input[type=radio]").attr("checked","checked")
	$(obj).find("label").attr("class","radio radio_a")//radio
}

function selectTR2(obj){//多选行	
	if($(obj).find("input[type=checkbox]").attr("checked")!="checked"){
		$(obj).find("label").attr("class","checkbox checkbox_a")
		$(obj).find("input[type=checkbox]").attr("checked",true)
		$(obj).find("td").css("background","#dff0d8");//改变行背景
	}
	else{
		$(obj).find("label").attr("class","checkbox")
		$(obj).find("input[type=checkbox]").attr("checked",false)
		$(obj).find("td").css("background","#fff");//改变行背景
	}	
}