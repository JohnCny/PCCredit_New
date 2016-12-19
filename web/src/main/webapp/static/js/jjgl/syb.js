function addTd(table){   
	//----------------------贷前调查——益损表--------------------------	
    if(table=="sr"){//收入
        $("#"+table).append("<tr class='add'>"+
								"<td>"+
									"<input type='text' name='items_name_1' onchange='spryMaxLength(this,32)' class='short'/> "+		
									"<input type='button' class='edit info' value='复制列' onclick='copy1(this)'/>"+	
								"</td>"+
								"<td>"+
									"<input type='text' name='month_1_1' onchange='checkNUM(this)' maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_1_1','month_1_2');totalSum(2);totalAve(2);cut('month_1_2','month_1_4','month_1_5');totalSum(5);totalAve(5);cut4('month_1_2','month_1_4','month_1_23','month_1_24','month_1_25');other(1);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_2_1' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_2_1','month_2_2');totalSum(2);totalAve(2);cut('month_2_2','month_2_4','month_2_5');totalSum(5);totalAve(5);cut4('month_2_2','month_2_4','month_2_23','month_2_24','month_2_25');other(2);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_3_1' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_3_1','month_3_2');totalSum(2);totalAve(2);cut('month_3_2','month_3_4','month_3_5');totalSum(5);totalAve(5);cut4('month_3_2','month_3_4','month_3_23','month_3_24','month_3_25');other(3);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_4_1' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_4_1','month_4_2');totalSum(2);totalAve(2);cut('month_4_2','month_4_4','month_4_5');totalSum(5);totalAve(5);cut4('month_4_2','month_4_4','month_4_23','month_4_24','month_4_25');other(4);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_5_1' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_5_1','month_5_2');totalSum(2);totalAve(2);cut('month_5_2','month_5_4','month_5_5');totalSum(5);totalAve(5);cut4('month_5_2','month_5_4','month_5_23','month_5_24','month_5_25');other(5);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_6_1' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_6_1','month_6_2');totalSum(2);totalAve(2);cut('month_6_2','month_6_4','month_6_5');totalSum(5);totalAve(5);cut4('month_6_2','month_6_4','month_6_23','month_6_24','month_6_25');other(6);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_7_1' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_7_1','month_7_2');totalSum(2);totalAve(2);cut('month_7_2','month_7_4','month_7_5');totalSum(5);totalAve(5);cut4('month_7_2','month_7_4','month_7_23','month_7_24','month_7_25');other(7);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_8_1' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_8_1','month_8_2');totalSum(2);totalAve(2);cut('month_8_2','month_8_4','month_8_5');totalSum(5);totalAve(5);cut4('month_8_2','month_8_4','month_8_23','month_8_24','month_8_25');other(8);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_9_1' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_9_1','month_9_2');totalSum(2);totalAve(2);cut('month_9_2','month_9_4','month_9_5');totalSum(5);totalAve(5);cut4('month_9_2','month_9_4','month_9_23','month_9_24','month_9_25');other(9);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_10_1' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_10_1','month_10_2');totalSum(2);totalAve(2);cut('month_10_2','month_10_4','month_10_5');totalSum(5);totalAve(5);cut4('month_10_2','month_10_4','month_10_23','month_10_24','month_10_25');other(10);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_11_1' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_11_1','month_11_2');totalSum(2);totalAve(2);cut('month_11_2','month_11_4','month_11_5');totalSum(5);totalAve(5);cut4('month_11_2','month_11_4','month_11_23','month_11_24','month_11_25');other(11);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_12_1' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,1);average(this,1);total('month_12_1','month_12_2');totalSum(2);totalAve(2);cut('month_12_2','month_12_4','month_12_5');totalSum(5);totalAve(5);cut4('month_12_2','month_12_4','month_12_23','month_12_24','month_12_25');other(12);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+			
								"<td>"+
									"<input type='text' name='total_1' value='0' maxlength='11' readonly/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='pre_month_1' value='0' maxlength='11' readonly/>"+
								"</td>"+	
							"</tr>");
    }
	if(table=="kbcb"){//可变成本
       $("#"+table).append("<tr class='add'>"+
								"<td>"+
									"<input type='text' name='items_name_3' onchange='spryMaxLength(this,32)' class='short'/> "+		
									"<input type='button' class='edit info' value='复制列' onclick='copy1(this)'/>"+	
								"</td>"+
								"<td>"+
									"<input type='text' name='month_1_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_1_3','month_1_4');totalSum(4);totalAve(4);cut('month_1_2','month_1_4','month_1_5');totalSum(5);totalAve(5);cut4('month_1_2','month_1_4','month_1_23','month_1_24','month_1_25');other(1);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_2_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_2_3','month_2_4');totalSum(4);totalAve(4);cut('month_2_2','month_2_4','month_2_5');totalSum(5);totalAve(5);cut4('month_2_2','month_2_4','month_2_23','month_2_24','month_2_25');other(2);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_3_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_3_3','month_3_4');totalSum(4);totalAve(4);cut('month_3_2','month_3_4','month_3_5');totalSum(5);totalAve(5);cut4('month_3_2','month_3_4','month_3_23','month_3_24','month_3_25');other(3);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_4_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_4_3','month_4_4');totalSum(4);totalAve(4);cut('month_4_2','month_4_4','month_4_5');totalSum(5);totalAve(5);cut4('month_4_2','month_4_4','month_4_23','month_4_24','month_4_25');other(4);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_5_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_5_3','month_5_4');totalSum(4);totalAve(4);cut('month_5_2','month_5_4','month_5_5');totalSum(5);totalAve(5);cut4('month_5_2','month_5_4','month_5_23','month_5_24','month_5_25');other(5);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_6_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_6_3','month_6_4');totalSum(4);totalAve(4);cut('month_6_2','month_6_4','month_6_5');totalSum(5);totalAve(5);cut4('month_6_2','month_6_4','month_6_23','month_6_24','month_6_25');other(6);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_7_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_7_3','month_7_4');totalSum(4);totalAve(4);cut('month_7_2','month_7_4','month_7_5');totalSum(5);totalAve(5);cut4('month_7_2','month_7_4','month_7_23','month_7_24','month_7_25');other(7);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_8_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_8_3','month_8_4');totalSum(4);totalAve(4);cut('month_8_2','month_8_4','month_8_5');totalSum(5);totalAve(5);cut4('month_8_2','month_8_4','month_8_23','month_8_24','month_8_25');other(8);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_9_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_9_3','month_9_4');totalSum(4);totalAve(4);cut('month_9_2','month_9_4','month_9_5');totalSum(5);totalAve(5);cut4('month_9_2','month_9_4','month_9_23','month_9_24','month_9_25');other(9);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_10_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_10_3','month_10_4');totalSum(4);totalAve(4);cut('month_10_2','month_10_4','month_10_5');totalSum(5);totalAve(5);cut4('month_10_2','month_10_4','month_10_23','month_10_24','month_10_25');other(10);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_11_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_11_3','month_11_4');totalSum(4);totalAve(4);cut('month_11_2','month_11_4','month_11_5');totalSum(5);totalAve(5);cut4('month_11_2','month_11_4','month_11_23','month_11_24','month_11_25');other(11);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_12_3' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,3);average(this,3);total('month_12_3','month_12_4');totalSum(4);totalAve(4);cut('month_12_2','month_12_4','month_12_5');totalSum(5);totalAve(5);cut4('month_12_2','month_12_4','month_12_23','month_12_24','month_12_25');other(12);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='total_3' maxlength='11' value='0' readonly/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='pre_month_3' maxlength='11' value='0' readonly/>"+
								"</td>"+	
							"</tr>");
    }
	if(table=="qtfy"){//其他费用
       $("#"+table).append("<tr class='add'>"+
								"<td>"+
									"<input type='text' name='items_name_21' onchange='spryMaxLength(this,32)' class='short'/> "+		
									"<input type='button' class='edit info' value='复制列' onclick='copy1(this)'/>"+	
								"</td>"+
								"<td>"+
									"<input type='text' name='month_1_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_1_');totalSum(23);totalAve(23);cut4('month_1_2','month_1_4','month_1_23','month_1_24','month_1_25');other(1);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_2_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_2_');totalSum(23);totalAve(23);cut4('month_2_2','month_2_4','month_2_23','month_2_24','month_2_25');other(2);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_3_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_3_');totalSum(23);totalAve(23);cut4('month_3_2','month_3_4','month_3_23','month_3_24','month_3_25');other(3);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_4_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_4_');totalSum(23);totalAve(23);cut4('month_4_2','month_4_4','month_4_23','month_4_24','month_4_25');other(4);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_5_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_5_');totalSum(23);totalAve(23);cut4('month_5_2','month_5_4','month_5_23','month_5_24','month_5_25');other(5);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_6_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_6_');totalSum(23);totalAve(23);cut4('month_6_2','month_6_4','month_6_23','month_6_24','month_6_25');other(6);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_7_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_7_');totalSum(23);totalAve(23);cut4('month_7_2','month_7_4','month_7_23','month_7_24','month_7_25');other(7);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_8_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_8_');totalSum(23);totalAve(23);cut4('month_8_2','month_8_4','month_8_23','month_8_24','month_8_25');other(8);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_9_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_9_');totalSum(23);totalAve(23);cut4('month_9_2','month_9_4','month_9_23','month_9_24','month_9_25');other(9);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_10_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_10_');totalSum(23);totalAve(23);cut4('month_10_2','month_10_4','month_10_23','month_10_24','month_10_25');other(10);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_11_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_11_');totalSum(23);totalAve(23);cut4('month_11_2','month_11_4','month_11_23','month_11_24','month_11_25');other(11);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_12_21' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,21);average(this,21);total3('month_12_');totalSum(23);totalAve(23);cut4('month_12_2','month_12_4','month_12_23','month_12_24','month_12_25');other(12);totalSum(25);totalAve(25);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='total_21' value='0' maxlength='11' readonly/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='pre_month_21' value='0' maxlength='11' readonly/>"+
								"</td>"+	
							"</tr>");
    } 
	if(table=="qtzc"){//其他支出
       $("#"+table).append("<tr class='add'>"+
								"<td>"+
									"<input type='text' name='items_name_28' onchange='spryMaxLength(this,32)' class='short'/> "+		
									"<input type='button' class='edit info' value='复制列' onclick='copy1(this)'/>"+	
								"</td>"+
								"<td>"+
									"<input type='text' name='month_1_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(1);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_2_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(2);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_3_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(3);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_4_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(4);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_5_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(5);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_6_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(6);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_7_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(7);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_8_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(8);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_9_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(9);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_10_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(10);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_11_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(11);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_12_28' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,28);average(this,28);other(12);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='total_28' maxlength='11' value='0' readonly/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='pre_month_28' maxlength='11' value='0' readonly/>"+
								"</td>"+	
							"</tr>");
    }
	if(table=="qtsr"){//其他收入
       $("#"+table).append("<tr class='add'>"+
								"<td>"+
									"<input type='text' name='items_name_29' onchange='spryMaxLength(this,32)' class='short'/> "+		
									"<input type='button' class='edit info' value='复制列' onclick='copy1(this)'/>"+	
								"</td>"+
								"<td>"+
									"<input type='text' name='month_1_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(1);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_2_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(2);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_3_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(3);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_4_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(4);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_5_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(5);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_6_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(6);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_7_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(7);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_8_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(8);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_9_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(9);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_10_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(10);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_11_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(11);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='month_12_29' onchange='checkNUM(this)'maxlength='11' onblur=\"sum(this,29);average(this,29);other(12);totalSum(30);totalAve(30);\"/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='total_29' maxlength='11' value='0' readonly/>"+
								"</td>"+
								"<td>"+
									"<input type='text' name='pre_month_29' maxlength='11' value='0' readonly/>"+
								"</td>"+	
							"</tr>");
    }
}