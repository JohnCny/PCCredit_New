function addTd(table){  	
	//----------------------现金流分析--------------------------
    if(table=="qtfyx"){//其他费用息
        $("#"+table).append("<tr >"+
								"<td>"+
									"<input type='text' name='items_name_18' onchange='spryMaxLength(this,32)' class='short'/> "+
									"<input type='button' class='edit info' value='复制列' onclick='copy1(this)'/>"+
								"</td>"+
								"<td><input type='text' name='month_1_18' value='' onblur='sum(this,18);average(this,18);total3(1);total4(1);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_2_18' value='' onblur='sum(this,18);average(this,18);total3(2);total4(2);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_3_18' value='' onblur='sum(this,18);average(this,18);total3(3);total4(3);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_4_18' value='' onblur='sum(this,18);average(this,18);total3(4);total4(4);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_5_18' value='' onblur='sum(this,18);average(this,18);total3(5);total4(5);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_6_18' value='' onblur='sum(this,18);average(this,18);total3(6);total4(6);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_7_18' value='' onblur='sum(this,18);average(this,18);total3(7);total4(7);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_8_18' value='' onblur='sum(this,18);average(this,18);total3(8);total4(8);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_9_18' value='' onblur='sum(this,18);average(this,18);total3(9);total4(9);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_10_18' value='' onblur='sum(this,18);average(this,18);total3(10);total4(10);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_11_18' value='' onblur='sum(this,18);average(this,18);total3(11);total4(11);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_12_18' value='' onblur='sum(this,18);average(this,18);total3(12);total4(12);total(19);total(20);total(21);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='total_18' maxlength='11' value='0' readonly/></td>	"+
								"<td><input type='text' name='pre_month_18' maxlength='11' value='0' readonly/></td>	"+
							"</tr>");
    } 
	if(table=="qtjk"){//其他借款
        $("#"+table).append("<tr class='insideTb'>"+
								"<td>"+
									"<input type='text' name='items_name_26' onchange='spryMaxLength(this,32)' class='short'/> "+
									"<input type='button' class='edit info' value='复制列' onclick='copy1(this)'/>"+
								"</td>"+
								"<td><input type='text' name='month_1_26' value='' onblur='sum(this,26);average(this,26);total7(1);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_2_26' value='' onblur='sum(this,26);average(this,26);total7(2);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_3_26' value='' onblur='sum(this,26);average(this,26);total7(3);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_4_26' value='' onblur='sum(this,26);average(this,26);total7(4);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_5_26' value='' onblur='sum(this,26);average(this,26);total7(5);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_6_26' value='' onblur='sum(this,26);average(this,26);total7(6);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_7_26' value='' onblur='sum(this,26);average(this,26);total7(7);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_8_26' value='' onblur='sum(this,26);average(this,26);total7(8);total(29);total(34);total(35)' onchange='checkNUM(this)'/ ></td>"+
								"<td><input type='text' name='month_9_26' value='' onblur='sum(this,26);average(this,26);total7(9);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_10_26' value='' onblur='sum(this,26);average(this,26);total7(10);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_11_26' value='' onblur='sum(this,26);average(this,26);total7(11);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_12_26' value='' onblur='sum(this,26);average(this,26);total7(12);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='total_26' maxlength='11' value='0' readonly/></td>	"+
								"<td><input type='text' name='pre_month_26' maxlength='11' value='0' readonly/></td>	"+
							"</tr>");
    } 
	if(table=="chqtjk"){//偿还其他借款
        $("#"+table).append("<tr class='insideTb'>"+
								"<td>"+
									"<input type='text' name='items_name_28' onchange='spryMaxLength(this,32)' class='short'/> "+
									"<input type='button' class='edit info' value='复制列' onclick='copy1(this)'/>"+
								"</td>"+
								"<td><input type='text' name='month_1_28' value='' onblur='sum(this,28);average(this,28);total7(1);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_2_28' value='' onblur='sum(this,28);average(this,28);total7(2);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_3_28' value='' onblur='sum(this,28);average(this,28);total7(3);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_4_28' value='' onblur='sum(this,28);average(this,28);total7(4);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_5_28' value='' onblur='sum(this,28);average(this,28);total7(5);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_6_28' value='' onblur='sum(this,28);average(this,28);total7(6);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_7_28' value='' onblur='sum(this,28);average(this,28);total7(7);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_8_28' value='' onblur='sum(this,28);average(this,28);total7(8);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_9_28' value='' onblur='sum(this,28);average(this,28);total7(9);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_10_28' value='' onblur='sum(this,28);average(this,28);total7(10);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_11_28' value='' onblur='sum(this,28);average(this,28);total7(11);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_12_28' value='' onblur='sum(this,28);average(this,28);total7(12);total(29);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='total_28' maxlength='11' value='0' readonly/></td>	"+
								"<td><input type='text' name='pre_month_28' maxlength='11' value='0' readonly/></td>	"+
							"</tr>");
    }
    if(table=="qtjkxjly"){//其他借款现金来源
        $("#"+table).append("<tr class='insideTb'>"+
								"<td>"+
									"<input type='text' name='items_name_30' onchange='spryMaxLength(this,32)' class='short'/> "+
									"<input type='button' class='edit info' value='复制列' onclick='copy1(this)'/>"+
								"</td>"+
								"<td><input type='text' name='month_1_30' value='' onblur='sum(this,30);average(this,30);total8(1);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_2_30' value='' onblur='sum(this,30);average(this,30);total8(2);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_3_30' value='' onblur='sum(this,30);average(this,30);total8(3);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_4_30' value='' onblur='sum(this,30);average(this,30);total8(4);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_5_30' value='' onblur='sum(this,30);average(this,30);total8(5);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_6_30' value='' onblur='sum(this,30);average(this,30);total8(6);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_7_30' value='' onblur='sum(this,30);average(this,30);total8(7);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_8_30' value='' onblur='sum(this,30);average(this,30);total8(8);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_9_30' value='' onblur='sum(this,30);average(this,30);total8(9);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_10_30' value='' onblur='sum(this,30);average(this,30);total8(10);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_11_30' value='' onblur='sum(this,30);average(this,30);total8(11);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='month_12_30' value='' onblur='sum(this,30);average(this,30);total8(12);total(33);total(34);total(35)' onchange='checkNUM(this)'/></td>"+
								"<td><input type='text' name='total_30' maxlength='11' value='0' readonly/></td>	"+
								"<td><input type='text' name='pre_month_30' maxlength='11' value='0' readonly/></td>	"+
							"</tr>");
    }
}